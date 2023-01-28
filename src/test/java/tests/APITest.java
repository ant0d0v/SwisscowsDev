package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest extends BaseTest {

    @Test
    public void testOrangeButtonsArePresentOnThePage() {
        final int expectedAmountOfButtons = 30;

        int actualAmountOfButtons = openBaseURL()
                .clickAPIMenu()
                .getOrangeButtonsAmount();

        Assert.assertEquals(actualAmountOfButtons, expectedAmountOfButtons);
    }

    @Test
    public void testAPIPageHeader() {
        final String expectedHeader = "Weather API";

        String actualHeader = openBaseURL()
                .clickAPIMenu()
                .getH1Header();

        Assert.assertEquals(actualHeader, expectedHeader);
    }
}
