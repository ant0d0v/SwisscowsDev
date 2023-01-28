package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.FooterMenuPage;
import utils.DateTimeUtils;
import utils.TestUtils;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static utils.TestUtils.convertStringToInt;

public class MainPage extends FooterMenuPage<MainPage> {

    @FindBy(className = "owm-loader-container")
    private WebElement greyContainer;

    @FindBy(xpath = "//div[@id = 'weather-widget']//h2")
    private WebElement h2CityCountryHeader;

    @FindBy(xpath = "//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
    private WebElement searchCityField;

    @FindBy(xpath = "//div[@id = 'weather-widget']//button[@type = 'submit']")
    private WebElement searchButton;

    @FindBy(className = "search-dropdown-menu")
    private WebElement searchDropdownMenu;

    @FindBy(xpath = "//div[@class='mobile-padding']/h1/span")
    private WebElement colorAndFontSizeOfH1Header;

    @FindBy(xpath = "//ul[@class = 'search-dropdown-menu']/li/span[@style='width: 140px;']")
    private List<WebElement> allChoicesInDropDownMenu;

    @FindBy(xpath = "//div[@class = 'controls']//span")
    private WebElement differentWeatherButton;

    @FindBy(xpath = "//div[@class='control-el']")
    private WebElement locationButton;

    @FindBy(xpath = "//div[text()='Metric: °C, m/s']")
    private WebElement metricButton;

    @FindBy(xpath = "//div[text()='Imperial: °F, mph']")
    private WebElement imperialButton;

    @FindBy(xpath = "//div[@class='current-temp']/span")
    private WebElement currentTempAndUnit;

    @FindBy(css = "div.current-container.mobile-padding")
    private List<WebElement> currentWeatherContainer;

    @FindBy(className = "pop-up-container")
    private WebElement differentWeatherPopUpContainer;

    @FindBy(xpath = "//ul[@class='icons']/*")
    private WebElement differentWeatherIconsContainer;

    @FindBy(xpath = "//ul[@class = 'icons']/*")
    private List<WebElement> iconsList;

    @FindBy(xpath = "//div[@aria-label='Loading']")
    private WebElement seeLoading;

    @FindBy(xpath = "//ul[@class='icons']/li")
    private List<WebElement> differentWeatherIcons;

    @FindBy(xpath = "//button[text()='Send']")
    private WebElement sendButtonInDifferentWeatherContainer;

    @FindBy(xpath = "//div[@class='pop-up-container']//*[name()='path' and @fill='#8a8a8a']")
    private WebElement xButtonInDifferentWeatherContainer;

    @FindBy(xpath = "//div[@class='widget-notification']")
    private WebElement resultErrorWidget;

    @FindBy(xpath = "//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
    private WebElement parisFRChoiceInDropdownMenu;

    @FindBy(xpath = "//span[text()='45.787, -87.904']")
    private WebElement cityNorway;

    @FindBy(className = "activeIcon")
    private List<WebElement> activeIconsInDifferentWeatherContainer;

    @FindBy(className = "activeIcon")
    private WebElement activeIcon;

    @FindBy(xpath = "//div[@class='day-list-values']/div/span")
    private List<WebElement> dayListValues;

    @FindBy(id = "dialogTitle")
    private WebElement h3DialogTitle;

    @FindBy(xpath = "//div[@id='weather-widget']//span[@Class='orange-text']")
    private WebElement currentTime;

    @FindBy(xpath = "//div[@class='stick-footer-panel__container']")
    private WebElement footerPanelContainer;

    @FindBy(xpath = "//div[@class='stick-footer-panel__container']")
    private WebElement bottomPanel;

    @FindBy(xpath = "//button[@type='button' and text()='Allow all']")
    private WebElement allowAllButton;

    @FindBy(xpath = "//a[@href='/cookies-settings' and text()=' Manage cookies ']")
    private WebElement manageButton;

    @FindBy(xpath = "//p[@class='stick-footer-panel__description']")
    private WebElement textPanel;

    @FindBy(xpath = "//div[@id='footer-website']//a[@href='/weather-dashboard']")
    private WebElement weatherDashboardFooterMenu;

    @FindBy(xpath = "//div[@class='more-options']")
    private WebElement moreOptionsDropDown;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement temperatureInputInDifferentWeatherContainer;

    @FindBy(xpath = "//a[text()='Bulks']")
    private WebElement bulkLink;

    @FindBy(xpath = "//div[@class = 'widget-notification']")
    private WebElement notificationMessage;

    @FindBy(xpath = "//div/a[@class='stats white-text']")
    private List<WebElement> apiIcons;

    @FindBy(xpath = "//div/a[@href='/current']")
    private WebElement currentWeatherIcon;

    @FindBy(xpath = "//div[@class='section orange-background white-text']")
    private WebElement orangeBackground;

    @FindBy(xpath = "//div[@class = 'mobile-padding']/h1")
    private WebElement mainPageHeader1;

    @FindBy(xpath = "//span[@class = 'white-text']")
    private WebElement mainPageHeader2;

    @FindBy(xpath = "//div[@class='dropdown-selector']")
    private WebElement dataSourceDropDown;

    @FindBy(xpath = "//div[@class='owm-selector open']//ul[@class='dropdown-menu']/li")
    private List<WebElement> dataSourceOptions;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailTextBox;

    @FindBy(xpath = "//textarea[@class='owm_textarea']")
    private WebElement anyAdditionalInfoTextarea;

    @FindBy(xpath = "//ul[@class='day-list']/li/span")
    private List<WebElement> listOfEightDaysData;

    @FindBy(xpath = "//ul[@class='day-list']/li/span[1]")
    private WebElement currentDateFromEightDaysForecast;

    @FindBy(xpath = "//div[@class = 'weather-alert']")
    private WebElement weatherAlert;

    @FindBy(xpath = "//span[@class='sub']")
    private List<WebElement> weatherDescription;

    @FindBy(css = "a[href*='/'],a[href*='#']")
    private List<WebElement> allLinks;

    @FindBy(xpath = "//div[@class = 'current-temp']//span[@class = 'heading']")
    private WebElement currentTemp;

    @FindBy(xpath = "//ul//li[contains(text(), 'hPa')]")
    private WebElement currentPressure;

    @FindBy(xpath = "//div[contains(text(), 'Feels like')]")
    private WebElement feelsLikeText;

    @FindBy(xpath = "//ul//li[contains(text(), '%')]")
    private WebElement currentHumidity;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage createGeneric() {

        return new MainPage(getDriver());
    }

    public String getCityCountryName() {

        return getText(h2CityCountryHeader);
    }

    public String getH1Color() {

        return getBackgroundColor(colorAndFontSizeOfH1Header);
    }

    public String getH1FontSize() {

        return getFontSize(colorAndFontSizeOfH1Header);
    }

    public int getAmountOfIconsOnDifferentWeatherPopUp() {

        return getListSize(iconsList);
    }

    public String getLoadingText(String attribute) {

        return getAttribute(seeLoading, attribute);
    }

    public List<WebElement> getListOfIconsOnDifferentWeatherPopUp() {

        return iconsList;
    }

    public String getErrorText() {

        return getText(resultErrorWidget);
    }

    public String getErrorButtonBackgroundColor() {

        return getBackgroundColor(resultErrorWidget);
    }

    public String getActiveIconBackgroundColorInHEX() {

        return getBackgroundColorInHEX(activeIcon);
    }

    public String getHeaderForDifferentWeatherContainer() {

        return getText(h3DialogTitle);
    }

    public String getBottomPanelText() {

        return getText(textPanel);
    }

    public int getTemperatureValueInDifferentWeatherContainer() {

        return convertStringToInt(getAttribute(temperatureInputInDifferentWeatherContainer, "_value"));
    }

    public String getFeelsLike() {
        String description = getText(feelsLikeText);
        char[] letters = description.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == '.') {

                return description.substring(0, i + 1);
            }
        }

        return "Wrong description";
    }

