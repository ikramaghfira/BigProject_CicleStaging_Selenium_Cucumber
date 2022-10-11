package Pages;

import Utils.WebElementUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static Utils.DriverUtils.driver;


public class GroupChatPage extends WebElementUtils {
    public GroupChatPage(WebDriver driver) {
        super(driver);
    }

    /**
     * BUTTON ELEMENTS
     */
    @FindBy(css = ".CreateMessage_send__2f1ZQ")
    private WebElement sendBtn;
    @FindBy(xpath = "(//div[@class='Message_iconOption__3F-Ru'])[1]")
    private WebElement navButtonLatestMessage;
    @FindBy(xpath = "//p[normalize-space()='Delete Message']")
    private WebElement deleteMessageBtn;
    @FindBy(xpath = "//button[@class='btn btn-danger btn-block btn-sm']")
    private WebElement popUpDeleteBtn;
    @FindBy(xpath = "//a[@href='https://www.youtube.com/watch?v=GrF2S2jSU2Y']")
    private WebElement urlElement;
    @FindBy(xpath = "//button[@class='close']")
    private WebElement closePopUpDeleteBtn;
    @FindBy(xpath = "//div[@class='MessageMenuPopUp_headerSection__2qEp5']//*[name()='svg']")
    private WebElement closeIconDelete;
    @FindBy(xpath = "(//div[@class='Message_attachment__title__2UFxF']/a)[1]")
    private WebElement downloadButton;

    /**
     * INPUT ELEMENTS
     */
    @FindBy(xpath = "//div[@class='fr-element fr-view']")
    private WebElement textFieldInput;
    @FindBy(xpath = "//div[@class='AttachFileContainer_container__3U9Wh']/input[1]")
    private WebElement inputFileExternal;

    /**
     * NON INTERACTIVE ELEMENTS
     */
    @FindBy(xpath = "//div[@class='BreadcrumbContainer_separateRoute__26-Ut']")
    private WebElement groupChatBreadcrumb;
    @FindBy(xpath = "(//div[@class='Message_container__3maDl']//div[@class='Message_content__21YIN'])[1]")
    private WebElement latestMessage;
    @FindBy(xpath = "(//div[@class='Message_balloon__zRoXK'])[1]")
    private WebElement latestUploadedMessage;
    @FindBy(xpath = "(//div[@class='Message_container__3maDl']//div[@class='Message_timeStamp__2XRSu'])[1]")
    private WebElement latestMessageTime;
    @FindBy(css = "#notistack-snackbar")
    private WebElement successAlert;
    @FindBy(xpath = "(//div[@class='Message_balloonMessage__3dmkS']//i)[1]")
    private WebElement textOnLatestDeletedMessage;
    @FindBy(xpath = "(//div[@class='Message_photo__2j-tv'])[1]")
    private WebElement latestSenderIcon;
    @FindBy(xpath = "(//div[@class='Message_name__3m1bn'])[1]")
    private WebElement latestSenderName;
    @FindBy(xpath = "(//div[@class='DateSeparator_container__2BpJl']/p)[1]")
    private WebElement dateSeparator;
    @FindBy(xpath = "(//div[@class='Message_attachment__title__2UFxF']/p)[1]")
    private WebElement lastestFileUploadedTitle;

    Actions actions = new Actions(driver);

