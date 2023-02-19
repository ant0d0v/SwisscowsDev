package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;

import java.util.List;

public class WebPage extends TopMenuPage<WebPage> {
    @FindBy(xpath = "//div[@class='web-results']//article")
    private WebElement webResultContainer;
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
}
