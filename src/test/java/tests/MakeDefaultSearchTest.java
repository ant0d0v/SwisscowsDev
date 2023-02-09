package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TestData;
import pages.footer_menu.MakeDefaultSearchPage;

import java.util.List;

public class MakeDefaultSearchTest extends BaseTest {
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
        List<String> actualH2Texts = openBaseURL()
                .scrollToFooterMenu()
                .clickMakeDefaultSearchPageFooterMenu()
                .getH2Texts();
        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
    }
    @Test(dataProvider = "MakeDefaultSearchLinksData", dataProviderClass = TestData.class)
    public void testMakeDefaultSearchLinksNavigateToCorrespondingPages(
            int index, String linkName, String href, String expectedURL) throws InterruptedException {
        MakeDefaultSearchPage makeDefaultSearchPage = new MakeDefaultSearchPage(getDriver());
        MainPage mainPage = openBaseURL();
        final String oldURL = mainPage
                .scrollToFooterMenu()
                .clickMakeDefaultSearchPageFooterMenu()
                .getCurrentURL();
        makeDefaultSearchPage
                .clickAllLinks(index);
        final String actualURL = mainPage.getCurrentURL();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void testH2FontSizesMakeDefaultSearchPage(){
        List<String> expectedH1Colors = List.of(
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
        System.out.println(actualH2FontSizes);

        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1Colors);
    }
    @Test(dataProvider = "LangMakaDefaultSearchTestData", dataProviderClass = TestData.class)
    public void testLocalizationGoToCorrespondingLanguage(
            int index, String LangName, String expectedH1text) {

        String actualH1texts = (openBaseURL()
                .clickMakeDefaultSearchPageFooterMenu()
                .clickHamburgerMenu()
                .clickLangDropDownMakeDefault(index)
                .getH1Text());

        Assert.assertEquals(actualH1texts, expectedH1text);
    }
    @Test
    public void testAnimationImageIsDysplaed(){
        MakeDefaultSearchPage makeDefaultSearchPage = new MakeDefaultSearchPage(getDriver());
        openBaseURL()
                .scrollToFooter()
                .clickMakeDefaultSearchPageFooterMenu()
                .scrollToWhereH2Tor();

        Assert.assertTrue(makeDefaultSearchPage.elementIsDisplayedAnimationImage());
    }

}
