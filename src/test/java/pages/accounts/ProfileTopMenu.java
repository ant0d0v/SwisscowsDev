package pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.base_abstract.FooterMenuPage;

import java.util.ArrayList;
import java.util.List;

public abstract class ProfileTopMenu<Generic> extends FooterMenuPage<Generic> {

    @FindBy(xpath = "//li[@class='user-li']/a")
    private WebElement signInTopMenu;

    @FindBy(xpath = "//ul[@id='myTab']/li")
    private List<WebElement> navTabLinks;

    public ProfileTopMenu(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();

    public int getHomeTopMenusAmount() {

        return getListSize(navTabLinks);
    }

    public UsersLoginPage clickSignInMenu() {
        click(signInTopMenu);

        return new UsersLoginPage (getDriver());
    }

    public List<String> clickHomeTopMenus() {
        List<String> urlList = new ArrayList<>();
        urlList.add(getCurrentURL());

        for (int i = 1; i < navTabLinks.size(); i++) {
            click(navTabLinks.get(i));
            urlList.add(getCurrentURL());

            if (i == 6) {
                goBack();
            }
        }

        return urlList;
    }

    public LoginPage signOut() {
        click(getDriver().findElement(By.id("user-dropdown")));
        click(getDriver().findElement(By.xpath("//a[@href='/users/sign_out']")));
        Reporter.log(getDriver().findElement(By.xpath("//h3")).getText(), true);

        return new LoginPage(getDriver());
    }

    public ProfilePage signIn() {
        clickSignInMenu()
                .clickClearInputRegularUserEmail()
                .clickClearInputRegularUserPassword()
                .clickSubmitButton();

        return new ProfilePage(getDriver());
    }
}
