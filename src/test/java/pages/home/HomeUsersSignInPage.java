package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class HomeUsersSignInPage extends FooterMenuPage<HomeUsersSignInPage> {

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

    @FindBy(id = "user_remember_me")
    private WebElement rememberMe;


    public HomeUsersSignInPage(WebDriver driver) {
        super(driver);
    }

    public HomeUsersSignInPage createGeneric() {

        return new HomeUsersSignInPage(getDriver());
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

    public HomeUsersSignInPage clickClearInputRegularUserEmail() {
        click(userEmail);
        userEmail.clear();
        String email = "jka59433@xcoxc.com";
        input(email, userEmail);

        return this;
    }

    public HomeUsersSignInPage clickClearInputRegularUserEmail(String email) {
        click(userEmail);
        userEmail.clear();
        input(email, userEmail);

        return this;
    }

    public HomeUsersSignInPage clickClearInputRegularUserPassword() {
        click(userPassword);
        userPassword.clear();
        String password = "Tester12#";
        input(password, userPassword);

        return this;
    }

    public HomeUsersSignInPage clickClearInputRegularUserPassword(String password) {
        click(userPassword);
        userPassword.clear();
        input(password, userPassword);

        return this;
    }

    public void clickSubmitButton() {
        click20(submitButton);
    }

    public void signInAsRegularUser() {
        clickClearInputRegularUserEmail();
        clickClearInputRegularUserPassword();
        clickSubmitButton();

        new HomePage(getDriver());
    }

    public HomeUsersSignUpPage clickCreateAnAccountLink() {
        click(createAccountLink);

        return new HomeUsersSignUpPage(getDriver());
    }

    public HomeUsersSignInPage checkRemeberMeCheckBox() {
        if (!rememberMe.isSelected())
            click(rememberMe);
        return this;
    }
}
