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
        final int expectedSizeSuggest = 5;

        MainPage mainPage = openBaseURL();

        mainPage
                .clickSearchField()
                .inputSearchCriteria(query)
                .clickMainLogo()
                .clickSearchField()
                .waitForSuggestToBeVisible();

        final int actualSizeSuggest = mainPage.countElementsInSuggestContainer();

        Assert.assertTrue(mainPage.suggestIsDisplayed());
        Assert.assertTrue(actualSizeSuggest > 0);
        Assert.assertEquals(actualSizeSuggest, expectedSizeSuggest);



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

        final List<String> actualSuggestion = mainPage.getAllElementsText();

        final int actualSizeSuggest = mainPage.countElementsInSuggestContainer();

        for (String searchCriteria : actualSuggestion) {
            Assert.assertTrue(mainPage.suggestIsDisplayed());
            Assert.assertTrue(actualSizeSuggest > 0);
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

        final String oldUrl  = mainPage.getCurrentURL();
        mainPage
                .waitForImageInBannerDisappeared();
        mainPage
                .clickHomeBanner()
                .switchToAnotherWindow();

        TestUtils.waitForPageLoaded(getDriver());
        final String actualUrl = mainPage.getCurrentURL();

        Assert.assertNotEquals(oldUrl,actualUrl);
        Assert.assertEquals(actualUrl,expectedUrl);
    }
    @Test
    public void testHomePageBannerSwitching ()  {

        final String expectedValue = "swiper-slide swiper-slide-next";

        MainPage mainPage = openBaseURL();
        mainPage
                .clickBannerSwitch();
        final String valueSecondSwitch = mainPage.getClassAttributeSwitchSecond();

        mainPage
                .clickBannerSwitchFirst();
        final String valueFirstSwitch = mainPage.getClassAttributeSwitchFirst();

        Assert.assertEquals(valueFirstSwitch,expectedValue);
        Assert.assertNotEquals(valueSecondSwitch,valueFirstSwitch);

    }

    @Test
    public void testHomePageBannerSwitchingAuto ()  {

        final String expectedValue = "swiper-slide swiper-slide-active";

        MainPage mainPage = openBaseURL();
        mainPage
                .waitForImageInBannerDisappeared();
        final String actualValue = mainPage.getClassAttributeSwitchSecond();

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
        MainPage mainPage =  openBaseURL();

        mainPage
                .setWindowWithHamburgerMenu(ProjectConstants.WIDTH_HAMBURGER_MENU, ProjectConstants.HEIGHT_HAMBURGER_MENU);

        Assert.assertTrue(new MainPage(getDriver()).isHomePageLogoDisplayed());
        Assert.assertTrue(mainPage.isTittleWhySwisscowsIsDisplayed());
        Assert.assertTrue(mainPage.isDisplayedWhySwisscowsBlock1());
        Assert.assertTrue(mainPage.isDisplayedWhySwisscowsBlock2());
        Assert.assertTrue(mainPage.isDisplayedWhySwisscowsBlock3());

    }
    @Test
    public void testQuestionsTextsMainPage() {
        List<String> expectedH3Texts = List.of(
                "What distinguishes the anonymous search engine Swisscows from other search engines?",
                "Who guarantees that my data is really not stored in the private search engine Swisscows?",
                "Are the search results on the private search engine Swisscows as good as on other search engines?",
                "How can I switch from another search engine to the anonymous search engine Swisscows?",
                "How does the anonymous search engine Swisscows earn its money?",
                "Why is the private search engine Swisscows against surveillance?"
        );
        List actualH3Texts = openBaseURL()
                .scrollToQuestions()
                .getH3Texts();
        Assert.assertTrue(actualH3Texts.size() > 0);
        Assert.assertEquals(actualH3Texts, expectedH3Texts);
    }

    @Test
    public void testAnswersTextsMainPage() {
        List<String> expectedH3Texts = List.of(
                "Our anonymous search engine protects the privacy of our users when searching and from inappropriate content when finding it."
                        + " We do not use cookies or other tracking technologies, with us each search query remains anonymous and each user a guest without a user profile.",
                "Protecting our users' data is an essential part of our DNA and thus a core promise of the anonymous search engine Swisscows. "
                        + "We do not store data, build search history or deliver ads based on collected data. Our technology is built in such a way that the storage of user data is not even possible.",
                "With us you are sure to find what you are looking for! Thanks to the cooperation of our anonymous search engine with Bing, "
                        + "as well as over 20 years of experience and research in the field of search technologies and a constant development, there are hardly any search requests that we cannot fulfill. The index-based country search and Swisscow's semantics ensure intelligent and fast finding.",
                "Switching is possible at any time. To use the anonymous search engine Swisscows as the default search engine in the browser "
                        + "(Chrome, Edge, Firefox, etc.), simply click on the link that appears below the search box and follow the browser-specific instructions. This is as simple and safe as searching with the anonymous search engine Swisscows.",
                "We earn money with search ads delivered by Bing. Swisscows has an exclusive cooperation agreement with Bing. "
                        + "These ads appear exclusively based on your own search query, which is submitted to Bing. The anonymous search engine Swisscows does not collect personal data and accordingly cannot transmit any data. From each click on an ad, Swisscows receives a share of the advertising revenue from Bing. In this way, we continue to invest in our technology and support social projects.",
                "Our vision is that every user can be online without fear of surveillance, annoying advertising and unwanted data storage."
                        + " We have been working towards this goal for over 20 years. Fortunately, data security has now become a relevant topic and many people have understood what all happens to their data completely without their knowledge.\n"
                        + "We don't want to share our users' data, we want to value it. That's why we developed Swisscows, the anonymous search engine, and other products:\n"
                        + "• TeleGuard - our data secure messenger (WhatsApp alternative)\n"
                        + "• Swisscows - works like a firewall and also helps to visit websites anonymously\n"
                        + "• GetDigest - an AI-based program that helps summarize web content and text documents and quickly delivers the relevant information.\n"
                        + "Our growing team continues to develop and research innovations that protect users and their privacy on the World Wide Web."

        );
        List actualH3Texts = openBaseURL()
                .scrollToQuestions()
                .clickAllQuestions()
                .getAnswersTexts();
        Assert.assertTrue(actualH3Texts.size() > 0);
        Assert.assertEquals(actualH3Texts, expectedH3Texts);
    }



}