    public String getNotificationMessage() {

        return getText(notificationMessage);
    }

    public List<WebElement> getDisplayedAPIIcons() {
        List<WebElement> displayedIcons = new ArrayList<>();

        for (WebElement element : apiIcons) {
            if (isElementDisplayed(element) && element.isEnabled()) {
                displayedIcons.add(element);
            } else {
                getWait20().until(ExpectedConditions.visibilityOf(element));
                displayedIcons.add(element);
            }
        }

        return displayedIcons;
    }

    public List<String> getCurrentWeatherText() {

        return getTexts(currentWeatherContainer);
    }

    public List<String> getListWeatherDescriptionText() {
        getActions().scrollByAmount(0, 500).perform();

        return getTexts(weatherDescription);
    }

    public List<WebElement> getApiIcons() {

        return apiIcons;
    }

    public int getAPIIconsQuantity() {

        return getListSize(getDisplayedAPIIcons());
    }

    public List<String> getAPIIconsNames() {

        return getTexts(apiIcons);
    }

    public String getH1Header() {

        return getText(mainPageHeader1);
    }

    public List<String> getDataSourceOptionsTexts() {

        return getTexts(dataSourceOptions);
    }

    public List<String> getListOfEightDaysDataText() {
        scrollByVisibleElement(currentDateFromEightDaysForecast);

        return getTexts(listOfEightDaysData);
    }

