package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.top_menu.WebPage;
import utils.TestUtils;


public class AutobahnTest extends BaseTest {
    @Test
    public void testBrazilianBots() throws InterruptedException {
        WebPage webPage = new WebPage(getDriver());
        String[] queries = { "\"iphone totti forover  \"",
                "\"iphone totti forover  \"",
                "\"iphone totti forover \"",
                "\"iphone totti forover \"",
                "\"iphone totti forover \"",
                "\"iphone totti forover \"",
                "\"iphone totti forover \"",
                "\"iphone totti forover \"",
                "\"iphone totti forover \"",
                "\"iphone totti forover \"",
                "\"iphone totti forover \"",
                "\"iphone totti forover \"",
                "\"iphone totti forover \"",
                "\"iphone totti forover \"",
                "\"iphone totti forover \"",
                "\"iphone totti forover \"",

        };

        final String expectedErrorMessage = "Too many requests";
        openBaseURL()
                .inputSearchCriteriaAndEnter("\"iphone totti forover \"")
                .waitUntilVisibilityWebResult();

        for (int i = 0; i < queries.length; i++)  {
            webPage.searchAfterClear(queries[i]);

            if (i == queries.length - 1) {
               Assert.assertTrue(webPage.getTitleErrorText().contains(expectedErrorMessage));
                break;
            }
        }
        Assert.assertTrue(webPage.errorImageIsDisplayed());

    }
    @Test
    public void testRegularBot() throws InterruptedException {
        final String random = TestUtils.getRandomName();
        WebPage webPage = new WebPage(getDriver());
        String[] queries = { random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random
                + random,random,random,random,random,random,random,random,random,random



        };

        final String expectedErrorMessage = "Too many requests";
        openBaseURL()
                .inputSearchCriteriaAndEnter("iphone")
                .waitUntilVisibilityWebResult();

        for (int i = 0; i < queries.length; i++)  {
            webPage.searchAfterClear(queries[i]);

            if (i == queries.length - 1) {
                Assert.assertTrue(webPage.getTitleErrorText().contains(expectedErrorMessage));
                break;
            }
        }
        Assert.assertTrue(webPage.errorImageIsDisplayed());
    }
}
