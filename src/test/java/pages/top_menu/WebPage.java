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


}
