package tests.header;

import base.BaseTest;
import org.testng.Assert;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.VpnInstructionsPage;
import utils.ProjectConstants;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class VpnInstructionsTest extends BaseTest {
    @Test
    public void testH2TextsVpnInstructionsPage() {
        final List<String> expectedH2Texts = List.of(
                    "Safari Browser (Mac OS)",
                    "Brave Browser",
                    "Opera Browser",
                    "Vivaldi Browser",
                    "MS Edge (Chromium) Browser",
                    "Microsoft Internet Explorer Browser",
                    "Windows 10 OS",
                    "Android OS"

            );
        final List<String> actualH2Texts = openBaseURL()
                    .clickVPNTopMenuAndCloseWindow()
                    .switchToVpnPage()
                    .clickInstructionsLink()
                    .getH2Texts();

        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
    }

    @Test
    public void testVpnLogoNavigatesToBaseURL() {
        final String expectedURL = ProjectConstants.DOMAIN + "/en";
        final String expectedTitle = "Your private and anonymous search engine Swisscows";

        MainPage mainPage = openBaseURL();
        final String actualURL = mainPage
                    .clickVPNTopMenuAndCloseWindow()
                    .switchToVpnPage()
                    .clickInstructionsLink()
                    .clickLogo()
                    .getCurrentURL();

        final String actualTitle = mainPage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void testTextsFontSizesVpnInstructionsPage() {
        final List<String> expectedH1FontSizes = List.of(
                    "24px",
                    "24px",
                    "24px",
                    "24px",
                    "24px",
                    "24px",
                    "24px",
                    "24px"
            );
        final List<String> actualH2FontSizes = openBaseURL()
                    .clickVPNTopMenuAndCloseWindow()
                    .switchToVpnPage()
                    .clickInstructionsLink()
                    .getH2FontSizes();

        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1FontSizes);
    }

    @Test
    public void testAllBrowserIconsExist() {
        VpnInstructionsPage vpnInstructionsPage = openBaseURL()
                    .clickVPNTopMenuAndCloseWindow()
                    .switchToVpnPage()
                    .clickInstructionsLink();

        Assert.assertTrue(vpnInstructionsPage.isLogoIconDisplayed());
        Assert.assertTrue(vpnInstructionsPage.allElementsDisplayed());
    }
    @Test
    public void testVpnExtensionsLinksNavigateToCorrespondingWebSites() {
        final List<String> links = List.of(
                "https://chrome.google.com/webstore/detail/swisscowsvpn",
                "https://addons.mozilla.org/en-GB/firefox/addon/swisscows-vpn/"

        );

        final List<String> expectedDomains = List.of(
                "chrome.google.com",
                "addons.mozilla.org"

        );
        openBaseURL()
                .clickVPNTopMenuAndCloseWindow()
                .switchToVpnPage()
                .clickInstructionsLink();

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

