package stepDef;

import Pages.Homepage;
import Pages.Notification;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Utils.DriverUtils.driver;

public class NotificationFeature {

    Notification notif = new Notification(driver);
    Homepage homepage = new Homepage(driver);
    @When("user go to Cheers Summary page")
    public void userGoToCheersSummaryPage() {
        notif.goToCheersSummaryPage();
    }

    @Then("user should be navigated to Cheers Summary page")
    public void userShouldBeNavigatedToCheersSummaryPage() {
        notif.verifyOnCheersSummaryPage();
    }

    @When("user go to Notification page")
    public void userGoToNotificationPage() throws Throwable {
        notif.goToNotificationPage();
    }

    @Then("user should see all notifications")
    public void userShouldSeeAllNotifications() {
        notif.verifyOnNotificationPage();
    }

    @Given("user is on the Notification Page")
    public void userIsOnTheNotificationPage() throws Throwable{
        homepage.goToSekolahQAHomepage().verifyHeaderHomepage();
        notif.goToNotificationPage();
        notif.verifyOnNotificationPage();
    }

    @When("user search group chat related notification")
    public void userSearchGroupChatRelatedNotification() throws Throwable{
        notif.goToGroupChatNotif();
    }

    @Then("user should be navigated to group chat page")
    public void userShouldBeNavigatedToGroupChatPage() {
        notif.verifyOnGroupChatPage();
    }

    @When("user search board related notification")
    public void userSearchBoardRelatedNotification() throws Throwable{
        notif.goToBoardNotif();
    }

    @Then("user should be navigated to card on board page")
    public void userShouldBeNavigatedToCardOnBoardPage() {
        notif.verifyOnBoardPage();
    }
}
