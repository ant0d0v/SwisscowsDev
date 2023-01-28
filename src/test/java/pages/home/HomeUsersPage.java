package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeUsersPage extends HomeUsersSignUpPage {

    @FindBy(xpath = "//div[@class='has-error']/div[@class='help-block']")
    private WebElement errorCaptchaMessage;

    public HomeUsersPage(WebDriver driver) {
        super(driver);
    }

    public String getErrorCaptchaMessage() {

        return getText(errorCaptchaMessage);
    }
}
