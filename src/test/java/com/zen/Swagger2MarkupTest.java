package com.zen;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import io.github.robwin.markup.builder.MarkupLanguage;
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;

/**
 * Class description goes here.
 * 
 * @author aopfilter@163.com
 * @since Feb 21, 2016
 * @version 1.0
 * @see
 */
@WebAppConfiguration
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Swagger2MarkupTest {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void groupAPI() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs?group=api").accept(MediaType.APPLICATION_JSON))
        .andDo(Swagger2MarkupResultHandler.outputDirectory("src/main/asciidoc/api").build())
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void actuatorAPI() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs?group=actuator").accept(MediaType.APPLICATION_JSON))
        .andDo(Swagger2MarkupResultHandler.outputDirectory("src/main/asciidoc/actuator").build())
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  // @Test
  // public void order() throws Exception {
  // MvcResult result = mockMvc
  // .perform(MockMvcRequestBuilders.get("/v2/api-docs?group=api").accept(MediaType.APPLICATION_JSON)).andReturn();
  // Swagger2MarkupConverter.fromString(result.getResponse().getContentAsString())
  // .withDefinitionsOrderedBy(OrderBy.NATURAL).build().intoFolder("src/main/asciidoc/api");
  // }

  // @Test
  public void convertSwaggerToMarkdown() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
        .andDo(Swagger2MarkupResultHandler.outputDirectory("src/main/markdown/generated")
            .withMarkupLanguage(MarkupLanguage.MARKDOWN).build())
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
