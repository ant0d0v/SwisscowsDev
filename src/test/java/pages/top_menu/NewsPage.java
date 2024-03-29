package pages.top_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;
import utils.ProjectConstants;

import java.util.List;

public class NewsPage extends TopMenuPage<NewsPage> {
    @FindBy(xpath = "//div[@class='news-results']")
    private WebElement newsResultContainer;
    @FindBy(xpath = "//h2[@class = 'title']")
    private WebElement h2News;

    @FindBy(xpath = "//figure//img")
    private List<WebElement> allImageNewsPage;
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
    @FindBy(className ="three-bounce")
    private WebElement loader;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public NewsPage createGeneric() {

        return new NewsPage(getDriver());
    }
    @Step("Wait until the news search results are visible")
    public NewsPage waitUntilVisibilityNewsResult() {
        wait20ElementToBeVisible(newsResultContainer);

        return new NewsPage(getDriver());
    }

    @Step("Get the title text of the news page")
    public String getTitleNews()  {
        wait10ElementToBeVisible(h2News);
        return getText(h2News);
    }
    public List<String> getTitleH2Texts()  {

        return getTexts(h2Texts);
    }
    @Step("Get the font size of the title text")
    public String getH2FontSize(){
        return  getFontSize(h2News);
    }

    public NewsPage clickFirstPost() {
        click(h2News);
        switchToAnotherWindow();

        return new NewsPage(getDriver());
    }

    @Step("Check that all images are dysplaed")
    public boolean  allImageIsDisplayed() {
        for (WebElement image : allImageNewsPage) {
                wait10ElementToBeVisible(image);
        }

        return areElementsInListDisplayed(allImageNewsPage);
    }

    @Step("Click third number in pagination")
    public NewsPage clickThirdPagePagination() {
        click(thirdPagePagination);
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/news?query=ronaldo&region=de-DE&offset=20");
        return new NewsPage(getDriver());
    }
    @Step("Click previous button in pagination")
    public NewsPage clickPreviousPagePagination() {
        click(previousPagePagination);
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/news?query=ronaldo&region=de-DE");

        return new NewsPage(getDriver());
    }
    @Step("Click next button in pagination")
    public NewsPage clickNextPagePagination() {
        click20(nextPagePagination);
        waitForUrlContains(ProjectConstants.DOMAIN + "/en/news?query=ronaldo&region=de-DE&offset=10");
        return new NewsPage(getDriver());
    }
    @Step("Get attribute third number in the pagination")
    public String getAttributeThirdButtonPagination() {
        return getAttribute(attributeThirdPagePagination,"class");
    }
    @Step("Get attribute second number in the pagination")
    public String getAttributeSecondButtonPagination() {

        return getAttribute(attributeSecondPagePagination,"class");
    }
    public NewsPage waitUntilToBeInVisibleLoader(){
        waitForLoaderToBeInVisible();
        return new NewsPage(getDriver());
    }
    @Step("Wait url to be changed")
    public NewsPage waitUntilUrlToBeChanged(String parametr){
        waitForUrlContains(ProjectConstants.DOMAIN +parametr);
        return new  NewsPage(getDriver());
    }

}