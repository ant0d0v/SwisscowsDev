package tests.header_tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.NewsPage;
import tests.retrytest.Retry;
import utils.ProjectConstants;

import java.util.List;

public class NewsTest extends BaseTest {
    @Test
    public void testSuggestEqualsSearchCriteria_NewsSearch() {
        final String query = "ivanka";

        MainPage mainPage = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickNewsButton()
                .waitUntilVisibilityNewsResult()
                .clickSearchFieldHeader();

        final List<String> actualSuggestion = mainPage
                .waitForSuggestToBeVisible()
                .getAllElementsText();

        final int actualSizeSuggest = mainPage.countElementsInSuggestContainer();

        Assert.assertEquals(mainPage.getAllElementsText().size(), 5);

        for (String searchCriteria : actualSuggestion) {
            Assert.assertTrue(mainPage.suggestIsDisplayed());
            Assert.assertTrue(actualSizeSuggest > 0);
            Assert.assertTrue(searchCriteria.contains(query));
        }
    }
    @Test
    public void testError501UnsupportedRegion_NewsPage(){
        NewsPage newsPage = new NewsPage (getDriver());
        final String expectedTitle501Error = "Sorry, there are no search results for your region";
        final String expectedFontSizeTitle501Error = "40px";

        final String actualTitle501Error = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickNewsButton()
                .waitUntilVisibilityNewsResult()
                .selectRegionBrazil()
                .waitUntilVisibilityErrorImage()
                .getTitleNews();

        final String actualFontSizeTitle501Error = newsPage.getH2FontSize();

        Assert.assertEquals(actualTitle501Error,expectedTitle501Error);
        Assert.assertTrue(newsPage.errorImageIsDisplayed());
        Assert.assertEquals(actualFontSizeTitle501Error,expectedFontSizeTitle501Error);
    }
    @Test
    public void testOpenNewsPost_NewsPage() {
        NewsPage newsPage = new NewsPage(getDriver());

        final String oldUrl = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickNewsButton()
                .waitUntilVisibilityNewsResult()
                .getCurrentURL();

        final String newUrl = newsPage
                .clickFirstPost()
                .getCurrentURL();
        ;
        Assert.assertNotEquals(newUrl, oldUrl);
    }
    @Test
    public void testSearchField_NewsPage(){
        NewsPage newsPage = new NewsPage (getDriver());

        final String oldTextFirstNews = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickNewsButton()
                .waitUntilVisibilityNewsResult()
                .getTitleNews();
        newsPage
                .searchAfterClearSearchField("Ronaldo")
                .clickSearchButton()
                .waitUrlToBeChanged("/en/news?query=Ronaldo&region=de-DE");

        final String newTextFirstNews = newsPage
                .waitUntilVisibilityNewsResult()
                .getTitleNews();

        Assert.assertTrue(newsPage.allImageIsDisplayed());
        Assert.assertNotEquals(newTextFirstNews,oldTextFirstNews);

    }
    @Test(retryAnalyzer = Retry.class)
    public void testImageProxy_NewsPage() {
        NewsPage newsPage = new NewsPage (getDriver());
        final List<String> actualSrc = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickNewsButton()
                .waitUntilVisibilityNewsResult()
                .getSrsOfImages();

        Assert.assertTrue(newsPage.allImageIsDisplayed());
        for (String search : actualSrc) {
            Assert.assertTrue(search.contains("https://cdn.swisscows.com/image?url"));
        }
    }
    @Test
    public void testAnyNumberInPaging_NewsPage() {
        NewsPage newsPage = new NewsPage (getDriver());
        final String oldTitle = openBaseURL()
                 .clickHamburgerMenu()
                 .clickRegionTopMenu()
                 .clickRegionGerman()
                 .inputSearchCriteriaAndEnter("ronaldo")
                 .waitUntilVisibilityWebResult()
                 .clickNewsButton()
                 .waitUntilVisibilityNewsResult()
                 .getTitleNews();

        final String newTitle = newsPage
                .clickThirdPagePagination()
                .waitUntilVisibilityNewsResult()
                .getTitleNews();

        final String actualAttribute = newsPage
                .getAttributeThirdButtonPagination();

        Assert.assertNotEquals(oldTitle,newTitle);
        Assert.assertEquals(actualAttribute,"number active");

    }
    @Test
    public void testNextButtonInPaging_NewsPage() {
        NewsPage newsPage = new NewsPage (getDriver());
        final String actualAttribute = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickNewsButton()
                .waitUntilUrlToBeChanged("/en/news?query=ronaldo&region=de-DE")
                .waitUntilToBeInVisibleLoader()
                .waitUntilVisibilityNewsResult()
                .clickNextPagePagination()
                .waitUntilUrlToBeChanged("/en/news?query=ronaldo&region=de-DE&offset=10")
                .waitUntilToBeInVisibleLoader()
                .waitUntilVisibilityNewsResult()
                .getAttributeSecondButtonPagination();

        Assert.assertTrue(newsPage.allImageIsDisplayed());
        Assert.assertEquals(newsPage.getTitleH2Texts().size(),10);
        Assert.assertEquals(actualAttribute,"number active");

    }
    @Test
    public void testPreviousButtonInPaging_NewsPage() {
        NewsPage newsPage = new NewsPage (getDriver());
        final String oldTitle = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickNewsButton()
                .waitUntilVisibilityNewsResult()
                .waitUntilUrlToBeChanged("/en/news?query=ronaldo&region=de-DE")
                .waitUntilToBeInVisibleLoader()
                .waitUntilVisibilityNewsResult()
                .clickNextPagePagination()
                .waitUntilUrlToBeChanged("/en/news?query=ronaldo&region=de-DE&offset=10")
                .waitUntilToBeInVisibleLoader()
                .waitUntilVisibilityNewsResult()
                .getTitleNews();

        final String newTitle = newsPage
                .clickPreviousPagePagination()
                .waitUntilVisibilityNewsResult()
                .waitUntilUrlToBeChanged("/en/news?query=ronaldo&region=de-DE&offset=0")
                .waitUntilToBeInVisibleLoader()
                .waitUntilVisibilityNewsResult()
                .getTitleNews();

        Assert.assertTrue(newsPage.allImageIsDisplayed());
        Assert.assertEquals(newsPage.getTitleH2Texts().size(),10);
        Assert.assertNotEquals(oldTitle,newTitle);
        Assert.assertEquals(newsPage.getCurrentURL(),ProjectConstants.DOMAIN+"/en/news?query=ronaldo&region=de-DE&offset=0");

    }


}
