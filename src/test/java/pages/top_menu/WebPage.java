package pages.top_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.TopMenuPage;
import utils.ProjectConstants;

import java.util.List;

public class WebPage extends TopMenuPage<WebPage> {
    @FindBy(xpath = "//div[@class='web-results']//article[1]")
    private WebElement webResultContainer;
    @FindBy(xpath = "//footer[@class = 'footer']")
    private WebElement footerFooterSearchPages;
    @FindBy(xpath = "//footer[@class = 'footer']" + "//p[contains(text(), '©')]")
    private WebElement footerSearchCopyright;
    @FindBy(xpath = "//footer[@class = 'footer']//a")
    private List<WebElement> innerFooterMenuLink;
    @FindBy(xpath = "//article[@class = 'item-web']//h2[1]")
    private WebElement h2Text;
    @FindBy(xpath = "//div[@class='error']//h2[@class = 'title']")
    private WebElement h2TextError;
    @FindBy(xpath = "//ul[@class='menu-dropdown-list']//li[5]")
    private WebElement regionBrazil;
    @FindBy(xpath = "//div[@class='image']//img")
    private WebElement errorImage;
    @FindBy(xpath = "//div[@class='related-searches  fade in']//li//a")
    private List<WebElement> listRelatedSearches;
    @FindBy(xpath = "//div[@class='related-searches  fade in']//li//a[1]")
    private WebElement firstTitleRelatedSearches;
    @FindBy(xpath = "//article[@class = 'item-web']//h2")
    private List<WebElement> listWebResult;
    @FindBy(xpath = "//article[@class = 'item-web']//h2[1]")
    private WebElement firstLinkWebResult;
    @FindBy(xpath = "//p[@class='hint'][text()]")
    private WebElement didYpuMeanMessage;
    @FindBy(xpath = "//button[@class][2]")
    private WebElement nextButtonInVideoWidget;
    @FindBy(xpath = "//div[@class='widget widget-video']//button[@class][1]")
    private WebElement prevButtonInVideoWidget;
    @FindBy(xpath = "//div[last()]/article/a[1]/figure")
    private WebElement lastImageInVideoWidget;
    @FindBy(xpath = "//div[1]/article/a[1]/figure/img")
    private WebElement firstImageInVideoWidget;
    @FindBy(xpath = "//div[@class='widget widget-video']//a[@class='widget-button button']")
    private WebElement buttonMoreVideo;
    @FindBy(xpath = "//a[@class='widget-button button'][text()='More images']")
    private WebElement buttonMoreImages;
    @FindBy(xpath = "//div[@class='video-player']")
    private WebElement videoPlayer;
    @FindBy(xpath = "//div[@class='widget-images']//figure//img[@src]")
    private List<WebElement>imagesInImageWidget;
    @FindBy(xpath = "//div[@class ='widget widget-news']//div[@class='news-results']//figure//img[@src]")
    private List<WebElement>imagesInNewsWidget;
    @FindBy(xpath = "//div[@class='widget-images']//figure//img[1]")
    private WebElement firstImageInImageWidget;
    @FindBy(xpath = "(//div[@class='widget widget-news']//a)[position() =1]")
    private WebElement firstNewsInNewsWidget;
    @FindBy(xpath = "//div[@class='widget']//p[@class='widget-title'][text()='Images for ']")
    private WebElement titleImageWidget;
    @FindBy(xpath = "//div[@class='widget widget-news']//p[@class='widget-title']")
    private WebElement titleNewsWidget;
    @FindBy(xpath = "//div['web-results']//ul[contains(@class,'pagination')]//li[3]")
    private WebElement thirdPagePagination;
    @FindBy(xpath = "//div['web-results']//ul[contains(@class,'pagination')]//li[4]")
    private WebElement attributeThirdPagePagination;
    @FindBy(xpath = "//div['web-results']//ul[contains(@class,'pagination')]//li[3]")
    private WebElement attributeSecondPagePagination;
    @FindBy(xpath = "//div['web-results']//ul[contains(@class,'pagination')]//li[1]")
    private WebElement previousPagePagination;
    @FindBy(xpath = "//div['web-results']//ul[contains(@class,'pagination')]//li[last()]")
    private WebElement nextPagePagination;
    @FindBy(xpath = "//div[@class = 'filters-wrap']//div[@class='button-menu']")
    private WebElement buttonDateInFilter;
    @FindBy(xpath = "//div[@class = 'filters-wrap']//ul[@class='popup menu']//li[5]")
    private WebElement pastYearDateInDropDownOfFilter;
    @FindBy(xpath = "//button[@class ='preview-link'][1]")
    private WebElement previewButton;
    @FindBy(xpath = "//button[@class ='preview-link']")
    private List<WebElement> listPreviewButtons;
    @FindBy(xpath = "//div[@class ='screenshot fade in']//img")
    private WebElement previewFrame;
    @FindBy(xpath = "//button[@class ='close mobile-hidden']")
    private WebElement closeButtonInScreenshot;
    @FindBy(xpath = "//a[@class ='button button-preview mobile-hidden']")
    private WebElement openButtonInScreenshot;
    @FindBy(xpath = "//div[@class ='trackers  fade in']")
    private WebElement trackersButtonInScreenshot;
    @FindBy(xpath = "//div[@class ='trackers  fade in']//span")
    private WebElement screenshotButtonInScreenshot;
    @FindBy(xpath = "//div[@class ='trackers fade in']//section//p//a")
    private List<WebElement> trackersOfScreenshot;
    @FindBy(xpath = "//div[@class ='trackers fade in']//section//p//a[1]")
    private WebElement firstTrackerOfScreenshot;

