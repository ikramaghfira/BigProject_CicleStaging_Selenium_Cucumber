package Pages;

import Utils.WebElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static Utils.DriverUtils.driver;

public class TeamsPage extends WebElementUtils {
    public TeamsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='QA-14-BP-C']")
    private WebElement teamsHeader;
    @FindBy(xpath = "//div[@class='TeamPage_rowBox__zylkg'][2]/div[1]")
    private WebElement boardIconBtn;
    @FindBy(xpath = "//div[@class='TeamPage_rowBox__zylkg'][2]/div[2]")
    private WebElement checkInsIconBtn;
    @FindBy(xpath = "//div[@class='TeamPage_rowBox__zylkg'][1]/div[1]")
    private WebElement groupChatIconBtn;
    @FindBy(className = "OverviewOptionButton_icon__23xgd")
    private WebElement overviewBtn;
    @FindBy(xpath = "//p[@class='OverviewOptionPopUp_title__38iOl'][contains(text(),\"Board\")]")
    private WebElement boardBtn2;
    @FindBy(xpath = "//p[@class='OverviewOptionPopUp_title__38iOl'][contains(text(),\"Check In\")]")
    private WebElement checkInBtn2;
    @FindBy(xpath = "//p[@class='OverviewOptionPopUp_title__38iOl'][contains(text(),\"Group Chat\")]")
    private WebElement groupChatBtn2;

    public TeamsPage verifyHeaderTeamsPage(){
        String actualHeader = readText(teamsHeader);
        Assert.assertEquals(actualHeader, "QA-14-BP-C");
        return this;
    }
    public BoardPage goToBoardPageThroughIconButton(){
        driver.switchTo().defaultContent();
        boardIconBtn.click();
        return new BoardPage(driver);
    }
    public CheckInsPage goToCheckInsPageThroughIconButton(){
        clickElement(checkInsIconBtn);
        return new CheckInsPage(driver);
    }
    public GroupChatPage goToGroupChatPageThroughIconButton(){
        clickElement(groupChatIconBtn);
        return new GroupChatPage(driver);
    }
    public BoardPage goToBoardPageThroughOverview(){
        clickElement(overviewBtn);
        clickElement(boardBtn2);
        return new BoardPage(driver);
    }
    public CheckInsPage goToCheckInsPageThroughOverview(){
        clickElement(overviewBtn);
        clickElement(checkInBtn2);
        return new CheckInsPage(driver);
    }
    public GroupChatPage goToGroupChatPageThroughOverview(){
        clickElement(overviewBtn);
        clickElement(groupChatBtn2);
        return new GroupChatPage(driver);
    }
}
