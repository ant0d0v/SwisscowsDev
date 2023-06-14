package tests.header;

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
        final String expectedEmailURL = ProjectConstants.DOMAIN +"/en/swisscows-email";
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
        MainPage mainPage = new MainPage(getDriver());
        final String expectedURL = ProjectConstants.DOMAIN + "/en/anonymous-vpn";
        final String expectedTitle = ProjectConstants.TITLE_VPN_PAGE ;

        final String oldURL = openBaseURL()
                .getCurrentURL();

        String actualURL = mainPage
                .clickVPNTopMenu()
                .getCurrentURL();

        final String actualTitle = mainPage.getTitle();

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
                "Donation",
                "Support"
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
        final String expectedURL = ProjectConstants.DOMAIN +"/en";
        final String expectedTitle = ProjectConstants.TITLE_MAIN_PAGE;

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
        MainPage mainPage = new MainPage(getDriver());


        final String oldURL = openBaseURL()
                .getCurrentURL();

        mainPage.clickTopMenu(index);

        final String actualURL = getDriver().getCurrentUrl();


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
        final int expectedNumberOfOptionsHamburgerMenu = 12;
        final List<String> expectedHamburgerMenuListTexts = List.of(
                "Integration", "Set as Startpage", "Make a Default Search Engine", "About Swisscows", "Who we are",
                "Media Education", "Charity Project", "Our Datacenter", "Contact us", "Data privacy",
                "Donation", "Support"
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
        final String expectedURLPartial = ProjectConstants.URL_ACCOUNTS;
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

        final int expectedNumberOfOptionsHamburgerMenu = 48;
        final List<String> expectedHamburgerMenuListTexts = List.of(
                "Argentina", "Australia", "Austria", "Belgium (FR)", "Belgium (NL)",
                "Brazil", "Canada (EN)", "Canada (FR)", "Chile", "China", "Denmark", "Finland", "France",
                "Germany", "Hong Kong SAR", "Hungary", "India", "Indonesia","Ireland", "Italy", "Japan",
                "Kazakhstan", "Korea", "Latvia", "Malaysia", "Mexico", "Netherlands",
                "New Zealand", "Nigeria", "Norway","Paraguay", "Philippines", "Poland", "Portugal", "Russia", "Saudi Arabia", "South Africa"
                , "Spain", "Sweden", "Switzerland (DE)", "Switzerland (FR)", "Taiwan", "Turkey", "Ukraine", "United Kingdom"
                , "United States (EN)", "United States (ES)", "World-wide"
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
            int index, String LangName, String expectedURL, String expectedTitle){

        MainPage mainPage = openBaseURL();

        final String oldURL = mainPage.getCurrentURL();
        mainPage
                .clickHamburgerMenu()
                .clickRegionDropDown(index)
                .waitForUrlContains(ProjectConstants.DOMAIN +"/en?region=");

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
                .waitTopMenuToBeVisible()
                .clickHamburgerMenu();

        Assert.assertTrue(mainPage.isAvatarIconIsDisplayedInHamburgerMenu());

    }

    @Test
    public void testLoginUserAndNicknameIsDysplaed() {
        final String expectedNick = "a" +"\n" +"a.qa@swisscows.email";

        final String nickname = openBaseURL()
                .clickHamburgerMenu()
                .signIn()
                .waitTopMenuToBeVisible()
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
                    .waitTopMenuToBeVisible()
                    .logOut()
                    .waitTopMenuToBeVisible()
                    .clickHamburgerMenu()
                    .getCurrentURL();

            Assert.assertTrue(mainPage.isLoginIconDisplayed());
            Assert.assertTrue(actualUrl.contains(ProjectConstants.DOMAIN));

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
    public void testCharityQueryCounterSearchAndGoBack_MainPage() {

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
                .waitUrlToBeChanged("/en/images?query=news")
                .waitCharityValueCountChanged("2")
                .getValueHeartIcon();

        Assert.assertEquals(actualValueHeartIcon,expectedValueHeartIcon);

    }
    @Test
    public void testCharityQueryCounterSearchVideo() {

        final String expectedValueHeartIcon = "2";

        final String  actualValueHeartIcon = openBaseURL()
                .inputSearchCriteriaAndEnter("news")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUrlToBeChanged("/en/video?query=news")
                .waitCharityValueCountChanged("2")
                .getValueHeartIcon();

        Assert.assertEquals(actualValueHeartIcon,expectedValueHeartIcon);

    }
    @Test
    public void testCharityQueryCounterSearchNews() {
        final String expectedValueHeartIcon = "2";

        final String  actualValueHeartIcon =openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("news")
                .waitUntilVisibilityWebResult()
                .clickNewsButton()
                .waitUrlToBeChanged("/en/news?query=news&region=de-DE")
                .waitCharityValueCountChanged("2")
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
        final String expectedURL = ProjectConstants.DOMAIN + "/en/anonymous-vpn";
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
