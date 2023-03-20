package pages.top_menu;

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
    @FindBy(xpath = "//div[@class='news-results']//figure")
    private WebElement newsResultContainer;
    @FindBy(xpath = "//h2[@class = 'title']")
    private WebElement h2Text;

    @FindBy(xpath = "//ul[@class='menu-dropdown-list']//li[5]")
    private WebElement regionBrazil;
    @FindBy(xpath = "//div[@class='image']//img")
    private WebElement errorImage;
    @FindBy(xpath = "//figure//img")
    private List<WebElement> allImageNewsPage;
    @FindBy(xpath = "//ul[@class='pagination']//li[3]")
    private WebElement secondPagePagination;
    @FindBy(xpath = "//div[@class='related-searches fade in']//li//a")
    private List<WebElement> listRelatedSearches;
    @FindBy(xpath = "//div[@class='related-searches fade in']//li//a[1]")
    private WebElement firstTitleRelatedSearches;
    @FindBy(xpath = "//section[@class='page-results']//article")
    private List<WebElement> listWebResult;
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
    @FindBy(xpath = "//div[@class='widget-images']")
    private WebElement frameImageWidget;
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
    public WebPage(WebDriver driver) {
        super(driver);
    }

    public WebPage createGeneric() {

        return new WebPage(getDriver());
    }
    public WebPage waitUntilVisibilityWebResult() {
        wait20ElementToBeVisible(webResultContainer);

        return this;
    }
    public WebPage scrollToFooterSearchPages() {
        scrollByVisibleElement(footerFooterSearchPages);

        return new WebPage(getDriver());
    }
    public String getCopyright() {

        return getText(footerSearchCopyright);
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

    public WebPage waitUntilVisibilityErrorImage() {
        wait20ElementToBeVisible(errorImage);

        return new WebPage(getDriver());
    }
    public String getTitleH2Text()  {

        return getText(h2Text);
    }
    public String getTextDidYpuMeanMessage()  {

        return getText(didYpuMeanMessage);
    }

    public String getH2FontSize(){
        return  getFontSize(h2Text);

    }
    public String getTittleImagesWidget(){
        return  getText(titleImageWidget);

    }
    public String getTittleNewsWidget(){
        return  getText(titleNewsWidget);

    }
    public NewsPage clickRegionBrazil() {
        click(regionBrazil);

        return new NewsPage(getDriver());
    }
    public NewsPage clickFirstPost() {
        click(h2Text);

        return new NewsPage(getDriver());
    }

    public boolean  errorImageIsDisplayed() {

        return isElementDisplayed(errorImage);
    }
    public boolean  allImageIsDisplayed() {
        areAllElementsVisibleAndClickable(allImageNewsPage);
        return areElementsInListDisplayed(allImageNewsPage);
    }
    public List<String> getSrsOfImages() {

        return getSrcOfElements(allImageNewsPage);
    }
    public List<String> getTextsColorsWhenHover() throws InterruptedException {

        return  getHoverColorsOfElements(listRelatedSearches);
    }
    public List<String> getTextColors() throws InterruptedException {

        return  getColorsOfElements(listRelatedSearches);
    }
    public List <String> getTitleInRelatedSearches()  {
        return getTexts(listRelatedSearches);
    }
    public List <String> getTitleInWebResult()  {
        return getTexts(listWebResult);
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
    public ImagePage clickFirstImageInImageWidget()  {

        clickByJavaScript(firstImageInImageWidget);
        return new ImagePage(getDriver());
    }
    public ImagePage clickFirstNewsInNewsWidget()  {

        clickByJavaScript(firstNewsInNewsWidget);
        return new ImagePage(getDriver());
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

}
