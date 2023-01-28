package pages.footer_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.FooterMenuPage;

import java.util.ArrayList;
import java.util.List;

public class WidgetsPage extends FooterMenuPage<WidgetsPage> {

    @FindBy(id = "api-key")
    private WebElement yourAPIKeyField;

    @FindBy(id = "city-name")
    private WebElement yourCityNameField;

    @FindBy(id = "search-city")
    private WebElement searchCityButton;

    @FindBy(xpath = "//div[@class='widget-left-menu__layout']/h2")
    private WebElement biggerWidgetCityName;

    @FindBy(xpath = "//ul[@id='city-list']//span")
    private List<WebElement> selectYourCity;

    @FindBy(xpath = "//div[@id=\"cities\"]/ul/li[1]//span")
    private WebElement cityFromSelectYourCityList;

    @FindBy(id = "error-key")
    private WebElement apiKeyErrorMessage;

    @FindBy(xpath = "//div[@class = 'widget-right__title']")
    private List<WebElement> rightWidgets;

    @FindBy(xpath = "//h2[@class = 'widget-right__title']")
    private List<WebElement> middleWidgets;

    @FindBy(xpath = "//h2[@class = 'widget-left-menu__header']")
    private List<WebElement> leftWidgets;

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    public WidgetsPage createGeneric() {

        return new WidgetsPage(getDriver());
    }

    public String getCityName() {

        return getText(cityFromSelectYourCityList);
    }

    public List<String> getSelectedCityTexts() {
        getWait20().until(ExpectedConditions.visibilityOfAllElements(selectYourCity));
        for (WebElement element : selectYourCity) {
            waitForTextNotToBeEmpty(element);
        }

        return getTexts(selectYourCity);
    }

    public String getCityNameWidget() {

        return getText(biggerWidgetCityName);
    }

    public List<String> getAllWidgetsCityName() {

        return getTexts(getWidgets());
    }

    public List<WebElement> getWidgets() {
        List<WebElement> widgets = new ArrayList<>();
        widgets.addAll(rightWidgets);
        widgets.addAll(middleWidgets);
        widgets.addAll(leftWidgets);

        return widgets;
    }

    public String getErrorMessage() {

        return getText(apiKeyErrorMessage);
    }

    public WidgetsPage clickSearchCityButton() {
        click(searchCityButton);

        return this;
    }

    public WidgetsPage inputYourAPIKey(String key) {
        inputAfterClear(yourAPIKeyField, key);

        return this;
    }

    public WidgetsPage inputYourCityName(String city) {
        inputAfterClear(yourCityNameField, city);

        return this;
    }

    public WidgetsPage waitCityFromSelectCityToBeChanged(String oldCity) {
        waitTextToBeChanged(cityFromSelectYourCityList, oldCity);

        return this;
    }

    public WidgetsPage waitCityToBeChanged(String oldCity) {
        waitTextToBeChanged(biggerWidgetCityName, oldCity);

        return this;
    }

    public WidgetsPage waitForBiggerWidgetToAppear() {
        wait20ElementToBeVisible(biggerWidgetCityName);

        return this;
    }
}
