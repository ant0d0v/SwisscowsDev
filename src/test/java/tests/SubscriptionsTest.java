package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.SubscriptionsPage;

public class SubscriptionsTest extends BaseTest {
    @Test
    public void testBuySubscriptionPlatinum() throws InterruptedException {
        SubscriptionsPage subscriptionsPage= new SubscriptionsPage(getDriver());
        final String expectedSuccessfulMessage = "Congratulations,\n"
                + "the payment was successful!";
        final String actualSuccessfulMessage = openBaseURL()
                .clickHamburgerMenu()
                .signIn()
                .waitTopMenuToBeInvisible()
                .clickHamburgerMenu()
                .clickAccountInHamburgerMenu()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickConfirmButtonInPopup()
                .clickBuyNowButtonOfProduct()
                .clickBuyNowButtonOfMonthlyPlan()
                .clickMethodCard()
                .payByCard()
                .getTextSuccessfulMessage();

        Assert.assertEquals(actualSuccessfulMessage,expectedSuccessfulMessage);

    }
    @Test
    public void testCheckSubscriptionPlatinum() throws InterruptedException {
        final String expectedAttribute = "item active";
        final String actualAttribute = openBaseURL()
                .clickHamburgerMenu()
                .signIn()
                .waitTopMenuToBeInvisible()
                .clickHamburgerMenu()
                .clickAccountInHamburgerMenu()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .getAttributePlatinumSubscription();

        Assert.assertEquals(actualAttribute,expectedAttribute);

    }
    @Test
    public void testBuyVpnSubscriptionPlatinum() throws InterruptedException {
        SubscriptionsPage subscriptionsPage= new SubscriptionsPage(getDriver());
        final String expectedSuccessfulMessage = "Congratulations,\n"
                + "the payment was successful!";
        final String actualSuccessfulMessage = openBaseURL()
                .clickHamburgerMenu()
                .signIn()
                .waitTopMenuToBeInvisible()
                .clickHamburgerMenu()
                .clickAccountInHamburgerMenu()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .clickBuyNowButtonOfVpnSubscription()
                .clickConfirmButtonInPopup()
                .clickBuyNowButtonOfProduct()
                .clickBuyNowButtonOfMonthlyPlan()
                .clickMethodCard()
                .payByCard()
                .getTextSuccessfulMessage();

        Assert.assertEquals(actualSuccessfulMessage,expectedSuccessfulMessage);

    }
    @Test
    public void testUpgradeSubscription() throws InterruptedException {
        SubscriptionsPage subscriptionsPage= new SubscriptionsPage(getDriver());
        final String expectedAttribute = "item active";
        final String actualAttribute = openBaseURL()
                .clickHamburgerMenu()
                .signIn()
                .waitTopMenuToBeInvisible()
                .clickHamburgerMenu()
                .clickAccountInHamburgerMenu()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .getAttributeVpnSubscription();

        Assert.assertEquals(actualAttribute,expectedAttribute);
        Assert.assertEquals(subscriptionsPage.getAttributePlatinumSubscription(),"item");

    }
}
