package pages.top_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.TopMenuPage;
import utils.ProjectConstants;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;

public class VideoPage extends TopMenuPage<VideoPage> {
    @FindBy(xpath = "//h2[@class = 'title']")
    private List<WebElement> h2AllVideo;
    @FindBy(xpath = "//h2[@class = 'title'][1]")
    private WebElement h2FirstVideo;
    @FindBy(xpath = "//section[@class='container page-results']//div")
    private WebElement videoResultContainer;
    @FindBy(xpath = "//div[@class='related-searches']//li//a")
    private List<WebElement> listRelatedSearches;

    @FindBy(xpath = "//div[@class='warning']")
    private WebElement warningMessage;
    @FindBy(xpath = "//button[@class='button']")
    private WebElement videoPlayerYouTubeButtonOk;
    @FindBy(xpath = "//article//h2[1]")
    private WebElement firstVideoResult;
    @FindBy(xpath = "//article[2]//h2[1]")
    private WebElement secondVideoResult;
    @FindBy(xpath = "(//div[@class = 'video-results list'])//article[last()]")
    private WebElement lastVideoResult;
    @FindBy(xpath = "//label[@class='check-player-mode']//input")
    private WebElement checkboxNoRemindMe;
    @FindBy(xpath = "//iframe")
    private WebElement iframe;
    @FindBy(xpath = "//*[@id='movie_player']/div[1]//video")
    private WebElement imageAttribute;
    @FindBy(xpath = "//article[@class='item--video']//img")
    private List<WebElement> listAllImagesOfVideos;
    @FindBy(xpath = "//article[@class='item-video']//img")
    private WebElement ImagesOfVideo;
    @FindBy(xpath = "//div[@class ='button-menu']//span[text() = 'Publisher']")
    private WebElement publisherButtonOfFilter;
    @FindBy(xpath = "//div[contains(@class, 'button-menu')][1]")
    private WebElement attributeOfPublisherButton;
    @FindBy(xpath = "//div[contains(@class, 'button-menu')][1]//ul/li[text() = 'DailyMotion']")
    private WebElement dailyMotionButtonInDropdownOfPublisher;
    @FindBy(xpath = "//footer")
    private WebElement lastTenVideo;
    @FindBy(xpath = "//div[@class = 'video-results list']//article[19]")
    private WebElement lastTwentyVideo;
    @FindBy(xpath = "//div[@class='ytp-time-display notranslate']//span[2]//span")
    private WebElement durationAttributeOfFirstVideo;
    @FindBy(xpath = "//div[@class = 'video-results list']//article//div//p[@class='metadata']")
    private List<WebElement> listMetadataAllVideo;
    @FindBy(xpath = "//div[@class ='video-results list']//article")
    private List<WebElement> list;
    public VideoPage(WebDriver driver) {
        super(driver);
    }

    public VideoPage createGeneric() {

        return new VideoPage(getDriver());

    }
    @Step("Wait until to be visible all images of videos")
    public VideoPage waitUntilToBeVisibleAllImagesOfVideo(){
        getWait10().until(driver -> {
        try {
            for (WebElement imageOfVideo : listAllImagesOfVideos) {
                wait10ElementToBeVisible(imageOfVideo);
                return imageOfVideo.isDisplayed();
            }
        } catch (StaleElementReferenceException e) {
            return false;
        }
            return null;
        });
        return new VideoPage(getDriver());
    }
    @Step("Wait until to be visible video result")
    public VideoPage waitUntilVisibilityVideoResult() {
        getWait10().until(driver -> {
            try {
                wait10ElementToBeVisible(videoResultContainer);
                return videoResultContainer.isDisplayed();
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });
        return new VideoPage(getDriver());
    }
    public List <String> getListMetadataAllVideo()  {
        getWait10().until(driver -> {
            try {
                getTexts(listMetadataAllVideo);
                return videoResultContainer.isDisplayed();
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });
        return getTexts(listMetadataAllVideo);
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
        getWait20().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        getWait20().until(ExpectedConditions.textToBePresentInElement(durationAttributeOfFirstVideo, expectedTime));
        getDriver().switchTo().defaultContent();
        return new VideoPage(getDriver());
    }
    public VideoPage clickPlayerYouTubeVideo(){
        wait10ElementToBeVisible(warningMessage);
        clickByJavaScript(videoPlayerYouTubeButtonOk);
        return  this;
    }
    public VideoPage clickFirstVideoResult() {
        click20(firstVideoResult);
        return new VideoPage(getDriver());
    }
    public VideoPage clickSecondVideoFromSideList() {
        click20(secondVideoResult);
        return new VideoPage(getDriver());
    }
    public VideoPage clickCheckboxNoRemindMe() {
        click20(checkboxNoRemindMe);
        return new VideoPage(getDriver());
    }
    public VideoPage refreshVideoPage() {
        refreshPage();
        return new VideoPage(getDriver());
    }

    public VideoPage clickPublisherButton() {
        click(publisherButtonOfFilter);
        return new VideoPage(getDriver());
    }
    public VideoPage clickDailyMotionButtonInDropdownOfPublisher() {
        click(dailyMotionButtonInDropdownOfPublisher);
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/video?query=ivanka&publisher=DailyMotion");
        return new VideoPage(getDriver());
    }
    public VideoPage clickFilterButton() {
        clickFilterButtonWeb();
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/video?query=ivanka");
        return new VideoPage(getDriver());
    }
    public VideoPage scrollToLastVideo() {
        scrollByVisibleElement(lastTenVideo);
        wait10ElementToBeVisible(lastTwentyVideo);
        scrollByVisibleElement(lastTwentyVideo);
        return new VideoPage(getDriver());
    }
    public VideoPage scrollToLastVideoInTheSideList() throws InterruptedException {

        hover(firstVideoResult);
        for (WebElement element : list) {
            scrollByVisibleElementActions(element);
            wait10ElementToBeVisible(element);
        }

        return new VideoPage(getDriver());
    }

    public VideoPage waitUtilLoaderToBeInVisible(){
        waitForLoaderToBeInVisible();
        return new VideoPage(getDriver());
    }
    public String getVideoImageAttribute() {
        getDriver().switchTo().frame(iframe);
        return getAttribute(imageAttribute, "src");
    }
    public List<String> getProxyImageAttributes() {
        List<String> srcList = new ArrayList<>();
        for (WebElement src : listAllImagesOfVideos) {
            if (src.isEnabled() && src.isDisplayed()) {
                srcList.add(src.getAttribute( "src"));
            }
        }
        return srcList;
    }

    public String getAttributeOfPublisherButton() {

        return getAttribute(attributeOfPublisherButton, "class");
    }
    public List<String> getTextsColorsWhenHover() throws InterruptedException {

        return  getHoverColorsOfElements(listRelatedSearches);
    }
    public VideoPage waitUntilToBeVisiblyListRelatedSearches(){
        for (WebElement element : listRelatedSearches){
            wait10ElementToBeVisible(element);
        }
        return new VideoPage(getDriver());
    }
    public List<String> getTextColors() throws InterruptedException {

        return  getColorsOfElements(listRelatedSearches);
    }
    @Step("Check that favorite item  is present on the page")
    public boolean isWarningMessageIsPresent() {
            try {
                getDriver().findElement(By.xpath("//div[@class='warning']"));
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
    }
}
