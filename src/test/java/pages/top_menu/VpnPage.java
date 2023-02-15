package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;
import pages.footer_menu.PrivacyPolicyPage;
import pages.footer_menu.WhoWeArePage;

public class VpnPage extends TopMenuPage<VpnPage> {
    @FindBy(xpath = "//div[@class='extensions']//div[1]//img")
    private WebElement imageGoogleExtension;
    @FindBy(xpath = "//img[@src='/images/icon-link-ff.svg']")
    private WebElement imageMozillaExtension;
    @FindBy(xpath = "//img[@src='/images/icon-link-browsers.svg']")
    private WebElement imageOtherExtension;
    @FindBy(xpath = "//div[@class='extensions']")
    private WebElement allExtensionsBlock;
    @FindBy(xpath = "//div[@class='extensions']")
    private WebElement instructionsContainer;



    public VpnPage(WebDriver driver) {
        super(driver);
    }

    public VpnPage createGeneric() {

        return new VpnPage(getDriver());
    }

    public VpnPage switchToVpnPage() {
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (getDriver().getWindowHandles().size() == 1) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }
    public VpnPage closeWindow() {
        getDriver().close();
        return this;

    }
    public VpnPage scrollToWhereToInstructions() {
        scrollByVisibleElement(instructionsContainer);

        return this;
    }
    public VpnPage scrollToWhereExtensionsBlock() {
        scrollByVisibleElement(allExtensionsBlock);

        return this;
    }
    public boolean isGoogleExtensionIconDisplayed() {

        return isElementDisplayed(imageGoogleExtension);
    }
    public boolean isMozillaExtensionIconDisplayed() {

        return isElementDisplayed(imageMozillaExtension);
    }
    public boolean isOtherExtensionIconDisplayed() {

        return isElementDisplayed(imageOtherExtension);
    }

}