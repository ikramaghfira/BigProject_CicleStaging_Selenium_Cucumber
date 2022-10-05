package Pages;

import Utils.WebElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static Utils.DriverUtils.driver;

public class Homepage extends WebElementUtils {

    public Homepage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='NavHeader_companyNameSection__12MiY']/p")
    private WebElement homepageHeader;
    @FindBy(xpath = "(//div[@class='MuiBox-root css-1l6cvlp'])[1]")
    private WebElement sekolahQABtn;
    @FindBy(className = "Card_Card__2LWWW")
    private WebElement teamsCard;


    public Homepage goToSekolahQAHomepage() {
        clickElement(sekolahQABtn);
        return this;
    }
    public Homepage verifyHeaderHomepage(){
        String actualHeader = readText(homepageHeader);
        Assert.assertEquals(actualHeader, "Sekolah QA");
        return this;
    }
    public TeamsPage goToTeamsPage(){
        clickElement(teamsCard);
        return new TeamsPage(driver);
    }
}
