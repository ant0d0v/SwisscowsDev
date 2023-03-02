package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.ImagePage;
import pages.top_menu.MusicPage;
import pages.top_menu.VideoPage;
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

        Assert.assertTrue(titleFirstImage.toLowerCase().contains("ivanka"));

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
    public void testRelatedSearch_ImagePage() {
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
        final List<String> textsRelatedSearch = imagePage.getTitleInRelatedSearchesImages();


        for (String search : textsRelatedSearch) {
            Assert.assertTrue(search.toLowerCase().contains("ronal"));
        }
        Assert.assertEquals(actualRegion,"https://dev.swisscows.com/en/images?query=ronaldo&region=de-DE");

    }
    @Test
    public void testSelectAnyQueryFromRelatedSearch_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains("https://dev.swisscows.com/en/images?query=ronaldo");

        final String actualUrl = imagePage.getCurrentURL();
        imagePage
                .clickSecondQueryInRelatedSearchContainer()
                .getAltAllImages();

        final String newUrl = imagePage.getCurrentURL();
        final int actualSize = imagePage.getLinksAllImages().size();

        Assert.assertTrue(actualSize >= 50);
        Assert.assertNotEquals(actualUrl,newUrl);

    }

    @Test
    public void testFilterSearch_ImagePage() {
        ImagePage imagePage = new ImagePage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("photo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .clickFilterButton();
       imagePage
                .clickSizeButton()
                .clickSmallSizeInDropdownSize()
                .waitForUrlContains("https://dev.swisscows.com/en/images?query=photo&region=de-DE&size=Small");
        final List<String> sizeAllImages = imagePage.getAttributeAllImages();
        System.out.println(sizeAllImages);

        for (String search : sizeAllImages) {
           Assert.assertTrue(search.contains("360px"));
       }

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
