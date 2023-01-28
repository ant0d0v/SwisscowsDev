package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CurrentWeatherPage;
import pages.MainPage;
import pages.TestData;
import pages.base_abstract.BasePage;
import utils.TestUtils;

import java.util.List;

public class MainTest extends BaseTest {

    @Test
    public void testSuggestIsDysplaed() {
        final String query = "test";

        MainPage mainPage = openBaseURL();

        mainPage
                .clickSearchField()
                .inputSearchCriteria(query)
                .clickMainLogo()
                .clickSearchField()
                .waitForSuggestToBeVisible();


        Assert.assertTrue(mainPage.suggestIsDisplayed());


    }

    @Test
    public void testSuggestEqualsSearchCriteria() {
        final String query = "ivan";

        MainPage mainPage = openBaseURL();

        mainPage
                .clickSearchField()
                .inputSearchCriteria(query)
                .clickMainLogo()
                .clickSearchField()
                .waitForSuggestToBeVisible();

        List<String> actualSuggestion = mainPage.getAllElementsText();

        for (String searchCriteria : actualSuggestion) {
            Assert.assertTrue(searchCriteria.contains(query));

        }
    }

    @Test
    public void testHomePageBanner() {

        MainPage mainPage = openBaseURL();

        Assert.assertTrue(mainPage.homePageBannerIsDisplayed());
    }




    // c
    @Test
    public void testHomePageBannerClickable () {

        final String expectedUrl = "https://dev.swisscows.com/en/music?query=popular+music";

        MainPage mainPage = openBaseURL();
        mainPage
                .clickHomeBanner()
                .switchToAnotherWindow();

        String actualUrl = getExternalPageURL();

        Assert.assertEquals(actualUrl,expectedUrl);
    }



}
