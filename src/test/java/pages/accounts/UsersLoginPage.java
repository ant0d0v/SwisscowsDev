package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import pages.base_abstract.FooterMenuPage;
import utils.ProjectConstants;

public class UsersLoginPage extends FooterMenuPage<UsersLoginPage> {

    @FindBy(xpath = "//input[@class ='input email']")
    private WebElement userEmail;
    @FindBy(xpath = "//input[@type = 'password']")
    private WebElement userPassword;
    @FindBy(xpath = "//button[@class = 'btn-submit']")
    private WebElement submitButton;

    public UsersLoginPage(WebDriver driver) {
        super(driver);
    }

    public UsersLoginPage createGeneric() {

        return new UsersLoginPage(getDriver());
    }

    public UsersLoginPage clickClearInputRegularUserEmail() {
        click(userEmail);
        userEmail.clear();
        String email = ProjectConstants.SWISSCOWS_EMAIL_USER;
        input(email, userEmail);

        return this;
    }

    public UsersLoginPage clickClearInputRegularUserPassword() {
        click(userPassword);
        userPassword.clear();
        String password = ProjectConstants.PASSWORD;
        input(password, userPassword);

        return this;
    }

    public void clickSubmitButton() {
        clickEnter(submitButton);
    }

    public void signInAsRegularUser() {
        clickClearInputRegularUserEmail();
        clickClearInputRegularUserPassword();
        clickSubmitButton();

        new MainPage(getDriver());
    }
}

