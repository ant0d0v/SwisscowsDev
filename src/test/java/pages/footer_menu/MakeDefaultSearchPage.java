package pages.footer_menu;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class MakeDefaultSearchPage extends FooterMenuPage<MakeDefaultSearchPage> {
    @FindBy(xpath = "//img[@src='/_next/image?url=%2Fimages%2Fbrowsers%2Fopera-instruction.gif&w=1920&q=75']")
    private WebElement animationImage;
    @FindBy(xpath = "//h2[text()='Tor']")
    private WebElement h2Tor;
    public MakeDefaultSearchPage(WebDriver driver) {
        super(driver);
    }

    public MakeDefaultSearchPage createGeneric() {

        return new MakeDefaultSearchPage(getDriver());
    }
    public  MakeDefaultSearchPage scrollToWhereH2Tor() {
        scrollByVisibleElement(h2Tor);

        return this;
    }
    public boolean elementIsDisplayedAnimationImage() {

        return isElementDisplayed(animationImage);
    }

}