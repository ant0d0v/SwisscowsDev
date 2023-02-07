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
    public void testHTML5VideoPlayer() throws Exception {
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
                .screen("/Users/antonudovycenko/Desktop/Screen/1.png");
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
@Ignore
    @Test
    public void testImageSwitchingFirstBlock() throws InterruptedException {

        MainPage mainPage = openBaseURL();
        mainPage
                .scrollToFooterMenu()
                .clickCharityProjectFooterMenu();

        CharityProjectPage charityProjectPage = new CharityProjectPage(getDriver());
        TestUtils.waitForPageLoaded(getDriver());
        charityProjectPage
                .scrollToImageFirstBlock()
                .clickImageFirstBlock();
        String actual = charityProjectPage.getClassAttributeOfImage();

        Assert.assertTrue(charityProjectPage.elementIsDisplayed());







    }

    }


