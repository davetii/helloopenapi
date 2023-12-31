# Hello Open API SpringBoot 

Examples of using OpenApi in Springboot

## Description
Collection of samples creating SpringBoot services from openapi generator

### Exterbnal Dependencies
* jdk17
* Docker installed on system
* docker-compose available on command line

### Whats in the POM
(Examples of usage)
* Springboot 3 mvc version (see react feature branches for reactvie version)
* openapi
* Cucumber
* Wiremock

### Installing
* mvn install

### Executing program
* mvn spring-boot:run

### History
* feature/feature/rollback-to-mvc
  * Back to mvc based, improved config for docker  
* feature/reactive
  * Converted api to spring-boot-reactive
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
