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
import utils.TestUtils;

import static io.restassured.RestAssured.given;


public class AutobahnTest extends BaseTest {
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


        Assert.assertTrue(webPage.getTitleErrorText().contains("Too many requests"));
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(webPage.getH2FontSize(),"40px");

    }
    @QaseTitle("Check Queries Rate Limit for Regular Bot")
    @QaseId(value = 4889)
    @Test
    public void testRegularBotAndError429Page() {
        WebPage webPage = new WebPage(getDriver());

        Header nonceHeader = new Header("Request-Nonce", "I6iO_D0fwZOi8HsyXaUQraP8SgqL8cBl");
        Header signatureHeader = new Header("X-Request-Signature", "SLQ8JkCtYy4jwTM1_jyvtCcNsaQpOsmtvbgR_1XnBUo");

        openBaseURL()
                .inputSearchCriteriaAndEnter("iphone")
                .waitUntilVisibilityWebResult()
                .getCurrentURL();

        for (int i = 0; i < 110; i++) {
            RestAssured
                    .given()
                    .header(nonceHeader)
                    .header(signatureHeader)
                    .get("https://api.dev.swisscows.com/web/search?query=ddsf&offset=0&itemsCount=10&region=uk-UA&freshness=All");
        }

        webPage.searchAfterClear(TestUtils.getRandomName());

        Assert.assertTrue(webPage.getTitleErrorText().contains("Too many requests"));
        Assert.assertTrue(webPage.errorImageIsDisplayed());
        Assert.assertEquals(webPage.getH2FontSize(),"40px");
    }
}
