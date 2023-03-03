package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.ImagePage;
import tests.retrytest.Retry;
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
    public void testRegionalSearch_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains("https://dev.swisscows.com/en/images?query=ivanka&region=");

        final String actualRegion = imagePage.getCurrentURL();
        final String titleFirstImage = imagePage
                .clickFirstImageInImagesResult()
                .getTitleFirstImage();


        Assert.assertEquals(actualRegion,"https://dev.swisscows.com/en/images?query=ivanka&region=de-DE");

        Assert.assertTrue(titleFirstImage.toLowerCase().contains("ivan"));

    }
    @Test
    public void testScrollToNextPage_ImagePage() throws InterruptedException {
        ImagePage imagePage =new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("Lady gaga")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .scrollToLastImage();
        sleep(1000);
        final List<String> AllLinks = imagePage.getLinksAllImages();

        Assert.assertTrue(AllLinks.size() >= 70);


    }
    @Test
    public void testImageResultsEqualsSearchCriteria(){
        ImagePage imagePage = new ImagePage(getDriver());
        final List<String> titleAllImage = openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .getAltAllImages();

        final int actualSize = imagePage.getLinksAllImages().size();

        Assert.assertTrue(actualSize >= 50);
        for (String searchCriteria : titleAllImage) {
            Assert.assertTrue(searchCriteria.toLowerCase().contains("ronal"));
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
                .waitForUrlContains("https://dev.swisscows.com/en/images?query=ronaldo&region=");

        final String actualRegion = imagePage.getCurrentURL();
        final String textsRelatedSearch = imagePage.getTitleInRelatedSearchesImages();

            Assert.assertTrue(textsRelatedSearch.toLowerCase().contains("ronaldo"));

        Assert.assertEquals(actualRegion,"https://dev.swisscows.com/en/images?query=ronaldo&region=de-DE");

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
                .waitForUrlContains("https://dev.swisscows.com/en/images?query=ronaldo");

        final String actualUrl = imagePage.getCurrentURL();
        imagePage
                .clickSecondQueryInRelatedSearchContainer()
                .waitForUrlContains("https://dev.swisscows.com/en/images?query=Ronaldo%");

        final String newUrl = imagePage.getCurrentURL();

        Assert.assertNotEquals(actualUrl,newUrl);

    }

    @Test
    public void testFilterSearch_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
       openBaseURL()
                .inputSearchCriteriaAndEnter("photo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .waitForLoaderIsDisappeared()
                .clickFilterButton();

       imagePage
                .clickColorButton()
                .clickRedColorInDropdownColors()
                .waitForUrlContains("https://dev.swisscows.com/en/images?query=photo&color=");
        final String actualTitleImage = imagePage.getAttributeImage();

            Assert.assertTrue(actualTitleImage.toLowerCase().contains("red"));
            Assert.assertEquals(imagePage.getCurrentURL(),
                   "https://dev.swisscows.com/en/images?query=photo&color=Red");
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
                .waitForUrlContains("https://dev.swisscows.com/en/images?query=crocs+price&region=de-DE");
        imagePage
                .clickNextButton();
        Assert.assertTrue(imagePage.lastImageInAdsIsDisplayed());
        imagePage
                .clickPrevButton();
        Assert.assertTrue(imagePage.firstImageInAdsIsDisplayed());
    }
}
