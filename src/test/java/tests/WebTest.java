package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.NewsPage;
import pages.top_menu.WebPage;

import java.util.List;

public class WebTest extends BaseTest {
    @Test
    public void testSuggestEqualsSearchCriteria_WebSearch() {
        final String query = "ivanka";

        MainPage mainPage = openBaseURL();
        openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickSearchFieldHeader();
        mainPage
                .waitForSuggestToBeVisible();

        final List<String> actualSuggestion = mainPage.getAllElementsText();
        final int actualSizeSuggest = mainPage.countElementsInSuggestContainer();

        Assert.assertEquals(mainPage.getAllElementsText().size(), 5);

        for (String searchCriteria : actualSuggestion) {
            Assert.assertTrue(mainPage.suggestIsDisplayed());
            Assert.assertTrue(actualSizeSuggest > 0);
            Assert.assertTrue(searchCriteria.contains(query));
        }
    }
    @Test
    public void test404PageError_WebPage(){
        WebPage webPage = new WebPage (getDriver());

        final String expectedTitle404Error = "No results found for \"yquwhjsbcfkjascgfiaff%^$&\"";
        final String expectedFontSizeTitle404Error = "40px";
        final String actualTitle404Error = openBaseURL()
                .inputSearchCriteriaAndEnter("yquwhjsbcfkjascgfiaff%^$&")
                .waitUntilVisibilityErrorImage()
                .getTitleH2Text();


        final String actualFontSizeTitle404Error = webPage.getH2FontSize();

        Assert.assertEquals(actualTitle404Error,expectedTitle404Error);
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(actualFontSizeTitle404Error,expectedFontSizeTitle404Error);
    }
}

