package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.DonationPage;
import java.io.IOException;
import java.util.List;


public class DonationTest extends BaseTest {
    @Test
    public void testPdfLinkCHFDonation() throws IOException {
        DonationPage donationPage = new DonationPage(getDriver());
        final String oldURL = openBaseURL().getCurrentURL();
        String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickDonationPageFooterMenu()
                .getCurrentURL();
        String pdfContent = donationPage
                .scrollToWherePaymentBlock()
                .clickQrCodeChf()
                .getPdfText("https://dev.swisscows.com/docs/Swisscows_Donation_CHF_t.pdf");

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertTrue(pdfContent.contains(""));


    }
    @Test
    public void testPdfLinkEuroDonation() throws IOException {
        DonationPage donationPage = new DonationPage(getDriver());
        final String oldURL = openBaseURL().getCurrentURL();
        String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickDonationPageFooterMenu()
                .getCurrentURL();
        String pdfContent = donationPage
                .scrollToWherePaymentBlock()
                .clickQrCodeEuro()
                .getPdfText("https://dev.swisscows.com/docs/Swisscows_Donation_EUR_t.pdf");

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertTrue(pdfContent.contains(""));
    }
    @Test(dataProvider = "DonationLinksData", dataProviderClass = TestData.class)
    public void testDonationLinksNavigateToCorrespondingPages(
            int index, String linkName, String href, String expectedURL,String expectedH1Header) throws InterruptedException {
        DonationPage donationPage = new DonationPage(getDriver());
        MainPage mainPage = openBaseURL();
        final String oldURL = mainPage
                .scrollToFooterMenu()
                .clickDonationPageFooterMenu()
                .getCurrentURL();
        final String oldH1Header = donationPage.getH1Text();

        donationPage
                .scrollToWhereH1Header()
                .clickAllLinksToDonationPage(index);

        final String actualURL = getExternalPageURL();
        final String actualH1Header = donationPage.getH1Text();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldH1Header, actualH1Header);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualH1Header, expectedH1Header);
    }
    @Test
    public void testH1TextsDonationPage(){
        List<String> expectedH1Texts = List.of(
                "Swisscows is the anonymous search engine",
                "Helping and supporting"
        );
        List<String> actualH1Texts = openBaseURL()
                .scrollToFooterMenu()
                .clickDonationPageFooterMenu()
                .getH1Texts();
        Assert.assertTrue(actualH1Texts.size() > 0);
        Assert.assertEquals(actualH1Texts, expectedH1Texts);


    }
    @Test
    public void testH1ColorsDonationPage(){
        List<String> expectedH1Colors = List.of(
                "rgba(191, 0, 0, 1)",
                "rgba(191, 0, 0, 1)"
        );
        List<String>  actualH1Colors = openBaseURL()
                .scrollToFooterMenu()
                .clickDonationPageFooterMenu()
                .getH1Colors();

        Assert.assertTrue(actualH1Colors.size() > 0);
        Assert.assertEquals(actualH1Colors, expectedH1Colors);

    }

}
