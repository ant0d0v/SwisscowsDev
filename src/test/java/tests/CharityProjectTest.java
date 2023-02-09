package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.CharityProjectPage;

public class CharityProjectTest extends BaseTest {

    @Test
    public void testHTML5VideoPlayerCharity() throws Exception {
        final String expectedSource = "https://dev.swisscows.com/video/SwisscowsCharityVideo_EN.mp4";
        CharityProjectPage charityProjectPage = new CharityProjectPage(getDriver());
        final String source = openBaseURL()
                .scrollToFooterMenu()
                .clickCharityProjectFooterMenu()
                .getCurrentSrcOfVideo();
        charityProjectPage
                .playVideoCharity()
                .pauseVideoCharity()
                .screen("CharityVideo.png");
        Assert.assertEquals(source, expectedSource);
    }

        @Test(dataProvider = "CharityProjectLinksData", dataProviderClass = TestData.class)
        public void testCharityProjectLinksNavigateToCorrespondingPages(
        int index, String linkName, String href, String expectedURL) throws InterruptedException {
            CharityProjectPage charityProjectPage = new CharityProjectPage(getDriver());
            MainPage mainPage = openBaseURL();
            final String oldURL = mainPage
                    .scrollToFooterMenu()
                    .clickCharityProjectFooterMenu()
                    .getCurrentURL();

            charityProjectPage
                    .scrollToWhereToH2Header()
                    .clickAllLinks(index);

            final String actualURL = mainPage.getCurrentURL();

            Assert.assertNotEquals(oldURL, actualURL);
            Assert.assertEquals(actualURL, expectedURL);
    }
    @Test
    public void testCharityProjectFirstSlider()  {
        CharityProjectPage charityProjectPage = new CharityProjectPage(getDriver());
        final String oldAttribute = openBaseURL()
                .scrollToFooterMenu()
                .clickCharityProjectFooterMenu()
                .scrollToFirstSlider()
                .getClassAttributeOfImageInFirstSlider();
        final String newAttribute = charityProjectPage
                .doubleClickToSecondImageInSlider()
                .getClassAttributeOfImageInFirstSlider();

        Assert.assertNotEquals(newAttribute,oldAttribute);
        Assert.assertTrue(charityProjectPage.elementIsDisplayedFirstSlider());
    }

    @Test
    public void testCharityProjectSecondSlider()  {
        CharityProjectPage charityProjectPage = new CharityProjectPage(getDriver());
        final String oldAttribute = openBaseURL()
                .scrollToFooterMenu()
                .clickCharityProjectFooterMenu()
                .scrollToSecondSlider()
                .getClassAttributeOfImageInSecondSlider();

        final String newAttribute = charityProjectPage
                .doubleClickToThirdImageInSlider()
                .getClassAttributeOfImageInSecondSlider();

        Assert.assertNotEquals(newAttribute,oldAttribute);
        Assert.assertTrue(charityProjectPage.elementIsDisplayedInSecondSlider());
    }

    }