    /**
     * ASSERTION FUNCTIONS
     */
    public GroupChatPage verifyOnGroupChatPage(){
        //assert breadcrumbs of Group Chat appeared
        String actualText = readText(groupChatBreadcrumb);
        Assert.assertEquals(actualText, "Group Chat");
        //assert Send button of Group Chat
        waitVisibilityElement(sendBtn);
        Assert.assertTrue(sendBtn.isEnabled());
        return this;
    }
    public GroupChatPage verifyMessageOnBubbleChat(String message) throws InterruptedException {
        Thread.sleep(2000);
        waitVisibilityElement(latestMessage);
        String actualMessage = latestMessage.getText();
        Assert.assertTrue(actualMessage.contains(message));
        return this;
    }
    public GroupChatPage verifyTimeStampLatestMessage(String timeStamp) throws InterruptedException {
        Thread.sleep(4000);
        waitVisibilityElement(latestMessageTime);
        String actualTime = readText(latestMessageTime);
        Assert.assertTrue(actualTime.contains(timeStamp));
        return this;
    }
    public GroupChatPage verifySuccessAlert(String text){
        String actualAlert = readText(successAlert);
        Assert.assertEquals(actualAlert,text);
        return this;
    }
    public GroupChatPage verifyAfterDeleteBubbleChatContain(String text){
        waitVisibilityElement(textOnLatestDeletedMessage);
        String actualText = readText(textOnLatestDeletedMessage);
        Assert.assertEquals(actualText,text);
        return this;
    }
    public GroupChatPage verifyGoToUrlSite(){
        Set<String> handles =driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        //iterate through your windows
        while (it.hasNext()){
            String parent = it.next();
            String newwin = it.next();
            driver.switchTo().window(newwin);
            //perform actions on new window
            Assert.assertTrue(driver.getTitle().contains("\uD83C\uDF34 4-HOUR STUDY MUSIC PLAYLIST" +
                    "/ Relaxing Lofi/ Deep Focus Pomodoro Timer/Study With Me/STAY MOTIVATED"));
            driver.close();
            driver.switchTo().window(parent);
        }
        return this;
    }
    public GroupChatPage verifyTextOnTheInputText(String message) throws InterruptedException {
        Thread.sleep(1500);
        Assert.assertTrue(textFieldInput.getText().contains(message));
        return this;
    }
    public GroupChatPage verifyOtherSenderIconAndName(String name){
        Assert.assertTrue(latestSenderIcon.isDisplayed());
        Assert.assertTrue(latestSenderName.getText().toLowerCase().contains(name));
        return this;
    }
    public GroupChatPage verifyDateSeparator(String date){
        Assert.assertTrue(dateSeparator.getText().toLowerCase().contains(date));
        return this;
    }
    public GroupChatPage verifyUploadedFileName(String text) throws InterruptedException {
        Thread.sleep(2000);
        waitVisibilityElement(lastestFileUploadedTitle);
        Assert.assertTrue(lastestFileUploadedTitle.getText().equalsIgnoreCase(text));
        return this;
    }
    public boolean verifyFileIsDownloaded(String downloadPath, String fileName){
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                Assert.assertTrue(dirContents[i].getName().equals(fileName));
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    /**
     * INTERACTION FUNCTIONS
     */
    public GroupChatPage typeAMessage(String message){
        waitVisibilityElement(textFieldInput);
        clickElement(textFieldInput);
        writeText(textFieldInput, message);
        return this;
    }
    public GroupChatPage clickSendButton(){
        clickElement(sendBtn);
        return this;
    }
    public GroupChatPage deleteLatestMessage() throws InterruptedException {
        Thread.sleep(2000);
        actions.moveToElement(latestMessage).click().build().perform();
        waitVisibilityElement(navButtonLatestMessage);
        actions.moveToElement(navButtonLatestMessage).click().build().perform();
        waitVisibilityElement(deleteMessageBtn);
        clickElement(deleteMessageBtn);
        waitVisibilityElement(popUpDeleteBtn);
        clickElement(popUpDeleteBtn);
        return this;
    }
    public GroupChatPage clickUrlMessage() throws InterruptedException {
        Thread.sleep(1500);
        waitVisibilityElement(urlElement);
        actions.moveToElement(urlElement).click().build().perform();
        return this;
    }
    public GroupChatPage addEnterToMessage(){
        textFieldInput.sendKeys(Keys.chord(Keys.ENTER));
        return this;
    }
    public GroupChatPage messageWithMentionMember(String message, String member) {
        waitVisibilityElement(textFieldInput);
        clickElement(textFieldInput);
        String textMsg = message + " @";
        writeText(textFieldInput, textMsg);
        List<WebElement> listMention =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("//div[@class='tribute-container']//li//a")));
        for (int i = 0; i < listMention.size(); i++) {
            String actualMember = listMention.get(i).getText().trim();
            if (actualMember.toLowerCase().contains(member)) {
                WebElement desiredElement = listMention.get(i);
                clickElement(desiredElement);
            }
        }
        return this;
    }
    public GroupChatPage cancelDeleteMessage() throws InterruptedException {
        Thread.sleep(2000);
        actions.moveToElement(latestMessage).click().build().perform();
        actions.moveToElement(navButtonLatestMessage).click().build().perform();
        waitVisibilityElement(deleteMessageBtn);
        clickElement(deleteMessageBtn);
        waitVisibilityElement(closePopUpDeleteBtn);
        clickElement(closePopUpDeleteBtn);
        waitVisibilityElement(closeIconDelete);
        clickElement(closeIconDelete);
        return this;
    }
    public GroupChatPage scrollToLatestOtherSender(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", latestSenderIcon);
        return this;
    }
    public GroupChatPage scrollToLatestDate(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", dateSeparator);
        return this;
    }
    public GroupChatPage uploadFile(String text){
        ((JavascriptExecutor) driver)
                .executeScript(
                        "document.evaluate('//div[2]/div/div/input', document, null, " +
                                "XPathResult.FIRST_ORDERED_NODE_TYPE, null,).singleNodeValue" +
                                ".setAttribute('style', 'display: block;')");
        if(text.equalsIgnoreCase("document")){
            writeText(inputFileExternal,
                    "F:\\K. Belajar JAVA\\4. Tugas\\BigProject\\src\\main\\java\\testData\\document.zip");
        } else if (text.equalsIgnoreCase("image")) {
            writeText(inputFileExternal,
                    "F:\\K. Belajar JAVA\\4. Tugas\\BigProject\\src\\main\\java\\testData\\image.png");
        } else if (text.equalsIgnoreCase("video")) {
            writeText(inputFileExternal,
                    "F:\\K. Belajar JAVA\\4. Tugas\\BigProject\\src\\main\\java\\testData\\video.mp4");
        }
        return this;
    }
    public GroupChatPage deleteLatestFile() throws InterruptedException {
        Thread.sleep(3000);
        actions.moveToElement(latestUploadedMessage).click().build().perform();
        waitVisibilityElement(navButtonLatestMessage);
        actions.moveToElement(navButtonLatestMessage).click().build().perform();
        waitVisibilityElement(deleteMessageBtn);
        clickElement(deleteMessageBtn);
        waitVisibilityElement(popUpDeleteBtn);
        clickElement(popUpDeleteBtn);
        Thread.sleep(3000);
        return this;
    }
    public GroupChatPage downloadFileUploaded(){
        clickElement(downloadButton);
        return this;
    }
}
