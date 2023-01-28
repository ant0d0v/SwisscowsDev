package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.home.HomeHistoryBulksNewPage;

import java.util.List;

public class HomeHistoryBulksNewTest extends BaseTest {

    @Test
    public void testWeatherParametersAreSelectedByDefault() {
        HomeHistoryBulksNewPage homeHistoryBulksNewPage = new HomeHistoryBulksNewPage(getDriver());

        List<WebElement> checkBoxes = openBaseURL()
                .clickMarketplaceMenu()
                .switchToMarketplaceWindow()
                .clickHistoryBulkMenu()
                .clickWeatherParametersButton()
                .getCheckBoxes();

        int selectedCount = homeHistoryBulksNewPage.getSelectedCount(checkBoxes);

        Assert.assertEquals(selectedCount, checkBoxes.size());
    }

    @Test(dependsOnMethods = "testWeatherParametersAreSelectedByDefault")
    public void testWeatherParametersAreNOTSelected_AfterUncheckAll() {
        HomeHistoryBulksNewPage homeHistoryBulksNewPage = new HomeHistoryBulksNewPage(getDriver());

        List<WebElement> checkBoxes = openBaseURL()
                .clickMarketplaceMenu()
                .switchToMarketplaceWindow()
                .clickHistoryBulkMenu()
                .clickWeatherParametersButton()
                .getCheckBoxes();

        homeHistoryBulksNewPage.clickAllWeatherParameters();

        int notSelectedAmount = homeHistoryBulksNewPage.getNOTSelectedCount(checkBoxes);

        Assert.assertEquals(notSelectedAmount, checkBoxes.size());
    }
}
