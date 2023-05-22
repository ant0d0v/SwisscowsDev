package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.ImagePage;
import pages.top_menu.MusicPage;
import tests.retrytest.Retry;
import utils.ProjectConstants;
import utils.TestUtils;
import java.util.List;


public class ImageTest extends BaseTest {
    @Test
    public void testSuggestEqualsSearchCriteria_ImageSearch() {
        final String query = "ivanka";

        MainPage mainPage = openBaseURL();
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
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/images?query=ivanka&region=de-DE");

        final String actualRegion = imagePage.getCurrentURL();

        Assert.assertEquals(actualRegion,ProjectConstants.DOMAIN +"/en/images?query=ivanka&region=de-DE");


    }
    @Test
    public void testScrollToNextPage_ImagePage() throws InterruptedException {
        ImagePage imagePage =new ImagePage(getDriver());
        final List<String> oldSize = openBaseURL()
                .inputSearchCriteriaAndEnter("Lady gaga")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitForLoaderIsDisappeared()
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
                .getAltAllImages();

        final int actualSize = imagePage.getLinksAllImages().size();

        Assert.assertTrue(actualSize >= 50);
        for (String searchCriteria : titleAllImage) {
            Assert.assertTrue(searchCriteria.toLowerCase().contains("ivan"));
        }

    }
    @Test
    public void testRelatedSearch_ImagePage() throws InterruptedException {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains(ProjectConstants.DOMAIN +"/en/images?query=ronaldo&region=");

        final String actualRegion = imagePage.getCurrentURL();
        final String textsRelatedSearch = imagePage.getTitleInRelatedSearchesImages();

        Assert.assertTrue(textsRelatedSearch.toLowerCase().contains("ronaldo"));

        Assert.assertEquals(actualRegion,ProjectConstants.DOMAIN +"/en/images?query=ronaldo&region=de-DE");

    }
    @Test
    public void testSelectAnyQueryFromRelatedSearch_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .clickHamburgerMenuIcon()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains(ProjectConstants.DOMAIN +"/en/images?query=ronaldo");

        final String actualUrl = imagePage.getCurrentURL();
        imagePage
                .clickSecondQueryInRelatedSearchContainer()
                .waitForUrlContains(ProjectConstants.DOMAIN +"/en/images?query=Ronaldo%");

        final String newUrl = imagePage.getCurrentURL();

