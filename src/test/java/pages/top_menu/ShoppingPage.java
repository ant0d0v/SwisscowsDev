package pages.top_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;
import utils.ProjectConstants;

import java.util.Collections;
import java.util.List;

public class ShoppingPage extends TopMenuPage<ShoppingPage> {
    @FindBy(xpath = "//div[@class='shopping-results']")
    private WebElement shoppingResultContainer;
    @FindBy(xpath = "//h2[@class = 'title']")
    private WebElement h2Shopping;
    @FindBy(xpath = "//h2[@class = 'title']")
    private List<WebElement> h2TextShopping;

    @FindBy(xpath = "//div['shopping-results']//ul[@class]//li[3]")
    private WebElement thirdPagePagination;
    @FindBy(xpath = "//figure//img[1]")
    private WebElement firstImageInImagesResult;
    @FindBy(xpath = "//div['shopping-results']//ul[@class]//li[4]")
    private WebElement attributeThirdPagePagination;
    @FindBy(xpath = "//div['shopping-results']//ul[@class]//li[3]")
    private WebElement attributeSecondPagePagination;
    @FindBy(xpath = "//div['shopping-results']//ul[@class]//li[1]")
    private WebElement previousPagePagination;
    @FindBy(xpath = "//div['shopping-results']//ul[@class]//li[last()]")
    private WebElement nextPagePagination;
    @FindBy(xpath = "//div[@class = 'details-pane']//img")
    private WebElement detailsPanel;
    @FindBy(xpath = "//div[@class = 'details-pane']")
    private WebElement detailsContainer;
    @FindBy(xpath = "(//a[text() ='See all offers'])[position() < 2]")
    private WebElement seeAllOffersLink;
    @FindBy(xpath = "//section[@class ='section offers']//a[1]")
    private WebElement firstShopInDetailsPanel;
    @FindBy(xpath = "//h3[@title ='Marken']")
    private WebElement modelDropdown;
    @FindBy(xpath = "//div[@class = 'filter']//ul//li[text() = 'Apple']")
    private WebElement appleModel;
    @FindBy(xpath = "//section[@class ='section offers']//a")
    private List<WebElement> shopsInDetailsPanel;
    @FindBy(xpath = "//div[@class = 'scroller']//h3")
    private List<WebElement> h3TextInFilter;

    public ShoppingPage(WebDriver driver) {
        super(driver);
    }
    public ShoppingPage createGeneric() {

        return new ShoppingPage(getDriver());
    }
    @Step("Wait until the news search results are visible")
    public ShoppingPage waitUntilVisibilityShoppingResult() {
        wait20ElementToBeVisible(shoppingResultContainer);

        return new ShoppingPage(getDriver());
    }
    public ShoppingPage selectBrazilRegion() {
        selectRegionBrazil();
        return new ShoppingPage(getDriver());
    }
    public ShoppingPage waitVisibilityErrorImage() {
        waitUntilVisibilityErrorImage();
        return new ShoppingPage(getDriver());
    }
    @Step("Get the title text of the shopping page")
    public String getTitleShopping()  {
        wait10ElementToBeVisible( h2Shopping);
        return getText( h2Shopping);
    }
    public ShoppingPage refreshShoppingPage(){
        refreshPage();
        return new ShoppingPage(getDriver());
    }
    @Step("Get the title text of the shopping page")
    public List<String> getH2TextShoppingResult()  {
        try {
            return getTexts(h2TextShopping);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            return getTexts(h2TextShopping);
        }

    }

    public ShoppingPage waitUntilToBeInvisibleDetailsPanel() {
        wait10ElementToBeInVisible(detailsContainer);
        return new ShoppingPage(getDriver());
    }
    public ShoppingPage waitUntilToBeVisibleDetailsPanel() {
        wait10ElementToBeVisible(detailsPanel);
        return new ShoppingPage(getDriver());
    }
    public ShoppingPage clickFilterButton() {
        clickFilterButtonWeb();
        return new ShoppingPage(getDriver());
    }
    public ShoppingPage clickModelDropdown() {
        click(modelDropdown);
        return new ShoppingPage(getDriver());
    }
    public ShoppingPage clickAppleModel() {
        click(appleModel);
        return new ShoppingPage(getDriver());
    }

    @Step("Get attribute first image")
    public boolean detailsPanelIsDysplaed() {
        return detailsContainer.isDisplayed();
    }
    public ShoppingPage clickFirstShopInDetailPanel(){
        click(firstShopInDetailsPanel);
        return new ShoppingPage(getDriver());
    }
    public int getCountShopsInDetailsPanel(){
        int count = 0;
        for(WebElement element : shopsInDetailsPanel){
            wait10ElementToBeVisible(element);
            if(element.isEnabled()){
                count = getListSize(shopsInDetailsPanel);
            }
        }
        return  count;
    }
    public ShoppingPage waitToBeVisibleFirstFiveImage(){
        waitUtilToBeVisibleFiveImages();
        return new ShoppingPage(getDriver());
    }
    public List<String> getH3TextsInTheFilter(){
        return getTexts(h3TextInFilter);

    }

    public ShoppingPage clickCloseIconInSideImageview(){
        clickCloseButtonInSideImageview();
        return new ShoppingPage(getDriver());
    }
    public ShoppingPage clickFirstImageInShoppingResult(){
        clickFirstImageInResult();
        return new ShoppingPage(getDriver());
    }
    public ShoppingPage clickFirstLink_SeeAllOffers(){
        click(seeAllOffersLink);
        return new ShoppingPage(getDriver());
    }

    public ShoppingPage waitUntilLoaderToBeInVisible(){
        waitForLoaderToBeInVisible();
        return new ShoppingPage(getDriver());
    }

    @Step("Click third number in pagination")
    public ShoppingPage clickThirdPagePagination() {
        click(thirdPagePagination);
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/shopping?query=laptop&region=de-DE&offset=48");
        return new ShoppingPage(getDriver());
    }
    @Step("Click previous button in pagination")
    public ShoppingPage clickPreviousPagePagination() {
        click(previousPagePagination);
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/shopping?query=laptop&region=de-DE");

        return new ShoppingPage(getDriver());
    }
    @Step("Click next button in pagination")
    public ShoppingPage clickNextPagePagination() {
        click20(nextPagePagination);
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/shopping?query=laptop&region=de-DE&offset=24");
        return new ShoppingPage(getDriver());
    }
    @Step("Get attribute third number in the pagination")
    public String getAttributeThirdButtonPagination() {
        return getAttribute(attributeThirdPagePagination,"class");
    }
    @Step("Get attribute second number in the pagination")
    public String getAttributeSecondButtonPagination() {

        return getAttribute(attributeSecondPagePagination,"class");
    }
    @Step("Wait url to be changed")
    public ShoppingPage waitUntilUrlToBeChanged(String parametr){
        waitForUrlContains(ProjectConstants.DOMAIN +parametr);
        return new  ShoppingPage(getDriver());
    }
    public ShoppingPage waitUntilToBeInVisibleLoader(){
        waitForLoaderToBeInVisible();
        return new ShoppingPage(getDriver());
    }
}
