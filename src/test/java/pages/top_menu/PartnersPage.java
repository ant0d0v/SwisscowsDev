package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.BreadCrumbPage;

import java.util.List;

public class PartnersPage extends BreadCrumbPage<PartnersPage> {

    @FindBy(xpath = "//a[@href='#apache']")
    private WebElement apacheCamellink;

    @FindBy(xpath = "//a[@href='http://camel.apache.org/weather.html']")
    private WebElement seeOnWebsiteButton;

    @FindBy(xpath = "//div[@class = 'doc-container']//li")
    private List<WebElement> rightSideLinks;

    public PartnersPage(WebDriver driver) {
        super(driver);
    }

    public PartnersPage createGeneric() {

        return new PartnersPage(getDriver());
    }

    public List<String> getRightSideLinksText() {

        return getTexts(rightSideLinks);
    }

    public PartnersPage clickApacheCamelLink() {
        click20(apacheCamellink);

        return this;
    }

    public void clickSeeOnWebsiteButton() {
        click20(seeOnWebsiteButton);
    }
}
