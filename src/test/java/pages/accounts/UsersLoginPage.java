package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import pages.base_abstract.FooterMenuPage;

public class UsersLoginPage extends FooterMenuPage<UsersLoginPage> {

    @FindBy(xpath = "//div[@class = 'panel-body']")
    WebElement notification;
    @FindBy(xpath = "//input[@class ='input email']")
    private WebElement userEmail;
    @FindBy(xpath = "//input[@type = 'password']")
    private WebElement userPassword;
    @FindBy(xpath = "//button[@class = 'btn-submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//a[@href='/users/sign_up']")
    private WebElement createAccountLink;
    @FindBy(xpath = "//a[@href='#']")
    private WebElement clickHereToRecoverLink;
    @FindBy(xpath = "//h3")
    private WebElement h3Header;
    @FindBy(xpath = "//div[@id='desktop-menu']//li[@class='user-li']/a")
    private WebElement signInTopMenu;

    public UsersLoginPage(WebDriver driver) {
        super(driver);
    }

    public UsersLoginPage createGeneric() {

        return new UsersLoginPage(getDriver());
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

    public UsersLoginPage clickClearInputRegularUserEmail() {
        click(userEmail);
        userEmail.clear();
        String email = "a.qa@swisscows.email";
        input(email, userEmail);

        return this;
    }

    public UsersLoginPage clickClearInputRegularUserEmail(String email) {
        click(userEmail);
        userEmail.clear();
        input(email, userEmail);

        return this;
    }

    public UsersLoginPage clickClearInputRegularUserPassword() {
        click(userPassword);
        userPassword.clear();
        String password = "2075Deltuha";
        input(password, userPassword);

        return this;
    }

    public UsersLoginPage clickClearInputRegularUserPassword(String password) {
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

        new MainPage(getDriver());
    }
    public LoginPage signInTopMenu() {
        clickSignInMenu();
        switchToAnotherWindow();
        signInAsRegularUser();
        return new LoginPage(getDriver());
    }

    public UsersLoginPage clickCreateAnAccountLink() {
        click(createAccountLink);

        return new UsersLoginPage(getDriver());
    }
}

