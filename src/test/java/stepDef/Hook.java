package stepDef;

import Pages.Homepage;
import Pages.TeamsPage;
import Utils.CommonUtils;
import Utils.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;


public class Hook {
    private WebDriver driver = DriverUtils.getDriver();

    private Homepage homepage = new Homepage(driver);
    private TeamsPage teamsPage;

    @Before
    public void setUp(){
        CommonUtils.getToken(driver);
    }

    /**
     * BACKGROUND STEP DEFINITION
     */
    @BeforeClass
    @Given("user is on the home page")
    public void user_is_on_the_home_page(){
        homepage.goToSekolahQAHomepage().verifyHeaderHomepage();
    }
    @When("user clicks TEAMS CARD")
    public void user_clicks_teams_card(){
        homepage.goToTeamsPage();
    }
    @Then("user should be navigated to TEAMS PAGE")
    public void user_should_be_navigated_to_teams_page(){
        teamsPage = new TeamsPage(driver);
        teamsPage.verifyHeaderTeamsPage();
    }

    @After
    public void closeBrowser(){
        DriverUtils.tearDown();
    }

}
