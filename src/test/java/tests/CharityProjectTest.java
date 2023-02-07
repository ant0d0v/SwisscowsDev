package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.CharityProjectPage;
import utils.TestUtils;


public class CharityProjectTest extends BaseTest {
@Ignore
    @Test
    public void testHTML5VideoPlayerCharity() throws Exception {
        String expectedSource = "https://dev.swisscows.com/video/SwisscowsCharityVideo_EN.mp4";
        MainPage mainPage = openBaseURL();
        mainPage
                .scrollToFooterMenu()
                .clickCharityProjectFooterMenu();

        CharityProjectPage charityProjectPage = new CharityProjectPage(getDriver());
        TestUtils.waitForPageLoaded(getDriver());
        String source = charityProjectPage.getCurrentSrcOfVideo();
        charityProjectPage
                .playVideo()
                .pauseVideo();
        charityProjectPage
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

            String actualURL = mainPage.getCurrentURL();

            Assert.assertNotEquals(oldURL, actualURL);
            Assert.assertEquals(actualURL, expectedURL);
    }
    @Test
    public void testCharityProjectFirstSlider()  {

        MainPage mainPage = openBaseURL();
        mainPage
                .scrollToFooterMenu()
                .clickCharityProjectFooterMenu();

        CharityProjectPage charityProjectPage = new CharityProjectPage(getDriver());
        TestUtils.waitForPageLoaded(getDriver());
        charityProjectPage
                .scrollToFirstSlider();
        String oldAttribute = charityProjectPage.getClassAttributeOfImageFirstSlider();

        charityProjectPage
                .doubleClickToTwoSecondInSlider();
        String newAttribute = charityProjectPage.getClassAttributeOfImageFirstSlider();


        Assert.assertNotEquals(newAttribute,oldAttribute);
        Assert.assertTrue(charityProjectPage.elementIsDisplayedFirstSlider());
    }

    @Test
    public void testCharityProjectSecondSlider()  {

        MainPage mainPage = openBaseURL();
        mainPage
                .scrollToFooterMenu()
                .clickCharityProjectFooterMenu();

        CharityProjectPage charityProjectPage = new CharityProjectPage(getDriver());
        TestUtils.waitForPageLoaded(getDriver());
        charityProjectPage
                .scrollToSecondSlider();
        String oldAttribute = charityProjectPage.getClassAttributeOfImageSecondSlider();

        charityProjectPage
                .doubleClickToThirdImageInSlider();
        String newAttribute = charityProjectPage.getClassAttributeOfImageSecondSlider();

        Assert.assertNotEquals(newAttribute,oldAttribute);
        Assert.assertTrue(charityProjectPage.elementIsDisplayedSecondSlider());
    }

    }


