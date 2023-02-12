package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.footer_menu.MediaEducationPage;
import java.io.IOException;
import java.util.List;


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
        mediaEducationPage.screen();
        Assert.assertTrue(source.contains(expectedSource));

    }

    @Test
    public void testH2TextsMediaEducationPage(){
        List<String> expectedH1Texts = List.of(
                "We attach great importance to family-friendly Internet content!",
                "A safe Internet for our children - how children can learn to use digital media"
        );
        List<String> actualH1Texts = openBaseURL()
                .scrollToFooterMenu()
                .clickMediaEducationFooterMenu()
                .getH2Texts();
        Assert.assertTrue(actualH1Texts.size() > 0);
        Assert.assertEquals(actualH1Texts, expectedH1Texts);


    }
    @Test
    public void testLinksColorsMediaEducationPage() {
        List<String> expectedLinksColors = List.of(
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(255, 255, 255, 0.7)"


        );
        List<String> actualLinksColors = openBaseURL()
                .scrollToFooterMenu()
                .clickMediaEducationFooterMenu()
                .getColorLinks();

        Assert.assertTrue(actualLinksColors.size() > 0);
        Assert.assertEquals(actualLinksColors, expectedLinksColors);

    }

}
