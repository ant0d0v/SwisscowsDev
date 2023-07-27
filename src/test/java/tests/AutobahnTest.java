package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.top_menu.ImagePage;
import pages.top_menu.WebPage;
import utils.ProjectConstants;
import utils.TestUtils;

import static io.restassured.RestAssured.given;


public class AutobahnTest extends BaseTest {
    final String errorMessage = "Too many requests";

    @QaseTitle("Check Queries Rate Limit for \"Brazillian bots\"")
    @QaseId(value = 4875)
    @Test
    public void testBrazilianBotsAndError429Page()  {
        WebPage webPage = new WebPage(getDriver());

        Header nonceHeader = new Header("Request-Nonce", "HxKCS7QWGay1C6--VD0sRoWu.DVUluq.");
        Header signatureHeader = new Header("X-Request-Signature", "V67ilp9bISPgKVx5hmuSGlWApZkXXy74jZ6WurtRm2I");


        openBaseURL()
                .inputSearchCriteriaAndEnter("\"iphone\"")
                .waitUntilVisibilityWebResult();

        for (int i = 0; i < 10; i++) {
            RestAssured
                    .given()
                    .header(nonceHeader)
                    .header(signatureHeader)
                    .queryParam("query","\"Otras características considerar\"")
                    .get("https://api.dev.swisscows.com/web/search");
        }

        webPage.searchAfterClear("\"" + TestUtils.getRandomNameForBrazilBots() + " " + TestUtils.getRandomNameForBrazilBots()
                + " " + TestUtils.getRandomNameForBrazilBots() + "\"");


        Assert.assertTrue(webPage.getTitleErrorText().contains(errorMessage));
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(webPage.getH2FontSize(), ProjectConstants.FONT_SIZE_40_PX);

    }
    @QaseTitle("Check Queries Rate Limit for Regular Bot")
    @QaseId(value = 4889)
    @Test
    public void testRegularBotAndError429Page() {
        WebPage webPage = new WebPage(getDriver());

        Header nonceHeader = new Header("Request-Nonce", "5CMgl0NqUuUhq7._dd57XvBNUhhrkdZT");
        Header signatureHeader = new Header("X-Request-Signature", "oa0ctwcngO5R120H9nAb5yNESv1r7KTffC-xL4aenr0");

        openBaseURL()
                .inputSearchCriteriaAndEnter("iphone")
                .waitUntilVisibilityWebResult()
                .getCurrentURL();

        for (int i = 0; i < 60; i++) {
            RestAssured
                    .given()
                    .header(nonceHeader)
                    .header(signatureHeader)
                    .queryParam("query","iphone")
                    .get("https://api.dev.swisscows.com/web/search");
             webPage.searchAfterClear(TestUtils.getRandomName());
        }

        webPage.searchAfterClear(TestUtils.getRandomName());

        Assert.assertTrue(webPage.getTitleErrorText().contains(errorMessage));
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(webPage.getH2FontSize(), ProjectConstants.FONT_SIZE_40_PX);
    }
}
