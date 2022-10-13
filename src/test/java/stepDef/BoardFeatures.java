package stepDef;

import Pages.BoardPage;
import Pages.TeamsPage;
import io.cucumber.java.en.*;

import static Utils.DriverUtils.driver;

public class BoardFeatures {
    private TeamsPage teamsPage = new TeamsPage(driver);
    private BoardPage boardPage = new BoardPage(driver);

    private final String list1 = "coba list";
    private final String firstListArchived = "test";
    private final String newlist1 = "coba list ke 1";
    private final String card1 = "Fitur A";

    @Given("user is on the TEAMS PAGE")
    public void user_is_on_the_teams_page() {
        teamsPage.verifyHeaderTeamsPage();
    }
    @When("user clicks BOARD ICON")
    public void user_clicks_board_icon() {
        teamsPage.goToBoardPageThroughIconButton();
    }
    @Then("user should be navigated to BOARD PAGE")
    public void user_should_be_navigated_to_board_page() throws Throwable {boardPage.verifyIsOnBoardPage();}
    @When("user clicks BOARD inside OVERVIEW BUTTON")
    public void user_clicks_board_inside_overview_button() {
        teamsPage.goToBoardPageThroughOverview();
    }
    @Given("user is on the BOARD PAGE")
    public void user_is_on_the_board_page() throws Throwable{
        teamsPage
                .goToBoardPageThroughIconButton()
                .verifyIsOnBoardPage();
    }
    @When("user click Add List button to make a List with certain title")
    public void user_click_add_list_button_to_make_a_list_with_certain_title() {
        boardPage.clickAddList().createList(list1);
    }
    @Then("the success alert is appeared: {string}")
    public void theSuccessAlertIsAppeared(String alert) throws Throwable{
        boardPage.verifySuccessAlert(alert);
    }
    @And("the list is successfully created")
    public void theListIsSuccessfullyCreated() throws Throwable {
        boardPage.verifyListIsCreated(list1);
    }
    @When("user click Add List Button")
    public void user_click_add_list_button() {boardPage.clickAddList();}
    @But("user click cancel button")
    public void user_click_cancel_button() {boardPage.clickCancelListBtn();}
    @Then("the list should not be created")
    public void the_list_should_not_be_created() throws Throwable {boardPage.verifyIsOnBoardPage();}
    @When("user click navigation button to select Archive This List menu")
    public void user_click_navigation_button_to_select_archive_this_list_menu() {
        boardPage.clickNavMenu("Archive List");
    }
    @Then("the list should be moved to Archived Items")
    public void the_list_should_be_moved_to_archived_items() throws Throwable{
        boardPage.clickArchivedItem("Switch to List").verifyListIsMovedToArchive(list1);
    }
    @When("user click Archived Items to restore a list")
    public void userClickArchivedItemsToRestoreAList() throws Throwable{
        boardPage.clickArchivedItem("Switch to List").clickRestoreButton(boardPage.getFirstListArchived());
    }
    @And("the restored list should be on Board Page")
    public void theRestoredListShouldBeOnBoardPage() throws Throwable{
        boardPage.verifyListIsCreated(boardPage.getListOnBoard()).clickNavMenu("Archive List");
        Thread.sleep(1000);
    }
    @When("user click navigation button to select Set as a Complete List menu")
    public void userClickNavigationButtonToSelectSetAsACompleteListMenu() throws Throwable{
        boardPage.clickArchivedItem("Switch to List").searchItemToBeRestored(firstListArchived)
                .clickRestoreButton("test");
        Thread.sleep(7000);
        boardPage.clickNavMenu("Set as Complete List");
    }
    @And("the list should be displayed DONE icon that contains:{string}")
    public void theListShouldBeDisplayedDONEIconThatContains(String alert) throws Throwable {
        boardPage.verifyDoneIconIsVisible(alert).clickNavMenu("Archive List");
        Thread.sleep(1000);
    }
    @When("user click navigation button to select Unset Complete List menu")
    public void userClickNavigationButtonToSelectUnsetCompleteListMenu() throws Throwable {
        boardPage.clickArchivedItem("Switch to List").searchItemToBeRestored(firstListArchived)
                .clickRestoreButton("test");
        Thread.sleep(7000);
        boardPage.clickNavMenu("Set as Complete List");
    }
    @And("the DONE icon should be disappeared")
    public void theDONEIconShouldBeDisappeared() throws Throwable {
        boardPage.clickNavMenu("Archive List");
        Thread.sleep(1000);
    }
    @And("user changed icon into BLOCKED icon")
    public void userChangedIconIntoBLOCKEDIcon() throws Throwable{
        boardPage.clickBlockedIcon();
        Thread.sleep(1000);
    }
    @Then("the list should be displayed BLOCKED icon that contains: {string}")
    public void theListShouldBeDisplayedBLOCKEDIconThatContains(String alert) throws Throwable {
        boardPage.verifyBlockedIconIsVisible(alert).clickNavMenu("Archive List");
        Thread.sleep(1000);
    }
    @When("user click Add Card button to create card with certain title")
    public void userClickAddCardButtonToCreateCardWithCertainTitle() throws Throwable {
        boardPage.clickArchivedItem("Switch to List").searchItemToBeRestored(boardPage.getFirstListArchived())
                .clickRestoreButton("");
        Thread.sleep(7000);
        boardPage.createCard(card1, "not private");
    }
    @Then("the card should be created inside the list")
    public void theCardShouldBeCreatedInsideTheList() throws Throwable{
        boardPage.verifyCardIsCreated(card1).clickNavMenu("Archive List");
        Thread.sleep(1000);;
    }
    @When("user click Add Card button to create private card")
    public void userClickAddCardButtonToCreatePrivateCard() throws Throwable{
        boardPage.clickArchivedItem("Switch to List").searchItemToBeRestored(boardPage.getFirstListArchived())
                .clickRestoreButton("").closeArchivedItemsMenu();
        Thread.sleep(7000);
        boardPage.createCard(card1,"private");
    }
    @And("the card should be created in private mode")
    public void theCardShouldBeCreatedInPrivateMode() throws Throwable{
        boardPage.verifyCardIsCreated(card1).verifyCardIsPrivate(card1);
        Thread.sleep(1000);
        boardPage.clickNavMenu("Archive List");
        Thread.sleep(1000);
    }
    @When("user click List title to update its title")
    public void userClickListTitleToUpdateItsTitle() throws Throwable {
        boardPage.clickArchivedItem("Switch to List").searchItemToBeRestored(list1)
                .clickRestoreButton("").closeArchivedItemsMenu();
        Thread.sleep(7000);
        boardPage.updateListTitle(newlist1);
    }
    @And("the List title should be updated")
    public void theListTitleShouldBeUpdated() throws Throwable{
        boardPage.verifyListIsCreated(newlist1).updateListTitle(list1).clickNavMenu("Archive List");
        Thread.sleep(1000);
    }
    @When("user search a list to be restored")
    public void userSearchAListToBeRestored() throws Throwable {
        boardPage.clickArchivedItem("Switch to List").clickRestoreButton("test");
    }
    @When("user create a card without title")
    public void userCreateACardWithoutTitle() throws Throwable{
        boardPage.clickArchivedItem("Switch to List").searchItemToBeRestored(boardPage.getFirstListArchived())
                .clickRestoreButton("").closeArchivedItemsMenu();
        Thread.sleep(7000);
        boardPage.createCard("","not private");
    }
    @And("the card should not be created")
    public void theCardShouldNotBeCreated() throws Throwable{
        boardPage.verifyCardIsNotCreated().clickNavMenu("Archive List");
        Thread.sleep(1000);
    }
    @When("user archives all cards through Archive All Cards in This List")
    public void userArchivesAllCardsThroughArchiveAllCardsInThisList() throws Throwable{
        boardPage.clickArchivedItem("Switch to List").searchItemToBeRestored(firstListArchived)
                .clickRestoreButton("test").closeArchivedItemsMenu();
        Thread.sleep(7000);
        boardPage.clickNavMenu("Archive All Cards");
    }
    @And("all cards on the list should be archived")
    public void allCardsOnTheListShouldBeArchived() throws Throwable{
        boardPage.clickNavMenu("Archive List");
        Thread.sleep(1000);
    }
    @When("^user sort all cards through list navigation (.*)$")
    public void userSortAllCardsThroughListNavigationMenu(String menu) throws Throwable{
        boardPage.clickArchivedItem("Switch to List").searchItemToBeRestored(firstListArchived)
                .clickRestoreButton("test").closeArchivedItemsMenu();
        Thread.sleep(7000);
        boardPage.clickNavMenu(menu);
    }
    @Then("^the (.*) should be sorted according to (.*)$")
    public void theCardShouldBeSortedAccordingToMenu(String title, String menu) throws Throwable{
        boardPage.verifyTheCardIsSorted(title).clickNavMenu(menu)
                .clickNavMenu("Archive List");
        Thread.sleep(1000);
    }
    @Given("user is on CARD DETAIL CONTAINER")
    public void userIsOnCARDDETAILCONTAINER() throws Throwable{
        teamsPage
                .goToBoardPageThroughIconButton()
                .verifyIsOnBoardPage();
        boardPage.clickArchivedItem("Switch to List").searchItemToBeRestored(firstListArchived)
                .clickRestoreButton("test").closeArchivedItemsMenu();
        Thread.sleep(2000);
        boardPage.clickCard();
        Thread.sleep(5000);
    }
    @When("^user update the card (.*)$")
    public void userUpdateTheCardTitle(String title) {
        boardPage.updateCardTitle(title);
    }
    @And("^the card title is updated into (.*)$")
    public void theCardTitleIsUpdatedIntoTitle(String title) throws Throwable{
        boardPage.verifyCardTitleIsUpdated(title).clickNavMenu("Archive List");
        Thread.sleep(1000);
    }
    @When("user attach a file on the card Attachments section")
    public void userAttachAFileOnTheCardAttachmentsSection() {
        boardPage.uploadFile("document");
    }
    @And("the file is attached")
    public void theFileIsAttached() throws Throwable{
        boardPage.verifyFileUploaded("document").clickNavMenu("Archive List");
        Thread.sleep(1000);
    }
    @When("^user (.*) the attachment file (.*)$")
    public void userFunctionTheAttachmentFile(String function, String text) throws Throwable{
        boardPage.clickAttachmentButton(function,text);
    }
    @Then("^the success alert function is appeared: (.*)$")
    public void theSuccessAlertFunctionIsAppearedAlert(String alert) throws Throwable{
        boardPage.verifySuccessAlert(alert).closeContainer().clickNavMenu("Archive List");
        Thread.sleep(1000);
    }
    @When("^user (.*) (.*) comment on the card$")
    public void userFunctionTextCommentOnTheCard(String function, String text) throws Throwable{
        boardPage.clickCommentField(function,text);
    }
    @When("^user proceed to (.*) label on the card: (.*)$")
    public void userProceedToFunctionLabelOnTheCardText(String function, String text) throws Throwable{
        boardPage.clickLabelButton(function,text);
    }
    @When("^user proceed to (.*) due date on the card: (.*), (.*)$")
    public void userProceedToFunctionDueDateOnTheCardDateTime(String function, String date, String time) throws Throwable{
        boardPage.clickDueDateButton(function, date, time);
    }
    @When("^user proceed to (.*) the card$")
    public void userProceedToFunctionTheCard(String text) throws Throwable{
        boardPage.clickPrivateButton(text);
    }
    @And("the restored list should be on Board Page: {string}")
    public void theRestoredListShouldBeOnBoardPage(String text) throws Throwable{
        boardPage.verifyListIsCreated(text).clickNavMenu("Archive List");
        Thread.sleep(1000);
    }
}