    @FindBy(xpath = "//div[@class='a11t-privacy']")
    private WebElement adsText;
    @FindBy(xpath = "//div[@class='a11t--product']//p")
    private WebElement adsProductsText;
    @FindBy(className ="three-bounce")
    private WebElement loader;
    @FindBy(xpath = "//div[@class='web-results']//div//article[@class='text-item']")
    private List<WebElement> adsList;
    @FindBy(xpath = "//div[@class='web-results']//div//article[@class='text-item'][1]//a[2]")
    private WebElement firstAds;
    @FindBy(xpath = "//div[@class='a11t--product']//button[2]")
    private WebElement nextButtonInAds;
    @FindBy(xpath = "//div[@class='a11t--product']//button[1]")
    private WebElement prevButtonInAds;
    @FindBy(xpath = "//div[@class='widget-slider']//div[last()]/article/a[1]/figure")
    private WebElement lastImageInAds;


    public WebPage(WebDriver driver) {
        super(driver);
    }

    public WebPage createGeneric() {

        return new WebPage(getDriver());
    }
    @Step("Open the 404 page.")
    public WebPage open404Page() {
        getDriver().get("https://swisscows.com/en/qwerty");
        return new WebPage(getDriver());
    }
    @Step("Open the 500 page.")
    public WebPage open500Page() {
        getDriver().get(" https://swisscows.com/en/music?query= ");
        return new WebPage(getDriver());
    }
    @Step("Get text of Copyright")
    public String getCopyright() {
        return getText(footerSearchCopyright);
    }
    @Step("Wait to be visible title of first search result ")
    public WebPage waitToBeVisibleTitleFirstSearchResult(){
        getWait10().until(driver -> {
            try {
                wait10ElementToBeVisible(h2Text);
                return h2Text.isDisplayed();
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });
        return new WebPage(getDriver());
    }
    @Step("Get title h2 text")
    public String getTitleH2Text()  {
        try {
            return h2Text.getText();
        } catch (StaleElementReferenceException e) {
            wait10ElementToBeVisible(h2Text);
            return h2Text.getText();
        }
    }
    @Step("Get texts ads")
    public String getAdsText_WebPage() {
        wait10ElementToBeVisible(adsText);
        return getText(adsText);
    }
    @Step("Get texts of products ads")
    public String getProductsAdsText_WebPage() {
        wait10ElementToBeVisible(adsProductsText);
        return getText(adsProductsText);
    }
    @Step("Click next button the products ads container")
    public void clickNextButtonInProductsAds() {
        wait10ElementToBeVisible(nextButtonInAds);
        clickElementUntilInvisible(nextButtonInAds);
    }

    @Step("Click prev button the related search container")
    public void clickPrevButtonInProductsAds() {
        wait10ElementToBeVisible(prevButtonInAds);
        clickElementUntilInvisible(prevButtonInAds);
    }

    public WebPage choiceGermanyRegion(){
        selectGermanyRegion();
        return new WebPage(getDriver());
    }
    @Step("Wait until url to be changed")
    public WebPage waitUntilUrlToBeChanged(String parametr){
        waitForUrlContains(ProjectConstants.DOMAIN +parametr);
        return new  WebPage(getDriver());
    }
    @Step("Get trackers in screenshot ")
    public int getTrackersInScreenshot() {
        wait10ElementToBeVisible(firstTrackerOfScreenshot);
        return getListSize(trackersOfScreenshot);
    }

    public List<WebElement> getInnerFooterMenuLinks() {
        return innerFooterMenuLink;
    }
    public void clickFooterSearchMenuExternalLink(int index) {
        click(getInnerFooterMenuLinks().get(index));
        switchToAnotherWindow();
        getWait20().until(ExpectedConditions.numberOfWindowsToBe(2));
    }
    public int getFooterMenuLinksCount() {
        areAllElementsVisibleAndClickable(innerFooterMenuLink);

        return getListSize(innerFooterMenuLink);
    }

    @Step("Get the title text of the error page")
    public String getTitleErrorText()  {
        String errorText = null;
        try {
            wait10ElementToBeVisible(h2TextError);
            errorText = getText(h2TextError);
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException occurred: " + e.getMessage());
            errorText = getText(h2TextError);
        }
        return errorText;
    }
    @Step("Get text Did you mean message in the search field")
    public String getTextDidYouMeanMessage()  {
        return getText(didYpuMeanMessage);
    }
    @Step("Get the font size of the title text.")
    public String getH2FontSize(){
        return  getFontSize(h2TextError);

    }
    @Step("Get title of image widget")
    public String getTittleImagesWidget(){
        return  getText(titleImageWidget);
    }
    @Step("Get title of news widget")
    public String getTittleNewsWidget(){
        return  getText(titleNewsWidget);

    }
    public List<String> getAdsList(){
        wait10ElementToBeVisible(firstAds);
        return  getTexts(adsList);

    }
    @Step("Get title in the related searches")
    public List <String> getTitleInRelatedSearches()  {
        return getTexts(listRelatedSearches);
    }
    public WebPage waitUntilLoaderToBeInvisible(){
           waitForLoaderToBeInVisible();
           return new WebPage(getDriver());
        }

    @Step("Wait to be visible titles in web result")
    public WebPage waitUntilToBeVisibleTitlesInWebResult(){
        getWait10().until(driver -> {
            try {
                getWait20().until(ExpectedConditions.visibilityOfAllElements(listWebResult));
                return areElementsInListDisplayed(listWebResult);
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });
        return new WebPage(getDriver());
    }
    @Step("Get titles all queries in web results")
    public List<String> getTitlesInWebResult() {
        for (WebElement element : listWebResult){
            try {
                wait10ElementToBeVisible(element);
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException occurred: " + e.getMessage());
            }
        }
        return getTexts(listWebResult);
    }
    @Step("Get texts color when hovering")
    public List<String> getTextsColorsWhenHover() throws InterruptedException {
        return  getHoverColorsOfElements(listRelatedSearches);
    }
    @Step("Get texts color")
    public List<String> getTextColors() throws InterruptedException {
        return  getColorsOfElements(listRelatedSearches);
    }
    @Step("Get colors preview buttons when hovering")
    public List<String> getColorsOfPreviewButtonsWhenHovering() throws InterruptedException {
        return  getHoverColorsOfElements(listPreviewButtons);
    }
    @Step("Get colors preview buttons")
    public List<String> getColorsOfPreviewButtons() throws InterruptedException {
        return  getColorsOfElements(listPreviewButtons);
    }
    @Step("Get attribute third button of pagination ")
    public String getAttributeOfThirdButtonInPagination() {
        return getAttribute(attributeThirdPagePagination,"class");
    }
    @Step("Get attribute second button of pagination ")
    public String getAttributeOfSecondButtonInPagination() {
        wait10ElementToBeVisible(attributeSecondPagePagination);
        return getAttribute(attributeSecondPagePagination,"class");
    }
    @Step("Click preview button ")
    public WebPage clickPreviewButton() {
        click(previewButton);
        return new WebPage(getDriver());
    }
    @Step("Click first link od ads")
    public WebPage clickFirstLinkOfAds() {
        click20(firstAds);
        return new WebPage(getDriver());
    }
    @Step("Click first link in the web result")
    public WebPage clickFirstLinkInWebResult() {
        click(firstLinkWebResult);
        return new WebPage(getDriver());
    }
    @Step("Click open button in the screenshot")
    public WebPage click_OpenSite_ButtonInScreenshot() {
        click(openButtonInScreenshot);
        return new WebPage(getDriver());
    }
    @Step("Click trackers button in Screenshot")
    public WebPage clickTrackersButtonInScreenshot() {
        click(trackersButtonInScreenshot);
        return new WebPage(getDriver());
    }
    @Step("Select of date filter ")
    public WebPage clickDateButtonInFilter() {
        click(buttonDateInFilter);

        return new WebPage(getDriver());
    }
    @Step("Select past year of filter date")
    public WebPage click_PastYear_InDropDownOfDateFilter() {
        click(pastYearDateInDropDownOfFilter);
        return new WebPage(getDriver());
    }

    @Step("Click first query in related search ")
    public WebPage clickFirstTitleInRelatedSearches()  {
        clickByJavaScript(firstTitleRelatedSearches);
        return this;
    }
    @Step("Click more video button in the video widget")
    public VideoPage click_MoreVideo_ButtonInVideoWidget()  {
        try {
            click(buttonMoreVideo);
            waitForUrlContains(ProjectConstants.DOMAIN + "/en/video?query=watch%20youtube&region=de-DE");
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            click(buttonMoreVideo);
            waitForUrlContains(ProjectConstants.DOMAIN + "/en/video?query=watch%20youtube&region=de-DE");
        }
        return new VideoPage(getDriver());
    }
    @Step("Check click more button in the image widget")
    public ImagePage click_MoreImages_ButtonInImageWidget()  {
        click(buttonMoreImages);
        return new ImagePage(getDriver());
    }
    @Step("Click close in screenshot")
    public void clickCloseButtonInScreenshot()  {
        click(closeButtonInScreenshot);
        new WebPage(getDriver());
    }
    public ImagePage clickFirstImageInImageWidget()  {
        clickByJavaScript(firstImageInImageWidget);
        switchToAnotherWindow();
        return new ImagePage(getDriver());
    }
    public ImagePage clickFirstNewsInNewsWidget()  {
        clickByJavaScript(firstNewsInNewsWidget);
        switchToAnotherWindow();
        return new ImagePage(getDriver());
    }
    @Step("Click third number in the pagination")
    public WebPage clickThirdNumberInPagination_WebPage() {
        click(thirdPagePagination);
        return new WebPage (getDriver());
    }
    @Step("Click prev button in the pagination")
    public WebPage clickPreviousButtonInPagination_WebPage() {
        click20(previousPagePagination);
        return new WebPage (getDriver());
    }
    @Step("Click next button in the pagination")
    public WebPage clickNextButtonInPagination_WebPage() {
        click(nextPagePagination);
        return new WebPage(getDriver());
    }
    @Step("Click next button until button to be invisible in the video widget")
    public WebPage clickNextButtonVideoWidget() {
        wait10ElementToBeVisible(nextButtonInVideoWidget);
        clickElementUntilInvisible(nextButtonInVideoWidget);
        return new WebPage(getDriver());
    }
    @Step("Click first video in the video widget")
    public WebPage clickFirstVideoInVideoWidget() {
        wait10ElementToBeVisible(firstImageInVideoWidget);
        clickByJavaScript(firstImageInVideoWidget);
        return  this;
    }
    @Step("Click prev button until button to be invisible in the video widget")
    public void clickPrevButtonVideoWidget() {
        wait10ElementToBeVisible(prevButtonInVideoWidget);
        clickElementUntilInvisible(prevButtonInVideoWidget);
        new WebPage(getDriver());
    }
    @Step("Check that last video is dysplaed")
    public boolean lastImageInVideoWidgetIsDisplayed() {
        wait10ElementToBeVisible(lastImageInVideoWidget);
        return isElementDisplayed(lastImageInVideoWidget);

    }
    @Step("Wait until the web search results are visible")
    public WebPage waitUntilVisibilityWebResult() {
        try {
            wait20ElementToBeVisible(webResultContainer);
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            wait20ElementToBeVisible(webResultContainer);
        }
        return this;
    }
    @Step("Wait until the error image is visible.")
    public WebPage waitUntilVisibilityErrorImage() {
        wait20ElementToBeVisible(errorImage);
        return new WebPage(getDriver());
    }
    @Step("Wait until visible tracker button .")
    public WebPage waitUntilVisibilityTrackersButtonInScreenshot() {
        wait10ElementToBeVisible(trackersButtonInScreenshot);

        return new WebPage(getDriver());
    }
    @Step("Wait to be visible screenshot button")
    public WebPage waitUntilVisibilityScreenshotButtonInScreenshot() {
        wait10ElementToBeVisible(screenshotButtonInScreenshot);

        return new WebPage(getDriver());
    }
    @Step("Wait until to be visible Screenshot")
    public WebPage waitUntilVisibilityScreenshot() {
        wait10ElementToBeVisible(previewFrame);

        return new WebPage(getDriver());
    }
    @Step("Check that Screenshot is dysplaed")
    public boolean screenshotIsDisplayed() {
        return isElementDisplayed(previewFrame);
    }
    public boolean  errorImageIsDisplayed() {
        waitUntilVisibilityErrorImage();
        return isElementDisplayed(errorImage);
    }

    @Step("Check that Screenshot is present on the page")
    public boolean isScreenshotItemIsPresent() {
        try {
            getDriver().navigate().refresh();
            getDriver().findElement(By.xpath("//div[@class ='screenshot fade in']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    @Step("Check that first video is dysplaed in the video widget")
    public boolean firstImageInVideoWidgetIsDisplayed() {
        wait10ElementToBeVisible(firstImageInVideoWidget);
        return isElementDisplayed(firstImageInVideoWidget);

    }
    @Step("Wait to be visible video player")
    public VideoPage waitIUntilVisiblyVideoPlayer() {
        wait10ElementToBeVisible(videoPlayer);
        return new VideoPage(getDriver());

    }
    @Step("Wait until to be visible images in image widget")
    public WebPage waitForImageIsVisibleInImagesWidget(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (WebElement image : imagesInImageWidget) {
            getWait10().until(driver -> (Boolean) js.executeScript(
                    "return arguments[0].complete && typeof arguments[0].naturalWidth !== 'undefined' && arguments[0].naturalWidth > 0;",
                    image));
        }
        return this;

    }
    @Step("Wait until to be visible images in news widget")
    public WebPage waitForImageIsVisibleInNewsWidget(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (WebElement image : imagesInNewsWidget) {
            getWait10().until(driver -> (Boolean) js.executeScript(
                    "return arguments[0].complete && typeof arguments[0].naturalWidth !== 'undefined' && arguments[0].naturalWidth > 0;",
                    image));
        }
        return this;

    }
    @Step("Images are dysplaed in the image widget")
    public boolean imagesInImageWidgetIsDisplayed() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (WebElement image : imagesInImageWidget) {
         return (Boolean) js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", image);
        }
        return imagesInNewsWidgetIsDisplayed();
    }
    @Step("Images are dysplaed in the news widget")
    public boolean imagesInNewsWidgetIsDisplayed(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (WebElement image : imagesInNewsWidget) {
            return (Boolean) js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", image);
        }
        return imagesInNewsWidgetIsDisplayed();
    }
    @Step("Scroll to the footer menu for search ")
    public WebPage scrollToFooterOnSearchPages() {
        scrollByVisibleElement(footerFooterSearchPages);
        return new WebPage(getDriver());
    }

}
