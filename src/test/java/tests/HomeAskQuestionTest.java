package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ProjectConstants;

public class HomeAskQuestionTest extends BaseTest {

    @Test
    public void testErrorMessageWhenCaptchaNotVerified() {
        final String expectedMessage = "reCAPTCHA verification failed, please try again.";

        String actualMessage = openBaseURL()
                .clickSupportMenu()
                .clickAskQuestionSupportSubmenu()
                .inputTextInEmailTextbox(ProjectConstants.EMAIL)
                .selectSubject(ProjectConstants.SUBJECT)
                .inputTextInMessageTextbox(ProjectConstants.MESSAGE_TEXT)
                .clickOnSubmitButton()
                .getErrorMessageText();

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void testRadioButtonMessage() {
        String expectedMessage =
                "Please enter your account email in our system - it will help us process your request faster";

        String actualMessage = openBaseURL()
                .clickSupportMenu()
                .clickAskQuestionSupportSubmenu()
                .clickYesRadioButton()
                .getRadioButtonText();

        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
