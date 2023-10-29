package software.daveturner.helloopenapi;

import com.github.tomakehurst.wiremock.*;
import com.github.tomakehurst.wiremock.client.*;
import io.cucumber.java.*;
import io.cucumber.junit.*;
import org.junit.runner.*;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty"},
        glue = {"software.daveturner.helloopenapi.stepdef"})
public class CucumberTest {

    private static final WireMockServer server= new WireMockServer(4010);

    @BeforeAll
    public static void setup() {
        ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
        mockResponse.withStatus(200);
        mockResponse.withBodyFile("roles.json");
        mockResponse.withHeader("Content-Type", "application/JSON");

        server.start();
        server.stubFor(WireMock.get("/roles").willReturn(mockResponse));
    }

    @AfterAll
    public static void cleanup() {
        server.stop();
    }
}