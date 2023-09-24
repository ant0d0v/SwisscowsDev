package tests.header;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.top_menu.NewsPage;
import pages.top_menu.ShoppingPage;
import utils.ProjectConstants;

import java.util.List;

public class ShoppingTest extends BaseTest {
    @QaseTitle("Check that suggestion equals search criteria")
    @Test
    public void testSuggestEqualsSearchCriteria_ShoppingPage() {
        final String query = "ivanka";

        MainPage mainPage = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickShoppingButton()
                .waitUntilVisibilityShoppingResult()
                .clickSearchFieldHeader();

        final List<String> actualSuggestion = mainPage
                .waitForSuggestToBeVisible()
                .getAllElementsText();

        final int actualSizeSuggest = mainPage.countElementsInSuggestContainer();

        Assert.assertEquals(mainPage.getAllElementsText().size(), 5);

        for (String searchCriteria : actualSuggestion) {
            Assert.assertTrue(mainPage.suggestIsDisplayed());
            Assert.assertTrue(actualSizeSuggest > 0);
            Assert.assertTrue(searchCriteria.contains(query));
        }
    }
    @QaseId(value = 2)
    @Test
    public void testError501UnsupportedRegion_ShoppingPage(){
        NewsPage newsPage = new NewsPage (getDriver());
        final String expectedTitle501Error = "Sorry, there are no search results for your region";

        final String actualTitle501Error = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("Ivanka")
                .waitUntilVisibilityWebResult()
                .clickShoppingButton()
                .waitUntilVisibilityShoppingResult()
                .selectBrazilRegion()
                .waitVisibilityErrorImage()
                .getTitleShopping();

        final String actualFontSizeTitle501Error = newsPage.getH2FontSize();

        Assert.assertEquals(actualTitle501Error,expectedTitle501Error);
        Assert.assertTrue(newsPage.errorImageIsDisplayed());
        Assert.assertEquals(actualFontSizeTitle501Error, ProjectConstants.FONT_SIZE_40_PX);
    }
    @QaseTitle("Check any number in the paging")
    @Test
    public void testAnyNumberInPaging_ShoppingPage() {
        ShoppingPage shoppingPage = new ShoppingPage(getDriver());
        final String oldTitle = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("laptop")
                .waitUntilVisibilityWebResult()
                .clickShoppingButton()
                .waitUntilVisibilityShoppingResult()
                .getTitleShopping();

        final String newTitle = shoppingPage
                .clickThirdPagePagination()
                .waitUntilVisibilityShoppingResult()
                .getTitleShopping();

        final String actualAttribute = shoppingPage
                .getAttributeThirdButtonPagination();

        Assert.assertNotEquals(oldTitle,newTitle);
        Assert.assertEquals(actualAttribute,"number active");

    }
    @QaseTitle("Check next number in the paging")
    @Test
    public void testNextButtonInPaging_ShoppingPage() {
        NewsPage newsPage = new NewsPage (getDriver());
        String query = "laptop";

        final String actualAttribute = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickShoppingButton()
                .waitUntilUrlToBeChanged("/en/shopping?query=" + query + "&region=de-DE")
                .waitUntilToBeInVisibleLoader()
                .waitUntilVisibilityShoppingResult()
                .clickNextPagePagination()
                .waitUntilUrlToBeChanged("/en/shopping?query=" + query + "&region=de-DE&offset=24")
                .waitUntilToBeInVisibleLoader()
                .waitUntilVisibilityShoppingResult()
                .getAttributeSecondButtonPagination();

        Assert.assertTrue(newsPage.allImageIsDisplayed());
        Assert.assertEquals(newsPage.getTitleH2Texts().size(),24);
        Assert.assertEquals(actualAttribute,"number active");

    }
    @QaseTitle("Check previous number in the paging")
    @Test
    public void testPreviousButtonInPaging_ShoppingPage() {
        NewsPage newsPage = new NewsPage (getDriver());
        ShoppingPage shoppingPage = new ShoppingPage(getDriver());

        String query = "laptop";

        final String oldTitle = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickShoppingButton()
                .waitUntilUrlToBeChanged("/en/shopping?query=" + query + "&region=de-DE")
                .waitUntilToBeInVisibleLoader()
                .waitUntilVisibilityShoppingResult()
                .clickNextPagePagination()
                .waitUntilUrlToBeChanged("/en/shopping?query=" + query + "&region=de-DE&offset=24")
                .waitUntilToBeInVisibleLoader()
                .waitUntilVisibilityShoppingResult()
                .getTitleShopping();

        final String newTitle = shoppingPage
                .clickPreviousPagePagination()
                .waitUntilVisibilityShoppingResult()
                .waitUntilUrlToBeChanged("/en/shopping?query=" + query + "&region=de-DE&offset=0")
                .waitUntilToBeInVisibleLoader()
                .waitUntilVisibilityShoppingResult()
                .getTitleShopping();

        Assert.assertTrue(newsPage.allImageIsDisplayed());
        Assert.assertEquals(newsPage.getTitleH2Texts().size(),24);
        Assert.assertNotEquals(oldTitle,newTitle);
        Assert.assertEquals(newsPage.getCurrentURL(),ProjectConstants.DOMAIN+"/en/shopping?query=" + query + "&region=de-DE&offset=0");

    }
    @QaseTitle("Check image proxy")
    @Test()
    public void testImageProxy_ShoppingPage() {
        NewsPage newsPage = new NewsPage (getDriver());
        final List<String> actualSrc = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter("ronaldo")
                .waitUntilVisibilityWebResult()
                .clickShoppingButton()
                .waitUntilVisibilityShoppingResult()
                .getSrsOfImages();

        Assert.assertTrue(newsPage.allImageIsDisplayed());
        for (String search : actualSrc) {
            Assert.assertTrue(search.contains("https://cdn.swisscows.com/image?url"));
        }
    }
    @QaseTitle("Check search results in the shopping")
    @Test
    public void testSearchResults_ShoppingPage(){
        NewsPage newsPage = new NewsPage (getDriver());
        String query = "macbook";

        final List<String> oldTextAllShoppingResults = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter(query)
                .waitUntilVisibilityWebResult()
                .clickShoppingButton()
                .waitUntilVisibilityShoppingResult()
                .getH2TextShoppingResult();

        for (String searchCriteria : oldTextAllShoppingResults) {
            Assert.assertTrue(searchCriteria.toLowerCase().contains(query));
        }

        Assert.assertTrue(newsPage.allImageIsDisplayed());

    }
    @QaseTitle("Check close button in side View")
    @Test
    public void testCloseButtonInSideView_ShoppingPage() {
        ShoppingPage shoppingPage = new ShoppingPage(getDriver());
        String searchQuery = "laptop";

        openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickShoppingButton()
                .waitUntilVisibilityShoppingResult()
                .waitUntilUrlToBeChanged("/en/shopping?query=" + searchQuery + "&region=de-DE")
                .waitUntilLoaderToBeInVisible()
                .waitToBeVisibleFirstFiveImage()
                .clickFirstImageInShoppingResult()
                .clickCloseIconInSideImageview()
                .waitUntilToBeInvisibleDetailsPanel();

        Assert.assertFalse(shoppingPage.detailsPanelIsDysplaed());
    }
    @QaseTitle("Check click see all link of product card")
    @Test
    public void testSeeAllOffersLinkOpenedSideView_ShoppingPage() {
        ShoppingPage shoppingPage = new ShoppingPage(getDriver());
        String searchQuery = "laptop";

        openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickShoppingButton()
                .waitUntilVisibilityShoppingResult()
                .waitUntilUrlToBeChanged("/en/shopping?query=" + searchQuery + "&region=de-DE")
                .waitUntilLoaderToBeInVisible()
                .waitToBeVisibleFirstFiveImage()
                .clickFirstLink_SeeAllOffers()
                .waitUntilToBeVisibleDetailsPanel();

        Assert.assertTrue(shoppingPage.detailsPanelIsDysplaed());
    }
    @QaseTitle("Check open shop from details panel")
    @Test
    public void testOpenShopInSideView_ShoppingPage() {
        ShoppingPage shoppingPage = new ShoppingPage(getDriver());
        String searchQuery = "laptop";

        final String oldUrl = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickShoppingButton()
                .waitUntilVisibilityShoppingResult()
                .waitUntilUrlToBeChanged("/en/shopping?query=" + searchQuery + "&region=de-DE")
                .waitUntilLoaderToBeInVisible()
                .waitToBeVisibleFirstFiveImage()
                .clickFirstLink_SeeAllOffers()
                .waitUntilToBeVisibleDetailsPanel()
                .scrollToSideBarMenu()
                .getCurrentURL();

        Assert.assertTrue(shoppingPage.detailsPanelIsDysplaed());
        Assert.assertTrue(shoppingPage.getCountShopsInDetailsPanel()>=4);

        shoppingPage
                .clickFirstShopInDetailPanel()
                .switchToAnotherWindow();

        Assert.assertNotEquals(shoppingPage.getCurrentURL(), oldUrl);

    }
    @QaseTitle("Check filter model")
    @Test
    public void testCheckFilterModel_ShoppingPage() {
        String searchQuery = "smartphone";

        final List<String> actualResult = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickShoppingButton()
                .waitUntilVisibilityShoppingResult()
                .waitUntilUrlToBeChanged("/en/shopping?query=" + searchQuery + "&region=de-DE")
                .waitUntilLoaderToBeInVisible()
                .clickFilterButton()
                .clickModelDropdown()
                .clickAppleModel()
                .waitUntilLoaderToBeInVisible()
                .waitToBeVisibleFirstFiveImage()
                .getH2TextShoppingResult();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://dev.swisscows.com/en/shopping?query=smartphone&region=de-DE&brands=58" );

        for(String h2text : actualResult){
            Assert.assertTrue(h2text.contains("iPhone"));
        }
    }
    @QaseTitle("Check filter parameters")
    @Test
    public void testCheckFilterParameters_ShoppingPage() {
        final List<String> expectedFilterTexts = List.of(
                "Sort By", "Marken", "Anbieter", "Zahlungsarten", "Deals & Schnäppchen", "Betriebssystemfamilie", "Display-Diagonale"
                , "Integrierter Speicher", "Farbe", "Kameraauflösung", "Arbeitsspeicher","Auflösung Frontkamera","SIM-Kartenleser",
                "Akkukapazität","Datenübertragung","Sprachassistent","Produkttyp","Schutzart","Bildwiederholfrequenz"
        );
        String searchQuery = "smartphone";

        final List<String> actualFilterTexts = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter(searchQuery)
                .waitUntilVisibilityWebResult()
                .clickShoppingButton()
                .waitUntilVisibilityShoppingResult()
                .waitUntilUrlToBeChanged("/en/shopping?query=" + searchQuery + "&region=de-DE")
                .waitUntilLoaderToBeInVisible()
                .clickFilterButton()
                .getH3TextsInTheFilter();

        Assert.assertEquals(actualFilterTexts.size(),19);
        Assert.assertEquals(actualFilterTexts, expectedFilterTexts);
    }
    @QaseTitle("Check filter expensive")
    @Test
    public void testCheckFilterSortByMostExpensiveFirst_ShoppingPage() {
        String searchQuery = "laptop";

            final String actualPrice = openBaseURL()
                .clickHamburgerMenu()
                .clickRegionTopMenu()
                .clickRegionGerman()
                .inputSearchCriteriaAndEnter(searchQuery)
                .clickShoppingButton()
                .waitUntilUrlToBeChanged("/en/shopping?query=" + searchQuery + "&region=de-DE")
                .waitUntilLoaderToBeInVisible()
                .clickFilterButton()
                .clickMostExpensive()
                .waitUntilUrlToBeChanged("/en/shopping?query=" + searchQuery + "&region=de-DE&sort=PriceDesc")
                .waitUntilLoaderToBeInVisible()
                .getPriceFirstProductInShoppingResult();

        Assert.assertTrue(Integer.parseInt(actualPrice.substring(2, 7))> 16000);
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://dev.swisscows.com/en/shopping?query=laptop&region=de-DE&sort=PriceDesc" );
    }
}
