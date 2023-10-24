package software.daveturner.helloopenapi.cucumberglue;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.*;
import software.daveturner.helloopenapi.delegate.*;
import software.daveturner.helloopenapi.model.*;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest

public class StepDefsIntegrationTest {


   V1ApiDelegateImpl d = new MockV1ApiDelegateImpl();
    private String greetingValue = null;
    private int allPeopleSize = 0;

    private int status;
    @When("user {string} says hello")
    public void userCallsSayHello(String newName) {
        greetingValue = d.sayHello(newName).getBody();
    }

    @Then("api returns {string}")
    public void ensureSayHelloReturnsExpected(String result) {
        Assertions.assertEquals(greetingValue, result);
    }

    @When("getAllPersons is called")
    public void callGetAllPlayers() {
        allPeopleSize = d.getAllPersons().getBody().size();
    }

    @Then("size returned is 4")
    public void ensureGetAllPersonReturnsExpected() {
        Assertions.assertEquals(allPeopleSize, 4);
    }

    @When("newPerson is called with {string} and {string}")
    public void callNewPlayer(String name, String role) throws Exception {
        Person p = new Person();
        p.setRole(role);
        p.setName(name);
        status = d.createPerson(p).getStatusCode().value();
        System.out.println("status: " + status );
    }

    @Then("api returns status {string}")
    public void ensureGetNewPersonReturnsExpected(String expected) {
        Assertions.assertEquals(status, Integer.parseInt(expected));
    }

    class MockV1ApiDelegateImpl extends V1ApiDelegateImpl {


        public List<String> readRoles() {
            String [] s = {"sibling", "spouse", "parent", "child", "friend"};
            return Arrays.asList(s);
        }

    }


}
