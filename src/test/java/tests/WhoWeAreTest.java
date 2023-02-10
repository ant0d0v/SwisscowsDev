package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.WhoWeArePage;

import java.util.List;

public class WhoWeAreTest extends BaseTest {

    @Test
    public void testH1text() {
        final String expectedH1Text = "The search engine without tracking – Swisscows";

        MainPage mainPage = openBaseURL();
        String oldUrl = mainPage.getCurrentURL();
        String actualText1 = mainPage
                .scrollToFooter()
                .clickAboutUsFooterMenu()
                .getH1Text();
        String newUrl = mainPage.getCurrentURL();
        Assert.assertNotEquals(oldUrl, newUrl);
        Assert.assertEquals(actualText1, expectedH1Text);
    }
        @Test(dataProvider = "WhoWeAreLinksData", dataProviderClass = TestData.class)
        public void testWhoWeAreLinksNavigateToCorrespondingPages(
        int index, String linkName, String href, String expectedURL, String expectedTitle) throws InterruptedException {

            MainPage mainPage = openBaseURL();
            mainPage
                    .scrollToFooterMenu()
                    .clickAboutUsFooterMenu();

            final String oldURL = mainPage.getCurrentURL();
            final String oldTitle = mainPage.getTitle();

            mainPage.scrollToFooterMenu();
            WhoWeArePage whoWeArePage = new WhoWeArePage(getDriver());
            whoWeArePage
                    .scrollToWhereToH2Header()
                    .clickAllLinks(index);

            String actualURL = mainPage.getCurrentURL();
            String actualTitle = getDriver().getTitle();

            Assert.assertNotEquals(oldURL, actualURL);
            Assert.assertNotEquals(oldTitle, actualTitle);
            Assert.assertEquals(actualURL, expectedURL);
            Assert.assertEquals(actualTitle, expectedTitle);
        }
    @Test
    public void testLinksColorsWhoWeArePage() {
        List<String> expectedLinksColors = List.of(
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)"



        );
        List<String> actualLinksColors = openBaseURL()
                .scrollToFooterMenu()
                .clickAboutUsFooterMenu()
                .getColorLinks();

        Assert.assertTrue(actualLinksColors.size() > 0);
        Assert.assertEquals(actualLinksColors, expectedLinksColors);

    }




    }

