package pages.top_menu;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.BreadCrumbPage;

public class HowToStartPage extends BreadCrumbPage<HowToStartPage> {

    public HowToStartPage(WebDriver driver) {
        super(driver);
    }

    public HowToStartPage createGeneric() {

        return new HowToStartPage(getDriver());
    }
}
