package pages.footer_menu;
import io.qase.api.annotation.Step;
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
    @Step("Click  privacy microsoft link ")
    public PrivacyPolicyPage clickPrivacyMicrosoftLink() {
        click(privacyMicrosoft);
        switchToAnotherWindow();
        return new PrivacyPolicyPage(getDriver());
    }
    @Step("Scroll to privacy microsoft link ")
    public PrivacyPolicyPage scrollToWherePrivacyMicrosoft() {
        scrollByVisibleElement(privacyMicrosoft);

        return this;
    }

}

