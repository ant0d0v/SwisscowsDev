package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.home.HomeUsersSignUpPage;

public class HomeSignUpTest extends BaseTest {

    @Test
    public void testErrorMessageWhenCreatingNewAccountWithoutCaptcha() {
        final String expectedReCaptchaErrorMessage = "reCAPTCHA verification failed, please try again.";

        String actualReCaptchaErrorMessage = openBaseURL()
                .clickSignInMenu()
                .clickCreateAnAccountLink()
                .clickClearInputNewUsername()
                .clickClearInputNewUserEmail()
                .clickClearInputNewUserPassword()
                .clickClearInputRepeatPassword()
                .clickAgeConfirmCheckbox()
                .clickAgreementCheckbox()
                .clickCreateAccountButton()
                .getErrorCaptchaMessage();

        Assert.assertEquals(actualReCaptchaErrorMessage, expectedReCaptchaErrorMessage);
    }

    @Test
    public void testPrivacyPolicySignUpLinkNavigatesToPrivacyPolicyPage() {
        final String expectedURL = "https://openweather.co.uk/privacy-policy";
        final String expectedTitle = "Privacy policy - OpenWeatherMap";

        final String oldURL = openBaseURL()
                .clickSignInMenu()
                .clickCreateAnAccountLink()
                .getCurrentURL();

        HomeUsersSignUpPage homeUsersSignUpPage = new HomeUsersSignUpPage(getDriver());

        homeUsersSignUpPage.clickPrivacyPolicy();
        homeUsersSignUpPage.switchToExternalPage();

        Assert.assertNotEquals(getExternalPageURL(), oldURL);
        Assert.assertEquals(getExternalPageURL(), expectedURL);
        Assert.assertEquals(getExternalPageTitle(), expectedTitle);
    }
}
