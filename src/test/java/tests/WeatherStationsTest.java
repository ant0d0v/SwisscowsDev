package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WeatherStationsTest extends BaseTest {

    @Test
    public void testSummaryExistsAndActive() {
        final List<String> expectedSummaryTexts = List.of(
                "Three simple steps",
                "Basic methods to retrieve data from station",
                "Register station",
                "Send measurements for station",
                "Get measurements for station",
                "Additional features",
                "Get all stations",
                "Get station info",
                "Update station info",
                "Delete station",
                "Possible errors"
        );

        List<String> actualSummaryTexts =
                openBaseURL()
                        .scrollToPageBottom()
                        .clickConnectYourWeatherStationFooterMenu()
                        .waitAllSummaryElementsVisibleAndClickable()
                        .getSummaryTextsWeatherStations();

        Assert.assertEquals(actualSummaryTexts, expectedSummaryTexts);
    }
}
