package pages.top_menu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;
import java.util.List;



public class EmailPage extends TopMenuPage<EmailPage> {
    @FindBy(xpath = "//a[@class='button']")
    private List<WebElement> allButtonsOnEmailPage;
    @FindBy(xpath = "//div[@class='popup popup-install']//a[@class='button']")
    private WebElement InstallWebAppLink;
    @FindBy(xpath = "//div[@class='static-content']//a[@class='button outline']")
    private List<WebElement> allLinksOnEmailPage;
    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public EmailPage createGeneric() {

        return new EmailPage(getDriver());
    }
    public EmailPage switchToEmailPage() {
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (getDriver().getWindowHandles().size() == 1) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }
    public EmailPage closeWindow() {
        getDriver().close();
        return this;

    }

    public EmailPage scrollToWhereToInstallEmail() {
        scrollByVisibleElement(InstallWebAppLink);

        return this;
    }
    public EmailPage hoverElement() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover', {bubbles: true, cancelable: true}));", InstallWebAppLink);

        return  this;

    }

    public List<String> getButtonColorsWhenHover() throws InterruptedException {

        return  getBackgroundHoverColorsOfElements(allLinksOnEmailPage);
    }
    public List<String> getButtonColors() throws InterruptedException {

        return  getBackgroundColorsOfElements(allLinksOnEmailPage);
    }
    public List<String> getButtonsStartAndInstallColorsWhenHover() throws InterruptedException {

        return  getBackgroundHoverColorsOfElements(allButtonsOnEmailPage);
    }
    public List<String> getButtonStartAndInstallColors() throws InterruptedException {

        return  getBackgroundColorsOfElements(allButtonsOnEmailPage);
    }
}