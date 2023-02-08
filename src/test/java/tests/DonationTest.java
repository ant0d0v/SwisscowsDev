package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.footer_menu.DonationPage;
import java.io.IOException;

public class DonationTest extends BaseTest {

    @Test
    public void testPdfLinkCHFDonation() throws IOException {
        DonationPage donationPage = new DonationPage(getDriver());
        final String expectedPdfLink = "https://dev.swisscows.com/docs/Swisscows_Donation_CHF_t.pdf";
        final String oldURL = openBaseURL().getCurrentURL();
        String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickDonationPageFooterMenu()
                .getCurrentURL();
        String actualPdfLink = donationPage
                .scrollToWherePaymentBlock()
                .clickQrCodeChf()
                .getCurrentURL();
        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualPdfLink,expectedPdfLink);

    }
    @Test
    public void testPdfLinkEuroDonation() throws IOException {
        DonationPage donationPage = new DonationPage(getDriver());
        final String expectedPdfLink = "https://dev.swisscows.com/docs/Swisscows_Donation_EUR_t.pdf";
        final String oldURL = openBaseURL().getCurrentURL();
        String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickDonationPageFooterMenu()
                .getCurrentURL();
        String actualPdfLink = donationPage
                .scrollToWherePaymentBlock()
                .clickQrCodeEuro()
                .getCurrentURL();
        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualPdfLink,expectedPdfLink);
    }
}
