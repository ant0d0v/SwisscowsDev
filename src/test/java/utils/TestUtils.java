package utils;

import base.BaseTest;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class TestUtils {

    private final static By H2_HEADER = By.xpath("//div[@class = 'logo-home']//h1");
    private final static By ON_LOAD_CONTAINER = By.xpath("//div[@class = 'badges animation-badges']");

    public static void loadBaseUrlPage(WebDriver driver, WebDriverWait wait) {
        driver.get(BaseTest.getBaseUrl());
        waitForPageLoaded(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ON_LOAD_CONTAINER));
    }


    public static void waitForPageLoaded(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public static void reLoadBaseUrlPage(WebDriver driver, WebDriverWait wait) {
        int count = 0;
        while (count <= 3 && !(isH2HeaderExists(driver))) {
            loadBaseUrlPage(driver, wait);
            count++;
        }

        if (count == 3 && !isH2HeaderExists(driver)) {
            Reporter.log("!!!!! Error !!!!! BaseURL page was NOT loaded. Re-Run jobs\n", true);
        }
    }

    public static boolean isH2HeaderExists(WebDriver driver) {
        boolean isExists = true;
        try {
            driver.findElement(H2_HEADER);
        } catch (NoSuchElementException e) {
            isExists = false;
        }

        return isExists;
    }

    public static String getRandomName(int length) {

        return RandomStringUtils
                .random(length,
                        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
    }
    public static String getRandomNameForBrazilBots(int length) {

        return RandomStringUtils
                .random(length,
                        "abcdefghijklmnopqrst");
    }

    public static String getRandomName() {

        return getRandomName(7);
    }
    public static String getRandomNameForBrazilBots() {

        return getRandomNameForBrazilBots(7);
    }

    public static int convertStringToInt(String text) {

        return Integer.parseInt(text);
    }

    public static String getSubstring(String text, String separator) {
        int index = text.indexOf(separator);

        return text.substring(0, index);
    }
    public static String getCookie (WebDriver driver){
        driver.get("https://accounts.dev.swisscows.com/profile");
        return given()
                .contentType(ContentType.JSON)
                .body("{\"email\":\"a.qa@swisscows.email\",\"password\":\"2075Deltuha\",\"returnUrl\":\"/login\"}")
                .post("https://accounts.dev.swisscows.com/api/account/login")
                .then().log().all().extract().cookie(".AspNetCore.Identity.Application");
    }
    public static void addCookie(WebDriver driver, String cookieValue){
        Date expDate = new Date();
        expDate.setTime(expDate.getTime() + (10000 * 10000));
        Cookie cookie = new Cookie(".AspNetCore.Identity.Application", cookieValue, "accounts.dev.swisscows.com", "/", expDate);
        driver.manage().addCookie(cookie);
    }

    public static List<String> getSortedList(List<String> elements) {

        return elements.stream().sorted().collect(Collectors.toList());
    }
}
