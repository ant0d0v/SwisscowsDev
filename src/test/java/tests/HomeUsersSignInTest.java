package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.home.HomePage;
import pages.home.HomeUsersSignInPage;

public class HomeUsersSignInTest extends BaseTest {

    @Test
    public void testSignOut() {
        String actualSignOutMessage = openBaseURL()
                .signIn()
                .signOut()
                .getNotification();

        Assert.assertEquals(actualSignOutMessage, "You need to sign in or sign up before continuing.");
    }

    @Test
    public void testLogInWithInvalidPassword() {
        final String expectedNoticeMessage = "Invalid Email or password.";
        final String expectedSignInMenuText = "Sign In";
        final String userPassword = "Tester11#";

        final String oldSignInMenuText = openBaseURL()
                .clickSignInMenu()
                .getSignInText();

        HomeUsersSignInPage homeUsersSignInPage = new HomeUsersSignInPage(getDriver());

        homeUsersSignInPage
                .clickClearInputRegularUserEmail()
                .clickClearInputRegularUserPassword(userPassword)
                .clickSubmitButton();

        String actualNoticeMessage = homeUsersSignInPage.getNotification();
        String actualSignInMenuText = homeUsersSignInPage.getSignInText();

        Assert.assertEquals(actualNoticeMessage, expectedNoticeMessage);
        Assert.assertEquals(actualSignInMenuText, oldSignInMenuText);
        Assert.assertEquals(actualSignInMenuText, expectedSignInMenuText);
    }

    @Test
    public void testLogInWithPasswordIsCaseSensitive() {
        final String expectedNoticeMessage = "Invalid Email or password.";
        final String expectedSignInMenuText = "Sign In";
        final String userPassword = "tester12#";

        final String oldSignInMenuText = openBaseURL()
                .clickSignInMenu()
                .getSignInText();

        HomeUsersSignInPage homeUsersSignInPage = new HomeUsersSignInPage(getDriver());

        homeUsersSignInPage
                .clickClearInputRegularUserEmail()
                .clickClearInputRegularUserPassword(userPassword)
                .clickSubmitButton();

        String actualNoticeMessage = homeUsersSignInPage.getNotification();
        String actualSignInMenuText = homeUsersSignInPage.getSignInText();

        Assert.assertEquals(actualNoticeMessage, expectedNoticeMessage);
        Assert.assertEquals(actualSignInMenuText, oldSignInMenuText);
        Assert.assertEquals(actualSignInMenuText, expectedSignInMenuText);
    }

    @Test(dataProvider = "SignInCredentials", dataProviderClass = TestData.class)
    public void testSignInWithInvalidCredentials(String scenario, String userEmail, String userPassword, String expectedNoticeMessage, String expectedSignInMenuText) {

        final String oldSignInMenuText = openBaseURL()
                .clickSignInMenu()
                .getSignInText();

        HomeUsersSignInPage homeUsersSignInPage = new HomeUsersSignInPage(getDriver());

        homeUsersSignInPage
                .clickClearInputRegularUserEmail(userEmail)
                .clickClearInputRegularUserPassword(userPassword)
                .clickSubmitButton();

        String actualNoticeMessage = homeUsersSignInPage.getNotification();
        String actualSignInMenuText = homeUsersSignInPage.getSignInText();

        Assert.assertEquals(actualNoticeMessage, expectedNoticeMessage);
        Assert.assertEquals(actualSignInMenuText, oldSignInMenuText);
        Assert.assertEquals(actualSignInMenuText, expectedSignInMenuText);
    }
}

