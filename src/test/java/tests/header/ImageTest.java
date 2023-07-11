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
        ImagePage imagePage = new ImagePage(getDriver());
        final List<String> oldSize = openBaseURL()
                .inputSearchCriteriaAndEnter("Lady gaga")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=Lady+gaga")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .getLinksAllImages();

        final List<String> newSize = imagePage
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
        ImagePage imagePage = new ImagePage(getDriver());
        final String actualRegion = openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=ronaldo")
                .waitForLoaderToBeInVisible()
                .choiceRegionGermany()
                .waitUrlToBeChanged("/en/images?query=ronaldo&region=")
                .getCurrentURL();

        final String textsRelatedSearch = imagePage.getTitleInRelatedSearchesImages();

        Assert.assertTrue(textsRelatedSearch.toLowerCase().contains("ronaldo"));
        Assert.assertEquals(actualRegion,ProjectConstants.DOMAIN +"/en/images?query=ronaldo&region=de-DE");

    }
    @Test
    public void testSelectAnyQueryFromRelatedSearch_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        final String actualUrl = openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=ronaldo")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .choiceRegionGermany()
                .waitUrlToBeChanged("/en/images?query=ronaldo&region=de-DE")
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
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=ronaldo")
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
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=ronaldo")
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
                .inputSearchCriteriaAndEnter("ronaldo")
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

        final String actualAttributePrevImage = openBaseURL()
                .inputSearchCriteriaAndEnter("rep")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=rep")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .clickFirstImageInImagesResult()
                .clickCloseButtonInSideImageview()
                .getAttributeFirstImage();

        Assert.assertEquals(actualAttributePrevImage,"item--image");
    }
    @Test(priority = 1,retryAnalyzer = Retry.class)
    public void testAddImageInFavorite_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=ronaldo")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .clickHamburgerMenu()
                .signIn();
       imagePage
                .clickFirstImageInImagesResult()
                .clickFavoriteButtonInSideImageview()
                .waitUntilToBeVisibleFavoriteItem();

        Assert.assertTrue(imagePage.favoriteItemIsDisplayed());


    }
    @Test(dependsOnMethods = "testAddImageInFavorite_ImagePage",retryAnalyzer = Retry.class)
    public void testAddedImageEqualImageInFavorite_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=ronaldo")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .clickHamburgerMenu()
                .signIn();

        final String AttributeImageInSideView = imagePage
                .clickFavoriteItem()
                .waitUrlToBeChanged("/en/images/my?query=ronaldo")
                .clickFirstImageInImagesResult()
                .getAttributeHrefImageInSideView();


        Assert.assertEquals(AttributeImageInSideView, imagePage.getAttributeHrefImage());

    }
    @Test(dependsOnMethods = "testAddedImageEqualImageInFavorite_ImagePage")
    public void testDeleteImageFromFavorite_ImagePage_ImagePage() {
        MusicPage musicPage =new MusicPage(getDriver());
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=ronaldo")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .clickHamburgerMenu()
                .signIn();

        final String actualH2Title = imagePage
                .clickFavoriteItem()
                .waitUrlToBeChanged("/en/images/my?query=ronaldo")
                .clickFirstImageInImagesResult()
                .clickFavoriteButtonInSideImageview()
                .refreshImagePage()
                .getErrorTitleInFavoritePlaylist();

        Assert.assertTrue(actualH2Title.contains("No items found"));
        Assert.assertEquals(musicPage.getFontSizeErrorTitleInFavoritePlaylist(),"40px");
    }
    @Test(dependsOnMethods = "testDeleteImageFromFavorite_ImagePage_ImagePage")
    public void testAddSeveralImagesInFavorite_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitUrlToBeChanged("/en/images?query=ronaldo")
                .waitForLoaderToBeInVisible()
                .waitUtilToBeVisibleFifteenImages()
                .clickHamburgerMenu()
                .signIn();
        imagePage
                .clickFirstImageInImagesResult()
                .clickFavoriteButtonInSideImageview()
                .clickNextButtonInSideImageview()
                .clickFavoriteButtonInSideImageview()
                .clickFavoriteItem()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/images/my?query=ronaldo");


        Assert.assertEquals(imagePage.getLinksAllImages().size(), 2);
    }
    @Test(dependsOnMethods = "testAddSeveralImagesInFavorite_ImagePage")
    public void testChangeLanguageInFavorite_ImagePage() {
            ImagePage imagePage = new ImagePage(getDriver());
            openBaseURL()
                    .inputSearchCriteriaAndEnter("ronaldo")
                    .waitUntilVisibilityWebResult()
                    .clickImageButton()
                    .waitUrlToBeChanged("/en/images?query=ronaldo")
                    .waitForLoaderToBeInVisible()
                    .waitUtilToBeVisibleFifteenImages()
                    .clickHamburgerMenuIcon()
                    .signIn();
            imagePage
                    .clickFavoriteItem()
                    .waitUrlToBeChanged("/en/images/my?query=ronaldo")
                    .choiceDeutschLocalisation();

            Assert.assertEquals(imagePage.getCurrentURL(),ProjectConstants.DOMAIN + "/de/images/my?query=ronaldo");
            Assert.assertEquals(imagePage.getTitle(),"Meine Bilder - Swisscows");

    }
        @Test(dependsOnMethods = "testChangeLanguageInFavorite_ImagePage")
        public void testDeletedSeveralImagesFromFavorite_ImagePage () {
            ImagePage imagePage = new ImagePage(getDriver());
            openBaseURL()
                    .inputSearchCriteriaAndEnter("ronaldo")
                    .waitUntilVisibilityWebResult()
                    .clickImageButton()
                    .waitUrlToBeChanged("/en/images?query=ronaldo")
                    .waitForLoaderToBeInVisible()
                    .waitUtilToBeVisibleFifteenImages()
                    .clickHamburgerMenuIcon()
                    .signIn();

            imagePage
                    .clickFirstImageInImagesResult()
                    .clickFavoriteButtonInSideImageview()
                    .clickNextButtonInSideImageview()
                    .clickFavoriteButtonInSideImageview();

            Assert.assertFalse(imagePage.isFavoriteItemIsPresent());
        }
}

