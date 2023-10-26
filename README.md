# Hello Open API SpringBoot 

Examples of using OpenApi in Springboot

## Description
Collection of samples creating SpringBoot services from openapi generator

### Dependencies
* jdk17
* Springboot 3 web mvc (via pom)
* openapi (via pom)
* Cucumber (via pom)
* Wiremock (via pom)
* Docker installed on system
* docker-compose available on command line

### Installing
* mvn install

### Executing program
* mvn spring-boot:run

### Todo
* Convert project from mvc to reactive
* implement persistence layer

### History
* feature/adding-docker
  * Adding docker-compose support
 * feature/adding-wiremock-to-test
   * Adding Wiremock to tests
* feature/integrationTests_MVC
  * Adding Cucumber API testing
* feature/MvcClient_Example
  * Added Client Example, using docker based mock server
  * Not a great example of using a client, used the client api to validate appropriate roles on the update requests
* feature/SpringBootMVC_SimpleModel_Example
  * Added Example of CRUD methods for Simple Models
* feature/HelloWorld_SringBootMvc
  * Basic openapi generated api
    * http://localhost:8080/api/v1/hello?name=bob
    * response = Hello bob
  * Demonstrates implemented delegate class and swagger-ui.htmk
