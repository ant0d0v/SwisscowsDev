package pages.top_menu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.TopMenuPage;

import java.util.List;

public class WebPage extends TopMenuPage<WebPage> {
    @FindBy(xpath = "//div[@class='web-results']//article")
    private WebElement webResultContainer;
    @FindBy(xpath = "//div[@class = 'row row-page-results footer-inner']")
    private WebElement footerFooterSearchPages;
    @FindBy(xpath = "//div[@class = 'row row-page-results footer-inner']" + "//p[contains(text(), '©')]")
    private WebElement footerSearchCopyright;
    @FindBy(xpath = "//div[@class = 'row row-page-results footer-inner']//a")
    private List<WebElement> innerFooterMenuLink;
    @FindBy(xpath = "//article[@class = 'item-web']//h2[1]")
    private WebElement h2Text;
    @FindBy(xpath = "//h2[@class = 'title']")
    private WebElement h2TextError;
    @FindBy(xpath = "//ul[@class='menu-dropdown-list']//li[5]")
    private WebElement regionBrazil;
    @FindBy(xpath = "//div[@class='image']//img")
    private WebElement errorImage;
    @FindBy(xpath = "//div[@class='related-searches fade in']//li//a")
    private List<WebElement> listRelatedSearches;
    @FindBy(xpath = "//div[@class='related-searches fade in']//li//a[1]")
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
    @FindBy(xpath = "//div[@class='widget-images']//figure//img")
    private List<WebElement>imagesInNewsWidget;
    @FindBy(xpath = "//div[@class='widget-images']//figure//img[1]")
    private WebElement firstImageInImageWidget;
    @FindBy(xpath = "//div[@class='widget-images']//figure//img[1]")
    private WebElement firstNewsInNewsWidget;
    @FindBy(xpath = "//div[@class='widget']//p[@class='widget-title'][text()='Images for ']")
    private WebElement titleImageWidget;
    @FindBy(xpath = "//div[@class='widget']//p[@class='widget-title'][text()='News for ']")
    private WebElement titleNewsWidget;
    @FindBy(xpath = "//div['web-results']//ul[contains(@class,'pagination')]//li[3]")
    private WebElement thirdPagePagination;
    @FindBy(xpath = "//div['web-results']//ul[contains(@class,'pagination')]//li[4]")
    private WebElement attributeThirdPagePagination;
    @FindBy(xpath = "//div['web-results']//ul[contains(@class,'pagination')]//li[3]")
    private WebElement attributeSecondPagePagination;
    @FindBy(xpath = "//div['web-results']//ul[contains(@class,'pagination')]//li[@class='named previous']")
    private WebElement previousPagePagination;
    @FindBy(xpath = "//div['web-results']//ul[contains(@class,'pagination')]//li[last()]")
    private WebElement nextPagePagination;
    @FindBy(xpath = "//div[@class = 'filters']//div[@class='button-menu']")
    private WebElement buttonDateInFilter;
    @FindBy(xpath = "//div[@class = 'filters']//ul[@class='popup menu']//li[5]")
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
    @FindBy(xpath = "//div[@class ='trackers fade in']")
    private WebElement trackersButtonInScreenshot;
    @FindBy(xpath = "//div[@class ='trackers fade in']//section")
    private List<WebElement>trackersInScreenshot;
    @FindBy(xpath = "//div[@class ='trackers fade in']//section")
    private WebElement trackersScreenshot;
    @FindBy(xpath = "//div[@class='a11t-privacy']")
    private WebElement adsText;
    @FindBy(xpath = "//div[@class='a11t']//article")
    private List<WebElement> adsList;
    @FindBy(xpath = "//div[@class='a11t']//article//a[1]")
    private WebElement firstAds;


    public WebPage(WebDriver driver) {
        super(driver);
    }

