package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.footer_menu.WidgetsPage;
import utils.ProjectConstants;

import java.util.List;

public class WidgetsTest extends BaseTest {

    @Test
    public void testSelectYourCityFieldContainsChosenCity() throws InterruptedException {
        final String city = "Rome";

        WidgetsPage widgetPage = openBaseURL()
                .scrollToFooterMenu()
                .clickWidgetsPageFooterMenu();

        sleep(1000);

        final String oldCity = widgetPage.getCityName();

        final String newCity = widgetPage
                .inputYourAPIKey(ProjectConstants.WIDGETS_KEY)
                .inputYourCityName(city)
                .clickSearchCityButton()
                .waitCityFromSelectCityToBeChanged(oldCity)
                .getCityName();
        Reporter.log("City changed to ------" + newCity, true);

        Assert.assertNotEquals(newCity, oldCity);

        List<String> actualCitiesTexts = widgetPage.getSelectedCityTexts();
        Reporter.log("Actual list of cities is -------" + actualCitiesTexts, true);

        for (String actualCity : actualCitiesTexts) {
            Assert.assertTrue(actualCity.contains(city));
        }
    }

    @Test
    public void testErrorMessage_WhenEnteringInvalidAPIKeyInWidgetForm() {

        final String apiKey = "6a7ee29a7bc59ae512514cf9d4e49";
        final String expectedErrorMessage = "Validation error";
        final String cityName = "Athens";

        WidgetsPage widgetPage = openBaseURL()
                .scrollToFooterMenu()
                .clickWidgetsPageFooterMenu();

        final String oldCity = widgetPage.getCityName();
        Reporter.log("Old city was --------" + oldCity, true);

        final String newCity = widgetPage
                .inputYourAPIKey(apiKey)
                .inputYourCityName(cityName)
                .clickSearchCityButton()
                .waitCityFromSelectCityToBeChanged(oldCity)
                .getCityName();
        Reporter.log("City changed to ------" + newCity, true);

        String actualErrorMessage = widgetPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void testAllWidgetsDisplayChosenCity() throws InterruptedException {
        final String key = "20cbbe5f82ae947874eb39f29f8ffbe1";
        final String cityCountry = "Rome, US";

        WidgetsPage widgetPage = openBaseURL()
                .scrollToFooterMenu()
                .clickWidgetsPageFooterMenu();

        sleep(1000);

        final String oldCity = widgetPage
                .waitForBiggerWidgetToAppear()
                .getCityNameWidget();
        Reporter.log("Old city was --------" + oldCity, true);

        final String newCity = widgetPage.inputYourAPIKey(key)
                .inputYourCityName(cityCountry)
                .clickSearchCityButton()
                .waitCityToBeChanged(oldCity)
                .getCityNameWidget();
        Reporter.log("City changed to ------" + newCity, true);

        Assert.assertNotEquals(newCity, oldCity);

        List<String> allWidgetsTexts = widgetPage.getAllWidgetsCityName();
        Reporter.log("The size of the allWidgetsTexts is "
                + allWidgetsTexts.size() + "\nList of widget's cities  ----- " + allWidgetsTexts, true);

        for (String cityName : allWidgetsTexts) {
            Assert.assertEquals(cityName, cityCountry);
        }
    }
}
