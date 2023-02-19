package tests.api;

import api.ApiHelpers;
import api.CaptureNetworkTraffic;
import api.model.Current;
import base.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.WebPage;
import utils.DateTimeUtils;
import utils.TestUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class API_WebTest extends BaseTest {
    final static String DATA_URL = "https://openweathermap.org/data/2.5/";
    final static String PARIS_URL_ONECALL = DATA_URL
            + "onecall?lat=48.8534&lon=2.3488&units=metric&appid=439d4b804bc8187953eb36d2a8c26a02";
    final static String PARIS_URL_WEATHER = DATA_URL + "weather?id=2988507&appid=439d4b804bc8187953eb36d2a8c26a02";
    static HttpResponse<String> response;
    static String city;
    static String country;
    static long weatherTemp;
    static long weatherFeelsLike;
    static String weatherDescription;
    static List<String> weatherDescriptionList = new ArrayList<>();

    @Test
    public void test_API_CNTRequest_OpenWebURL()  {
        List<String> requests = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequestsContain("/web/search?");

        openBaseURL()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult();


        Assert.assertNotNull(requests);
        for (int i = 0; i < requests.size(); i += 2) {
            if(requests.get(i).equals("GET" )){
                Assert.assertEquals(requests.get(i), "GET");
            }else {
                Assert.assertEquals(requests.get(i), "OPTIONS");
            }
        }
        for (int i = 1; i < requests.size(); i += 2 ) {
            Assert.assertTrue(requests.get(i).contains("dev.swisscows.com/"));
        }
    }

    @Test
    public void test_API_CNTResponse_OpenWebURL() {
        List<String> responses = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponsesContain("/web/search?");

        openBaseURL()
                .inputSearchCriteriaAndEnter("Crocs")
                .waitUntilVisibilityWebResult();

        Assert.assertNotNull(responses);
        for (int i = 0; i < responses.size(); i += 4) {
            if(responses.get(i).equals("200" )){
                Assert.assertEquals(responses.get(i), "200");
            }else{
                Assert.assertEquals(responses.get(i), "204");
            }
        }
        for (int i = 2; i < responses.size(); i += 4) {
            Assert.assertTrue(responses.get(i).contains("dev.swisscows.com/"));
        }
        Assert.assertTrue(Double.parseDouble(responses.get(3).substring(10, 14)) <= 3);
    }

    @Test
    public void test_API_CNTRequests_Suggest() throws InterruptedException {

        WebPage webPage = new WebPage(getDriver());
        List<String> requests = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequestsContain("/web/search?");

        openBaseURL()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult();

        Assert.assertNotNull(requests);
        if (requests.get(requests.size() - 2).equals("GET")) {
            Assert.assertEquals(requests.get(requests.size() - 2), "GET");
            ;
        } else {
            Assert.assertEquals(requests.get(requests.size() - 2), "OPTIONS");
        }
        Assert.assertTrue(requests.get(requests.size() - 1)
                .contains("dev.swisscows.com/web/search?query=ronaldo"));

        webPage.clickSearchFieldHeader();
        webPage.clickChoiceInDropDownList();
        sleep(2000);

        Assert.assertNotNull(requests);
        System.out.println(requests);
        if (requests.get(requests.size() - 2).equals("GET")) {
            Assert.assertEquals(requests.get(requests.size() - 2), "GET");
            ;
        } else {
            Assert.assertEquals(requests.get(requests.size() - 2), "OPTIONS");
        }
        System.out.println(requests);
        Assert.assertTrue(requests.get(requests.size() - 1)
                .contains("dev.swisscows.com/web/search?query=ronaldo+cristiano"));
    }

}
