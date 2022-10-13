package Pages;

import Utils.WebElementUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;

import static Utils.DriverUtils.driver;

public class CheckInsPage extends WebElementUtils {

    public CheckInsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * BUTTON ELEMENTS
     */
    @FindBy(css = ".GlobalActionButton_container__EJ7Lh")
    private WebElement createCheckInsBtn;
    @FindBy(xpath = "//div[@class='RoundActionMenu_container__2ta8s RoundActionMenu_medium__3rLho']")
    private WebElement roundActionMenu;
    @FindBy(xpath = "(//div[@class='QuestionMenu_menu__3nDO6'])[1]")
    private WebElement editQuestionBtn;
    @FindBy(xpath = "(//div[@class='QuestionMenu_menu__3nDO6'])[2]")
    private WebElement archiveThisQuestionBtn;
    @FindBy(css = ".btn.btn-success")
    private WebElement startCollectinAnswersBtn;
    @FindBy(css = ".btn.btn-danger")
    private WebElement cancelQuestionBtn;
    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root " +
            "MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw']")
    private WebElement clockIconBtn;
    @FindBy(xpath = "//button[@title='open previous view']")
    private WebElement clockPreviousBtn;
    @FindBy(xpath = "//button[@title='open next view']")
    private WebElement clockNextBtn;
    @FindBy(xpath = "//div[@class='ShowLimitMembers_plusButton__8k3vj ShowLimitMembers_secondary__2lF80']")
    private WebElement addMemberBtn;
    @FindBy(css = ".ManageSubscribersContainer_doneButton__1KEKA")
    private WebElement doneAddMemberBtn;
    @FindBy(xpath = "//div[@class='ManageSubscribersContainer_ManageSubscribersContainer__SelectAll__1eO7d']" +
            "//*[name()='svg']")
    private WebElement selectAllMemberBtn;
    @FindBy(xpath = "//span[@class='MuiSwitch-thumb css-19gndve']")
    private WebElement questionPrivateBtn;

    /**
     * INPUT ELEMENTS
     */
    @FindBy(className = "form-control")
    private WebElement titleField;
    @FindBy(xpath = "(//input[@class='General_input__i_E5P'])[2]")
    private WebElement searchMemberInput;

    /**
     * NON INTERACTIVE ELEMENTS
     */
    @FindBy(xpath = "//div[@class='BreadcrumbContainer_separateRoute__26-Ut']/span")
    private WebElement checkInsBreadcrumb;
    @FindBy(xpath = "//div[@class='BreadcrumbContainer_separateRoute__26-Ut']/span")
    private WebElement createCIBreadcrumb;
    @FindBy(id = "notistack-snackbar")
    private WebElement successAlert;
    @FindBy(xpath = "//div[@class='Question_contentSection__2XBmI']/h1")
    private WebElement createdQuestionTitle;
    @FindBy(xpath = "//a[@class='LinkNoDecor_Link__3DEkL']")
    private WebElement questionContainer;
    @FindBy(xpath = "//div[@class='QuestionPage_archivedSection__1VczP']")
    private WebElement archivedLabel;
    @FindBy(xpath = "//div[@class='Question_contentSection__2XBmI']/p")
    private WebElement createdQueryInfo;
    @FindBy(xpath = "//div[@class='MuiFormControl-root MuiTextField-root css-i44wyl']/div[1]/input")
    private WebElement actualTimeDisplayed;
    @FindBy(xpath = "//div[@class='Question_contentSection__2XBmI']" +
            "//img[@src='https://lh3.googleusercontent.com/a-/AFdZucoCVOSWoVrADWgZwDYcHcnqnUDpFI-DrkhpEJG1=s96-c']")
    private WebElement firaIcon;
    @FindBy(xpath = "//div[@class='Question_contentSection__2XBmI']" +
            "//img[@src='https://lh3.googleusercontent.com/a-/AOh14GgcImXblykCbQ7D3asP9g6MT59wqcmpAPHSPo9UAg=s96-c']")
    private WebElement fenyIcon;
    @FindBy(xpath = "//div[@class='Question_contentSection__2XBmI']//*[name()='svg']")
    private WebElement queryPrivateIcon;
    @FindBy(xpath = "//div[@class='MuiTooltip-tooltip MuiTooltip-tooltipPlacementBottom css-1spb1s5']")
    private WebElement privateTextAlert;
    @FindBy(xpath = "//a[normalize-space()='Check-Ins']")
    private WebElement ciBreadcrumb;


    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    /**
     * ASSERTION FUNCTIONS
     */
    public CheckInsPage verifyOnCheckInsPage(){
        //assert Check Ins breadcrumb
        String actualText = readText(checkInsBreadcrumb);
        Assert.assertEquals(actualText, "Check-Ins");
        //assert Create CheckIn button is clickable
        Assert.assertTrue(createCheckInsBtn.isEnabled());
        return this;
    }
    public CheckInsPage verifyOnNewQuestionPage(){
        //assert New Question breadcrumb
        String actualText = readText(createCIBreadcrumb);
        Assert.assertEquals(actualText,"Create Check-in");
        //assert Start Collecting Answers is clickable
        waitVisibilityElement(startCollectinAnswersBtn);
        Assert.assertTrue(startCollectinAnswersBtn.isEnabled());
        return this;
    }
    public CheckInsPage verifySuccessAlert(String text){
        String actualAlert = readText(successAlert);
        Assert.assertEquals(actualAlert,text);
        return this;
    }
    public CheckInsPage verifyCreatedQuestionTitle(String title){
        waitVisibilityElement(createdQuestionTitle);
        Assert.assertEquals(readText(createdQuestionTitle), title);
        return this;
    }

    public CheckInsPage verifyQuestionIsArchived(){
        //assert This question is archived label is displayed
        waitVisibilityElement(archivedLabel);
        Assert.assertTrue(archivedLabel.isDisplayed());
        return this;
    }
    public CheckInsPage verifyCreatedQuestionContainInfo(String text){
        waitVisibilityElement(createdQueryInfo);
        String actualInfo = readText(createdQueryInfo);
        Assert.assertTrue(actualInfo.contains(text));
        return this;
    }
    public CheckInsPage verifyTimeSet(String time){
        String actualTime = actualTimeDisplayed.getAttribute("value");
        Assert.assertTrue(actualTime.contains(time));
        return this;
    }
    public CheckInsPage verifyPrevOrNextBtn(String text){
        if(text.equals("next")){
            Assert.assertFalse(clockNextBtn.isEnabled());
        } else if (text.equals("previous")) {
            Assert.assertFalse(clockPreviousBtn.isEnabled());
        }
        return this;
    }
    public CheckInsPage verifySelectedMember(String member){
        List<WebElement> listMemberIcon =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("//img[@class='MuiAvatar-img css-1hy9t21']")));
        for (int i=0; i< listMemberIcon.size(); i++){
            String altText = listMemberIcon.get(i).getAttribute("alt");
            if(altText.toLowerCase().contains(member)){
                boolean isTrue = true;
                Assert.assertTrue(isTrue);
            }
        }
        return this;
    }
    public CheckInsPage verifyMemberIsNotAvailable(){
        Assert.assertTrue(addMemberBtn.isDisplayed());
        return this;
    }
    public  CheckInsPage verifyMemberIconOnCreatedQuery(){
        Assert.assertTrue(firaIcon.isDisplayed());
        Assert.assertTrue(fenyIcon.isDisplayed());
        return this;
    }
    public CheckInsPage verifyPrivateModeIsActivated(String alert){
        //assert private icon is displayed
        waitVisibilityElement(queryPrivateIcon);
        Assert.assertTrue(queryPrivateIcon.isDisplayed());
        //assert private alert text is suitable
        actions.moveToElement(queryPrivateIcon).perform();
        waitVisibilityElement(privateTextAlert);
        String actualMessage = privateTextAlert.getText();
        Assert.assertEquals(actualMessage, alert);
        return this;
    }

    /**
     * INTERACTION FUNCTIONS
     */
    public CheckInsPage clickCreateCheckInButton(){
        clickElement(createCheckInsBtn);
        return this;
    }
    public CheckInsPage setQuestionTitle(String text){
        clickElement(titleField);
        writeText(titleField, text);
        return this;
    }
    public CheckInsPage clickStartCollectingAnswers(){
        clickElement(startCollectinAnswersBtn);
        return this;
    }
    public CheckInsPage selectQuestionToBeArchived(String title){
        waitVisibilityElement(questionContainer);
        boolean isTrue = readText(questionContainer).contains(title);
        if(isTrue == true){
            clickElement(questionContainer);
            clickElement(roundActionMenu);
            clickElement(archiveThisQuestionBtn);
        }
        return this;
    }
    public CheckInsPage clickCancelQuestionButton(){
        waitVisibilityElement(cancelQuestionBtn);
        clickElement(cancelQuestionBtn);
        return this;
    }
    public CheckInsPage selectDayOfReminders(String day){
        List<WebElement> listElementDays =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("//div[@class='DayBox_container__2GPGE']")));
        for (int i=0; i< listElementDays.size(); i++){
            String actualDay = listElementDays.get(i).getText().trim();
            if(actualDay.equalsIgnoreCase(day)){
                WebElement desiredElement = listElementDays.get(i);
                clickElement(desiredElement);
            }
        }
        return this;
    }
    public CheckInsPage clickClockIcon(){
        clickElement(clockIconBtn);
        return this;
    }
    public CheckInsPage setHour(String hour){
        By pickHourElement = By.xpath("//span[normalize-space()="+hour+"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(pickHourElement));
        actions.moveToElement(driver.findElement(pickHourElement)).click().build().perform();
        return this;
    }
    public CheckInsPage setTimeFormat(String format){
        List<WebElement> listFormat =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("//span[@class='MuiTypography-root MuiTypography-caption css-1v2gfp5']")));
        for (int i=0; i< listFormat.size(); i++){
            String actualFormat = listFormat.get(i).getText().trim();
            if(actualFormat.equalsIgnoreCase(format)){
                WebElement desiredElement = listFormat.get(i);
                clickElement(desiredElement);
            }
        }
        return this;
    }
    public CheckInsPage clickPrevOrNextBtn(String text){
        if(text.equals("next")){
            clickElement(clockNextBtn);
        } else if (text.equals("previous")) {
            clickElement(clockPreviousBtn);
        }
        return this;
    }
    public CheckInsPage setTimeManually(String time){
        clickElement(actualTimeDisplayed);
        actualTimeDisplayed.sendKeys(Keys.chord(Keys.CONTROL, "a"), time);
        return this;
    }
    public CheckInsPage clickAddMember(){
        clickElement(addMemberBtn);
        return this;
    }
    public CheckInsPage searchMember(String member){
        clickElement(searchMemberInput);
        writeText(searchMemberInput, member);
        return this;
    }
    public CheckInsPage selectMember(String member){
        List<WebElement> listMember =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("//div[@class='ManageSubscribersContainer" +
                                "_ManageSubscribersContainer__teamMember__dAJ8o']//p")));
        for (int i=0; i< listMember.size(); i++){
            String actualMember = listMember.get(i).getText().trim();
            if(actualMember.toLowerCase().contains(member)){
                WebElement desiredElement = listMember.get(i);
                clickElement(desiredElement);
            }
        }
        return this;
    }
    public CheckInsPage clickDoneAddMember(){
        clickElement(doneAddMemberBtn);
        return this;
    }
    public CheckInsPage clickSelectAllCheckBox(){
        clickElement(selectAllMemberBtn);
        return this;
    }
    public CheckInsPage clickPrivateButton(){
        actions.moveToElement(questionPrivateBtn).click().build().perform();
        return this;
    }
    public CheckInsPage selectQuestionToBeEdited(String title){
        waitVisibilityElement(questionContainer);
        boolean isTrue = readText(questionContainer).contains(title);
        if(isTrue == true){
            clickElement(questionContainer);
            clickElement(roundActionMenu);
            clickElement(editQuestionBtn);
        }
        return this;
    }
    public CheckInsPage backToCheckInsPage(){
        clickElement(ciBreadcrumb);
        return this;
    }
}
