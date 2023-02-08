package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.OurDatacenterPage;


public class OurDatacenterTest extends BaseTest {
@Ignore
    @Test
    public void testHTML5VideoPlayerDatacenter() throws Exception {
        OurDatacenterPage ourDatacenterPage = new OurDatacenterPage(getDriver());
        final String expectedSource = "https://dev.swisscows.com/video/SWISSCOWS.mp4";
        final String source = openBaseURL()
                .scrollToFooterMenu()
                .clickOurDatacenterPageFooterMenu()
                .getCurrentSrcOfVideo();
        ourDatacenterPage
                .playVideoDatacenter()
                .pauseVideoDatacenter()
                .screen("DatacenterVideo.png");
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
    public void testOurDatacenterSlider(){
        OurDatacenterPage ourDatacenterPage = new OurDatacenterPage(getDriver());
        final String oldAttribute = openBaseURL()
                .scrollToFooterMenu()
                .clickOurDatacenterPageFooterMenu()
                .scrollToSlider()
                .getClassAttributeOfImageSlider();

        final String newAttribute = ourDatacenterPage
                .doubleClickToSecondImageInSlider()
                .getClassAttributeOfImageSlider();

        Assert.assertNotEquals(newAttribute,oldAttribute);
        Assert.assertTrue(ourDatacenterPage.elementIsDisplayedInSlider());
    }
}
