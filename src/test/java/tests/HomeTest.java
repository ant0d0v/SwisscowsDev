package tests;

import base.BaseTest;
import base.BaseUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.home.HomePage;
import pages.home.HomeUsersSignInPage;

import java.util.List;

public class HomeTest extends BaseTest {

    @Test
    public void testSuccessfulSignIn() {
        String actualSignInMessage = openBaseURL()
                .signIn()
                .getNotification();

        Assert.assertEquals(actualSignInMessage, "Signed in successfully.");
    }

    @Test
    public void testH2Headers() {
        final List<String> expectedH2Headers = List.of(
                "Historical weather for any location",
                "Weather Dashboard",
                "Agricultural Dashboard and Agro API"
        );

        openBaseURL().signIn();

        List<String> actualH2Headers = new HomePage(getDriver()).getListH2Headers();

        Assert.assertEquals(actualH2Headers, expectedH2Headers);
    }

    @Test
    public void testOrangeButtonsAreClickableAndVisible() {
        int count = 0;

        HomePage homePage = new HomePage(getDriver());

        List<WebElement> orangeButtons = openBaseURL()
                .signIn()
                .getOrangeButtons();

        for (WebElement button : orangeButtons) {
            if (button.isEnabled() && button.isDisplayed()) {
                homePage.waitUntilButtonIsClickable(button);
                count++;
            }
        }

        Assert.assertEquals(count, orangeButtons.size());
    }

    @Test
    public void testLogInWithEmailIsNotCaseSensitive() {
        final String expectedNoticeMessage = "Signed in successfully.";
        final String expectedUserMenuText = "Tester";
        final String userEmail = "jKA59433@xcOxc.com";

        final String signInMenuText = openBaseURL()
                .clickSignInMenu()
                .getSignInText();

        new HomeUsersSignInPage(getDriver())
                .clickClearInputRegularUserEmail(userEmail)
                .clickClearInputRegularUserPassword()
                .clickSubmitButton();

        HomePage homePage = new HomePage(getDriver());
        String actualNoticeMessage = homePage.getNotification();
        String actualUserMenuText = homePage.getUserMenuText();

        Assert.assertEquals(actualNoticeMessage, expectedNoticeMessage);
        Assert.assertNotEquals(actualUserMenuText, signInMenuText);
        Assert.assertEquals(actualUserMenuText, expectedUserMenuText);
    }

    @Test
    public void testSignInNavigatesToHomePage() {
        final String expectedURL = "https://home.openweathermap.org/";
        final String expectedTitle = "Members";

        final String oldURL = openBaseURL()
                .getCurrentURL();

        String actualURL = new HomeUsersSignInPage(getDriver())
                .signIn()
                .getCurrentURL();

        String actualTitle = new HomePage(getDriver())
                .getTitle();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testLogInRememberMeTokenSaveInCookie() {
        final String userEmail = "jKA59433@xcOxc.com";

        openBaseURL()
                .clickSignInMenu();
        Cookie remember_user_token_old = getDriver().manage().getCookieNamed("remember_user_token");
        Assert.assertTrue(remember_user_token_old==null);

        new HomeUsersSignInPage(getDriver())
                .clickClearInputRegularUserEmail(userEmail)
                .clickClearInputRegularUserPassword()
                .checkRemeberMeCheckBox()
                .clickSubmitButton();

        Cookie remember_user_token_new = getDriver().manage().getCookieNamed("remember_user_token");

        Assert.assertTrue(remember_user_token_new!=null);
        Assert.assertFalse(remember_user_token_new.getValue().isEmpty());
    }
}
