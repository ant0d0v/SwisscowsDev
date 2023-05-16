package pages.top_menu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @FindBy(xpath = "(//figure//a//img)[position() < 5]")
    private List<WebElement> AltAttributeAllImage;
    @FindBy(xpath = "//figure[40]//img")
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
    @FindBy(xpath = "//button[@class ='bookmark']")
    private WebElement favoriteButtonInSideImageview;
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
    @FindBy(xpath = "(//div[@class='images-results']//figure//img)[position() < 5]")
    private List<WebElement> allImages;
    @FindBy(xpath = "//a[@class ='item favorite']")
    private WebElement favoriteItem;

    public ImagePage(WebDriver driver) {
        super(driver);
    }

    public ImagePage createGeneric() {

        return new ImagePage(getDriver());
    }
    public ImagePage clickFirstImageInImagesResult() {
        click(firstImageInImagesResult);
        return this;

    }
    public ImagePage clickFavoriteButtonInSideImageview() {
        click(favoriteButtonInSideImageview);
        return this;

    }
    public ImagePage clickFavoriteItem() {
        wait10ElementToBeVisible(favoriteItem);
        click(favoriteItem);
        return this;

    }
    public ImagePage scrollToLastImage() throws InterruptedException {
        scrollByVisibleElement(lastImage);
        sleep(1000);
        return new ImagePage(getDriver());
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
    public ImagePage waitForLoaderIsInvisible (){
        wait10ElementToBeInVisible(loader);
        return this;
    }
    public ImagePage waitForImageIsVisible(){
        for (WebElement image : allImages) {
            wait20ElementToBeVisible(image);
        }
        return this;
    }
    public void clickColorButton() {
        click(colorButton);
        new ImagePage(getDriver());
    }
    public ImagePage clickNextButtonInSideImageview() {
        wait10ElementToBeVisible(nextButtonInSideImageview);
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
    public boolean favoriteItemIsDisplayed() {
        getDriver().navigate().refresh();
        return isElementDisplayed(favoriteItem);

    }
    public void favoriteItemOnPage() {
        getDriver().navigate().refresh();
        getDriver().findElement(By.xpath("//a[@class ='item favorite']"));
        new ImagePage(getDriver());

    }

}
