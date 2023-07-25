package pages.top_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.TopMenuPage;
import utils.ProjectConstants;

import java.util.List;

import static java.lang.Thread.sleep;

public class MusicPage extends TopMenuPage<MusicPage> {
    @FindBy(xpath = "//div[@class='music-results']//article")
    private WebElement audioResultContainer;
    @FindBy(xpath = "//button[@class='button play-pause'][1]")
    private WebElement firstPlayButton;
    @FindBy(xpath = "//button[@title='Next track']")
    private WebElement skipButton;
    @FindBy(xpath = "//button[@title='Previous track']")
    private WebElement previousButton;
    @FindBy(xpath = "//section//*[name()='button']//*[name()='use'][1]")
    private WebElement attributeOfPlayButtonFirstTrack;
    @FindBy(xpath = "//article[2]")
    private WebElement nextTrackAttributes;
    @FindBy(xpath = "//article[20]")
    private WebElement last20Track;
    @FindBy(xpath = "//article[29]")
    private WebElement last29Track;
    @FindBy(xpath = "//article[1]/div[1]/div/span[1]")
    private WebElement durationAttributeOfFirstTrack;
    @FindBy(xpath = "//div//article[2]//div//span[1]")
    private WebElement durationAttributeOfSecondTrack;
    @FindBy(xpath = "//article[1]")
    private WebElement previousTrackAttribute;
    @FindBy(xpath = "//article[1]//div[@class = 'timeline']//div[@class = 'progress-bar']//div")
    private WebElement progressbar;
    @FindBy(xpath = "//button[@class = 'button shuffle']")
    private WebElement shuffleButton;
    @FindBy(xpath = "//div[@class = 'buttons']//button[1]")
    private WebElement shuffleButtonAttribute;
    @FindBy(xpath = "//button[@class = 'button favorite']")
    private WebElement favoriteButton;
    @FindBy(xpath = "//div[@class = 'progress-bar']//div[@style]")
    private WebElement progressbarFirsTrack;
    @FindBy(xpath = "//article[@class = 'item item--audio']//h2")
    private List<WebElement> allTracks;
    @FindBy(xpath = "//button[@title='Play/Pause']")
    private List<WebElement> allPlayButton;
    @FindBy(xpath = "//h2[text() ='My favorite tracks']")
    private WebElement favoriteContainer;
    @FindBy(xpath = "//article[@class='item item--audio']//img[1]")
    private WebElement valueFirstImage;
    @FindBy(xpath = "//div[@class='error']//h2[@class]")
    private WebElement h2TitleErrorInFavorite;
    @FindBy(xpath = "//button[@class='button favorite active']")
    private WebElement favoriteIconInPlaylist;
    @FindBy(xpath = "//button[@class='button favorite active']")
    private List<WebElement> allActiveHeartButtons;
    @FindBy(xpath = "//div[@class='music-results']//a//h2")
    private List<WebElement> titleAllPlaylist;



    public MusicPage(WebDriver driver) {
        super(driver);
    }

