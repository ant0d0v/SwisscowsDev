package pages.footer_menu;
import io.qase.api.annotation.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import java.util.List;

public class MakeDefaultSearchPage extends FooterMenuPage<MakeDefaultSearchPage> {
    @FindBy(xpath = "//img[@src='/_next/image?url=%2Fimages%2Fbrowsers%2Fopera-instruction.gif&w=1920&q=75']")
    private WebElement animationImage;
    @FindBy(xpath = "//div[@class = 'row narrow static-content']//img")
    private List<WebElement> allImageOnPageMakePage;
    @FindBy(xpath = "//a[@class='button']")
    private List<WebElement> allButtonsOnMakeDefaultPage;
    @FindBy(xpath = "//h2[text()='Tor']")
    private WebElement h2Tor;
    public MakeDefaultSearchPage(WebDriver driver) {
        super(driver);
    }

    public MakeDefaultSearchPage createGeneric() {

        return new MakeDefaultSearchPage(getDriver());
    }
    @Step("Scroll to where h2 tor")
    public  MakeDefaultSearchPage scrollToWhereH2Tor() {
        scrollByVisibleElement(h2Tor);
        return this;
    }
    @Step("Wait to be visible animation images ")
    public MakeDefaultSearchPage waitToBeVisibleAnimationImage(){
        wait10ElementToBeVisible(animationImage);
        return new MakeDefaultSearchPage(getDriver());
    }
    @Step("Check that animation images are dysplaed")
    public boolean elementIsDisplayedAnimationImage() {
        return isElementDisplayed(animationImage);
    }
    @Step("Check that all images are dysplaed ")
    public boolean allElementsDisplayed() {
        return areElementsInListDisplayed(allImageOnPageMakePage);
    }
    @Step("Get the button colors when hover")
    public List<String> getButtonColorsWhenHover() throws InterruptedException {

        return  getBackgroundHoverColorsOfElements(allButtonsOnMakeDefaultPage);
    }
    @Step("Get the button colors without hover")
    public List<String> getButtonColors() throws InterruptedException {
        return  getBackgroundColorsOfElements(allButtonsOnMakeDefaultPage);
    }



}