package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.top_menu.MusicPage;
import tests.retrytest.Retry;

import java.util.List;

public class MusicTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void testPlayMusic() throws InterruptedException {
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Popular")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .getPlayButtonAttribute();

        final String actualDuration = musicPage.getVolumeDuration();

        Assert.assertEquals(actualAttribute, "/images/icons.svg#pause");
        Assert.assertTrue(Double.parseDouble(actualDuration.substring(3, 4)) > 0);
    }

    @Test(retryAnalyzer = Retry.class)
    public void testPauseMusic() throws InterruptedException {
        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Popular")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .clickPauseButton()
                .getPlayButtonAttribute();

        Assert.assertEquals(actualAttribute, "/images/icons.svg#play");
    }

    @Test(retryAnalyzer = Retry.class)
    public void testSkipToNextSong() throws InterruptedException {
        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .clickForwardButton()
                .getNextTrackAttribute();

        Assert.assertTrue(actualAttribute.contains("item item--audio active"));
    }

    @Test(retryAnalyzer = Retry.class)
    public void testSkipToPreviousSong() throws InterruptedException {
        final String actualAttribute = openBaseURL()
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

    @Test(retryAnalyzer = Retry.class)
    public void testSetTimeInPlayer() throws InterruptedException {
        final String actualTime = openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .clickToProgressbar()
                .getVolumeInProgressbarAttribute();

        Assert.assertTrue(Double.parseDouble(actualTime.substring(7, 10)) >= 49.0);
    }

    @Test(retryAnalyzer = Retry.class)
    public void testTrackResultsEqualsSearchCriteria() throws InterruptedException {
        final List<String> titleAllTracks = openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .getTitleAllTracks();
        final int actualSize = titleAllTracks.size();
        System.out.println(titleAllTracks);

        Assert.assertEquals(actualSize, 20);
        for (String searchCriteria : titleAllTracks) {
            Assert.assertEquals(searchCriteria.toLowerCase(), "ivanka");
        }
    }

    @Test(retryAnalyzer = Retry.class)
    public void testShuffleFunctionInPlayer() throws InterruptedException {
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .clickShuffleButton()
                .getShuffleButtonAttribute();

        Assert.assertTrue(actualAttribute.contains("button shuffle active"));

        musicPage
                .clickForwardButton()
                .getNextTrackAttribute();

        Assert.assertFalse(actualAttribute.contains("item item--audio active"));
    }

    @Test(retryAnalyzer = Retry.class)
    public void testAddTrackInTheFavorite() throws InterruptedException {
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualValueFirstTrack = openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickHamburgerMenu()
                .signIn()
                .clickFavoriteIcon()
                .getFirstTrackAttribute();
        final String expectedValueFirstTrackInFavorite =
                musicPage
                        .clickFavoritePlaylist()
                        .getFirstTrackAttribute();


        Assert.assertEquals(actualValueFirstTrack, expectedValueFirstTrackInFavorite);
        Assert.assertTrue(musicPage.favoriteIsDisplayed());


    }

    @Test(retryAnalyzer = Retry.class)
    public void testDeleteTrackFromFavorite() throws InterruptedException {
        MusicPage musicPage = new MusicPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickHamburgerMenu()
                .signIn();
        final String actualH2Title = musicPage
                .clickFavoritePlaylist()
                .clickFavoriteIconInPlaylist()
                .getErrorTitleInFavoritePlaylist();



        Assert.assertTrue(actualH2Title.contains("No items found"));

    }
}