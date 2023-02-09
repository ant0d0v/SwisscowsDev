package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.DonationPage;


public class DonationTest extends BaseTest {

    @Test
    public void testPdfLinkCHFDonation() throws InterruptedException {
        DonationPage donationPage = new DonationPage(getDriver());
        final String expectedPdfLink = "https://dev.swisscows.com/docs/Swisscows_Donation_CHF_t.pdf";
        final String oldURL = openBaseURL().getCurrentURL();
        String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickDonationPageFooterMenu()
                .getCurrentURL();
        ;
        donationPage
                .scrollToWherePaymentBlock()
                .clickQrCodeChf();
        String actualPdfLink = getExternalPageURL();
        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualPdfLink,expectedPdfLink);

    }
    @Test
    public void testPdfLinkEuroDonation() throws  InterruptedException {
        DonationPage donationPage = new DonationPage(getDriver());
        final String expectedPdfLink = "https://dev.swisscows.com/docs/Swisscows_Donation_EUR_t.pdf";
        final String oldURL = openBaseURL().getCurrentURL();
        String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickDonationPageFooterMenu()
                .getCurrentURL();
        donationPage
                .scrollToWherePaymentBlock()
                .clickQrCodeEuro();
        String actualPdfLink = getExternalPageURL();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualPdfLink,expectedPdfLink);
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

}
