package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.WhoWeArePage;
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
}
