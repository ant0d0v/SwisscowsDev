package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class LoginPage extends FooterMenuPage<LoginPage> {

    @FindBy(xpath = "//div[@class = 'panel-body']")
    WebElement notification;
    @FindBy(id = "user_email")
    private WebElement userEmail;
    @FindBy(id = "user_password")
    private WebElement userPassword;
    @FindBy(name = "commit")
    private WebElement submitButton;
    @FindBy(xpath = "//a[@href='/users/sign_up']")
    private WebElement createAccountLink;
    @FindBy(xpath = "//a[@href='#']")
    private WebElement clickHereToRecoverLink;
    @FindBy(xpath = "//h3")
    private WebElement h3Header;
    @FindBy(xpath = "//div[@id='desktop-menu']//li[@class='user-li']/a")
    private WebElement signInTopMenu;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage createGeneric() {

        return new LoginPage(getDriver());
    }

    public String getNotification() {

        return getText(notification);
    }

    public String getWelcomeMessage() {

        return getText(h3Header);
    }

    public String getSignInText() {

        return getText(signInTopMenu);
    }

    public LoginPage clickClearInputRegularUserEmail() {
        click(userEmail);
        userEmail.clear();
        String email = "jka59433@xcoxc.com";
        input(email, userEmail);

        return this;
    }

    public LoginPage clickClearInputRegularUserEmail(String email) {
        click(userEmail);
        userEmail.clear();
        input(email, userEmail);

        return this;
    }

    public LoginPage clickClearInputRegularUserPassword() {
        click(userPassword);
        userPassword.clear();
        String password = "Tester12#";
        input(password, userPassword);

        return this;
    }

    public LoginPage clickClearInputRegularUserPassword(String password) {
        click(userPassword);
        userPassword.clear();
        input(password, userPassword);

        return this;
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public void signInAsRegularUser() {
        clickClearInputRegularUserEmail();
        clickClearInputRegularUserPassword();
        clickSubmitButton();

        new ProfilePage (getDriver());
    }


}
