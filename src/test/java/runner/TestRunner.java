package runner;

import Utils.SendReportUtils;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;

@CucumberOptions(
    tags ="@regression",
    features = {"classpath:features"},
    glue = {"classpath:stepDef"},
    plugin = {"pretty",
            "html:target/cucumber-reports/cucumber.html",
            "json:target/cucumber.json"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
    @AfterSuite
    public void sendReportMail(){
        SendReportUtils.main();
    }
}
