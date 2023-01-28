package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.PartnersPage;

import java.util.List;

public class PartnersTest extends BaseTest {

    @Test
    public void testH1Header() {
        final String expectedHeader = "Partners and solutions";

        String actualHeader = openBaseURL()
                .clickPartnersMenu()
                .getH1Header();

        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void testSeeOnTheWebsiteButtonNavigatesToApacheWebsite() {
        final String expectedURL = "https://camel.apache.org/components/next/weather-component.html";

        PartnersPage partnersPage = openBaseURL()
                .clickPartnersMenu();

        String oldURL = partnersPage.getCurrentURL();

        partnersPage
                .clickApacheCamelLink()
                .clickSeeOnWebsiteButton();

        new MainPage(getDriver()).switchToExternalPage();

        Assert.assertNotEquals(oldURL, getExternalPageURL());
        Assert.assertEquals(getExternalPageURL(), expectedURL);
    }

    @Test
    public void testLinksTextsAreAsExpected() {
        final List<String> expectedRightSideLinks = List.of(
                "Google Weather-Based Campaign Management with OpenWeatherMap API"
                , "Google Maps JavaScript API based on OpenWeatherMap API"
                , "OpenWeather current weather data in Mozilla's IoT project"
                , "Ubuntu"
                , "Android"
                , "Leaflet"
                , "Java"
                , "Go (golang)"
                , "JavaScript"
                , "CMS"
                , "Raspberry Pi"
                , "Python"
                , "PHP"
                , "Apache Camel"
                , "Desktop"
                , "Mobile applications"
                , "Big library on GitHub"
        );

        List<String> actualRightSideLinks = openBaseURL()
                .clickPartnersMenu()
                .getRightSideLinksText();

        Assert.assertEquals(actualRightSideLinks, expectedRightSideLinks);
    }
}
