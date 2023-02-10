package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class PrivacyPolicyTest extends BaseTest {
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
        List<String> actualH2Texts = openBaseURL()
                .scrollToFooterMenu()
                .clickPrivacyPolicyPageFooterMenu()
                .getH2Texts();
        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
    }
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
        @Test
        public void testH2FontSizesPrivacyPolicyPage(){
            List<String> expectedH1FontSizes = List.of(
                    "24px",
                    "24px",
                    "24px",
                    "24px",
                    "24px",
                    "24px"

            );
            List<String>  actualH2FontSizes = openBaseURL()
                    .scrollToFooterMenu()
                    .clickPrivacyPolicyPageFooterMenu()
                    .getH2FontSizes();

            Assert.assertTrue(actualH2FontSizes.size() > 0);
            Assert.assertEquals(actualH2FontSizes, expectedH1FontSizes);
        }
        @Test
        public void testLinksColorsPrivacyPolicyPage(){
            List<String> expectedH1Colors = List.of(
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                    "rgba(223, 93, 93, 1)"
        );
            List<String>  actualH1Colors = openBaseURL()
                .scrollToFooterMenu()
                .clickPrivacyPolicyPageFooterMenu()
                .getColorLinks();

            Assert.assertTrue(actualH1Colors.size() > 0);
            Assert.assertEquals(actualH1Colors, expectedH1Colors);

    }
    }

