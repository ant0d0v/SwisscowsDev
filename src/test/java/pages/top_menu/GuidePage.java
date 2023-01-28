package pages.top_menu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.RoadRiskAPIPage;
import pages.SolarRadiationAPIPage;
import pages.base_abstract.BreadCrumbPage;

import java.util.List;

public class GuidePage extends BreadCrumbPage<GuidePage> {

    @FindBy(xpath = "//a[@href='/api/solar-radiation']")
    private WebElement solarRadiationLink;

    @FindBy(xpath = "//h2[contains(text(),'Dedicated weather products')]")
    private WebElement dedicatedWeatherProductsHeader;

    @FindBy(xpath = "//p/a[@href= '/api/road-risk']")
    private WebElement roadRiskAPILink;

    @FindBy(xpath = "//a[text()='Learn more']")
    private List<WebElement> learnMoreButtons;

    public GuidePage(WebDriver driver) {
        super(driver);
    }

    public GuidePage createGeneric() {

        return new GuidePage(getDriver());
    }

    public int countLearnMoreButtons() {

        return getListSize(learnMoreButtons);
    }

    public SolarRadiationAPIPage clickSolarRadiationLink() {
        click(solarRadiationLink);

        return new SolarRadiationAPIPage(getDriver());
    }

    public RoadRiskAPIPage clickRoadRiskAPILink() {
        click(roadRiskAPILink);

        return new RoadRiskAPIPage(getDriver());
    }

    public GuidePage scrollToDedicatedWeatherProducts() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", dedicatedWeatherProductsHeader);
        return this;
    }
}
