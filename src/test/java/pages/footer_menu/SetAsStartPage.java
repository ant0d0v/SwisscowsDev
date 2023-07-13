package pages.footer_menu;
import io.qase.api.annotation.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import pages.base_abstract.FooterMenuPage;

import java.util.List;

public class SetAsStartPage extends FooterMenuPage<SetAsStartPage> {
    @FindBy(xpath = "//a[@class='draglinks']")
    private WebElement dragLink;
    @FindBy(xpath = "//div[@class = 'row narrow static-content']//img")
    private List<WebElement> allImageOnPageSetAsPage;
    public SetAsStartPage(WebDriver driver) {
        super(driver);
    }

    public SetAsStartPage createGeneric() {

        return new SetAsStartPage(getDriver());
    }
    public MainPage clickDragLink(){
        click20(dragLink);
        return new MainPage(getDriver());
    }
    @Step("Check that elements are displayed ")
    public boolean allElementsDisplayed() {
        return areElementsInListDisplayed(allImageOnPageSetAsPage);
    }


}