package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.footer_menu.MediaEducationPage;
import java.io.IOException;



public class MediaEducationTest extends BaseTest {
    @Test
    public void testPdfLinkMediaEducation() throws IOException {
        MediaEducationPage mediaEducationPage = new MediaEducationPage(getDriver());
        final String oldURL = openBaseURL().getCurrentURL();
        String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickMediaEducationFooterMenu()
                .getCurrentURL();
        String pdfContent = mediaEducationPage
                .scrollToWhereToLinkPdf()
                .clickLinkPdf()
                .getPdfText("https://dev.swisscows.com/docs/Medienerziehung_2020_06_EN.pdf");
        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertTrue(pdfContent.contains("Digital" + "\n" + "media education"));
    }
    @Test
    public void testPdfButtonOpenFlyerMediaEducation() throws IOException {
        MediaEducationPage mediaEducationPage = new MediaEducationPage(getDriver());
        final String oldURL = openBaseURL().getCurrentURL();
        String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickMediaEducationFooterMenu()
                .getCurrentURL();
        String pdfContent = mediaEducationPage
                .scrollToWhereToButtonOpenFlyer()
                .clickButtonOpenFlyer()
                .getPdfText("https://dev.swisscows.com/docs/Medienerziehung_2020_06_EN.pdf");
        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertTrue(pdfContent.contains("Digital" + "\n" + "media education"));


    }
@Ignore
    @Test
    public void testHTML5VideoYouTubePlayerMediaEducation() throws Exception {
        MediaEducationPage mediaEducationPage = new MediaEducationPage(getDriver());
        final String expectedSource = "https://www.youtube.com/";
        final String source = openBaseURL()
                .scrollToFooterMenu()
                .clickMediaEducationFooterMenu()
                .scrollToWhereToVideoPlayerYouTube()
                .clickPlayerYouTube()
                .getCurrentSrcOfVideo();
        mediaEducationPage.screen("mediaEducationPage.png");
        Assert.assertTrue(source.contains(expectedSource));






    }
}
