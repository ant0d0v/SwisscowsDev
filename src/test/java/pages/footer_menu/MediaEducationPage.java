package pages.footer_menu;
import org.openqa.selenium.*;
import pages.base_abstract.FooterMenuPage;

public class MediaEducationPage extends FooterMenuPage<MediaEducationPage> {

    public MediaEducationPage(WebDriver driver) {
        super(driver);
    }

    public MediaEducationPage createGeneric() {

        return new MediaEducationPage(getDriver());
    }



}

