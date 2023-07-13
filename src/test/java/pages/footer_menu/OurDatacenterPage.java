package pages.footer_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.FooterMenuPage;

import java.util.List;

public class OurDatacenterPage extends FooterMenuPage<OurDatacenterPage> {
    @FindBy(xpath = "//div/h2")
    private WebElement whereToH2Header;
    @FindBy(xpath = "//div[@class ='swiper-wrapper']/div[2]")
    private WebElement attributeSecondImageInSlider;
    @FindBy(xpath = "//img[@src ='/_next/image?url=%2Fimages%2Fdatacenter-img2.jpg&w=256&q=75']")
    private WebElement secondImageInSlider;
    @FindBy(xpath = "//img[@src ='/_next/image?url=%2Fimages%2Fdatacenter-img3.jpg&w=1920&q=75']")
    private WebElement bigSecondImageInSlider;


    public OurDatacenterPage(WebDriver driver) {
        super(driver);
    }

    public OurDatacenterPage createGeneric() {

        return new OurDatacenterPage(getDriver());
    }
    @Step("Scroll to h2 header")
    public OurDatacenterPage scrollToWhereToH2Header() {
        scrollByVisibleElement(whereToH2Header);

        return this;
    }
    @Step("Scroll to slider")
    public OurDatacenterPage scrollToSlider() {
        scrollByVisibleElement(attributeSecondImageInSlider);

        return this;
    }
    @Step("Get attribute of image slider")
    public String getClassAttributeOfImageSlider() {
        return getAttribute(attributeSecondImageInSlider, "class");
    }
    @Step("Double click to second image in slider")
    public OurDatacenterPage doubleClickToSecondImageInSlider() {
        Actions action = new Actions(getDriver());
        action.doubleClick(secondImageInSlider).build().perform();
        getWait10().until(ExpectedConditions.visibilityOf(secondImageInSlider));
        return this;
    }
    public OurDatacenterPage playVideoDatacenter()  {
        playVideoCharity();
        return new OurDatacenterPage(getDriver());
    }
    public OurDatacenterPage pauseVideoDatacenter(){
        pauseVideoCharity();
        return new OurDatacenterPage(getDriver());
    }

    public OurDatacenterPage waitUntilTimeOfVideoChanged(long timeMillis) {
        waitUntilTimeOfVideoToBeChanged(timeMillis);
        return new OurDatacenterPage(getDriver());
    }
    @Step("Wait to be visible second image in the slider")
    public OurDatacenterPage waitUntilSecondImageToBeVisible() {
        wait10ElementToBeVisible(bigSecondImageInSlider);
        return new OurDatacenterPage(getDriver());
    }
    @Step("Image is displayed in slider")
    public boolean elementIsDisplayedInSlider() {
        return isElementDisplayed(bigSecondImageInSlider);
    }



}