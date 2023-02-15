package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.top_menu.VpnPage;

import java.util.List;

public class VpnTest extends BaseTest {
    @Test
    public void testH2TextsVpnPage() {
        final List<String> expectedH2Texts = List.of(
                "How to use Swisscows proxy server?",
                "How does a Swisscows proxy server work?",
                "Set up subscription for Swisscows VPN"

        );
        final List<String> actualH2Texts = openBaseURL()
                .clickVPNTopMenu()
                .closeWindow()
                .switchToVpnPage()
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
                .clickLogo()
                .getCurrentURL();

        final String actualTitle = mainPage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test(dataProvider = "VpnLinksData", dataProviderClass = TestData.class)
    public void testVpnLinksNavigateToCorrespondingPages(
            int index, String linkName, String href, String expectedURL, String expectedH1text) throws InterruptedException {
        VpnPage vpnPage = new VpnPage(getDriver());

        MainPage mainPage = openBaseURL();
        mainPage
                .clickVPNTopMenu()
                .closeWindow()
                .switchToVpnPage();

        final String oldURL = mainPage.getCurrentURL();
        final String oldH1Text = mainPage.getH1Text();
        vpnPage
                .clickTopMenuExternalLink(index);

        final String actualURL = mainPage.getCurrentURL();
        final String actualH1Text = mainPage.getH1Text();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldH1Text, actualH1Text);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualH1Text, expectedH1text);
    }
    @Test
    public void testLinksColorsVpnPage() {
        List<String> expectedLinksColors = List.of(
                "rgba(255, 255, 255, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)"
        );
        List<String> actualLinksColors = openBaseURL()
                .clickVPNTopMenu()
                .closeWindow()
                .switchToVpnPage()
                .getColorLinks();

        Assert.assertTrue(actualLinksColors.size() > 0);
        Assert.assertEquals(actualLinksColors, expectedLinksColors);
    }

    @Test
    public void testTextsFontSizesVpnPage(){
        final List<String> expectedH1FontSizes = List.of(
                "40px",
                "40px",
                "40px"
        );
        final List<String>  actualH2FontSizes = openBaseURL()
                .clickVPNTopMenu()
                .closeWindow()
                .switchToVpnPage()
                .getH2FontSizes();

        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1FontSizes);
    }
    @Test
    public void testRegisterLinkNavigateToCorrespondingPage() {
        final String expectedUrl = "https://accounts.swisscows.com/register";
        final String actualUrl = openBaseURL()
                .clickVPNTopMenu()
                .closeWindow()
                .switchToVpnPage()
                .scrollToWhereToInstructions()
                .clickRegisterLink()
                .getCurrentURL();
        final String actualTitle = getExternalPageTitle();

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(actualTitle.contains("Registration made easy! - Swisscows Account"));
    }
    @Test
    public void testInstructionLinkNavigateToCorrespondingPage() {
        final String expectedUrl = "https://dev.swisscows.com/en/vpn-instruction";
        final String actualUrl = openBaseURL()
                .clickVPNTopMenu()
                .closeWindow()
                .switchToVpnPage()
                .scrollToWhereToInstructions()
                .clickInstructionsLink()
                .getCurrentURL();
        final String actualTitle = new MainPage(getDriver()).getH1Text();
        System.out.println(actualTitle);

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(actualTitle.contains("Configuring Swisscows Proxy"));
    }
    @Test
    public void testExtensionsIconsExist() {
        VpnPage vpnPagePage = openBaseURL()
                .clickVPNTopMenu()
                .closeWindow()
                .switchToVpnPage()
                .scrollToWhereExtensionsBlock();

        Assert.assertTrue(vpnPagePage.isLogoIconDisplayed());
        Assert.assertTrue(vpnPagePage.isGoogleExtensionIconDisplayed());
        Assert.assertTrue(vpnPagePage.isMozillaExtensionIconDisplayed());
        Assert.assertTrue(vpnPagePage.isOtherExtensionIconDisplayed());
    }

}
