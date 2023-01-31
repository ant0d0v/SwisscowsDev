package pages.top_menu;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.FooterMenuPage;
import pages.base_abstract.TopMenuPage;

public class VpnPage extends TopMenuPage<VpnPage> {

    public VpnPage(WebDriver driver) {
        super(driver);
    }

    public VpnPage createGeneric() {

        return new VpnPage(getDriver());
    }
}