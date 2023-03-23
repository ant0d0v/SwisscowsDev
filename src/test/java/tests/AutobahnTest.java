package tests;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.top_menu.WebPage;

import java.util.List;

public class AutobahnTest extends BaseTest {
    @Test
    public void testBrazilianBots() {
        WebPage webPage = new WebPage(getDriver());

        final String expectedErrorMessage = "Too many requests";
        openBaseURL()
                .inputSearchCriteriaAndEnter("\"Otras características a considerar \"")
                .waitUntilVisibilityWebResult();


        String[] queries = { "\"Otras carateríticas a considerar \"", "\"Otras carateríticas a considerar \"", "\"Otras carateríticas a considerar \"",
                "\"Otras carateríticas a considerar \"", "\"Otras carateríticas a considerar \"", "\"Otras carateríticas a considerar \"",
                "\"Otras carateríticas a considerar \"", "\"Otras carateríticas a considerar \"", "\"Otras carateríticas a considerar \""};

        for (String query : queries) {
            webPage.searchAfterClear(query);
            if (webPage.getTitleErrorText().contains("Too many")) {
               Assert.assertTrue(webPage.getTitleErrorText().contains(expectedErrorMessage));
                break;
            }
        }
        Assert.assertTrue(webPage.errorImageIsDisplayed());


    }
}
