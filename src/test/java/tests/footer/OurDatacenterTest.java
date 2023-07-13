package tests.footer;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.OurDatacenterPage;
import utils.ProjectConstants;

import java.util.List;


public class OurDatacenterTest extends BaseTest {
    @QaseTitle("Check  Video player ")
    @QaseId(value = 5008)
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
    @QaseTitle("Check  Video player on German localisation")
    @QaseId(value = 5009)
    @Test
    public void testHTML5VideoPlayerUsingGermanyLocalization_Datacenter() throws Exception {
        OurDatacenterPage ourDatacenterPage = new OurDatacenterPage(getDriver());

        final String expectedSource = ProjectConstants.DOMAIN + "/video/SWISSCOWS.mp4";
        final String source = openBaseURL()
                .scrollToFooterMenu()
                .clickOurDatacenterPageFooterMenu()
                .clickHamburgerMenu()
                .clickLanguagesHamburgerMenu()
                .clickGermanyLang()
                .getCurrentSrcOfVideo();

        ourDatacenterPage
                .playVideoDatacenter()
                .waitUntilTimeOfVideoChanged(2000)
                .pauseVideoDatacenter()
                .screen("dataCentreGermany.png");

        Assert.assertEquals(source, expectedSource);
    }

    @QaseTitle("Check that links navigate to corresponding pages")
    @QaseId(value = 5010)
    @Test(dataProvider = "OurDatacenterLinksData", dataProviderClass = TestData.class)
    public void testOurDatacenterLinksNavigateToCorrespondingPages(
            int index, String linkName, String href, String expectedURL) throws InterruptedException {
        OurDatacenterPage ourDatacenterPage = new OurDatacenterPage(getDriver());

        final String oldURL = openBaseURL()
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
    @QaseTitle("Check slider")
    @QaseId(value = 5011)
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
    @QaseTitle("Check colors of links ")
    @QaseId(value = 5012)
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
