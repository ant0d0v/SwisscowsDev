package pages.footer_menu;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.FooterMenuPage;

public class ContactUsPage extends FooterMenuPage<ContactUsPage> {

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage createGeneric() {

        return new ContactUsPage(getDriver());
    }
}
