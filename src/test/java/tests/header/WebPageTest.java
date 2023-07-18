package tests.header;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.WebPage;
import tests.retrytest.Retry;
import utils.ProjectConstants;

import java.util.List;

public class WebPageTest extends BaseTest {
    @QaseTitle("Check that suggestion equals search criteria")
    @QaseId(value = 5051)
    @Test
    public void testSuggestEqualsSearchCriteria_WebSearch() {
        MainPage mainPage = new MainPage(getDriver());
        String query = "ivanka";

        final List<String> actualSuggestion = openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickSearchFieldHeader()
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

    @QaseId(value = 4884)
    @Test
    public void test202NoResultsFoundPageError_WebPage()  {
        WebPage webPage = new WebPage(getDriver());
        String query = "@#@$%^$^dasdsad1231";
        final String expectedTitle202Error = "No results found for \"@#@$%^$^dasdsad1231\"";

        final String actualTitle202Error = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionUkraine()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilLoaderToBeInvisible()
                .waitUntilVisibilityErrorImage()
                .getTitleErrorText();

        final String actualFontSizeTitle202Error = webPage.getH2FontSize();

        Assert.assertEquals(actualTitle202Error, expectedTitle202Error);
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(actualFontSizeTitle202Error, ProjectConstants.FONT_SIZE_40_PX);
    }
    @QaseId(value = 4885)
    @Test
    public void testError450RequestIsBlocked_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        final String expectedTitle404Error = "No results found for \"porn\"";

        final String actualTitle404Error = openBaseURL()
                .inputSearchCriteriaAndEnter("porn")
                .waitUntilLoaderToBeInvisible()
                .waitUntilVisibilityErrorImage()
                .getTitleErrorText();

        final String actualFontSizeTitle404Error = webPage.getH2FontSize();

        Assert.assertEquals(actualTitle404Error, expectedTitle404Error);
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(actualFontSizeTitle404Error, ProjectConstants.FONT_SIZE_40_PX);
    }
    @QaseId(value = 4880)
    @Test
    public void testError404PageNotFound() {
        WebPage webPage = new WebPage(getDriver());

        final String expectedTitle404Error = "Page not found";

        final String actualTitle404Error = webPage
                .open404Page()
                .waitUntilVisibilityErrorImage()
                .getTitleErrorText();

        final String actualFontSizeTitle404Error = webPage.getH2FontSize();

        Assert.assertEquals(actualTitle404Error, expectedTitle404Error);
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(actualFontSizeTitle404Error, ProjectConstants.FONT_SIZE_40_PX);
    }
    @QaseId(value = 4887)
    @Test
    public void testError500UnknownError() {
        WebPage webPage = new WebPage(getDriver());

        final String expectedTitle404Error = "Oops! Something is wrong";

        final String actualTitle404Error = webPage
                .open500Page()
                .waitUntilVisibilityErrorImage()
                .getTitleErrorText();

        final String actualFontSizeTitle404Error = webPage.getH2FontSize();

        Assert.assertEquals(actualTitle404Error, expectedTitle404Error);
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(actualFontSizeTitle404Error, ProjectConstants.FONT_SIZE_40_PX);
    }
    @QaseTitle("Check that hover texts related to search")
    @QaseId(value = 5052)
    @Test
    public void testHoverTextsRelatedSearch_WebPage() throws InterruptedException {
        WebPage webPage = new WebPage(getDriver());

        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult();

        final List<String> oldTextsColorsWhenHover = webPage.getTextColors();
        final List<String> newTextsColorsWhenHover = webPage.getTextsColorsWhenHover();

        Assert.assertNotEquals(newTextsColorsWhenHover, oldTextsColorsWhenHover);
    }
    @QaseTitle("Check related search criteria")
    @QaseId(value = 5053)
    @Test
    public void testRelatedSearchCriteria_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        String query = "ronaldo";

        final String actualRegion = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .getCurrentURL();

        final List<String> titleAllVideo = webPage.getTitleInRelatedSearches();

