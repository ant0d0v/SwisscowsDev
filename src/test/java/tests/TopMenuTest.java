package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.accounts.UsersLoginPage;
import pages.top_menu.VpnPage;
import tests.retrytest.Retry;
import utils.ProjectConstants;
import utils.TestUtils;

import java.util.List;

public class TopMenuTest extends BaseTest {

    @Test
    public void testTeleGardIconNavigatesToTeleGardWebPage() {
        final String expectedPartialInstagramURL = "https://teleguard.com/en";

        String oldURL = openBaseURL().getCurrentURL();

        MainPage mainPage = new MainPage(getDriver());

        mainPage
                .clickTeleGuardTopMenu();
        mainPage.switchToExternalPage();
        TestUtils.waitForPageLoaded(getDriver());

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedPartialInstagramURL);

    }

    @Test(retryAnalyzer = Retry.class)
    public void testEmailIconNavigatesToEmailWebPage() {
        final String expectedEmailURL = "https://dev.swisscows.com/en/swisscows-email";
        final String expectedH1Text = "A letter is your personal property!";

        String oldURL = openBaseURL().getCurrentURL();

        MainPage mainPage = new MainPage(getDriver());

        mainPage
                .clickEmailTopMenu();
        mainPage.switchToExternalPage();
        TestUtils.waitForPageLoaded(getDriver());

        String actualH1text = mainPage.getH1Text();


        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedEmailURL);
        Assert.assertEquals(actualH1text,expectedH1Text);

    }

    @Ignore
    @Test(retryAnalyzer = Retry.class)
    public void testVPNIconNavigatesToVPNWebPage() {
        final String expectedURL = "https://dev.swisscows.com/en/anonymous-vpn";
        final String expectedTitle = "Surf anonymously with VPN - Secure web surfing with Swisscows";

        final String oldURL = openBaseURL().getCurrentURL();

        MainPage mainPage = new MainPage(getDriver());

        VpnPage vpnPage = mainPage
                .clickVPNTopMenu();
        mainPage
                .switchToExternalPage();
        String actualURL = vpnPage
                .getCurrentURL();

        String actualTitle = vpnPage.getTitle();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Test
    public void testHamburgerMenuLinksTexts() {
        final List<String> expectedList = List.of(
                "Set as Startpage",
                "Make a Default Search Engine",
                "Who we are",
                "Media Education",
                "Charity Project",
                "Our Datacenter",
                "Contact us",
                "Data privacy",
                "Donation"

        );

        MainPage mainPage = openBaseURL();
        mainPage
                .clickHamburgerMenuIcon();
        List<String> actualList = mainPage.getLinksText();

        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void testHamburgerMenuIsClickable() {
        final String expectedIfVisible = "hamburger-menu active";
        final String expectedIfNotVisible = "hamburger-menu";

        openBaseURL();

        MainPage mainPage = openBaseURL();
        mainPage.clickHamburgerMenuIcon();
        String actualIfVisible = mainPage.getHamburgerMenuIsActiveValue();

        Assert.assertTrue(new MainPage(getDriver()).isHamburgerDropdownContainerDisplayed());
        Assert.assertEquals(actualIfVisible, expectedIfVisible);

        mainPage.clickHamburgerMenuIcon();
        String actualIfNotVisible = mainPage.getHamburgerMenuIsActiveValue();

        Assert.assertEquals(actualIfNotVisible, expectedIfNotVisible);
    }


    @Test
    public void testTopMenuLinkAmount() {
        final int expectedTopMenuLinkAmount = 3;

        int actualTopMenuLinkAmount =
                openBaseURL()
                        .topMenuLinkAmount();

        Assert.assertEquals(actualTopMenuLinkAmount, expectedTopMenuLinkAmount);
    }

    @Test
    public void testCompanyLogoNavigatesToBaseURL() {
        final String expectedURL = "https://dev.swisscows.com/en";
        final String expectedTitle = "Your private and anonymous search engine Swisscows";

        openBaseURL();

        MainPage mainPage = new MainPage(getDriver());
        mainPage
                .clickHamburgerMenuIcon();
        mainPage
                .clickSetAsStartAppInHamburgerMenu();
        mainPage.switchToAnotherWindow();
        mainPage
                .clickLogo()
                .switchToAnotherWindow();

        String actualURL = mainPage.getCurrentURL();

        String actualTitle = new MainPage(getDriver()).getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(dataProvider = "TopMenuTestData", dataProviderClass = TestData.class)
    public void testEachTopMenuNavigatesToCorrespondingPage(
            int index, String menuName, String href, String expectedURL) {

        MainPage mainPage = openBaseURL();

        String oldURL = mainPage.getCurrentURL();

        mainPage.clickTopMenu(index);

        String actualURL = getDriver().getCurrentUrl();


        if (index != 0) {
            Assert.assertNotEquals(actualURL, oldURL);

        }

        if (index != 6) {
            Assert.assertEquals(actualURL, expectedURL);
        } else {
            Assert.assertTrue(actualURL.contains(expectedURL));
        }

    }

    @Test
    public void testHamburgerMenuIsAvailableAndHasOptions_TopMenu() {
        final int expectedNumberOfOptionsHamburgerMenu = 11;
        final List<String> expectedHamburgerMenuListTexts = List.of(
                "Integration", "Set as Startpage", "Make a Default Search Engine", "About Swisscows", "Who we are",
                "Media Education", "Charity Project", "Our Datacenter", "Contact us", "Data privacy",
                "Donation"
        );
        openBaseURL()
                .setWindowWithHamburgerMenu(ProjectConstants.WIDTH_HAMBURGER_MENU, ProjectConstants.HEIGHT_HAMBURGER_MENU)
                .clickHamburgerMenuIcon();

        int actualNumberOfOptionsHamburgerMenu = new MainPage(getDriver()).getNumberOfListHamburgerMenu();

        List<String> actualHamburgerMenuListTexts = new MainPage(getDriver()).getHamburgerMenuAllListText();

        Assert.assertTrue(new MainPage(getDriver()).isHamburgerIconDisplayed());
        Assert.assertTrue(new MainPage(getDriver()).getNumberOfListHamburgerMenu() > 0);
        Assert.assertEquals(actualNumberOfOptionsHamburgerMenu, expectedNumberOfOptionsHamburgerMenu);
        Assert.assertEquals(actualHamburgerMenuListTexts, expectedHamburgerMenuListTexts);
    }


    @Test
    public void testLoginMenuNavigatesToAccountPage() {
        final String expectedURLPartial = "accounts.dev.swisscows.com";


        final String oldURL = openBaseURL().getCurrentURL();

        String actualURL = new MainPage(getDriver())
                .clickHamburgerMenu()
                .clickSignInMenu()
                .getCurrentURL();


        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertTrue(actualURL.contains(expectedURLPartial), " PageURL does not contain 'accounts.dev.swisscows.com' ");

    }

    @Test
    public void testLocalizationDropdownMenuIsAvailableAndHasOptions_TopMenu() {
        final int expectedNumberOfOptionsHamburgerMenu = 10;
        final List<String> expectedHamburgerMenuListTexts = List.of(
                "English", "Deutsch", "Français", "Italiano", "Español",
                "Nederlands", "Latviešu", "Magyar", "Русский", "Українська"
        );
        openBaseURL()
                .setWindowWithHamburgerMenu(ProjectConstants.WIDTH_HAMBURGER_MENU, ProjectConstants.HEIGHT_HAMBURGER_MENU)
                .clickHamburgerMenuIcon();

        MainPage mainPage = new MainPage(getDriver());
        mainPage
                .clickLanguagesTopMenu();


        int actualNumberOfOptionsHamburgerMenu = new MainPage(getDriver()).getNumberLangMenu();

        List<String> actualHamburgerMenuListTexts = new MainPage(getDriver()).getLangMenuListTexts();

        Assert.assertTrue(new MainPage(getDriver()).isHamburgerIconDisplayed());
        Assert.assertTrue(new MainPage(getDriver()).getNumberOfListHamburgerMenu() > 0);
        Assert.assertEquals(actualNumberOfOptionsHamburgerMenu, expectedNumberOfOptionsHamburgerMenu);
        Assert.assertEquals(actualHamburgerMenuListTexts, expectedHamburgerMenuListTexts);
    }

    @Test(dataProvider = "LangTopMenuTestData", dataProviderClass = TestData.class)
    public void testLocalizationNavigateToCorrespondingPages(
            int index, String LangName, String expectedURL, String expectedTitle) {

        MainPage mainPage = openBaseURL();

        final String oldURL = mainPage.getCurrentURL();
        final String oldTitle = mainPage.getTitle();

        mainPage.clickHamburgerMenu().clickLangDropDown(index);
        TestUtils.waitForPageLoaded(getDriver());
        String actualURL = mainPage.getCurrentURL();
        String actualTitle = getDriver().getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTitle, actualTitle);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testRegionDropdownMenuIsAvailableAndHasOptions_TopMenu() {
        final int expectedNumberOfOptionsHamburgerMenu = 46;
        final List<String> expectedHamburgerMenuListTexts = List.of(
                "Argentina", "Australia", "Austria", "Belgium (fr)", "Belgium (nl)",
                "Brazil", "Canada (en)", "Canada (fr)", "Chile", "China", "Denmark", "Finland", "France",
                "Germany", "Hong Kong SAR", "Hungary", "India", "Indonesia", "Italy", "Japan",
                "Kazakhstan", "Korea", "Latvia", "Malaysia", "Mexico", "Netherlands",
                "New Zealand", "Nigeria", "Norway", "Philippines", "Poland", "Portugal", "Russia", "Saudi Arabia", "South Africa"
                , "Spain", "Sweden", "Switzerland (de)", "Switzerland (fr)", "Taiwan", "Turkey", "Ukraine", "United Kingdom"
                , "United States (en)", "United States (es)", "World-wide"
        );
        openBaseURL()
                .clickHamburgerMenuIcon();

        MainPage mainPage = new MainPage(getDriver());
        mainPage
                .clickRegionTopMenu();
        mainPage
                .scrollToLastElementInDropdownRegion();

        int actualNumberOfOptionsHamburgerMenu = new MainPage(getDriver()).getNumberRegionMenu();

        List<String> actualHamburgerMenuListTexts = new MainPage(getDriver()).getLangMenuListTexts();

        Assert.assertTrue(new MainPage(getDriver()).isHamburgerIconDisplayed());
        Assert.assertTrue(new MainPage(getDriver()).getNumberOfListHamburgerMenu() > 0);
        Assert.assertEquals(actualNumberOfOptionsHamburgerMenu, expectedNumberOfOptionsHamburgerMenu);
        Assert.assertEquals(actualHamburgerMenuListTexts, expectedHamburgerMenuListTexts);
    }

    @Test(dataProvider = "RegionTopMenuTestData", dataProviderClass = TestData.class)
    public void testRegionNavigateToCorrespondingPages(
            int index, String LangName, String expectedURL, String expectedTitle) throws InterruptedException {

        MainPage mainPage = openBaseURL();

        final String oldURL = mainPage.getCurrentURL();

        mainPage.clickHamburgerMenu().clickRegionDropDown(index);
        sleep(3000);
        String actualURL = mainPage.getCurrentURL();
        String actualTitle = getDriver().getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testThemeIsDefaultFirstOpenSite() {
        final String expectedValue = "active";

        MainPage mainPage = openBaseURL();
        mainPage
                .clickHamburgerMenu()
                .clickThemeDropDownIcon();
        String actualValue = mainPage.getClassAttributeThemeDefault();

        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test
    public void tesThemeChanged() throws InterruptedException {
        final String expectedValue = "active";

        MainPage mainPage = openBaseURL();
        mainPage
                .clickHamburgerMenu()
                .clickThemeDropDownIcon();
        mainPage
                .clickThemeLight();
        mainPage
                .clickHamburgerMenu()
                .clickThemeDropDownIcon();

        String actualValueLight = mainPage.getClassAttributeThemeLight();

        Assert.assertEquals(actualValueLight, expectedValue);
    }

    @Test
    public void tesThemeOfBodyChanged() throws InterruptedException {
        final String expectedValue = "dark";

        MainPage mainPage = openBaseURL();
        mainPage
                .clickHamburgerMenu()
                .clickThemeDropDownIcon();
        mainPage
                .clickThemeDark();

        String actualValueLight = mainPage.getClassAttributeBodyOfSite();

        Assert.assertEquals(actualValueLight, expectedValue);


    }
    @Test
    public void testThemeMenuTexts() {
        final List<String> expectedList = List.of(
                "Default",
                "Light",
                "Dark"

        );

        MainPage mainPage = openBaseURL();
        mainPage
                .clickHamburgerMenuIcon();
        mainPage
                .clickThemeDropDownIcon();
        List<String> actualList = mainPage.getLangMenuListTexts();

        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void testLoginUserAndAvatarIconIsDysplaed() throws InterruptedException {
        MainPage mainPage = openBaseURL();
        mainPage.clickHamburgerMenu();
        UsersLoginPage UsersloginPage  = new UsersLoginPage (getDriver());
        UsersloginPage
                .signInTopMenu();

        mainPage.switchToAnotherWindow();
        mainPage.waitTopMenuToBeInvisible();

        mainPage.clickHamburgerMenu();

        Assert.assertTrue(mainPage.isAvatarIconIsDisplayedInHamburgerMenu());

    }

    @Test
    public void testLoginUserAndNicknameIsDysplaed() throws InterruptedException {
        final String expectedNick = "T" + "\n" + "Test";

        MainPage mainPage = openBaseURL();
        mainPage.clickHamburgerMenu();
        UsersLoginPage UsersloginPage = new UsersLoginPage(getDriver());
        UsersloginPage
                .signInTopMenu();
        mainPage.switchToAnotherWindow();
        mainPage.waitTopMenuToBeInvisible();
        mainPage
                .clickHamburgerMenu();

        String nickname = mainPage.getNicknameInHamburgerMenu();
        Assert.assertEquals(nickname, expectedNick);
    }
        @Test
        public void testLogOutUserAndLoginButtonIsDysplaed() throws InterruptedException {

            final String expectedUrl = "https://dev.swisscows.com/en";

            MainPage mainPage = openBaseURL();
            mainPage.clickHamburgerMenu();
            UsersLoginPage UsersloginPage = new UsersLoginPage(getDriver());
            UsersloginPage
                    .signInTopMenu();
            mainPage.switchToAnotherWindow();
            mainPage.waitTopMenuToBeInvisible();

            mainPage.logOut().waitTopMenuToBeInvisible();
            mainPage.clickHamburgerMenu();
            String actualUrl = mainPage.getCurrentURL();

            Assert.assertTrue(mainPage.isLoginIconDisplayed());
            Assert.assertEquals(actualUrl,expectedUrl);

    }

}
