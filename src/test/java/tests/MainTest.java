package tests;
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

public class MainTest extends BaseTest {
    @QaseTitle("Check that suggest feature is displayed")
    @QaseId(value = 4891)
    @Test
    public void testSuggestIsDysplaed() {
        MainPage mainPage = openBaseURL()
                .clickSearchField()
                .inputSearchCriteria("test")
                .clickMainLogo()
                .clickSearchField()
                .waitForSuggestToBeVisible();

        final int actualSizeSuggest = mainPage.countElementsInSuggestContainer();

        Assert.assertTrue(mainPage.suggestIsDisplayed());
        Assert.assertTrue(actualSizeSuggest > 0);
        Assert.assertEquals(actualSizeSuggest, 5);
    }
    @QaseTitle("Check the list of suggestions from the suggest container.")
    @QaseId(value = 4893)
    @Test
    public void testSuggestEqualsSearchCriteria() {
        MainPage mainPage = openBaseURL()
                .clickSearchField()
                .inputSearchCriteria("ivan")
                .clickMainLogo()
                .clickSearchField()
                .waitForSuggestToBeVisible();

        final List<String> actualSuggestion = mainPage.getAllElementsText();

        final int actualSizeSuggest = mainPage.countElementsInSuggestContainer();

        for (String searchCriteria : actualSuggestion) {
            Assert.assertTrue(mainPage.suggestIsDisplayed());
            Assert.assertTrue(actualSizeSuggest > 0);
            Assert.assertTrue(searchCriteria.contains("ivan"));

        }
    }
    @QaseTitle("Check that the home page banner is clickable and redirects to the corresponding page")
    @QaseId(value = 4894)
    @Test
    public void testHomePageBannerClickableAndRedirectToCorrespondingPage() {
        MainPage mainPage = new MainPage(getDriver());

        final String oldUrl  = openBaseURL()
                .getCurrentURL();

        final String actualUrl = mainPage
                .waitForImageInBannerVisibleOfMusic()
                .clickHomeBanner()
                .getCurrentURL();

        Assert.assertNotEquals(oldUrl,actualUrl);
        Assert.assertEquals(actualUrl, ProjectConstants.DOMAIN_WITHOUT_DEV + "/en/music?query=new+charts+2022");
    }
    @QaseTitle("Home page banner switches correctly")
    @QaseId(value = 4895)
    @Test
    public void testHomePageBannerSwitching ()  {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedValue = "swiper-pagination-bullet swiper-pagination-bullet-active";

        final String valueFirstSwitch = openBaseURL()
                .clickBannerSwitchFirst()
                .getClassAttributeSwitchFirst();


        final String valueSecondSwitch = mainPage
                .clickBannerSwitchSecond()
                .waitForImageInBannerVisibleOfEmail()
                .getClassAttributeSwitchSecond();

        Assert.assertEquals(valueFirstSwitch,expectedValue);
        Assert.assertEquals(valueSecondSwitch,valueFirstSwitch);

    }
    @QaseTitle("Home page banner automatically switches to the next image")
    @QaseId(value = 4896)
    @Test
    public void testHomePageBannerSwitchingAuto ()  {
            MainPage mainPage = new MainPage(getDriver());
            openBaseURL()
                    .waitForImageInBannerVisibleOfMusic();

            Assert.assertTrue(mainPage.imageOfMusicInBannerIsDysplaed() );

            mainPage.waitForImageInBannerVisibleOfEmail();

            Assert.assertTrue(mainPage.imageOfEmailInBannerIsDysplaed());
    }
    @QaseTitle("Check that the cursor is in the search field and the search icon is clickable.")
    @QaseId(value = 4897)
    @Test(retryAnalyzer = Retry.class)
    public void testCursorInSearchFieldAndSearchIconClickeble() {
        final String query = "test";

        openBaseURL()
                .inputSearchCriteria(query)
                .clickSearchButton()
                .waitUntilVisibilityWebResult();

        Assert.assertEquals(getExternalPageURL(),ProjectConstants.DOMAIN + "/en/web?query=test");
    }
    @QaseTitle("Check that all questions and answers were opened on the page.")
    @QaseId(value = 4898)
    @Test
    public void testQuestionAndAnswersWasOpened() {
        final List<String> expectedAttribute = List.of(
                "faq open",
                "faq open",
                "faq open",
                "faq open",
                "faq open",
                "faq open"
        );

        final List<String> actualAttribute = openBaseURL()
                .scrollToQuestions()
                .clickAllQuestions()
                .getClassAttributeAllQuestions();

        Assert.assertEquals(actualAttribute,expectedAttribute);
    }
    @QaseTitle("Check that a question and answer can be opened and closed on the page.")
    @QaseId(value = 4899)
    @Test
    public void testQuestionAndAnswersOpenAndClose() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedClassOpen = "faq open";
        final String expectedClassCloses = "faq";

