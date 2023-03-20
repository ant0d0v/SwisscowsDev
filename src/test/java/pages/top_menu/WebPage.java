package pages.top_menu;

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

    public String getH2FontSize(){
        return  getFontSize(h2Text);

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


}
