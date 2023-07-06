package tests.header;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.MusicPage;
import tests.retrytest.Retry;
import utils.ProjectConstants;

import java.util.List;

public class MusicTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void testPlayTrack(){
        MusicPage musicPage = new MusicPage(getDriver());

        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .waitUntilTimeOfFirstTrackToBeChanged("0:03")
                .getPlayButtonAttribute();

        final String actualDuration = musicPage.getVolumeDurationFirstTrack();


        Assert.assertTrue(musicPage.playButtonsIsDisplayed());
        Assert.assertEquals(actualAttribute, "/images/icons.svg#pause");
        Assert.assertTrue(Double.parseDouble(actualDuration.substring(3, 4)) > 0);

    }

    @Test(retryAnalyzer = Retry.class)
    public void testClickPauseOfTrack(){
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .waitUntilTimeOfFirstTrackToBeChanged("0:03")
                .clickPauseButton()
                .getPlayButtonAttribute();

        final String actualDuration = musicPage.getVolumeDurationFirstTrack();

        Assert.assertEquals(actualAttribute, "/images/icons.svg#play");
        Assert.assertEquals(actualDuration,"0:03");
    }

    @Test(retryAnalyzer = Retry.class)
    public void testSwitchToNextTrack() {
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .waitUntilTimeOfFirstTrackToBeChanged("0:03")
                .clickNextButton()
                .waitUntilTimeOfSecondTrackToBeChanged("0:03")
                .getNextTrackAttribute();

        final String actualDuration = musicPage.getVolumeDurationSecondTrack();

        Assert.assertNotEquals(actualAttribute, musicPage.getPreviousTrackAttribute());
        Assert.assertTrue(actualAttribute.contains("item item--audio active"));
        Assert.assertTrue(Double.parseDouble(actualDuration.substring(3, 4)) > 0);
    }

    @Test(retryAnalyzer = Retry.class)
        public void testSwitchToPreviousTrack(){
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualAttributeNextTrack = openBaseURL()
                .inputSearchCriteriaAndEnter("Skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .waitUntilTimeOfFirstTrackToBeChanged("0:01")
                .clickNextButton()
                .waitUntilTimeOfSecondTrackToBeChanged("0:01")
                .getNextTrackAttribute();

        final String actualAttributePrevTrack = musicPage
                .clickPreviousButton()
                .waitUntilTimeOfFirstTrackToBeChanged("0:01")
                .getPreviousTrackAttribute();


        Assert.assertEquals(actualAttributeNextTrack, actualAttributePrevTrack);
        Assert.assertNotEquals(actualAttributePrevTrack,musicPage.getNextTrackAttribute());
        Assert.assertTrue(actualAttributePrevTrack.contains("item item--audio active"));
    }

    @Test(retryAnalyzer = Retry.class)
    public void testSetTimeInPlayer(){
        final String actualTime = openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .waitUntilTimeOfFirstTrackToBeChanged("0:01")
                .setTimeOfProgressbar()
                .getVolumeInProgressbarAttribute();

        Assert.assertTrue(Double.parseDouble(actualTime.substring(7, 10)) >= 49.0);
    }

    @Test(retryAnalyzer = Retry.class)
    public void testTrackResultsEqualsSearchCriteria(){
        MusicPage musicPage = new MusicPage(getDriver());
        final List<String> titleAllTracks = openBaseURL()
                .inputSearchCriteriaAndEnter("best")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .getTitleAllTracks();
        final int actualSize = titleAllTracks.size();


        final List<String> titleAllPlaylist = musicPage.getTitleAllPlaylist();

        Assert.assertEquals(actualSize, 20);
        for (String searchCriteria : titleAllTracks) {
            Assert.assertTrue(searchCriteria.toLowerCase().contains("best"));
        }
        Assert.assertEquals(musicPage.getTitleAllPlaylist().size(), 3);
        for (String search : titleAllPlaylist) {
            Assert.assertTrue(search.toLowerCase().contains("best"));
        }
    }

    @Test(retryAnalyzer = Retry.class)
    public void testShuffleFunctionInPlayer() {
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButton()
                .waitUntilTimeOfFirstTrackToBeChanged("0:02")
                .clickShuffleButton()
                .getShuffleButtonAttribute();

        Assert.assertTrue(actualAttribute.contains("button shuffle active"));

        musicPage
                .clickNextButton()
                .getNextTrackAttribute();

        Assert.assertFalse(actualAttribute.contains("item item--audio active"));
    }

    @Test(priority = 1,retryAnalyzer = Retry.class)
    public void testAddTrackInTheFavorite() {
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

        final String expectedValueFirstTrackInFavorite = musicPage
                        .clickFavoritePlaylist()
                        .getFirstTrackAttribute();

        Assert.assertEquals(actualValueFirstTrack, expectedValueFirstTrackInFavorite);
        Assert.assertTrue(musicPage.favoriteIsDisplayed());


    }

    @Test(priority = 2,retryAnalyzer = Retry.class)
    public void tesPlayTrackInTheFavorite(){
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
                .waitUntilTimeOfFirstTrackToBeChanged("0:02")
                .getPreviousTrackAttribute();

        final String actualDuration = musicPage.getVolumeDurationFirstTrack();

        Assert.assertTrue(musicPage.playButtonsIsDisplayed());
        Assert.assertTrue(actualAttribute.contains("item item--audio active"));
        Assert.assertTrue(Double.parseDouble(actualDuration.substring(3, 4)) > 0);

    }
    @Test(retryAnalyzer = Retry.class)
    public void testLocalization_MusicPage() {

        MusicPage musicPage =new MusicPage(getDriver());
        final String oldURL = openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .getCurrentURL();

        final String oldTitle = musicPage.getTitle();

        final String actualURL = musicPage
                .selectDeutschLocalisation()
                .waitUntilVisibilityAudioResult()
                .getCurrentURL();

        final String actualTitle = musicPage.getTitle();;


        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTitle, actualTitle);
        Assert.assertEquals(actualURL, ProjectConstants.DOMAIN + "/de/music?query=ivanka");
        Assert.assertEquals(actualTitle,"ivanka in Musik suchen - Swisscows");

    }

    @Test(priority = 3,retryAnalyzer = Retry.class)
    public void testDeleteTrackFromFavorite(){
        MusicPage musicPage = new MusicPage(getDriver());
        final String oldUrl = openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickHamburgerMenu()
                .signIn()
                .getCurrentURL();

        final String actualH2Title = musicPage
                .clickFavoritePlaylist()
                .clickFavoriteIconInPlaylist()
                .getErrorTitleInFavoritePlaylist();

        final String newUrl = musicPage.getCurrentURL();

        Assert.assertNotEquals(newUrl, oldUrl);
        Assert.assertTrue(actualH2Title.contains("No items found"));
        Assert.assertEquals(musicPage.getFontSizeErrorTitleInFavoritePlaylist(),"40px");
    }

    @Test(retryAnalyzer = Retry.class)
    public void testAddAfterDeleteSeveralTracksFromFavorite() {
        MusicPage musicPage = new MusicPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilUrlToBeChanged("/en/music?query=skofka")
                .waitLoaderToBeInvisible()
                .waitUntilVisibilityAudioResult()
                .clickHamburgerMenu()
                .signIn();
        final List<String> actualTracks = musicPage
                .waitUntilUrlToBeChanged("/en/music?query=skofka")
                .waitLoaderToBeInvisible()
                .waitUntilVisibilityAudioResult()
                .clickOnAllHeart()
                .clickFavoritePlaylist()
                .getTitleAllTracks();

        Assert.assertEquals(actualTracks.size(), 20);
        musicPage
                .clickOnAllActiveHeart()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult();

        Assert.assertEquals(musicPage.getTitleAllPlaylist().size(), 3);
        Assert.assertEquals(musicPage.getFavoriteAttribute(), "button favorite");

    }

    @Test(retryAnalyzer = Retry.class)
    public void testSuggestEqualsSearchCriteria() {
        MainPage mainPage = new MainPage(getDriver());

        final List<String> actualSuggestion = openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .clickSearchFieldHeader()
                .waitForSuggestToBeVisible()
                .getAllElementsText();

        final int actualSizeSuggest = mainPage.countElementsInSuggestContainer();

        Assert.assertEquals(mainPage.getAllElementsText().size(), 5);

        for (String searchCriteria : actualSuggestion) {
            Assert.assertTrue(mainPage.suggestIsDisplayed());
            Assert.assertTrue(actualSizeSuggest > 0);
            Assert.assertTrue(searchCriteria.contains("ivanka"));
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

        Assert.assertTrue(actualTracks.size()>= 29);
    }
    @Test
    public void testRegionalSearch_MusicPage() {
        MusicPage musicPage =new MusicPage(getDriver());
        openBaseURL()
                .inputSearchCriteriaAndEnter("best")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .selectDeutschRegion()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/music?query=best&region=");

        final String actualRegion = musicPage.getCurrentURL();
        final List<String> titleAllTracks = musicPage.getTitleAllTracks();

        Assert.assertEquals(actualRegion,ProjectConstants.DOMAIN + "/en/music?query=best&region=de-DE");
        for (String search : titleAllTracks) {
            Assert.assertTrue(search.toLowerCase().contains("best"));
        }
    }

}