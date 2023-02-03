package pages.footer_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import java.util.List;

public class WhoWeArePage extends FooterMenuPage<WhoWeArePage> {

    @FindBy(xpath = "//div[@class ='row narrow static-content']//h1")
    private WebElement WhoWeArePageHeader;

    @FindBy(xpath = "//div/h2")
    private WebElement whereToH2Header;

    @FindBy(xpath = "//div[@class='products']//span")
    private List<WebElement> products;

    public WhoWeArePage(WebDriver driver) {
        super(driver);
    }

    public WhoWeArePage createGeneric() {

        return new WhoWeArePage(getDriver());
    }

    public List<String> getProductsText() {

        return getTexts(products);
    }

    public WhoWeArePage scrollToWhereToH2Header() {
        scrollByVisibleElement(whereToH2Header);

        return this;
    }

    public WhoWeArePage waitForWhoWeArePageHeaderBeVisible() {
        wait10ElementToBeVisible(WhoWeArePageHeader);

        return new WhoWeArePage(getDriver());
    }

    public WhoWeArePage clickAllLinks(int index) {
        click(getAllLinksOnPage().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }

        return createGeneric();
    }


    public WhoWeArePage waitAllOptionsAreVisibleAndClickable() {
        areAllElementsVisibleAndClickable(products);

        return this;
    }
}

