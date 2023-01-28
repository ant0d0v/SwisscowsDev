package pages;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.BreadCrumbPage;

public class SolarRadiationAPIPage extends BreadCrumbPage<SolarRadiationAPIPage> {

    public SolarRadiationAPIPage(WebDriver driver) {
        super(driver);
    }

    public SolarRadiationAPIPage createGeneric() {

        return new SolarRadiationAPIPage(getDriver());
    }
}
