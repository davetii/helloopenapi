package software.daveturner.helloopenapi.stepdef;

import com.github.tomakehurst.wiremock.*;
import com.github.tomakehurst.wiremock.client.*;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.mock.web.server.*;
import org.springframework.test.context.junit4.*;
import org.springframework.web.server.*;
import reactor.core.publisher.*;
import software.daveturner.helloopenapi.delegate.*;
import software.daveturner.helloopenapi.model.*;

@SpringBootTest
public class StepDefsIntegrationTest {




    private static final WireMockServer server= new WireMockServer(4010);
    private final V1ApiDelegateImpl d = new V1ApiDelegateImpl();
    private String greetingValue = null;
    private int allPeopleSize = 0;

    private int status;
    @When("user {string} says hello")
    public void userCallsSayHello(String newName) {
        greetingValue = d.sayHello(newName, null).block().getBody();
    }

    @Then("api returns {string}")
    public void ensureSayHelloReturnsExpected(String result) {
        Assertions.assertEquals(greetingValue, result);
    }

    @When("getAllPersons is called")
    public void callGetAllPlayers() {
        allPeopleSize = d.getAllPersons(null).block().getBody().collectList().block().size();
    }

    @Then("size returned is 4")
    public void ensureGetAllPersonReturnsExpected() {
        Assertions.assertEquals(allPeopleSize, 4);
    }

    @When("newPerson is called with {string} and {string}")
    public void callNewPlayer(String name, String role) {

        Person p = new Person();
        p.setRole(role);
        p.setName(name);
        status = d.createPerson(Mono.just(p), null).block().getStatusCode().value();
    }

    @Then("api returns status {string}")
    public void ensureGetNewPersonReturnsExpected(String expected) {
        Assertions.assertEquals(status, Integer.parseInt(expected));
    }

}
