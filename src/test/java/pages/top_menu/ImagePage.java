package pages.top_menu;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.TopMenuPage;
import utils.ProjectConstants;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class ImagePage extends TopMenuPage<ImagePage> {
    @FindBy(xpath = "//figure//img[1]")
    private WebElement firstImageInImagesResult;
    @FindBy(xpath = "//h2[@class = 'title']")
    private WebElement h2FirstImage;
    @FindBy(xpath = "(//figure//a//img)[position() < 5]")
    private List<WebElement> AltAttributeAllImage;
    @FindBy(xpath = "//figure[50]//img")
    private WebElement last50Image;
    @FindBy(xpath = "//figure[60]//img")
    private WebElement last60Image;

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
    @FindBy(xpath = "//div[@class ='filters-button']//*[name() = 'svg']")
    private WebElement filterButton;
    @FindBy(xpath = "//div[@class ='related-queries']//a[1]")
    private WebElement relatedSearchesImage;
    @FindBy(xpath = "//div[@class='related-queries']//a[2]")
    private WebElement secondQueryInRelatedSearchContainer;

    @FindBy(xpath = "//div[@class='three-bounce']")
    private WebElement loader;
    @FindBy(xpath = "//ul[@class='popup menu']")
    private WebElement dropdownLisOfColor;
    @FindBy(xpath = "(//figure[@class='item--image']//img)[position()<15]")
    private List<WebElement> fifteenImages;
    @FindBy(xpath = "//a[@class ='item favorite']")
    private WebElement favoriteItem;

    public ImagePage(WebDriver driver) {
        super(driver);
    }

    public ImagePage createGeneric() {

        return new ImagePage(getDriver());
    }
    public ImagePage clickFirstImageInImagesResult() {
        click20(firstImageInImagesResult);
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
    public ImagePage refreshImagePage(){
        refreshPage();
        return new ImagePage(getDriver());
    }
    public ImagePage choiceRegionGermany(){
        selectGermanyRegion();
        return new ImagePage(getDriver());
    }

    public ImagePage scrollToLastImage(){
        scrollByVisibleElementActions(last50Image);
        wait10ElementToBeVisible(last60Image);
        scrollByVisibleElement(last60Image);
        return new ImagePage(getDriver());
    }
    public List <String> getLinksAllImages()  {

        return getTexts(allLinksImages);
    }

    public String getTitleFirstImage()  {
        wait10ElementToBeVisible(h2FirstImage);
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
    public String getTitleInRelatedSearchesImages() {
        wait10ElementToBeVisible(relatedSearchesImage);
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

    public ImagePage waitUtilToBeVisibleFifteenImages(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        for (WebElement image : fifteenImages) {
            wait20ElementToBeVisibleJsExecutor(jsExecutor,image);
        }
        return this;
    }
    public ImagePage clickColorButton(){
        click(colorButton);
        return new ImagePage(getDriver());
    }
    public ImagePage clickFilterButton() {
        clickFilterButtonWeb();

        return new ImagePage(getDriver());
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
        click20(secondQueryInRelatedSearchContainer);
        waitForUrlContains(ProjectConstants.DOMAIN +"/en/images?query=Ronaldo%");
        return new ImagePage(getDriver());
    }
    public void clickNextButton() {
        wait10ElementToBeVisible(nextButtonInAds);
        clickElementUntilInvisible(nextButtonInAds);
    }
    public void clickPrevButton() {
        wait10ElementToBeVisible(prevButtonInAds);
        clickElementUntilInvisible(prevButtonInAds);
    }

    public ImagePage clickRedColorInDropdownColors() {
        click20(redInDropdownColor);
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/images?query=color&color=Red");
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
    public ImagePage waitUntilToBeVisibleFavoriteItem(){
        wait10ElementToBeVisible(favoriteItem);
        return new ImagePage(getDriver());
    }
    public ImagePage choiceDeutschLocalisation(){
        selectDeutschLocalisation();
        return new ImagePage(getDriver());
    }
    public boolean favoriteItemIsDisplayed() {
        return isElementDisplayed(favoriteItem);

    }
    public boolean isFavoriteItemIsPresent() {
        try {
            getDriver().navigate().refresh();
            getDriver().findElement(By.xpath("//a[@class ='item favorite']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
