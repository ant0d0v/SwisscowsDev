package pages.footer_menu;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class PrivacyPolicyPage extends FooterMenuPage<PrivacyPolicyPage> {
    @FindBy(xpath = "//a[text() = 'https://privacy.microsoft.com/en-us/privacystatement']")
    private WebElement privacyMicrosoft;
    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }

    public PrivacyPolicyPage createGeneric() {

        return new PrivacyPolicyPage(getDriver());
    }
    public PrivacyPolicyPage clickPrivacyMicrosoftLink() {
        click(privacyMicrosoft);
        switchToAnotherWindow();
        return new PrivacyPolicyPage(getDriver());
    }
    public PrivacyPolicyPage scrollToWherePrivacyMicrosoft() {
        scrollByVisibleElement(privacyMicrosoft);

        return this;
    }

}

