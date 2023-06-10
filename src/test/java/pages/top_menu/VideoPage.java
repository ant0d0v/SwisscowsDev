package pages.top_menu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.TopMenuPage;
import pages.footer_menu.MediaEducationPage;

import java.util.List;

import static java.lang.Thread.sleep;

public class VideoPage extends TopMenuPage<VideoPage> {
    @FindBy(xpath = "//h2[@class = 'title']")
    private List<WebElement> h2AllVideo;
    @FindBy(xpath = "//h2[@class = 'title'][1]")
    private WebElement h2FirstVideo;
    @FindBy(xpath = "//div[@class='video-results']//article")
    private WebElement videoResultContainer;
    @FindBy(xpath = "//div[@class='related-searches']//li//a")
    private List<WebElement> listRelatedSearches;

    @FindBy(xpath = "//div[@class='content']")
    private WebElement videoPlayerYouTube;
    @FindBy(xpath = "//button[@class='button button-warning']")
    private WebElement videoPlayerYouTubeButtonOk;
    @FindBy(xpath = "//article//h2[1]")
    private WebElement firstVideoResult;
    @FindBy(xpath = "//iframe")
    private WebElement iframe;
    @FindBy(xpath = "//div[@class='video-player']//iframe")
    private WebElement imageAttribute;
    @FindBy(xpath = "//div[@class='video-player']//img")
    private WebElement srcAttribute;
    @FindBy(xpath = "//div[@class ='button-menu'][3]")
    private WebElement durationButton;
    @FindBy(xpath = "//div[3]")
    private WebElement durationAttribute;
    @FindBy(xpath = "//div[@class][3]//ul//li[2]")
    private WebElement shortButtonInDropdownDuration;
    @FindBy(xpath = "//div[@class = 'video-results'][2]//article[20]")
    private WebElement last20Video;
    @FindBy(xpath = "//div[@class = 'video-results'][2]//article[29]")
    private WebElement last29Video;
    @FindBy(xpath = "//div[@class='ytp-time-display notranslate']//span[2]")
    private WebElement durationAttributeOfFirstVideo;
    @FindBy(xpath = "//article[@class ='item-video']//figure//span")
    private List<WebElement> listDurationAllVideo;
    public VideoPage(WebDriver driver) {
        super(driver);
    }

    public VideoPage createGeneric() {

        return new VideoPage(getDriver());

    }
    public VideoPage waitUntilVisibilityVideoResult() {
        wait20ElementToBeVisible(videoResultContainer);

        return new VideoPage(getDriver());
    }
    public List <String> getListDurationAllVideo()  {

        return getTexts(listDurationAllVideo);
    }
    public List <String> getTitleAllVideo()  {

        return getTexts(h2AllVideo);
    }
    public String getTitleFirstVideo()  {

        return getText(h2FirstVideo);
    }
    public List <String> getTitleInRelatedSearches()  {
        return getTexts(listRelatedSearches);
    }
    public VideoPage waitUntilTimeOfFirstVideoToBeChanged(String expectedTime) {
        getWait10().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        getWait20().until(ExpectedConditions.textToBePresentInElement(durationAttributeOfFirstVideo, expectedTime));
        getDriver().switchTo().defaultContent();
        return new VideoPage(getDriver());
    }
    public VideoPage clickPlayerYouTubeVideo(){
        wait10ElementToBeVisible(videoPlayerYouTube);
        clickByJavaScript(videoPlayerYouTubeButtonOk);
        return  this;
    }
    public VideoPage clickFirstVideoResult() {
        click20(firstVideoResult);
        return new VideoPage(getDriver());
    }
    public VideoPage clickDurationButton() {
        click(durationButton);
        return new VideoPage(getDriver());
    }
    public VideoPage clickShortInDropdownDuration() {
        click(shortButtonInDropdownDuration);
        return new VideoPage(getDriver());
    }
    public VideoPage scrollToLastVideo() {
        scrollByVisibleElement(last20Video);
        wait10ElementToBeVisible(last29Video);
        scrollByVisibleElement(last29Video);
        return new VideoPage(getDriver());
    }
    public String getVideoImageAttribute() {

        return getAttribute(imageAttribute, "src");
    }
    public String getProxyImageAttribute() {

        return getAttribute(srcAttribute, "src");
    }
    public String getDurationButtonAttribute() {

        return getAttribute(durationAttribute, "class");
    }
    public List<String> getTextsColorsWhenHover() throws InterruptedException {

        return  getHoverColorsOfElements(listRelatedSearches);
    }
    public List<String> getTextColors() throws InterruptedException {

        return  getColorsOfElements(listRelatedSearches);
    }
}
