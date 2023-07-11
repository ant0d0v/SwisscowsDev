package tests.header;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import tests.retrytest.Retry;
import utils.ProjectConstants;

import java.util.List;

public class TopMenuTest extends BaseTest {
    @QaseTitle("TeleGuard icon navigates to the TeleGuard web page.")
    @QaseId(value = 4918)
    @Test
    public void testTeleGardIconNavigatesToTeleGardWebPage() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedPartialInstagramURL = "https://teleguard.com/en";

        final String oldURL = openBaseURL().getCurrentURL();
        mainPage
                .clickTeleGuardTopMenu()
                .switchToExternalPage();

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedPartialInstagramURL);

    }
    @QaseTitle("Email icon navigates to the Email web page.")
    @QaseId(value = 4919)
    @Test(retryAnalyzer = Retry.class)
    public void testEmailIconNavigatesToEmailWebPage() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedEmailURL = ProjectConstants.DOMAIN +"/en/swisscows-email";
        final String expectedH1Text = "A letter is your personal property!";

        final String oldURL = openBaseURL().getCurrentURL();
        mainPage
                .clickEmailTopMenu()
                .switchToExternalPage();
        final String actualH1text = mainPage
                .getH1Text();


        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedEmailURL);
        Assert.assertEquals(actualH1text,expectedH1Text);

    }
    @QaseTitle("VPN icon navigates to the VPN web page.")
    @QaseId(value = 4920)
    @Test
    public void testVPNIconNavigatesToVPNWebPage() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedURL = ProjectConstants.DOMAIN + "/en/anonymous-vpn";
        final String expectedH1text = "Anonymous web surfing with Swisscows";

        final String oldURL = openBaseURL()
                .getCurrentURL();

        String actualURL = mainPage
                .clickVPNTopMenu()
                .getCurrentURL();

        final String actualH1text = mainPage.getH1Text();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualH1text, expectedH1text);
    }

    @QaseTitle("Texts of the links in the hamburger menu.")
    @QaseId(value = 4921)
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
                .getLinksOfText();

        Assert.assertEquals(actualList, expectedList);
    }
    @QaseTitle("Hamburger menu can be clicked and its visibility changes accordingly.")
    @QaseId(value = 4922)
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
    @QaseTitle("Check number of top menu links")
    @QaseId(value = 4923)
    @Test
    public void testTopMenuLinkAmount() {
        final int expectedTopMenuLinkAmount = 3;

        int actualTopMenuLinkAmount = openBaseURL()
                        .topMenuLinkAmount();

        Assert.assertEquals(actualTopMenuLinkAmount, expectedTopMenuLinkAmount);
    }
    @QaseTitle("Clicking on the company's logo leads to the basic URL address.")
    @QaseId(value = 4924)
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
    @QaseTitle("Each hamburger menu links navigates to the corresponding page.")
    @QaseId(value = 4925)
    @Test(dataProvider = "hamburgerTestData", dataProviderClass = TestData.class)
    public void testEachHamburgerMenuLinksNavigatesToCorrespondingPage(
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
    @QaseTitle("Check Availability and Options of Hamburger Menu in Top Menu")
    @QaseId(value = 4926)
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

        final List<String> actualHamburgerMenuListTexts = mainPage.getHamburgerMenuAllListText();

        Assert.assertTrue(mainPage.isHamburgerIconDisplayed());
        Assert.assertTrue(mainPage.getNumberOfListHamburgerMenu() > 0);
        Assert.assertEquals(actualNumberOfOptionsHamburgerMenu, expectedNumberOfOptionsHamburgerMenu);
        Assert.assertEquals(actualHamburgerMenuListTexts, expectedHamburgerMenuListTexts);
    }

    @QaseTitle("Check navigation account Page when clicking SingIn from hamburger menu")
    @QaseId(value = 4927)
    @Test
    public void testNavigationAccountPageWhenClickingSingInFromHamburgerMenu() {
        MainPage mainPage = new MainPage(getDriver());

        final String oldURL = openBaseURL().getCurrentURL();

        final String actualURL = mainPage
                .clickHamburgerMenu()
                .clickSignInMenu()
                .getCurrentURL();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertTrue(actualURL.contains(ProjectConstants.URL_ACCOUNTS), " PageURL does not contain 'accounts.dev.swisscows.com' ");

    }
    @QaseTitle("Check availability and options of localization dropdown menu in hamburger Menu")
    @QaseId(value = 4928)
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
                .clickLanguagesHamburgerMenu()
                .getNumberLangMenu();

        List<String> actualHamburgerMenuListTexts = mainPage.getLangMenuListTexts();

        Assert.assertTrue(mainPage.isHamburgerIconDisplayed());
        Assert.assertTrue(mainPage.getNumberOfListHamburgerMenu() > 0);
        Assert.assertEquals(actualNumberOfOptionsHamburgerMenu, expectedNumberOfOptionsHamburgerMenu);
        Assert.assertEquals(actualHamburgerMenuListTexts, expectedHamburgerMenuListTexts);
    }
    @QaseTitle("Check navigation to corresponding pages for localization")
    @QaseId(value = 4929)
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
    @QaseTitle("Check  availability and options of region dropdown menu in hamburger menu")
    @QaseId(value = 4930)
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
        final int actualNumberOfOptionsHamburgerMenu = openBaseURL()
                .clickHamburgerMenuIcon()
                .clickRegionTopMenu()
                .scrollToLastElementInDropdownRegion()
                .getNumberRegionMenu();

        final List<String> actualHamburgerMenuListTexts = mainPage.getLangMenuListTexts();

        Assert.assertTrue(mainPage.isHamburgerIconDisplayed());
        Assert.assertTrue(mainPage.getNumberOfListHamburgerMenu() > 0);
        Assert.assertEquals(actualNumberOfOptionsHamburgerMenu, expectedNumberOfOptionsHamburgerMenu);
        Assert.assertEquals(actualHamburgerMenuListTexts, expectedHamburgerMenuListTexts);
    }
    @QaseTitle("Check navigation to corresponding pages for region")
    @QaseId(value = 4931)
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
        final String actualTitle = mainPage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @QaseTitle("Check default theme on first opening the site")
    @QaseId(value = 4932)
    @Test
    public void testThemeIsDefaultFirstOpenSite() {
        final String expectedValue = "active";

        final String actualValue = openBaseURL()
                .clickHamburgerMenu()
                .clickThemeDropDownIcon()
                .getClassAttributeThemeDefault();

        Assert.assertEquals(actualValue, expectedValue);

    }
    @QaseTitle("Check theme change to light theme")
    @QaseId(value = 4933)
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
    @QaseTitle("Theme change of body")
    @QaseId(value = 4934)
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
    @QaseTitle("Check Theme menu texts")
    @QaseId(value = 4935)
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
    @QaseTitle("Check  login User and display of avatar image in hamburger menu")
    @QaseId(value = 4936)
    @Test
    public void testLoginUserAndAvatarIconIsDysplaed() {

        MainPage mainPage = openBaseURL()
                .clickHamburgerMenu()
                .signIn()
                .waitTopMenuToBeVisible()
                .clickHamburgerMenu();

        Assert.assertTrue(mainPage.isAvatarIconIsDisplayedInHamburgerMenu());

    }
    @QaseTitle("Check  login User and display of nickname in hamburger menu")
    @QaseId(value = 4937)
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
    @QaseTitle("Check Log Out user and display of login button")
    @QaseId(value = 4938)
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
    @QaseTitle("Check that display of heart icon message on the main Page")
    @QaseId(value = 4939)
    @Test
    public void testHeartIconMessageIsDysplaed_MainPage() {

        final String expectedTextHeartPopup = "This is the number of your Swisscows searches."
                + " On average, 50 search queries finance a children's meal.";

        final String  actualTextHeartPopup = openBaseURL()
                .clickHeartIcon()
                .getHeartPopupMessage();

        Assert.assertEquals(actualTextHeartPopup,expectedTextHeartPopup);
    }
    @QaseTitle("Check charity query counter value at the Beginning")
    @QaseId(value = 4940)
    @Test
    public void testCharityQueryCounterAtTheBeginning_MainPage() {

        final String expectedValueHeartIcon = "0";

        final String  actualValueHeartIcon = openBaseURL()
                .getValueHeartIcon();

        Assert.assertEquals(actualValueHeartIcon,expectedValueHeartIcon);

    }
    @QaseTitle("Check charity query counter value after refresh page")
    @QaseId(value = 4941)
    @Test
    public void testCharityQueryCounterAfterReloadPage_MainPage() {
        final String expectedValueHeartIcon = "0";

        final String  actualValueHeartIcon = openBaseURL()
                .refreshMainPage()
                .getValueHeartIcon();

        Assert.assertEquals(actualValueHeartIcon,expectedValueHeartIcon);

    }
    @QaseTitle("Check charity query counter value after search and go back to main bage ")
    @QaseId(value = 4942)
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
    @QaseTitle("Check query counter value when searching for images ")
    @QaseId(value = 4943)
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
    @QaseTitle("Check query counter value when searching for videos ")
    @QaseId(value = 4944)
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
    @QaseTitle("Check query counter value when searching for news ")
    @QaseId(value = 4945)
    @Test
    public void testCharityQueryCounterSearchNews() {
        final String expectedValueHeartIcon = "2";

        final String  actualValueHeartIcon = openBaseURL()
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
    @QaseTitle("Check message is dysplaed after click heart icon")
    @QaseId(value = 4946)
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
    @QaseTitle("Check that email icon navigates to login page if user logged in ")
    @QaseId(value = 4947)
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
    @QaseTitle("Check that email icon navigates to login page if user logged in on the search page  ")
    @QaseId(value = 4948)
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
    @QaseTitle("VPN icon navigates to the VPN web page for search page")
    @QaseId(value = 4949)
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
    @QaseTitle("VPN icon navigates to the VPN web page for search page")
    @QaseId(value = 4950)
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
