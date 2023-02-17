package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.VpnInstructionsPage;

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
                .clickVPNTopMenu()
                .closeWindow()
                .switchToVpnPage()
                .clickInstructionsLink()
                .getH2Texts();

        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
    }

    @Test
    public void testVpnLogoNavigatesToBaseURL() {
        final String expectedURL = "https://dev.swisscows.com/en";
        final String expectedTitle = "Your private and anonymous search engine Swisscows";

        MainPage mainPage = openBaseURL();
        final String actualURL = mainPage
                .clickVPNTopMenu()
                .closeWindow()
                .switchToVpnPage()
                .clickInstructionsLink()
                .clickLogo()
                .getCurrentURL();

        final String actualTitle = mainPage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testTextsFontSizesVpnInstructionsPage(){
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
        final List<String>  actualH2FontSizes = openBaseURL()
                .clickVPNTopMenu()
                .closeWindow()
                .switchToVpnPage()
                .clickInstructionsLink()
                .getH2FontSizes();

        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1FontSizes);
    }
   @Test
    public void testVpnChromeLinkNavigateToCorrespondingPage() {
        final String expectedUrl = "https://chrome.google.com/webstore/detail/swisscowsvpn/nglddggbgngenfgaelmmmhldofddjlmh";
       VpnInstructionsPage vpnInstructionsPage = openBaseURL()
               .clickVPNTopMenu()
               .closeWindow()
               .switchToVpnPage()
               .clickInstructionsLink()
               .closeWindow()
               .switchToVpnPage()
               .clickVpnChromeLink()
               .closeWindow()
               .switchToVpnPage();

       final String actualUrl  = getExternalPageURL();
       final String actualTitle = getExternalPageTitle();

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(actualTitle.contains("Swisscows.VPN - Chrome Web Store"));
    }
    @Test
    public void testVpnMozillaLinkNavigateToCorrespondingPage() {
        final String expectedUrl = "https://addons.mozilla.org/en-GB/firefox/addon/swisscows-vpn/";
        VpnInstructionsPage vpnInstructionsPage = openBaseURL()
                .clickVPNTopMenu()
                .closeWindow()
                .switchToVpnPage()
                .clickInstructionsLink()
                .closeWindow()
                .switchToVpnPage()
                .clickVpnMozillaLink()
                .closeWindow()
                .switchToVpnPage();
        final String actualUrl  = getExternalPageURL();
        final String actualTitle = getExternalPageTitle();

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(actualTitle.contains("Swisscows.VPN – Get this Extension"));
    }
    @Test
    public void testAllBrowserIconsExist() {
        VpnInstructionsPage vpnInstructionsPage = openBaseURL()
                .clickVPNTopMenu()
                .closeWindow()
                .switchToVpnPage()
                .clickInstructionsLink();

        Assert.assertTrue(vpnInstructionsPage.isLogoIconDisplayed());
        Assert.assertTrue(vpnInstructionsPage.allElementsDisplayed());
    }
}
