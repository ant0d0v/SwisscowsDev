package pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.base_abstract.FooterMenuPage;
import pages.base_abstract.TopMenuPage;

import java.util.ArrayList;
import java.util.List;

public abstract class ProfileTopMenu<Generic> extends TopMenuPage<Generic> {

    @FindBy(xpath = "//li[@class='user-li']/a")
    private WebElement signInTopMenu;

    @FindBy(xpath = "//ul[@id='myTab']/li")
    private List<WebElement> navTabLinks;

    public ProfileTopMenu(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();

    public UsersLoginPage clickSignInMenu() {
        click(signInTopMenu);

        return new UsersLoginPage (getDriver());
    }

    @Override
    public LoginPage signIn() {
        clickSignInMenu()
                .clickClearInputRegularUserEmail()
                .clickClearInputRegularUserPassword()
                .clickSubmitButton();

        return new LoginPage(getDriver());
    }
}