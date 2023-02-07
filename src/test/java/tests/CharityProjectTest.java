package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.CharityProjectPage;

public class CharityProjectTest extends BaseTest {
    @Ignore
    @Test
    public void testHTML5VideoPlayerCharity() throws Exception {
        final String expectedSource = "https://dev.swisscows.com/video/SwisscowsCharityVideo_EN.mp4";
        CharityProjectPage charityProjectPage = new CharityProjectPage(getDriver());
        MainPage mainPage = openBaseURL();
        mainPage
                .scrollToFooterMenu()
                .clickCharityProjectFooterMenu();

        final String source = charityProjectPage.getCurrentSrcOfVideo();
        charityProjectPage
                .playVideoCharity()
                .pauseVideoCharity()
                .screen("CharityVideo.png");
        Assert.assertEquals(source, expectedSource);
    }

        @Test(dataProvider = "CharityProjectLinksData", dataProviderClass = TestData.class)
        public void testCharityProjectLinksNavigateToCorrespondingPages(
        int index, String linkName, String href, String expectedURL) throws InterruptedException {

            MainPage mainPage = openBaseURL();
            mainPage
                    .scrollToFooterMenu()
                    .clickCharityProjectFooterMenu();

            final String oldURL = mainPage.getCurrentURL();
            mainPage.scrollToFooterMenu();
            CharityProjectPage charityProjectPage = new CharityProjectPage(getDriver());
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
        MainPage mainPage = openBaseURL();
        mainPage
                .scrollToFooterMenu()
                .clickCharityProjectFooterMenu()
                .scrollToFirstSlider();
        final String oldAttribute = charityProjectPage.getClassAttributeOfImageInFirstSlider();
        charityProjectPage
                .doubleClickToSecondImageInSlider();
        final String newAttribute = charityProjectPage.getClassAttributeOfImageInFirstSlider();


        Assert.assertNotEquals(newAttribute,oldAttribute);
        Assert.assertTrue(charityProjectPage.elementIsDisplayedFirstSlider());
    }

    @Test
    public void testCharityProjectSecondSlider()  {
        CharityProjectPage charityProjectPage = new CharityProjectPage(getDriver());
        MainPage mainPage = openBaseURL();
        mainPage
                .scrollToFooterMenu()
                .clickCharityProjectFooterMenu()
                .scrollToSecondSlider();
        final String oldAttribute = charityProjectPage.getClassAttributeOfImageInSecondSlider();

        charityProjectPage
                .doubleClickToThirdImageInSlider();
        final String newAttribute = charityProjectPage.getClassAttributeOfImageInSecondSlider();

        Assert.assertNotEquals(newAttribute,oldAttribute);
        Assert.assertTrue(charityProjectPage.elementIsDisplayedInSecondSlider());
    }

    }


