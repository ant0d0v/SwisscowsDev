package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends ProfileTopMenu<ProfilePage> {

    @FindBy(xpath = "//div[@class = 'panel-body']")
    WebElement notification;

    @FindBy(id = "user-dropdown")
    WebElement userTopMenu;

    @FindBy(xpath = "//ul[@id='user-dropdown-menu']/li")
    List<WebElement> userDropdownMenuLinks;

    @FindBy(xpath = "//ul[@id='myTab']//a[@href='/api_keys']")
    private WebElement apiKeysTab;

    @FindBy(xpath = "//h2")
    private List<WebElement> h2Headers;

    @FindBy(className = "btn_like")
    private List<WebElement> orangeButtons;

    @FindBy(xpath = "//ul[@class='nav nav-tabs pull-left']//a")
    private List<WebElement> navTabs;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage createGeneric() {

        return new ProfilePage(getDriver());
    }

    public String getNotification() {

        return getText(notification);
    }

    public List<String> getUserNameDropdownMenuTexts() {

        return getTexts(userDropdownMenuLinks);
    }

    public List<String> getListH2Headers() {

        return getTexts(h2Headers);
    }

    public String getUserMenuText() {

        return getText(userTopMenu);
    }

    public ProfilePage clickUserNameMenu() {
        click(userTopMenu);

        return this;
    }

    public List<WebElement> getOrangeButtons() {

        return orangeButtons;
    }

    public void waitUntilButtonIsClickable(WebElement button) {

        wait10ElementToBeClickable(button);
    }
}
