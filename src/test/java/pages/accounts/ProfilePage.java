package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends ProfileTopMenu<ProfilePage> {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage createGeneric() {

        return new ProfilePage(getDriver());
    }
}
