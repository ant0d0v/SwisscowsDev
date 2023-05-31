package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.WebPage;
import tests.retrytest.Retry;
import utils.ProjectConstants;

import java.util.List;

public class WebPageTest extends BaseTest {
    @Test
    public void testSuggestEqualsSearchCriteria_WebSearch() {
        final String query = "ivanka";

        MainPage mainPage = openBaseURL();
        openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
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
    public void test202NoResultsFoundPageError_WebPage()  {
        WebPage webPage = new WebPage(getDriver());

        final String expectedTitle404Error = "No results found for \"@#@$%^$^dasdsad1231\"";
        final String expectedFontSizeTitle404Error = "40px";

        final String actualTitle404Error = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionUkraine()
                .inputSearchCriteriaAndEnter("@#@$%^$^dasdsad1231")
                .waitUntilVisibilityErrorImage()
                .getTitleErrorText();

        final String actualFontSizeTitle404Error = webPage.getH2FontSize();

        Assert.assertEquals(actualTitle404Error, expectedTitle404Error);
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(actualFontSizeTitle404Error, expectedFontSizeTitle404Error);
    }
    @Test
    public void testError450RequestIsBlocked_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        final String expectedTitle404Error = "No results found for \"porn\"";
        final String expectedFontSizeTitle404Error = "40px";


        final String actualTitle404Error =openBaseURL()
                .inputSearchCriteriaAndEnter("porn")
                .waitUntilVisibilityErrorImage()
                .getTitleErrorText();

        final String actualFontSizeTitle404Error = webPage.getH2FontSize();

        Assert.assertEquals(actualTitle404Error, expectedTitle404Error);
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(actualFontSizeTitle404Error, expectedFontSizeTitle404Error);
    }
    @Test
    public void testError404PageNotFound() {
        WebPage webPage = new WebPage(getDriver());

        final String expectedTitle404Error = "Page not found";
        final String expectedFontSizeTitle404Error = "40px";


        final String actualTitle404Error = webPage
                .open404Page()
                .waitUntilVisibilityErrorImage()
                .getTitleErrorText();
        final String actualFontSizeTitle404Error = webPage.getH2FontSize();

        Assert.assertEquals(actualTitle404Error, expectedTitle404Error);
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(actualFontSizeTitle404Error, expectedFontSizeTitle404Error);
    }
    @Test
    public void testError500UnknownError() {
        WebPage webPage = new WebPage(getDriver());

        final String expectedTitle404Error = "Oops! Something is wrong";
        final String expectedFontSizeTitle404Error = "40px";


        final String actualTitle404Error = webPage
                .open500Page()
                .waitUntilVisibilityErrorImage()
                .getTitleErrorText();
        final String actualFontSizeTitle404Error = webPage.getH2FontSize();

        Assert.assertEquals(actualTitle404Error, expectedTitle404Error);
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(actualFontSizeTitle404Error, expectedFontSizeTitle404Error);
    }


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

    @Test
    public void testRelatedSearchCriteria_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/web?query=ronaldo&region=");

        final String actualRegion = webPage.getCurrentURL();
        final List<String> titleAllVideo = webPage.getTitleInRelatedSearches();

