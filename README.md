#### Generate
* https://start.spring.io/

#### Development
* Java
	* mvn eclipse:eclipse
	* import to eclipse
* Front-end
	* install bower: bower install or bower install bootstrap-fileinput --save
	* install grunt: npm install grunt --save-dev
	* install grunt plugins: npm install plugin-name --save-dev
	* run grunt: grunt
	* bower cache clean

#### Run 
* mvn spring-boot:run
* once you excute mvn spring-boot:run command, then just choose Run As > Java Application to launch your main class(com.zen.Application)
* if you update the POM.xml, make sure to run mvn eclipse:eclipse.

#### Deploy to Tomcat
* mvn install
* put war into webapps directory

#### Generate REST API
* mvn install 
* cd target/generated-docs/index.html
* [Swagger UI](http://localhost:8080/swagger-ui.html)

#### Reference
* http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
* https://spring.io/guides/gs/spring-boot/
* https://spring.io/guides/gs/rest-service/
* https://spring.io/understanding/REST
* http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-tool-plugins-maven-packaging
* http://caseyscarborough.com/blog/2014/12/18/caching-data-in-spring-using-redis/
* http://blog.joshuawhite.com/java/caching-with-spring-data-redis/
* http://docs.spring.io/spring-data/jpa/docs/current/reference/html

#### Tools
* [Postman](http://www.getpostman.com/) helps you develop APIs faster.

#### Have fun
:sunny: :smile: :sunny: :smile: :sunny: :smile: :sunny: