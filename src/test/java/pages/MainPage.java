package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;
import pages.top_menu.MusicPage;
import pages.top_menu.VpnPage;

import java.util.ArrayList;
import java.util.List;


public class MainPage extends FooterMenuPage<MainPage> {

    @FindBy(xpath = "//div[@class = 'logo-home']//h1")
    private WebElement h1HomeTitle;

    @FindBy(xpath = "//input[@class = 'input-search'][@placeholder = 'Your search. Your business.']")
    private WebElement searchCityField; // swisscows

    @FindBy(xpath = "//div[@class = 'logo-home']//h1")
    private WebElement logoHome; // swisscows

    @FindBy(xpath = "//div[@class='services-blocks']")
    private WebElement ourServiceContainer;

    @FindBy(xpath = "//ul[@class = 'suggestions']/li")
    private List<WebElement> allChoicesInSuggestion;

    @FindBy(xpath = "//div[@class = 'bnnr-widget']")
    private WebElement homepageBanner;

    @FindBy(xpath = "(//span[contains (@class ,'swiper-pagination-bullet')])[position() =2]")
    private WebElement homepageBannerSwitchSecond;

    @FindBy(xpath = "(//span[contains (@class ,'swiper-pagination-bullet')])[position() =1]")
    private WebElement homepageBannerSwitchFirst;

    @FindBy(xpath = "(//img[@src= 'https://api.dev.swisscows.com/b4r/be94588d61a04cd6849392dd3884464d'])[position() = 2]")
    private WebElement homepageBannerImageOfEmail;
    @FindBy(xpath = "(//img[@src= 'https://api.dev.swisscows.com/b4r/991b8059be404bb2ac04c6ad90662351'])[position() = 2]")
    private WebElement homepageBannerImageOfMusic;

    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[1]")
    private WebElement homepageQuestion1;

    @FindBy(xpath = "//h3[@class='question'][1]")
    private WebElement homepageQuestionOne;

    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[4]")
    private WebElement homepageQuestion4;

    @FindBy(xpath = "//p//a[@href='/en/default-search']")
    private WebElement linkInQuestion4;

    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[6]")
    private WebElement homepageQuestion6;

    @FindBy(xpath = "//div[@class= 'faq-wrap']//h3")
    private List<WebElement> homepageAllQuestion;

    @FindBy(xpath = "//p[@class= 'answer close']")
    private WebElement homepageOneAnswer;

    @FindBy(xpath = "//a[@class = 'install-sw-block popup']")
    private WebElement installGoogleBlockPopup;

    @FindBy(xpath = "//div[@class='home-link-instruction popup animation-badges']")
    private WebElement googlePopupInstall;

    @FindBy(xpath = "//div[@class='footer-full-inner-wrap']")
    private WebElement footerPanelContainer;

    @FindBy(xpath = "//img[@class='footer-back']")
    private WebElement imageFooterPanel;

    @FindBy(xpath = "//ul[@class = 'suggestions']")
    private WebElement suggestMainPage;

    @FindBy(xpath = "//ul[@class = 'suggestions']//li")
    private List<WebElement> suggestListMainPage;

    @FindBy(xpath = "//footer[@class='footer-full']//a[@href]")
    private List<WebElement> allLinks;
    @FindBy(xpath = "//div[@class= 'faq-wrap']//div")
    private List<WebElement> attributeAllQuestions;

    @FindBy(xpath = "//input[@class ='input-search']")
    private WebElement searchBoxTopMenu;

    @FindBy(xpath = "//ul[@class ='menu-dropdown-list']//li[1]")
    private static WebElement firstValueOfTheme;

    @FindBy(xpath = "//body[@class ='dark']")
    private static WebElement bodyIsDark;
    @FindBy(xpath =  "//div[@class = 'badges animation-badges']//a[2]")
    private WebElement VPNTopMenu;

    @FindBy(xpath = "//ul[@class ='menu-dropdown-list']//li[2]")
    private static WebElement secondValueOfLight;
    @FindBy(xpath = "//ul[@class ='menu-dropdown-list']//li[3]")
    private static WebElement thirdValueOfDark;

