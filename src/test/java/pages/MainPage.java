package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.FooterMenuPage;
import pages.top_menu.VpnPage;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.TestUtils.convertStringToInt;

public class MainPage extends FooterMenuPage<MainPage> {

    @FindBy(xpath = "//div[@class = 'logo-home']//h1")
    private WebElement h1HomeTitle;

    @FindBy(xpath = "//input[@class = 'input-search'][@placeholder = 'Your search. Your business.']")
    private WebElement searchCityField; // swisscows

    @FindBy(xpath = "//div[@class = 'logo-home']//h1")
    private WebElement logoHome; // swisscows

    @FindBy(xpath = "//div[@class='services-blocks']")
    private WebElement ourServiceContainer; // swisscows

    @FindBy(xpath = "//div[@class='services-blocks']//a[@href='https://hesbox.com/']")
    private WebElement linkLearnMoreInOurService; // swisscows

    @FindBy(xpath = "//div[@class='services-blocks']//a[@href='https://swisscows-fanshop.com']")
    private WebElement linkFanShopInOurService; // swisscows

    @FindBy(xpath = "//div[@class='services-blocks']//a[@href='https://awiebe.org/']")
    private WebElement linkWiebeBlogInOurService; // swisscows

    @FindBy(xpath = "//ul[@class = 'suggestions']/li")
    private List<WebElement> allChoicesInSuggestion; //swisscows

    @FindBy(xpath = "//div[@class = 'bnnr-widget']")
    private WebElement homepageBanner; //swisscows

    @FindBy(xpath = "//div[@class = 'swiper-slide swiper-slide-active']")
    private WebElement homepageBannerSwitchSecondValue; //Get the second switch value

    @FindBy(xpath = "//div[@class = 'swiper-slide swiper-slide-next']")
    private WebElement homepageBannerSwitchFirstValue; //Get the first switch value

    @FindBy(xpath = "//span[@class ='swiper-pagination-bullet'][2]")
    private WebElement homepageBannerSwitchSecond; //Click on the second switch

    @FindBy(xpath = "//span[@class ='swiper-pagination-bullet'][1]")
    private WebElement homepageBannerSwitchFirst; // Click on the first switch

    @FindBy(xpath = "//img[@src= 'https://api.dev.swisscows.com/b4r/aa0de0145ba54acab978665b92a8c082']")
    private WebElement homepageBannerImage; // Image of banner

    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[1]")
    private WebElement homepageQuestion1; //

    @FindBy(xpath = "//h3[@class='question'][1]")
    private WebElement homepageQuestionOne; //

    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[2]")
    private WebElement homepageQuestion2; //

    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[3]")
    private WebElement homepageQuestion3; //
    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[4]")
    private WebElement homepageQuestion4; //

    @FindBy(xpath = "//p//a[@href='/en/default-search']")
    private WebElement linkInQuestion4; //

    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[5]")
    private WebElement homepageQuestion5; //

    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[6]")
    private WebElement homepageQuestion6; //

    @FindBy(xpath = "//div[@class= 'faq-wrap']//h3")
    private List<WebElement> homepageAllQuestion; // All questions

    @FindBy(xpath = "//p[@class= 'answer close']")
    private WebElement homepageOneAnswer; //

    @FindBy(xpath = "//a[@class = 'install-sw-block popup']")
    private WebElement installGoogleBlockPopup; //

    @FindBy(xpath = "//div[@class='home-link-instruction popup animation-badges']")
    private WebElement googlePopupInstall; //

    @FindBy(xpath = "//div[@class='mobile-padding']/h1/span")
    private WebElement colorAndFontSizeOfH1Header;

    @FindBy(xpath = "//div[@class='current-temp']/span")
    private WebElement currentTempAndUnit;

    @FindBy(className = "pop-up-container")
    private WebElement differentWeatherPopUpContainer;

    @FindBy(xpath = "//div[@aria-label='Loading']")
    private List<WebElement> questionList; // AllQeustion

