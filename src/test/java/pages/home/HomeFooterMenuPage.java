package pages.home;

import org.openqa.selenium.WebDriver;

public abstract class HomeFooterMenuPage<Generic> extends HomeTopMenuPage {

    public HomeFooterMenuPage(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();
}
