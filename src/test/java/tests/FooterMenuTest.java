package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.*;
import pages.top_menu.WebPage;
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
        final List<String> expectedSubscriptionTexts = List.of(
                "Who we are",
                "Media Education",
                "Charity Project",
                "Our Datacenter",
                "Contact us"
        );

        final List<String> actualSubscriptionTexts =
                openBaseURL()
                        .scrollToAboutSwisscowsFooterMenu()
                        .getAboutSwisscowsMenusTexts();

        Assert.assertTrue(actualSubscriptionTexts.size() > 0);
        Assert.assertEquals(actualSubscriptionTexts, expectedSubscriptionTexts);
    }
    @Ignore
    @Test
    public void testEducationFooterLinkNavigatesToEducationPage() {
        final String expectedURL = "https://dev.swisscows.com/en/media-education";
        final String expectedTitle = "Media Education - Extremely Safe Web for Children";

        final String oldURL = openBaseURL().getCurrentURL();

        MediaEducationPage educationPagePage = new MainPage(getDriver())
                 .scrollToFooterMenu()
                 .clickMediaEducationFooterMenu();

        final String actualTitle = educationPagePage.getTitle();
        final String actualURL = educationPagePage.getCurrentURL();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Ignore
    @Test(retryAnalyzer = Retry.class)
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
    @Ignore
    @Test(retryAnalyzer = Retry.class)
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


    @Ignore
    @Test(retryAnalyzer = Retry.class)
    public void testWhoWeAreUsFooterLinkNavigatesToAboutUsPage() {
        final String expectedTitle = "Search engine without tracking - Learn more about us";
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

        final String actualTitle = contactPage.getTitle();
        final String actualURL = contactPage.getCurrentURL();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testOurProductsText() {
        final List<String> OurProductsTextTexts = List.of(
                "VPN",
                "Swisscows.email",
                "TeleGuard",
                "HES",
                "GetDigest"
        );

       final List<String> actualSubscriptionTexts =
                openBaseURL()
                        .scrollToAboutSwisscowsFooterMenu()
                        .getOurProductsMenusTexts();

        Assert.assertTrue(actualSubscriptionTexts.size() > 0);
        Assert.assertEquals(actualSubscriptionTexts, OurProductsTextTexts);
    }




    @Test(retryAnalyzer = Retry.class)
    public void testSwisscowsEmailPageFooterNavigatesToSwisscowsEmailSite() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedEmailURL = "https://dev.swisscows.com/en/swisscows-email";
        final String expectedH1Text = "A letter is your personal property!";

        final String oldURL = openBaseURL().getCurrentURL();

        mainPage
                .scrollToFooterMenu()
                .clickSwisscowsEmail()
                .switchToExternalPage();

        final String actualH1text =mainPage.getH1Text();

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedEmailURL);
        Assert.assertTrue(actualH1text.contains(expectedH1Text),
                " ExternalPageTitle does not contain 'A letter is your personal property!' ");
    }



    @Test
    public void testGooglePlayIconNavigatesToGooglePlayWeb() {
        final String oldURL = openBaseURL().getCurrentURL();
        final String expectedURL = "https://play.google.com/store/apps/details?id=com.swisscows.search";
        final String expectedTitle = "Swisscows Private Search - Apps on Google Play";

        MainPage mainPage = new MainPage(getDriver());

        mainPage
                .scrollToFooterMenu()
                .clickGooglePlayIcon()
                .switchToExternalPage();

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedURL);
        Assert.assertEquals(getExternalPageTitle(), expectedTitle);
    }

    @Test
    public void testAppStoreIconNavigatesToAppStoreWeb() {
        final String expectedURL = "https://apps.apple.com/app/swisscows-privacy-search/id1581108092";
        final String expectedTitle = "Swisscows Private Search on the App Store";

        final String oldURL = openBaseURL().getCurrentURL();

        MainPage mainPage = new MainPage(getDriver());

        mainPage.scrollToFooterMenu()
                .clickAppStoreIcon()
                .switchToExternalPage();;

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedURL);
        Assert.assertEquals(getExternalPageTitle(), expectedTitle);
    }

    @Test
    public void testCopyrightOnFooterMenu() {
        final String expectedCopyright = "© Swisscows AG, 2023";

        final String actualCopyright = openBaseURL()
                .scrollToFooterMenu()
                .getCopyright();

        Assert.assertEquals(actualCopyright, expectedCopyright);
    }

    @Test
    public void testFacebookIconNavigatesToFacebookWeb() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedPartialFacebookURL = "facebook.com";

        final String oldURL = openBaseURL().getCurrentURL();

        mainPage
                .scrollToFooterMenu()
                .clickFacebookIcon()
                .switchToExternalPage();


        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertTrue(getExternalPageURL().contains(expectedPartialFacebookURL),
                " ExternalPageURL does not contain 'facebook.com' " + getExternalPageURL());
    }

    @Test
    public void testInstagramIconNavigatesToInstagramWeb() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedPartialInstagramURL = "instagram.com";

        final String oldURL = openBaseURL().getCurrentURL();

        mainPage
                .scrollToFooterMenu()
                .clickInstagramIcon()
                .switchToExternalPage();

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertTrue(getExternalPageURL().contains(expectedPartialInstagramURL),
                " ExternalPageURL does not contain 'instagram.com' " + getExternalPageURL());


    }
    @Test
    public void testLinkedinIconNavigatesToLinkedinWeb() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedPartialFacebookURL = "linkedin.com";

        final String oldURL = openBaseURL().getCurrentURL();

        mainPage
                .scrollToFooterMenu()
                .clickLinkedinIcon()
                .switchToExternalPage();

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertTrue(getExternalPageURL().contains(expectedPartialFacebookURL),
                " ExternalPageURL does not contain 'linkedin.com' " + getExternalPageURL());
    }

    @Test
    public void testTwitterIconNavigatesToTwitterWeb() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedPartialInstagramURL = "https://twitter.com/swisscows_ch";

        final String oldURL = openBaseURL().getCurrentURL();

        mainPage
                .scrollToFooterMenu()
                .clickTwitterIcon()
                .switchToExternalPage();

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(),expectedPartialInstagramURL);

    }

    @Test
    public void testTeleGardIconNavigatesToTeleGardWeb() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedPartialInstagramURL = "https://teleguard.com/en";

        final String oldURL = openBaseURL().getCurrentURL();

        mainPage
                .scrollToFooterMenu()
                .clickTeleGuardIcon()
                .switchToExternalPage();

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(),expectedPartialInstagramURL);

    }


    @Test(priority = -5)
    public void testFooterMenuLinksAmount() {
        final int expectedLinks = 25;

        int actualLinks = openBaseURL()
                .scrollToFooterMenu()
                .getFooterMenuLinksCount();

        Assert.assertEquals(actualLinks, expectedLinks);
    }

    @Test
    public void testBlockImprintDonationDataPrivacyTexts() {
        final List<String> OurProductsTextTexts = List.of(
                "About Swisscows AG",
                "Imprint",
                "Data privacy",
                "Donation"

        );

        final List<String> actualSubscriptionTexts =
                openBaseURL()
                        .scrollToAboutSwisscowsAGFooterMenu()
                        .getAboutSwisscowsAGMenusTexts();

        Assert.assertTrue(actualSubscriptionTexts.size() > 0);
        Assert.assertEquals(actualSubscriptionTexts, OurProductsTextTexts);
    }




    @Test(dataProvider = "FooterMenuData", dataProviderClass = TestData.class)
    public void testFooterMenuLinksNavigateToCorrespondingPages(
        int index, String linkName, String href, String expectedURL, String expectedH1Header)  {

        MainPage mainPage = openBaseURL();

        final String oldURL = mainPage.getCurrentURL();
        final String oldH1Header = mainPage.getH1Text();

        mainPage
                .scrollToFooterMenu()
                .clickFooterMenu(index);

        final String actualURL = mainPage.getCurrentURL();
        final String actualH1Header = mainPage.getH1Text();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldH1Header, actualH1Header);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualH1Header, expectedH1Header);

    }

    @Test(dataProvider = "ExternalFooterMenuData", dataProviderClass = TestData.class, retryAnalyzer = Retry.class)
    public void testExternalMenuLinksNavigateToCorrespondingPages(
            int index, String linkName, String href, String expectedURL, String expectedTitle) {

        MainPage mainPage = openBaseURL();

        final String oldURL = mainPage.getCurrentURL();
        final String oldTitle = mainPage.getTitle();

        mainPage
                .scrollToFooterMenu()
                .clickFooterMenuExternalLink(index);

        final String actualURL = getExternalPageURL();
        final String actualTitle = getExternalPageTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTitle, actualTitle);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void testCopyrightOnFooterSearchPages() {
        final String expectedCopyright = "© Swisscows AG, 2023";

        final String actualCopyright = openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .scrollToFooterSearchPages()
                .getCopyright();

        Assert.assertEquals(actualCopyright, expectedCopyright);
    }
    @Test(dataProvider = "ExternalFooterSearchMenuData", dataProviderClass = TestData.class)
    public void testExternalFooterSearchLinksNavigateToCorrespondingPages(
            int index, String linkName, String href, String expectedURL, String expectedTitle) {
        WebPage webPage = new WebPage(getDriver());

        openBaseURL();

        final String oldURL = webPage.getCurrentURL();
        final String oldTitle = webPage.getTitle();

        webPage
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .scrollToFooterSearchPages()
                .clickFooterSearchMenuExternalLink(index);

        final String actualURL = getExternalPageURL();
        final String actualTitle = getExternalPageTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTitle, actualTitle);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void testFooterSearchMenuLinksAmount() {
        final int expectedLinks = 8;

        int actualLinks = openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .scrollToFooterSearchPages()
                .getFooterMenuLinksCount();

        Assert.assertEquals(actualLinks, expectedLinks);
    }
    @Test
    public void testFooterSearchSocialPanelIconsNavigateToCorrespondingWebSites() {
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
}
