package tests.footer;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.MakeDefaultSearchPage;
import pages.top_menu.EmailPage;

import java.util.List;

public class MakeDefaultSearchTest extends BaseTest {
    @QaseTitle("Check h2 texts on the page")
    @QaseId(value = 4994)
    @Test
    public void testH2TextsMakeDefaultSearchPage() {
        List<String> expectedH2Texts = List.of(
                "Mozilla Firefox",
                "Google Chrome",
                "Brave",
                "Opera",
                "Tor",
                "Microsoft Internet Explorer",
                "Microsoft Edge"
        );
        final List<String> actualH2Texts = openBaseURL()
                .scrollToFooterMenu()
                .clickMakeDefaultSearchPageFooterMenu()
                .getH2Texts();

        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
    }
    @QaseTitle("Check make default search links navigate to corresponding pages")
    @QaseId(value = 4995)
    @Test(dataProvider = "MakeDefaultSearchLinksData", dataProviderClass = TestData.class)
    public void testMakeDefaultSearchLinksNavigateToCorrespondingPages(
            int index, String linkName, String href, String expectedURL) throws InterruptedException {
        MakeDefaultSearchPage makeDefaultSearchPage = new MakeDefaultSearchPage(getDriver());

        final String oldURL = openBaseURL()
                .scrollToFooterMenu()
                .clickMakeDefaultSearchPageFooterMenu()
                .getCurrentURL();

        makeDefaultSearchPage.clickAllLinks(index);

        final String actualURL = makeDefaultSearchPage.getCurrentURL();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
    }
    @QaseTitle("Check font sixes of texts on the page")
    @QaseId(value = 4996)
    @Test
    public void testH2FontSizesMakeDefaultSearchPage(){
        List<String> expectedH1FontSizes = List.of(
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px"
        );
        List<String>  actualH2FontSizes = openBaseURL()
                .scrollToFooterMenu()
                .clickMakeDefaultSearchPageFooterMenu()
                .getH2FontSizes();

        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1FontSizes);
    }
    @QaseTitle("Check localisation navigate to corresponding pages")
    @QaseId(value = 4997)
    @Test(dataProvider = "LangMakaDefaultSearchTestData", dataProviderClass = TestData.class)
    public void testLocalizationGoToCorrespondingLanguage(
            int index, String LangName, String expectedH1text) {

        String actualH1texts = openBaseURL()
                .clickMakeDefaultSearchPageFooterMenu()
                .clickHamburgerMenu()
                .clickLangDropDownMakeDefault(index)
                .getH1Text();

        Assert.assertEquals(actualH1texts, expectedH1text);
    }
    @QaseTitle("Check that animation images are dysplaed")
    @QaseId(value = 4998)
    @Test
    public void testAnimationImageAreDysplaed(){
        MakeDefaultSearchPage makeDefaultSearchPage = new MakeDefaultSearchPage(getDriver());
        openBaseURL()
                .scrollToFooter()
                .clickMakeDefaultSearchPageFooterMenu()
                .scrollToWhereH2Tor()
                .waitToBeVisibleAnimationImage();

        Assert.assertTrue(makeDefaultSearchPage.elementIsDisplayedAnimationImage());
    }
    @QaseTitle("Check colors of links on the page ")
    @QaseId(value = 4999)
    @Test
    public void testLinksColorsMakeDefaultSearchPage() {
        List<String> expectedLinksColors = List.of(
                "rgba(255, 255, 255, 1)",
                "rgba(255, 255, 255, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(255, 255, 255, 1)"

        );
        List<String> actualLinksColors = openBaseURL()
                .scrollToFooterMenu()
                .clickMakeDefaultSearchPageFooterMenu()
                .getColorLinks();

        Assert.assertTrue(actualLinksColors.size() > 0);
        Assert.assertEquals(actualLinksColors, expectedLinksColors);

    }
    @QaseTitle("Check existence of all icons on  page ")
    @QaseId(value = 5000)
    @Test
    public void testAllIconsExistToMakeDefaultSearchPage() {

        MakeDefaultSearchPage makeDefaultSearchPage = openBaseURL()
                .scrollToFooterMenu()
                .clickMakeDefaultSearchPageFooterMenu();

        Assert.assertTrue(makeDefaultSearchPage.allElementsDisplayed());
        Assert.assertTrue(makeDefaultSearchPage.isLogoIconDisplayed());


    }
    @QaseTitle("Check button colors when hover on page")
    @QaseId(value = 5001)
    @Test
    public void testAllButtonColorsWhenHover_makeDefaultSearchPage() throws InterruptedException {
        MakeDefaultSearchPage makeDefaultSearchPage = new MakeDefaultSearchPage(getDriver());
        final List<String> oldButtonColorsWhenHover = openBaseURL()
                .scrollToFooterMenu()
                .clickMakeDefaultSearchPageFooterMenu()
                .getButtonColors();

        final List<String> newButtonColorsWhenHover = makeDefaultSearchPage
                .getButtonColorsWhenHover();

        Assert.assertNotEquals(newButtonColorsWhenHover, oldButtonColorsWhenHover);
    }

}
