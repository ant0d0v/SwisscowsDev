package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;


public class SummaryTest extends BaseTest {
    @QaseId(value = 4876)
    @Test
    public void testOpenVersionTxtSwisscowsPage() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedTextInSummaryPage = "3.5";


        final String actualTitle404Error = mainPage
                .openVersionTxtPageSwisscows()
                .getTextInSummaryPage();

        Assert.assertTrue(actualTitle404Error.contains(expectedTextInSummaryPage));
    }
    @QaseId(value = 4883)
    @Test
    public void testOpenVersionTxtAccountPage() {
        MainPage mainPage = new MainPage(getDriver());

        final String expectedTextInSummaryPage = "4.";


        final String actualTitle404Error = mainPage
                .openVersionTxtPageAccount()
                .getTextInSummaryPage();

        Assert.assertTrue(actualTitle404Error.contains(expectedTextInSummaryPage));
    }



}
