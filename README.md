# Hello Open API SpringBoot 

Examples of using OpenApi in Springboot

## Description
Collection of samples creating SpringBoot services from openapi generator

### Exterbnal Dependencies
* jdk17
* Docker installed on system
* docker-compose available on command line

### Whats in the POM (Samples)
* Springboot 3 web mvc
* openapi
* Cucumber
* Wiremock

### Installing
* mvn install

### Executing program
* mvn spring-boot:run

### Todo
* Convert project from mvc to reactive
* implement persistence layer

### History
* feature/adding-docker
  * Adding docker-compose support in maven pom
 * feature/adding-wiremock-to-test
   * Exchanging class mock for wiremock
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
