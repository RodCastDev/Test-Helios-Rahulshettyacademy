package ruuners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/Login.feature",
                "src/test/resources/features/Purchase.feature"},
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
    public class TestRunner {
}