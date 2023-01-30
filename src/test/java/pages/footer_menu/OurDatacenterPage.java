package pages.footer_menu;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.FooterMenuPage;

public class OurDatacenterPage extends FooterMenuPage<OurDatacenterPage> {

    public OurDatacenterPage(WebDriver driver) {
        super(driver);
    }

    public OurDatacenterPage createGeneric() {

        return new OurDatacenterPage(getDriver());
    }
}