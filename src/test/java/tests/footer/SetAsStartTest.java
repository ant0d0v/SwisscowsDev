package tests.footer;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.footer_menu.MakeDefaultSearchPage;
import pages.footer_menu.SetAsStartPage;

import java.util.List;

public class SetAsStartTest extends BaseTest {
    @QaseTitle("Check h2 texts")
    @QaseId(value = 5016)
    @Test
    public void testH2TextsSetAsStartPage() {
        List<String> expectedH2Texts = List.of(
                "Mozilla Firefox",
                "Google Chrome",
                "Brave",
                "Microsoft Internet Explorer",
                "Microsoft Edge"
        );
        final List<String> actualH2Texts = openBaseURL()
                .scrollToFooterMenu()
                .clickSetAsStartPageFooterMenu()
                .getH2Texts();

        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
    }
    @QaseTitle("Check that drag link navigate to corresponding page")
    @QaseId(value = 5018)
    @Test
    public void testDragLinkNavigateToCorrespondingPage() {
        final String expectedUrl = "https://swisscows.com/en";

        final String actualUrl = openBaseURL()
                .scrollToFooter()
                .clickSetAsStartPageFooterMenu()
                .clickDragLink()
                .getCurrentURL();

        Assert.assertEquals(actualUrl, expectedUrl);
    }
    @QaseTitle("Check font sizes of texts")
    @QaseId(value = 5019)
    @Test
    public void testH2FontSizesSetAsStartPage() {
        List<String> expectedH1Colors = List.of(
                "24px",
                "24px",
                "24px",
                "24px",
                "24px"
        );
        List<String> actualH2FontSizes = openBaseURL()
                .scrollToFooterMenu()
                .clickSetAsStartPageFooterMenu()
                .getH2FontSizes();


        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1Colors);
    }
    @QaseTitle("Check localisation")
    @QaseId(value = 5020)
    @Test(dataProvider = "LangSetAsStartTestData", dataProviderClass = TestData.class)
    public void testLocalizationGoToCorrespondingLanguage(
            int index, String LangName, String expectedH1text) {

        final String actualH1texts = openBaseURL()
                .clickSetAsStartPageFooterMenu()
                .clickHamburgerMenu()
                .clickLangDropDownSetAsStart(index)
                .getH1Text();

        Assert.assertEquals(actualH1texts, expectedH1text);
    }
    @QaseTitle("Check colors of links")
    @QaseId(value = 5021)
    @Test
    public void testLinksColorsSetAsStartPage() {
        List<String> expectedLinksColors = List.of(
                "rgba(223, 93, 93, 1)"

        );
        List<String> actualLinksColors = openBaseURL()
                .scrollToFooterMenu()
                .clickSetAsStartPageFooterMenu()
                .getColorLinks();

        Assert.assertTrue(actualLinksColors.size() > 0);
        Assert.assertEquals(actualLinksColors, expectedLinksColors);

    }
    @QaseTitle("Check existence of all icons on  page ")
    @QaseId(value = 5022)
    @Test
    public void testAllIconsExistToSetAsStartPage() {

        SetAsStartPage setAsStartPage = openBaseURL()
                .scrollToFooterMenu()
                .clickSetAsStartPageFooterMenu();

        Assert.assertTrue(setAsStartPage.allElementsDisplayed());
        Assert.assertTrue(setAsStartPage.isLogoIconDisplayed());


    }
}

