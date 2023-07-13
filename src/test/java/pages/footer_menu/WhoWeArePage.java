package pages.footer_menu;

import io.qase.api.annotation.Step;
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

    @Step("Scroll to h2 header")
    public WhoWeArePage scrollToWhereToH2Header() {
        scrollByVisibleElement(whereToH2Header);

        return this;
    }


}

