package tests.footer;

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

        final String oldUrl = mainPage.getCurrentURL();

        final String actualText1 = mainPage
                .scrollToFooter()
                .clickAboutUsFooterMenu()
                .getH1Text();

        final String newUrl = mainPage.getCurrentURL();

        Assert.assertNotEquals(oldUrl, newUrl);
        Assert.assertEquals(actualText1, expectedH1Text);
    }
        @Test(dataProvider = "WhoWeAreLinksData", dataProviderClass = TestData.class)
        public void testWhoWeAreLinksNavigateToCorrespondingPages(
        int index, String linkName, String href, String expectedURL, String expectedH1text) throws InterruptedException {
            WhoWeArePage whoWeArePage = new WhoWeArePage(getDriver());
            MainPage mainPage = new MainPage(getDriver());

            final String oldURL = openBaseURL()
                    .scrollToFooterMenu()
                    .clickAboutUsFooterMenu()
                    .getCurrentURL();

            final String oldH1Text = mainPage.getH1Text();

            whoWeArePage
                    .scrollToWhereToH2Header()
                    .clickAllLinks(index);

            final String actualURL = mainPage.getCurrentURL();
            final String actualH1Text = mainPage.getH1Text();

            Assert.assertNotEquals(oldURL, actualURL);
            Assert.assertNotEquals(oldH1Text, actualH1Text);
            Assert.assertEquals(actualURL, expectedURL);
            Assert.assertEquals(actualH1Text, expectedH1text);
        }
    @Test
    public void testLinksColorsWhoWeArePage() {
        final List<String> expectedLinksColors = List.of(
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)"

        );
        final List<String> actualLinksColors = openBaseURL()
                .scrollToFooterMenu()
                .clickAboutUsFooterMenu()
                .getColorLinks();

        Assert.assertTrue(actualLinksColors.size() > 0);
        Assert.assertEquals(actualLinksColors, expectedLinksColors);
    }
}

