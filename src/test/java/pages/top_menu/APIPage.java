package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.APIOneCall3Page;
import pages.base_abstract.BreadCrumbPage;

import java.util.List;

public class APIPage extends BreadCrumbPage<APIPage> {

    @FindBy(xpath = "//a[contains(@class,'orange')]")
    private List<WebElement> orangeButtons;

    @FindBy(xpath = "//a[@href='/api/one-call-3'][text()='API doc']")
    private WebElement APIDocButton;

    @FindBy(xpath = "//a[@href]")
    private List<WebElement> links;

    public APIPage(WebDriver driver) {
        super(driver);
    }

    public APIPage createGeneric() {

        return new APIPage(getDriver());
    }

    public int getOrangeButtonsAmount() {

        return getListSize(orangeButtons);
    }

    public APIOneCall3Page clickAPIDocButton() {
        click(APIDocButton);

        return new APIOneCall3Page(getDriver());
    }

    public List<WebElement> getHTTPSLinks() {

        return getAllHTTPSLinks(links);
    }
}
