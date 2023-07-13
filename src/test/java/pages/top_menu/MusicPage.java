package pages.top_menu;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.TopMenuPage;
import utils.ProjectConstants;

import java.util.ArrayList;
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
    private WebElement last20Track;
    @FindBy(xpath = "//article[29]")
    private WebElement last29Track;
    @FindBy(xpath = "//article[1]/div[1]/span[1]")
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
    @FindBy(xpath = "//div[@class = 'tracks']//h2")
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
    @FindBy(xpath = "//div[@class='playlists']/a/h2")
    private List<WebElement> titleAllPlaylist;



    public MusicPage(WebDriver driver) {
        super(driver);
    }

    public MusicPage createGeneric() {

        return new MusicPage(getDriver());
    }
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

    public MusicPage clickPlayButton(){
        click(firstPlayButton);
        return new MusicPage(getDriver());
    }
    public MusicPage waitUntilTimeOfFirstTrackToBeChanged(String expectedTime){
        getWait10().until(ExpectedConditions.textToBePresentInElement(durationAttributeOfFirstTrack, expectedTime));
        return new MusicPage(getDriver());
    }
    public MusicPage waitUntilTimeOfSecondTrackToBeChanged(String expectedTime){
        getWait10().until(ExpectedConditions.textToBePresentInElement(durationAttributeOfSecondTrack, expectedTime));
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
    public MusicPage clickNextButton() {
        click(skipButton);
        return new MusicPage(getDriver());
    }
    public MusicPage clickPreviousButton() {
        click(previousButton);
        return new MusicPage(getDriver());
    }
    public MusicPage clickOnAllActiveHeart() {
        clickAllElementsInList(allActiveHeartButtons);
        return new MusicPage(getDriver());
    }

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


    public MusicPage setTimeOfProgressbar() {
        int progressBarWidth = progressbar.getSize().getWidth();
        int progressBarX = progressbar.getLocation().getX();

        int middlePosition = progressBarX + (progressBarWidth / 2);
        getActions().moveToElement(progressbar, middlePosition, 0).build().perform();

        getActions().click().build().perform();

        return new MusicPage(getDriver());
    }
    public MusicPage scrollToLastTrack(){
        scrollByVisibleElement(last20Track);
        wait10ElementToBeVisible(last29Track);
        scrollByVisibleElement(last29Track);
        return new MusicPage(getDriver());
    }
    public MusicPage clickFavoritePlaylist() {
        click20(favoriteContainer);
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/music/my?query=");
        return new MusicPage(getDriver());
    }
    public MusicPage clickFavoriteIconInPlaylist() {
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/music/my?query=");
        click(favoriteIconInPlaylist);
        return new MusicPage(getDriver());
    }
    public MusicPage selectDeutschRegion(){
        selectGermanyRegion();
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
    public String getFirstTrackAttribute() {
        return getAttribute( valueFirstImage, "src");
    }
    public String getVolumeDurationFirstTrack()  {

        return getText(durationAttributeOfFirstTrack);
    }
    public String getVolumeDurationSecondTrack()  {

        return getText(durationAttributeOfSecondTrack);
    }

    public String getFontSizeErrorTitleInFavoritePlaylist()  {

        return getFontSize(h2TitleErrorInFavorite);
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