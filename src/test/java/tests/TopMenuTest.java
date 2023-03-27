package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.accounts.UsersLoginPage;
import pages.top_menu.NewsPage;
import pages.top_menu.VideoPage;
import pages.top_menu.VpnPage;
import pages.top_menu.WebPage;
import tests.retrytest.Retry;
import utils.ProjectConstants;
import utils.TestUtils;

import java.util.List;

public class TopMenuTest extends BaseTest {

    @Test
    public void testTeleGardIconNavigatesToTeleGardWebPage() {
        final String expectedPartialInstagramURL = "https://teleguard.com/en";

        final String oldURL = openBaseURL().getCurrentURL();

        MainPage mainPage = new MainPage(getDriver());
        mainPage
                .clickTeleGuardTopMenu()
                .switchToExternalPage();

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedPartialInstagramURL);

    }

    @Test(retryAnalyzer = Retry.class)
    public void testEmailIconNavigatesToEmailWebPage() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedEmailURL = "https://dev.swisscows.com/en/swisscows-email";
        final String expectedH1Text = "A letter is your personal property!";

        String oldURL = openBaseURL().getCurrentURL();
        mainPage
                .clickEmailTopMenu()
                .switchToExternalPage();
        final String actualH1text = mainPage.getH1Text();


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

        final List actualList = openBaseURL()
                .clickHamburgerMenuIcon()
                .getLinksText();
        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void testHamburgerMenuIsClickable() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedIfVisible = "hamburger-menu active";
        final String expectedIfNotVisible = "hamburger-menu";

        final String actualIfVisible = openBaseURL()
               .clickHamburgerMenuIcon()
               .getHamburgerMenuIsActiveValue();

        Assert.assertTrue(mainPage.isHamburgerDropdownContainerDisplayed());
        Assert.assertEquals(actualIfVisible, expectedIfVisible);

        final String actualIfNotVisible = mainPage
                .clickHamburgerMenuIcon()
                .getHamburgerMenuIsActiveValue();

        Assert.assertEquals(actualIfNotVisible, expectedIfNotVisible);
    }


    @Test
    public void testTopMenuLinkAmount() {
        final int expectedTopMenuLinkAmount = 3;

        int actualTopMenuLinkAmount = openBaseURL()
                        .topMenuLinkAmount();

        Assert.assertEquals(actualTopMenuLinkAmount, expectedTopMenuLinkAmount);
    }

    @Test
    public void testCompanyLogoNavigatesToBaseURL() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedURL = "https://dev.swisscows.com/en";
        final String expectedTitle = "Your private and anonymous search engine Swisscows";

        openBaseURL()
                .clickHamburgerMenuIcon()
                .clickSetAsStartAppInHamburgerMenu()
                .clickLogo()
                .switchToAnotherWindow();

        final String actualURL = mainPage.getCurrentURL();
        final String actualTitle = mainPage.getTitle();

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
        MainPage mainPage = new MainPage(getDriver());
        final int expectedNumberOfOptionsHamburgerMenu = 11;
        final List<String> expectedHamburgerMenuListTexts = List.of(
                "Integration", "Set as Startpage", "Make a Default Search Engine", "About Swisscows", "Who we are",
                "Media Education", "Charity Project", "Our Datacenter", "Contact us", "Data privacy",
                "Donation"
        );
        final int actualNumberOfOptionsHamburgerMenu = openBaseURL()
                .setWindowWithHamburgerMenu(ProjectConstants.WIDTH_HAMBURGER_MENU, ProjectConstants.HEIGHT_HAMBURGER_MENU)
                .clickHamburgerMenuIcon()
                .getNumberOfListHamburgerMenu();

        final List<String> actualHamburgerMenuListTexts =mainPage.getHamburgerMenuAllListText();

        Assert.assertTrue(mainPage.isHamburgerIconDisplayed());
        Assert.assertTrue(mainPage.getNumberOfListHamburgerMenu() > 0);
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
        MainPage mainPage = new MainPage(getDriver());
        final int expectedNumberOfOptionsHamburgerMenu = 11;
        final List<String> expectedHamburgerMenuListTexts = List.of(
                "English", "Deutsch", "Español","Français", "Italiano", "Latviešu",
                "Magyar","Nederlands", "Português", "Русский", "Українська"
        );
        final int actualNumberOfOptionsHamburgerMenu = openBaseURL()
                .setWindowWithHamburgerMenu(ProjectConstants.WIDTH_HAMBURGER_MENU, ProjectConstants.HEIGHT_HAMBURGER_MENU)
                .clickHamburgerMenuIcon()
                .clickLanguagesTopMenu()
                .getNumberLangMenu();

        List<String> actualHamburgerMenuListTexts = mainPage.getLangMenuListTexts();

        Assert.assertTrue(mainPage.isHamburgerIconDisplayed());
        Assert.assertTrue(mainPage.getNumberOfListHamburgerMenu() > 0);
        Assert.assertEquals(actualNumberOfOptionsHamburgerMenu, expectedNumberOfOptionsHamburgerMenu);
        Assert.assertEquals(actualHamburgerMenuListTexts, expectedHamburgerMenuListTexts);
    }

    @Test(dataProvider = "LangTopMenuTestData", dataProviderClass = TestData.class)
    public void testLocalizationNavigateToCorrespondingPages(
            int index, String LangName, String expectedURL, String expectedTitle) {

        MainPage mainPage = openBaseURL();

        final String oldURL = mainPage.getCurrentURL();
        final String oldTitle = mainPage.getTitle();

        mainPage
                .clickHamburgerMenu()
                .clickLangDropDown(index);

        final String actualURL = mainPage.getCurrentURL();
        final String actualTitle = getDriver().getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTitle, actualTitle);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testRegionDropdownMenuIsAvailableAndHasOptions_TopMenu() {
        MainPage mainPage = new MainPage(getDriver());

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
        final int actualNumberOfOptionsHamburgerMenu =openBaseURL()
                .clickHamburgerMenuIcon()
                .clickRegionTopMenu()
                .scrollToLastElementInDropdownRegion()
                .getNumberRegionMenu();

        final List<String> actualHamburgerMenuListTexts =mainPage.getLangMenuListTexts();

        Assert.assertTrue(mainPage.isHamburgerIconDisplayed());
        Assert.assertTrue(mainPage.getNumberOfListHamburgerMenu() > 0);
        Assert.assertEquals(actualNumberOfOptionsHamburgerMenu, expectedNumberOfOptionsHamburgerMenu);
        Assert.assertEquals(actualHamburgerMenuListTexts, expectedHamburgerMenuListTexts);
    }

    @Test(dataProvider = "RegionTopMenuTestData", dataProviderClass = TestData.class)
    public void testRegionNavigateToCorrespondingPages(
            int index, String LangName, String expectedURL, String expectedTitle) throws InterruptedException {

        MainPage mainPage = openBaseURL();

        final String oldURL = mainPage.getCurrentURL();
        mainPage
                .clickHamburgerMenu()
                .clickRegionDropDown(index)
                .waitForUrlContains("https://dev.swisscows.com/en?region=");

        final String actualURL = mainPage.getCurrentURL();
        final String actualTitle = getDriver().getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testThemeIsDefaultFirstOpenSite() {
        final String expectedValue = "active";

        final String actualValue = openBaseURL()
                .clickHamburgerMenu()
                .clickThemeDropDownIcon()
                .getClassAttributeThemeDefault();

        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test
    public void tesThemeChanged(){
        final String expectedValue = "active";

        final String actualValueLight =  openBaseURL()
                .clickHamburgerMenu()
                .clickThemeDropDownIcon()
                .clickThemeLight()
                .clickHamburgerMenu()
                .clickThemeDropDownIcon()
                .getClassAttributeThemeLight();

        Assert.assertEquals(actualValueLight, expectedValue);
    }

    @Test
    public void tesThemeOfBodyChanged()  {
        final String expectedValue = "dark";

        final String actualValueLight = openBaseURL()
                .clickHamburgerMenu()
                .clickThemeDropDownIcon()
                .clickThemeDark()
                .getClassAttributeBodyOfSite();

        Assert.assertEquals(actualValueLight, expectedValue);


    }
    @Test
    public void testThemeMenuTexts() {
        final List<String> expectedList = List.of(
                "Default",
                "Light",
                "Dark"
        );

        final List actualList = openBaseURL()
                .clickHamburgerMenuIcon()
                .clickThemeDropDownIcon()
                .getLangMenuListTexts();
        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void testLoginUserAndAvatarIconIsDysplaed() {

        MainPage mainPage = openBaseURL()
                .clickHamburgerMenu()
                .signIn()
                .waitTopMenuToBeInvisible()
                .clickHamburgerMenu();

        Assert.assertTrue(mainPage.isAvatarIconIsDisplayedInHamburgerMenu());

    }

    @Test
    public void testLoginUserAndNicknameIsDysplaed() {
        final String expectedNick = "a" +"\n" +"a.qa@swisscows.email";

        final String nickname = openBaseURL()
                .clickHamburgerMenu()
                .signIn()
                .waitTopMenuToBeInvisible()
                .clickHamburgerMenu()
                .getNicknameInHamburgerMenu();

        Assert.assertEquals(nickname, expectedNick);
    }
        @Test
        public void testLogOutUserAndLoginButtonIsDysplaed()  {
            MainPage mainPage = new MainPage(getDriver());
            final String actualUrl =openBaseURL()
                    .clickHamburgerMenu()
                    .signIn()
                    .waitTopMenuToBeInvisible()
                    .logOut()
                    .waitTopMenuToBeInvisible()
                    .clickHamburgerMenu()
                    .getCurrentURL();

            Assert.assertTrue(mainPage.isLoginIconDisplayed());
            Assert.assertTrue(actualUrl.contains("https://dev.swisscows.com/"));

    }
    @Test
    public void testHeartIconMessageIsDysplaed_MainPage() {

        final String expectedTextHeartPopup = "This is the number of your Swisscows searches."
                + " On average, 50 search queries finance a children's meal.";

        final String  actualTextHeartPopup = openBaseURL()
                .clickHeartIcon()
                .getHeartPopupMessage();


        Assert.assertEquals(actualTextHeartPopup,expectedTextHeartPopup);

    }
    @Test
    public void testCharityQueryCounterAtTheBeginning_MainPage() {

        final String expectedValueHeartIcon = "0";

        final String  actualValueHeartIcon = openBaseURL()
                .getValueHeartIcon();

        Assert.assertEquals(actualValueHeartIcon,expectedValueHeartIcon);

    }
    @Test
    public void testCharityQueryCounterAfterReloadPage_MainPage() {
        final String expectedValueHeartIcon = "0";

        final String  actualValueHeartIcon = openBaseURL()
                .refreshMainPage()
                .getValueHeartIcon();

        Assert.assertEquals(actualValueHeartIcon,expectedValueHeartIcon);

    }
    @Test
    public void testCharityQueryCounterSearch_MainPage() {

        final String expectedValueHeartIcon = "1";

        final String  actualValueHeartIcon = openBaseURL()
                .inputSearchCriteriaAndEnter("news")
                .waitUntilVisibilityWebResult()
                .goBackToMainPage()
                .refreshMainPage()
                .getValueHeartIcon();

        Assert.assertEquals(actualValueHeartIcon,expectedValueHeartIcon);

    }
    @Test
    public void testCharityQueryCounterSearchImage() {

        final String expectedValueHeartIcon = "2";

        final String  actualValueHeartIcon = openBaseURL()
                .inputSearchCriteriaAndEnter("news")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitCharityValueCountChanged("1")
                .getValueHeartIcon();

        Assert.assertEquals(actualValueHeartIcon,expectedValueHeartIcon);

    }
    @Test
    public void testCharityQueryCounterSearchVideo() {
        VideoPage videoPage  = new VideoPage(getDriver());

        final String expectedValueHeartIcon = "2";

        openBaseURL()
                .inputSearchCriteriaAndEnter("news")
                .waitUntilVisibilityWebResult()
                .clickVideoButton();

        final String  actualValueHeartIcon = videoPage
                .waitUntilVisibilityVideoResult()
                .getValueHeartIcon();

        Assert.assertEquals(actualValueHeartIcon,expectedValueHeartIcon);

    }
    @Test
    public void testCharityQueryCounterSearchNews() {
        NewsPage newsPage = new NewsPage(getDriver());
        final String expectedValueHeartIcon = "3";

        openBaseURL()
                .inputSearchCriteriaAndEnter("news")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains("https://dev.swisscows.com/en/web?query=news&region=de-DE");

        final String  actualValueHeartIcon = newsPage
                .clickNewsButton()
                .waitUntilVisibilityNewsResult()
                .getValueHeartIcon();

        Assert.assertEquals(actualValueHeartIcon,expectedValueHeartIcon);
    }
    @Test
    public void testHeartIconMessageIsDysplaed_SearchPages() {

        final String expectedTextHeartPopup = "This is the number of your Swisscows searches."
                + " On average, 50 search queries finance a children's meal.";

        final String  actualTextHeartPopup = openBaseURL()
                .inputSearchCriteriaAndEnter("123")
                .waitUntilVisibilityWebResult()
                .clickHeartIcon()
                .getHeartPopupMessage();


        Assert.assertEquals(actualTextHeartPopup,expectedTextHeartPopup);

    }
    @Test
    public void testEmailIconNavigatesToLoginPageIfLoggedIn() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedEmailURL = "https://accounts.swisscows.com/login?ReturnUrl";
        final String expectedH1Text = "Login";

        openBaseURL()
                .clickHamburgerMenu()
                .signIn()
                .clickEmailTopMenu()
                .switchToExternalPage();

        final String actualH1text = mainPage.getH1Text();

        Assert.assertTrue(getExternalPageURL().contains(expectedEmailURL));
        Assert.assertEquals(actualH1text,expectedH1Text);

    }
    @Test
    public void testEmailIconNavigatesToLoginPageIfLoggedIn_SearchPage() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedEmailURL = "https://accounts.swisscows.com/login?ReturnUrl";
        final String expectedH1Text = "Login";

        openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .signIn()
                .clickEmailTopMenuSearch()
                .switchToExternalPage();

        final String actualH1text = mainPage.getH1Text();

        Assert.assertTrue(getExternalPageURL().contains(expectedEmailURL));
        Assert.assertEquals(actualH1text,expectedH1Text);

    }

    @Test
    public void testVpnIconNavigatesToVpnPage_SearchPage() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedURL = "https://dev.swisscows.com/en/anonymous-vpn";
        final String expectedTitle = "Anonymous web surfing with Swisscows";

        openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickVpnTopMenuSearch()
                .switchToExternalPage();

        final String actualH1text = mainPage.getH1Text();

        Assert.assertEquals(getExternalPageURL(), expectedURL);
        Assert.assertEquals(actualH1text,expectedTitle);

    }
    @Test
    public void testTeleGuardIconNavigatesToTeleGuardPage_SearchPage() {
        final String expectedURL = "https://teleguard.com/en";
        final String expectedTitle = "TeleGuard - secure messenger from Switzerland";

        openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickTeleGuardTopMenuSearch()
                .switchToExternalPage();

        final String actualH1text = getExternalPageTitle();

        Assert.assertEquals(getExternalPageURL(), expectedURL);
        Assert.assertEquals(actualH1text,expectedTitle);

    }

}
