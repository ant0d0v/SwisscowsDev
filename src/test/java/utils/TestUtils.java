package utils;

import base.BaseTest;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import io.qameta.allure.Attachment;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.Assertion;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class TestUtils{

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
    public static String getCookie(WebDriver driver){
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
    public static void assertScreen(Method method,WebDriver driver) throws IOException {
        String expectedFileName = method.getName();
        String expectedScreenDir = "src/test/resources/screens/";

        File actualScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File expectedScreenshot = new File(expectedScreenDir + expectedFileName + ".png");

        if (!expectedScreenshot.exists()) {
            addImgToAllure("actual", actualScreenshot);
            throw new IllegalArgumentException("Cannot assert image, because there is no reference. "
                    + "Actual screenshot can be downloaded from Allure.");
        }

        BufferedImage expectedImage = ImageIO.read(expectedScreenshot);
        BufferedImage actualImage = ImageIO.read(actualScreenshot);

        File resultDestination = new File("target/diffs/diff_" + expectedFileName + ".png");

        ImageComparison imageComparison = new ImageComparison(expectedImage, actualImage, resultDestination);
        ImageComparisonResult result = imageComparison.compareImages();

        if (!result.getImageComparisonState().equals(ImageComparisonState.MATCH)) {
            addImgToAllure("actual", actualScreenshot);
            addImgToAllure("expected", expectedScreenshot);
            addImgToAllure("diff", resultDestination);
        }

       Assertions.assertEquals(ImageComparisonState.MATCH, result.getImageComparisonState());

    }

    private static void addImgToAllure(String name, File file) {
        try {
            byte[] image = Files.readAllBytes(file.toPath());
            saveScreenshot(name, image);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read bytes");
        }
    }

    @Attachment(value = "{name}", type = "image/png")
    private static byte[] saveScreenshot(String name, byte[] image) {
        return image;
    }

    public static List<String> getSortedList(List<String> elements) {

        return elements.stream().sorted().collect(Collectors.toList());
    }
}
