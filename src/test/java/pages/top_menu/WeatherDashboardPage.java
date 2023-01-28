package pages.top_menu;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.FooterMenuPage;

public class WeatherDashboardPage extends FooterMenuPage<WeatherDashboardPage> {

    public WeatherDashboardPage(WebDriver driver) {
        super(driver);
    }

    public WeatherDashboardPage createGeneric() {

        return new WeatherDashboardPage(getDriver());
    }
}
