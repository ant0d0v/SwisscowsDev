package tests.header;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.VideoPage;
import utils.ProjectConstants;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class VideoTest extends BaseTest {
    @Test
    public void testSuggestEqualsSearchCriteria_VideoSearch() {
        final String query = "ivanka";

        MainPage mainPage = openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .clickSearchFieldHeader();

        final List<String> actualSuggestion = mainPage
                .waitForSuggestToBeVisible()
                .getAllElementsText();

        final int actualSizeSuggest = mainPage.countElementsInSuggestContainer();

        Assert.assertEquals(mainPage.getAllElementsText().size(), 5);

        for (String searchCriteria : actualSuggestion) {
            assertTrue(mainPage.suggestIsDisplayed());
            assertTrue(actualSizeSuggest > 0);
            assertTrue(searchCriteria.contains(query));
        }
    }
    @Test
    public void testRegionalSearch_VideoPage() {
        VideoPage videoPage = new VideoPage(getDriver());

        final String actualRegion =   openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .selectGermanyRegion()
                .waitUrlToBeChanged("/en/video?query=ronaldo&region=de-DE")
                .waitForLoaderToBeInVisible()
                .getCurrentURL();

        final String titleAllVideo = videoPage
                .waitUntilVisibilityVideoResult()
                .getTitleFirstVideo();


        Assert.assertEquals(actualRegion,ProjectConstants.DOMAIN + "/en/video?query=ronaldo&region=de-DE");
        assertTrue(titleAllVideo.toLowerCase().contains("ronaldo"));

    }
    @Test
    public void testScrollToNextPage_VideoPage() {
        VideoPage videoPage = new VideoPage(getDriver());

        final List<String> oldSize = openBaseURL()
                .inputSearchCriteriaAndEnter("rep")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .waitUntilToBeVisibleAllImagesOfVideo()
                .getTitleAllVideo();

        final List<String> newSize = videoPage
                .scrollToLastVideo()
                .waitUntilToBeVisibleAllImagesOfVideo()
                .getTitleAllVideo();

        Assert.assertNotEquals(newSize.size() ,oldSize.size());
        assertTrue(newSize.size()  >= 19);
    }
    @Test
    public void testScrollToNextPageInSideListOfVideos_VideoPage() throws InterruptedException {
        VideoPage videoPage = new VideoPage(getDriver());

        final List<String> oldSize = openBaseURL()
                .inputSearchCriteriaAndEnter("rep")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .waitUntilToBeVisibleAllImagesOfVideo()
                .clickFirstVideoResult()
                .getTitleAllVideo();

        final List<String> newSize = videoPage
                .scrollToLastVideoInTheSideList()
                .waitUntilToBeVisibleAllImagesOfVideo()
                .getTitleAllVideo();

        Assert.assertNotEquals(newSize.size() ,oldSize.size());
        assertTrue(newSize.size()  >= 19);
    }
    @Test
    public void testVideoResultsEqualsSearchCriteria(){
        VideoPage videoPage = new VideoPage(getDriver());
        final List<String> titleAllTracks = openBaseURL()
                .inputSearchCriteriaAndEnter("iphone")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUtilLoaderToBeInVisible()
                .waitUntilVisibilityVideoResult()
                .waitUntilToBeVisibleAllImagesOfVideo()
                .getTitleAllVideo();


        final int actualSize = videoPage.getTitleAllVideo().size();

        assertTrue(actualSize >= 10);
        for (String searchCriteria : titleAllTracks) {
            assertTrue(searchCriteria.toLowerCase().contains("iphone"));
        }
    }

    @Test
    public void testVideoResultsEqualsSearchCriteriaWhenVideoIsSelected(){
        VideoPage videoPage = new VideoPage(getDriver());
        final List<String> titleAllTracks = openBaseURL()
                .inputSearchCriteriaAndEnter("iphone")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUtilLoaderToBeInVisible()
                .waitUntilVisibilityVideoResult()
                .waitUntilToBeVisibleAllImagesOfVideo()
                .clickFirstVideoResult()
                .waitUntilToBeVisibleAllImagesOfVideo()
                .getTitleAllVideo();

        final int actualSize = videoPage.getTitleAllVideo().size();

        assertTrue(actualSize >= 10);
        for (String searchCriteria : titleAllTracks) {
            assertTrue(searchCriteria.toLowerCase().contains("iphone"));
        }
    }
    @Test
    public void testPlayVideoFromSideList(){
        final  String actualSrc = openBaseURL()
                .inputSearchCriteriaAndEnter("short video")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUtilLoaderToBeInVisible()
                .waitUntilVisibilityVideoResult()
                .waitUntilToBeVisibleAllImagesOfVideo()
                .clickFirstVideoResult()
                .waitUntilToBeVisibleAllImagesOfVideo()
                .clickSecondVideoFromSideList()
                .clickPlayerYouTubeVideo()
                .waitUntilTimeOfFirstVideoToBeChanged("0:02")
                .getVideoImageAttribute();
                 captureScreenshot();

        assertTrue(actualSrc.contains("https://www.youtube-nocookie.com"));
    }
    @Test
    public void testPlayVideo_VideoPage() throws IOException {
        VideoPage videoPage = new VideoPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("плакала")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .clickFirstVideoResult()
                .clickPlayerYouTubeVideo()
                .waitUntilTimeOfFirstVideoToBeChanged("0:02");
                 captureScreenshot();

        final String actualSrc = videoPage.getVideoImageAttribute();

        assertTrue(actualSrc.contains("https://www.youtube-nocookie.com"));

    }
    @Test
    public void testCheckboxNoRemindMe_VideoPage()  {
        VideoPage videoPage = new VideoPage(getDriver());

        openBaseURL()
                .inputSearchCriteriaAndEnter("music")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilVisibilityVideoResult()
                .clickFirstVideoResult()
                .clickCheckboxNoRemindMe()
                .clickPlayerYouTubeVideo()
                .waitUntilTimeOfFirstVideoToBeChanged("0:02")
                .refreshVideoPage()
                .clickFirstVideoResult()
                .waitUntilTimeOfFirstVideoToBeChanged("0:01");

        assertFalse(videoPage.isWarningMessageIsPresent());

    }
    @Test
    public void testImageProxy_VideoPage() {
        final List<String> actualSrc = openBaseURL()
                .inputSearchCriteriaAndEnter("iphone")
                .waitUntilVisibilityWebResult()
                .clickVideoButton()
                .waitUntilToBeVisibleAllImagesOfVideo()
                .getProxyImageAttributes();

        for (String search : actualSrc) {
            assertTrue(search.contains("https://cdn.swisscows.com/image"));
        }
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
                .clickPublisherButton();

        Assert.assertEquals(videoPage.getAttributeOfPublisherButton(),"button-menu open");

        final List<String> durationAllVideo = videoPage
                .clickDailyMotionButtonInDropdownOfPublisher()
                .getListMetadataAllVideo();

        for (String search : durationAllVideo) {
            assertTrue(search.contains("DailyMotion"));
        }
        Assert.assertEquals(videoPage.getCurrentURL(),ProjectConstants.DOMAIN + "/en/video?query=ivanka&publisher=DailyMotion");
    }
    @Test
    public void testCancelFilterSearch_VideoPage() {
        VideoPage videoPage = new VideoPage(getDriver());
        final String oldUrl = openBaseURL()
                 .inputSearchCriteriaAndEnter("ivanka")
                 .waitUntilVisibilityWebResult()
                 .clickVideoButton()
                 .waitUntilVisibilityVideoResult()
                 .clickFilterButton()
                 .clickPublisherButton()
                 .clickDailyMotionButtonInDropdownOfPublisher()
                 .getCurrentURL();

        final String newUrl = videoPage
                .clickFilterButton()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(newUrl,ProjectConstants.DOMAIN + "/en/video?query=ivanka");
    }
}
