package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.ProjectConstants;
import utils.TestUtils;

import java.util.List;

public class MainTest extends BaseTest {

    @Test
    public void testSuggestIsDysplaed() {
        final String query = "test";

        MainPage mainPage = openBaseURL();

        mainPage
                .clickSearchField()
                .inputSearchCriteria(query)
                .clickMainLogo()
                .clickSearchField()
                .waitForSuggestToBeVisible();



        Assert.assertTrue(mainPage.suggestIsDisplayed());


    }

    @Test
    public void testSuggestEqualsSearchCriteria() {
        final String query = "ivan";

        MainPage mainPage = openBaseURL();

        mainPage
                .clickSearchField()
                .inputSearchCriteria(query)
                .clickMainLogo()
                .clickSearchField()
                .waitForSuggestToBeVisible();

        List<String> actualSuggestion = mainPage.getAllElementsText();

        for (String searchCriteria : actualSuggestion) {
            Assert.assertTrue(searchCriteria.contains(query));

        }
    }

    @Test
    public void testHomePageBanner() {

        MainPage mainPage = openBaseURL();

        Assert.assertTrue(mainPage.homePageBannerIsDisplayed());
    }



    @Test
    public void testHomePageBannerClickable () {

        final String expectedUrl = "https://dev.swisscows.com/en/music?query=popular+music";

        MainPage mainPage = openBaseURL();
        mainPage
                .waitForImageInBannerDisappeared();
        mainPage
                .clickHomeBanner()
                .switchToAnotherWindow();

        TestUtils.waitForPageLoaded(getDriver());


        String actualUrl = mainPage.getCurrentURL();

        Assert.assertEquals(actualUrl,expectedUrl);
    }
    @Test
    public void testHomePageBannerSwitching ()  {


        MainPage mainPage = openBaseURL();
        mainPage
                .clickBannerSwitch();
        String valueSecondSwitch = mainPage.getClassAttributeSwitchSecond();

        mainPage
                .clickBannerSwitchFirst();
        String valueFirstSwitch = mainPage.getClassAttributeSwitchFirst();


        Assert.assertNotEquals(valueSecondSwitch,valueFirstSwitch);

    }

    @Test
    public void testHomePageBannerSwitchingAuto ()  {

        final String expectedValue = "swiper-slide swiper-slide-active";

        MainPage mainPage = openBaseURL();
        mainPage
                .waitForImageInBannerDisappeared();
        String actualValue = mainPage.getClassAttributeSwitchSecond();
        Assert.assertEquals(actualValue,expectedValue);


    }

    @Test
    public void testCursorInSearchField() {
        final String query = "test";

        MainPage mainPage = openBaseURL();

        mainPage.inputSearchCriteria(query);


    }

    //Check that all questions were open
    @Test
    public void testQuestionAndAnswersWasOpened() {

        final String expectedClass = "faq open";

        MainPage mainPage = openBaseURL();

        mainPage
                .scrollToQuestions()
                .clickAllQuestions();

        String actualClassAttributeQuestion1 = mainPage.getClassAttributeQuestion1();
        String actualClassAttributeQuestion2 = mainPage.getClassAttributeQuestion2();
        String actualClassAttributeQuestion3 = mainPage.getClassAttributeQuestion3();
        String actualClassAttributeQuestion4 = mainPage.getClassAttributeQuestion4();
        String actualClassAttributeQuestion5 = mainPage.getClassAttributeQuestion5();
        String actualClassAttributeQuestion6 = mainPage.getClassAttributeQuestion6();

        Assert.assertEquals(actualClassAttributeQuestion1,expectedClass);
        Assert.assertEquals(actualClassAttributeQuestion2,expectedClass);
        Assert.assertEquals(actualClassAttributeQuestion3,expectedClass);
        Assert.assertEquals(actualClassAttributeQuestion4,expectedClass);
        Assert.assertEquals(actualClassAttributeQuestion5,expectedClass);
        Assert.assertEquals(actualClassAttributeQuestion6,expectedClass);

    }
    //Check that the issue is closes
    @Test
    public void testQuestionAndAnswersOpenAndClose() {

        final String expectedClassOpen = "faq open";
        final String expectedClassCloses = "faq";

        MainPage mainPage = openBaseURL();

        mainPage
                .scrollToQuestions()
                .clickQuestion1();
        String actualClassAttributeQuestionOpen = mainPage.getClassAttributeQuestion1();
        Assert.assertEquals(actualClassAttributeQuestionOpen,expectedClassOpen);

        mainPage
                .clickQuestion1()
                .waitForAnswerToBeInvisible();

        String actualClassAttributeQuestionCloses = mainPage.getClassAttributeQuestion1();
        Assert.assertEquals(actualClassAttributeQuestionCloses,expectedClassCloses);


    }
    @Test
    public void testLinkIn4Question() {

        final String expectedUrl = "https://dev.swisscows.com/en/default-search";

        MainPage mainPage = openBaseURL();
        mainPage
                .scrollToQuestions()
                .clickQuestion4()
                .clickLinkInQuestion4();
        mainPage.switchToAnotherWindow();
        String actualUrl = mainPage.getCurrentURL();

        Assert.assertEquals(actualUrl,expectedUrl);


    }

