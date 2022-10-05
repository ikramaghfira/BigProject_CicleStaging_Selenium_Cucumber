package stepDef;

import Pages.CheckInsPage;
import Pages.TeamsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Utils.DriverUtils.driver;

public class CheckInsFeature {
    TeamsPage teamsPage = new TeamsPage(driver);
    CheckInsPage checkInsPage = new CheckInsPage(driver);

    /**
     * TEST DATA
     */
    private String alphabeticTitle = "Ini coba pertanyaan";
    private String nonAlphabetTitle = "1234567890!@#$%^&*()-=_+,./;'[]<>?:{}|";
    private String emojiTitle = "\u270b" + " " + "\u2618";
    private String urlTitle = "https://staging.cicle.app/companies";
    private String selectedDays = "Sun Mon Tue Wed Thu Fri Sat";
    private String hour = "10";
    private String timeFormat = "PM";
    private String clockBtn = "next";
    private String timeManual = "10:11 PM";
    private String timeManual2 = "07:02 AM";
    private String memberName = "widiya";
    private String memberName1 = "risya";
    private String memberName2 = "fira";
    private String memberName3 = "feny";
    private String unlistedMember = "jira";

    /**
     * STEP DEFINITION FUNCTIONS
     */
    @When("user go to Check Ins Page through Box Menu")
    public void userGoToCheckInsPageThroughBoxMenu() {
        teamsPage
                .goToCheckInsPageThroughIconButton();
    }
    @Then("user should see Create CheckIn button")
    public void userShouldSeeCreateCheckInButton() {
        checkInsPage
                .verifyOnCheckInsPage();
    }
    @When("user go to Check Ins Page through Overview Menu")
    public void userGoToCheckInsPageThroughOverviewMenu() {
        teamsPage
                .goToCheckInsPageThroughOverview();
    }
    @Given("user is on the CHECK INS PAGE")
    public void userIsOnTheCHECKINSPAGE() {
        teamsPage
                .goToCheckInsPageThroughIconButton().verifyOnCheckInsPage();
    }
    @When("user go to New Question Page through Create CheckIn button")
    public void userGoToNewQuestionPageThroughCreateCheckInButton() {
        checkInsPage
                .clickCreateCheckInButton();
    }
    @Then("user should see Start collecting answers button")
    public void userShouldSeeStartCollectingAnswersButton() {
        checkInsPage
                .verifyOnNewQuestionPage();
    }
    @Given("user is on the NEW QUESTION PAGE")
    public void userIsOnTheNEWQUESTIONPAGE() {
        teamsPage
                .goToCheckInsPageThroughIconButton().verifyOnCheckInsPage()
                .clickCreateCheckInButton().verifyOnNewQuestionPage();
    }
    @When("user fill the Question title with alphabetic while left other fields as default")
    public void userFillTheQuestionTitleWithAlphabeticWhileLeftOtherFieldsAsDefault() {
        checkInsPage
                .setQuestionTitle(alphabeticTitle);
    }
    @And("user create question through Start collecting answers button")
    public void userCreateQuestionThroughStartCollectingAnswersButton() {
        checkInsPage
                .clickStartCollectingAnswers();
    }
    @Then("user should see success alert: {string}")
    public void userShouldSeeSuccessAlert(String alert) {
        checkInsPage
                .verifySuccessAlert(alert);
    }
    @When("user choose desired question to be archived")
    public void userChooseDesiredQuestionToBeArchived() {
        checkInsPage
                .selectQuestionToBeArchived(alphabeticTitle).verifyQuestionIsArchived();
    }
    @And("user should see Question is created with suitable title")
    public void userShouldSeeQuestionIsCreatedWithSuitableTitle() {
        checkInsPage
                .verifyCreatedQuestionTitle(alphabeticTitle);
    }
    @When("user decide to cancel a question")
    public void userDecideToCancelAQuestion() {
        checkInsPage
                .clickCancelQuestionButton();
    }
    @Then("user should go back to Check Ins Page")
    public void userShouldGoBackToCheckInsPage() {
        checkInsPage
                .verifyOnCheckInsPage();
    }
    @When("user fill the Question title with non-alphabetic")
    public void userFillTheQuestionTitleWithNonAlphabetic() {
        checkInsPage
                .setQuestionTitle(nonAlphabetTitle);
    }
    @And("the non-alphabetic question is created")
    public void theNonAlphabeticQuestionIsCreated() throws Throwable {
        Thread.sleep(7000);
        checkInsPage.verifyCreatedQuestionTitle(nonAlphabetTitle)
                .selectQuestionToBeArchived(nonAlphabetTitle)
                .verifyQuestionIsArchived();
    }
    @Then("user should stay remain on New Question Page")
    public void userShouldStayRemainOnNewQuestionPage() {
        checkInsPage
                .verifyOnNewQuestionPage();
    }
    @When("user fill the Question title with emoji")
    public void userFillTheQuestionTitleWithEmoji() {
        checkInsPage
                .setQuestionTitle(emojiTitle);
    }
    @And("the emoji question is created")
    public void theEmojiQuestionIsCreated() throws Throwable {
        Thread.sleep(7000);
        checkInsPage
                .verifyCreatedQuestionTitle(emojiTitle).selectQuestionToBeArchived(emojiTitle)
                .verifyQuestionIsArchived();
    }
    @When("user fill the Question title with URL")
    public void userFillTheQuestionTitleWithURL() {
        checkInsPage
                .setQuestionTitle(urlTitle);
    }
    @And("the URL question is created but inaccessible")
    public void theURLQuestionIsCreatedButInaccessible() throws Throwable{
        Thread.sleep(7000);
        checkInsPage
                .verifyCreatedQuestionTitle(urlTitle).selectQuestionToBeArchived(urlTitle)
                .verifyQuestionIsArchived();
    }
    @When("user set all days as reminders")
    public void userSetAllDaysAsReminders() {
        checkInsPage
                .setQuestionTitle(alphabeticTitle)
                .selectDayOfReminders("sun").selectDayOfReminders("tue").selectDayOfReminders("wed")
                .selectDayOfReminders("thu").selectDayOfReminders("fri").selectDayOfReminders("sat");
    }
    @And("the everyday reminder question is created")
    public void theEverydayReminderQuestionIsCreated() throws Throwable{
        Thread.sleep(7000);
        checkInsPage
                .verifyCreatedQuestionContainInfo(selectedDays)
                .selectQuestionToBeArchived(alphabeticTitle)
                .verifyQuestionIsArchived();
    }
    @When("user set the hour part of the timer")
    public void userSetTheHourPartOfTheTimer() {
        checkInsPage
                .clickClockIcon().setHour(hour);
    }
    @Then("the Time field should be shown the hour accordingly")
    public void theTimeFieldShouldBeShownTheHourAccordingly() throws Throwable{
        Thread.sleep(2000);
        checkInsPage
                .verifyTimeSet(hour);
    }
    @When("user choose time format of the timer")
    public void userChooseTimeFormatOfTheTimer() {
        checkInsPage
                .clickClockIcon().setTimeFormat(timeFormat);
    }
    @Then("the Time field should be shown time format accordingly")
    public void theTimeFieldShouldBeShownTimeFormatAccordingly() {
        checkInsPage
                .verifyTimeSet(timeFormat);
    }
    @When("user navigate back and forth to hour or minute part")
    public void userNavigateBackAndForthToHourOrMinutePart() {
        checkInsPage
                .clickClockIcon().clickPrevOrNextBtn(clockBtn);
    }
    @Then("user should be shown hour or minute accordingly")
    public void userShouldBeShownHourOrMinuteAccordingly() {
        checkInsPage
                .verifyPrevOrNextBtn(clockBtn);
    }
    @When("user set timer by typing on Timer field")
    public void userSetTimerByTypingOnTimerField() {
        checkInsPage
                .setTimeManually(timeManual);
    }
    @Then("user should be shown correct time")
    public void userShouldBeShownCorrectTime() {
        checkInsPage
                .verifyTimeSet(timeManual);
    }
    @When("user set title also time manually")
    public void userSetTitleAlsoTimeManually() {
        checkInsPage
                .setQuestionTitle(alphabeticTitle).setTimeManually(timeManual);
    }
    @And("the timer question is created")
    public void theTimerQuestionIsCreated() throws Throwable {
        Thread.sleep(7000);
        checkInsPage
                .verifyCreatedQuestionContainInfo(timeManual).selectQuestionToBeArchived(alphabeticTitle)
                .verifyQuestionIsArchived();
    }
    @When("user select a member name by Search field")
    public void userSelectAMemberNameBySearchField() {
        checkInsPage
                .clickAddMember().searchMember(memberName)
                .selectMember(memberName).clickDoneAddMember();
    }
    @Then("the member icon should be shown on Member section")
    public void theMemberIconShouldBeShownOnMemberSection() {
        checkInsPage
                .verifySelectedMember(memberName);
    }
    @When("user select members name")
    public void userSelectMembersName() {
        checkInsPage
                .clickAddMember().selectMember(memberName).selectMember(memberName1)
                .selectMember(memberName2).clickDoneAddMember();
    }
    @Then("selected member's icon should be shown on Member section")
    public void selectedMemberSIconShouldBeShownOnMemberSection() {
        checkInsPage
                .verifySelectedMember(memberName).verifySelectedMember(memberName1)
                .verifySelectedMember(memberName2);
    }
    @When("user search unlisted member by Search field")
    public void userSearchUnlistedMemberBySearchField() {
        checkInsPage
                .clickAddMember().searchMember(unlistedMember).clickDoneAddMember();
    }
    @Then("no member icon is shown on the Member list")
    public void noMemberIconIsShownOnTheMemberList() {
        checkInsPage
                .verifyMemberIsNotAvailable();
    }
    @When("user select all members at once")
    public void userSelectAllMembersAtOnce() {
        checkInsPage
                .clickAddMember().clickSelectAllCheckBox().clickDoneAddMember();
    }
    @Then("all member's icon should be shown on Member section")
    public void allMemberSIconShouldBeShownOnMemberSection() throws Throwable {
        Thread.sleep(2000);
        checkInsPage
                .verifySelectedMember(memberName).verifySelectedMember(memberName1)
                .verifySelectedMember(memberName2).verifySelectedMember(memberName3);
    }
    @And("user remove the member from Member list")
    public void userRemoveTheMemberFromMemberList() throws Throwable{
        checkInsPage
                .clickAddMember();
        Thread.sleep(1000);
        checkInsPage
                .selectMember(memberName).selectMember(memberName1)
                .selectMember(memberName2).clickDoneAddMember();
    }
    @And("user remove all members at once")
    public void userRemoveAllMembersAtOnce() {
        checkInsPage
                .clickAddMember().clickSelectAllCheckBox().clickDoneAddMember();
    }
    @When("user select members name to be notified")
    public void userSelectMembersNameToBeNotified() {
        checkInsPage
                .setQuestionTitle(alphabeticTitle).setTimeManually(timeManual).clickAddMember()
                .selectMember(memberName2).selectMember(memberName3).clickDoneAddMember();
    }
    @And("member's icon should be shown on the created question")
    public void memberSIconShouldBeShownOnTheCreatedQuestion() throws Throwable{
        Thread.sleep(7000);
        checkInsPage
                .verifyMemberIconOnCreatedQuery().selectQuestionToBeArchived(alphabeticTitle)
                .verifyQuestionIsArchived();
    }
    @And("user activate private mode question")
    public void userActivatePrivateModeQuestion() {
        checkInsPage
                .clickPrivateButton().clickStartCollectingAnswers();
    }
    @And("user should see private icon on created question contain alert: {string}")
    public void userShouldSeePrivateIconOnCreatedQuestionContainAlert(String privateText) throws Throwable {
        Thread.sleep(7000);
        checkInsPage
                .verifyPrivateModeIsActivated(privateText).selectQuestionToBeArchived(alphabeticTitle)
                .verifyQuestionIsArchived();
    }
    @When("user created a question of notification")
    public void userCreatedAQuestionOfNotification() {
        checkInsPage.
                setQuestionTitle(alphabeticTitle).setTimeManually(timeManual)
                .clickAddMember().selectMember(memberName2).clickDoneAddMember()
                .clickPrivateButton().clickStartCollectingAnswers()
                .verifyCreatedQuestionTitle(alphabeticTitle)
                .verifyCreatedQuestionContainInfo(timeManual)
                .verifyPrivateModeIsActivated("Only members/subscribers can see this");
    }
    @And("user update the desired section to be updated")
    public void userUpdateTheDesiredSectionToBeUpdated() throws Throwable{
        checkInsPage
                .selectQuestionToBeEdited(alphabeticTitle).setTimeManually(timeManual2).clickPrivateButton()
                .clickStartCollectingAnswers();
        Thread.sleep(3000);

    }
    @And("user should see updated information on created question")
    public void userShouldSeeUpdatedInformationOnCreatedQuestion() throws Throwable{
        Thread.sleep(7000);
        checkInsPage
                .backToCheckInsPage()
                .verifyCreatedQuestionContainInfo(timeManual2)
                .selectQuestionToBeArchived(alphabeticTitle)
                .verifyQuestionIsArchived();;
    }
}
