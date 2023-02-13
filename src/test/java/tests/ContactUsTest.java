package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.footer_menu.ContactUsPage;

public class ContactUsTest extends BaseTest {
    @Test
    public void testFormContactUs() {
        final String expectedSuccessMessage = "Thank you for contacting us!";
        final String oldURL = openBaseURL().getCurrentURL();
        final String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickContactUsPageFooterMenu()
                .getCurrentURL();

        final String actualSuccessMessage = new ContactUsPage(getDriver())
                .sendFormContactUs()
                .getThanksMessage();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
    }

    @Test
    public void testContactUsButtonNavigateToCorrespondingPages() {
        final String expectedUrl = "https://dev.swisscows.com/en";
        final String oldURL = openBaseURL().getCurrentURL();

        final String newURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickContactUsPageFooterMenu()
                .getCurrentURL();

        final String actualUrl = new ContactUsPage(getDriver())
                .sendFormContactUs()
                .clickBackToSearchButton()
                .getCurrentURL();

        Assert.assertNotEquals(newURL, oldURL);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void testPrivacyPolicyLinkNavigateToCorrespondingPages() {
        final String expectedUrl = "https://dev.swisscows.com/en/privacy";
        final String actualUrl = openBaseURL()
                    .scrollToFooter()
                    .clickContactUsPageFooterMenu()
                    .clickPrivacyPolicyLink()
                    .getCurrentURL();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void testLinksColorContactUsPage() {
        final String expectedLinksColors =
                "rgba(223, 93, 93, 1)";
        final String actualLinksColors = openBaseURL()
                .scrollToFooterMenu()
                .clickContactUsPageFooterMenu()
                .getColorPrivacyLink();

        Assert.assertEquals(actualLinksColors, expectedLinksColors);

    }

}
