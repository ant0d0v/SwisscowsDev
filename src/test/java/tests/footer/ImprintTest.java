package tests.footer;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.footer_menu.ImprintPage;

import java.util.List;

public class ImprintTest extends BaseTest {
    @QaseTitle("Check image swisscows is dysplaed")
    @QaseId(value = 4990)
    @Test
    public void testImageSwisscowsIsDysplaed(){
        ImprintPage imprintPage  = new ImprintPage (getDriver());
        openBaseURL()
                .scrollToFooter()
                .clickImprintPageFooterMenu();

        Assert.assertTrue(imprintPage.elementIsDisplayedImageSwisscows());
    }
    @QaseTitle("Check texts on the page")
    @QaseId(value = 4991)
    @Test
    public void testSpanTextsImprintPage() {
        final  List<String> expectedH2Texts = List.of(
                "Swisscows AG\n"+"Bucherstrasse 2\n"+"9322 Egnach, Switzerland",
                "+41 (0) 716 667 931",
                "+41 (0) 716 667 930",
                "info@swisscows.com",
                "Legal Form",
                "Executive Board",
                "Commercial Registry Office",
                "District Court",
                "Commercial Register"
        );
        final List<String> actualH2Texts = openBaseURL()
                .scrollToFooterMenu()
                .clickImprintPageFooterMenu()
                .getTextsOnPage();

        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
    }
    @QaseTitle("Check font sizes of texts on the page")
    @QaseId(value = 4992)
    @Test
    public void testTextsFontSizesImprintPage(){
        final List<String> expectedH1FontSizes = List.of(
                "20px",
                "20px",
                "20px",
                "20px",
                "20px",
                "20px",
                "20px",
                "20px",
                "20px"
        );
        final List<String>  actualH2FontSizes = openBaseURL()
                .scrollToFooterMenu()
                .clickImprintPageFooterMenu()
                .getTextsFontSizes();

        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1FontSizes);
    }
    @QaseTitle("Check color of email link ")
    @QaseId(value = 4993)
    @Test
    public void tesEmailLinkColorImprintPage(){
        final String expectedH1Colors =
                "rgba(223, 93, 93, 1)";
        final String  actualH1Colors = openBaseURL()
                .scrollToFooterMenu()
                .clickImprintPageFooterMenu()
                .getColorEmail();

        Assert.assertEquals(actualH1Colors, expectedH1Colors);

    }
}
