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
    public void testTrackResultsEqualsSearchCriteria(){
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

    @Test(priority = 1,retryAnalyzer = Retry.class)
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

    @Test(priority = 2,retryAnalyzer = Retry.class)
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
    @Test(priority = 3,retryAnalyzer = Retry.class)
    public void testLocalization_MusicPage() throws InterruptedException {

        MusicPage musicPage =new MusicPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult();

        final String oldURL = musicPage.getCurrentURL();
        final String oldH1Text = musicPage.getTitlePlaylist();
        musicPage
                .clickHamburgerMenu()
                .signIn()
                .clickHamburgerMenu()
                .clickLanguagesTopMenu();
        sleep(1000);
        musicPage
                .clickLangDeutsch();

        String actualURL = musicPage.getCurrentURL();
        String actualH1Text =musicPage.getTitlePlaylist();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldH1Text, actualH1Text);
        Assert.assertEquals(actualURL,"https://dev.swisscows.com/de/music?query=ivanka");
        Assert.assertEquals(actualH1Text,"Meine Lieblingslieder");

    }

    @Test(priority = 4,retryAnalyzer = Retry.class)
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
    }
    @Test(retryAnalyzer = Retry.class)
    public void testScrollToNextPage() {

        final List<String> actualTracks = openBaseURL()
                .inputSearchCriteriaAndEnter("Lady gaga")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .scrollToLastTrack()
                .getTitleAllTracks();

        Assert.assertEquals(actualTracks.size(), 29);


    }
    @Test(retryAnalyzer = Retry.class)
    public void testRegionalSearch_MusicPage() {
        MusicPage musicPage =new MusicPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .waitForUrlContains("https://dev.swisscows.com/en/music?query=ivanka&region=");

        final String actualRegion = musicPage.getCurrentURL();
        final List<String> titleAllTracks = musicPage.getTitleAllTracks();

        Assert.assertEquals(actualRegion,"https://dev.swisscows.com/en/music?query=ivanka&region=de-DE");
        for (String search : titleAllTracks) {
            Assert.assertEquals(search.toLowerCase(), "ivanka");
        }


    }

}