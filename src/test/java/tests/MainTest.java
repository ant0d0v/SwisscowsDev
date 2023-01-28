package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CurrentWeatherPage;
import pages.MainPage;
import pages.TestData;
import utils.TestUtils;

import java.util.List;

public class MainTest extends BaseTest {

    @Test
    public void testH2Header_WhenSearchingCityCountry() {
        final String cityName = "Paris";
        final String expectedCityCountryNames = "Paris, FR";

        MainPage mainPage = openBaseURL();

        final String oldCityCountryName = mainPage.getCityCountryName();

        mainPage.clickSearchCityField();
        mainPage.inputSearchCriteria(cityName);
        mainPage.clickSearchButton();
        mainPage.clickParisInDropDownList();
        mainPage.waitForCityCountryNameChanged(oldCityCountryName);

        String newCityCountryNames = mainPage.getCityCountryName();

        Assert.assertEquals(newCityCountryNames, expectedCityCountryNames);
    }

    @Test
    public void testH2Header_WhenSearchingCityCountryChain() {
        final String cityName = "Paris";
        final String expectedCityCountryNames = "Paris, FR";

        MainPage mainPage = openBaseURL();

        final String oldCityCountryName = mainPage.getCityCountryName();

        String newCityCountryNames =
                mainPage
                        .clickSearchCityField()
                        .inputSearchCriteria(cityName)
                        .clickSearchButton()
                        .clickParisInDropDownList()
                        .waitForCityCountryNameChanged(oldCityCountryName)
                        .getCityCountryName();

        Assert.assertEquals(newCityCountryNames, expectedCityCountryNames);
    }

    @Test
    public void testH1HeaderColorAndFontSize() {
        final String expectedH1Color = "rgba(0, 0, 0, 0)";
        final String expectedH1FontSize = "45px";

        MainPage mainPage = openBaseURL();

        String actualH1Color = mainPage.getH1Color();
        String actualH1FontSize = mainPage.getH1FontSize();

        Assert.assertEquals(actualH1Color, expectedH1Color);
        Assert.assertEquals(actualH1FontSize, expectedH1FontSize);
    }

    @Test
    public void testAmountOfIcons_OnDifferentWeatherPopUp() {
        final int expectedAmountOfIcons = 9;

        int actualIconsAmount =
                openBaseURL()
                        .clickDifferentWeatherButton()
                        .waitUntilDifferentWeatherPopUpIsVisible()
                        .getAmountOfIconsOnDifferentWeatherPopUp();

        Assert.assertEquals(actualIconsAmount, expectedAmountOfIcons);
    }

    @Test
    public void testIconsHighlighted_OnDifferentWeatherPopUp() {
        final String expectedValueOfAttribute = "activeIcon";

        MainPage mainPage = openBaseURL();

        List<WebElement> iconsDifferentWeather =
                mainPage
                        .clickDifferentWeatherButton()
                        .waitUntilDifferentWeatherPopUpIsVisible()
                        .getListOfIconsOnDifferentWeatherPopUp();

        for (WebElement icon : iconsDifferentWeather) {
            String actualValueAttribute =
                    mainPage
                            .clickIconOnDifferentWeatherPopUp(icon)
                            .getClassAttribute(icon);

            Assert.assertEquals(actualValueAttribute, expectedValueOfAttribute);
        }
    }

    @Test
    public void testRefreshPage() {
        final String expectedTextWhenLoading = "Loading";

        String actualTextWhenLoading =
                openBaseURL()
                        .clickLogo()
                        .getLoadingText("aria-label");

        Assert.assertEquals(actualTextWhenLoading, expectedTextWhenLoading);
    }

    @Test
    public void testCurrentLocationButton() {
        final String cityName = "Norway";
        final String expectedCityCountryName = "London, GB";

        String actualCityCountryName =
                openBaseURL()
                        .clickSearchCityField()
                        .inputSearchCriteria(cityName)
                        .clickSearchButton()
                        .clickCityNorway()
                        .clickLocationButton()
                        .getCityCountryName();

        Assert.assertEquals(actualCityCountryName, expectedCityCountryName);
    }

    @Test
    public void testXButtonIsDisplayed_OnDifferentWeatherPopUp() {
        MainPage mainPage =
                openBaseURL()
                        .clickDifferentWeatherButton();

        Assert.assertTrue(mainPage.isXButtonDisplayed(), "X button is not displayed");
    }

    @Test
    public void testTempUnitChangedToC_WhenSwitchingToMetric() {
        final String expectedTempUnit = "°C";

        String actualTempUnit = openBaseURL()
                .switchToMetric()
                .waitForGreyContainerDisappeared()
                .getTempUnit();

        Assert.assertEquals(actualTempUnit, expectedTempUnit);
    }

    @Test
    public void testTempUnitChangedToF_WhenSwitchingToImperial() {
        final String expectedTempUnit = "°F";

        String actualTempUnit = openBaseURL()
                .switchToImperial()
                .waitForGreyContainerDisappeared()
                .getTempUnit();

        Assert.assertEquals(actualTempUnit, expectedTempUnit);
    }

