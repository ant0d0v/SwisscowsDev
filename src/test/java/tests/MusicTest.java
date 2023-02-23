package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
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

        Assert.assertTrue(musicPage.playButtonsIsDisplayed());
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
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .clickForwardButton()
                .getNextTrackAttribute();


        Assert.assertNotEquals(actualAttribute, musicPage.getPreviousTrackAttribute());
        Assert.assertNotEquals(actualAttribute,musicPage.getPreviousTrackAttribute());
        Assert.assertTrue(actualAttribute.contains("item item--audio active"));
    }

    @Test(retryAnalyzer = Retry.class)
    public void testSkipToPreviousSong() throws InterruptedException {
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .clickForwardButton()
                .clickBackButton()
                .getPreviousTrackAttribute();


        Assert.assertNotEquals(actualAttribute, musicPage.getNextTrackAttribute());
        Assert.assertNotEquals(actualAttribute,musicPage.getNextTrackAttribute());
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
        MusicPage musicPage = new MusicPage(getDriver());
        final List<String> titleAllTracks = openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .getTitleAllTracks();
        final int actualSize = titleAllTracks.size();


        final List<String> titleAllPlaylist = musicPage.getTitleAllPlaylist();

        Assert.assertEquals(actualSize, 20);
        for (String searchCriteria : titleAllTracks) {
            Assert.assertEquals(searchCriteria.toLowerCase(), "ivanka");
        }
        Assert.assertEquals(musicPage.getTitleAllPlaylist().size(), 3);
        for (String search : titleAllPlaylist) {
            Assert.assertEquals(search.toLowerCase(), "ivanka");
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
    public void tesPlayTrackInTheFavorite() throws InterruptedException {
        MusicPage musicPage = new MusicPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickHamburgerMenu()
                .signIn();

        final String actualAttribute = musicPage
                .clickFavoritePlaylist()
                .clickPlayButton()
                .getPreviousTrackAttribute();

        final String actualDuration = musicPage.getVolumeDuration();

        Assert.assertTrue(musicPage.playButtonsIsDisplayed());
        Assert.assertTrue(actualAttribute.contains("item item--audio active"));
        Assert.assertTrue(Double.parseDouble(actualDuration.substring(3, 4)) > 0);

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

        final String oldUrl = musicPage.getCurrentURL();

        final String actualH2Title = musicPage
                .clickFavoritePlaylist()
                .clickFavoriteIconInPlaylist()
                .getErrorTitleInFavoritePlaylist();

        final String newUrl = musicPage.getCurrentURL();

        Assert.assertNotEquals(newUrl, oldUrl);
        Assert.assertTrue(actualH2Title.contains("No items found"));
    }

    @Test(retryAnalyzer = Retry.class)
    public void testAddAfterDeleteSeveralTracksFromFavorite() {
        MusicPage musicPage = new MusicPage(getDriver());
        final List<String> actualTracks = openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickHamburgerMenu()
                .signIn()
                .clickOnAllHeart()
                .clickFavoritePlaylist()
                .getTitleAllTracks();

        Assert.assertEquals(actualTracks.size(), 20);
        musicPage
                .clickOnAllActiveHeart()
                .clickSearchButton();

        Assert.assertEquals(musicPage.getTitleAllPlaylist().size(), 3);
        Assert.assertEquals(musicPage.getFavoriteAttribute(), "button favorite");

    }

    @Test(retryAnalyzer = Retry.class)
    public void testSuggestEqualsSearchCriteria() {
        final String query = "ivanka";

        MainPage mainPage = openBaseURL();
        openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
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

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertTrue(actualH2Title.contains("No items found"));

    }

}