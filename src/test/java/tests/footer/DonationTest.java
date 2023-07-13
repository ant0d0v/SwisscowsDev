package tests.footer;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.DonationPage;
import pages.top_menu.EmailPage;
import utils.ProjectConstants;

import java.io.IOException;
import java.util.List;


public class DonationTest extends BaseTest {
    @QaseTitle("Check PDF Link for CHF Donation")
    @QaseId(value = 4983)
    @Test
    public void testPdfLinkCHFDonation() throws IOException {
        DonationPage donationPage = new DonationPage(getDriver());
        final String oldURL = openBaseURL().getCurrentURL();
        final String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickDonationPageFooterMenu()
                .getCurrentURL();
        final String pdfContent = donationPage
                .scrollToWherePaymentBlock()
                .clickQrCodeChf()
                .getPdfText(ProjectConstants.DOMAIN +"/docs/Swisscows_Donation_CHF_t.pdf");

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertTrue(pdfContent.contains(""));
    }
    @QaseTitle("Check PDF Link for Euro Donation")
    @QaseId(value = 4984)
    @Test
    public void testPdfLinkEuroDonation() throws IOException{
        DonationPage donationPage = new DonationPage(getDriver());
        final String oldURL = openBaseURL().getCurrentURL();
        final String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickDonationPageFooterMenu()
                .getCurrentURL();
        final String pdfContent = donationPage
                .scrollToWherePaymentBlock()
                .clickQrCodeEuro()
                .getPdfText(ProjectConstants.DOMAIN + "/docs/Swisscows_Donation_EUR_t.pdf");

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertTrue(pdfContent.contains(""));
    }
    @QaseTitle("Check donation Links Navigate to Corresponding Pages")
    @QaseId(value = 4985)
    @Test(dataProvider = "DonationLinksData", dataProviderClass = TestData.class)
    public void testDonationLinksNavigateToCorrespondingPages(
            int index, String linkName, String href, String expectedURL,String expectedH1Header) throws InterruptedException {
        DonationPage donationPage = new DonationPage(getDriver());

        final String oldURL = openBaseURL()
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
    @QaseTitle("Check h1 text on the page ")
    @QaseId(value = 4986)
    @Test
    public void testH1TextsDonationPage(){
        final List<String> expectedH1Texts = List.of(
                "Swisscows is the anonymous search engine",
                "Helping and supporting"
        );
        final List<String> actualH1Texts = openBaseURL()
                .scrollToFooterMenu()
                .clickDonationPageFooterMenu()
                .getH1Texts();
        Assert.assertTrue(actualH1Texts.size() > 0);
        Assert.assertEquals(actualH1Texts, expectedH1Texts);


    }
    @QaseTitle("Check colors of h1 text on the page ")
    @QaseId(value = 4987)
    @Test
    public void testH1ColorsDonationPage(){
        final List<String> expectedH1Colors = List.of(
                "rgba(191, 0, 0, 1)",
                "rgba(191, 0, 0, 1)"
        );
        final List<String>  actualH1Colors = openBaseURL()
                .scrollToFooterMenu()
                .clickDonationPageFooterMenu()
                .getH1Colors();

        Assert.assertTrue(actualH1Colors.size() > 0);
        Assert.assertEquals(actualH1Colors, expectedH1Colors);

    }
    @QaseTitle("Check colors of links on the page ")
    @QaseId(value = 4988)
    @Test
    public void testLinksColorsDonationPage() {
        final List<String> expectedLinksColors = List.of(
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)"

        );
        final List<String> actualLinksColors = openBaseURL()
                .scrollToFooterMenu()
                .clickDonationPageFooterMenu()
                .getColorLinksDonation();

        Assert.assertTrue(actualLinksColors.size() > 0);
        Assert.assertEquals(actualLinksColors, expectedLinksColors);

    }
    @QaseTitle("Check existence of all images on  page")
    @QaseId(value = 4989)
    @Test
    public void testAllImageExistDonationPage() {
        DonationPage donationPage = openBaseURL()
                .scrollToFooterMenu()
                .clickDonationPageFooterMenu();

        Assert.assertTrue(donationPage.isLogoIconDisplayed());
        Assert.assertTrue(donationPage.allElementsDisplayed());
    }

}