    public String getCurrentTempAndUnit() {

        return getText(currentTempAndUnit);
    }

    public String getEightDaysForecastCalendarSequenceText() {

        final String[] dowMonDate = currentDateFromEightDaysForecast.getText().split(" ");
        final String dowText = dowMonDate[0].substring(0, 3);
        final int monNum = DateTimeUtils.returnMonth(dowMonDate[1]);
        final int date = Integer.parseInt(dowMonDate[2]);

        return DateTimeUtils.getEightDaysFromDate(dowText, monNum, date, Year.now().getValue());
    }

    public String getH2Header() {

        return getText(mainPageHeader2);
    }

    public String getAdditionalInfoText() {

        return getAttribute(anyAdditionalInfoTextarea, "_value");
    }

    public String getDataSourceDropDownText() {

        return getText(dataSourceDropDown);
    }

    public String getEmailTextBoxText() {

        return getAttribute(emailTextBox, "_value");
    }

    public String getCurrentTemp() {

        return getText(currentTemp).substring(0, 2).replaceAll("°", "");
    }

    public String getCurrentPressure() {
        String pressure = getText(currentPressure);

        return pressure.substring(0, pressure.length() - 3);
    }

    public MainPage clickSearchCityField() {
        click(searchCityField);

        return this;
    }

    public MainPage clickSearchButton() {
        click(searchButton);

        return this;
    }

    public MainPage clickParisInDropDownList() {
        wait20ElementToBeVisible(searchDropdownMenu);
        click(parisFRChoiceInDropdownMenu);

        return this;
    }

    public MainPage clickDifferentWeatherButton() {
        click(differentWeatherButton);

        return this;
    }

    public MainPage clickIconOnDifferentWeatherPopUp(WebElement element) {
        click(element);

        return this;
    }

    public MainPage clickCityNorway() {
        click20(cityNorway);

        return this;
    }

    public MainPage clickLocationButton() {
        click20(locationButton);

        return this;
    }

    public CurrentWeatherPage clickCurrentWeatherIcon() {
        wait10ElementToBeClickable(currentWeatherIcon);
        click20(currentWeatherIcon);

        return new CurrentWeatherPage(getDriver());
    }

    public BulkPage clickBulks() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", bulkLink);