        Assert.assertEquals(actualRegion, ProjectConstants.DOMAIN + "/en/web?query=ronaldo&region=de-DE");
        for (String search : titleAllVideo) {
            Assert.assertTrue(search.toLowerCase().contains("ronaldo"));
        }
    }
    @QaseTitle("Check click query in related search criteria")
    @QaseId(value = 5054)
    @Test(retryAnalyzer = Retry.class)
    public void testClickSearchCriteriaInRelatedSearch_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        String query = "ronaldo";

        final List<String> oldSearchResult = openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .getTitlesInWebResult();

        final List<String> newSearchResult = webPage
                .clickFirstTitleInRelatedSearches()
                .getTitlesInWebResult();

        Assert.assertNotEquals(oldSearchResult, newSearchResult);

    }
    @QaseTitle("Check Did you mean message in the search field ")
    @QaseId(value = 5055)
    @Test
    public void testSearchFieldDidYouMeanMessage_webPage() {
        String query = "appple";
        final String expectedResult = "[Do you want results only for" + query + "?]";


        final String actualResult = openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .getTextDidYouMeanMessage();

        Assert.assertNotEquals(expectedResult, actualResult);
    }
    @QaseTitle("Check that web results equals search criteria ")
    @QaseId(value = 5056)
    @Test
    public void testWebResultsEqualsSearchCriteria() {
        WebPage webPage = new WebPage(getDriver());
        String query = "iphone";

        final List<String> titles = openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .getTitlesInWebResult();

        final int actualSize = webPage.getTitlesInWebResult().size();

        Assert.assertTrue(actualSize >= 5);
        for (String searchCriteria : titles) {
            Assert.assertTrue(searchCriteria.toLowerCase().contains(query));
        }
        Assert.assertEquals(webPage.getTitle(),query+ " in Web search - Swisscows");

    }
    @QaseTitle("Check next and prev buttons in the video widget")
    @QaseId(value = 5057)
    @Test
    public void testNextButtonAndPrevButtonVideoWidget_WebPage() {

        WebPage webPage = openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo youtube")
                .waitUntilVisibilityWebResult()
                .choiceGermanyRegion()
                .waitUntilUrlToBeChanged("/en/web?query=ronaldo+youtube&region=de-DE")
                .waitUntilLoaderToBeInvisible()
                .clickNextButtonVideoWidget();

        Assert.assertTrue(webPage.lastImageInVideoWidgetIsDisplayed());

        webPage.clickPrevButtonVideoWidget();

        Assert.assertTrue(webPage.firstImageInVideoWidgetIsDisplayed());

    }
    @QaseTitle("Check click more button in the video widget")
    @QaseId(value = 5058)
    @Test
    public void testClickMoreVideoButtonInVideoWidget_WebPage() {

        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo youtube")
                .waitUntilVisibilityWebResult()
                .choiceGermanyRegion()
                .waitUntilUrlToBeChanged("/en/web?query=ronaldo+youtube&region=")
                .click_MoreVideo_ButtonInVideoWidget()
                .waitUntilVisibilityVideoResult();

        Assert.assertTrue(getExternalPageURL().contains(ProjectConstants.DOMAIN + "/en/video?query=ronaldo%20youtube&region=de-DE"));

    }
    @QaseTitle("Check that open video in the video widget")
    @QaseId(value = 5059)
    @Test
    public void testOpenVideoInVideoWidget_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        final String expectedTitle = "Your private and anonymous search engine Swisscows";

        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo youtube")
                .waitUntilUrlToBeChanged("/en/web?query=ronaldo+youtube")
                .waitUntilLoaderToBeInvisible()
                .waitUntilVisibilityWebResult()
                .choiceGermanyRegion()
                .waitUntilUrlToBeChanged("/en/web?query=ronaldo+youtube&region=")
                .waitUntilLoaderToBeInvisible()
                .clickFirstVideoInVideoWidget()
                .waitIUntilVisiblyVideoPlayer();

        Assert.assertTrue(webPage.getCurrentURL().contains(ProjectConstants.DOMAIN + "/en/video/watch?query=ronaldo%20youtube&region=de-DE&id"));
        Assert.assertEquals(getExternalPageTitle(), expectedTitle);

    }
    @QaseTitle("Check click more button in the image widget")
    @QaseId(value = 5060)
    @Test(retryAnalyzer = Retry.class)
    public void testClickMoreImageButtonInImageWidget_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        String query = "flowers";

        final String expectedTitle = query + " in Images search - Swisscows";

        openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .click_MoreImages_ButtonInImageWidget()
                .waitUrlToBeChanged("/en/images?query=" + query + "&region=de-DE")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages();

        Assert.assertEquals(webPage.getCurrentURL(), ProjectConstants.DOMAIN + "/en/images?query=" + query + "&region=de-DE");
        Assert.assertEquals(webPage.getTitle(), expectedTitle);

    }
    @QaseTitle("Check that all images and title are dysplaed in the Image widget")
    @QaseId(value = 5061)
    @Test(retryAnalyzer = Retry.class)
    public void testImagesAndTitleIsDysplaedInImageWidget_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        String query = "flowers";

        final String expectedTitle = "Images for " + query;

        final String actualTitle = openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .waitForImageIsVisibleInImagesWidget()
                .getTittleImagesWidget();


        Assert.assertTrue(webPage.imagesInImageWidgetIsDisplayed());
        Assert.assertEquals(actualTitle, expectedTitle);

    }
    @QaseTitle("Check open image in the image widget")
    @QaseId(value = 5062)
    @Test
    public void testOpenImageInTheImageWidget_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        String query = "flowers";

        final String oldUrl = openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .getCurrentURL();

        final String newUrl = webPage
                .clickFirstImageInImageWidget()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl, oldUrl);


    }
    @QaseTitle("Check open news in the news widget")
    @QaseId(value = 5063)
    @Test
    public void testOpenNewsInTheNewsWidget_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        final String oldUrl = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("ukraine")
                .waitUntilVisibilityWebResult()
                .getCurrentURL();

        final String newUrl = webPage
                .clickFirstNewsInNewsWidget()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl, oldUrl);

    }
    @QaseTitle("Check that all images and title are dysplaed in the news widget")
    @QaseId(value = 5064)
    @Test
    public void testImagesAndTitleIsDysplaedInNewsWidget_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        final String expectedTitle = "News for ukraine";

        final String actualTitle = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("ukraine")
                .waitUntilVisibilityWebResult()
                .waitForImageIsVisibleInNewsWidget()
                .getTittleNewsWidget();

        Assert.assertTrue(webPage.imagesInNewsWidgetIsDisplayed());
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @QaseTitle("Check select any number in the paging")
    @QaseId(value = 5065)
    @Test
    public void testSelectAnyNumberInPaging_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        String query = "ronaldo";

        final String oldTitle = openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilUrlToBeChanged("/en/web?query=" + query)
                .waitUntilLoaderToBeInvisible()
                .waitToBeVisibleTitleFirstSearchResult()
                .getTitleH2Text();

        final String newTitle = webPage
                .clickThirdNumberInPagination_WebPage()
                .waitUntilUrlToBeChanged("/en/web?query=" + query + "&offset=20")
                .waitUntilLoaderToBeInvisible()
                .waitToBeVisibleTitleFirstSearchResult()
                .getTitleH2Text();

        final String actualAttribute = webPage.getAttributeOfThirdButtonInPagination();

        Assert.assertNotEquals(oldTitle,newTitle);
        Assert.assertEquals(actualAttribute,"number active");

    }
    @QaseTitle("Check next button in the paging")
    @QaseId(value = 5066)
    @Test
    public void testNextButtonInPaging_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        String query = "ronaldo";

        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickNextButtonInPagination_WebPage()
                .waitUntilUrlToBeChanged("/en/web?query=" + query + "&offset=10")
                .waitUntilLoaderToBeInvisible()
                .waitUntilVisibilityWebResult()
                .getAttributeOfSecondButtonInPagination();

        Assert.assertTrue(webPage.getTitlesInWebResult().size() >= 5);
        Assert.assertEquals(webPage.getTitle(),query + " in Web search - Swisscows");
        Assert.assertEquals(actualAttribute,"number active");

    }
    @QaseTitle("Check previous button in the paging")
    @QaseId(value = 5067)
    @Test
    public void testPreviousButtonInPaging_WebPage()  {
        WebPage webPage = new WebPage(getDriver());
        String query = "wiki";

        final String actualTitleFirstSearchResult = openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilUrlToBeChanged("/en/web?query=" + query)
                .waitUntilLoaderToBeInvisible()
                .waitToBeVisibleTitleFirstSearchResult()
                .clickNextButtonInPagination_WebPage()
                .waitUntilUrlToBeChanged("/en/web?query=" + query + "&offset=10")
                .waitUntilLoaderToBeInvisible()
                .waitToBeVisibleTitleFirstSearchResult()
                .clickPreviousButtonInPagination_WebPage()
                .waitUntilUrlToBeChanged("/en/web?query=" + query + "&offset=0")
                .waitUntilLoaderToBeInvisible()
                .waitToBeVisibleTitleFirstSearchResult()
                .getTitleH2Text();

        Assert.assertEquals(webPage.getTitle(),query + " in Web search - Swisscows");
        Assert.assertEquals(actualTitleFirstSearchResult,"Wikipedia");


    }
    @QaseTitle("Check using filter ")
    @QaseId(value = 5068)
    @Test
    public void testUsingFilter_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        String query = "date";

        final String oldTitle = openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilUrlToBeChanged("/en/web?query=" + query)
                .waitUntilLoaderToBeInvisible()
                .waitToBeVisibleTitleFirstSearchResult()
                .getTitleH2Text();

        final String newTitle = webPage
                .clickFilterButtonWeb()
                .clickDateButtonInFilter()
                .click_PastYear_InDropDownOfDateFilter()
                .waitUntilUrlToBeChanged("/en/web?query=" + query + "&freshness=Year")
                .waitUntilLoaderToBeInvisible()
                .waitToBeVisibleTitleFirstSearchResult()
                .getTitleH2Text();

        Assert.assertTrue(webPage.getCurrentURL().contains((ProjectConstants.DOMAIN + "/en/web?query=" + query + "&freshness=Year")));
        Assert.assertTrue(webPage.getTitlesInWebResult().size() >= 5);
        Assert.assertNotEquals(oldTitle,newTitle);
        Assert.assertEquals(webPage.getTitle(),query +" in Web search - Swisscows");
    }
    @QaseTitle("Check cancel filter ")
    @QaseId(value = 5069)
    @Test
    public void testCancelFilter_WebPage()  {
        WebPage webPage = new WebPage(getDriver());
        String query = "chat jpg";

        final List<String> actualListTitleInWebResult = openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilUrlToBeChanged("/en/web?query=chat+jpg")
                .waitUntilLoaderToBeInvisible()
                .waitUntilVisibilityWebResult()
                .clickFilterButtonWeb()
                .clickDateButtonInFilter()
                .click_PastYear_InDropDownOfDateFilter()
                .waitUntilUrlToBeChanged( "/en/web?query=chat+jpg&freshness=Year")
                .clickFilterButtonWeb()
                .waitUntilUrlToBeChanged( "/en/web?query=chat+jpg")
                .waitUntilLoaderToBeInvisible()
                .waitUntilToBeVisibleTitlesInWebResult()
                .getTitlesInWebResult();

        Assert.assertTrue(actualListTitleInWebResult.size() >= 5);
        Assert.assertEquals(webPage.getCurrentURL(),ProjectConstants.DOMAIN + "/en/web?query=chat+jpg");
    }
    @QaseTitle("Check open web Preview ")
    @QaseId(value = 5070)
    @Test(retryAnalyzer = Retry.class)
    public void testOpenWebPreview_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickPreviewButton()
                .waitUntilVisibilityScreenshot();

        Assert.assertTrue(webPage.screenshotIsDisplayed());

    }
    @QaseTitle("Check close web Preview ")
    @QaseId(value = 5071)
    @Test(retryAnalyzer = Retry.class)
    public void testCloseWebPreview_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickPreviewButton()
                .waitUntilVisibilityScreenshot()
                .clickCloseButtonInScreenshot();

        Assert.assertFalse(webPage.isScreenshotItemIsPresent());

    }
    @QaseTitle("Check open site in web Preview ")
    @QaseId(value = 5072)
    @Test(retryAnalyzer = Retry.class)
    public void testOpenSiteInPreview_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        final String oldUrl = openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .getCurrentURL();
        webPage
                .clickPreviewButton()
                .waitUntilVisibilityScreenshot()
                .click_OpenSite_ButtonInScreenshot()
                .switchToExternalPage();

        Assert.assertNotEquals(getExternalPageURL(),oldUrl);

    }
    @QaseTitle("Check open trackers in web Preview ")
    @QaseId(value = 5073)
    @Test(retryAnalyzer = Retry.class)
    public void testOpenTrackersInPreview_WebPage() {

        final List<String> trackersSize = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionUkraine()
                .inputSearchCriteriaAndEnter("asdasd")
                .waitUntilVisibilityWebResult()
                .clickPreviewButton()
                .waitUntilVisibilityScreenshotButtonInScreenshot()
                .clickTrackersButtonInScreenshot()
                .getTrackersInScreenshot();


        Assert.assertTrue(trackersSize.size() >= 2);

    }
    @QaseTitle("Check click screenshot button in web Preview ")
    @QaseId(value = 5076)
    @Test(retryAnalyzer = Retry.class)
    public void testClickScreenshotButtonInPreview_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionUkraine()
                .inputSearchCriteriaAndEnter("asdasd")
                .waitUntilVisibilityWebResult()
                .clickPreviewButton()
                .waitUntilVisibilityTrackersButtonInScreenshot()
                .clickTrackersButtonInScreenshot()
                .waitUntilVisibilityScreenshotButtonInScreenshot()
                .clickTrackersButtonInScreenshot()
                .waitUntilVisibilityScreenshot();

        Assert.assertTrue(webPage.screenshotIsDisplayed());

    }
    @QaseTitle("Check change language ")
    @QaseId(value = 5077)
    @Test(retryAnalyzer = Retry.class)
    public void testChangeLanguage_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickLanguagesHamburgerMenu()
                .clickLangDeutsch();

        Assert.assertEquals(webPage.getCurrentURL(),ProjectConstants.DOMAIN + "/de/web?query=ronaldo");
        Assert.assertTrue(webPage.getTitle().contains("in Web suchen - Swisscows"));
    }
    @QaseTitle("Check advertising ")
    @QaseId(value = 5078)
    @Test(retryAnalyzer = Retry.class)
    public void testAdvertising_WebPage()  {
        WebPage webPage = new WebPage(getDriver());
        final String expectedAdsText = "Ads by Microsoft Data privacy";

        final String actualAdsText = openBaseURL()
                .inputSearchCriteriaAndEnter("price")
                .waitUntilVisibilityWebResult()
                .choiceGermanyRegion()
                .waitUntilUrlToBeChanged("/en/web?query=price&region=de-DE")
                .waitUntilLoaderToBeInvisible()
                .getAdsText_WebPage();

        final int actualSizes = webPage.getAdsList().size();

        Assert.assertEquals(actualAdsText,expectedAdsText);
        Assert.assertTrue(actualSizes >= 1);
    }
    @QaseTitle("Check open advertising ")
    @QaseId(value = 5079)
    @Test(retryAnalyzer = Retry.class)
    public void testOpenAdvertising_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        final String oldUrl = openBaseURL()
                .inputSearchCriteriaAndEnter("price")
                .waitUntilVisibilityWebResult()
                .choiceGermanyRegion()
                .getCurrentURL();

        final String newUrl = webPage
                .clickFirstLinkOfAds()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);

    }
    @QaseTitle("Check open link in  the web result ")
    @QaseId(value = 5080)
    @Test
    public void testOpenAnyLinkInWebResult_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        final String oldUrl = openBaseURL()
                .inputSearchCriteriaAndEnter("wiki")
                .waitUntilVisibilityWebResult()
                .getCurrentURL();

        final String newUrl = webPage
                .clickFirstLinkInWebResult()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);

    }
    @QaseTitle("Check hover of preview buttons ")
    @QaseId(value = 5081)
    @Test(retryAnalyzer = Retry.class)
    public void testHoverPreviewButtons_WebPage() throws InterruptedException {
        WebPage webPage = new WebPage(getDriver());

        final List<String> colorPrevButtonWithoutHover = openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .getColorsOfPreviewButtons();

        final List<String> colorPrevButtonWhenHover = webPage
                .getColorsOfPreviewButtonsWhenHovering();

        Assert.assertNotEquals(colorPrevButtonWhenHover,colorPrevButtonWithoutHover);
    }
}