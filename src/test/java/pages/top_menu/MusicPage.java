package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;

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
    @FindBy(xpath = "//article[1]")
    private WebElement previousTrackAttribute;
    @FindBy(xpath = "//div[@class = 'timeline']")
    private WebElement progressbar;
    @FindBy(xpath = "//div[@class = 'progress-bar']//div[@style]")
    private WebElement progressbarFirsTrack;


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
        sleep(5000);

        return new MusicPage(getDriver());
    }
    public MusicPage clickPauseButton() {
        click(firstPlayButton);
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

    public MusicPage clickToProgressbar() {
        click(progressbar);
        return new MusicPage(getDriver());
    }

    public String getPlayButtonAttribute() {

        return getAttribute(playButtonAttribute, "xlink:href");
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
}