    public WebPage createGeneric() {

        return new WebPage(getDriver());
    }
    public WebPage open404Page() {
        getDriver().get("https://swisscows.com/en/qwerty");
        return new WebPage(getDriver());
    }
    public WebPage open500Page() {
        getDriver().get(" https://swisscows.com/en/music?query= ");
        return new WebPage(getDriver());
    }

    public String getCopyright() {

        return getText(footerSearchCopyright);
    }
    public String getTitleH2Text()  {
        wait10ElementToBeVisible(h2Text);
        return getText(h2Text);
    }
    public String getAdsText_WebPage() {
        return getText(adsText);
    }
    public List<String> getTrackersInScreenshot() {
        wait10ElementToBeVisible(trackersScreenshot);
        return getTexts(trackersInScreenshot);
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



    public String getTitleErrorText()  {
        return getText(h2TextError);
    }
    public String getTextDidYpuMeanMessage()  {

        return getText(didYpuMeanMessage);
    }

    public String getH2FontSize(){
        return  getFontSize(h2TextError);

    }
    public String getTittleImagesWidget(){
        return  getText(titleImageWidget);

    }
    public String getTittleNewsWidget(){
        return  getText(titleNewsWidget);

    }
    public List<String> getAdsList(){
        wait10ElementToBeVisible(firstAds);
        return  getTexts(adsList);

    }
    public List <String> getTitleInRelatedSearches()  {
        return
                getTexts(listRelatedSearches);
    }
    public List <String> getTitleInWebResult()  {

        return getTexts(listWebResult);
    }
    public List<String> getTextsColorsWhenHover() throws InterruptedException {

        return  getHoverColorsOfElements(listRelatedSearches);
    }
    public List<String> getTextColors() throws InterruptedException {

        return  getColorsOfElements(listRelatedSearches);
    }
    public List<String> getPreviewColorsWhenHover() throws InterruptedException {

        return  getHoverColorsOfElements(listPreviewButtons);
    }
    public List<String> getPreviewColors() throws InterruptedException {

        return  getColorsOfElements(listPreviewButtons);
    }
    public String getAttributeThirdButtonPagination() {

        return getAttribute(attributeThirdPagePagination,"class");
    }
    public String getAttributeSecondButtonPagination() {

        return getAttribute(attributeSecondPagePagination,"class");
    }
    public NewsPage clickRegionBrazil() {
        click(regionBrazil);

        return new NewsPage(getDriver());
    }
    public WebPage clickPreviewButton() {
        click(previewButton);
        return new WebPage(getDriver());
    }
    public WebPage clickFirstAds() {
        click(firstAds);
        return new WebPage(getDriver());
    }
    public WebPage clickFirstLinkInWebResult() {
        click(firstLinkWebResult);
        return new WebPage(getDriver());
    }
    public WebPage clickOpenButtonInScreenshot() {
        click(openButtonInScreenshot);
        return new WebPage(getDriver());
    }
    public WebPage clickTrackersButtonInScreenshot() {
        wait10ElementToBeVisible(trackersButtonInScreenshot);
        click(trackersButtonInScreenshot);
        return new WebPage(getDriver());
    }
    public WebPage clickButtonDateInFilter() {
        click(buttonDateInFilter);

        return new WebPage(getDriver());
    }
    public WebPage clickPastYearInDropDownOfFilter() {
        click(pastYearDateInDropDownOfFilter);

        return new WebPage(getDriver());
    }


    public WebPage clickFirstTitleInRelatedSearches()  {
        clickByJavaScript(firstTitleRelatedSearches);
        return this;
    }
    public void clickMoreVideoInVideoWidget()  {

        click(buttonMoreVideo);
    }
    public ImagePage clickMoreImagesInVideoWidget()  {

        click(buttonMoreImages);
        return new ImagePage(getDriver());
    }
    public WebPage clickCloseInScreenshot()  {

        click(closeButtonInScreenshot);
        return new WebPage(getDriver());
    }
    public ImagePage clickFirstImageInImageWidget()  {

        clickByJavaScript(firstImageInImageWidget);
        return new ImagePage(getDriver());
    }
    public ImagePage clickFirstNewsInNewsWidget()  {

        clickByJavaScript(firstNewsInNewsWidget);
        return new ImagePage(getDriver());
    }
    public WebPage clickThirdPagePagination_WebPage() {
        click(thirdPagePagination);

        return new WebPage (getDriver());
    }
    public WebPage  clickPreviousPagePagination_WebPage() {
        clickByJavaScript(previousPagePagination);

        return new WebPage (getDriver());
    }
    public WebPage clickNextPagePagination_WebPage() {
        click(nextPagePagination);

        return new WebPage(getDriver());
    }
    public void clickNextButtonVideoWidget() {

        clickElementUntilInvisible(nextButtonInVideoWidget);
    }
    public WebPage clickFirstVideoInVideoWidget() {

        clickByJavaScript(firstImageInVideoWidget);
        return  this;
    }
    public void clickPrevButtonVideoWidget() {

        clickElementUntilInvisible(prevButtonInVideoWidget);
    }
    public boolean lastImageInVideoWidgetIsDisplayed() {
        wait10ElementToBeVisible(lastImageInVideoWidget);
        return isElementDisplayed(lastImageInVideoWidget);

    }
    public WebPage waitUntilVisibilityWebResult() {
        wait20ElementToBeVisible(webResultContainer);

        return this;
    }
    public WebPage waitUntilVisibilityErrorImage() {
        wait20ElementToBeVisible(errorImage);

        return new WebPage(getDriver());
    }
    public WebPage waitUntilVisibilityScreenshot() {
        wait20ElementToBeVisible(previewFrame);

        return new WebPage(getDriver());
    }
    public boolean screenshotIsDisplayed() {

        return isElementDisplayed(previewFrame);

    }
    public boolean  errorImageIsDisplayed() {

        return isElementDisplayed(errorImage);
    }
    public void screenshotIsDisplayedWebPage() {
        getDriver().navigate().refresh();
        getDriver().findElement(By.xpath("//div[@class ='screenshot fade in']"));
        new WebPage(getDriver());

    }
    public boolean firstImageInVideoWidgetIsDisplayed() {
        wait10ElementToBeVisible(firstImageInVideoWidget);
        return isElementDisplayed(firstImageInVideoWidget);

    }
    public VideoPage waitIUntilVisiblyVideoPlayer() {
        wait10ElementToBeVisible(videoPlayer);
        return new VideoPage(getDriver());

    }
    public WebPage waitForImageIsVisibleInImagesWidget(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (WebElement image : imagesInImageWidget) {
            getWait10().until(driver -> (Boolean) js.executeScript(
                    "return arguments[0].complete && typeof arguments[0].naturalWidth !== 'undefined' && arguments[0].naturalWidth > 0;",
                    image));
        }
        return this;

    }

    public WebPage waitForImageIsVisibleInNewsWidget(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (WebElement image : imagesInNewsWidget) {
            getWait10().until(driver -> (Boolean) js.executeScript(
                    "return arguments[0].complete && typeof arguments[0].naturalWidth !== 'undefined' && arguments[0].naturalWidth > 0;",
                    image));
        }
        return this;

    }
    public boolean imagesInImageWidgetIsDisplayed() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (WebElement image : imagesInImageWidget) {
         return (Boolean) js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", image);
        }
        return imagesInNewsWidgetIsDisplayed();
    }

    public boolean imagesInNewsWidgetIsDisplayed(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (WebElement image : imagesInNewsWidget) {
            return (Boolean) js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", image);
        }
        return imagesInNewsWidgetIsDisplayed();
    }

    public WebPage scrollToFooterSearchPages() {
        scrollByVisibleElement(footerFooterSearchPages);

        return new WebPage(getDriver());
    }

}
