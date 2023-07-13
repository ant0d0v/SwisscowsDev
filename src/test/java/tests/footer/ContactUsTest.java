package tests.footer;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.footer_menu.ContactUsPage;
import pages.footer_menu.MediaEducationPage;
import utils.ProjectConstants;

public class ContactUsTest extends BaseTest {
    @QaseTitle("Check form submission on Contact Us Page")
    @QaseId(value = 4978)
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
                .waitToBeVisibleThanksMessage()
                .getThanksMessage();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
    }
    @QaseTitle("Check that contact Us Button navigates to corresponding pages")
    @QaseId(value = 4979)
    @Test
    public void testContactUsButtonNavigateToCorrespondingPages() {
        final String expectedUrl = ProjectConstants.DOMAIN +"/en";
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
    @QaseTitle("Check that privacy policy link navigates to corresponding pages")
    @QaseId(value = 4980)
    @Test
    public void testPrivacyPolicyLinkNavigateToCorrespondingPages() {
        final String expectedUrl = ProjectConstants.DOMAIN + "/en/privacy";
        final String actualUrl = openBaseURL()
                    .scrollToFooter()
                    .clickContactUsPageFooterMenu()
                    .clickPrivacyPolicyLink()
                    .getCurrentURL();

        Assert.assertEquals(actualUrl, expectedUrl);
    }
    @QaseTitle("Check that colors of links on the page")
    @QaseId(value = 4981)
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
    @QaseTitle("Check that send button color when hovering")
    @QaseId(value = 4982)
    @Test
    public void testSendButtonColorWhenHover_ContactUsPage() throws InterruptedException {
        ContactUsPage contactUsPage  = new ContactUsPage (getDriver());
        final String oldButtonColor = openBaseURL()
                .scrollToFooterMenu()
                .clickContactUsPageFooterMenu()
                .backgroundColorOfElement();

        final String newButtonColor  = contactUsPage
                .hoverElement()
                .backgroundColorOfElement();

        Assert.assertNotEquals(newButtonColor,oldButtonColor);

    }

}
