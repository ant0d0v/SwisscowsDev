package pages.footer_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.FooterMenuPage;

public class CharityProjectPage extends FooterMenuPage<CharityProjectPage> {
    @FindBy(xpath = "//div/h2[3]")
    private WebElement whereToH2Header;

    @FindBy(xpath = "//div[@class ='swiper-wrapper']/div[2]")
    private WebElement attributeSecondImageInFirstSlider;

    @FindBy(xpath = "//div[@class = 'static-slider'][2]//div[@class ='swiper-wrapper']/div[3]")
    private WebElement attributeThirdImageInSecondSlider;

    @FindBy(xpath = "/html/body/div/div/div/div[3]/div[2]/div[1]/div[2]/span/img")
    private WebElement secondImageInSlider;

    @FindBy(xpath = "//img[@src = '/_next/image?url=%2Fimages%2Fcolumbia-img3.jpg&w=256&q=75']")
    private WebElement thirdImageInSlider;
    @FindBy(xpath = "//img[@src ='/_next/image?url=%2Fimages%2Fhaiti-img3.jpg&w=1920&q=75']")
    private WebElement bigTwoImageInSlider;

    @FindBy(xpath = "//img[@src = '/_next/image?url=%2Fimages%2Fcolumbia-img5.jpg&w=1920&q=75']")
    private WebElement bigThirdImageInSlider;


    public CharityProjectPage(WebDriver driver) {
        super(driver);
    }

    public CharityProjectPage createGeneric() {

        return new CharityProjectPage(getDriver());
    }
    @Step("Scroll to the desired section where the links are located (")
    public CharityProjectPage scrollToWhereToH2Header() {
        scrollByVisibleElement(whereToH2Header);

        return this;
    }
    @Step("Scroll to the first slider.")
    public CharityProjectPage scrollToFirstSlider() {
        scrollByVisibleElement(attributeSecondImageInFirstSlider);
        return new CharityProjectPage(getDriver());
    }
    public CharityProjectPage scrollToSecondSlider() {
        scrollByVisibleElement(attributeThirdImageInSecondSlider);

        return new CharityProjectPage(getDriver());
    }
    @Step("double-clicking on the second image")
    public CharityProjectPage doubleClickToSecondImageInSlider() {
        Actions action = new Actions(getDriver());
        action.doubleClick(secondImageInSlider).build().perform();
        getWait10().until(ExpectedConditions.visibilityOf(secondImageInSlider));
        return this;
    }
    @Step("double-clicking on the third image")
    public CharityProjectPage doubleClickToThirdImageInSlider() {
        Actions action = new Actions(getDriver());
        action.doubleClick(thirdImageInSlider).build().perform();
        getWait10().until(ExpectedConditions.visibilityOf(thirdImageInSlider));
        return this;
    }
    @Step("Get the  attribute of the image in the first slider")
    public String getClassAttributeOfImageInFirstSlider() {
        return getAttribute(attributeSecondImageInFirstSlider, "class");
    }

    public String getClassAttributeOfImageInSecondSlider() {
        return getAttribute(attributeThirdImageInSecondSlider, "class");
    }
    @Step("Waiting for two images to be visible")
    public CharityProjectPage waitUntilTwoImageInTheSliderToBeVisible(){
        wait10ElementToBeVisible(bigTwoImageInSlider);
        return new CharityProjectPage(getDriver());
    }
    public CharityProjectPage waitUntilThirdImageInTheSliderToBeVisible(){
        wait10ElementToBeVisible(bigThirdImageInSlider);
        return new CharityProjectPage(getDriver());
    }


    public boolean elementIsDisplayedFirstSlider() {

        return isElementDisplayed(bigTwoImageInSlider);
    }

    public boolean elementIsDisplayedInSecondSlider() {

        return isElementDisplayed(bigThirdImageInSlider);
    }





}


