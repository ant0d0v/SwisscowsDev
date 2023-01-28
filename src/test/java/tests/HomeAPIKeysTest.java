package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.home.HomeAPIKeysPage;

import java.util.UUID;

public class HomeAPIKeysTest extends BaseTest {

    final static String API_KEYS_NAME = String.valueOf(UUID.randomUUID()).substring(0, 8);

    @Test
    public void testAPIKeysGenerated() {
        final String expectedNotificationMessage = "API key was created successfully";
        final String expectedAPIKeyStatus = "Active";

        HomeAPIKeysPage homeAPIKeysPage = openBaseURL()
                .signIn()
                .clickAPIKeysTab();

        int oldAmountOfExistingKeys = homeAPIKeysPage.getAmountOfExistingAPIKeys();

        homeAPIKeysPage
                .clickAPIKeyNameField()
                .inputNewName(API_KEYS_NAME)
                .clickGenerateKeysButton();

        int actualAmountOfKeys = homeAPIKeysPage.getAmountOfExistingAPIKeys();
        String actualNameOfNewKey = homeAPIKeysPage.getLastGeneratedAPIKeyName();
        String actualStatus = homeAPIKeysPage.getLastAPIKeyStatus();
        String successMessage = homeAPIKeysPage.confirmMessageAppears();

        Assert.assertEquals(actualAmountOfKeys, oldAmountOfExistingKeys + 1);
        Assert.assertEquals(actualNameOfNewKey, API_KEYS_NAME);
        Assert.assertEquals(actualStatus, expectedAPIKeyStatus);
        Assert.assertEquals(successMessage, expectedNotificationMessage);
    }

    @Test(dependsOnMethods = "testAPIKeysGenerated")
    public void testAPIKeysDeleted() {
        final String expectedNotificationMessage = "API key was deleted successfully";

        HomeAPIKeysPage homeAPIKeysPage = openBaseURL()
                .signIn()
                .clickAPIKeysTab();

        String lastKeyName = homeAPIKeysPage.getLastGeneratedAPIKeyName();

        Assert.assertEquals(lastKeyName, API_KEYS_NAME);

        homeAPIKeysPage.deleteLastAPIKey()
                .confirmAPIKeyDeletion();

        String actualLastKeyName = homeAPIKeysPage.getLastGeneratedAPIKeyName();
        String actualNotificationMessage = homeAPIKeysPage.confirmationMessageDeleted();

        Assert.assertNotEquals(actualLastKeyName, lastKeyName);
        Assert.assertEquals(actualNotificationMessage, expectedNotificationMessage);
    }
}
