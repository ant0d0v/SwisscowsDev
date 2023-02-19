package tests.api;

import api.CaptureNetworkTraffic;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class API_ImageTest extends BaseTest {
    @Test
    public void test_API_Images_Cdn_Swisscows() throws InterruptedException {
        List<String> requests = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequestsContain("cdn.swisscows.com/image");

        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickImageButton()
                .clickFirstImageInImagesResult();
        sleep(1000);

        for (int i = 1; i < requests.size(); i += 2 ) {
            Assert.assertTrue(requests.get(i).contains("https://cdn.swisscows.com/image?url=https"));


        }
    }
}

