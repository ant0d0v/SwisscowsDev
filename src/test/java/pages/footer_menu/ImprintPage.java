package pages.footer_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import java.util.List;

public class ImprintPage extends FooterMenuPage<ImprintPage> {
    @FindBy(xpath = "//img[@src='/_next/image?url=%2Fimages%2Fimprint-img.png&w=1920&q=75']")
    private WebElement imageSwisscows;
    @FindBy(xpath = "//p//span")
    private List<WebElement> listTextsOnPage;
    public ImprintPage createGeneric() {

        return new ImprintPage(getDriver());
    }
    public ImprintPage(WebDriver driver) {
        super(driver);
    }
    public boolean elementIsDisplayedImageSwisscows() {

        return isElementDisplayed(imageSwisscows);
    }
    public List<String> getTextsOnPage() {

        return getTexts(listTextsOnPage);
    }

    public List<String> getTextsFontSizes(){
        return  getFontSizes(listTextsOnPage);

    }

}
