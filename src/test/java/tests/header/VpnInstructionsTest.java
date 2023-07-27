package tests.header;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.VpnInstructionsPage;
import utils.ProjectConstants;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class VpnInstructionsTest extends BaseTest {
    @QaseTitle("Check h2 texts")
    @QaseId(value = 5046)
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
    @QaseTitle("Check that vpn logo navigate to base url")
    @QaseId(value = 5047)
    @Test
    public void testVpnLogoNavigatesToBaseURL() {

        final String actualURL = openBaseURL()
                    .clickVPNTopMenuAndCloseWindow()
                    .switchToVpnPage()
                    .clickInstructionsLink()
                    .clickLogo()
                    .getCurrentURL();

        final String actualTitle = new MainPage(getDriver()).getTitle();

        Assert.assertEquals(actualURL, ProjectConstants.DOMAIN + "/en");
        Assert.assertEquals(actualTitle, "Your private and anonymous search engine Swisscows");
    }
    @QaseTitle("Check font sizes of texts")
    @QaseId(value = 5048)
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
    @QaseTitle("Check that browser icons are displayed")
    @QaseId(value = 5049)
    @Test
    public void testAllBrowserIconsExist() {
        VpnInstructionsPage vpnInstructionsPage = openBaseURL()
                    .clickVPNTopMenuAndCloseWindow()
                    .switchToVpnPage()
                    .clickInstructionsLink();

        Assert.assertTrue(vpnInstructionsPage.isLogoIconDisplayed());
        Assert.assertTrue(vpnInstructionsPage.allElementsDisplayed());
    }
    @QaseTitle("Check that vpn extensions links navigate to corresponding page")
    @QaseId(value = 5050)
    @Test
    public void testVpnExtensionsLinksNavigateToCorrespondingWebSites() {
        final List<String> expectedLinks = List.of(
                "https://chrome.google.com/webstore/detail/swisscowsvpn/nglddggbgngenfgaelmmmhldofddjlmh",
                "https://addons.mozilla.org/firefox/addon/swisscows-vpn/"

        );

        final List<String> actualLinks  = openBaseURL()
                .clickVPNTopMenuAndCloseWindow()
                .switchToVpnPage()
                .clickInstructionsLink()
                .getListOfExtensionsLinks();

        Assert.assertEquals(actualLinks,expectedLinks);

    }
}

