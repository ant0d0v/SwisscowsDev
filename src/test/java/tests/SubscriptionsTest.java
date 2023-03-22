package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.SubscriptionsPage;

public class SubscriptionsTest extends BaseTest {
    @Test(priority = 1)
    public void testBuySubscriptionPlatinum() throws InterruptedException {
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
    @Test(priority = 2)
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
    @Test(priority = 3)
    public void testBuyVpnSubscriptionPlatinum() throws InterruptedException {
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
    @Test(priority = 4)
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
