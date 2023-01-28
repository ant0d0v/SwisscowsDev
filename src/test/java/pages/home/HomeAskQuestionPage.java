package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class HomeAskQuestionPage extends FooterMenuPage<HomeAskQuestionPage> {

    @FindBy(id = "question_form_email")
    private WebElement emailTextBox;

    @FindBy(id = "question_form_subject")
    private WebElement subjectTextBox;

    @FindBy(id = "question_form_message")
    private WebElement messageTextBox;

    @FindBy(xpath = "//div[@class='col-sm-8']//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='help-block']")
    private WebElement errorMessage;

    @FindBy(xpath = "//input[@id = 'question_form_is_user_true']")
    private WebElement yesRadioButton;

    @FindBy(xpath = "//input[@id = 'question_form_is_user_false']")
    private WebElement noRadioButton;

    @FindBy(xpath = "//input[@id='question_form_email']/following-sibling::span[@class = 'help-block']")
    private WebElement emailHelpBlock;

    @FindBy(xpath = "//select[@id = 'question_form_subject']/following-sibling::span[@class = 'help-block']")
    private WebElement subjectHelpBlock;

    @FindBy(xpath = "//select[@id = 'question_form_subject']//option[@value= 'Sales']")
    private WebElement salesSubjectSelect;

    @FindBy(xpath = "//select[@id = 'question_form_subject']//option[@value= 'Data Issue']")
    private WebElement dataIssueSubjectSelect;

    @FindBy(xpath = "//select[@id = 'question_form_subject']//option[@value= 'Tech Issue']")
    private WebElement techIssueSubjectSelect;

    @FindBy(xpath = "//select[@id = 'question_form_subject']//option[@value= 'Initiatives']")
    private WebElement initiativesSubjectSelect;

    @FindBy(xpath = "//select[@id = 'question_form_subject']//option[@value= 'Other']")
    private WebElement otherSubjectSelect;

    @FindBy(xpath = "//textarea[@id = 'question_form_message']/following-sibling::span[@class = 'help-block']")
    private WebElement messageHelpBlock;

    @FindBy(xpath = "//div[@id='rc-anchor-container']")
    private WebElement captchaContainer;

    @FindBy(xpath = "//div[@class = 'recaptcha-checkbox-checkmark']")
    private WebElement captchaCkeckbox;

    @FindBy(xpath = "//div[@class = 'has-error']/div[@class = 'help-block']")
    private WebElement captchaHelpBlock;

    @FindBy(xpath = "//div[@id='prompt']")
    private WebElement enterYourAccountMessage;

    @FindBy(xpath = "//div[@class = 'panel-body']")
    private WebElement questionSentMessage;

    public HomeAskQuestionPage(WebDriver driver) {
        super(driver);
    }

    public HomeAskQuestionPage createGeneric() {

        return new HomeAskQuestionPage(getDriver());
    }

    public String getErrorMessageText() {

        return getText(errorMessage);
    }

    public String getRadioButtonText() {

        return getText(enterYourAccountMessage);
    }

    public HomeAskQuestionPage clickOnSubmitButton() {
        click(submitButton);

        return this;
    }

    public HomeAskQuestionPage clickYesRadioButton() {
        click(yesRadioButton);

        return this;
    }

    public HomeAskQuestionPage selectSubject() {
        click(subjectTextBox);

        return this;
    }

    public HomeAskQuestionPage selectTechQuestionsInSubjectSubmenu() {
        click(subjectTextBox);
        click(techIssueSubjectSelect);

        return this;
    }

    public HomeAskQuestionPage inputTextInEmailTextbox(String text) {
        input(text, emailTextBox);

        return this;
    }

    public HomeAskQuestionPage inputTextInMessageTextbox(String text) {
        input(text, messageTextBox);

        return this;
    }

    public HomeAskQuestionPage selectSubject(String text) {
        selectOption(subjectTextBox, text);

        return this;
    }
}
