package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.TopMenuPage;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class ImagePage extends TopMenuPage<ImagePage> {
    @FindBy(xpath = "//div[@class='images-results']//figure")
    private WebElement firstImageInImagesResult;
    @FindBy(xpath = "//h2[@class = 'title']")
    private WebElement h2FirstImage;
    @FindBy(xpath = "//figure//a//img")
    private List<WebElement> AltAttributeAllImage;
    @FindBy(xpath = "//figure[40]")
    private WebElement lastImage;
    @FindBy(xpath = "//div[@class='button-menu color']")
    private WebElement colorButton;
    @FindBy(xpath = "//div[@class][3]//li[4]")
    private WebElement redInDropdownColor;
    @FindBy(xpath = "//div[@class='images-results']//figure[1]")
    private WebElement imageAttribute;
    @FindBy(xpath = "//div[@class= 'images-results']//figure[1]//a")
    private WebElement imageAttributeHref;
    @FindBy(xpath = "//div[@class= 'image-view aside fade in']//a")
    private WebElement imageAttributeHrefInSideImageview;
    @FindBy(xpath = "//figure[2]")
    private WebElement secondImageAttribute;
    @FindBy(xpath = "//figure//a")
    private List<WebElement> allLinksImages;
    @FindBy(xpath = "//div[@class='images-results']//button[@class][2]")
    private WebElement nextButtonInAds;
    @FindBy(xpath = "//div[@class='images-results']//button[@class][1]")
    private WebElement prevButtonInAds;
    @FindBy(xpath = "//button[@class='next']")
    private WebElement nextButtonInSideImageview;
    @FindBy(xpath = "//button[@class='prev']")
    private WebElement prevButtonInSideImageview;
    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeButtonInSideImageview;
    @FindBy(xpath = "//div[@class='widget-slider']//div[last()]/article/a[1]/figure")
    private WebElement lastImageInAds;
    @FindBy(xpath = "//div[@class='widget-slider']//div[2]/article/a[1]/figure/img")
    private WebElement firstImageInAds;

    @FindBy(xpath = "//div[@class ='related-queries']//a[1]")
    private WebElement relatedSearchesImage;
    @FindBy(xpath = "//div[@class='related-queries']//a[2]")
    private WebElement secondQueryInRelatedSearchContainer;

    @FindBy(xpath = "//div[@class='three-bounce']")
    private WebElement loader;
    @FindBy(xpath = "//ul[@class='popup menu']")
    private WebElement dropdownLisOfColor;
    @FindBy(xpath = "(//div[@class='images-results']//figure//img)[position() < 10]")
    private List<WebElement> allImages;



    public ImagePage(WebDriver driver) {
        super(driver);
    }

    public ImagePage createGeneric() {

        return new ImagePage(getDriver());
    }
    public ImagePage clickFirstImageInImagesResult() {
        click(firstImageInImagesResult);
        return new ImagePage(getDriver());

    }
    public MusicPage scrollToLastImage() {
        scrollByVisibleElement(lastImage);
        return new MusicPage(getDriver());
    }
    public List <String> getLinksAllImages()  {

        return getTexts(allLinksImages);
    }

    public String getTitleFirstImage()  {
        return getText(h2FirstImage);
    }
    public List<String> getAltAllImages() {
        if (AltAttributeAllImage.size() > 0) {
            getWait20().until(ExpectedConditions.visibilityOfAllElements(AltAttributeAllImage));
            List<String> ListAttribute = new ArrayList<>();
            for (WebElement element : AltAttributeAllImage) {
                if (element.isEnabled() && element.isDisplayed()) {
                    ListAttribute.add(element.getAttribute("alt"));
                }
            }

            return ListAttribute;
        }

        return new ArrayList<>();
    }
    public String getTitleInRelatedSearchesImages() throws InterruptedException {
        sleep(1000);
        return getText(relatedSearchesImage);
    }
    public String getAttributeFirstImage() {
        wait10ElementToBeVisible(imageAttribute);
        return getAttribute(imageAttribute,"class");
    }
    public String getAttributeSecondImage() {
        wait10ElementToBeVisible(secondImageAttribute);
        return getAttribute(secondImageAttribute,"class");
    }
    public String getAttributeHrefImage() {
        wait10ElementToBeVisible(imageAttributeHref);
        return getAttribute(imageAttributeHref,"src");
    }
    public String getAttributeHrefImageInSideView() {
        wait10ElementToBeVisible(imageAttributeHrefInSideImageview);
        return getAttribute(imageAttributeHrefInSideImageview,"src");
    }
    public ImagePage waitForLoaderIsDisappeared (){
        waitForElementIsDisappeared(loader);
        return this;
    }
    public ImagePage waitForImageIsVisible(){
        for (WebElement image : allImages) {
            wait10ElementToBeVisible(image);
        }
        return this;
    }
    public ImagePage clickColorButton() {
        click(colorButton);
        return new ImagePage(getDriver());
    }
    public ImagePage clickNextButtonInSideImageview() {
        clickByJavaScript(nextButtonInSideImageview);
        return new ImagePage(getDriver());
    }
    public ImagePage clickPrevButtonInSideImageview() {
        click(prevButtonInSideImageview);
        return new ImagePage(getDriver());
    }
    public ImagePage clickCloseButtonInSideImageview() {
        click(closeButtonInSideImageview);
        return new ImagePage(getDriver());
    }
    public ImagePage clickSecondQueryInRelatedSearchContainer() {

        clickByJavaScript(secondQueryInRelatedSearchContainer);

        return new ImagePage(getDriver());
    }
    public void clickNextButton() {

        clickElementUntilInvisible(nextButtonInAds);
    }
    public void clickPrevButton() {

        clickElementUntilInvisible(prevButtonInAds);
    }

    public ImagePage clickRedColorInDropdownColors() {
        wait10ElementToBeVisible(dropdownLisOfColor);
        click(redInDropdownColor);
        return new ImagePage(getDriver());
    }
    public boolean lastImageInAdsIsDisplayed() {
        wait10ElementToBeVisible(lastImageInAds);
        return isElementDisplayed(lastImageInAds);

    }
    public boolean firstImageInAdsIsDisplayed() {
        wait10ElementToBeVisible(firstImageInAds);
        return isElementDisplayed(firstImageInAds);

    }
}
