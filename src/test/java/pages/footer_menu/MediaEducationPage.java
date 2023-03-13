package pages.footer_menu;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;
import pages.top_menu.EmailPage;

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
    public MediaEducationPage(WebDriver driver) {
        super(driver);
    }

    public MediaEducationPage createGeneric() {

        return new MediaEducationPage(getDriver());
    }
    public MediaEducationPage scrollToWhereToLinkPdf() {
        scrollByVisibleElement(linkPdf);

        return this;
    }
    public MediaEducationPage scrollToWhereToButtonOpenFlyer() {
        scrollByVisibleElement(buttonOpenFlyer);

        return this;
    }
    public MediaEducationPage scrollToWhereToVideoPlayerYouTube() {
        scrollByVisibleElement(videoPlayerYouTube);

        return this;
    }
    public MediaEducationPage clickLinkPdf() {
        click(linkPdf);

        return this;
    }

    public MediaEducationPage clickButtonOpenFlyer() {
        click(buttonOpenFlyer);
        return this;
    }

    public MediaEducationPage clickPlayerYouTube() throws InterruptedException {
        wait10ElementToBeVisible(videoPlayerYouTube);
        getDriver().switchTo().frame(videoPlayerYouTube);
        clickByJavaScript(videoPlayerYouTubeButtonPlay);
        sleep(7000);
        return  this;
    }
    public MediaEducationPage hoverElement() throws InterruptedException {
        hover(buttonOpenFlyer);
        return  this;

    }

    public String backgroundColorOfElement() {
        return getBackgroundHoverColor(buttonOpenFlyer);

    }




}

