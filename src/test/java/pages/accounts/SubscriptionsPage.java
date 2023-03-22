package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class SubscriptionsPage extends FooterMenuPage<SubscriptionsPage> {

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

    public SubscriptionsPage(WebDriver driver) {

        super(driver);
    }

    public SubscriptionsPage createGeneric() {

        return new SubscriptionsPage(getDriver());
    }
}
