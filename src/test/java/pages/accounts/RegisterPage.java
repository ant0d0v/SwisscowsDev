package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class RegisterPage extends FooterMenuPage<RegisterPage> {

    @FindBy(xpath = "//input[@id='user_username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement enterEmailField;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//input[@id='user_password_confirmation']")
    private WebElement repeatUserPasswordField;

    @FindBy(xpath = "//input[@id='agreement_is_age_confirmed']")
    private WebElement ageConfirmCheckbox;

    @FindBy(xpath = "//input[@id='agreement_is_accepted']")
    private WebElement agreementCheckbox;

    @FindBy(xpath = "//input[@id='mailing_system']")
    private WebElement mailingSystemCheckbox;

    @FindBy(xpath = "//input[@id='mailing_product']")
    private WebElement mailingProductCheckbox;

    @FindBy(xpath = "//input[@id='mailing_news']")
    private WebElement mailingNewsCheckbox;

    @FindBy(xpath = "//input[@value='Create Account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//div[contains(text(),'Privacy Centre')]/a[.='Privacy Policy']")
    private WebElement privacyPolicy;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage createGeneric() {

        return new RegisterPage(getDriver());
    }

    public RegisterPage clickClearInputNewUsername() {
        String username = "Tester";

        click(usernameField);
        usernameField.clear();
        input(username, usernameField);

        return this;
    }

    public RegisterPage clickClearInputNewUserEmail() {
        String email = "jka59433@xcoxc.com";

        click(enterEmailField);
        enterEmailField.clear();
        input(email, enterEmailField);

        return this;
    }

    public RegisterPage clickClearInputNewUserPassword() {
        String password = "Tester12#";

        click(userPasswordField);
        userPasswordField.clear();
        input(password, userPasswordField);

        return this;
    }

    public RegisterPage clickClearInputRepeatPassword() {
        String password = "Tester12#";

        click(repeatUserPasswordField);
        repeatUserPasswordField.clear();
        input(password, repeatUserPasswordField);

        return this;
    }

    public RegisterPage clickAgeConfirmCheckbox() {
        click(ageConfirmCheckbox);

        return this;
    }

    public RegisterPage clickAgreementCheckbox() {
        click(agreementCheckbox);

        return this;
    }

    public RegisterPage clickCreateAccountButton() {
        click(createAccountButton);

        return new RegisterPage(getDriver());
    }

    public void clickPrivacyPolicy() {
        click20(privacyPolicy);
    }
}
