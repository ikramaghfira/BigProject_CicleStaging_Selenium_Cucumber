package Pages;

import Utils.WebElementUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static Utils.DriverUtils.driver;
public class BoardPage extends WebElementUtils {
    public BoardPage(WebDriver driver) {
        super(driver);
    }

    /**
     * BUTTON ELEMENTS
     */
    @FindBy(css = ".btn.btn-outline-dark.btn-block.btn-sm")
    private WebElement addListButton;
    @FindBy(xpath = "(//div[@class='ListMenu_menu__2FIPr'])[2]")
    private WebElement archiveThisListMenu;
    @FindBy(xpath = "(//div[@class='ListMenu_menu__2FIPr'])[1]")
    private WebElement archiveAllCardsInThisList;
    @FindBy(xpath = "(//div[@class='ListMenu_menu__2FIPr'])[3]")
    private WebElement setAsCompleteList;
    @FindBy(xpath = "(//div[@class='ListMenu_menu__2FIPr'])[4]")
    private WebElement sortFromAtoZ;
    @FindBy(xpath = "(//div[@class='ListMenu_menu__2FIPr'])[5]")
    private WebElement sortFromZtoA;
    @FindBy(xpath = "(//div[@class='ListMenu_menu__2FIPr'])[6]")
    private WebElement sortNearestDate;
    @FindBy(xpath = "(//div[@class='ListMenu_menu__2FIPr'])[7]")
    private WebElement sortFurthestDate;
    @FindBy(xpath = "(//div[@class='ListMenu_menu__2FIPr'])[8]")
    private WebElement sortNearestCreatedDate;
    @FindBy(xpath = "(//div[@class='ListMenu_menu__2FIPr'])[9]")
    private WebElement sortFurthestCreatedDate;
    @FindBy(xpath = "(//div[@class='GlobalActionButton_outlinedContainer__DLFAv'])[2]")
    private WebElement archivedItemMenu;
    @FindBy(css = ".btn.btn-dark.btn-sm")
    private WebElement switchBtn;
    @FindBy(css = ".btn.btn-success.btn-sm")
    private WebElement createListBtn;
    @FindBy(xpath = "//div[@class='CreateListButton_actionSection__1BBgC']/div[1]//*[name()='svg']")
    private WebElement cancelListBtn;
    @FindBy(xpath = "(//div[@class='RoundActionMenu_container__2ta8s'])[1]")
    private WebElement navBtn;
    @FindBy(xpath = "(//div[@class='ChangeCompleteIconMenu_menu__a_LT8'])[2]")
    private WebElement blockedBtn;
    @FindBy(xpath = "//div[@class='ListContainer_ListContainer__buttonBottom__2kZAI']")
    private WebElement addCardBtn;
    @FindBy(xpath = "//div[@class='CreateCardForm_togglePrivateCard__Nzcz0']/span/span[1]")
    private WebElement privateCardToggle;
    @FindBy(xpath = "//button[@class='btn btn-success btn-sm']")
    private WebElement addCardBtnGreen;
    @FindBy(xpath = "(//div[@class='Button_container__1WNuB'])[2]")
    private WebElement firstRestoreButton;
    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeCardContainerBtn;
    @FindBy(xpath = "(//div[@class='ManageAttachments_wrapper__2BoXS'])[2]")
    private WebElement editAttachmentBtn;
    @FindBy(xpath = "(//div[@class='ManageAttachments_wrapper__2BoXS'])[4]")
    private WebElement deleteAttachmentBtn;
    @FindBy(xpath = "//button[@class='btn btn-success btn-sm']")
    private WebElement updateAttachmentBtn;
    @FindBy(xpath = "//button[@class='btn btn-danger btn-block btn-sm']")
    private WebElement deletePUAttachmentBtn;
    @FindBy(xpath = "(//button[@class='Main_container__3r1Cm'])[2]")
    private WebElement postCommentBtn;
    @FindBy(xpath = "(//div[@class='More_container__2VGML'])[1]")
    private WebElement navBtnLatestComment;
    @FindBy(xpath = "(//div[@class='Item_container__3qBQE'])[2]")
    private WebElement deleteLatestCommentBtn;
    @FindBy(xpath = "(//button[@class='Main_container__3r1Cm'])[2]")
    private WebElement deleteCommentPUBtn;
    @FindBy(xpath = "(//button[@class='btn btn-secondary btn-block btn-sm'])[2]")
    private WebElement labelBtnATC;
    @FindBy(xpath = "//div[@class='ToggleLabels_plusButton__3YgnQ']//*[name()='svg']")
    private WebElement addLabelBtn;
    @FindBy(xpath = "//button[@class='btn btn-success btn-sm']")
    private WebElement createLabelBtn;
    @FindBy(xpath = "//div[@class='ManageLabelsContainer_ManageLabelsContainer__Header__2ZJCk']//*[name()='svg']")
    private WebElement closeLabelPU;
    @FindBy(xpath = "(//div[@class='ToggleLabels_sectionLabel__28djQ']//*[name()='svg'])[2]")
    private WebElement editFirstLabelBtn;
    @FindBy(xpath = "//button[@class='Main_container__3r1Cm']")
    private WebElement applyLabelBtn;
    @FindBy(xpath = "//button[@class='btn btn-danger btn-sm']")
    private WebElement deleteLabelBtn;
    @FindBy(xpath = "(//button[@class='btn btn-secondary btn-block btn-sm'])[3]")
    private WebElement dueDateBtnATC;
    @FindBy(xpath = "(//button[@class='btn btn-secondary btn-block btn-sm'])[6]")
    private WebElement privateBtnAction;
    @FindBy(css = ".modal-title.h4")
    private WebElement cardTitleOnLayer;
    @FindBy(xpath = "//div[@class='ArchivedItemsMenu_header__1txSL']//*[name()='svg']")
    private WebElement closeArchivedItems;
    @FindBy(xpath = "//div[@class='CreateLabel_CreateLabelContainer__body__1tydf']//div[5]")
    private WebElement labelColor;
    @FindBy(xpath = "//div[normalize-space()='test']/following-sibling::div/button")
    private WebElement testListRestoreBtn;
    /**
     * INPUT BUTTONS
     */
    @FindBy(className = "form-control")
    private WebElement inputTitleList;
    @FindBy(xpath = "//input[@placeholder='Card name']")
    private WebElement inputCardName;
    @FindBy(className = "form-control")
    private WebElement updateListTitleForm;
    @FindBy(css = ".ChangeNameForm_teamName__VbXNI.form-control")
    private WebElement inputCardTitleOnLayer;
    @FindBy(xpath = "//div[@class='ArchivedItemsMenu_search__1B_5_']//input")
    private WebElement searchFieldArchivedItem;
    @FindBy(xpath = "(//div[@class='AttachFileContainer_container__3U9Wh']/input)[1]")
    private WebElement attachmentInput;
    @FindBy(xpath = "//div[@class='EditPopUp_formSection__3ndu0']//input")
    private WebElement updateAttachmentTitleField;
    @FindBy(xpath = "//div[@class='CreateCommentForm_inputComment__2G2m9']//input")
    private WebElement commentField;
    @FindBy(xpath = "//div[@class='fr-wrapper show-placeholder']//p")
    private WebElement commentInputField;
    @FindBy(xpath = "//input[@placeholder='Input name']")
    private WebElement inputLabelName;
    @FindBy(xpath = "//div[@class='EditLabel_sectionSmallTitle__1LzwO']//form/input")
    private WebElement changeLabelNameInput;
    @FindBy(xpath = "(//div[@class='MuiFormControl-root MuiTextField-root css-i44wyl']//input)[1]")
    private WebElement dateInput;
    @FindBy(xpath = "(//div[@class='MuiFormControl-root MuiTextField-root css-i44wyl']//input)[2]")
    private WebElement timeInput;
    /**
     * NON INTERACTIVE ELEMENTS
     */
    @FindBy(xpath = "//div[@class='BreadcrumbContainer_separateRoute__26-Ut']/span")
    private WebElement boardBreadcrumb;
    @FindBy(xpath = "(//div[@class='ListContainer_headerSection__title__text__36H_r'])[1]")
    private WebElement latestCreatedList;
    @FindBy(id = "notistack-snackbar")
    private WebElement successAlert;
    @FindBy(xpath = "//div[@class='MuiTooltip-tooltip MuiTooltip-tooltipPlacementBottom css-1spb1s5']")
    private WebElement iconMessage;
    @FindBy(xpath = "//*[name()='path' and contains(@d,'M12 2C6.48')]")
    private WebElement doneIcon;
    @FindBy(xpath = "//div[@class='ListContainer_headerSection__title__completeIcon__container__1kqb5']")
    private WebElement blockedIcon;
    @FindBy(xpath = "//*[name()='svg'][@data-testid='LockIcon']")
    private WebElement privateIcon;
    @FindBy(xpath = "(//div[@class='SmallCard_SmallCard__xuek9']//h1)[1]")
    private WebElement cardOnTheFirstPosition;
    @FindBy(xpath = "//div[@class='ManageAttachments_titleSection__3I823']")
    private WebElement attachmentTitle;
    @FindBy(xpath = "(//div[@class='Box_DateBox__fI6QU Box_noClick__2_CPN']//time)[1]")
    private WebElement commentLatestTimeStamp;
    @FindBy(xpath = "(//div[@class='Label_label__block__3aY7I'])[1]")
    private WebElement firstCreatedLabel;
    @FindBy(xpath = "//div[@class='modal-title h4']//*[name()='svg']")
    private WebElement privateIconOnLayer;
    @FindBy(xpath = "(//div[@class='ArchivedItemsLists_listName__3Wb-n'])[1]")
    private WebElement firstArchivedList;


