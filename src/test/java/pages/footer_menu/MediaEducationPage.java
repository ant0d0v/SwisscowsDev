package pages.footer_menu;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;



public class MediaEducationPage extends FooterMenuPage<MediaEducationPage> {
    @FindBy(xpath = "//p//a[@href = '/docs/Medienerziehung_2020_06_EN.pdf'][1]")
    private WebElement linkPdf;
    @FindBy(xpath = "//div[@class = 'brochure-wrap']//a[@href='/docs/Medienerziehung_2020_06_EN.pdf']")
    private WebElement buttonOpenFlyer;
    public MediaEducationPage(WebDriver driver) {
        super(driver);
    }

    public MediaEducationPage createGeneric() {

        return new MediaEducationPage(getDriver());
    }
    public MediaEducationPage scrollToWhereToLinkPdf() {
        scrollByVisibleElement(linkPdf);

        return this;
    }
    public MediaEducationPage scrollToWhereToButtonOpenFlyer() {
        scrollByVisibleElement(buttonOpenFlyer);

        return this;
    }
    public MediaEducationPage clickLinkPdf() {
        click(linkPdf);
        return this;
    }

    public MediaEducationPage clickButtonOpenFlyer() {
        click(buttonOpenFlyer);
        return this;
    }




}

