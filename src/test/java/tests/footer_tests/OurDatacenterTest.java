package tests.footer_tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.OurDatacenterPage;
import utils.ProjectConstants;

import java.util.List;


public class OurDatacenterTest extends BaseTest {

    @Test
    public void testHTML5VideoPlayer_Datacenter() throws Exception {
        OurDatacenterPage ourDatacenterPage = new OurDatacenterPage(getDriver());
        final String expectedSource = ProjectConstants.DOMAIN + "/video/swisscows-promo.mp4";
        final String source = openBaseURL()
                .scrollToFooterMenu()
                .clickOurDatacenterPageFooterMenu()
                .getCurrentSrcOfVideo();
        ourDatacenterPage
                .playVideoDatacenter()
                .waitUntilTimeOfVideoChanged(2000)
                .pauseVideoDatacenter()
                .screen("dataCentre.png");

        Assert.assertEquals(source, expectedSource);
    }
    @Test
    public void testHTML5VideoPlayerUsingGermanyLocalization_Datacenter() throws Exception {
        OurDatacenterPage ourDatacenterPage = new OurDatacenterPage(getDriver());
        final String expectedSource = ProjectConstants.DOMAIN + "/video/SWISSCOWS.mp4";
        final String source = openBaseURL()
                .scrollToFooterMenu()
                .clickOurDatacenterPageFooterMenu()
                .clickHamburgerMenu()
                .clickLanguagesTopMenu()
                .clickGermanyLang()
                .getCurrentSrcOfVideo();
        ourDatacenterPage
                .playVideoDatacenter()
                .waitUntilTimeOfVideoChanged(2000)
                .pauseVideoDatacenter()
                .screen("dataCentreGermany.png");

        Assert.assertEquals(source, expectedSource);
    }


    @Test(dataProvider = "OurDatacenterLinksData", dataProviderClass = TestData.class)
    public void testOurDatacenterLinksNavigateToCorrespondingPages(
            int index, String linkName, String href, String expectedURL) throws InterruptedException {
        OurDatacenterPage ourDatacenterPage = new OurDatacenterPage(getDriver());
        MainPage mainPage = openBaseURL();
        final String oldURL = mainPage
                .scrollToFooterMenu()
                .clickOurDatacenterPageFooterMenu()
                .getCurrentURL();
        ourDatacenterPage
                .scrollToWhereToH2Header()
                .clickAllLinks(index);

        final String actualURL = ourDatacenterPage.getCurrentURL();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void testOurDatacenterSlider() {
        OurDatacenterPage ourDatacenterPage = new OurDatacenterPage(getDriver());
        final String oldAttribute = openBaseURL()
                .scrollToFooterMenu()
                .clickOurDatacenterPageFooterMenu()
                .scrollToSlider()
                .getClassAttributeOfImageSlider();

        final String newAttribute = ourDatacenterPage
                .doubleClickToSecondImageInSlider()
                .waitUntilSecondImageToBeVisible()
                .getClassAttributeOfImageSlider();

        Assert.assertNotEquals(newAttribute, oldAttribute);
        Assert.assertTrue(ourDatacenterPage.elementIsDisplayedInSlider());
    }

    @Test
    public void testLinksColorsDataCenterPage() {
        List<String> expectedLinksColors = List.of(
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)"


        );
        List<String> actualLinksColors = openBaseURL()
                .scrollToFooterMenu()
                .clickOurDatacenterPageFooterMenu()
                .getColorLinks();

        Assert.assertTrue(actualLinksColors.size() > 0);
        Assert.assertEquals(actualLinksColors, expectedLinksColors);

    }

}
