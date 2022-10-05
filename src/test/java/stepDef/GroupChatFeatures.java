package stepDef;

import Pages.GroupChatPage;
import Pages.TeamsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Utils.DriverUtils.driver;

public class GroupChatFeatures {
    TeamsPage teamsPage = new TeamsPage(driver);
    GroupChatPage groupChatPage = new GroupChatPage(driver);

    /**
     * TEST DATA
     */
    String alphabeticMessage = "Halo ini adalah uji coba group chat";
    String urlMessage = "https://www.youtube.com/watch?v=GrF2S2jSU2Y";
    String longMessage = "Paragraf atau alinea adalah suatu gagasan yang berbentuk serangkaian kalimat yang " +
            "saling berkaitan satu sama lain. Nama lain dari paragraf ialah wacana mini. Kegunaan dari paragraf " +
            "adalah untuk menjadi penanda dimulainya topik baru dan memisahkan gagasan-gagasan utama yang berbeda. " +
            "Penggunaan paragraf memudahkan pembaca untuk memahami bacaan secara menyeluruh. Panjang dari satu " +
            "paragraf adalah beberapa kalimat.[1] Jumlah kalimat dalam paragraf ditentukan oleh cara pengembangan " +
            "dan ketuntasan uraian gagasan yang disampaikan. Jumlah kalimat di dalam paragraf dapat menentukan " +
            "kualitas dari bacaan.[2] Paragraf tersusun dari gagasan utama yang terletak dalam kalimat topik. " +
            "Selain itu, terdapat kalimat penjelas yang memperjelas kalimat topik.[3] Paragraf juga berfungsi " +
            "untuk mengungkapkan pemikiran penulis secara sistematis sehingga mudah untuk dipahami oleh pembaca.[4]" +
            " Kriteria sekumpulan kalimat yang dapat menjadi paragraf yaitu adanya kesatuan, kepaduan, ketuntasan, " +
            "keruntutan, dan sudut pandang yang tidak berubah-ubah.[5]";
    String memberToMention = "widiya";
    String latestOtherSender = "risya";
    String chatDate = "today";

