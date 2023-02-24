package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.TopMenuPage;

import java.util.List;

import static java.lang.Thread.sleep;

public class MusicPage extends TopMenuPage<MusicPage> {
    @FindBy(xpath = "//div[@class='audio-results']//article")
    private WebElement audioResultContainer;
    @FindBy(xpath = "//button[@class='button play-pause'][1]")
    private WebElement firstPlayButton;
    @FindBy(xpath = "//button[@title='Next track']")
    private WebElement skipButton;
    @FindBy(xpath = "//button[@title='Previous track']")
    private WebElement previousButton;
    @FindBy(xpath = "//section//*[name()='button']//*[name()='use'][1]")
    private WebElement playButtonAttribute;
    @FindBy(xpath = "//article[2]")
    private WebElement nextTrackAttributes;
    @FindBy(xpath = "//article[20]")
    private WebElement lastTrack;
    @FindBy(xpath = "//article[29]")
    private WebElement lastTrackDouble;
    @FindBy(xpath = "//article[1]/div[1]/span[1]")
    private WebElement durationAttribute;

    @FindBy(xpath = "//article[1]")
    private WebElement previousTrackAttribute;
    @FindBy(xpath = "//div[@class = 'timeline']")
    private WebElement progressbar;
    @FindBy(xpath = "//button[@class = 'button shuffle']")
    private WebElement shuffleButton;
    @FindBy(xpath = "//div[@class = 'buttons']//button[1]")
    private WebElement shuffleButtonAttribute;
    @FindBy(xpath = "//button[@class = 'button favorite']")
    private WebElement favoriteButton;
    @FindBy(xpath = "//div[@class = 'progress-bar']//div[@style]")
    private WebElement progressbarFirsTrack;
    @FindBy(xpath = "//div[@class = 'tracks']//h2")
    private List<WebElement> allTracks;
    @FindBy(xpath = "//button[@title='Play/Pause']")
    private List<WebElement> allPlayButton;
    @FindBy(xpath = "//button[@class='button favorite']")
    private List<WebElement> allHeartButtons;
    @FindBy(xpath = "//h2[text() ='My favorite tracks']")
    private WebElement favoriteContainer;
    @FindBy(xpath = "//article[@class='item item--audio']//img[1]")
    private WebElement valueFirstImage;
    @FindBy(xpath = "//div[@class='error']//h2[@class]")
    private WebElement h2TitleErrorInFavorite;
    @FindBy(xpath = "//div[@class='row row-page-results']//a//h2[1]")
    private WebElement h2TitleInFavorite;
    @FindBy(xpath = "//button[@class='button favorite active']")
    private WebElement favoriteIconInPlaylist;
    @FindBy(xpath = "//button[@class='button favorite active']")
    private List<WebElement> allActiveHeartButtons;
    @FindBy(xpath = "//div[@class='playlists']/a/h2")
    private List<WebElement> titleAllPlaylist;


    public MusicPage(WebDriver driver) {
        super(driver);
    }

    public MusicPage createGeneric() {

        return new MusicPage(getDriver());
    }
    public MusicPage waitUntilVisibilityAudioResult() {
        wait20ElementToBeVisible(audioResultContainer);

        return new MusicPage(getDriver());
    }

    public MusicPage clickPlayButton() throws InterruptedException {
        click(firstPlayButton);
        sleep(4000);

        return new MusicPage(getDriver());
    }
    public MusicPage clickPauseButton() {
        click(firstPlayButton);
        return new MusicPage(getDriver());
    }


    public MusicPage clickShuffleButton() {
        click(shuffleButton);
        return new MusicPage(getDriver());
    }
    public MusicPage clickForwardButton() {
        click(skipButton);
        return new MusicPage(getDriver());
    }
    public MusicPage clickBackButton() {
        click(previousButton);
        return new MusicPage(getDriver());
    }
    public MusicPage clickOnAllActiveHeart() {
        clickAllElementsInList(allActiveHeartButtons);
        return new MusicPage(getDriver());
    }

    public List <String> getTitleAllTracks()  {
        return getTexts(allTracks);
    }

    public MusicPage clickToProgressbar() {
        click(progressbar);
        return new MusicPage(getDriver());
    }
    public MusicPage scrollToLastTrack() {
        scrollByVisibleElement(lastTrack);
        return new MusicPage(getDriver());
    }
    public MusicPage clickFavoritePlaylist() {
        click(favoriteContainer);
        waitForUrlContains("https://dev.swisscows.com/en/music/my?query=");
        return new MusicPage(getDriver());
    }
    public MusicPage clickFavoriteIconInPlaylist() {
        waitForUrlContains("https://dev.swisscows.com/en/music/my?query=");
        click(favoriteIconInPlaylist);
        return new MusicPage(getDriver());
    }

    public String getPlayButtonAttribute() {

        return getAttribute(playButtonAttribute, "xlink:href");
    }
    public String getShuffleButtonAttribute() {

        return getAttribute(shuffleButtonAttribute, "class");
    }
    public String getFavoriteAttribute() {

        return getAttribute(favoriteButton, "class");
    }
    public String getNextTrackAttribute() {

        return getAttribute(nextTrackAttributes, "class");
    }
    public String getPreviousTrackAttribute() {

        return getAttribute(previousTrackAttribute, "class");
    }
    public String getVolumeInProgressbarAttribute()  {

        return getAttribute(progressbarFirsTrack, "style");
    }
    public String getFirstTrackAttribute() throws InterruptedException {
        return getAttribute( valueFirstImage, "src");
    }
    public String getVolumeDuration()  {

        return getText(durationAttribute);
    }
    public String getErrorTitleInFavoritePlaylist()  {

        return getText(h2TitleErrorInFavorite);
    }
    public String getTitlePlaylist()  {
        waitForUrlContains("https://dev.swisscows.com/");
        return getText(h2TitleInFavorite);
    }
    public boolean favoriteIsDisplayed() {
        return isElementDisplayed(favoriteContainer);

    }
    public List<String> getTitleAllPlaylist() {
        return getTexts(titleAllPlaylist);

    }
    public boolean playButtonsIsDisplayed() {
        return areElementsInListDisplayed(allPlayButton);

    }



}