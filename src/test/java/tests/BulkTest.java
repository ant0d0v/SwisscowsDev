package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BulkPage;

public class BulkTest extends BaseTest {

    @Test
    public void testH2Header() {
        final String expectedH2Header = "How to use the service";

        String actualH2Header = openBaseURL()
                .scrollToBulkLink()
                .clickBulks()
                .getH2Header();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testBulkFilesInAPIRequestsTemplate() {
        final String expectedCurrentAndForecastBulkRequest =
                "https://bulk.openweathermap.org/snapshot/{BULK_FILE_NAME}?appid={API key}";
        final String expectedSevenDaysArchiveBulkRequest =
                "https://bulk.openweathermap.org/archive/{BULK_FILE_NAME}?appid={API key}";

        BulkPage bulkPage = openBaseURL()
                .scrollToBulkLink()
                .clickBulks();

        String actualCurrentAndForecastBulkRequest = bulkPage.getBulkFilesRequests().get(0);
        String actualSevenDaysArchiveBulkRequest = bulkPage.getBulkFilesRequests().get(1);

        Assert.assertEquals(actualCurrentAndForecastBulkRequest, expectedCurrentAndForecastBulkRequest);
        Assert.assertEquals(actualSevenDaysArchiveBulkRequest, expectedSevenDaysArchiveBulkRequest);
    }
}