    Actions action = new Actions(driver);

    public BoardPage verifyIsOnBoardPage() throws InterruptedException {
        String actualHeader = readText(boardBreadcrumb);
        Assert.assertEquals(actualHeader, "Kanban Board");
        Thread.sleep(2000);
        Assert.assertTrue(addListButton.isDisplayed());
        return this;
    }

    /**
     * ASSERTION FUNCTIONS
     */
    public BoardPage verifySuccessAlert(String text) throws InterruptedException {
        Thread.sleep(1500);
        String actualAlert = readText(successAlert);
        Assert.assertTrue(actualAlert.contains(text));
        return this;
    }
    public BoardPage verifyListIsCreated(String title) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(latestCreatedList.getText().contains(title));
        return this;
    }
    public BoardPage verifyListIsMovedToArchive(String text) throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> archivedList =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("//div[@class='ArchivedItemsLists_container__3XA4E']//p")));
        for(int i=0; i<archivedList.size(); i++){
            String data = archivedList.get(i).getText().trim();
            if(data.equals(text)){
                Assert.assertEquals(data,text);
            }
        }
        return this;
    }
    public BoardPage verifyDoneIconIsVisible(String doneExpctdMsg){
        //verify done icon is displayed
        boolean isDisplayed = doneIcon.isDisplayed();
        Assert.assertTrue(isDisplayed);
        //verify text in done icon message is displayed
        action.moveToElement(doneIcon).perform();
        waitVisibilityElement(iconMessage);
        String actualMessage = iconMessage.getText();
        Assert.assertEquals(actualMessage, doneExpctdMsg);
        return this;
    }
    public BoardPage verifyBlockedIconIsVisible(String blockedExctdMsg){
        //verify blocked icon is displayed
        boolean isDisplayed = blockedIcon.isDisplayed();
        Assert.assertTrue(isDisplayed);
        //verify text in blocked icon message is displayed
        action.moveToElement(blockedIcon).perform();
        waitVisibilityElement(iconMessage);
        String actualMessage = iconMessage.getText();
        Assert.assertEquals(actualMessage, blockedExctdMsg);
        return this;
    }
    public BoardPage verifyCardIsCreated(String cardTitle){
        //verify card name is displayed inside the list
        List<WebElement> listCard =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("//div[@class='SmallCard_SmallCard__xuek9']/div[3]/h1")));
        for (int i=0; i<listCard.size();i++){
            String actualCardName = listCard.get(i).getText().trim();
            if(actualCardName.equals(cardTitle)){
                Assert.assertEquals(actualCardName,cardTitle);
            }
        }
        return this;
    }
    public BoardPage verifyCardIsNotCreated(){
        Assert.assertTrue(addCardBtnGreen.isDisplayed());
        return this;
    }
    public BoardPage verifyCardIsPrivate(String cardTitle){
        List<WebElement> listCard =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("//div[@class='SmallCard_SmallCard__xuek9']/div[3]/h1")));
        for (int i=0; i<listCard.size();i++){
            String actualCardName = listCard.get(i).getText().trim();
            if(actualCardName.equals(cardTitle)){
                Assert.assertTrue(privateIcon.isDisplayed());
            }
        }
        return this;
    }
    public BoardPage verifyCardTitleIsUpdated(String title) throws InterruptedException {
        waitToBeClickable(cardTitleOnLayer);
        Assert.assertTrue(cardTitleOnLayer.getText().contains(title));
        Thread.sleep(2000);
        clickElement(closeCardContainerBtn);
        return this;
    }
    public BoardPage verifyTheCardIsSorted(String title) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(cardOnTheFirstPosition.getText().contains(title));
        return this;
    }

    /**
     * INTERACTION FUNCTIONS
     */
    public BoardPage clickAddList(){
        clickElement(addListButton);
        return this;
    }
    public BoardPage createList(String text){
        clickElement(inputTitleList);
        writeText(inputTitleList, text);
        clickElement(createListBtn);
        return this;
    }
    public BoardPage clickCancelListBtn(){
        clickElement(cancelListBtn);
        return this;
    }
    public BoardPage clickNavMenu(String text){
        clickElement(navBtn);
        if (text.equals("Archive All Cards")){
            clickElement(archiveAllCardsInThisList);
        } else if (text.equals("Archive List")) {
            clickElement(archiveThisListMenu);
        } else if (text.equals("Set as Complete List")) {
            clickElement(setAsCompleteList);
        } else if (text.equals("Sort From A to Z")) {
            clickElement(sortFromAtoZ);
        } else if (text.equals("Sort From Z to A")) {
            clickElement(sortFromZtoA);
        } else if (text.equals("Sort By Nearest Due Date")) {
            clickElement(sortNearestDate);
        } else if (text.equals("Sort By Furthest Due Date")) {
            clickElement(sortFurthestDate);
        } else if (text.equals("Sort By Nearest Created Date")) {
            clickElement(sortNearestCreatedDate);
        } else if (text.equals("Sort By Furthest Created Date")) {
            clickElement(sortFurthestCreatedDate);
        }
        return this;
    }
    public BoardPage clickArchivedItem(String text) throws InterruptedException {
        clickElement(archivedItemMenu);
        if(text.equals("Switch to List")){
            clickElement(switchBtn);
        }
        Thread.sleep(2000);
        return this;
    }
    public BoardPage closeArchivedItemsMenu(){
        clickElement(closeArchivedItems);
        return this;
    }
    public BoardPage clickRestoreButton(String text) throws InterruptedException {
        Thread.sleep(2000);
        if(text.equals("test")){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", testListRestoreBtn);
            Thread.sleep(2000);
            clickElement(testListRestoreBtn);
        } else{clickElement(firstRestoreButton);}
        return this;
    }
    public BoardPage searchItemToBeRestored(String item){
        clickElement(searchFieldArchivedItem);
        writeText(searchFieldArchivedItem, item);
        return this;
    }
    public BoardPage clickBlockedIcon() throws StaleElementReferenceException, InterruptedException {
        Thread.sleep(7000);
        boolean staleElement = true;
        while(staleElement){
            try{
                clickElement(doneIcon);
                clickElement(blockedBtn);
                staleElement = false;
            } catch (StaleElementReferenceException e){
                staleElement=true;
            }
        }
        return this;
    }
    public BoardPage createCard(String cardTitle, String status) throws InterruptedException {
        Thread.sleep(7000);
        if(status.equals("not private")){
            clickElement(addCardBtn);
            clickElement(inputCardName);
            writeText(inputCardName,cardTitle);
            clickElement(addCardBtnGreen);
        }
        else if(status.equals("private")){
            clickElement(addCardBtn);
            clickElement(inputCardName);
            writeText(inputCardName,cardTitle);
            clickElement(privateCardToggle);
            clickElement(addCardBtnGreen);
        }
        return this;
    }
    public BoardPage updateListTitle(String newTitle){
        waitVisibilityElement(latestCreatedList);
        clickElement(latestCreatedList);
        updateListTitleForm.clear();
        updateListTitleForm.sendKeys(newTitle);
        updateListTitleForm.sendKeys(Keys.ENTER);
        return this;
    }
    public BoardPage clickCard(){
        action.moveToElement(cardOnTheFirstPosition).click().build().perform();
        return this;
    }
    public BoardPage updateCardTitle(String newTitle){
        waitToBeClickable(cardTitleOnLayer);
        cardTitleOnLayer.click();
        inputCardTitleOnLayer.clear();
        inputCardTitleOnLayer.sendKeys(newTitle);
        inputCardTitleOnLayer.sendKeys(Keys.ENTER);
        return this;
    }
    public BoardPage uploadFile(String text){
        ((JavascriptExecutor) driver)
                .executeScript(
                        "document.evaluate('//div[5]/div/div/div/input', document, null, " +
                                "XPathResult.FIRST_ORDERED_NODE_TYPE, null,).singleNodeValue" +
                                ".setAttribute('style', 'display: block;')");
        if(text.equalsIgnoreCase("document")){
            writeText(attachmentInput,
                    "F:\\K. Belajar JAVA\\4. Tugas\\BigProject\\src\\main\\java\\testData\\document.zip");
        }
        return this;
    }
    public BoardPage verifyFileUploaded(String text){
        Assert.assertTrue(attachmentTitle.getText().contains(text));
        clickElement(closeCardContainerBtn);
        return this;
    }
    public BoardPage clickAttachmentButton(String text, String newTitle) throws InterruptedException {
        if (text.equalsIgnoreCase("edit")){
            waitToBeClickable(editAttachmentBtn);
            clickElement(editAttachmentBtn);
            waitVisibilityElement(updateAttachmentTitleField);
            updateListTitleForm.click();
            updateListTitleForm.sendKeys(Keys.chord(Keys.CONTROL + "a"));
            updateListTitleForm.sendKeys(Keys.BACK_SPACE);
            writeText(updateAttachmentTitleField, newTitle);
            Thread.sleep(2000);
            clickElement(updateAttachmentBtn);
        } else if(text.equalsIgnoreCase("delete")){
            waitToBeClickable(deleteAttachmentBtn);
            clickElement(deleteAttachmentBtn);
            waitVisibilityElement(deletePUAttachmentBtn);
            clickElement(deletePUAttachmentBtn);
        }
        return this;
    }
    public BoardPage closeContainer(){
        clickElement(closeCardContainerBtn);
        return this;
    }
    public BoardPage clickCommentField(String function, String text) throws InterruptedException {
        if(function.equalsIgnoreCase("create")){
            action.scrollToElement(commentField);
            clickElement(commentField);
            waitVisibilityElement(commentInputField);
            writeText(commentInputField, text);
            clickElement(postCommentBtn);
            Thread.sleep(1000);
            Assert.assertTrue(commentLatestTimeStamp.getText().contains("just now"));
        } else if (function.equalsIgnoreCase("delete")) {
            action.moveToElement(commentLatestTimeStamp).perform();
            clickElement(navBtnLatestComment);
            waitVisibilityElement(deleteLatestCommentBtn);
            clickElement(deleteLatestCommentBtn);
            waitVisibilityElement(deleteCommentPUBtn);
            clickElement(deleteCommentPUBtn);
            Thread.sleep(2000);
        }
        return this;
    }
    public BoardPage clickLabelButton(String function, String text) throws InterruptedException {
        if(function.equalsIgnoreCase("create")){
            clickElement(labelBtnATC);
            clickElement(addLabelBtn);
            writeText(inputLabelName, text);
            clickElement(labelColor);
            Thread.sleep(1500);
            clickElement(createLabelBtn);
            clickElement(closeLabelPU);
        } else if (function.equalsIgnoreCase("edit")) {
            clickElement(labelBtnATC);
            clickElement(editFirstLabelBtn);
            changeLabelNameInput.click();
            changeLabelNameInput.sendKeys(Keys.chord(Keys.CONTROL + "a"));
            changeLabelNameInput.sendKeys(Keys.BACK_SPACE);
            writeText(changeLabelNameInput, text);
            Thread.sleep(1500);
            clickElement(createLabelBtn);
            clickElement(closeLabelPU);
        } else if (function.equalsIgnoreCase("apply")) {
            clickElement(labelBtnATC);
            clickElement(firstCreatedLabel);
            Thread.sleep(1500);
            clickElement(applyLabelBtn);
            clickElement(closeLabelPU);
        } else if (function.equalsIgnoreCase("delete")) {
            clickElement(labelBtnATC);
            clickElement(editFirstLabelBtn);
            Thread.sleep(1500);
            clickElement(deleteLabelBtn);
            clickElement(closeLabelPU);
        }
        return this;
    }
    public BoardPage clickDueDateButton(String function, String date, String time) throws InterruptedException {
        if(function.equalsIgnoreCase("set")){
            clickElement(dueDateBtnATC);
            dateInput.click();
            dateInput.sendKeys(Keys.chord(Keys.CONTROL + "a"));
            dateInput.sendKeys(Keys.BACK_SPACE);
            writeText(dateInput, date);
            timeInput.click();
            timeInput.sendKeys(Keys.chord(Keys.CONTROL + "a"));
            timeInput.sendKeys(Keys.BACK_SPACE);
            writeText(timeInput, time);
            Thread.sleep(1000);
            clickElement(createLabelBtn);
        } else if (function.equalsIgnoreCase("delete")) {
            clickElement(dueDateBtnATC);
            Thread.sleep(1000);
            clickElement(deleteLabelBtn);
        }
        return this;
    }
    public BoardPage clickPrivateButton(String function) throws InterruptedException {
        if(function.equalsIgnoreCase("private")){
            clickElement(privateBtnAction);
            Thread.sleep(1000);
            Assert.assertTrue(privateIconOnLayer.isDisplayed());
        } else if (function.equalsIgnoreCase("public")){
            clickElement(privateBtnAction);
        }
        return this;
    }
    public String getFirstListArchived() throws InterruptedException {
        Thread.sleep(1000);
        return firstArchivedList.getText();
    }
}
