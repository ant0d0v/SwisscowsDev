package tests.header_tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.top_menu.VpnPage;
import utils.ProjectConstants;

import java.util.List;

public class VpnPageTest extends BaseTest {

    @Test
    public void testH2TextsVpnPage() {
        final List<String> expectedH2Texts = List.of(
                "How to use Swisscows proxy server?",
                "How does a Swisscows proxy server work?",
                "Set up subscription for Swisscows VPN"

        );
        final List<String> actualH2Texts = openBaseURL()
                .clickVPNTopMenu()
                .getH2Texts();
        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
    }

    @Test
    public void testVpnLogoNavigatesToBaseURL() {
        final String expectedURL = ProjectConstants.DOMAIN +"/en";
        final String expectedTitle = "Your private and anonymous search engine Swisscows";

        MainPage mainPage = openBaseURL();
        final String actualURL = mainPage
                .clickVPNTopMenu()
                .clickLogo()
                .getCurrentURL();

        final String actualTitle = mainPage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(dataProvider = "VpnLinksData", dataProviderClass = TestData.class)
    public void testVpnLinksNavigateToCorrespondingPages(
            int index, String expectedURL, String expectedH1text){
        VpnPage vpnPage = new VpnPage(getDriver());
        MainPage mainPage = new MainPage(getDriver());

        openBaseURL()
                .clickVPNTopMenuAndCloseWindow()
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
                .getColorLinks();

        Assert.assertTrue(actualLinksColors.size() > 0);
        Assert.assertEquals(actualLinksColors, expectedLinksColors);
    }

    @Test
    public void testTextsFontSizesVpnPage() {
        final List<String> expectedH1FontSizes = List.of(
                "40px",
                "40px",
                "40px"
        );
        final List<String> actualH2FontSizes = openBaseURL()
                .clickVPNTopMenu()
                .getH2FontSizes();

        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1FontSizes);
    }

    @Test
    public void testRegisterLinkNavigateToCorrespondingPage() {
        VpnPage vpnPage = new VpnPage(getDriver());
        final String expectedUrl = "https://accounts.swisscows.com/register";

        final String actualUrl = openBaseURL()
                .clickVPNTopMenuAndCloseWindow()
                .switchToVpnPage()
                .scrollToWhereToInstructions()
                .clickRegisterLink()
                .getCurrentURL();
        final String actualTitle = getExternalPageTitle();

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(actualTitle.contains("Register - Swisscows Accounts"));
    }

    @Test
    public void testInstructionLinkNavigateToCorrespondingPage() {
        final String expectedUrl = ProjectConstants.DOMAIN + "/en/vpn-instruction";
        VpnPage vpnPage = new VpnPage(getDriver());

        final String actualUrl = openBaseURL()
                .clickVPNTopMenuAndCloseWindow()
                .switchToVpnPage()
                .scrollToWhereToInstructions()
                .clickInstructionsLink()
                .getCurrentURL();
        final String actualTitle = new MainPage(getDriver()).getH1Text();


        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(actualTitle.contains("Configuring Swisscows Proxy"));
    }

    @Test
    public void testExtensionsIconsExist() {
        VpnPage vpnPagePage = openBaseURL()
                .clickVPNTopMenu()
                .scrollToWhereExtensionsBlock();

        Assert.assertTrue(vpnPagePage.isLogoIconDisplayed());
        Assert.assertTrue(vpnPagePage.isGoogleExtensionIconDisplayed());
        Assert.assertTrue(vpnPagePage.isMozillaExtensionIconDisplayed());
        Assert.assertTrue(vpnPagePage.isOtherExtensionIconDisplayed());
        Assert.assertTrue(vpnPagePage.allElementsDisplayed());
    }

    @Test
    public void testAllButtonColorsWhenHover_VpnPage() throws InterruptedException {
        VpnPage vpnPage = new VpnPage(getDriver());
        final List<String> oldButtonColorsWhenHover = openBaseURL()
                .clickVPNTopMenu()
                .getButtonColors();


        final List<String> newButtonColorsWhenHover = vpnPage
                .getButtonColorsWhenHover();

        Assert.assertNotEquals(newButtonColorsWhenHover, oldButtonColorsWhenHover);
    }

    @Test
    public void testStarNowButtonColorWhenHover_VpnPage(){
        VpnPage vpnPage = new VpnPage(getDriver());
        final String oldButtonColor = openBaseURL()
                .clickVPNTopMenu()
                .backgroundColorOfElement();

        final String newButtonColor = vpnPage
                .hoverElement()
                .backgroundColorOfElement();

        Assert.assertNotEquals(newButtonColor, oldButtonColor);
    }


}