        Assert.assertNotEquals(actualUrl,newUrl);
    }

    @Test(retryAnalyzer = Retry.class)
    public void testFilterSearch_ImagePage() throws InterruptedException {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("photo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitForLoaderIsDisappeared()
                .clickFilterButton_ImagePage()
                .clickColorButton()
                .clickRedColorInDropdownColors()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/images?query=photo&color=Red");

        final String actualTitleImage = imagePage
                .clickFirstImageInImagesResult()
                .getTitleFirstImage();

        Assert.assertTrue(actualTitleImage.contains("Red"));
        Assert.assertEquals(imagePage.getCurrentURL(),
                ProjectConstants.DOMAIN +"/en/images?query=photo&color=Red");
    }


    @Test(retryAnalyzer = Retry.class)
    public void testNextButtonAndPrevButtonAdvertising_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("crocs price")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains(ProjectConstants.DOMAIN +"/en/images?query=crocs+price&region=de-DE");
        imagePage
                .clickNextButton();
        Assert.assertTrue(imagePage.lastImageInAdsIsDisplayed());
        imagePage
                .clickPrevButton();
        Assert.assertTrue(imagePage.firstImageInAdsIsDisplayed());
    }
    @Test(retryAnalyzer = Retry.class)
    public void testPrevButtonInSideView_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/images?query=ronaldo");


        final String actualAttributePrevImage = imagePage
                .clickFirstImageInImagesResult()
                .clickNextButtonInSideImageview()
                .getAttributeFirstImage();

        final String newAttributePrevImage = imagePage
                .clickPrevButtonInSideImageview()
                .getAttributeFirstImage();


        Assert.assertNotEquals(actualAttributePrevImage,newAttributePrevImage);
        Assert.assertTrue(newAttributePrevImage.contains("active"));
    }
    @Test(retryAnalyzer = Retry.class)
    public void testImageInResultEqualsImageInSideView_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitForUrlContains(ProjectConstants.DOMAIN +"/en/images?query=ronaldo");

        final String AttributeImageInResult = imagePage
                .waitForImageIsVisible()
                .getAttributeHrefImage();

        final String AttributeImageInSideView = imagePage
                .clickFirstImageInImagesResult()
                .getAttributeHrefImageInSideView();

        Assert.assertEquals(AttributeImageInResult,AttributeImageInSideView);
    }
    @Test
    public void testNextButtonInSideView_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/images?query=ronaldo");


        final String actualAttributeSecondImage = imagePage
                .waitForImageIsVisible()
                .clickFirstImageInImagesResult()
                .clickNextButtonInSideImageview()
                .getAttributeSecondImage();

        Assert.assertEquals(actualAttributeSecondImage,"item--image active");
    }
    @Test
    public void testCloseButtonInSideView_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("rep")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/images?query=rep");

        TestUtils.waitForPageLoaded(getDriver());

        final String actualAttributePrevImage = imagePage
                .waitForImageIsVisible()
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
                .waitForLoaderIsDisappeared()
                .clickHamburgerMenu()
                .signIn();
       imagePage
                .clickFirstImageInImagesResult()
                .clickFavoriteButtonInSideImageview();

        Assert.assertTrue(imagePage.favoriteItemIsDisplayed());


    }
    @Test(priority = 2,retryAnalyzer = Retry.class)
    public void testAddedImageEqualImageInFavorite_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitForLoaderIsDisappeared()
                .clickHamburgerMenu()
                .signIn();
        imagePage
                .clickFavoriteItem()
                .waitForUrlContains(ProjectConstants.DOMAIN +"/en/images/my?query=ronaldo");
        final String AttributeImageInSideView = imagePage
                .clickFirstImageInImagesResult()
                .getAttributeHrefImageInSideView();


        Assert.assertEquals(AttributeImageInSideView, imagePage.getAttributeHrefImage());

    }
    @Test(priority = 3)
    public void testDeleteImageFromFavorite_ImagePage_ImagePage() {
        MusicPage musicPage =new MusicPage(getDriver());
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitForLoaderIsDisappeared()
                .clickHamburgerMenu()
                .signIn();
        imagePage
                .clickFavoriteItem()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/images/my?query=ronaldo");
        imagePage
                .clickFirstImageInImagesResult()
                .clickFavoriteButtonInSideImageview();
        getDriver().navigate().refresh();
        final String actualH2Title = musicPage.getErrorTitleInFavoritePlaylist();

        Assert.assertTrue(actualH2Title.contains("No items found"));
        Assert.assertEquals(musicPage.getFontSizeErrorTitleInFavoritePlaylist(),"40px");
    }
    @Test(priority = 4)
    public void testAddSeveralImagesInFavorite_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitForLoaderIsDisappeared()
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
    @Test(priority = 5)
    public void testChangeLanguageInFavorite_ImagePage() {
            ImagePage imagePage = new ImagePage(getDriver());
            openBaseURL()
                    .inputSearchCriteriaAndEnter("ronaldo")
                    .waitUntilVisibilityWebResult()
                    .clickImageButton()
                    .waitForLoaderIsDisappeared()
                    .clickHamburgerMenuIcon()
                    .signIn();
            imagePage
                    .clickFavoriteItem()
                    .waitForUrlContains(ProjectConstants.DOMAIN + "/en/images/my?query=ronaldo");
            imagePage
                    .clickHamburgerMenu()
                    .clickLanguagesTopMenu();
            imagePage
                    .clickLangDeutsch();

            Assert.assertEquals(imagePage.getCurrentURL(),ProjectConstants.DOMAIN + "/de/images/my?query=ronaldo");
            Assert.assertEquals(imagePage.getTitle(),"Meine Bilder - Swisscows");

    }
        @Test(priority = 6)
        public void testDeletedSeveralImagesFromFavorite_ImagePage () {
            ImagePage imagePage = new ImagePage(getDriver());
            openBaseURL()
                    .inputSearchCriteriaAndEnter("ronaldo")
                    .waitUntilVisibilityWebResult()
                    .clickImageButton()
                    .waitForLoaderIsDisappeared()
                    .clickHamburgerMenuIcon()
                    .signIn();

            imagePage
                    .clickFirstImageInImagesResult()
                    .clickFavoriteButtonInSideImageview()
                    .clickNextButtonInSideImageview()
                    .clickFavoriteButtonInSideImageview();
            try {
                imagePage.favoriteItemOnPage();
                Assert.fail("Item is present on the page!");
            } catch (org.openqa.selenium.NoSuchElementException e) {

            }


        }

}

