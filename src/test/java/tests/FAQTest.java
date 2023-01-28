package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FAQTest extends BaseTest {

    @Test
    public void testFAQHeader() {
        final String expectedHeader = "Frequently Asked Questions";

        String actualHeader = openBaseURL()
                .clickSupportMenu()
                .clickFAQSupportSubmenu()
                .getH1Header();

        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void testH3HeadersAmount() {
        final int expectedH3HeadersAmount = 10;

        int actualH3HeadersAmount = openBaseURL().
                clickSupportMenu().
                clickFAQSupportSubmenu().
                getH3HeadersAmount();

        Assert.assertEquals(actualH3HeadersAmount, expectedH3HeadersAmount);
    }

    @Test
    public void testFAQInnerDescriptionsAmount() {
        final int expectedOpenedFAQAmount = 59;

        int actualOpenedFAQAmount = openBaseURL()
                .clickSupportMenu()
                .clickFAQSupportSubmenu()
                .getOpenedFAQAmount();

        Assert.assertEquals(actualOpenedFAQAmount, expectedOpenedFAQAmount);
    }
}
