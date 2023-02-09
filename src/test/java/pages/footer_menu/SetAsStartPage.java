package pages.footer_menu;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import pages.base_abstract.FooterMenuPage;

public class SetAsStartPage extends FooterMenuPage<SetAsStartPage> {
    @FindBy(xpath = "//a[@class='draglinks']")
    private WebElement dragLink;
    @FindBy(xpath = "//div[@class ='menu-dropdown-button'][1]")
    private WebElement LangDropDownIcon;
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


}