    @Test
    public void testSendButtonIsDisplayed_OnDifferentWeatherPopUp() {
        MainPage mainPage =
                openBaseURL()
                        .clickDifferentWeatherButton();

        Assert.assertTrue(mainPage.isSendButtonDisplayed(), "Send button is not displayed");
    }

    @Test
    public void testErrorMessageWhenCityDoesNotExists() {
        final String cityName = TestUtils.getRandomName();
        final String expectedErrorText = "No results for " + cityName;

        String actualErrorText =
                openBaseURL()
                        .clickSearchCityField()
                        .inputSearchCriteria(cityName)
                        .clickSearchButton()
                        .getErrorText();

        Assert.assertEquals(actualErrorText, expectedErrorText);
    }

    @Test
    public void testSearchErrorMessageBackgroundColor() {
        final String cityName = TestUtils.getRandomName();
        final String expectedSearchErrorMessageColor = "rgba(120, 203, 191, 0.8)";

        String actualSearchErrorMessageColor =
                openBaseURL()
                        .clickSearchCityField()
                        .inputSearchCriteria(cityName)
                        .clickSearchButton()
                        .getErrorButtonBackgroundColor();

        Assert.assertEquals(actualSearchErrorMessageColor, expectedSearchErrorMessageColor);
    }

    @Test
    public void testOneIconHighlightedByDefault_OnDifferentWeatherPopUp() {
        final String expectedIconColor = "#ececed";
        MainPage mainPage = openBaseURL();

        int activeIcon =
                mainPage
                        .clickDifferentWeatherButton()
                        .waitUntilDifferentWeatherPopUpIsVisible()
                        .countActiveIconsInDifferentWeatherContainer();

        final String activeIconColor = mainPage.getActiveIconBackgroundColorInHEX();

        Assert.assertEquals(activeIcon, 1);
        Assert.assertEquals(activeIconColor, expectedIconColor);
    }

    @Test
    public void testDayListTempInC_WhenSwitchingToMetric() {
        final List<String> expectedResult = List.of("°C", "°C", "°C", "°C", "°C", "°C", "°C", "°C");

        MainPage mainPage =
                openBaseURL()
                        .switchToMetric()
                        .waitForGreyContainerDisappeared();

        Assert.assertEquals(mainPage.getTempsAndUnitsList(), expectedResult);
    }

    @Test
    public void testDayListTempInF_WhenSwitchingToImperial() {
        final List<String> expectedResult = List.of("°F", "°F", "°F", "°F", "°F", "°F", "°F", "°F");

        MainPage mainPage =
                openBaseURL()
                        .switchToImperial()
                        .waitForGreyContainerDisappeared();

        Assert.assertEquals(mainPage.getTempsAndUnitsList(), expectedResult);
    }

