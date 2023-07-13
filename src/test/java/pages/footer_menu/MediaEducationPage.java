package pages.footer_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.FooterMenuPage;
import pages.top_menu.EmailPage;
import pages.top_menu.VideoPage;

import static java.lang.Thread.sleep;


public class MediaEducationPage extends FooterMenuPage<MediaEducationPage> {
    @FindBy(xpath = "//p//a[@href = '/docs/Medienerziehung_2020_06_EN.pdf'][1]")
    private WebElement linkPdf;
    @FindBy(xpath = "//div[@class = 'brochure-wrap']//a[@href='/docs/Medienerziehung_2020_06_EN.pdf']")
    private WebElement buttonOpenFlyer;
    @FindBy(xpath = "//div[@class='player']/iframe")
    private WebElement videoPlayerYouTube;
    @FindBy(xpath = "//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")
    private WebElement videoPlayerYouTubeButtonPlay;
    @FindBy(xpath = "//div[@class='ytp-time-display notranslate']//span[2]//span[1]")
    private WebElement durationAttributeOfFirstVideo;
    public MediaEducationPage(WebDriver driver) {
        super(driver);
    }

    public MediaEducationPage createGeneric() {

        return new MediaEducationPage(getDriver());
    }
    @Step("Scroll to pdf link")
    public MediaEducationPage scrollToWhereToLinkPdf() {
        scrollByVisibleElement(linkPdf);
        return this;
    }
    @Step("Scroll to button open flayer ")
    public MediaEducationPage scrollToWhereToButtonOpenFlyer() {
        scrollByVisibleElement(buttonOpenFlyer);

        return this;
    }
    @Step("Scroll to video player ")
    public MediaEducationPage scrollToWhereToVideoPlayerYouTube() {
        scrollByVisibleElement(videoPlayerYouTube);

        return this;
    }
    @Step("Click pdf link ")
    public MediaEducationPage clickLinkPdf() {
        click(linkPdf);
        return this;
    }
    @Step("Click button open flayer")
    public MediaEducationPage clickButtonOpenFlyer() {
        click(buttonOpenFlyer);
        return this;
    }
    @Step("Click play youtube video")
    public MediaEducationPage clickPlayerYouTube() throws InterruptedException {
        wait10ElementToBeVisible(videoPlayerYouTube);
        getDriver().switchTo().frame(videoPlayerYouTube);
        clickByJavaScript(videoPlayerYouTubeButtonPlay);

        return  this;
    }
    @Step("Wait to be time of video to be changed ")
    public MediaEducationPage waitUntilTimeOfVideoToBeChanged(String expectedTime) {
        getWait20().until(ExpectedConditions.textToBePresentInElement(durationAttributeOfFirstVideo, expectedTime));
        return new MediaEducationPage(getDriver());
    }
    @Step("Hover to button")
    public MediaEducationPage hoverElement() throws InterruptedException {
        hover(buttonOpenFlyer);
        return  this;

    }
    @Step("Get the button colors ")
    public String backgroundColorOfElement() {
        return getBackgroundHoverColor(buttonOpenFlyer);

    }




}

