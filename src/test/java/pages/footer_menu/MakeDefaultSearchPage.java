package pages.footer_menu;
import org.openqa.selenium.*;
import pages.base_abstract.FooterMenuPage;

public class MakeDefaultSearchPage extends FooterMenuPage<MakeDefaultSearchPage> {

    public MakeDefaultSearchPage(WebDriver driver) {
        super(driver);
    }

    public MakeDefaultSearchPage createGeneric() {

        return new MakeDefaultSearchPage(getDriver());
    }

}