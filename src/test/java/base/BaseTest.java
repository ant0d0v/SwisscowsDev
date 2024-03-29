package base;

import io.qameta.allure.Attachment;
import io.qase.api.annotation.Step;
import io.restassured.http.ContentType;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.MainPage;
import utils.ReportUtils;
import utils.TestUtils;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;

import static io.restassured.RestAssured.given;

public abstract class BaseTest {

    private final static String BASE_URL = "https://dev.swisscows.com/en";

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public static String getBaseUrl() {
        return BASE_URL;
    }

    @BeforeSuite
    protected void beforeSuite(ITestContext context) {

        Reporter.log(ReportUtils.getReportHeader(context), true);
    }

    @BeforeMethod
    protected void beforeMethod(Method method, ITestResult result) {
        driver = BaseUtils.createDriver();

        Reporter.log(ReportUtils.END_LINE, true);
        Reporter.log("TEST RUN", true);
        Reporter.log(ReportUtils.getClassNameTestName(method, result), true);
    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod(Method method, ITestResult result) {
        if (!result.isSuccess()) {
            BaseUtils.captureScreenFile(driver, method.getName(), this.getClass().getName());
            captureScreenshot();
        }

        BaseUtils.logf("Execution time is %o sec\n\n", (result.getEndMillis() - result.getStartMillis()) / 1000);
        Reporter.log(ReportUtils.getTestStatistics(method, result), true);

        driver.quit();
        webDriverWait = null;
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] captureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        return webDriverWait;
    }


    @Step("Open the base URL of the web page.")
    public MainPage openBaseURL() {
        TestUtils.loadBaseUrlPage(getDriver(), getWait());

        if (TestUtils.isH2HeaderExists(getDriver())) {
            Reporter.log("BaseURL page was loaded successfully ", true);
        } else {
            TestUtils.reLoadBaseUrlPage(getDriver(), getWait());
        }

        return new MainPage(getDriver());
    }

    @Step("Open the base URL of the web page and get cookie of page")
    public MainPage openBaseURLAndGetCookie() {
        TestUtils.addCookie(getDriver(),TestUtils.getCookie(getDriver()));

        TestUtils.loadBaseUrlPage(getDriver(), getWait());
        if (TestUtils.isH2HeaderExists(getDriver())) {
            Reporter.log("BaseURL page was loaded successfully ", true);
        } else {
            TestUtils.reLoadBaseUrlPage(getDriver(), getWait());
        }

        return new MainPage(getDriver());
    }
    @Step("Get external page title")
    public String getExternalPageTitle() {
        if(getDriver().getTitle().isEmpty()) {
            TestUtils.waitForPageLoaded(getDriver());
        }

        return getDriver().getTitle();
    }
    @Step("Get url external page.")
    public String getExternalPageURL() {
        return getDriver().getCurrentUrl();
    }
}
