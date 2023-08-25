package tests.header;
import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.MusicPage;
import tests.retrytest.Retry;
import utils.ProjectConstants;

import java.util.List;

public class MusicTest extends BaseTest {
    @QaseTitle("Check play video")
    @QaseId(value = 5107)
    @Test(retryAnalyzer = Retry.class)
    public void testPlayTrack(){
        MusicPage musicPage = new MusicPage(getDriver());

        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButtonOfFirstTrack()
                .waitUntilTimeOfFirstTrackToBeChanged("0:03")
                .getAttributeOfPlayButtonFirstTrack();

        final String actualDuration = musicPage.getVolumeDurationFirstTrack();


        Assert.assertTrue(musicPage.playButtonsAreDisplayed());
        Assert.assertEquals(actualAttribute, "/images/icons.svg#pause");
        Assert.assertTrue(Double.parseDouble(actualDuration.substring(3, 4)) > 0);

    }
    @QaseTitle("Check pause video")
    @QaseId(value = 5108)
    @Test(retryAnalyzer = Retry.class)
    public void testClickPauseOfTrack(){
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButtonOfFirstTrack()
                .waitUntilTimeOfFirstTrackToBeChanged("0:03")
                .clickPauseButton()
                .getAttributeOfPlayButtonFirstTrack();

        final String actualDuration = musicPage.getVolumeDurationFirstTrack();

        Assert.assertEquals(actualAttribute, "/images/icons.svg#play");
        Assert.assertEquals(actualDuration,"0:03");
    }
    @QaseTitle("Check next button of track")
    @QaseId(value = 5109)
    @Test(retryAnalyzer = Retry.class)
    public void testSwitchToNextTrack() {
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButtonOfFirstTrack()
                .waitUntilTimeOfFirstTrackToBeChanged("0:03")
                .clickNextButton()
                .waitUntilTimeOfSecondTrackToBeChanged("0:03")
                .getAttributeOfNextTrack();

        final String actualDuration = musicPage.getVolumeDurationSecondTrack();

        Assert.assertNotEquals(actualAttribute, musicPage.getAttributeOfPreviousTrack());
        Assert.assertTrue(actualAttribute.contains("item item--audio active"));
        Assert.assertTrue(Double.parseDouble(actualDuration.substring(3, 4)) > 0);
    }
    @QaseTitle("Check previous button of track")
    @QaseId(value = 5110)
    @Test(retryAnalyzer = Retry.class)
        public void testSwitchToPreviousTrack(){
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualAttributeNextTrack = openBaseURL()
                .inputSearchCriteriaAndEnter("Skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButtonOfFirstTrack()
                .waitUntilTimeOfFirstTrackToBeChanged("0:01")
                .clickNextButton()
                .waitUntilTimeOfSecondTrackToBeChanged("0:01")
                .getAttributeOfNextTrack();

        final String actualAttributePrevTrack = musicPage
                .clickPreviousButton()
                .waitUntilTimeOfFirstTrackToBeChanged("0:01")
                .getAttributeOfPreviousTrack();


        Assert.assertEquals(actualAttributeNextTrack, actualAttributePrevTrack);
        Assert.assertNotEquals(actualAttributePrevTrack,musicPage.getAttributeOfNextTrack());
        Assert.assertTrue(actualAttributePrevTrack.contains("item item--audio active"));
    }
    @QaseTitle("Check set time in player")
    @QaseId(value = 5111)
    @Test(retryAnalyzer = Retry.class)
    public void testSetTimeInPlayer(){
        final String actualTime = openBaseURL()
                .inputSearchCriteriaAndEnter("skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButtonOfFirstTrack()
                .waitUntilTimeOfFirstTrackToBeChanged("0:01")
                .setTimeOfProgressbar()
                .waitForProgressBarToBeChanged()
                .getAttributeStyleInProgressbar();

        Assert.assertTrue(Double.parseDouble(actualTime.substring(7, 9)) >= 35.0);
    }
    @QaseTitle("Check that music results equals search criteria ")
    @QaseId(value = 5112)
    @Test(retryAnalyzer = Retry.class)
    public void testMusicResultsEqualsSearchCriteria(){
        MusicPage musicPage = new MusicPage(getDriver());
        String query = "popular";

        final List<String> titleAllTracks = openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .getTitleAllTracks();

        final int actualSize = titleAllTracks.size();

        final List<String> titleAllPlaylist = musicPage.getTitleAllPlaylist();

        Assert.assertEquals(actualSize, 20);
        for (String searchCriteria : titleAllTracks) {
            Assert.assertTrue(searchCriteria.toLowerCase().contains(query));
        }
        Assert.assertEquals(musicPage.getTitleAllPlaylist().size(), 3);
        for (String search : titleAllPlaylist) {
            Assert.assertTrue(search.toLowerCase().contains(query));
        }
    }
    @QaseTitle("Check shuffle function in the player")
    @QaseId(value = 5113)
    @Test(retryAnalyzer = Retry.class)
    public void testShuffleFunctionInPlayer() {
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualAttribute = openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .clickPlayButtonOfFirstTrack()
                .waitUntilTimeOfFirstTrackToBeChanged("0:02")
                .clickShuffleButton()
                .getAttributeShuffleButton();

        Assert.assertTrue(actualAttribute.contains("button shuffle active"));

        musicPage
                .clickNextButton()
                .getAttributeOfNextTrack();

        Assert.assertFalse(actualAttribute.contains("item item--audio active"));
    }
    @QaseTitle("Check add track in the favorite")
    @QaseId(value = 5114)
    @Test(priority = 1,retryAnalyzer = Retry.class)
    public void testAddTrackInTheFavorite() {
        MusicPage musicPage = new MusicPage(getDriver());
        final String actualValueFirstTrack = openBaseURLAndGetCookie()
                .inputSearchCriteriaAndEnter("lady gaga")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .loginUsingCookie()
                .clickFavoriteIcon()
                .getAttributeSrcOfFirstTrack();

        final String expectedValueFirstTrackInFavorite = musicPage
                        .clickFavoritePlaylist()
                        .getAttributeSrcOfFirstTrack();

        Assert.assertEquals(actualValueFirstTrack, expectedValueFirstTrackInFavorite);
        Assert.assertTrue(musicPage.favoritePlaylistIsDisplayed());


    }
    @QaseTitle("Check play track in the favorite")
    @QaseId(value = 5115)
    @Test(priority = 2,retryAnalyzer = Retry.class)
    public void tesPlayTrackInTheFavorite(){
        MusicPage musicPage = new MusicPage(getDriver());

        final String actualAttribute =  openBaseURLAndGetCookie()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .loginUsingCookie()
                .clickFavoritePlaylist()
                .clickPlayButtonOfFirstTrack()
                .waitUntilTimeOfFirstTrackToBeChanged("0:02")
                .getAttributeOfPreviousTrack();

        final String actualDuration = musicPage.getVolumeDurationFirstTrack();

        Assert.assertTrue(musicPage.playButtonsAreDisplayed());
        Assert.assertTrue(actualAttribute.contains("item item--audio active"));
        Assert.assertTrue(Double.parseDouble(actualDuration.substring(3, 4)) > 0);

    }
    @QaseTitle("Check localization")
    @QaseId(value = 5116)
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
        Assert.assertEquals(actualTitle,"Musik zu ivanka - Swisscows");

    }
    @QaseTitle("Check delete track in the favorite")
    @QaseId(value = 5117)
    @Test(priority = 3,retryAnalyzer = Retry.class)
    public void testDeleteTrackFromFavorite(){
        MusicPage musicPage = new MusicPage(getDriver());
        final String oldUrl = openBaseURLAndGetCookie()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .loginUsingCookie()
                .getCurrentURL();

        final String actualH2Title = musicPage
                .clickFavoritePlaylist()
                .clickFavoriteIconInPlaylist()
                .getErrorOfTitleInFavorite();

        final String newUrl = musicPage.getCurrentURL();

        Assert.assertNotEquals(newUrl, oldUrl);
        Assert.assertTrue(actualH2Title.contains("No items found"));
        Assert.assertEquals(musicPage.getFontSizeErrorTitleInFavoritePlaylist(),"40px");
    }
    @QaseTitle("Check add after delete several tracks from favorite")
    @QaseId(value = 5118)
    @Test(retryAnalyzer = Retry.class)
    public void testAddAfterDeleteSeveralTracksFromFavorite() {
        MusicPage musicPage = new MusicPage(getDriver());
        final List<String> actualTracks = openBaseURLAndGetCookie()
                .inputSearchCriteriaAndEnter("skofka")
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilUrlToBeChanged("/en/music?query=skofka")
                .waitLoaderToBeInvisible()
                .waitUntilVisibilityAudioResult()
                .loginUsingCookie()
                .waitUntilUrlToBeChanged("/en/music?query=skofka")
                .waitLoaderToBeInvisible()
                .waitUntilVisibilityAudioResult()
                .clickOnAllHeart()
                .scrollToHeaderMenu()
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
    @QaseTitle("Check that suggest equals search criteria")
    @QaseId(value = 5119)
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
    @QaseTitle("Check scroll to next page")
    @QaseId(value = 5120)
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
    @QaseTitle("Check regional search")
    @QaseId(value = 5121)
    @Test(retryAnalyzer = Retry.class)
    public void testRegionalSearch_MusicPage() {
        MusicPage musicPage = new MusicPage(getDriver());
        String query = "popular";
        openBaseURL()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult()
                .selectDeutschRegion()
                .waitForUrlContains(ProjectConstants.DOMAIN + "/en/music?query=" + query + "&region=");

        final String actualRegion = musicPage.getCurrentURL();
        final List<String> titleAllTracks = musicPage.getTitleAllTracks();

        Assert.assertEquals(actualRegion,ProjectConstants.DOMAIN + "/en/music?query=" + query + "&region=de-DE");
        for (String search : titleAllTracks) {
            Assert.assertTrue(search.toLowerCase().contains(query));
        }
    }

}