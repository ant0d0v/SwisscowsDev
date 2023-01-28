package pages.footer_menu;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.FooterMenuPage;

public class TechnologyPage extends FooterMenuPage<TechnologyPage> {

    public TechnologyPage(WebDriver driver) {
        super(driver);
    }

    public TechnologyPage createGeneric() {

        return new TechnologyPage(getDriver());
    }
}
