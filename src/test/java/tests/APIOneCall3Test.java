package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.APIOneCall3Page;

public class APIOneCall3Test extends BaseTest {

    @Test
    public void testAPICallsParameters() {
        final String expectedParameters = "Parameters";
        final String expectedFirstParameter = "lat, lon required Geographical coordinates (latitude, longitude). "
                + "If you need the geocoder to automatic convert city names and zip-codes "
                + "to geo coordinates and the other way around, please use our Geocoding API.";
        final String expectedSecondParameter = "appid required Your unique API key "
                + "(you can always find it on your account page under the \"API key\" tab)";
        final String expectedThirdParameter = "exclude optional By using this parameter you can exclude some parts "
                + "of the weather data from the API response. It should be a comma-delimited list (without spaces).\n"
                + "Available values:\ncurrent\nminutely\nhourly\ndaily\nalerts";
        final String expectedFourthParameter = "units optional Units of measurement. standard, metric and imperial units"
                + " are available. If you do not use the units parameter, standard units will be applied by default. "
                + "Learn more";
        final String expectedFifthParameter = "lang optional You can use the lang parameter to get the output in your "
                + "language. Learn more";

        APIOneCall3Page apiOneCall3Page = openBaseURL()
                .clickAPIMenu()
                .clickAPIDocButton();

        String actualParameters = apiOneCall3Page.getADIOneCall3Parameters().get(0);
        String actualFirstParameter = apiOneCall3Page.getADIOneCall3Parameters().get(1);
        String actualSecondParameter = apiOneCall3Page.getADIOneCall3Parameters().get(2);
        String actualThirdParameter = apiOneCall3Page.getADIOneCall3Parameters().get(3);
        String actualFourthParameter = apiOneCall3Page.getADIOneCall3Parameters().get(4);
        String actualFifthParameter = apiOneCall3Page.getADIOneCall3Parameters().get(5);

        Assert.assertEquals(actualParameters, expectedParameters);
        Assert.assertEquals(actualFirstParameter, expectedFirstParameter);
        Assert.assertEquals(actualSecondParameter, expectedSecondParameter);
        Assert.assertEquals(actualThirdParameter, expectedThirdParameter);
        Assert.assertEquals(actualFourthParameter, expectedFourthParameter);
        Assert.assertEquals(actualFifthParameter, expectedFifthParameter);
    }
}