    @FindBy(xpath =  "//input[@class ='input-search']")
    private WebElement searchField;
    @FindBy(xpath =  "//a[@class = 'userinfo']")
    private WebElement nicknameHamburgerMenu;
    @FindBy(xpath =  "//div/img")
    private List<WebElement> allImagesMainPage;
    @FindBy(xpath =  "//h2")
    private List<WebElement> h2TextsMainPage;
    @FindBy(xpath =  "//body")
    private WebElement summaryPage;
    @FindBy(xpath =  "//div//p[@class='title-section']")
    private List<WebElement> h1TextsMainPage;
    @FindBy(xpath =  "//div[@class='services-blocks']//a")
    private List<WebElement> linksServicesBlock;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage createGeneric() {

        return new MainPage(getDriver());
    }
    public MainPage openVersionTxtPageSwisscows() {
        getDriver().get("https://dev.swisscows.com/version.txt");
        return new MainPage(getDriver());
    }
    public MainPage openVersionTxtPageAccount() {
        getDriver().get("https://accounts.dev.swisscows.com/version.txt");
        return new MainPage(getDriver());
    }
    public String getTextInSummaryPage() {

        return getText(summaryPage);
    }
    public List <String> getH2TextsMainPage() {

        return getTexts(h2TextsMainPage);
    }
    public List <String> getH1TextsMainPage() {

        return getTexts(h1TextsMainPage);
    }

    public String getMainTittleName() {

        return getText(h1HomeTitle);
    }
    public String getTextPopupInstall() {

        return getText(googlePopupInstall);
    }

    public String getNicknameInHamburgerMenu() {

        return getText(nicknameHamburgerMenu);
    }



    public boolean isHomePageLogoDisplayed() {

        return isElementDisplayed(logoHome);
    }

    public MainPage clickSearchField() {
        click(searchCityField);

        return this;
    }

    public MusicPage clickHomeBanner() {
        Actions action = new Actions(getDriver());
        action.doubleClick(homepageBanner).build().perform();
        switchToAnotherWindow();
        return new MusicPage(getDriver());
    }

    public MainPage clickQuestion1() {
        click(homepageQuestionOne);

        return this;
    }

    public MainPage clickInstallGoogleBlockPopup() {
        click(installGoogleBlockPopup);

        return this;
    }

    public MainPage clickQuestion4() {
        click(homepageQuestion4);

        return this;
    }
    public MainPage clickLinkInQuestion4() {
        click(linkInQuestion4);
        switchToAnotherWindow();
        return new MainPage(getDriver());

    }

    public MainPage clickAllQuestions(){
        clickAllElementsInList(homepageAllQuestion);
        return new MainPage(getDriver());
    }

    public MainPage scrollToFooterMenu() {
        scrollByVisibleElement(getFooterMenu());

        return this;
    }


    public MainPage scrollToLastElementInDropdownRegion() {
        scrollByVisibleElement(getLastElementInDropdownRegion());

        return this;
    }

    public MainPage inputSearchCriteria(String text) {
        input(text, searchCityField);

        return this;
    }

    public boolean isPopupGoogleDisplayed() {

        return isElementDisplayed(googlePopupInstall);
    }



    public boolean suggestIsDisplayed() {

        return isElementDisplayed(suggestMainPage);
    }
    public boolean allImagesDisplayed() {

        return areElementsInListDisplayed(allImagesMainPage);
    }

    public boolean homePageBannerIsDisplayed() {

        return isElementDisplayed(homepageBanner);
    }

    public boolean isPlaceholderDisplayedMain() {

        return isElementDisplayed(searchBoxTopMenu);
    }

    public String getInnerTextOfPlaceholderMain(String attribute) {

        return getAttribute(searchField, attribute);
    }



    public MainPage clickMainLogo() {
        click(logoHome);

        return this;
    }

    public MainPage clickPopupGoogle() {
        click(googlePopupInstall);

        return this;
    }

    public MainPage clickThemeLight() {
        click(secondValueOfLight);

        return new MainPage(getDriver());
    }
    public MainPage clickThemeDark() {
        click(thirdValueOfDark);

        return new MainPage(getDriver());
    }

    public MainPage clickBannerSwitchSecond() {
        clickByJavaScript(homepageBannerSwitchSecond);
        return this;
    }
    public MainPage clickBannerSwitchFirst() {
        clickByJavaScript(homepageBannerSwitchFirst);
        return this;
    }


