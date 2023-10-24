package software.daveturner.helloopenapi;

import io.cucumber.java.en.*;
import io.cucumber.junit.*;
import io.cucumber.spring.*;
import org.junit.runner.*;
import org.springframework.boot.test.context.*;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty"},
        glue = {"software.daveturner.helloopenapi.cucumberglue"})
public class CucumberTest { }
