package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.MusicPage;
import pages.top_menu.VideoPage;

import java.io.IOException;
import java.util.List;

public class VideoTest extends BaseTest {
    @Test
    public void testSuggestEqualsSearchCriteria_VideoSearch() {
        final String query = "ivanka";

        MainPage mainPage = openBaseURL();
        openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
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
    public void testRegionalSearch_VideoPage() {
        VideoPage videoPage = new VideoPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains("https://dev.swisscows.com/en/video?query=ivanka&region=");

        final String actualRegion = videoPage.getCurrentURL();
        final List<String> titleAllVideo = videoPage.getTitleAllVideo();


        Assert.assertEquals(actualRegion,"https://dev.swisscows.com/en/video?query=ivanka&region=de-DE");
        for (String search : titleAllVideo) {
            Assert.assertTrue(search.toLowerCase().contains("ivan"));
        }
    }
    @Test
    public void testScrollToNextPage_VideoPage() throws InterruptedException {
        MusicPage videoResult = new MusicPage(getDriver());
        VideoPage videoPage = new VideoPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("Lady gaga")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult();
        videoResult.scrollToLastTrack();
        sleep(1000);
        final List<String> titleAllVideo = videoPage.getTitleAllVideo();

        Assert.assertTrue(titleAllVideo.size() >= 40);


    }
    @Test
    public void testVideoResultsEqualsSearchCriteria(){
        VideoPage videoPage = new VideoPage(getDriver());
        final List<String> titleAllTracks = openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .getTitleAllVideo();

        final int actualSize = videoPage.getTitleAllVideo().size();

        Assert.assertTrue(actualSize >= 20);
        for (String searchCriteria : titleAllTracks) {
            Assert.assertTrue(searchCriteria.toLowerCase().contains("ivan"));
        }

    }
    @Test
    public void testRelatedSearch_VideoPage() {
        VideoPage videoPage = new VideoPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains("https://dev.swisscows.com/en/video?query=ronaldo&region=");

        final String actualRegion = videoPage.getCurrentURL();
        final List<String> titleAllVideo = videoPage.getTitleInRelatedSearches();

        Assert.assertEquals(actualRegion,"https://dev.swisscows.com/en/video?query=ronaldo&region=de-DE");
        for (String search : titleAllVideo) {
            Assert.assertTrue(search.toLowerCase().contains("ronaldo"));
        }
    }
    @Test
    public void testPlayVideo_VideoPage() throws InterruptedException, IOException {
        VideoPage videoPage = new VideoPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .clickFirstVideoResult()
                .clickPlayerYouTubeVideo()
                .screen("youtube.png");
        final String actualSrc = videoPage.getVideoImageAttribute();

        Assert.assertTrue(actualSrc.contains("youtube.com"));

    }
}
