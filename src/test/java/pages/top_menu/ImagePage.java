package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.TopMenuPage;

import java.util.ArrayList;
import java.util.List;

public class ImagePage extends TopMenuPage<ImagePage> {
    @FindBy(xpath = "//div[@class='images-results']//figure")
    private WebElement firstImageInImagesResult;
    @FindBy(xpath = "//h2[@class = 'title']")
    private WebElement h2FirstImage;
    @FindBy(xpath = "//figure//a//img")
    private List<WebElement> AltAttributeAllImage;
    @FindBy(xpath = "//figure[40]")
    private WebElement lastImage;
    @FindBy(xpath = "//div[@class='button-menu'][2]")
    private WebElement sizeButton;
    @FindBy(xpath = "//div[@class][2]//li[2]")
    private WebElement SmallInDropdownSize;
    @FindBy(xpath = "//figure[1]")
    private WebElement imageAttribute;
    @FindBy(xpath = "//figure//a")
    private List<WebElement> allLinksImages;
    @FindBy(xpath = "//div[@class='images-results']//button[@class][2]")
    private WebElement nextButtonInAds;
    @FindBy(xpath = "//div[@class='images-results']//button[@class][1]")
    private WebElement prevButtonInAds;
    @FindBy(xpath = "//div[@class='widget-slider']//div[last()]/article/a[1]/figure")
    private WebElement lastImageInAds;
    @FindBy(xpath = "//div[@class='widget-slider']//div[2]/article/a[1]/figure/img")
    private WebElement firstImageInAds;
    @FindBy(xpath = "(//section//div[@class ='related-queries']//a)[position() < 6]")
    private List<WebElement> relatedSearchesImages;
    @FindBy(xpath = "//div[@class='widget-slider']//img")
    private List<WebElement> adsImages;
    @FindBy(xpath = "//div[@class='related-queries']//a[2]")
    private WebElement secondQueryInRelatedSearchContainer;
    @FindBy(xpath = "//button[@class='search-submit']")
    private WebElement searchButton;
    @FindBy(xpath = "//div[@class='three-bounce']")
    private WebElement loader;



    public ImagePage(WebDriver driver) {
        super(driver);
    }

    public ImagePage createGeneric() {

        return new ImagePage(getDriver());
    }
    public ImagePage clickFirstImageInImagesResult() {
        wait20ElementToBeVisible(firstImageInImagesResult);
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
    public List<String> getTitleInRelatedSearchesImages() {

        return getTexts(relatedSearchesImages);
    }
    public String getAttributeAllImage() {
        waitForElementIsDisappeared(loader);
        return getAttribute(imageAttribute,"style");
    }
    public ImagePage clickSizeButton() {
        click(sizeButton);
        return new ImagePage(getDriver());
    }
    public ImagePage clickSecondQueryInRelatedSearchContainer() {
        click(secondQueryInRelatedSearchContainer);
        return new ImagePage(getDriver());
    }
    public void clickNextButton() {

        clickElementUntilInvisible(nextButtonInAds);
    }
    public void clickPrevButton() {

        clickElementUntilInvisible(prevButtonInAds);
    }

    public ImagePage clickSmallSizeInDropdownSize() {
        click(SmallInDropdownSize);
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