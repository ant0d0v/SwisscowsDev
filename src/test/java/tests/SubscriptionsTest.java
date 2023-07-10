package tests;
import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.SubscriptionsPage;

public class SubscriptionsTest extends BaseTest {
    @QaseTitle("Check  that the Email Standard subscription can be successfully purchased.")
    @QaseId(value = 4914)
    @Test(priority = 1)
    public void testBuySubscriptionEmailStandard() throws InterruptedException {
        final String expectedSuccessfulMessage = "Congratulations,\n"
                + "the payment was successful!";
        openBaseURL()
                .clickHamburgerMenu()
                .signIn()
                .clickHamburgerMenu()
                .clickAccountInHamburgerMenu()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickConfirmButtonInPopup()
                .clickBuyNowButtonOfProduct()
                .clickBuyNowButtonOfMonthlyPlan()
                .clickMethodCard()
                .payByCard()
                .waitForUrlContains("https://accounts.dev.swisscows.com/products/swisscows-email-standard/buy/success");

        final String actualSuccessfulMessage = new SubscriptionsPage(getDriver())
                .waitSuccessImage()
                .getTextSuccessfulMessage();
        Assert.assertEquals(actualSuccessfulMessage,expectedSuccessfulMessage);
    }
    @QaseTitle("Check that the Email Standard subscription is active.")
    @QaseId(value = 4915)
    @Test(priority = 2)
    public void testCheckSubscriptionEmailStandard() throws InterruptedException {
        final String expectedAttribute = "item active";
        final String actualAttribute = openBaseURL()
                .clickHamburgerMenu()
                .signIn()
                .clickHamburgerMenu()
                .clickAccountInHamburgerMenu()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .getAttributeEmailStandardSubscription();

        Assert.assertEquals(actualAttribute,expectedAttribute);
    }
    @QaseTitle("Check  that the Platinum subscription can be successfully purchased.")
    @QaseId(value = 4916)
    @Test(priority = 3)
    public void testBuySubscriptionPlatinum() throws InterruptedException {
        final String expectedSuccessfulMessage = "Congratulations,\n"
                + "the payment was successful!";
        openBaseURL()
                .clickHamburgerMenu()
                .signIn()
                .clickHamburgerMenu()
                .clickAccountInHamburgerMenu()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickConfirmButtonInPopup()
                .clickBuyNowButtonOfProduct()
                .clickBuyNowButtonOfMonthlyPlan()
                .clickMethodCard()
                .payByCard();

        final String actualSuccessfulMessage = new SubscriptionsPage(getDriver())
                .waitSuccessImage()
                .getTextSuccessfulMessage();
        Assert.assertEquals(actualSuccessfulMessage,expectedSuccessfulMessage);

    }
    @QaseTitle("Check that Platinum  subscription is active.")
    @QaseId(value = 4917)
    @Test(priority = 4)
    public void testUpgradeSubscription() throws InterruptedException {
        SubscriptionsPage subscriptionsPage= new SubscriptionsPage(getDriver());
        final String expectedAttribute = "item active";
        final String actualAttribute = openBaseURL()
                .clickHamburgerMenu()
                .signIn()
                .clickHamburgerMenu()
                .clickAccountInHamburgerMenu()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .getAttributePlatinumSubscription();

        Assert.assertEquals(actualAttribute,expectedAttribute);
        Assert.assertEquals(subscriptionsPage.getAttributeEmailStandardSubscription(),"item");

    }
}