        return new BulkPage(getDriver());
    }

    public MainPage clickMoreOptionsDropDown() {
        click20(moreOptionsDropDown);

        return this;
    }

    public MainPage clickLessOptionsDropDown() {
        click20(moreOptionsDropDown);

        return this;
    }

    public void clickUpKeyInTemperatureInput() {
        clickArrowUp(temperatureInputInDifferentWeatherContainer);

    }

    public MainPage clickDataSourceDropDown() {
        scrollByVisibleElement(dataSourceDropDown);
        click20(dataSourceDropDown);

        return this;
    }

    public MainPage clickFirstDataSourceOption() {
        click(dataSourceOptions.get(0));

        return this;
    }

    public MainPage clickOutOfDifferentWeatherContainer() {
        Actions action = new Actions(getDriver());
        action.moveByOffset(0, 0).click().build().perform();
        getWait10().until(ExpectedConditions.invisibilityOf(differentWeatherPopUpContainer));

        return this;
    }

    public void clickApiIcon(int index) {
        click(getApiIcons().get(index));
    }

    public MainPage scrollToFooterMenu() {
        scrollByVisibleElement(getFooterMenu());

        return this;
    }

    public MainPage inputSearchCriteria(String text) {
        input(text, searchCityField);

        return this;
    }

    public MainPage waitForCityCountryNameChanged(String oldText) {
        waitTextToBeChanged(h2CityCountryHeader, oldText);

        return this;
    }

    public MainPage waitUntilDifferentWeatherPopUpIsVisible() {
        wait10ElementToBeVisible(differentWeatherPopUpContainer);

        return this;
    }

    public boolean isSendButtonDisplayed() {

        return isElementDisplayed(sendButtonInDifferentWeatherContainer);
    }

    public boolean isXButtonDisplayed() {

        return isElementDisplayed(xButtonInDifferentWeatherContainer);
    }

    public MainPage switchToMetric() {
        click(metricButton);

        return this;
    }

    public MainPage switchToImperial() {
        click(imperialButton);

        return this;
    }

    public List<String> getTempsAndUnitsList() {

        List<String> list = new ArrayList<>();

        for (String element : getTexts(dayListValues)) {
            list.add(element.substring(element.length() - 2));
        }

        return list;
    }

    public int countActiveIconsInDifferentWeatherContainer() {

        return getListSize(activeIconsInDifferentWeatherContainer);
    }

    public MainPage scrollToPageBottom() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        return this;
    }

    public MainPage waitForGreyContainerDisappeared() {
        waitForGreyContainerDisappeared(greyContainer);

        return this;
    }

    public MainPage waitForFooterPanelToBeVisible() {
        wait20ElementToBeVisible(footerPanelContainer);
        wait20ElementToBeVisible(bottomPanel);

        return this;
    }

    public MainPage waitForElementToBeVisible() {
        wait20ElementToBeVisible(allowAllButton);
        wait20ElementToBeVisible(manageButton);

        return this;
    }

    public MainPage scrollToBulkLink() {

        if (isElementDisplayed(bulkLink)) {
            wait20ElementToBeVisible(bulkLink);
        }
        scrollByVisibleElement(bulkLink);

        return this;
    }

    public boolean isLocationButtonDisplayed() {

        return isElementDisplayed(locationButton);
    }

    public MainPage scrollByCurrentWeatherIcon() {
        scrollByVisibleElement(currentWeatherIcon);

        return this;
    }

    public MainPage scrollToSubscriptionFooterMenu() {
        scrollByVisibleElement(getSubscriptionFooterMenu());

        return this;
    }

    public MainPage inputTextInEmailTextBox() {
        String randomEmail = TestUtils.getRandomName(7) + "@gmail.com";
        input(randomEmail, emailTextBox);

        return this;
    }

    public MainPage inputTextInAdditionalInfoTextArea() {
        input(TestUtils.getRandomName(9), anyAdditionalInfoTextarea);

        return this;
    }

    public MainPage scrollByOrangeBackground() {
        scrollByVisibleElement(orangeBackground);

        return this;
    }

    public List<String> getAllLinks() {
        List<String> linksList = new ArrayList<>();

        for (WebElement link : allLinks) {
            linksList.add(getAttribute(link, "href"));
        }

        return linksList;
    }

    public String getTempUnit() {
        String tempAndUnit = getText(currentTempAndUnit);

        return tempAndUnit.substring(tempAndUnit.length() - 2);
    }

    public String getClassAttribute(WebElement element) {

        return getAttribute(element, "class");
    }

    public String getCurrentHumidity() {

        String humidity = getText(currentHumidity);

        return humidity.substring(10, humidity.length() - 1);
    }
}