    @FindBy(xpath = "//div[@aria-label='Loading']")
    private WebElement seeLoading;

    @FindBy(xpath = "//div[@class='widget-notification']")
    private WebElement resultErrorWidget;

    @FindBy(className = "activeIcon")
    private WebElement activeIcon;

    @FindBy(xpath = "//div[@class='day-list-values']/div/span")
    private List<WebElement> dayListValues;

    @FindBy(xpath = "//div[@class='footer-full-inner-wrap']")
    private WebElement footerPanelContainer;

    @FindBy(xpath = "//img[@class='footer-back']")
    private WebElement imageFooterPanel;

    @FindBy(xpath = "//ul[@class = 'suggestions']")
    private WebElement suggestMainPage;

    @FindBy(xpath = "//ul[@class = 'suggestions']//li")
    private List<WebElement> suggestListMainPage;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement temperatureInputInDifferentWeatherContainer;

    @FindBy(xpath = "//a[text()='Bulks']")
    private WebElement bulkLink;

    @FindBy(xpath = "//div[@class = 'widget-notification']")
    private WebElement notificationMessage;

    @FindBy(xpath = "//div/a[@class='stats white-text']")
    private List<WebElement> apiIcons;
    @FindBy(xpath = "//div[@class='section orange-background white-text']")
    private WebElement orangeBackground;

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

    @FindBy(xpath = "//span[@class='sub']")
    private List<WebElement> weatherDescription;

    @FindBy(xpath = "//footer[@class='footer-full']//a[@href]")
    private List<WebElement> allLinks;

    @FindBy(xpath = "//div[@class = 'current-temp']//span[@class = 'heading']")
    private WebElement currentTemp;

    @FindBy(xpath = "//ul//li[contains(text(), 'hPa')]")
    private WebElement currentPressure;

    @FindBy(xpath = "//div[contains(text(), 'Feels like')]")
    private WebElement feelsLikeText;

    @FindBy(xpath = "//ul//li[contains(text(), '%')]")
    private WebElement currentHumidity;

    @FindBy(xpath = "//input[@class ='input-search']")
    private WebElement searchBoxTopMenu;

    @FindBy(xpath = "//ul[@class ='menu-dropdown-list']//li[1]")
    private static WebElement firstValueOfTheme;

    @FindBy(xpath = "//body[@class ='dark']")
    private static WebElement bodyIsDark;


    @FindBy(xpath = "//ul[@class ='menu-dropdown-list']//li[2]")
    private static WebElement secondValueOfLight;
    @FindBy(xpath = "//ul[@class ='menu-dropdown-list']//li[3]")
    private static WebElement thirdValueOfDark;

    @FindBy(xpath =  "//input[@class ='input-search']")
    private WebElement searchField;
    @FindBy(xpath =  "//a[@class = 'userinfo']")
    private WebElement nicknameHamburgerMenu;
    @FindBy(xpath =  "//div/img")
    private List<WebElement> allImagesMainPage;
    @FindBy(xpath =  "//h2")
    private List<WebElement> h2TextsMainPage;
    @FindBy(xpath =  "//div//p[@class='title-section']")
    private List<WebElement> h1TextsMainPage;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage createGeneric() {

        return new MainPage(getDriver());
    }
    public List <String> getH2TextsMainPage() {

        return getTexts(h2TextsMainPage);
    }
    public List <String> getH1TextsMainPage() {

        return getTexts(h1TextsMainPage);
    }

    public String getMainTittleName() {

        return getText(h1HomeTitle);
    }


    public String getLoadingText(String attribute) {

        return getAttribute(seeLoading, attribute);
    }
    public String getTextPopupInstall() {

        return getText(googlePopupInstall);
    }

    public String getErrorButtonBackgroundColor() {

        return getBackgroundColor(resultErrorWidget);
    }

    public String getActiveIconBackgroundColorInHEX() {

        return getBackgroundColorInHEX(activeIcon);
    }


