package pages.top_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.TopMenuPage;
import utils.ProjectConstants;
import java.util.ArrayList;
import java.util.List;

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
    @FindBy(xpath = "//div[@class ='related-queries']//a[1]")
    private WebElement relatedSearchesImage;
    @FindBy(xpath = "//div[@class='related-queries']//a[2]")
    private WebElement secondQueryInRelatedSearchContainer;
    @FindBy(xpath = "(//figure[@class='item--image']//img)[position()<10]")
    private List<WebElement> tenImages;
    @FindBy(xpath = "(//figure[@class='item--image']//img)[position()<5]")
    private List<WebElement> fiveImages;
    @FindBy(xpath = "//a[@class ='item favorite']")
    private WebElement favoriteItem;

    public ImagePage(WebDriver driver) {
        super(driver);
    }

    public ImagePage createGeneric() {

        return new ImagePage(getDriver());
    }

    @Step("Click first image in images results")
    public ImagePage clickFirstImageInImagesResult() {
        click20(firstImageInImagesResult);
        return this;

    }
    @Step("Click favorite button of image in the side view")
    public ImagePage clickFavoriteButtonOfImageInSideView() {
        click(favoriteButtonInSideImageview);
        return this;
    }
    @Step("Click favorite item")
    public ImagePage clickFavoriteItem() {
        wait10ElementToBeVisible(favoriteItem);
        click(favoriteItem);
        return this;

    }
    @Step("Update page")
    public ImagePage refreshImagePage(){
        refreshPage();
        return new ImagePage(getDriver());
    }
    public ImagePage choiceRegionGermany(){
        selectGermanyRegion();
        return new ImagePage(getDriver());
    }
    public ImagePage loginUsingCookie(){
        clickHamburgerMenu();
        clickSignInMenu();
        return new ImagePage(getDriver());
    }
    @Step("Scroll down to last image")
    public ImagePage scrollToLastImage() throws Throwable {
        scrollByVisibleElementActions(last50Image);
        wait10ElementToBeVisible(last60Image);
        scrollByVisibleElement(last60Image);

        return new ImagePage(getDriver());
    }
    @Step("Get links all images")
    public List <String> getLinksAllImages()  {
        return getTexts(allLinksImages);
    }
    @Step("Get title first image")
    public String getTitleFirstImage()  {
        wait10ElementToBeVisible(h2FirstImage);
        return getText(h2FirstImage);
    }
    @Step("Get attribute alt all images")
    public List<String> getAltAttributeAllImages() {
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
    @Step("Get get title of related search images")
    public String getTitleOfImagesInRelatedSearche() {
        wait10ElementToBeVisible(relatedSearchesImage);
        return getText(relatedSearchesImage);
    }
    @Step("Get attribute first image")
    public String getAttributeFirstImage() {
        wait10ElementToBeVisible(imageAttribute);
        return getAttribute(imageAttribute,"class");
    }
    @Step("Get attribute second image")
    public String getAttributeSecondImage() {
        wait10ElementToBeVisible(secondImageAttribute);
        return getAttribute(secondImageAttribute,"class");
    }
    @Step("Get href attribute of image")
    public String getAttributeHrefOfImage() {
        wait10ElementToBeVisible(imageAttributeHref);
        return getAttribute(imageAttributeHref,"src");
    }
    @Step("Get href attribute of image in side view")
    public String getAttributeHrefImageInSideView() {
        wait10ElementToBeVisible(imageAttributeHrefInSideImageview);
        return getAttribute(imageAttributeHrefInSideImageview,"src");
    }
    @Step("Wait until to be visible ten images")
    public ImagePage waitUtilToBeVisibleTenImages(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        for (WebElement image : tenImages) {
            wait20ElementToBeVisibleJsExecutor(jsExecutor,image);
        }
        return this;
    }
    @Step("Wait until to be visible five images")
    public ImagePage waitUtilToBeVisibleFiveImages(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        for (WebElement image : fiveImages) {
            wait20ElementToBeVisibleJsExecutor(jsExecutor,image);
        }
        return this;
    }
    @Step("Click color button in the filter")
    public ImagePage clickColorButton(){
        click(colorButton);
        return new ImagePage(getDriver());
    }

    public ImagePage clickFilterButton() {
        clickFilterButtonWeb();
        return new ImagePage(getDriver());
    }
    @Step("Click next button of image in the side view")
    public ImagePage clickNextButtonInSideImageview() {
        wait10ElementToBeVisible(nextButtonInSideImageview);
        clickByJavaScript(nextButtonInSideImageview);
        return new ImagePage(getDriver());
    }
    @Step("Click prev button of image in the side view")
    public ImagePage clickPrevButtonInSideImageview() {
        click(prevButtonInSideImageview);
        return new ImagePage(getDriver());
    }
    @Step("Click close button of image in the side view")
    public ImagePage clickCloseButtonInSideImageview() {
        click(closeButtonInSideImageview);
        return new ImagePage(getDriver());
    }
    @Step("Click second query in the related search container")
    public ImagePage clickSecondQueryInRelatedSearchContainer() {
        click20(secondQueryInRelatedSearchContainer);
        waitForUrlContains(ProjectConstants.DOMAIN +"/en/images?query=Ronaldo%");
        return new ImagePage(getDriver());
    }
    @Step("Click next button the related search container")
    public void clickNextButtonInRelatedSearch() {
        wait10ElementToBeVisible(nextButtonInAds);
        clickElementUntilInvisible(nextButtonInAds);
    }
    @Step("Click prev button the related search container")
    public void clickPrevButtonInRelatedSearch() {
        wait10ElementToBeVisible(prevButtonInAds);
        clickElementUntilInvisible(prevButtonInAds);
    }
    @Step("Click Red color in the dropdown list of colors")
    public ImagePage clickRedColorInDropdownListOfColorsFilter() {
        click20(redInDropdownColor);
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/images?query=color&color=Red");
        return new ImagePage(getDriver());
    }
    @Step("Check that last image of ads is dysplaed")
    public boolean lastImageInAdsIsDisplayed() {
        wait10ElementToBeVisible(lastImageInAds);
        return isElementDisplayed(lastImageInAds);

    }
    @Step("Check that first image of ads is dysplaed")
    public boolean firstImageInAdsIsDisplayed() {
        wait10ElementToBeVisible(firstImageInAds);
        return isElementDisplayed(firstImageInAds);

    }
    @Step("Wait until to be visible favorite item")
    public ImagePage waitUntilToBeVisibleFavoriteItem(){
        wait10ElementToBeVisible(favoriteItem);
        return new ImagePage(getDriver());
    }
    public ImagePage choiceDeutschLocalisation(){
        selectDeutschLocalisation();
        return new ImagePage(getDriver());
    }
    @Step("Check that favorite item  is dysplaed on the page")
    public boolean favoriteItemIsDisplayed() {
        return isElementDisplayed(favoriteItem);

    }
    @Step("Check that favorite item  is present on the page")
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
