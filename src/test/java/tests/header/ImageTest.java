package tests.header;
import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.ImagePage;
import pages.top_menu.MusicPage;
import tests.retrytest.Retry;
import utils.ProjectConstants;

import java.util.List;


public class ImageTest extends BaseTest {
    private final String searchQuery = "ronaldo";
    @QaseTitle("Check that suggestion equals search criteria")
    @QaseId(value = 5089)
    @Test
    public void testSuggestEqualsSearchCriteria_ImageSearch() {
        MainPage mainPage = new MainPage(getDriver());

        final String query = "ivanka";

        openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
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
    @QaseTitle("Check regional search")
    @QaseId(value = 5090)
    @Test
    public void testRegionalSearch_ImagePage() {

        final String actualRegion = openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .choiceRegionGermany()
                .waitUrlToBeChanged("/en/images?query=ivanka&region=de-DE")
                .getCurrentURL();

        Assert.assertEquals(actualRegion,ProjectConstants.DOMAIN +"/en/images?query=ivanka&region=de-DE");


    }
    @QaseTitle("Check scroll down to next page")
    @QaseId(value = 5091)
    @Test
    public void testScrollToNextPage_ImagePage() {

        final List<String> oldSize = openBaseURL()
                .inputSearchCriteriaAndEnter("Lady gaga")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=Lady+gaga")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleTenImages()
                .getLinksAllImages();

        final List<String> newSize = new ImagePage(getDriver())
                .scrollToLastImage()
                .getLinksAllImages();

        Assert.assertNotEquals(newSize,oldSize);
    }
    @QaseTitle("Check that image result equals search criteria")
    @QaseId(value = 5092)
    @Test
    public void testImageResultsEqualsSearchCriteria(){
        ImagePage imagePage = new ImagePage(getDriver());

        final List<String> titleAllImage = openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=ivanka")
                .waitForLoaderToBeInVisible()
                .getAltAttributeAllImages();

        final int actualSize = imagePage.getLinksAllImages().size();

        Assert.assertTrue(actualSize >= 50);
        for (String searchCriteria : titleAllImage) {
            Assert.assertTrue(searchCriteria.toLowerCase().contains("ivan"));
        }
    }
    @QaseTitle("Check related search container")
    @QaseId(value = 5093)
    @Test
    public void testRelatedSearch_ImagePage() {

        final String actualRegion = openBaseURL()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .choiceRegionGermany()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery + "&region=")
                .getCurrentURL();

        final String textsRelatedSearch = new ImagePage(getDriver()).getTitleOfImagesInRelatedSearche();

        Assert.assertTrue(textsRelatedSearch.toLowerCase().contains(searchQuery));
        Assert.assertEquals(actualRegion,ProjectConstants.DOMAIN +"/en/images?query=ronaldo&region=de-DE");

    }
    @QaseTitle("Check select any query from related search container")
    @QaseId(value = 5094)
    @Test
    public void testSelectAnyQueryFromRelatedSearch_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());

        final String actualUrl = openBaseURL()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleTenImages()
                .choiceRegionGermany()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery + "&region=de-DE")
                .getCurrentURL();

        final String newUrl = imagePage
                .clickSecondQueryInRelatedSearchContainer()
                .getCurrentURL();

        Assert.assertNotEquals(actualUrl,newUrl);
    }
    @QaseTitle("Check filter search")
    @QaseId(value = 5095)
    @Test
    public void testFilterSearch_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        final String actualTitleImage = openBaseURL()
                .inputSearchCriteriaAndEnter("color")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=color")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleTenImages()
                .clickFilterButton()
                .clickColorButton()
                .clickRedColorInDropdownListOfColorsFilter()
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFiveImages()
                .clickFirstImageInImagesResult()
                .getTitleFirstImage();

        Assert.assertTrue(actualTitleImage.contains("Red"));
        Assert.assertEquals(imagePage.getCurrentURL(),
                ProjectConstants.DOMAIN +"/en/images?query=color&color=Red");
    }
    @QaseTitle("Check next button and prev button of advertising")
    @QaseId(value = 5096)
    @Test(retryAnalyzer = Retry.class)
    public void testNextButtonAndPrevButtonOfAdvertising_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());

        openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("iphone price in germany")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=iphone+price+in+germany&region=de-DE")
                .clickNextButtonInRelatedSearch();

        Assert.assertTrue(imagePage.lastImageInAdsIsDisplayed());

        imagePage.clickPrevButtonInRelatedSearch();

        Assert.assertTrue(imagePage.firstImageInAdsIsDisplayed());
    }
    @QaseTitle("Check prev button in side View")
    @QaseId(value = 5097)
    @Test(retryAnalyzer = Retry.class)
    public void testPrevButtonInSideView_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());

        final String actualAttributePrevImage = openBaseURL()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .clickFirstImageInImagesResult()
                .clickNextButtonInSideImageview()
                .getAttributeFirstImage();

        final String newAttributePrevImage = imagePage
                .clickPrevButtonInSideImageview()
                .getAttributeFirstImage();


        Assert.assertNotEquals(actualAttributePrevImage,newAttributePrevImage);
        Assert.assertTrue(newAttributePrevImage.contains("active"));
    }
    @QaseTitle("Check that image in the images results equals image in side view")
    @QaseId(value = 5098)
    @Test
    public void testImageInResultEqualsImageInSideView_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());

        final String AttributeImageInResult = openBaseURL()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFiveImages()
                .getAttributeHrefOfImage();

        final String AttributeImageInSideView = imagePage
                .clickFirstImageInImagesResult()
                .getAttributeHrefImageInSideView();

        Assert.assertEquals(AttributeImageInResult,AttributeImageInSideView);
    }
    @QaseTitle("Check next button in side View")
    @QaseId(value = 5099)
    @Test
    public void testNextButtonInSideView_ImagePage() {

        final String actualAttributeSecondImage = openBaseURL()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=ronaldo")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFiveImages()
                .clickFirstImageInImagesResult()
                .clickNextButtonInSideImageview()
                .getAttributeSecondImage();

        Assert.assertEquals(actualAttributeSecondImage,"item--image active");
    }
    @QaseTitle("Check close button in side View")
    @QaseId(value = 5100)
    @Test
    public void testCloseButtonInSideView_ImagePage() {
        String searchQuery = "rep";

        final String actualAttributePrevImage = openBaseURL()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFiveImages()
                .clickFirstImageInImagesResult()
                .clickCloseButtonInSideImageview()
                .getAttributeFirstImage();

        Assert.assertEquals(actualAttributePrevImage,"item--image");
    }
    @QaseTitle("Check add image in favorite ")
    @QaseId(value = 5101)
    @Test(priority = 1,retryAnalyzer = Retry.class)
    public void testAddImageInFavorite_ImagePage() {

        openBaseURLAndGetCookie()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleTenImages()
                .loginUsingCookie()
                .clickFirstImageInImagesResult()
                .clickFavoriteButtonOfImageInSideView()
                .waitUntilToBeVisibleFavoriteItem();

        Assert.assertTrue(new ImagePage(getDriver()).favoriteItemIsDisplayed());


    }
    @QaseTitle("Check that added image equal image in favorite")
    @QaseId(value = 5102)
    @Test(dependsOnMethods = "testAddImageInFavorite_ImagePage",retryAnalyzer = Retry.class)
    public void testAddedImageEqualImageInFavorite_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());

        openBaseURLAndGetCookie()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleTenImages()
                .loginUsingCookie();

        final String AttributeImageInSideView = imagePage
                .clickFavoriteItem()
                .waitUrlToBeChanged("/en/images/my?query=" + searchQuery)
                .clickFirstImageInImagesResult()
                .getAttributeHrefImageInSideView();

        Assert.assertEquals(AttributeImageInSideView, imagePage.getAttributeHrefOfImage());
    }
    @QaseTitle("Check delete image from favorite")
    @QaseId(value = 5103)
    @Test(dependsOnMethods = "testAddedImageEqualImageInFavorite_ImagePage",retryAnalyzer = Retry.class )
    public void testDeleteImageFromFavorite_ImagePage_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());

        openBaseURLAndGetCookie()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleTenImages()
                .loginUsingCookie();

        final String actualH2Title = imagePage
                .clickFavoriteItem()
                .waitUrlToBeChanged("/en/images/my?query=" + searchQuery)
                .clickFirstImageInImagesResult()
                .clickFavoriteButtonOfImageInSideView()
                .refreshImagePage()
                .getErrorOfTitleInFavorite();

        Assert.assertTrue(actualH2Title.contains("No items found"));
        Assert.assertEquals( new MusicPage(getDriver()).getFontSizeErrorTitleInFavoritePlaylist(),ProjectConstants.FONT_SIZE_40_PX);
    }
    @QaseTitle("Check add several images to favorite")
    @QaseId(value = 5104)
    @Test(dependsOnMethods = "testDeleteImageFromFavorite_ImagePage_ImagePage")
    public void testAddSeveralImagesToFavorite_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());

        openBaseURLAndGetCookie()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleTenImages()
                .loginUsingCookie()
                .clickFirstImageInImagesResult()
                .clickFavoriteButtonOfImageInSideView()
                .clickNextButtonInSideImageview()
                .clickFavoriteButtonOfImageInSideView()
                .clickFavoriteItem()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/images/my?query=" + searchQuery);


        Assert.assertEquals(imagePage.getLinksAllImages().size(), 2);
    }
    @QaseTitle("Check change language in favorite")
    @QaseId(value = 5105)
    @Test(dependsOnMethods = "testAddSeveralImagesToFavorite_ImagePage")
    public void testChangeLanguageInFavorite_ImagePage() {
            ImagePage imagePage = new ImagePage(getDriver());

            openBaseURLAndGetCookie()
                    .inputSearchCriteriaAndEnter(searchQuery)
                    .waitUntilVisibilityWebResult()
                    .clickImageButton()
                    .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                    .waitForLoaderToBeInVisible()
                    .waitUtilToBeVisibleTenImages()
                    .loginUsingCookie()
                    .clickFavoriteItem()
                    .waitUrlToBeChanged("/en/images/my?query=" + searchQuery)
                    .choiceDeutschLocalisation();

            Assert.assertEquals(imagePage.getCurrentURL(),ProjectConstants.DOMAIN + "/de/images/my?query=" + searchQuery);
            Assert.assertEquals(imagePage.getTitle(),"Meine Bilder - Swisscows");

    }
    @QaseTitle("Check delete several images from favorite")
    @QaseId(value = 5106)
    @Test(dependsOnMethods = "testChangeLanguageInFavorite_ImagePage")
        public void testDeletedSeveralImagesFromFavorite_ImagePage () {

        openBaseURLAndGetCookie()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query="+ searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleTenImages()
                .loginUsingCookie()
                .clickFirstImageInImagesResult()
                .clickFavoriteButtonOfImageInSideView()
                .clickNextButtonInSideImageview()
                .clickFavoriteButtonOfImageInSideView();

        Assert.assertFalse(new ImagePage(getDriver()).isFavoriteItemIsPresent());
    }
}

