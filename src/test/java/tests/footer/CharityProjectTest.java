package tests.footer;

import base.BaseTest;
import io.qameta.allure.Attachment;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.CharityProjectPage;
import utils.ProjectConstants;

import java.util.List;

public class CharityProjectTest extends BaseTest {
    @QaseTitle("Check video player")
    @QaseId(value = 4973)
    @Test
    public void testHTML5VideoPlayerCharity() throws Exception {
        final String expectedSource = ProjectConstants.DOMAIN + "/video/SwisscowsCharityVideo_EN.mp4";
        CharityProjectPage charityProjectPage = new CharityProjectPage(getDriver());
        final String source = openBaseURL()
                .scrollToFooterMenu()
                .clickCharityProjectFooterMenu()
                .getCurrentSrcOfVideo();
        charityProjectPage
                .playVideoCharity()
                .waitUntilTimeOfVideoToBeChanged(2000)
                .pauseVideoCharity()
                .screen("CharityProject.png");
                 captureScreenshot();

        Assert.assertEquals(source, expectedSource);
    }
    @QaseTitle("Check charity project links navigate to corresponding pages")
    @QaseId(value = 4974)
    @Test(dataProvider = "CharityProjectLinksData", dataProviderClass = TestData.class)
        public void testCharityProjectLinksNavigateToCorrespondingPages(
        int index, String linkName, String href, String expectedURL) throws InterruptedException {
            CharityProjectPage charityProjectPage = new CharityProjectPage(getDriver());

            final String oldURL = openBaseURL()
                    .scrollToFooterMenu()
                    .clickCharityProjectFooterMenu()
                    .getCurrentURL();
            charityProjectPage
                    .scrollToWhereToH2Header()
                    .clickAllLinks(index);

            final String actualURL = charityProjectPage.getCurrentURL();

            Assert.assertNotEquals(oldURL, actualURL);
            Assert.assertEquals(actualURL, expectedURL);
    }
    @QaseTitle("Check Charity Project first slider")
    @QaseId(value = 4975)
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
                .waitUntilTwoImageInTheSliderToBeVisible()
                .getClassAttributeOfImageInFirstSlider();

        Assert.assertNotEquals(newAttribute,oldAttribute);
        Assert.assertTrue(charityProjectPage.elementIsDisplayedFirstSlider());
    }
    @QaseTitle("Check Charity Project second slider")
    @QaseId(value = 4976)
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
                .waitUntilThirdImageInTheSliderToBeVisible()
                .getClassAttributeOfImageInSecondSlider();

        Assert.assertNotEquals(newAttribute,oldAttribute);
        Assert.assertTrue(charityProjectPage.elementIsDisplayedInSecondSlider());
    }
    @QaseTitle("Check links colors on the Charity project page")
    @QaseId(value = 4977)
    @Test
    public void testLinksColorsCharityProjectPage() {
        final List<String> expectedLinksColors = List.of(
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)"
        );
        final List<String> actualLinksColors = openBaseURL()
                .scrollToFooterMenu()
                .clickCharityProjectFooterMenu()
                .getColorLinks();

        Assert.assertTrue(actualLinksColors.size() > 0);
        Assert.assertEquals(actualLinksColors, expectedLinksColors);
    }

    }


