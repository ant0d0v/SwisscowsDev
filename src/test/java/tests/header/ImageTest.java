package tests.header;
import base.BaseTest;
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
    @Test
    public void testScrollToNextPage_ImagePage() {

        final List<String> oldSize = openBaseURL()
                .inputSearchCriteriaAndEnter("Lady gaga")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=Lady+gaga")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .getLinksAllImages();

        final List<String> newSize = new ImagePage(getDriver())
                .scrollToLastImage()
                .getLinksAllImages();

        Assert.assertNotEquals(newSize,oldSize);


    }
    @Test
    public void testImageResultsEqualsSearchCriteria(){
        ImagePage imagePage = new ImagePage(getDriver());

        final List<String> titleAllImage = openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=ivanka")
                .waitForLoaderToBeInVisible()
                .getAltAllImages();

        final int actualSize = imagePage.getLinksAllImages().size();

        Assert.assertTrue(actualSize >= 50);
        for (String searchCriteria : titleAllImage) {
            Assert.assertTrue(searchCriteria.toLowerCase().contains("ivan"));
        }

    }
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

        final String textsRelatedSearch = new ImagePage(getDriver()).getTitleInRelatedSearchesImages();

        Assert.assertTrue(textsRelatedSearch.toLowerCase().contains(searchQuery));
        Assert.assertEquals(actualRegion,ProjectConstants.DOMAIN +"/en/images?query=ronaldo&region=de-DE");

    }
    @Test
    public void testSelectAnyQueryFromRelatedSearch_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());

        final String actualUrl = openBaseURL()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .choiceRegionGermany()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery + "&region=de-DE")
                .getCurrentURL();

        final String newUrl = imagePage
                .clickSecondQueryInRelatedSearchContainer()
                .getCurrentURL();

        Assert.assertNotEquals(actualUrl,newUrl);
    }

    @Test
    public void testFilterSearch_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        final String actualTitleImage = openBaseURL()
                .inputSearchCriteriaAndEnter("color")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=color")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .clickFilterButton()
                .clickColorButton()
                .clickRedColorInDropdownColors()
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .clickFirstImageInImagesResult()
                .getTitleFirstImage();

        Assert.assertTrue(actualTitleImage.contains("Red"));
        Assert.assertEquals(imagePage.getCurrentURL(),
                ProjectConstants.DOMAIN +"/en/images?query=color&color=Red");
    }


    @Test(retryAnalyzer = Retry.class)
    public void testNextButtonAndPrevButtonAdvertising_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());

        openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("iphone price in germany")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=iphone+price+in+germany&region=de-DE")
                .clickNextButton();

        Assert.assertTrue(imagePage.lastImageInAdsIsDisplayed());

        imagePage.clickPrevButton();

        Assert.assertTrue(imagePage.firstImageInAdsIsDisplayed());
    }
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
    @Test
    public void testImageInResultEqualsImageInSideView_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());

        final String AttributeImageInResult = openBaseURL()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .getAttributeHrefImage();

        final String AttributeImageInSideView = imagePage
                .clickFirstImageInImagesResult()
                .getAttributeHrefImageInSideView();

        Assert.assertEquals(AttributeImageInResult,AttributeImageInSideView);
    }
    @Test
    public void testNextButtonInSideView_ImagePage() {

        final String actualAttributeSecondImage = openBaseURL()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=ronaldo")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .clickFirstImageInImagesResult()
                .clickNextButtonInSideImageview()
                .getAttributeSecondImage();

        Assert.assertEquals(actualAttributeSecondImage,"item--image active");
    }
    @Test
    public void testCloseButtonInSideView_ImagePage() {
        String searchQuery = "rep";

        final String actualAttributePrevImage = openBaseURL()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .clickFirstImageInImagesResult()
                .clickCloseButtonInSideImageview()
                .getAttributeFirstImage();

        Assert.assertEquals(actualAttributePrevImage,"item--image");
    }
    @Test(priority = 1,retryAnalyzer = Retry.class)
    public void testAddImageInFavorite_ImagePage() {

        openBaseURLUsingCookie()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .loginUsingCookie()
                .clickFirstImageInImagesResult()
                .clickFavoriteButtonInSideImageview()
                .waitUntilToBeVisibleFavoriteItem();

        Assert.assertTrue(new ImagePage(getDriver()).favoriteItemIsDisplayed());


    }
    @Test(dependsOnMethods = "testAddImageInFavorite_ImagePage",retryAnalyzer = Retry.class)
    public void testAddedImageEqualImageInFavorite_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());


        openBaseURLUsingCookie()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .clickHamburgerMenu()
                .signIn();

        final String AttributeImageInSideView = imagePage
                .clickFavoriteItem()
                .waitUrlToBeChanged("/en/images/my?query=" + searchQuery)
                .clickFirstImageInImagesResult()
                .getAttributeHrefImageInSideView();


        Assert.assertEquals(AttributeImageInSideView, imagePage.getAttributeHrefImage());

    }
    @Test(dependsOnMethods = "testAddedImageEqualImageInFavorite_ImagePage",retryAnalyzer = Retry.class )
    public void testDeleteImageFromFavorite_ImagePage_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());

        openBaseURLUsingCookie()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .loginUsingCookie();

        final String actualH2Title = imagePage
                .clickFavoriteItem()
                .waitUrlToBeChanged("/en/images/my?query=" + searchQuery)
                .clickFirstImageInImagesResult()
                .clickFavoriteButtonInSideImageview()
                .refreshImagePage()
                .getErrorTitleInFavoritePlaylist();

        Assert.assertTrue(actualH2Title.contains("No items found"));
        Assert.assertEquals( new MusicPage(getDriver()).getFontSizeErrorTitleInFavoritePlaylist(),ProjectConstants.FONT_SIZE_40_PX);
    }
    @Test(dependsOnMethods = "testDeleteImageFromFavorite_ImagePage_ImagePage")
    public void testAddSeveralImagesInFavorite_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());


        openBaseURLUsingCookie()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .loginUsingCookie()
                .clickFirstImageInImagesResult()
                .clickFavoriteButtonInSideImageview()
                .clickNextButtonInSideImageview()
                .clickFavoriteButtonInSideImageview()
                .clickFavoriteItem()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/images/my?query=" + searchQuery);


        Assert.assertEquals(imagePage.getLinksAllImages().size(), 2);
    }
    @Test(dependsOnMethods = "testAddSeveralImagesInFavorite_ImagePage")
    public void testChangeLanguageInFavorite_ImagePage() {
            ImagePage imagePage = new ImagePage(getDriver());

            openBaseURLUsingCookie()
                    .inputSearchCriteriaAndEnter(searchQuery)
                    .waitUntilVisibilityWebResult()
                    .clickImageButton()
                    .waitUrlToBeChanged("/en/images?query=" + searchQuery)
                    .waitForLoaderToBeInVisible()
                    .waitUtilToBeVisibleFifteenImages()
                    .loginUsingCookie()
                    .clickFavoriteItem()
                    .waitUrlToBeChanged("/en/images/my?query=" + searchQuery)
                    .choiceDeutschLocalisation();

            Assert.assertEquals(imagePage.getCurrentURL(),ProjectConstants.DOMAIN + "/de/images/my?query=" + searchQuery);
            Assert.assertEquals(imagePage.getTitle(),"Meine Bilder - Swisscows");

    }
        @Test(dependsOnMethods = "testChangeLanguageInFavorite_ImagePage")
        public void testDeletedSeveralImagesFromFavorite_ImagePage () {

            openBaseURLUsingCookie()
                    .inputSearchCriteriaAndEnter(searchQuery)
                    .waitUntilVisibilityWebResult()
                    .clickImageButton()
                    .waitUrlToBeChanged("/en/images?query="+ searchQuery)
                    .waitForLoaderToBeInVisible()
                    .waitUtilToBeVisibleFifteenImages()
                    .loginUsingCookie()
                    .clickFirstImageInImagesResult()
                    .clickFavoriteButtonInSideImageview()
                    .clickNextButtonInSideImageview()
                    .clickFavoriteButtonInSideImageview();

            Assert.assertFalse(new ImagePage(getDriver()).isFavoriteItemIsPresent());
        }
}

