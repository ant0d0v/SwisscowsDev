package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class LoginPage extends FooterMenuPage<LoginPage> {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage createGeneric() {

        return new LoginPage(getDriver());
    }
}
