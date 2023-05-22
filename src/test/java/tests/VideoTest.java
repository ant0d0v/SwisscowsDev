package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.MusicPage;
import pages.top_menu.VideoPage;
import utils.ProjectConstants;

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
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/video?query=ivanka&region=");

        final String actualRegion = videoPage.getCurrentURL();
        final String titleAllVideo = videoPage.getTitleFirstVideo();


        Assert.assertEquals(actualRegion,ProjectConstants.DOMAIN + "/en/video?query=ivanka&region=de-DE");
        Assert.assertTrue(titleAllVideo.toLowerCase().contains("ivan"));

    }
    @Test
    public void testScrollToNextPage_VideoPage() throws InterruptedException {
        VideoPage videoPage = new VideoPage(getDriver());
        final List<String> oldSize = openBaseURL()
                .inputSearchCriteriaAndEnter("Lady gaga")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .getTitleAllVideo();

        final List<String> newSize = videoPage
                .scrollToLastVideo()
                .getTitleAllVideo();

        Assert.assertNotEquals(newSize.size() ,oldSize.size());

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
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/video?query=ronaldo&region=");

        final String actualRegion = videoPage.getCurrentURL();
        final List<String> titleAllVideo = videoPage.getTitleInRelatedSearches();

        Assert.assertEquals(actualRegion,ProjectConstants.DOMAIN + "/en/video?query=ronaldo&region=de-DE");
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
    @Test
    public void testImageProxy_VideoPage() throws InterruptedException, IOException {
        VideoPage videoPage = new VideoPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .clickFirstVideoResult()
                .clickPlayerYouTubeVideo()
                .screen("proxy.png");
        final String actualSrc = videoPage.getProxyImageAttribute();

        Assert.assertTrue(actualSrc.contains("https://cdn.swisscows.com/"));

    }
    @Test
    public void testFilterSearch_VideoPage() {
        VideoPage videoPage = new VideoPage(getDriver());
         openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .clickFilterButton()
                .clickDurationButton();
        Assert.assertEquals(videoPage.getDurationButtonAttribute(),"button-menu open");

        videoPage
                .clickShortInDropdownDuration()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/video?query=ivanka&videoLength=Short");
        final List<String> durationAllVideo = videoPage.getListDurationAllVideo();


        for (String search : durationAllVideo) {
            Assert.assertTrue((Integer.parseInt(search.substring(1, 2)) <= 4));
        }
        Assert.assertEquals(videoPage.getCurrentURL(),ProjectConstants.DOMAIN + "/en/video?query=ivanka&videoLength=Short");
    }
    @Test
    public void testCancelFilterSearch_VideoPage() {
        VideoPage videoPage = new VideoPage(getDriver());
         openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .clickFilterButton()
                .clickDurationButton()
                .clickShortInDropdownDuration()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/video?query=ivanka&videoLength=Short");


        final String oldUrl = videoPage.getCurrentURL();
        videoPage
                .clickFilterButton()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/video?query=ivanka");

        final String newUrl = videoPage.getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(newUrl,ProjectConstants.DOMAIN + "/en/video?query=ivanka");
    }
    @Test
    public void testHoverTextsRelatedSearch_VideoPage() throws InterruptedException {
        VideoPage videoPage = new VideoPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/video?query=ronaldo&region=");

        final List<String> oldTextsColorsWhenHover = videoPage.getTextColors();
        final List<String> newTextsColorsWhenHover = videoPage.getTextsColorsWhenHover();

        Assert.assertNotEquals(newTextsColorsWhenHover, oldTextsColorsWhenHover);
    }

}
