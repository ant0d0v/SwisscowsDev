package pages.top_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;
import pages.footer_menu.PrivacyPolicyPage;
import pages.footer_menu.WhoWeArePage;

import java.util.List;

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

    @FindBy(xpath = "//div[@class='static-content']//div[@class= 'subs']//a//p[5]")
    private List<WebElement> allLinksOnVpnPage;
    @FindBy(xpath = "//div[@class='static-content']//a[1]")
    private WebElement startNowButtonVpnPage;

    public VpnPage(WebDriver driver) {
        super(driver);
    }

    public VpnPage createGeneric() {

        return new VpnPage(getDriver());
    }
    @Step("Switch to vpn page")
    public VpnPage switchToVpnPage() {
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (getDriver().getWindowHandles().size() == 1) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }
    @Step("Scroll to where instructions")
    public VpnPage scrollToWhereToInstructions() {
        scrollByVisibleElement(instructionsContainer);
        return this;
    }
    @Step("Scroll to where extensions block ")
    public VpnPage scrollToWhereExtensionsBlock() {
        scrollByVisibleElement(allExtensionsBlock);
        return this;
    }
    @Step("Check that google extension icon is displayed")
    public boolean isGoogleExtensionIconDisplayed() {
        return isElementDisplayed(imageGoogleExtension);
    }
    @Step("Check that mozilla extension icon is displayed")
    public boolean isMozillaExtensionIconDisplayed() {
        return isElementDisplayed(imageMozillaExtension);
    }
    @Step("Check that other extension icon is displayed")
    public boolean isOtherExtensionIconDisplayed() {

        return isElementDisplayed(imageOtherExtension);
    }
    @Step("Get color buttons when hovering")
    public List<String> getButtonColorsWhenHover() throws InterruptedException {

        return  getBackgroundHoverColorsOfElements(allLinksOnVpnPage);
    }
    @Step("Get color buttons without hover")
    public List<String> getButtonColors() throws InterruptedException {
        return  getBackgroundColorsOfElements(allLinksOnVpnPage);
    }
    @Step("Get color start now button without hover")
    public String backgroundColorOfElement() {
        return getBackgroundHoverColor(startNowButtonVpnPage);

    }
    @Step("Hover to button")
    public VpnPage hoverElement(){
        hover(startNowButtonVpnPage);
        return  this;

    }

}