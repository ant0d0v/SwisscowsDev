package tests.header;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.top_menu.EmailPage;
import utils.ProjectConstants;

import java.util.List;

public class EmailTest extends BaseTest {
    @QaseTitle("Check h2 texts")
    @QaseId(value = 5026)
    @Test
    public void testH2TextsEmailPage() {
        final List<String> expectedH2Texts = List.of(
                "Advantages",
                "What we guarantee with Swisscows.email:",
                "Prices",
                "Install Swisscows.email",
                "FAQ and Support"
        );
        final List<String> actualH2Texts = openBaseURL()
                .clickEmailTopMenu()
                .closeWindow()
                .switchToEmailPage()
                .getH2Texts();

        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
    }
    @QaseTitle("Check that email logo in the header to base url")
    @QaseId(value = 5027)
    @Test
    public void testEmailLogoNavigatesToBaseURL() {
        MainPage mainPage = new MainPage(getDriver());
        final String expectedURL = ProjectConstants.DOMAIN + "/en";

        final String expectedTitle = "Your private and anonymous search engine Swisscows";
        final String actualURL = openBaseURL()
                .clickEmailTopMenu()
                .closeWindow()
                .switchToEmailPage()
                .clickLogo()
                .getCurrentURL();

        final String actualTitle = mainPage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @QaseTitle("Check that links Of price containers navigate to corresponding pages")
    @QaseId(value = 5028)
    @Test(dataProvider = "LinksOfPriceContainersData", dataProviderClass = TestData.class)
    public void testLinksOfPriceContainersNavigateToCorrespondingPages_EmailPage(
            int index, String expectedTittle, String expectedUrl) {
        EmailPage emailPage = new EmailPage(getDriver());

        openBaseURL()
                .clickEmailTopMenu()
                .closeWindow()
                .switchToEmailPage();

        final String oldURL = emailPage.getCurrentURL();
        final String oldTittle = emailPage.getTitle();
        emailPage
                .clickAllLinksOfPriceContainers(index);

        final String actualURL = emailPage.getFormattedURL();
        final String actualTittle = emailPage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTittle, actualTittle);
        Assert.assertEquals(actualURL, expectedUrl);
        Assert.assertEquals(actualTittle, expectedTittle);
    }
    @QaseTitle("Check that links Of page containers navigate to corresponding pages")
    @QaseId(value = 5029)
    @Test(dataProvider = "LinksOfEmailPageData", dataProviderClass = TestData.class)
    public void testLinksOfOfEmailPageNavigateToCorrespondingPages_EmailPage(
            int index, String expectedTittle, String expectedH1Text) {
        EmailPage emailPage = new EmailPage(getDriver());

        openBaseURL()
                .clickEmailTopMenu()
                .closeWindow()
                .switchToEmailPage();

        final String oldH1Text = emailPage.getH1Text();
        final String oldTittle = emailPage.getTitle();

        emailPage
                .clickLinksOfEmailPage(index);

        final String actualH1Text = emailPage.getH1Text();
        final String actualTittle = emailPage.getTitle();

        Assert.assertNotEquals(oldH1Text, actualH1Text);
        Assert.assertNotEquals(oldTittle, actualTittle);
        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(actualTittle, expectedTittle);
    }
    @QaseTitle("Check colors of links")
    @QaseId(value = 5030)
    @Test
    public void testLinksColorsEmailPage() {
        List<String> expectedLinksColors = List.of(
                "rgba(255, 255, 255, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(255, 255, 255, 1)",
                "rgba(255, 255, 255, 1)"
        );
        List<String> actualLinksColors = openBaseURL()
                .clickEmailTopMenu()
                .closeWindow()
                .switchToEmailPage()
                .getColorLinks();

        Assert.assertEquals(actualLinksColors.size(), 9);
        Assert.assertEquals(actualLinksColors, expectedLinksColors);
    }
    @QaseTitle("Check font sizes  of texts")
    @QaseId(value = 5031)
    @Test
    public void testTextsFontSizesEmailPage() {
        final List<String> expectedH1FontSizes = List.of(
                "40px",
                "40px",
                "40px",
                "40px",
                "40px"
        );
        final List<String> actualH2FontSizes = openBaseURL()
                .clickEmailTopMenu()
                .closeWindow()
                .switchToEmailPage()
                .getH2FontSizes();

        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1FontSizes);
    }
    @QaseTitle("Check that install web link navigate to corresponding page")
    @QaseId(value = 5032)
    @Test
    public void testInstallWebLinkNavigateToCorrespondingPage() {
        final String actualUrl = openBaseURL()
                .clickEmailTopMenu()
                .closeWindow()
                .switchToEmailPage()
                .scrollToWhereToInstallEmail()
                .clickInstallWebLink()
                .getCurrentURL();

        final String actualTitle = getExternalPageTitle();

        Assert.assertTrue(actualUrl.contains("https://accounts.swisscows.com/login?ReturnUrl"));
        Assert.assertTrue(actualTitle.contains("Login"));
    }
    @QaseTitle("Check existence of all images on  page ")
    @QaseId(value = 5033)
    @Test
    public void testAllImageExist()  {
        final int expectedCountImages = 80;
        EmailPage emailPage = openBaseURL()
                .clickEmailTopMenu()
                .closeWindow()
                .switchToEmailPage();

        Assert.assertEquals(emailPage.getCountImagesOnPage(),expectedCountImages);
        Assert.assertTrue(emailPage.isLogoIconDisplayed());
        Assert.assertTrue(emailPage.allElementsDisplayed());
    }
    @QaseTitle("Check that start login and install and support buttons colors when hovering ")
    @QaseId(value = 5034)
    @Test
    public void testStartLoginAndInstallAndSupportButtonsColorsWhenHover_EmailPage() throws InterruptedException {
        EmailPage emailPage = new EmailPage(getDriver());
        final List<String> oldButtonColorsWhenHover = openBaseURL()
                .clickEmailTopMenu()
                .closeWindow()
                .switchToEmailPage()
                .getButtonStartAndInstallColors();

        final List<String> newButtonColorsWhenHover   = emailPage
                .getButtonsStartAndInstallColorsWhenHover();

        Assert.assertNotEquals(newButtonColorsWhenHover,oldButtonColorsWhenHover);
    }
    @QaseTitle("Check that order by  buttons colors when hovering ")
    @QaseId(value = 5035)
    @Test
    public void testOrderByButtonsColorsWhenHover_EmailPage() throws InterruptedException {
       EmailPage emailPage = new EmailPage(getDriver());
       final List<String> oldButtonColorsWhenHover = openBaseURL()
               .clickEmailTopMenu()
               .closeWindow()
               .switchToEmailPage()
               .getButtonColors();

       final List<String> newButtonColorsWhenHover = emailPage
               .getButtonColorsWhenHover();

       Assert.assertNotEquals(newButtonColorsWhenHover, oldButtonColorsWhenHover);

   }


}