    public String getNicknameInHamburgerMenu() {

        return getText(nicknameHamburgerMenu);
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

    public boolean isHomePageLogoDisplayed() {

        return isElementDisplayed(logoHome);
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


    public String getAdditionalInfoText() {

        return getAttribute(anyAdditionalInfoTextarea, "_value");
    }

    public String getCurrentTemp() {

        return getText(currentTemp).substring(0, 2).replaceAll("°", "");
    }

    public String getCurrentPressure() {
        String pressure = getText(currentPressure);

        return pressure.substring(0, pressure.length() - 3);
    }


    public MainPage clickSearchField() {
        click(searchCityField);

        return this;
    }

    public MainPage clickHomeBanner() {
        Actions action = new Actions(getDriver());
        action.doubleClick(homepageBanner).build().perform();
        switchToAnotherWindow();
        return this;
    }

    public MainPage clickLinkLearnMoreInOurService() {
        click(linkLearnMoreInOurService);
        return new MainPage(getDriver());

    }

    public MainPage clickLinkFanShopInOurService() {
        click(linkFanShopInOurService);
        return new MainPage(getDriver());

    }

    public MainPage clickLinkWiebeBlogInOurService() {
        click(linkWiebeBlogInOurService);
        return new MainPage(getDriver());

    }
    public MainPage clickQuestion1() {
        click(homepageQuestionOne);

        return this;
    }

    public MainPage clickInstallGoogleBlockPopup() {
        click(installGoogleBlockPopup);

        return this;
    }

    public MainPage clickQuestion4() {
        click(homepageQuestion4);

        return this;
    }
    public MainPage clickLinkInQuestion4() {
        click(linkInQuestion4);
        switchToAnotherWindow();
        return new MainPage(getDriver());

    }

    public MainPage clickAllQuestions(){
        clickAllElementsInList(homepageAllQuestion);
        return new MainPage(getDriver());
    }

    public MainPage clickIconOnDifferentWeatherPopUp(WebElement element) {
        click(element);

        return this;
    }

    public void clickUpKeyInTemperatureInput() {
        clickArrowUp(temperatureInputInDifferentWeatherContainer);

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


    public MainPage scrollToFooterMenu() {
        scrollByVisibleElement(getFooterMenu());

        return this;
    }


    public MainPage scrollToLastElementInDropdownRegion() {
        scrollByVisibleElement(getLastElementInDropdownRegion());

        return this;
    }

    public MainPage inputSearchCriteria(String text) {
        input(text, searchCityField);

        return this;
    }

    public boolean isPopupGoogleDisplayed() {

        return isElementDisplayed(googlePopupInstall);
    }



    public boolean suggestIsDisplayed() {

        return isElementDisplayed(suggestMainPage);
    }
    public boolean allImagesDisplayed() {

        return areElementsInListDisplayed(allImagesMainPage);
    }

    public boolean homePageBannerIsDisplayed() {

        return isElementDisplayed(homepageBanner);
    }

    public boolean isPlaceholderDisplayedMain() {

        return isElementDisplayed(searchBoxTopMenu);
    }

    public String getInnerTextOfPlaceholderMain(String attribute) {

        return getAttribute(searchField, attribute);
    }



    public MainPage clickMainLogo() {
        click(logoHome);

        return this;
    }

    public MainPage clickPopupGoogle() {
        click(googlePopupInstall);

        return this;
    }

    public MainPage clickThemeLight() {
        click(secondValueOfLight);

        return new MainPage(getDriver());
    }
    public MainPage clickThemeDark() {
        click(thirdValueOfDark);

        return new MainPage(getDriver());
    }

    public MainPage clickBannerSwitch() {
        click(homepageBannerSwitchSecond);
        return this;
    }
    public MainPage clickBannerSwitchFirst() {
        click(homepageBannerSwitchFirst);
        return this;
    }


    public List<String> getTempsAndUnitsList() {

        List<String> list = new ArrayList<>();

        for (String element : getTexts(dayListValues)) {
            list.add(element.substring(element.length() - 2));
        }

        return list;
    }

    public int countElementsInSuggestContainer() {

        return getListSize(suggestListMainPage);
    }


    public MainPage waitForImageInBannerDisappeared() {
        wait20ElementToBeVisible(homepageBannerImage);
      return new MainPage(getDriver());
    }

    public void waitForFooterPanelToBeVisible() {
        wait20ElementToBeVisible(footerPanelContainer);
        wait20ElementToBeVisible(imageFooterPanel);

    }


    public void waitForSuggestToBeVisible() {
        wait20ElementToBeVisible(suggestMainPage);

    }
    public MainPage waitForPopupGoogleInstallToBeVisible() {
        wait20ElementToBeVisible(googlePopupInstall);
        return new MainPage(getDriver());

    }

    public MainPage waitForAnswerToBeInvisible(){
      wait10ElementToBeInVisible(homepageOneAnswer);
      return new MainPage(getDriver());

    }

    public MainPage scrollToBulkLink() {

        if (isElementDisplayed(bulkLink)) {
            wait20ElementToBeVisible(bulkLink);
        }
        scrollByVisibleElement(bulkLink);

        return this;
    }


    public MainPage scrollToQuestions() {
        scrollByVisibleElement(homepageQuestion6);

        return this;
    }

    public MainPage scrollToBlockGooglePopup() {
        scrollByVisibleElement(installGoogleBlockPopup);

        return this;
    }
    public MainPage scrollToFooter() {
        scrollByVisibleElement(footerPanelContainer);

        return this;
    }
    public MainPage scrollToOurService() {
        scrollByVisibleElement(ourServiceContainer);

        return this;
    }

    public MainPage scrollToAboutSwisscowsFooterMenu() {
        scrollByVisibleElement(getAboutSwisscowsFooterMenu());

        return this;
    }
    public MainPage scrollToAboutSwisscowsAGFooterMenu() {
        scrollByVisibleElement(getAboutSwisscowsAGFooterMenu());

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

    public String getClassAttributeSwitchSecond() {

        return getAttribute(homepageBannerSwitchSecondValue, "class");
    }
   public String getClassAttributeSwitchFirst() {

     return getAttribute(homepageBannerSwitchFirstValue, "class");
   }

    public String getClassAttributeThemeDefault() {

        return getAttribute(firstValueOfTheme, "class");
    }

    public String getClassAttributeBodyOfSite() {

        return getAttribute(bodyIsDark, "class");
    }
    public String getClassAttributeThemeLight() {

        return getAttribute(secondValueOfLight, "class");
    }

    public String getClassAttributeQuestion1() {

        return getAttribute(homepageQuestion1,"class");
    }
    public String getClassAttributeQuestion2() {

        return getAttribute(homepageQuestion2,"class");
    }
    public String getClassAttributeQuestion3() {

        return getAttribute(homepageQuestion3,"class");
    }
    public String getClassAttributeQuestion4() {

        return getAttribute(homepageQuestion4,"class");
    }
    public String getClassAttributeQuestion5() {

        return getAttribute(homepageQuestion5,"class");
    }
    public String getClassAttributeQuestion6() {

        return getAttribute(homepageQuestion6,"class");
    }


    public String getCurrentHumidity() {

        String humidity = getText(currentHumidity);

        return humidity.substring(10, humidity.length() - 1);
    }

    public List<String> getAllElementsText() {

        List<String> textList = new ArrayList<>();

        for (WebElement element : allChoicesInSuggestion) {
            textList.add(element.getText().toLowerCase());
        }
        return textList;
    }



    public void switchToAnotherWindow() {
        String originalWindow = getDriver().getWindowHandle();

        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!originalWindow.equals(windowHandle) && getDriver().getWindowHandles().size() == 2) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
    public MainPage closeWindow() {
        getDriver().close();
        return this;

    }


}