    @Test
    public void testDifferentWeatherButtonOpensDifferentWeatherContainer() {
        final String expectedHeader = "Different weather";

        String actualHeader =
                openBaseURL()
                        .clickDifferentWeatherButton()
                        .getHeaderForDifferentWeatherContainer();

        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void testTextInCookiesAgreement() {
        final String expectedTextPanel =
                "We use cookies which are essential for the site to work. We also use non-essential "
                        + "cookies to help us improve our services. Any data collected is anonymised. "
                        + "You can allow all cookies or manage them individually.";

        String actualTextPanel =
                openBaseURL()
                        .waitForFooterPanelToBeVisible()
                        .waitForElementToBeVisible()
                        .getBottomPanelText();

        Assert.assertEquals(actualTextPanel, expectedTextPanel);
    }

    @Test
    public void testTemperatureValueIncreasedByOne_WhenClickingUp() {
        MainPage mainPage = openBaseURL();

        int temperatureValueInContainer = mainPage
                .clickDifferentWeatherButton()
                .waitUntilDifferentWeatherPopUpIsVisible()
                .clickMoreOptionsDropDown()
                .getTemperatureValueInDifferentWeatherContainer();

        mainPage.clickUpKeyInTemperatureInput();

        int increasedTemperatureValueInContainer = mainPage.getTemperatureValueInDifferentWeatherContainer();

        Assert.assertEquals(increasedTemperatureValueInContainer - temperatureValueInContainer, 1);
    }

    @Test
    public void testLocationButtonIsDisplayedAndClickable() {
        final String expectedNotificationMessage = "Location unavailable. Displaying default location: London";

        MainPage mainPage = openBaseURL();
        Assert.assertTrue(mainPage.isLocationButtonDisplayed());

        String actualNotificationMessage =
                mainPage
                        .clickLocationButton()
                        .getNotificationMessage();

        Assert.assertEquals(actualNotificationMessage, expectedNotificationMessage);
    }

    @Test
    public void testAPIIconsAreDisplayed() {
        final int expectedAPIIconsQuantity = 5;
        final List<String> expectedAPIIconsNames = List.of(
                "current\nweather\n(current)",
                "hourly\nforecast\n(4 days)",
                "daily\nforecast\n(16 days)",
                "climatic\nforecast\n(30 days)",
                "historical\nweather\n(1 month, 1 year)"
        );

        MainPage mainPage =
                openBaseURL()
                        .scrollByCurrentWeatherIcon();

        Assert.assertEquals(mainPage.getDisplayedAPIIcons(), mainPage.getApiIcons());
        Assert.assertEquals(mainPage.getAPIIconsQuantity(), expectedAPIIconsQuantity);
        Assert.assertEquals(mainPage.getAPIIconsNames(), expectedAPIIconsNames);
    }

    @Test
    public void testMainPageHeaders() {
        final String expectedH1Header = "OpenWeather";
        final String expectedH2Header = "Weather forecasts, nowcasts and history in a fast and elegant way";

        MainPage mainPage = openBaseURL();

        Assert.assertEquals(mainPage.getH1Header(), expectedH1Header);
        Assert.assertEquals(mainPage.getH2Header(), expectedH2Header);
    }

    @Test
    public void testDataSourceOptions() {
        final List<String> expectedDataSourceOptionsTexts = List.of(
                "Personal feelings",
                "Own weather station or devices",
                "Local weather provider",
                "Global weather provider",
                "Other"
        );

        List<String> actualDataSourceOptionsTexts =
                openBaseURL()
                        .clickDifferentWeatherButton()
                        .waitUntilDifferentWeatherPopUpIsVisible()
                        .clickMoreOptionsDropDown()
                        .clickDataSourceDropDown()
                        .getDataSourceOptionsTexts();

        Assert.assertEquals(actualDataSourceOptionsTexts, expectedDataSourceOptionsTexts);
    }

    @Test
    public void testChosenDataSourceOptionIsSavedAfterClickingLessOptions() {
        MainPage mainPage = openBaseURL();

        String dataSourceDropDownTextBefore =
                mainPage
                        .clickDifferentWeatherButton()
                        .waitUntilDifferentWeatherPopUpIsVisible()
                        .clickMoreOptionsDropDown()
                        .clickDataSourceDropDown()
                        .clickFirstDataSourceOption()
                        .getDataSourceDropDownText();

        String dataSourceDropDownTextAfter =
                mainPage
                        .clickLessOptionsDropDown()
                        .clickMoreOptionsDropDown()
                        .getDataSourceDropDownText();

        Assert.assertEquals(dataSourceDropDownTextAfter, dataSourceDropDownTextBefore);
    }

    @Test
    public void testEmailAndAdditionalInfoIsNotSavedAfterClickingOutOfContainer() {
        MainPage mainPage = openBaseURL();

        String emailTextBefore =
                mainPage
                        .clickDifferentWeatherButton()
                        .waitUntilDifferentWeatherPopUpIsVisible()
                        .clickMoreOptionsDropDown()
                        .inputTextInEmailTextBox()
                        .getEmailTextBoxText();

        String additionalInfoTextBefore =
                mainPage
                        .inputTextInAdditionalInfoTextArea()
                        .getAdditionalInfoText();

        String emailTextAfter =
                mainPage
                        .clickOutOfDifferentWeatherContainer()
                        .clickDifferentWeatherButton()
                        .waitUntilDifferentWeatherPopUpIsVisible()
                        .clickMoreOptionsDropDown()
                        .getEmailTextBoxText();

        String additionalInfoTextAfter =
                mainPage
                        .getAdditionalInfoText();

        Assert.assertNotEquals(emailTextAfter, emailTextBefore);
        Assert.assertNotEquals(additionalInfoTextAfter, additionalInfoTextBefore);
    }

    @Test
    public void testCorrect8DaysForecastCalendarSequence() {

        List<String> listOfEightDaysData = openBaseURL().getListOfEightDaysDataText();

        String expectedResult = new MainPage(getDriver()).getEightDaysForecastCalendarSequenceText();

        String actualResult = listOfEightDaysData.toString().substring(1, listOfEightDaysData.toString().length() - 1);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCurrentWeatherAPIIconNavigatesToCorrespondingPage() {
        final String basePageTitle = "Сurrent weather and forecast - OpenWeatherMap";
        final String expectedUrl = "https://openweathermap.org/current";
        final String expectedTitle = "Current weather data - OpenWeatherMap";

        CurrentWeatherPage currentWeatherPage =
                openBaseURL()
                        .scrollByOrangeBackground()
                        .clickCurrentWeatherIcon();

        Assert.assertNotEquals(currentWeatherPage.getTitle(), basePageTitle);
        Assert.assertEquals(currentWeatherPage.getCurrentURL(), expectedUrl);
        Assert.assertEquals(currentWeatherPage.getTitle(), expectedTitle);
    }

    @Test(dataProvider = "ApiIconsMainPage", dataProviderClass = TestData.class)
    public void testAPIIconsNavigateToCorrespondingPages(
            int index, String iconName, String iconDescription, String href, String expectedURL, String expectedTitle) {

        MainPage mainPage = openBaseURL();

        final String oldURL = mainPage.getCurrentURL();
        final String oldTitle = mainPage.getTitle();

        mainPage
                .scrollByOrangeBackground()
                .clickApiIcon(index);

        String actualURL = getDriver().getCurrentUrl();
        String actualTitle = getDriver().getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTitle, actualTitle);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
