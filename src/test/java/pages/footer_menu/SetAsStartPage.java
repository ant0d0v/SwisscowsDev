package pages.footer_menu;
import org.openqa.selenium.*;
import pages.base_abstract.FooterMenuPage;

public class SetAsStartPage extends FooterMenuPage<SetAsStartPage> {

    public SetAsStartPage(WebDriver driver) {
        super(driver);
    }

    public SetAsStartPage createGeneric() {

        return new SetAsStartPage(getDriver());
    }

}