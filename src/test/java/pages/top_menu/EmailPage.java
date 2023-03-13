package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import pages.accounts.RegisterPage;
import pages.base_abstract.TopMenuPage;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;


public class EmailPage extends TopMenuPage<EmailPage> {
    @FindBy(xpath = "//a[@href='https://swisscows.email/mbox/index.php/login/oauth'][text()='install web-app']")
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
    public EmailPage hoverElement(){
        hover(InstallWebAppLink);
        return  this;

    }

    public String backgroundColorOfElement() {
        return getBackgroundHoverColor(InstallWebAppLink);

    }
    public List<String> getButtonColorsWhenHover() throws InterruptedException {

        return  getBackgroundHoverColorsOfElements(allLinksOnEmailPage);
    }
    public List<String> getButtonColors() throws InterruptedException {

        return  getBackgroundColorsOfElements(allLinksOnEmailPage);
    }
}