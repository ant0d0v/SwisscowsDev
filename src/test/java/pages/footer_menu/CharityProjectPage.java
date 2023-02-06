package pages.footer_menu;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class CharityProjectPage extends FooterMenuPage<CharityProjectPage> {
    @FindBy(xpath = "//div/h2[3]")
    private WebElement whereToH2Header;
    public CharityProjectPage(WebDriver driver) {
        super(driver);
    }

    public CharityProjectPage createGeneric() {

        return new CharityProjectPage(getDriver());
    }

    /*public long getDurationOfVideo() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        return (Long) executor.executeScript("return arguments[0].duration", videoPlayer);
    }*/

    public CharityProjectPage scrollToWhereToH2Header() {
        scrollByVisibleElement(whereToH2Header);

        return this;
    }



}


