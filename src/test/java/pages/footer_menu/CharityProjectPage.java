package pages.footer_menu;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.FooterMenuPage;

public class CharityProjectPage extends FooterMenuPage<CharityProjectPage> {
    @FindBy(xpath = "//div/h2[3]")
    private WebElement whereToH2Header;

    @FindBy(xpath = "//div[@class ='swiper-wrapper']/div[2]")
    private WebElement imageCharityProjectFirstBlock;

    @FindBy(xpath = "/html/body/div/div/div/div[3]/div[2]/div[1]/div[2]/span/img")
    private WebElement image;
    @FindBy(xpath = "/html/body/div/div/div/div[3]/div[1]/div[1]/div[2]/span/img")
    private WebElement imageBig;


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
    public CharityProjectPage scrollToImageFirstBlock() {
        scrollByVisibleElement(imageCharityProjectFirstBlock);

        return new CharityProjectPage(getDriver());
    }

    public void clickImageFirstBlock() {
        Actions action = new Actions(getDriver());
        action.doubleClick(image).build().perform();
        getWait10().until(ExpectedConditions.visibilityOf(image));
    }
    public String getClassAttributeOfImage() {
        return getAttribute(imageCharityProjectFirstBlock, "class");
    }


    public boolean elementIsDisplayed() {

        return isElementDisplayed(imageBig);
    }





}


