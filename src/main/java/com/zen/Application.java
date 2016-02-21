package com.zen;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author Kevin
 * @see http://eugeneyang.com/2015/12/18/Springmvc4%E9%9B%86%E6%88%90springfox,%20Swagger%20UI,%20springfox-staticdocs/
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.zen")
public class Application extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public Docket actuatorApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("actuator").apiInfo(apiInfo()).select()
        .paths(actuatorPaths()).build();
  }

  @Bean
  public Docket normalApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("api").apiInfo(apiInfo()).select().paths(apiPaths())
        .build();
  }

  private Predicate<String> actuatorPaths() {
    return not(apiPaths());
  }

  @SuppressWarnings("unchecked")
  private Predicate<String> apiPaths() {
    return or(regex("/member/.*"), regex("/hi"), regex("/welcome"), regex("/admin/.*"));
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("spring-boot-demo REST API")
        .description("spring-boot-demo REST API Descriptions.").contact("nickevin@gmail.com").version("0.0.1-SNAPSHOT")
        .license("Apache License Version 2.0")
        .licenseUrl("https://github.com/nickevin/spring-boot-demo/blob/master/LICENSE").build();
  }

}
