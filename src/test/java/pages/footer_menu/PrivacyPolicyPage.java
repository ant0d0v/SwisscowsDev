package pages.footer_menu;
import org.openqa.selenium.*;
import pages.base_abstract.FooterMenuPage;

public class PrivacyPolicyPage extends FooterMenuPage<PrivacyPolicyPage> {

    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }

    public PrivacyPolicyPage createGeneric() {

        return new PrivacyPolicyPage(getDriver());
    }



}

