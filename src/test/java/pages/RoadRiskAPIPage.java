package pages;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.BreadCrumbPage;

public class RoadRiskAPIPage extends BreadCrumbPage<RoadRiskAPIPage> {

    public RoadRiskAPIPage(WebDriver driver) {
        super(driver);
    }

    public RoadRiskAPIPage createGeneric() {

        return new RoadRiskAPIPage(getDriver());
    }
}
