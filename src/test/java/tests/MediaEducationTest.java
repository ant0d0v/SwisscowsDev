package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.footer_menu.MediaEducationPage;
import pages.top_menu.EmailPage;
import utils.ProjectConstants;

import java.io.IOException;
import java.util.List;


public class MediaEducationTest extends BaseTest {
    @Test
    public void testPdfLinkMediaEducation() throws IOException {
        MediaEducationPage mediaEducationPage = new MediaEducationPage(getDriver());

        final String oldURL = openBaseURL()
                .getCurrentURL();
        final String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickMediaEducationFooterMenu()
                .getCurrentURL();

        String pdfContent = mediaEducationPage
                .scrollToWhereToLinkPdf()
                .clickLinkPdf()
                .getPdfText(ProjectConstants.DOMAIN + "/docs/Medienerziehung_2020_06_EN.pdf");
        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertTrue(pdfContent.contains("Digital" + "\n" + "media education"));
    }
    @Test
    public void testPdfButtonOpenFlyerMediaEducation() throws IOException {
        MediaEducationPage mediaEducationPage = new MediaEducationPage(getDriver());
        final String oldURL = openBaseURL()
                .getCurrentURL();
        final  String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickMediaEducationFooterMenu()
                .getCurrentURL();

        String pdfContent = mediaEducationPage
                .scrollToWhereToButtonOpenFlyer()
                .clickButtonOpenFlyer()
                .getPdfText(ProjectConstants.DOMAIN + "/docs/Medienerziehung_2020_06_EN.pdf");
        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertTrue(pdfContent.contains("Digital" + "\n" + "media education"));


    }

    @Test
    public void testHTML5VideoYouTubePlayerMediaEducation() throws Exception {
        MediaEducationPage mediaEducationPage = new MediaEducationPage(getDriver());
        final String source = openBaseURL()
                .scrollToFooterMenu()
                .clickMediaEducationFooterMenu()
                .scrollToWhereToVideoPlayerYouTube()
                .clickPlayerYouTube()
                .waitUntilTimeOfVideoToBeChanged("0:02")
                .getCurrentSrcOfVideo();

        mediaEducationPage.screen("MediaEducation.png");
        Assert.assertTrue(source.contains("youtube.com"));

    }

    @Test
    public void testH2TextsMediaEducationPage(){
        final List<String> expectedH1Texts = List.of(
                "We attach great importance to family-friendly Internet content!",
                "A safe Internet for our children - how children can learn to use digital media"
        );
        final List<String> actualH1Texts = openBaseURL()
                .scrollToFooterMenu()
                .clickMediaEducationFooterMenu()
                .getH2Texts();
        Assert.assertTrue(actualH1Texts.size() > 0);
        Assert.assertEquals(actualH1Texts, expectedH1Texts);


    }
    @Test
    public void testLinksColorsMediaEducationPage() {
        final List<String> expectedLinksColors = List.of(
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(255, 255, 255, 1)"


        );
        final List<String> actualLinksColors = openBaseURL()
                .scrollToFooterMenu()
                .clickMediaEducationFooterMenu()
                .getColorLinks();

        Assert.assertTrue(actualLinksColors.size() > 0);
        Assert.assertEquals(actualLinksColors, expectedLinksColors);

    }
    @Test
    public void testOpenFlyerButtonColorWhenHover_MediaEducationPage() throws InterruptedException {
        MediaEducationPage mediaEducationPage  = new MediaEducationPage (getDriver());
        final String oldButtonColor = openBaseURL()
                .scrollToFooterMenu()
                .clickMediaEducationFooterMenu()
                .scrollToWhereToLinkPdf()
                .backgroundColorOfElement();

        final String newButtonColor  = mediaEducationPage
                .hoverElement()
                .backgroundColorOfElement();

        Assert.assertNotEquals(newButtonColor,oldButtonColor);

    }

}
