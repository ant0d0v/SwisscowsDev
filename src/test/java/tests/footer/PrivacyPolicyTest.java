package tests.footer;
import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class PrivacyPolicyTest extends BaseTest {
    @QaseTitle("Check h2 texts ")
    @QaseId(value = 5013)
    @Test
    public void testH2TextsPrivacyPolicyPage() {
        List<String> expectedH2Texts = List.of(
                "Swisscows is a data secure search engine. We take the privacy of our users very seriously.",
                "How does Swisscows protect your privacy?",
                "When does Swisscows collect personal data and why?",
                "How does Swisscows retain your personal data?",
                "Videos in the results at Swisscows",
                "Advertising at Swisscows"
        );
        final List<String> actualH2Texts = openBaseURL()
                .scrollToFooterMenu()
                .clickPrivacyPolicyPageFooterMenu()
                .getH2Texts();

        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
    }
    @QaseTitle("Check that links navigate to corresponding pages ")
    @QaseId(value = 5014)
    @Test
    public void testPrivacyMicrosoftLinkNavigateToCorrespondingPages() {
        final String expectedUrl = "https://privacy.microsoft.com/en-us/privacystatement";
        String actualUrl = openBaseURL()
                .scrollToFooter()
                .clickPrivacyPolicyPageFooterMenu()
                .scrollToWherePrivacyMicrosoft()
                .clickPrivacyMicrosoftLink()
                .getCurrentURL();

        Assert.assertEquals(actualUrl, expectedUrl);
    }
    @QaseTitle("Check font sizes of texts")
    @QaseId(value = 5015)
    @Test
    public void testH2FontSizesPrivacyPolicyPage(){
        final List<String> expectedH1FontSizes = List.of(
                    "24px",
                    "24px",
                    "24px",
                    "24px",
                    "24px",
                    "24px"

            );
        final List<String>  actualH2FontSizes = openBaseURL()
                .scrollToFooterMenu()
                .clickPrivacyPolicyPageFooterMenu()
                .getH2FontSizes();

        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1FontSizes);
    }
    @QaseTitle("Check colors of links")
    @QaseId(value = 5016)
    @Test
    public void testLinksColorsPrivacyPolicyPage(){
        final List<String> expectedH1Colors = List.of(
                    "rgba(223, 93, 93, 1)",
                    "rgba(223, 93, 93, 1)",
                    "rgba(223, 93, 93, 1)"
        );
        final List<String>  actualH1Colors = openBaseURL()
                .scrollToFooterMenu()
                .clickPrivacyPolicyPageFooterMenu()
                .getColorLinks();

        Assert.assertTrue(actualH1Colors.size() > 0);
        Assert.assertEquals(actualH1Colors, expectedH1Colors);

    }
}

