package pages.top_menu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
    @FindBy(xpath = "//div[@class = 'brochure-wrap']//a[@href='/docs/Medienerziehung_2020_06_EN.pdf']")
    private WebElement buttonOpenFlyer;
    @FindBy(xpath = "//div[@class='content']")
    private WebElement videoPlayerYouTube;
    @FindBy(xpath = "//button[@class='button button-warning']")
    private WebElement videoPlayerYouTubeButtonOk;
    @FindBy(xpath = "//article//h2[1]")
    private WebElement firstVideoResult;
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
    @FindBy(xpath = "//article[@class ='item-video']//figure//span")
    private List<WebElement> listDurationAllVideo;
    @FindBy(xpath = "//article[20]//figure//img")
    private WebElement lastVideo;
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
    public VideoPage clickPlayerYouTubeVideo() throws InterruptedException {
        wait10ElementToBeVisible(videoPlayerYouTube);

        clickByJavaScript(videoPlayerYouTubeButtonOk);
        sleep(7000);
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
        scrollToLastElement(lastVideo);
        wait10ElementToBeVisible(lastVideo);
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