        Assert.assertEquals(actualRegion, ProjectConstants.DOMAIN + "/en/web?query=ronaldo&region=de-DE");
        for (String search : titleAllVideo) {
            Assert.assertTrue(search.toLowerCase().contains("ronaldo"));
        }
    }

    @Test(retryAnalyzer = Retry.class)
    public void testClickSearchCriteriaInRelatedSearch_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        final List<String> oldSearchResult = openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .getTitleInWebResult();

        final List<String> newSearchResult = webPage
                .clickFirstTitleInRelatedSearches()
                .getTitleInWebResult();

        Assert.assertNotEquals(oldSearchResult, newSearchResult);

    }

    @Test
    public void testSearchFieldDidYouMeanMessage_webPage() {

        final String expectedResult = "[Do you want results only for appple?]";
        final String actualResult = openBaseURL()
                .inputSearchCriteriaAndEnter("appple")
                .waitUntilVisibilityWebResult()
                .getTextDidYpuMeanMessage();


        Assert.assertNotEquals(expectedResult, actualResult);

    }

    @Test
    public void testWebResultsEqualsSearchCriteria() {
        WebPage webPage = new WebPage(getDriver());
        final List<String> titles = openBaseURL()
                .inputSearchCriteriaAndEnter("ukraine")
                .waitUntilVisibilityWebResult()
                .getTitleInWebResult();

        final int actualSize = webPage.getTitleInWebResult().size();

        Assert.assertTrue(actualSize >= 5);
        for (String searchCriteria : titles) {
            Assert.assertTrue(searchCriteria.toLowerCase().contains("ukraine"));
        }
        Assert.assertEquals(webPage.getTitle(),"ukraine in Web search - Swisscows");

    }

    @Test
    public void testNextButtonAndPrevButtonVideoWidget_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo video")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/web?query=ronaldo+video&region=de-DE");
        webPage
                .clickNextButtonVideoWidget();
        Assert.assertTrue(webPage.lastImageInVideoWidgetIsDisplayed());
        webPage
                .clickPrevButtonVideoWidget();
        Assert.assertTrue(webPage.firstImageInVideoWidgetIsDisplayed());

    }

    @Test
    public void testClickMoreVideoButtonInVideoWidget_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo youtube")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/web?query=ronaldo+youtube&region=");
        webPage
                .clickMoreVideoInVideoWidget();
        Assert.assertTrue(getExternalPageURL().contains(ProjectConstants.DOMAIN + "/en/video?query=ronaldo%20youtube&region=de-DE"));

    }

    @Test
    public void testOpenVideoInVideoWidget_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        final String expectedTitle = "Your private and anonymous search engine Swisscows";
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo youtube")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/web?query=ronaldo+youtube&region=");
        webPage
                .clickFirstVideoInVideoWidget()
                .waitIUntilVisiblyVideoPlayer();

        Assert.assertTrue(webPage.getCurrentURL().contains(ProjectConstants.DOMAIN + "/en/video/watch?query=ronaldo%20youtube&region=de-DE&id"));
        Assert.assertEquals(getExternalPageTitle(), expectedTitle);

    }

    @Test
    public void testClickMoreImageButtonInImageWidget_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        final String expectedTitle = "flover in Images search - Swisscows";
        openBaseURL()
                .inputSearchCriteriaAndEnter("flover")
                .waitUntilVisibilityWebResult()
                .clickMoreImagesInVideoWidget()
                .waitForImageIsVisible();

        Assert.assertEquals(webPage.getCurrentURL(), ProjectConstants.DOMAIN + "/en/images?query=flover");
        Assert.assertEquals(webPage.getTitle(), expectedTitle);

    }

    @Test
    public void testImagesAndTitleIsDysplaedInImageWidget_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        final String expectedTitle = "Images for flover";

        final String actualTitle = openBaseURL()
                .inputSearchCriteriaAndEnter("flover")
                .waitUntilVisibilityWebResult()
                .waitForImageIsVisibleInImagesWidget()
                .getTittleImagesWidget();


        Assert.assertTrue(webPage.imagesInImageWidgetIsDisplayed());
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void testOpenImageInTheImageWidget_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        final String oldUrl = openBaseURL()
                .inputSearchCriteriaAndEnter("flovers")
                .waitUntilVisibilityWebResult()
                .getCurrentURL();
        final String newUrl = webPage
                .clickFirstImageInImageWidget()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl, oldUrl);


    }

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
    @Test
    public void testAnyNumberInPaging_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult();
        final String oldTitle = webPage.getTitleH2Text();


        final String newTitle = webPage
                .clickThirdPagePagination_WebPage()
                .waitUntilLoaderToBeInvisible()
                .getTitleH2Text();

        final String actualAttribute = webPage
                .getAttributeThirdButtonPagination();

        Assert.assertNotEquals(oldTitle,newTitle);
        Assert.assertEquals(actualAttribute,"number active");

    }
    @Test
    public void testNextButtonInPaging_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickNextPagePagination_WebPage()
                .waitUntilLoaderToBeInvisible();

        final String actualAttribute = webPage
                .getAttributeSecondButtonPagination();

        Assert.assertTrue(webPage.getTitleInWebResult().size() >= 5);
        Assert.assertEquals(webPage.getTitle(),"ronaldo in Web search - Swisscows");
        Assert.assertEquals(actualAttribute,"number active");

    }
    @Test
    public void testPreviousButtonInPaging_WebPage()  {
        WebPage webPage = new WebPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickNextPagePagination_WebPage()
                .waitUntilLoaderToBeInvisible()
                .clickPreviousPagePagination_WebPage()
                .waitUntilLoaderToBeInvisible();

        final String oldTitle = webPage.getTitleH2Text();
        final String newTitle = webPage.getTitleH2Text();

        Assert.assertEquals(webPage.getTitle(),"ronaldo in Web search - Swisscows");
        Assert.assertEquals(oldTitle,newTitle);

    }
    @Test
    public void testUsingFilter_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        final String oldTitle = openBaseURL()
                .inputSearchCriteriaAndEnter("winner")
                .waitUntilVisibilityWebResult()
                .getTitleH2Text();

        final String newTitle = webPage
                .clickFilterButtonWeb()
                .clickButtonDateInFilter()
                .clickPastYearInDropDownOfFilter()
                .waitUntilLoaderToBeInvisible()
                .getTitleH2Text();

        Assert.assertTrue(webPage.getCurrentURL().contains((ProjectConstants.DOMAIN + "/en/web?query=winner&freshness=Year")));
        Assert.assertTrue(webPage.getTitleInWebResult().size() >= 5);
        Assert.assertNotEquals(oldTitle,newTitle);
        Assert.assertEquals(webPage.getTitle(),"winner in Web search - Swisscows");


    }
    @Test
    public void testCancelFilter_WebPage()  {
        WebPage webPage = new WebPage(getDriver());

        openBaseURL()
                .inputSearchCriteriaAndEnter("chat jpg")
                .waitUntilVisibilityWebResult()
                .clickFilterButtonWeb()
                .clickButtonDateInFilter()
                .clickPastYearInDropDownOfFilter()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/web?query=chat+jpg&freshness=Year");
        webPage
                .clickFilterButtonWeb()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/web?query=chat+jpg");

        Assert.assertTrue(webPage.getTitleInWebResult().size() >= 5);
        Assert.assertEquals(webPage.getCurrentURL(),ProjectConstants.DOMAIN + "/en/web?query=chat+jpg");
    }
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
    @Test(retryAnalyzer = Retry.class)
    public void testCloseWebPreview_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickPreviewButton()
                .waitUntilVisibilityScreenshot()
                .clickCloseInScreenshot();

        try {
            webPage.screenshotIsDisplayedWebPage();
            Assert.fail("Item is present on the page!");
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }

    }
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
                .clickOpenButtonInScreenshot()
                .switchToExternalPage();

        Assert.assertNotEquals(getExternalPageURL(),oldUrl);

    }
    @Test(retryAnalyzer = Retry.class)
    public void testOpenTrackersInPreview_WebPage() {

        final List<String> trackersSize = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionUkraine()
                .inputSearchCriteriaAndEnter("asdasd")
                .waitUntilVisibilityWebResult()
                .clickPreviewButton()
                .waitUntilVisibilityScreenshotButton()
                .clickTrackersButtonInScreenshot()
                .getTrackersInScreenshot();


        Assert.assertTrue(trackersSize.size() >= 2);

    }
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
                .waitUntilVisibilityTrackerButton()
                .clickTrackersButtonInScreenshot()
                .waitUntilVisibilityScreenshotButton()
                .clickTrackersButtonInScreenshot()
                .waitUntilVisibilityScreenshot();

        Assert.assertTrue(webPage.screenshotIsDisplayed());

    }
    @Test(retryAnalyzer = Retry.class)
    public void testChangeLanguage_WebPage() {
        WebPage webPage = new WebPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickLanguagesTopMenu()
                .clickLangDeutsch();


        Assert.assertEquals(webPage.getCurrentURL(),ProjectConstants.DOMAIN + "/de/web?query=ronaldo");
        Assert.assertTrue(webPage.getTitle().contains("in Web suchen - Swisscows"));

    }
    @Test(retryAnalyzer = Retry.class)
    public void testAdvertising_WebPage()  {
        WebPage webPage = new WebPage(getDriver());
        final String expectedAdsText = "Ads by Microsoft Data privacy";
        openBaseURL()
                .inputSearchCriteriaAndEnter("price")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman();

        final String actualAdsText = webPage
                .waitUntilLoaderToBeInvisible()
                .getAdsText_WebPage();
        final int actualSizes = webPage
                .getAdsList().size();


        Assert.assertEquals(actualAdsText,expectedAdsText);
        Assert.assertTrue(actualSizes >= 1);

    }
    @Test(retryAnalyzer = Retry.class)
    public void testOpenAdvertising_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        final String oldUrl = openBaseURL()
                .inputSearchCriteriaAndEnter("price")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .getCurrentURL();

        final String newUrl = webPage
                .clickFirstAds()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
    }
    @Test
    public void testOpenAnyLinkInWebResult_WebPage() {
        WebPage webPage = new WebPage(getDriver());

        final String oldUrl = openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .getCurrentURL();

        final String newUrl = webPage
                .clickFirstLinkInWebResult()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);

    }
    @Test(retryAnalyzer = Retry.class)
    public void testHoverPreviewButtons_WebPage() throws InterruptedException {
        WebPage webPage = new WebPage(getDriver());

        final List<String> colorPrevButtonWithoutHover = openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .getPreviewColors();

        final List<String> colorPrevButtonWhenHover = webPage
                .getPreviewColorsWhenHover();

        Assert.assertNotEquals(colorPrevButtonWhenHover,colorPrevButtonWithoutHover);
    }
}