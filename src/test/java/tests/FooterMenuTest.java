package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.WeatherStationsPage;
import pages.footer_menu.AboutUsPage;
import pages.footer_menu.TechnologyPage;
import pages.footer_menu.WidgetsPage;
import pages.home.HomeAskQuestionPage;
import pages.top_menu.PricePage;
import pages.top_menu.WeatherDashboardPage;
import tests.retrytest.Retry;
import utils.TestUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FooterMenuTest extends BaseTest {

    @Test
    public void testSocialPanelIconsNavigateToCorrespondingWebSites() {
        final List<String> links = List.of(
                "https://www.facebook.com/groups/270748973021342/?mibextid=6NoCDW",
                "https://twitter.com/OpenWeatherMap",
                "https://www.linkedin.com/uas/login?session_redirect=%2Fcompany%2F9816754",
                "https://openweathermap.medium.com/",
                "https://t.me/openweathermap",
                "https://github.com/search?q=openweathermap&ref=cmdform]"
        );

        final List<String> expectedDomains = List.of(
                "www.facebook.com",
                "twitter.com",
                "www.linkedin.com",
                "openweathermap.medium.com",
                "t.me",
                "github.com"
        );

        Assert.assertEquals(links.size(), expectedDomains.size());

        for (int i = 0; i < links.size(); i++) {
            String expectedDomain = expectedDomains.get(i);

            URL url = null;
            try {
                url = new URL(links.get(i));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            Assert.assertNotNull(url);

            String actualDomain = url.getHost();

            Assert.assertEquals(actualDomain, expectedDomain);
        }
    }

    @Test
    public void testStorePanelExistsAndHasIcons() {
        final int expectedQuantity = 2;

        MainPage mainPage = openBaseURL()
                .scrollToFooterMenu();

        Assert.assertTrue(mainPage.isStorePanelDisplayed(), " StorePanel is not displayed ");
        Assert.assertEquals(mainPage.getStoresIconsCount(), expectedQuantity);
    }

    @Test
    public void testSocialPanelExistsAndHasIcons() {
        final int expectedIconsQuantity = 6;

        MainPage mainPage = openBaseURL()
                .scrollToFooterMenu();

        Assert.assertTrue(mainPage.isSocialPanelDisplayed(), " SocialPanel is not displayed ");
        Assert.assertEquals(mainPage.getSocialPanelSize(), expectedIconsQuantity);
    }

    @Test
    public void testSubscriptionText() {
        List<String> expectedSubscriptionTexts = List.of(
                "How to start",
                "Pricing",
                "Subscribe for free",
                "FAQ"
        );

        List<String> actualSubscriptionTexts =
                openBaseURL()
                        .scrollToSubscriptionFooterMenu()
                        .getSubscriptionMenusTexts();

        Assert.assertTrue(actualSubscriptionTexts.size() > 0);
        Assert.assertEquals(actualSubscriptionTexts, expectedSubscriptionTexts);
    }

    @Test
    public void testOurTechnologyFooterLinkNavigatesToTechnologyPage() {
        final String expectedURL = "https://openweathermap.org/technology";
        final String expectedTitle = "Weather model - OpenWeatherMap";

        final String oldURL = openBaseURL().getCurrentURL();

        TechnologyPage technologyPage = new MainPage(getDriver())
                .scrollToFooterMenu()
                .clickOurTechnologyFooterMenu();

        String actualTitle = technologyPage.getTitle();
        String actualURL = technologyPage.getCurrentURL();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testPrivacyPolicyFooterLinkNavigatesToPrivacyPolicyWeb() {
        final String expectedURL = "https://openweather.co.uk/privacy-policy";
        final String expectedTitle = "Privacy policy - OpenWeatherMap";

        final String oldURL = openBaseURL().getCurrentURL();

        MainPage mainPage = new MainPage(getDriver());

        mainPage.scrollToFooterMenu()
                .clickPrivacyPolicyFooterMenu();

        mainPage.switchToExternalPage();

        TestUtils.waitForPageLoaded(getDriver());

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedURL);
        Assert.assertEquals(getExternalPageTitle(), expectedTitle);
    }

    @Test
    public void testWeatherDashboardLinkNavigatesToWeatherDashboardPage() {
        final String expectedURL = "https://openweathermap.org/weather-dashboard";
        final String expectedTitle = "Weather dashboard - OpenWeatherMap";

        final String oldURL = openBaseURL().getCurrentURL();

        String actualURL = new MainPage(getDriver())
                .scrollToFooterMenu()
                .clickWeatherDashboardFooterMenu()
                .getCurrentURL();

        String actualTitle = new WeatherDashboardPage(getDriver()).getTitle();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testAboutUsFooterLinkNavigatesToAboutUsPage() {
        final String expectedTitle = "About us - OpenWeatherMap";
        final String expectedUrl = "https://openweathermap.org/about-us";

        final String oldURL = openBaseURL().getCurrentURL();

        String actualURL = new MainPage(getDriver())
                .scrollToFooterMenu()
                .clickAboutUsFooterMenu()
                .waitForAboutUsPageHeaderBeVisible()
                .getCurrentURL();

        String actualTitle = new AboutUsPage(getDriver()).getTitle();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testWidgetsFooterLinkNavigatesToWidgetsPage() {
        final String expectedURL = "https://openweathermap.org/widgets-constructor";
        final String expectedTitle = "Weather widgets constructor - OpenWeatherMap";

        final String oldURL = openBaseURL().getCurrentURL();

        String actualURL = new MainPage(getDriver())
                .scrollToFooterMenu()
                .clickWidgetsPageFooterMenu()
                .getCurrentURL();

        String actualTitle = new WidgetsPage(getDriver()).getTitle();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(retryAnalyzer = Retry.class)
    public void testAppStoreIconNavigatesToAppStoreWeb() {
        final String expectedAppStoreURL = "https://apps.apple.com/gb/app/openweather/id1535923697";
        final String expectedTitle = "OpenWeather";

        String oldURL = openBaseURL().getCurrentURL();

        MainPage mainPage = new MainPage(getDriver());

        mainPage.scrollToFooterMenu()
                .clickAppStoreIcon();

        mainPage.switchToExternalPage();
        TestUtils.waitForPageLoaded(getDriver());

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedAppStoreURL);
        Assert.assertTrue(getExternalPageTitle().contains(expectedTitle),
                " ExternalPageTitle does not contain 'OpenWeather' ");
    }

    @Test
    public void testGitHubIconNavigatesToGitHubWeb() {
        final String expectedURL = "https://github.com/search?q=openweathermap&ref=cmdform";
        final String expectedTitle = "Search · openweathermap · GitHub";

        String oldURL = openBaseURL()
                .scrollToFooterMenu()
                .getCurrentURL();

        MainPage mainPage = new MainPage(getDriver());

        mainPage.clickGitHubIcon();
        mainPage.switchToExternalPage();
        TestUtils.waitForPageLoaded(getDriver());

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedURL);
        Assert.assertEquals(getExternalPageTitle(), expectedTitle);
    }

    @Test
    public void testPricingFooterLinkNavigatesToPricePage() {
        final String expectedURL = "https://openweathermap.org/price";
        final String expectedTitle = "Pricing - OpenWeatherMap";

        final String oldURL = openBaseURL()
                .getCurrentURL();

        String actualURL = new MainPage(getDriver())
                .scrollToFooterMenu()
                .clickPricingFooterMenu()
                .getCurrentURL();

        String actualTitle = new PricePage(getDriver()).getTitle();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testConnectYourWeatherStationFooterLinkNavigatesToWeatherStationsPage() {
        final String expectedWeatherStationsUrl = "https://openweathermap.org/stations";
        final String expectedWeatherStationsTitle = "Weather Stations - OpenWeatherMap";

        final String oldURL = openBaseURL().getCurrentURL();

        WeatherStationsPage weatherStationsPage =
                openBaseURL()
                        .scrollToFooterMenu()
                        .clickConnectYourWeatherStationFooterMenu();

        String actualWeatherStationsUrl = weatherStationsPage.getCurrentURL();
        String actualWeatherStationsTitle = weatherStationsPage.getTitle();

        Assert.assertNotEquals(actualWeatherStationsUrl, oldURL);
        Assert.assertEquals(actualWeatherStationsUrl, expectedWeatherStationsUrl);
        Assert.assertEquals(actualWeatherStationsTitle, expectedWeatherStationsTitle);
    }

    @Test
    public void testAskQuestionFooterLinkNavigatesToHomeAskQuestionPage() {
        final String expectedTitle = "Members";
        final String expectedUrl = "https://home.openweathermap.org/questions";

        String oldURL = openBaseURL().getCurrentURL();
        String actualURL = new MainPage(getDriver())
                .scrollToFooterMenu()
                .clickAskQuestionFooterMenu()
                .switchToHomeAskQuestionPage()
                .getCurrentURL();

        String actualTitle = new HomeAskQuestionPage(getDriver()).getTitle();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testGooglePlayIconNavigatesToGooglePlayWeb() {
        final String expectedURL = "https://play.google.com/store/apps/details?id=uk.co.openweather";
        final String expectedTitle = "OpenWeather - Apps on Google Play";

        String oldURL = openBaseURL().getCurrentURL();

        MainPage mainPage = new MainPage(getDriver());

        mainPage.scrollToFooterMenu().clickGooglePlayIcon();
        mainPage.switchToExternalPage();
        TestUtils.waitForPageLoaded(getDriver());

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedURL);
        Assert.assertEquals(getExternalPageTitle(), expectedTitle);
    }

    @Test
    public void testCopyrightOnFooterMenu() {
        final String expectedCopyright = "© 2012 — 2023 OpenWeather ® All rights reserved";

        String actualCopyright = openBaseURL()
                .scrollToFooterMenu()
                .getCopyright();

        Assert.assertEquals(actualCopyright, expectedCopyright);
    }

    @Test
    public void testFacebookIconNavigatesToFacebookWeb() {
        final String expectedPartialFacebookURL = "facebook.com";

        String oldURL = openBaseURL().getCurrentURL();

        MainPage mainPage = new MainPage(getDriver());

        mainPage.scrollToFooterMenu()
                .clickFacebookIcon();
        mainPage.switchToExternalPage();
        TestUtils.waitForPageLoaded(getDriver());

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertTrue(getExternalPageURL().contains(expectedPartialFacebookURL),
                " ExternalPageURL does not contain'facebook.com' " + getExternalPageURL());
    }

    @Test
    public void testOpenWeatherForBusinessLinkNavigateToForBusinessWeb() {
        final String expectedURL = "https://openweather.co.uk/";
        final String expectedTitle = "OpenWeather for business - OpenWeatherMap";

        MainPage mainPage = new MainPage(getDriver());

        String urlOfMainPage = openBaseURL().getCurrentURL();

        mainPage.scrollToPageBottom()
                .clickOpenWeatherForBusinessFooterMenuLink();
        mainPage.switchToExternalPage();
        TestUtils.waitForPageLoaded(getDriver());

        Assert.assertNotEquals(getExternalPageURL(), urlOfMainPage);
        Assert.assertEquals(getExternalPageTitle(), expectedTitle);
        Assert.assertEquals(getExternalPageURL(), expectedURL);
    }

    @Test(priority = -5)
    public void testFooterMenuLinksAmount() {
        final int expectedLinks = 27;

        int actualLinks = openBaseURL()
                .scrollToFooterMenu()
                .getFooterMenuLinksCount();

        Assert.assertEquals(actualLinks, expectedLinks);
    }

    @Test(dataProvider = "FooterMenuData", dataProviderClass = TestData.class)
    public void testFooterMenuLinksNavigateToCorrespondingPages(
            int index, String linkName, String href, String expectedURL, String expectedTitle) {

        MainPage mainPage = openBaseURL();

        final String oldURL = mainPage.getCurrentURL();
        final String oldTitle = mainPage.getTitle();

        String actualURL = mainPage.scrollToFooterMenu().clickFooterMenu(index).getCurrentURL();
        String actualTitle = getDriver().getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTitle, actualTitle);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(dataProvider = "ExternalFooterMenuData", dataProviderClass = TestData.class)
    public void testExternalMenuLinksNavigateToCorrespondingPages(
            int index, String linkName, String href, String expectedURL, String expectedTitle) {

        MainPage mainPage = openBaseURL();

        final String oldURL = mainPage.getCurrentURL();
        final String oldTitle = mainPage.getTitle();

        mainPage.scrollToFooterMenu().clickFooterMenuExternalLink(index);

        String actualURL = getExternalPageURL();
        String actualTitle = getExternalPageTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTitle, actualTitle);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
