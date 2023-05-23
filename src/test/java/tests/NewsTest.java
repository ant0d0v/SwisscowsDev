package tests;

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

        MainPage mainPage = openBaseURL();
        openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
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
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .clickNewsButton()
                .waitUntilVisibilityNewsResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionBrazil()
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
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
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
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .clickNewsButton()
                .waitUntilVisibilityNewsResult()
                .getTitleNews();
        newsPage
                .searchAfterClearSearchField("Ronaldo")
                .clickSearchButton()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/news?query=Ronaldo&region=de-DE");

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
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
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
         openBaseURL()
                 .inputSearchCriteriaAndEnter("news")
                 .waitUntilVisibilityWebResult()
                 .clickHamburgerMenu()
                 .clickRegionTopMenu()
                 .clickRegionGerman()
                 .clickNewsButton();
        final String oldTitle = newsPage.getTitleNews();
        final String newTitle = newsPage
                .clickThirdPagePagination()
                .waitUntilLoaderToBeInvisible()
                .getTitleNews();

        final String actualAttribute = newsPage
                .getAttributeThirdButtonPagination();

        Assert.assertNotEquals(oldTitle,newTitle);
        Assert.assertEquals(actualAttribute,"number active");

    }
    @Test
    public void testNextButtonInPaging_NewsPage() {
        NewsPage newsPage = new NewsPage (getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("news")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .clickNewsButton()
                .clickNextPagePagination();

        final String actualAttribute = newsPage
                .waitUntilLoaderToBeInvisible()
                .getAttributeSecondButtonPagination();

        Assert.assertTrue(newsPage.allImageIsDisplayed());
        Assert.assertEquals(newsPage.getTitleH2Texts().size(),10);
        Assert.assertEquals(actualAttribute,"number active");

    }
    @Test
    public void testPreviousButtonInPaging_NewsPage() {
        NewsPage newsPage = new NewsPage (getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("news")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .clickNewsButton()
                .clickNextPagePagination()
                .clickPreviousPagePagination()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/news?query=news&region=de-DE");

        final String oldTitle = newsPage.getTitleNews();
        final String newTitle = newsPage
                .waitUntilVisibilityNewsResult()
                .getTitleNews();

        Assert.assertTrue(newsPage.allImageIsDisplayed());
        Assert.assertEquals(newsPage.getTitleH2Texts().size(),10);
        Assert.assertEquals(oldTitle,newTitle);

    }


}
