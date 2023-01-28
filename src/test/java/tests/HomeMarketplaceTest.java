package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.home.HomeMarketplacePage;
import pages.home.HomeZipCodeDataNewPage;

import java.util.List;

public class HomeMarketplaceTest extends BaseTest {

    @Test
    public void testButtonsAreVisibleAndClickable() {
        int count = 0;

        HomeMarketplacePage homeMarketplacePage = new HomeMarketplacePage(getDriver());

        List<WebElement> allButtons = openBaseURL()
                .clickMarketplaceMenu()
                .switchToMarketplaceWindow()
                .getAllHomeMarketplaceButtons();

        for (WebElement button : allButtons) {
            if (button.isEnabled() && button.isDisplayed()) {
                homeMarketplacePage.waitUntilButtonIsClickable(button);
                count++;
            }
        }

        Assert.assertEquals(count, allButtons.size());
    }

    @Test
    public void testWeatherDataByStateLink_NavigatesTo_HomeZipCodeDataPage() {
        final String expectedURL = "https://home.openweathermap.org/zip_code_data/new";
        final String expectedTitle = "Marketplace: History Bulk, History Forecast Bulk, Historical Weather Data by State for all ZIP codes, USA - OpenWeather";

        final String oldURL = openBaseURL()
                .clickMarketplaceMenu()
                .switchToMarketplaceWindow()
                .getCurrentURL();

        HomeZipCodeDataNewPage homeZipCodeDataNewPage = new HomeZipCodeDataNewPage(getDriver());

        homeZipCodeDataNewPage.clickWeatherDataByStateMenu();

        String actualURL = homeZipCodeDataNewPage.getCurrentURL();
        String actualTitle = homeZipCodeDataNewPage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
