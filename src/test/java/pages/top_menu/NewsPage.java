package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;

import java.util.List;

public class NewsPage extends TopMenuPage<NewsPage> {
    @FindBy(xpath = "//div[@class='news-results']//figure")
    private WebElement newsResultContainer;
    @FindBy(xpath = "//h2[@class = 'title']")
    private WebElement h2News;
    @FindBy(xpath = "//ul[@class='menu-dropdown-list']//li[5]")
    private WebElement regionBrazil;
    @FindBy(xpath = "//div[@class='image']//img")
    private WebElement errorImage;
    @FindBy(xpath = "//figure//img")
    private List<WebElement> allImageNewsPage;
    @FindBy(xpath = "//ul[@class='pagination']//li[3]")
    private WebElement secondPagePagination;
    @FindBy(xpath = "//h2[@class = 'title']")
    private List<WebElement> h2Texts;
    @FindBy(xpath = "//div['news-results']//ul[@class]//li[3]")
    private WebElement thirdPagePagination;
    @FindBy(xpath = "//div['news-results']//ul[@class]//li[4]")
    private WebElement attributeThirdPagePagination;
    @FindBy(xpath = "//div['news-results']//ul[@class]//li[3]")
    private WebElement attributeSecondPagePagination;
    @FindBy(xpath = "//div['news-results']//ul[@class]//li[1]")
    private WebElement previousPagePagination;
    @FindBy(xpath = "//div['news-results']//ul[@class]//li[last()]")
    private WebElement nextPagePagination;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public NewsPage createGeneric() {

        return new NewsPage(getDriver());
    }
    public NewsPage waitUntilVisibilityNewsResult() {
        wait20ElementToBeVisible(newsResultContainer);

        return new NewsPage(getDriver());
    }
    public NewsPage waitUntilVisibilityErrorImage() {
        wait20ElementToBeVisible(errorImage);

        return new NewsPage(getDriver());
    }
    public String getTitleNews()  {

        return getText(h2News);
    }
    public List<String> getTitleH2Texts()  {

        return getTexts(h2Texts);
    }
    public String getH2FontSize(){
        return  getFontSize(h2News);

    }
    public NewsPage clickRegionBrazil() {
        click(regionBrazil);

        return new NewsPage(getDriver());
    }
    public NewsPage clickFirstPost() {
        click(h2News);

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
    public NewsPage clickThirdPagePagination() {
        click(thirdPagePagination);

        return new NewsPage(getDriver());
    }
    public NewsPage clickPreviousPagePagination() {
        click(previousPagePagination);

        return new NewsPage(getDriver());
    }
    public NewsPage clickNextPagePagination() {
        click(nextPagePagination);

        return new NewsPage(getDriver());
    }

    public String getAttributeThirdButtonPagination() {

        return getAttribute(attributeThirdPagePagination,"class");
    }
    public String getAttributeSecondButtonPagination() {

        return getAttribute(attributeSecondPagePagination,"class");
    }

}