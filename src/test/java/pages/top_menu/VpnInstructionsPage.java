package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import pages.base_abstract.TopMenuPage;

public class VpnInstructionsPage extends TopMenuPage<VpnInstructionsPage> {
    @FindBy(xpath = "//a[@class ='extension popup'][1]")
    private WebElement vpnChromeLink;
    @FindBy(xpath = "//a[@class ='extension popup'][2]")
    private WebElement vpnMozillaLink;
    public VpnInstructionsPage(WebDriver driver) {
        super(driver);
    }

    public VpnInstructionsPage createGeneric() {

        return new VpnInstructionsPage(getDriver());
    }
    public VpnInstructionsPage goToExternalPage() {
        switchToExternalPage();
        return this;
    }
    public VpnInstructionsPage clickVpnChromeLink() {
        click(vpnChromeLink);

        return new VpnInstructionsPage(getDriver());
    }
    public VpnInstructionsPage clickVpnMozillaLink() {
        click(vpnMozillaLink);

       return new VpnInstructionsPage(getDriver());
    }
}
