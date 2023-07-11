package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class RegisterPage extends FooterMenuPage<RegisterPage> {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage createGeneric() {

        return new RegisterPage(getDriver());
    }

}
