package tests.api;

import api.CaptureNetworkTraffic;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class API_MusicTest extends BaseTest {
    @Test
    public void test_API_Images_Cdn_Swisscows() throws InterruptedException {
        List<String> requests = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequestsContain("https://api.dev.swisscows.com/audio/search/");

        openBaseURL()
                .inputSearchCriteriaAndEnter("ivanka")
                .waitUntilVisibilityWebResult()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .clickMusicButton()
                .waitUntilVisibilityAudioResult();

        sleep(1000);
        System.out.println(requests);

        for (int i = 1; i < requests.size(); i += 2 ) {
            Assert.assertTrue(requests.get(i).contains("https://api.swisscows.com/audio/search/tracks?query=ivanka&offset=0&itemsCount=20&region=de-DE"));


        }
    }
}