    @Test
    public void testClickableAndVisibleInstallGoogleBlock() {

        final String expectedUrl = "https://chrome.google.com/webstore/detail/swisscows/ibimaeimnogcdnjmmlpodbhhbejnpaij?hl=en";

        MainPage mainPage = openBaseURL();
        mainPage
                .scrollToBlockGooglePopup()
                .clickInstallGoogleBlockPopup()
                .switchToAnotherWindow();


        String actualUrl = getExternalPageURL();
        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @Test
    public void testAmountLinksInTheFooter() {

        MainPage mainPage = openBaseURL();
        mainPage
                .scrollToFooter()
                .waitForFooterPanelToBeVisible();

        int actualUrl = mainPage.getAllLinks().size();
        Assert.assertEquals(actualUrl, 25);


    }

    @Test
    public void testClickebleLinkLearnMore() {
        final String expectedUrl = "https://hesbox.com/en";

        MainPage mainPage = openBaseURL();
        mainPage
                .scrollToOurService()
                .clickLinkLearnMoreInOurService();
        mainPage.switchToAnotherWindow();

        String actualLearnMoreUrl = getExternalPageURL();

        Assert.assertEquals(actualLearnMoreUrl,expectedUrl);


    }

    @Test
    public void testClickebleLinkFanShop() {
        final String expectedUrl = "https://swisscows-fanshop.com/";

        MainPage mainPage = openBaseURL();
        mainPage
                .scrollToOurService()
                .clickLinkFanShopInOurService();
        mainPage.switchToAnotherWindow();

        String actualFanShopUrl = getExternalPageURL();

        Assert.assertEquals(actualFanShopUrl,expectedUrl);


    }

    @Test
    public void testClickebleLinkWiebeBlog() {
        final String expectedUrl = "https://awiebe.org/";

        MainPage mainPage = openBaseURL();
        mainPage
                .scrollToOurService()
                .clickLinkWiebeBlogInOurService();
        mainPage.switchToAnotherWindow();

        String actualWiebeBlogUrl = getExternalPageURL();

        Assert.assertEquals(actualWiebeBlogUrl,expectedUrl);


    }
    @Test
    public void testPopupIsDysplaed() {

        MainPage mainPage = openBaseURL();
        mainPage
                .waitForPopupGoogleInstallToBeVisible();

        Assert.assertTrue(mainPage.isPopupGoogleDisplayed());


    }

    @Test
    public void testPopupGoogleRedirectToInstall() {

        final String expectedUrl = "https://chrome.google.com/webstore/detail/swisscows/ibimaeimnogcdnjmmlpodbhhbejnpaij?hl=en";

        MainPage mainPage = openBaseURL();
        mainPage
                .waitForPopupGoogleInstallToBeVisible();
        mainPage
                .clickPopupGoogle()
                .switchToAnotherWindow();

        String actualUrl = getExternalPageURL();
        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @Test
    public void testBlockWhySwisscowsIsDisplayed() {

        MainPage mainPage = openBaseURL();

        Assert.assertTrue(mainPage.isTittleWhySwisscowsIsDisplayed());
        Assert.assertTrue(mainPage.isDisplayedWhySwisscowsBlock1());
        Assert.assertTrue(mainPage.isDisplayedWhySwisscowsBlock2());
        Assert.assertTrue(mainPage.isDisplayedWhySwisscowsBlock3());

    }

    @Test
    public void testPlaceholderIsAvailable_Main() {
        final String expectedInnerTextOfPlaceholder = "Your search. Your business.";
        final String attribute = "placeholder";

        MainPage mainPage = openBaseURL();
        Assert.assertTrue(mainPage.isPlaceholderDisplayedMain());

        String actualInnerTextOfPlaceholder = mainPage.getInnerTextOfPlaceholderMain(attribute);

        Assert.assertEquals(actualInnerTextOfPlaceholder, expectedInnerTextOfPlaceholder);
    }

    @Test
    public void testAdaptiveHomePageHasLogo() {


        MainPage mainPage =  openBaseURL()
                .setWindowWithHamburgerMenu(ProjectConstants.WIDTH_HAMBURGER_MENU, ProjectConstants.HEIGHT_HAMBURGER_MENU);

        Assert.assertTrue(new MainPage(getDriver()).isHomePageLogoDisplayed());

    }



}

