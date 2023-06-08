package pages.top_menu;

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
    private List<WebElement> allLinksOfPriceContainers;
    @FindBy(xpath = "//div[@class='content']//a")
    private List<WebElement> linksOfEmailPage;
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
    public void clickAllLinksOfPriceContainers(int index) {
        click(getLinksOfPriceContainers().get(index));
        switchToAnotherWindow();
        waitForUrlContains("https://accounts.swisscows.com/login?ReturnUrl");
    }
    public void clickLinksOfEmailPage(int index) {
        click(getLinksOfEmailPage().get(index));
        switchToAnotherWindow();
    }
    public List<WebElement> getLinksOfPriceContainers() {

        return allLinksOfPriceContainers;
    }
    public List<WebElement> getLinksOfEmailPage() {

        return linksOfEmailPage;
    }

    public EmailPage scrollToWhereToInstallEmail() {
        scrollByVisibleElement(InstallWebAppLink);

        return this;
    }


    public List<String> getButtonColorsWhenHover() throws InterruptedException {

        return  getBackgroundHoverColorsOfElements(allLinksOfPriceContainers);
    }
    public List<String> getButtonColors() throws InterruptedException {

        return  getBackgroundColorsOfElements(allLinksOfPriceContainers);
    }
    public List<String> getButtonsStartAndInstallColorsWhenHover() throws InterruptedException {

        return  getBackgroundHoverColorsOfElements(allButtonsOnEmailPage);
    }
    public List<String> getButtonStartAndInstallColors() throws InterruptedException {

        return  getBackgroundColorsOfElements(allButtonsOnEmailPage);
    }
}