package Pages;

import Utils.WebElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.security.auth.x500.X500Principal;

public class Notification extends WebElementUtils {
    public Notification(WebDriver driver) {
        super(driver);
    }

    /**
     * BUTTON ELEMENTS
     */
    @FindBy(xpath = "(//div[@class='NavIcon_icon__1nI8A']//*[name()='svg'])[2]")
    private WebElement notifBtn;
    @FindBy(xpath = "//div[@class='CheersButton_container__3sCQs']")
    private WebElement cheersBtn;
    @FindBy(xpath = "//button[@class='Main_container__3r1Cm']")
    private WebElement viewAllNotifBtn;
    @FindBy(css = ".CategoryTabNotif_tab__3dbuT.CategoryTabNotif_unselected__1Ixlu")
    private WebElement qaNotifBtn;
    @FindBy(xpath = "(//p[normalize-space()='Group Chat : QA-14-BP-C'])[1]")
    private WebElement groupChatNotif;
    @FindBy(xpath = "(//*[normalize-space()='Fira - QA-14-BP-C'])[1]")
    private WebElement boardNotif;

    //NON INTERACTIVE ELEMENT
    @FindBy (xpath = "//div[@class='modal-title h4']")
    private WebElement boardCard;
    @FindBy(xpath = "//div[@class='BreadcrumbContainer_separateRoute__26-Ut']/span")
    private WebElement cheersBreadcrumb;
    @FindBy(xpath = "//div[@class='OverviewOptionButton_container__M-oKs']//p")
    private WebElement groupChatOverview;



    /**
     * ASSERTION FUNCTIONS
     */
    public void verifyOnCheersSummaryPage(){
        Assert.assertTrue(cheersBreadcrumb.isDisplayed());
    }
    public void verifyOnNotificationPage(){
        Assert.assertTrue(qaNotifBtn.isDisplayed());
    }
    public void verifyOnGroupChatPage(){
        Assert.assertTrue(groupChatOverview.isDisplayed());
    }
    public void verifyOnBoardPage(){
        Assert.assertTrue(boardCard.isDisplayed());
    }

    /**
     * INTERACTION FUNCTIONS
     */
    public Notification goToCheersSummaryPage(){
        clickElement(notifBtn);
        waitToBeClickable(cheersBtn);
        clickElement(cheersBtn);
        return this;
    }
    public Notification goToNotificationPage(){
        clickElement(notifBtn);
        waitToBeClickable(viewAllNotifBtn);
        clickElement(viewAllNotifBtn);
        return this;
    }
    public Notification goToGroupChatNotif() throws InterruptedException {
        Thread.sleep(3000);
        scrollToElement(groupChatNotif);
        Thread.sleep(2000);
        clickElement(groupChatNotif);
        Thread.sleep(4000);
        return this;
    }
    public Notification goToBoardNotif() throws InterruptedException {
        Thread.sleep(2000);
        boardNotif.click();
        Thread.sleep(4000);
        return this;
    }
}
