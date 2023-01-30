package pages.footer_menu;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.FooterMenuPage;

public class CharityProjectPage extends FooterMenuPage<CharityProjectPage> {

    public CharityProjectPage(WebDriver driver) {
        super(driver);
    }

    public CharityProjectPage createGeneric() {

        return new CharityProjectPage(getDriver());
    }
}