package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.top_menu.ImagePage;
import pages.top_menu.WebPage;
import utils.TestUtils;


public class AutobahnTest extends BaseTest {
    @Test
    public void testBrazilianBotsAndError429Page() throws InterruptedException {
        WebPage webPage = new WebPage(getDriver());

        final String expectedErrorMessage = "Too many requests";
        openBaseURL()
                .inputSearchCriteriaAndEnter("\"iphone\"")
                .waitUntilVisibilityWebResult();

        for (int i = 0; i < 18; i++)  {
            webPage.searchAfterClear( "\"" + TestUtils.getRandomNameForBrazilBots() + " " + TestUtils.getRandomNameForBrazilBots()
                   + " " + TestUtils.getRandomNameForBrazilBots() + "\"");
            webPage.waitUntilVisibilityErrorImage();
            if (i == 11 - 1) {
               Assert.assertTrue(webPage.getTitleErrorText().contains(expectedErrorMessage));
                break;
            }
        }
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(webPage.getH2FontSize(),"40px");

    }
    @Test
    public void testRegularBotAndError429Page() throws InterruptedException {
        WebPage webPage = new WebPage(getDriver());

        final String expectedErrorMessage = "Too many requests";
        openBaseURL()
                .inputSearchCriteriaAndEnter("iphone")
                .waitUntilVisibilityWebResult();

        for (int i = 0; i < 130; i++)  {
            webPage.searchAfterClear(TestUtils.getRandomName());
            if (i == 130 - 1) {
                Assert.assertTrue(webPage.getTitleErrorText().contains(expectedErrorMessage));
                break;
            }
        }
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(webPage.getH2FontSize(),"40px");
    }
}
