package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;
import pages.footer_menu.PrivacyPolicyPage;
import pages.footer_menu.WhoWeArePage;

public class VpnInstructions extends TopMenuPage<VpnInstructions> {

    public VpnInstructions(WebDriver driver) {
        super(driver);
    }

    public VpnInstructions createGeneric() {

        return new VpnInstructions(getDriver());
    }
}