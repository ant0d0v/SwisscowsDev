package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.top_menu.WeatherMapsPage;

import java.util.List;

public class WeatherMapsTest extends BaseTest {

    @Test
    public void testZoomInOutControl() {
        final String expectedZoomIN = "+";
        final String expectedZoomOut = "-";
        final String partialUrl = "http";

        WeatherMapsPage weatherMapsPage = openBaseURL()
                .clickMapsMenu()
                .clickZoomInLoupe()
                .waitUntilUrlContains(partialUrl)
                .clickZoomOutLoupe();

        String actualZoomIN = weatherMapsPage.getZoomInText();
        String actualZoomOUT = weatherMapsPage.getZoomOutText();

        Assert.assertEquals(actualZoomIN, expectedZoomIN);
        Assert.assertEquals(actualZoomOUT, expectedZoomOut);
    }

    @Test
    public void testWeatherControlLayersText() {
        final List<String> expectedLayersTexts = List.of(
                "Temperature",
                "Pressure",
                "Wind speed",
                "Clouds",
                "Global Precipitation"
        );

        List<String> actualLayersTexts =
                openBaseURL()
                        .clickMapsMenu()
                        .getMenusTexts();

        Assert.assertTrue(actualLayersTexts.size() > 0);
        Assert.assertEquals(actualLayersTexts, expectedLayersTexts);
    }

    @Test
    public void testButtonLoop_MapPage() {
        final String locationROME = "Rome, Italy";

        WeatherMapsPage weatherMapsPage = openBaseURL()
                .clickMapsMenu()
                .clickSearchButton();

        Assert.assertTrue(weatherMapsPage.isLoopDisplayBlockDisplayed());

        weatherMapsPage.clickLoopDisplayBlock();
        String oldUrl = String.valueOf(weatherMapsPage.inputSearchCriteriaIntoSearchField(locationROME));

        Assert.assertNotEquals(oldUrl, weatherMapsPage.getCurrentURL());
    }
}
