package tests.footer;
import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.*;
import pages.top_menu.WebPage;
import tests.retrytest.Retry;
import utils.ProjectConstants;
import utils.TestUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FooterMenuTest extends BaseTest {
    @QaseTitle("Check existence and icons in the store panel")
    @QaseId(value = 4951)
    @Test
    public void testStorePanelExistsAndHasIcons() {
        final int expectedQuantity = 2;

        MainPage mainPage = openBaseURL()
                .scrollToFooterMenu();

        Assert.assertTrue(mainPage.isStorePanelDisplayed(), " StorePanel is not displayed ");
        Assert.assertEquals(mainPage.getStoresIconsCount(), expectedQuantity);
    }
    @QaseTitle("Check existence and icons in the store panel")
    @QaseId(value = 4952)
    @Test
    public void testSocialPanelExistsAndHasIcons() {
        final int expectedIconsQuantity = 5;

        MainPage mainPage = openBaseURL()
                .scrollToFooterMenu();

        Assert.assertTrue(mainPage.isSocialPanelDisplayed(), " SocialPanel is not displayed ");
        Assert.assertEquals(mainPage.getSocialPanelSize(), expectedIconsQuantity);
    }
    @QaseTitle("Check texts in the about swisscows section")
    @QaseId(value = 4953)
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
    @QaseTitle("Check texts in the our products section")
    @QaseId(value = 4954)
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
    @QaseTitle("Check that swisscows email link in the footer navigates to email page")
    @QaseId(value = 4955)
    @Test(retryAnalyzer = Retry.class)
    public void testSwisscowsEmailLinkFooterNavigatesToSwisscowsEmailSite() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedEmailURL = ProjectConstants.DOMAIN + "/en/swisscows-email";
        final String expectedH1Text = "A letter is your personal property!";

        final String oldURL = openBaseURL()
                .getCurrentURL();

        mainPage
                .scrollToFooterMenu()
                .clickSwisscowsEmail()
                .switchToExternalPage();

        final String actualH1text = mainPage
                .getH1Text();

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedEmailURL);
        Assert.assertTrue(actualH1text.contains(expectedH1Text),
                " ExternalPageTitle does not contain 'A letter is your personal property!' ");
    }

    @QaseTitle("Check that Google play icon in the footer navigates to google play page")
    @QaseId(value = 4956)
    @Test
    public void testGooglePlayIconNavigatesToGooglePlayWeb() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedURL = "https://play.google.com/store/apps/details?id=com.swisscows.search";
        final String expectedTitle = "Swisscows Private Search - Apps on Google Play";

        final String oldURL = openBaseURL().getCurrentURL();
        mainPage
                .scrollToFooterMenu()
                .clickGooglePlayIcon()
                .switchToExternalPage();

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedURL);
        Assert.assertEquals(getExternalPageTitle(), expectedTitle);
    }
    @QaseTitle("Check that app store icon in the footer navigates  to app store page")
    @QaseId(value = 4958)
    @Test
    public void testAppStoreIconNavigatesToAppStoreWeb() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedURL = "https://apps.apple.com/app/swisscows-privacy-search/id1581108092";
        final String expectedTitle = "Swisscows Private Search on the App Store";

        final String oldURL = openBaseURL().getCurrentURL();

        mainPage
                .scrollToFooterMenu()
                .clickAppStoreIcon()
                .switchToExternalPage();;

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedURL);
        Assert.assertEquals(getExternalPageTitle(), expectedTitle);
    }
    @QaseTitle("Check that facebook icon in the footer navigates  to facebook page")
    @QaseId(value = 4957)
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
    @QaseTitle("Check that instagram icon in the footer navigates  to instagram page")
    @QaseId(value = 4959)
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
    @QaseTitle("Check that LinkedIn icon in the footer navigates  to LinkedIn page")
    @QaseId(value = 4960)
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
    @QaseTitle("Check that twitter icon in the footer navigates  to twitter page")
    @QaseId(value = 4961)
    @Test
    public void testTwitterIconNavigatesToTwitterWeb() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedPartialInstagramURL = "https://twitter.com/i/flow/login?redirect_after_login=%2Fswisscows_ch";

        final String oldURL = openBaseURL().getCurrentURL();

        mainPage
                .scrollToFooterMenu()
                .clickTwitterIcon()
                .switchToExternalPage();

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(),expectedPartialInstagramURL);

    }
    @QaseTitle("Check that TeleGuard icon in the footer navigates  to TeleGuard page")
    @QaseId(value = 4962)
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

    @QaseTitle("Check that numbers links in the footer")
    @QaseId(value = 4962)
    @Test(priority = -5)
    public void testFooterMenuLinksAmount() {
        final int expectedLinks = 26;

        int actualLinks = openBaseURL()
                .scrollToFooterMenu()
                .getFooterMenuLinksCount();

        Assert.assertEquals(actualLinks, expectedLinks);
    }
    @QaseTitle("Check hover effect on footer menu links")
    @QaseId(value = 4964)
    @Test
    public void testHoverFooterMenuLinks() throws InterruptedException {
        MainPage mainPage = new MainPage(getDriver());
        final List<String> oldButtonColorsWhenHover = openBaseURL()
                .scrollToFooterMenu()
                .getLinkColorsFooterMenu();

        final List<String> newButtonColorsWhenHover = mainPage
                .getLinksColorsWhenHoverFooterMenu();

        Assert.assertNotEquals(newButtonColorsWhenHover, oldButtonColorsWhenHover);

    }
    @QaseTitle("Check copyright in the footer")
    @QaseId(value = 4965)
    @Test
    public void testCopyrightOnFooterMenu() {
        final String expectedCopyright = "© Swisscows AG, 2023";

        final String actualCopyright = openBaseURL()
                .scrollToFooterMenu()
                .getCopyright();

        Assert.assertEquals(actualCopyright, expectedCopyright);
    }
    @QaseTitle("Check texts in the Imprint, Donation, DataPrivacy, section")
    @QaseId(value = 4966)
    @Test
    public void testBlockImprintDonationDataPrivacyTexts() {
        final List<String> OurProductsTextTexts = List.of(
                "About Swisscows AG",
                "Imprint",
                "Data privacy",
                "Donation"

        );

        final List<String> actualSubscriptionTexts = openBaseURL()
                        .scrollToAboutSwisscowsAGFooterMenu()
                        .getAboutSwisscowsAGMenusTexts();

        Assert.assertTrue(actualSubscriptionTexts.size() > 0);
        Assert.assertEquals(actualSubscriptionTexts, OurProductsTextTexts);
    }
    @QaseTitle("Check texts in our services section")
    @QaseId(value = 4967)
    @Test
    public void testBlockOurServicesTexts() {
        final List<String> OurProductsTextTexts = List.of(
                "Our Services",
                "Fan-shop",
                "Swisscows Blog",
                "Support"

        );

        final List<String> actualSubscriptionTexts = openBaseURL()
                        .scrollToAboutSwisscowsAGFooterMenu()
                        .getOurServicesTexts();

        Assert.assertTrue(actualSubscriptionTexts.size() > 0);
        Assert.assertEquals(actualSubscriptionTexts, OurProductsTextTexts);
    }


    @QaseTitle("Check that footer menu links navigate to corresponding pages")
    @QaseId(value = 4968)
    @Test(dataProvider = "FooterMenuData", dataProviderClass = TestData.class)
    public void testFooterMenuLinksNavigateToCorrespondingPages(
        int index, String linkName, String href, String expectedURL, String expectedH1Header)  {
        MainPage mainPage = new MainPage(getDriver());

        final String oldURL = openBaseURL().getCurrentURL();
        final String oldH1Header = mainPage.getH1Text();

        final String actualURL = mainPage
                .scrollToFooterMenu()
                .clickFooterMenu(index)
                .getCurrentURL();
        final String actualH1Header = mainPage.getH1Text();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldH1Header, actualH1Header);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualH1Header, expectedH1Header);

    }
    @QaseTitle("Check that footer menu external links navigate to corresponding pages")
    @QaseId(value = 4969)
    @Test(dataProvider = "ExternalFooterMenuData", dataProviderClass = TestData.class, retryAnalyzer = Retry.class)
    public void testExternalMenuLinksNavigateToCorrespondingPages(
            int index, String linkName, String href, String expectedURL, String expectedTitle) {
        MainPage mainPage = new MainPage(getDriver());

        final String oldURL = openBaseURL().getCurrentURL();
        final String oldTitle = mainPage.getTitle();


        final String actualURL = mainPage
                .scrollToFooterMenu()
                .clickFooterMenuExternalLink(index)
                .getCurrentURL();

        final String actualTitle = getExternalPageTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTitle, actualTitle);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @QaseTitle("Check copyright in the footer for search pages")
    @QaseId(value = 4970)
    @Test(retryAnalyzer = Retry.class)
    public void testCopyrightOnFooterSearchPages() {
        final String expectedCopyright = "© Swisscows AG, 2023";

        final String actualCopyright = openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .scrollToFooterSearchPages()
                .getCopyright();

        Assert.assertEquals(actualCopyright, expectedCopyright);
    }
    @QaseTitle("Check that footer menu links navigate to corresponding pages for search pages ")
    @QaseId(value = 4971)
    @Test(dataProvider = "ExternalFooterSearchMenuData", dataProviderClass = TestData.class)
    public void testExternalFooterSearchLinksNavigateToCorrespondingPages(
            int index, String linkName, String href, String expectedURL, String expectedTitle) {
        MainPage mainPage = new MainPage(getDriver());


        final String oldTitle = openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .scrollToFooterSearchPages()
                .getTitle();

        final String oldURL = mainPage.getCurrentURL();

        final String actualURL = mainPage
                .clickFooterSearchMenuExternalLink(index)
                .getCurrentURL();

        final String actualTitle = getExternalPageTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTitle, actualTitle);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @QaseTitle("Check that numbers links in the footer for search pages")
    @QaseId(value = 4972)
    @Test
    public void testFooterSearchMenuLinksAmount() {
        int actualLinks = openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .scrollToFooterSearchPages()
                .getFooterMenuLinksCount();

        Assert.assertEquals(actualLinks, 8);
    }
}