    public int countElementsInSuggestContainer() {

        return getListSize(suggestListMainPage);
    }


    public MainPage waitForImageInBannerVisibleOfEmail() {
        wait20ElementToBeVisible(homepageBannerImageOfEmail);
      return new MainPage(getDriver());
    }
    public MainPage waitForImageInBannerVisibleOfMusic() {
        wait20ElementToBeVisible(homepageBannerImageOfMusic);
        return new MainPage(getDriver());
    }

    public void waitForFooterPanelToBeVisible() {
        wait20ElementToBeVisible(footerPanelContainer);
        wait20ElementToBeVisible(imageFooterPanel);

    }


    public MainPage waitForSuggestToBeVisible() {
        wait20ElementToBeVisible(suggestMainPage);
        return new MainPage(getDriver());

    }
    public VpnPage clickVPNTopMenuAndCloseWindow() {
        click(VPNTopMenu);
        closeWindow();
        return new VpnPage(getDriver());
    }
    public MainPage waitForPopupGoogleInstallToBeVisible() {
        wait20ElementToBeVisible(googlePopupInstall);
        return new MainPage(getDriver());

    }

    public MainPage waitForAnswerToBeInvisible(){
      wait10ElementToBeInVisible(homepageOneAnswer);
      return new MainPage(getDriver());

    }

    public MainPage scrollToQuestions() {
        scrollByVisibleElement(homepageQuestion6);

        return this;
    }

    public MainPage scrollToBlockGooglePopup() {
        scrollByVisibleElement(installGoogleBlockPopup);

        return this;
    }
    public MainPage scrollToFooter() {
        scrollByVisibleElement(footerPanelContainer);

        return this;
    }
    public MainPage scrollToOurService() {
        scrollByVisibleElement(ourServiceContainer);

        return this;
    }

    public MainPage scrollToAboutSwisscowsFooterMenu() {
        scrollByVisibleElement(getAboutSwisscowsFooterMenu());

        return this;
    }
    public MainPage scrollToAboutSwisscowsAGFooterMenu() {
        scrollByVisibleElement(getAboutSwisscowsAGFooterMenu());

        return this;
    }



    public List<String> getAllLinks() {
        List<String> linksList = new ArrayList<>();

        for (WebElement link : allLinks) {
            linksList.add(getAttribute(link, "href"));
        }

        return linksList;
    }

    public String getClassAttribute(WebElement element) {

        return getAttribute(element, "class");
    }

    public String getClassAttributeSwitchSecond() {

        return getAttribute(homepageBannerSwitchSecond, "class");
    }
   public String getClassAttributeSwitchFirst() {

     return getAttribute(homepageBannerSwitchFirst, "class");
   }

    public String getClassAttributeThemeDefault() {

        return getAttribute(firstValueOfTheme, "class");
    }

    public String getClassAttributeBodyOfSite() {

        return getAttribute(bodyIsDark, "class");
    }
    public String getClassAttributeThemeLight() {

        return getAttribute(secondValueOfLight, "class");
    }

    public String getClassAttributeQuestion1() {

        return getAttribute(homepageQuestion1,"class");
    }
    public List<String> getClassAttributeAllQuestions() {

        return getAttributeClassAllElements(attributeAllQuestions);
    }

    public List<String> getLinkColorsServicesBlock() throws InterruptedException {

        return  getColorsOfElements(linksServicesBlock);
    }
    public List<String> getLinksColorsWhenHoverServicesBlock() throws InterruptedException {

        return  getHoverColorsOfElements(linksServicesBlock);
    }


    public List<String> getAllElementsText() {

        List<String> textList = new ArrayList<>();

        for (WebElement element : allChoicesInSuggestion) {
            textList.add(element.getText().toLowerCase());
        }
        return textList;
    }
    public List<WebElement> getServicesBlockLinks() {

        return linksServicesBlock;
    }
    public void clickServicesBlockLinks(int index) {
        click(getServicesBlockLinks().get(index));
        switchToAnotherWindow();

    }



    public void switchToAnotherWindow() {
        String originalWindow = getDriver().getWindowHandle();

        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!originalWindow.equals(windowHandle) && getDriver().getWindowHandles().size() == 2) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
    public MainPage closeWindow() {
        getDriver().close();
        return this;

    }


}