    /**
     * STEP DEFINITION FUNCTIONS
     */
    @When("user go to Group Chat Page through Box Menu")
    public void userGoToGroupChatPageThroughBoxMenu() {
        teamsPage
                .goToGroupChatPageThroughIconButton();
    }
    @Then("user should see Send button")
    public void userShouldSeeSendButton() {
        groupChatPage
                .verifyOnGroupChatPage();
    }
    @When("user go to Group Chat Page through Overview Menu")
    public void userGoToGroupChatPageThroughOverviewMenu() {
        teamsPage
                .goToGroupChatPageThroughOverview();
    }
    @Given("user is on the GROUP CHAT PAGE")
    public void userIsOnTheGROUPCHATPAGE() {
        teamsPage
                .goToGroupChatPageThroughIconButton().verifyOnGroupChatPage();
    }
    @When("user type a message on text field")
    public void userTypeAMessageOnTextField() {
        groupChatPage
                .typeAMessage(alphabeticMessage);
    }
    @And("user send the message")
    public void userSendTheMessage() {
        groupChatPage
                .clickSendButton();
    }
    @Then("user should see the message on the bubble chat")
    public void userShouldSeeTheMessageOnTheBubbleChat() throws Throwable{
        groupChatPage
                .verifyMessageOnBubbleChat(alphabeticMessage);
    }
    @Then("user should see the time description on the bubble chat: {string}")
    public void userShouldSeeTheTimeDescriptionOnTheBubbleChat(String timeDesc) throws Throwable {
        groupChatPage
                .verifyTimeStampLatestMessage(timeDesc);
    }
    @When("user delete the desired message")
    public void userDeleteTheDesiredMessage() throws Throwable{
        groupChatPage
                .deleteLatestMessage();
    }
    @Then("user should see success alert appeared: {string}")
    public void userShouldSeeSuccessAlertAppeared(String alert) {
        groupChatPage
                .verifySuccessAlert(alert);
    }
    @And("user should not see the message on the bubble chat instead: {string}")
    public void userShouldNotSeeTheMessageOnTheBubbleChatInstead(String textReplacement) {
        groupChatPage
                .verifyAfterDeleteBubbleChatContain(textReplacement);
    }
    @When("^user type other kind of (.*) ot the type field$")
    public void userTypeOtherKindOfMessageOtTheTypeField(String uniqueMessage) {
        groupChatPage
                .typeAMessage(uniqueMessage);
    }
    @Then("^user should see the unique (.*) on the bubble chat$")
    public void userShouldSeeTheUniqueMessageOnTheBubbleChat(String uniqueMessage) throws Throwable{
        groupChatPage
                .verifyMessageOnBubbleChat(uniqueMessage).deleteLatestMessage()
                .verifySuccessAlert("Delete group chat message success");
    }
    @When("user type url as a message on the type field")
    public void userTypeUrlAsAMessageOnTheTypeField() {
        groupChatPage
                .typeAMessage(urlMessage).addEnterToMessage();
    }
    @Then("user should be navigated to the url site when url is accessed")
    public void userShouldBeNavigatedToTheUrlSiteWhenUrlIsAccessed() throws Throwable{
        groupChatPage
                .clickUrlMessage().verifyGoToUrlSite().deleteLatestMessage()
                .verifySuccessAlert("Delete group chat message success");
    }
    @When("user type a long message on the type field")
    public void userTypeALongMessageOnTheTypeField() {
        groupChatPage
                .typeAMessage(longMessage);
    }
    @Then("user should see the long message on the bubble chat")
    public void userShouldSeeTheLongMessageOnTheBubbleChat() throws Throwable{
        groupChatPage
                .verifyMessageOnBubbleChat(longMessage).deleteLatestMessage()
                .verifySuccessAlert("Delete group chat message success");
    }
    @And("user send the message through ENTER key")
    public void userSendTheMessageThroughENTERKey() {
        groupChatPage
                .addEnterToMessage();
    }
    @Then("user should see the message remain on the text field")
    public void userShouldSeeTheMessageRemainOnTheTextField() throws Throwable{
        groupChatPage
                .verifyTextOnTheInputText(alphabeticMessage);
    }
    @When("user type a message along with mention a member")
    public void userTypeAMessageAlongWithMentionAMember() {
        groupChatPage
                .messageWithMentionMember(alphabeticMessage, memberToMention);
    }
    @Then("user should see the latest message on the bubble chat")
    public void userShouldSeeTheLatestMessageOnTheBubbleChat() throws Throwable{
        groupChatPage
                .verifyMessageOnBubbleChat(alphabeticMessage).deleteLatestMessage()
                .verifySuccessAlert("Delete group chat message success");
    }
    @When("user decide to cancel a message from deleting process")
    public void userDecideToCancelAMessageFromDeletingProcess() throws Throwable{
        groupChatPage
                .typeAMessage(alphabeticMessage).clickSendButton()
                .cancelDeleteMessage();
    }
    @When("user see other sender message")
    public void userSeeOtherSenderMessage() {
        groupChatPage
                .scrollToLatestOtherSender();
    }
    @Then("user should be shown sender name and icon")
    public void userShouldBeShownSenderNameAndIcon() throws Throwable{
        Thread.sleep(1500);
        groupChatPage
                .verifyOtherSenderIconAndName(latestOtherSender);
    }
    @When("user want to see when the message is sent")
    public void userWantToSeeWhenTheMessageIsSent() throws Throwable {
        groupChatPage
                .scrollToLatestDate();
        Thread.sleep(2000);
    }
    @Then("user should be shown the date separator of the message")
    public void userShouldBeShownTheDateSeparatorOfTheMessage() {

        groupChatPage
                .verifyDateSeparator(chatDate);
    }
    @When("^user attach (.*) from the local repository$")
    public void userAttachFileFromTheLocalRepository(String file) {
        groupChatPage
                .uploadFile(file);
    }
    @And("^user should see the (.*) is displayed on the bubble chat$")
    public void userShouldSeeTheFileNameIsDisplayedOnTheBubbleChat(String fileName) throws Throwable{
        groupChatPage
                .verifyUploadedFileName(fileName).deleteLatestFile()
                .verifySuccessAlert("Delete group chat attachment success");
    }
    @When("user download the file attached on the group chat: {string}")
    public void userDownloadTheFileAttachedOnTheGroupChat(String file) {
        groupChatPage
                .uploadFile(file).downloadFileUploaded();
    }
    @Then("the file should be downloaded to local repository: {string}")
    public void theFileShouldBeDownloadedToLocalRepository(String file) throws Throwable{
        groupChatPage
                .verifyFileIsDownloaded("C:\\Users\\IKRAMAH\\Downloads", file);
        groupChatPage
                .deleteLatestFile()
                .verifySuccessAlert("Delete group chat attachment success");
    }
    @When("^user type (.*) on japanese, korean, also russian$")
    public void userTypeMessageOnJapaneseKoreanAlsoRussian(String text) {
        groupChatPage
                .typeAMessage(text).clickSendButton();
    }
    @Then("^user should see the (.*) on the bubble chat in suitable language$")
    public void userShouldSeeTheMessageOnTheBubbleChatInSuitableLanguage(String text) throws Throwable{
        Thread.sleep(2000);
        groupChatPage
                .verifyMessageOnBubbleChat(text).deleteLatestMessage()
                .verifySuccessAlert("Delete group chat message success");
    }
}
