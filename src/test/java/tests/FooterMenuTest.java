package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.*;
import tests.retrytest.Retry;
import utils.TestUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FooterMenuTest extends BaseTest {

    @Test
    public void testSocialPanelIconsNavigateToCorrespondingWebSites() {
        final List<String> links = List.of(
                "https://www.facebook.com/swisscows/",
                "https://twitter.com/swisscows_ch",
                "https://www.linkedin.com/authwall?trk=bf&trkInfo=AQFuutP8yP2NDwAAAYX_eJogFQhUFhjStomNWXxXyMfDTfaUTiDW86rJWhd1oVtNp4DfW1sjImPirI5XjJDnJSdq2Zs4a3GrvTb7V_OG87A1fb9eLiJzpkBA0abyxuA7e9Oa4g0=&original_referer=&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fcompany%2Fswisscows%2F",
                "https://www.instagram.com/swisscows.official/",
                "https://teleguard.com/en"

        );

        final List<String> expectedDomains = List.of(
                "www.facebook.com",
                "twitter.com",
                "www.linkedin.com",
                "www.instagram.com",
                "teleguard.com"

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
        final int expectedIconsQuantity = 5;

        MainPage mainPage = openBaseURL()
                .scrollToFooterMenu();

        Assert.assertTrue(mainPage.isSocialPanelDisplayed(), " SocialPanel is not displayed ");
        Assert.assertEquals(mainPage.getSocialPanelSize(), expectedIconsQuantity);
    }

    @Test
    public void testAboutSwisscowsTexts() {
        List<String> expectedSubscriptionTexts = List.of(
                "Who we are",
                "Media Education",
                "Charity Project",
                "Our Datacenter",
                "Contact us"
        );

        List<String> actualSubscriptionTexts =
                openBaseURL()
                        .scrollToAboutSwisscowsFooterMenu()
                        .getAboutSwisscowsMenusTexts();

        Assert.assertTrue(actualSubscriptionTexts.size() > 0);
        Assert.assertEquals(actualSubscriptionTexts, expectedSubscriptionTexts);
    }

    @Test
    public void testEducationFooterLinkNavigatesToEducationPage() {
        final String expectedURL = "https://dev.swisscows.com/en/media-education";
        final String expectedTitle = "Your private and anonymous search engine Swisscows";

        final String oldURL = openBaseURL().getCurrentURL();

        MediaEducationPage educationPagePage = new MainPage(getDriver())
                 .scrollToFooterMenu()
                 .clickMediaEducationFooterMenu();

        String actualTitle = educationPagePage.getTitle();
        String actualURL = educationPagePage.getCurrentURL();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testCharityProjectFooterLinkNavigatesToCharityProjectPage() {
        final String expectedURL = "https://dev.swisscows.com/en/social-projects";
        final String expectedTitle = "Social projects - We support social projects";

        final String oldURL = openBaseURL().getCurrentURL();

        CharityProjectPage charityPagePage = new MainPage(getDriver())
                .scrollToFooterMenu()
                .clickCharityProjectFooterMenu();

        String actualTitle = charityPagePage.getTitle();
        String actualURL = charityPagePage.getCurrentURL();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void testOurDatacenterPageFooterLinkNavigatesToOurDatacenterPagePage() {
        final String expectedURL = "https://dev.swisscows.com/en/data-safe-search-engine";
        final String expectedTitle = "Data center – Everything about the Swisscows data center";

        final String oldURL = openBaseURL().getCurrentURL();

        OurDatacenterPage OurDatacenterPage = new MainPage(getDriver())
                .scrollToFooterMenu()
                .clickOurDatacenterPageFooterMenu();

        String actualTitle = OurDatacenterPage.getTitle();
        String actualURL = OurDatacenterPage.getCurrentURL();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }



    @Test
    public void testWhoWeAreUsFooterLinkNavigatesToAboutUsPage() {
        final String expectedTitle = "Your private and anonymous search engine Swisscows";
        final String expectedUrl = "https://dev.swisscows.com/en/search-engine-no-tracking";

        final String oldURL = openBaseURL().getCurrentURL();

        String actualURL = new MainPage(getDriver())
                .scrollToFooterMenu()
                .clickAboutUsFooterMenu()
                .waitForWhoWeArePageHeaderBeVisible()
                .getCurrentURL();

        String actualTitle = new WhoWeArePage(getDriver()).getTitle();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testContactUsPageFooterLinkNavigatesToContactUsPage() {
        final String expectedURL = "https://dev.swisscows.com/en/contact";
        final String expectedTitle = "Contact us | Swisscows";

        final String oldURL = openBaseURL().getCurrentURL();

        ContactUsPage contactPage = new MainPage(getDriver())
                .scrollToFooterMenu()
                .clickContactUsPageFooterMenu();

        String actualTitle = contactPage.getTitle();
        String actualURL = contactPage.getCurrentURL();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testOurProductsText() {
        List<String> OurProductsTextTexts = List.of(
                "VPN",
                "Swisscows.email",
                "TeleGuard",
                "HES",
                "GetDigest"
        );

        List<String> actualSubscriptionTexts =
                openBaseURL()
                        .scrollToAboutSwisscowsFooterMenu()
                        .getOurProductsMenusTexts();

        Assert.assertTrue(actualSubscriptionTexts.size() > 0);
        Assert.assertEquals(actualSubscriptionTexts, OurProductsTextTexts);
    }




    @Test(retryAnalyzer = Retry.class)
    public void testSwisscowsEmailPageFooterNavigatesToSwisscowsEmailSite() {
        final String expectedAppStoreURL = "https://swisscows.email/";
        final String expectedTitle = "Swisscows.email - My secure e-mail.";

        String oldURL = openBaseURL().getCurrentURL();

        MainPage mainPage = new MainPage(getDriver());

        mainPage.scrollToFooterMenu()
                .clickSwisscowsEmail();

        mainPage.switchToExternalPage();
        TestUtils.waitForPageLoaded(getDriver());

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedAppStoreURL);
        Assert.assertTrue(getExternalPageTitle().contains(expectedTitle),
                " ExternalPageTitle does not contain 'Swisscows.email - My secure e-mail.' ");
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
        final String expectedCopyright = "© Swisscows AG, 2022";

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
