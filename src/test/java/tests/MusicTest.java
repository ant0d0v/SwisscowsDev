package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MusicTest extends BaseTest {

        @Test
        public void testPlayMusic() throws InterruptedException {
            String actualAttribute = openBaseURL()
                    .inputSearchCriteriaAndEnter("Popular")
                    .waitUntilVisibilityWebResult()
                    .clickMusicButton()
                    .waitUntilVisibilityAudioResult()
                    .clickPlayButton()
                    .getPlayButtonAttribute();

            Assert.assertEquals(actualAttribute, "/images/icons.svg#pause");
        }

    @Test
    public void testPauseMusic() throws InterruptedException {
        String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Popular")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .clickPauseButton()
                .getPlayButtonAttribute();

        Assert.assertEquals(actualAttribute, "/images/icons.svg#play");
    }

    @Test
    public void testSkipToNextSong() throws InterruptedException {
        String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .clickForwardButton()
                .getNextTrackAttribute();

        Assert.assertTrue(actualAttribute.contains("item item--audio active"));
    }
    @Test
    public void testSkipToPreviousSong() throws InterruptedException {
        String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .clickForwardButton()
                .clickBackButton()
                .getPreviousTrackAttribute();

        Assert.assertTrue(actualAttribute.contains("item item--audio active"));
    }

    @Test
    public void testSetTimeInPlayer() throws InterruptedException {
        String actualTime = openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .clickToProgressbar()
                .getVolumeInProgressbarAttribute();
                 sleep(1000);

        Assert.assertTrue(actualTime.contains("width: 50."));
    }


    }