    public MusicPage createGeneric() {

        return new MusicPage(getDriver());
    }
    @Step("Wait until to be visible audio result")
    public MusicPage waitUntilVisibilityAudioResult() {
        getWait10().until(driver -> {
            try {
                wait10ElementToBeVisible(audioResultContainer);
                return audioResultContainer.isDisplayed();
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });
        return new MusicPage(getDriver());
    }
    @Step("Click play button of first track")
    public MusicPage clickPlayButtonOfFirstTrack(){
        click(firstPlayButton);
        return new MusicPage(getDriver());
    }
    @Step("Wait until time of first track to be changed")
    public MusicPage waitUntilTimeOfFirstTrackToBeChanged(String expectedTime){
        getWait10().until(ExpectedConditions.textToBePresentInElement(durationAttributeOfFirstTrack, expectedTime));
        return new MusicPage(getDriver());
    }
    @Step("Wait until time of second track to be changed")
    public MusicPage waitUntilTimeOfSecondTrackToBeChanged(String expectedTime){
        getWait10().until(ExpectedConditions.textToBePresentInElement(durationAttributeOfSecondTrack, expectedTime));
        return new MusicPage(getDriver());
    }
    @Step("Click pause button ")
    public MusicPage clickPauseButton() {
        click(firstPlayButton);
        return new MusicPage(getDriver());
    }
    public MusicPage loginUsingCookie(){
        clickHamburgerMenu();
        clickSignInMenu();
        return new MusicPage(getDriver());
    }
   @Step("Click shuffle function of track")
   public MusicPage clickShuffleButton() {
        click(shuffleButton);
        return new MusicPage(getDriver());
    }
    @Step("Click next button")
    public MusicPage clickNextButton() {
        click(skipButton);
        return new MusicPage(getDriver());
    }
    @Step("Click prev button")
    public MusicPage clickPreviousButton() {
        click(previousButton);
        return new MusicPage(getDriver());
    }
    @Step("Click on all active heart icons")
    public MusicPage clickOnAllActiveHeart() {
        clickAllElementsInList(allActiveHeartButtons);
        return new MusicPage(getDriver());
    }
    @Step("Get title of all tracks in the music search result")
    public List <String> getTitleAllTracks()  {
        for (WebElement element : allTracks){
            try {
                wait10ElementToBeVisible(element);
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException occurred: " + e.getMessage());
            }
        }
        return getTexts(allTracks);
    }
    public MusicPage waitLoaderToBeInvisible(){
        waitForLoaderToBeInVisible();
        return new MusicPage(getDriver());
    }
    public MusicPage waitUntilUrlToBeChanged(String parametr){
        waitUrlToBeChanged(parametr);
        return new MusicPage(getDriver());
    }

    @Step("Move slider in timeline")
    public MusicPage setTimeOfProgressbar() {
        int progressBarWidth = progressbar.getSize().getWidth();
        int progressBarX = progressbar.getLocation().getX();
        int desiredPosition = progressBarX + (int) (progressBarWidth * 50.0);

        getActions().moveToElement(progressbar, desiredPosition, 0).clickAndHold()
                .moveByOffset(-progressBarWidth, 0).release().build().perform();

        return new MusicPage(getDriver());
    }
    @Step("Wait until progressbar to be changed")
    public MusicPage waitForProgressBarToBeChanged() {
        getWait10().until(ExpectedConditions.attributeToBeNotEmpty(progressbar, "style"));
        return new MusicPage(getDriver());
    }
    @Step("Scroll to last track")
    public MusicPage scrollToLastTrack(){
        scrollByVisibleElement(last20Track);
        wait10ElementToBeVisible(last29Track);
        scrollByVisibleElement(last29Track);
        return new MusicPage(getDriver());
    }
    @Step("Click favorite playlist")
    public MusicPage clickFavoritePlaylist() {
        click20(favoriteContainer);
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/music/my?query=");
        return new MusicPage(getDriver());
    }
    @Step("Click favorite icon in playlist")
    public MusicPage clickFavoriteIconInPlaylist() {
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/music/my?query=");
        click(favoriteIconInPlaylist);
        return new MusicPage(getDriver());
    }
    public MusicPage selectDeutschRegion(){
        selectGermanyRegion();
        return new MusicPage(getDriver());
    }
    @Step("Get attribute of play button first track")
    public String getAttributeOfPlayButtonFirstTrack() {
        return getAttribute(attributeOfPlayButtonFirstTrack, "xlink:href");
    }
    @Step("Get attribute of shuffle button")
    public String getAttributeShuffleButton() {
        return getAttribute(shuffleButtonAttribute, "class");
    }
    public String getFavoriteAttribute() {

        return getAttribute(favoriteButton, "class");
    }
    @Step("Get attribute class Of next track")
    public String getAttributeOfNextTrack() {
        return getAttribute(nextTrackAttributes, "class");
    }
    @Step("Get attribute class of previous track")
    public String getAttributeOfPreviousTrack() {
        return getAttribute(previousTrackAttribute, "class");
    }
    @Step("Get volume attribute in progressbar")
    public String getAttributeStyleInProgressbar()  {
        return getAttribute(progressbarFirsTrack, "style");
    }
    @Step("Get attribute src of first track")
    public String getAttributeSrcOfFirstTrack() {
        wait10ElementToBeVisible(valueFirstImage);
        return getAttribute( valueFirstImage, "src");
    }
    @Step("Get text volume duration of first track")
    public String getVolumeDurationFirstTrack()  {
        return getText(durationAttributeOfFirstTrack);
    }
    @Step("Get text volume duration of second track")
    public String getVolumeDurationSecondTrack()  {

        return getText(durationAttributeOfSecondTrack);
    }

    public String getFontSizeErrorTitleInFavoritePlaylist()  {

        return getFontSize(h2TitleErrorInFavorite);
    }
    @Step("Check that favorite playlist is dysplaed")
    public boolean favoritePlaylistIsDisplayed() {
        return isElementDisplayed(favoriteContainer);

    }
    @Step("Get title of playlist in music search results")
    public List<String> getTitleAllPlaylist() {
        return getTexts(titleAllPlaylist);

    }
    @Step("Check that play buttons are dysplaed")
    public boolean playButtonsAreDisplayed() {
        return areElementsInListDisplayed(allPlayButton);

    }



}