package pages.top_menu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import pages.base_abstract.TopMenuPage;
import java.util.List;



public class EmailPage extends TopMenuPage<EmailPage> {
    @FindBy(xpath = "//a[@class='button']")
    private List<WebElement> allButtonsOnEmailPage;
    @FindBy(xpath = "//div[@class='popup popup-install']//a[@class='button']")
    private WebElement InstallWebAppLink;
    @FindBy(xpath = "//div[@class='static-content']//a[@class='button outline']")
    private List<WebElement> allLinksOnEmailPage;
    @FindBy(xpath = "//a[@href='https://swisscows.email/en/help']")
    private WebElement supportButton;
    @FindBy(xpath = "//div[@class='content']//a[@href='https://accounts.swisscows.com/register']")
    private WebElement StartForFreeLink;
    @FindBy(xpath = "//div[@class='content']//a[@href='https://swisscows.email/mbox/index.php/login/oauth']")
    private WebElement loginLink;
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
    public EmailPage clickSupportButton() {
        click(supportButton);
        return new  EmailPage(getDriver());
    }
    public EmailPage clickStartForFreeLink() {
        click(StartForFreeLink);
        return new  EmailPage(getDriver());
    }
    public EmailPage clickLoginLink() {
        click(loginLink);
        return new  EmailPage(getDriver());
    }

    public EmailPage scrollToWhereToInstallEmail() {
        scrollByVisibleElement(InstallWebAppLink);

        return this;
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