package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class CurrentWeatherPage extends FooterMenuPage<CurrentWeatherPage> {

    @FindBy(xpath = "//section[@id='geo']/div[@class='api']/code")
    private WebElement apiCallTemplate;

    public CurrentWeatherPage(WebDriver driver) {
        super(driver);
    }

    public CurrentWeatherPage createGeneric() {

        return new CurrentWeatherPage(getDriver());
    }

    public String getAPICallTemplate() {
        if (!isElementDisplayed(apiCallTemplate)) {
            wait10ElementToBeVisible(apiCallTemplate);
        }

        return getText(apiCallTemplate);
    }
}
