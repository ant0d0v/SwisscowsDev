package pages;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.FooterMenuPage;

public class OurInitiativesPage extends FooterMenuPage<OurInitiativesPage> {

    public OurInitiativesPage(WebDriver driver) {
        super(driver);
    }

    public OurInitiativesPage createGeneric() {

        return new OurInitiativesPage(getDriver());
    }
}