        final String actualClassAttributeQuestionOpen = openBaseURL()
                .scrollToQuestions()
                .clickFirstQuestion()
                .getClassAttributeFirstQuestion();

        Assert.assertEquals(actualClassAttributeQuestionOpen,expectedClassOpen);

        final String actualClassAttributeQuestionCloses = mainPage
                .clickFirstQuestion()
                .waitForAnswerToBeInvisible()
                .getClassAttributeFirstQuestion();

        Assert.assertEquals(actualClassAttributeQuestionCloses,expectedClassCloses);
    }
    @QaseTitle("Check that the link in the fourth question leads to the expected URL.")
    @QaseId(value = 4900)
    @Test
    public void testLinkIn4Question() {
        final String actualUrl = openBaseURL()
                .scrollToQuestions()
                .clickFourthQuestion()
                .clickLinkInQuestion4()
                .getCurrentURL();

        Assert.assertEquals(actualUrl,ProjectConstants.DOMAIN + "/en/default-search");
    }
    @QaseTitle("Check that the \"Install Google Block\" button is clickable and leads to the expected URL.")
    @QaseId(value = 4901)
    @Test
    public void testClickableAndVisibleInstallGoogleBlock() {
        final String expectedUrl = "https://chrome.google.com/webstore/detail/swisscows/ibimaeimnogcdnjmmlpodbhhbejnpaij?hl=en";

        openBaseURL()
                .scrollToBlockGooglePopup()
                .clickInstallGoogleBlockPopup()
                .switchToAnotherWindow();

        Assert.assertEquals(getExternalPageURL(),expectedUrl);
    }
    @QaseTitle("Check the number of links in the footer of the website.")
    @QaseId(value = 4902)
    @Test
    public void testAmountLinksInTheFooter() {
        int actualUrl = openBaseURL()
                .scrollToFooter()
                .waitForFooterPanelToBeVisible()
                .getAllLinks().size();

        Assert.assertEquals(actualUrl, 26);
    }
    @QaseTitle("Check that the services block links navigate to the corresponding pages.")
    @QaseId(value = 4903)
    @Test(dataProvider = "ServicesBlockLinksData", dataProviderClass = TestData.class)
    public void testServicesBlockLinksNavigateToCorrespondingPages(
            int index, String expectedTittle,String expectedUrl) {

        MainPage mainPage = openBaseURL()
                .scrollToOurService();

        final String oldURL = mainPage.getCurrentURL();
        final String oldTittle = mainPage.getTitle();
        mainPage
                .clickServicesBlockLinks(index);

        final String actualURL = mainPage.getCurrentURL();
        final String actualTittle = mainPage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTittle, actualTittle);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedTittle);
    }
    @QaseTitle("Check that the services block links navigate to the corresponding pages.")
    @QaseId(value = 4904)
    @Test
    public void testHoverServicesBlockButtons() throws InterruptedException {
        MainPage mainPage = new MainPage(getDriver());
        final List<String> oldButtonColorsWhenHover = openBaseURL()
                .scrollToOurService()
                .getLinkColorsServicesBlock();


        final List<String> newButtonColorsWhenHover = mainPage
                .getLinksColorsWhenHoverServicesBlock();

        Assert.assertNotEquals(newButtonColorsWhenHover, oldButtonColorsWhenHover);

    }
    @QaseTitle("Check that popup google install Is Dysplaed")
    @QaseId(value = 4905)
    @Test
    public void testPopupGoogleInstallIsDysplaed() {

        MainPage mainPage = openBaseURL()
                .waitForPopupGoogleInstallToBeVisible();

        Assert.assertTrue(mainPage.isPopupGoogleDisplayed());
        Assert.assertEquals(mainPage.getTextPopupInstall(),"Install Swisscows\n" + "at Google Chrome\n"
                + "Stay with us and set Swisscows as your default search engine.");
    }
    @QaseTitle("Check that popup google redirect to the corresponding page")
    @QaseId(value = 4906)
    @Test
    public void testPopupGoogleRedirectToInstall() {
        final String expectedUrl = "https://chrome.google.com/webstore/detail/swisscows/ibimaeimnogcdnjmmlpodbhhbejnpaij?hl=en";

        openBaseURL()
                .waitForPopupGoogleInstallToBeVisible()
                .clickPopupGoogle()
                .switchToAnotherWindow();

        final String actualUrl = getExternalPageURL();

        Assert.assertEquals(actualUrl,expectedUrl);
    }
    @QaseTitle("Check that all images and texts in the \"Why Swisscows\" block on the main page are displayed.")
    @QaseId(value = 4907)
    @Test
    public void testAllImagesAndTextsIsDisplayedWhySwisscowsBlock_MainPage() {
        MainPage mainPage = new MainPage(getDriver());
        final List<String> expectedH2Texts = List.of(
                "Our anonymous search engine does not store your data!",
                "Anonymous search engine with own search index",
                "Family friendly, secure and anonymous search engine with own search index"

        );
        final List<String> actualH2Texts = openBaseURL()
                .getH2Texts();

        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
        Assert.assertTrue(mainPage.allImagesDisplayed());
    }
    @QaseTitle("Check h1 text on the main page")
    @QaseId(value = 4908)
    @Test
    public void testH1textIsCorrect_MainPage() {
        MainPage mainPage = new MainPage(getDriver());
        final List<String> expectedH2Texts = List.of(
                "Our Services",
                "Questions and Answers",
                "Why Swisscows?"
        );
        final List<String> actualH2Texts = openBaseURL()
                .getH1TextsMainPage();

        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
        Assert.assertEquals(mainPage.getMainTittleName(),"Anonymous search engine");
    }
    @QaseTitle("Check font sizes h2 text on the main page")
    @QaseId(value = 4909)
    @Test
    public void testTextsFontSizes_MainPage(){
        final List<String> expectedH1FontSizes = List.of(
                "24px",
                "24px",
                "24px"
        );
        final List<String>  actualH2FontSizes = openBaseURL()
                .getH2FontSizes();

        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1FontSizes);
    }
    @QaseTitle("Check that  placeholder text on the main page.")
    @QaseId(value = 4910)
    @Test
    public void testPlaceholderIsAvailable_Main() {
        final String expectedInnerTextOfPlaceholder = "Your search. Your business.";
        final String attribute = "placeholder";

        MainPage mainPage = openBaseURL();
        Assert.assertTrue(mainPage.isPlaceholderDisplayedMain());

        String actualInnerTextOfPlaceholder = mainPage.getInnerTextOfPlaceholderMain(attribute);

        Assert.assertEquals(actualInnerTextOfPlaceholder, expectedInnerTextOfPlaceholder);

    }
    @QaseTitle("Check that the presence of the logo on the adaptive homepage.")
    @QaseId(value = 4911)
    @Test
    public void testAdaptiveHomePageHasLogo() {
        MainPage mainPage =  openBaseURL()
                .setWindowWithHamburgerMenu(ProjectConstants.WIDTH_HAMBURGER_MENU, ProjectConstants.HEIGHT_HAMBURGER_MENU);

        Assert.assertTrue(mainPage.isHomePageLogoDisplayed());
        Assert.assertTrue(mainPage.allImagesDisplayed());

    }
    @QaseTitle("Check the texts of questions on the main page.")
    @QaseId(value = 4912)
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
    @QaseTitle("Check that the texts of answers on the main page.")
    @QaseId(value = 4913)
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

