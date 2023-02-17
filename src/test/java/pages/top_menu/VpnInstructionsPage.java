package pages.top_menu;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.TopMenuPage;

public class VpnInstructionsPage extends TopMenuPage<VpnInstructionsPage> {

    public VpnInstructionsPage(WebDriver driver) {
        super(driver);
    }

    public VpnInstructionsPage createGeneric() {

        return new VpnInstructionsPage(getDriver());
    }
}