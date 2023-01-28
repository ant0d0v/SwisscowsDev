package pages.footer_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import java.util.List;

public class AboutUsPage extends FooterMenuPage<AboutUsPage> {

    @FindBy(xpath = "//div[@class='about-us']//h1")
    private WebElement aboutUsPageHeader;

    @FindBy(xpath = "//h2[text()='Where-to']")
    private WebElement whereToH2Header;

    @FindBy(xpath = "//a[@class='btn_block orange round']")
    private List<WebElement> optionsUnderWhereTo;

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    public AboutUsPage createGeneric() {

        return new AboutUsPage(getDriver());
    }

    public List<String> getOptionsText() {

        return getTexts(optionsUnderWhereTo);
    }

    public String getTextH1Header(){
        return getText(aboutUsPageHeader);
    }

    public AboutUsPage scrollToWhereTo() {
        scrollByVisibleElement(whereToH2Header);

        return this;
    }

    public AboutUsPage waitForAboutUsPageHeaderBeVisible() {
        wait10ElementToBeVisible(aboutUsPageHeader);

        return new AboutUsPage(getDriver());
    }

    public AboutUsPage waitAllOptionsAreVisibleAndClickable() {
        areAllElementsVisibleAndClickable(optionsUnderWhereTo);

        return this;
    }
}
