package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrentWeatherTest extends BaseTest {

    @Test
    public void testCurrentWeatherDataCallTemplate() {
        final String expectedTemplate =
                "https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}";

        String actualTemplate = openBaseURL()
                .scrollByOrangeBackground()
                .clickCurrentWeatherIcon()
                .getAPICallTemplate();

        Assert.assertEquals(actualTemplate, expectedTemplate);
    }
}
