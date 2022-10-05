package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    tags ="@boardpage",
    features = {"classpath:features"},
    glue = {"classpath:stepDef"},
    plugin = {"pretty",
            "html:target/cucumber-reports/cucumber.html",
            "json:target/cucumber.json"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
