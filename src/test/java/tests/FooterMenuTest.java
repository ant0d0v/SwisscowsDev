package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FooterMenuTest extends BaseTest {

    @Test
    public void testSocialPanelIconsNavigateToCorrespondingWebSites() {
        final List<String> links = List.of(
                "https://www.facebook.com/swisscows/",
                "https://twitter.com/swisscows_ch",
                "https://www.linkedin.com/authwall?trk=bf&trkInfo=AQFuutP8yP2NDwAAAYX_eJogFQhUFhjStomNWXxXyMfDTfaUTiDW86rJWhd1oVtNp4DfW1sjImPirI5XjJDnJSdq2Zs4a3GrvTb7V_OG87A1fb9eLiJzpkBA0abyxuA7e9Oa4g0=&original_referer=&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fcompany%2Fswisscows%2F",
                "https://www.instagram.com/swisscows.official/",
                "https://teleguard.com/en"

        );

        final List<String> expectedDomains = List.of(
                "www.facebook.com",
                "twitter.com",
                "www.linkedin.com",
                "www.instagram.com",
                "teleguard.com"

        );

        Assert.assertEquals(links.size(), expectedDomains.size());

        for (int i = 0; i < links.size(); i++) {
            String expectedDomain = expectedDomains.get(i);

            URL url = null;
            try {
                url = new URL(links.get(i));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            Assert.assertNotNull(url);

            String actualDomain = url.getHost();

            Assert.assertEquals(actualDomain, expectedDomain);
        }
    }
}
