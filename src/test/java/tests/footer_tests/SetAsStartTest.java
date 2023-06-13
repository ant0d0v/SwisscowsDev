package tests.footer_tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.footer_menu.SetAsStartPage;

import java.util.List;

public class SetAsStartTest extends BaseTest {
    @Test
    public void testH2TextsSetAsStartPage() {
        List<String> expectedH2Texts = List.of(
                "Mozilla Firefox",
                "Google Chrome",
                "Brave",
                "Microsoft Internet Explorer",
                "Microsoft Edge"
        );
        List<String> actualH2Texts = openBaseURL()
                .scrollToFooterMenu()
                .clickSetAsStartPageFooterMenu()
                .getH2Texts();
        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
    }

    @Test
    public void testDragLinkNavigateToCorrespondingPage() {
        final String expectedUrl = "https://swisscows.com/en";
        String actualUrl = openBaseURL()
                .scrollToFooter()
                .clickSetAsStartPageFooterMenu()
                .clickDragLink()
                .getCurrentURL();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

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
        System.out.println(actualH2FontSizes);

        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1Colors);
    }

    @Test(dataProvider = "LangSetAsStartTestData", dataProviderClass = TestData.class)
    public void testLocalizationGoToCorrespondingLanguage(
            int index, String LangName, String expectedH1text) {

        String actualH1texts = (openBaseURL()
                .clickSetAsStartPageFooterMenu()
                .clickHamburgerMenu()
                .clickLangDropDownSetAsStart(index)
                .getH1Text());

        Assert.assertEquals(actualH1texts, expectedH1text);
    }

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

    @Test
    public void testAllIconsExistToSetAsStartPage() {

        SetAsStartPage setAsStartPage = openBaseURL()
                .scrollToFooterMenu()
                .clickSetAsStartPageFooterMenu();

        Assert.assertTrue(setAsStartPage.allElementsDisplayed());
        Assert.assertTrue(setAsStartPage.isLogoIconDisplayed());


    }
}

