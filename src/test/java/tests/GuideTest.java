package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RoadRiskAPIPage;
import pages.SolarRadiationAPIPage;
import pages.top_menu.GuidePage;

public class GuideTest extends BaseTest {

    @Test
    public void testHomeLinkNavigatesToBaseURL() {
        final String expectedBaseURL = "https://openweathermap.org/";
        final String expectedGuideURL = "https://openweathermap.org/guide";

        String baseURL = openBaseURL().getCurrentURL();

        String guideURL = new MainPage(getDriver())
                .clickGuideMenu()
                .getCurrentURL();

        Assert.assertNotEquals(guideURL, baseURL);
        Assert.assertEquals(guideURL, expectedGuideURL);

        String actualURL = new GuidePage(getDriver())
                .clickHomeLink()
                .waitForGreyContainerDisappeared()
                .getCurrentURL();

        Assert.assertNotEquals(actualURL, guideURL);
        Assert.assertEquals(actualURL, baseURL);
        Assert.assertEquals(actualURL, expectedBaseURL);
    }

    @Test
    public void testSolarRadiationApiLink_NavigatesTo_SolarRadiationApiPage() {
        final String expectedUrl = "https://openweathermap.org/api/solar-radiation";
        final String expectedTitle = "Solar radiation API - OpenWeatherMap";

        String oldURL = openBaseURL()
                .clickGuideMenu()
                .getCurrentURL();

        String actualURL = new GuidePage(getDriver()).scrollToDedicatedWeatherProducts()
                .clickSolarRadiationLink()
                .getCurrentURL();

        SolarRadiationAPIPage solarRadiationAPIPage = new SolarRadiationAPIPage(getDriver());

        String actualTitle = solarRadiationAPIPage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testRoadRiskAPILink_NavigatesTo_RoadRiskAPIPage() {
        final String expectedURL = "https://openweathermap.org/api/road-risk";
        final String expectedTitle = "Road Risk - OpenWeatherMap";

        String oldURL = openBaseURL()
                .clickGuideMenu()
                .getCurrentURL();

        String actualURL = new GuidePage(getDriver())
                .clickRoadRiskAPILink()
                .getCurrentURL();

        String actualTitle = new RoadRiskAPIPage(getDriver()).getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testLearnMoreButtonsAmount() {
        final int expectedAmount = 5;

        int actualAmount = openBaseURL()
                .clickGuideMenu()
                .countLearnMoreButtons();

        Assert.assertEquals(actualAmount, expectedAmount);
    }
}
