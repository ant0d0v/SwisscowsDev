package pages;

import io.qase.api.annotation.Step;
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
    private WebElement homepageFirstQuestion;

    @FindBy(xpath = "//h3[@class='question'][1]")
    private WebElement homepageQuestionOne;

    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[4]")
    private WebElement homepageFourthQuestion;

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
    @Step("Open the version.txt page on the Swisscows website.")
    @io.qameta.allure.Step
    public MainPage openVersionTxtPageSwisscows() {
        getDriver().get("https://dev.swisscows.com/version.txt");
        return new MainPage(getDriver());
    }
    @Step("Open the version.txt page on the Accounts website.")
    @io.qameta.allure.Step
    public MainPage openVersionTxtPageAccount() {
        getDriver().get("https://accounts.dev.swisscows.com/version.txt");
        return new MainPage(getDriver());
    }
    @Step("Get the text in the summary page.")
    @io.qameta.allure.Step
    public String getTextInSummaryPage() {

        return getText(summaryPage);
    }
    @Step("Get h1 text on the main page")
    @io.qameta.allure.Step
    public List <String> getH1TextsMainPage() {
        return getTexts(h1TextsMainPage);
    }
    @Step("Get title text on the main page")
    @io.qameta.allure.Step
    public String getMainTittleName() {
        return getText(h1HomeTitle);
    }
    public String getTextPopupInstall() {

        return getText(googlePopupInstall);
    }
    @Step("Get the nickname displayed in the Hamburger menu.")
    @io.qameta.allure.Step
    public String getNicknameInHamburgerMenu() {
        wait10ElementToBeVisible(nicknameHamburgerMenu);
        return getText(nicknameHamburgerMenu);
    }



    @Step("Check that home page logo is displayed")
    @io.qameta.allure.Step
    public boolean isHomePageLogoDisplayed() {
        return isElementDisplayed(logoHome);
    }
    @Step("Click on the search field ")
    @io.qameta.allure.Step
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
    @Step("Click on a first question .")
    @io.qameta.allure.Step
    public MainPage clickFirstQuestion() {
        click(homepageQuestionOne);

        return this;
    }
    @Step("Click on the \"Install Google Block\" button")
    @io.qameta.allure.Step
    public MainPage clickInstallGoogleBlockPopup() {
        click(installGoogleBlockPopup);

        return this;
    }
    @Step("Click on the fourth question")
    @io.qameta.allure.Step
    public MainPage clickFourthQuestion() {
        click(homepageFourthQuestion);

        return this;
    }
    @Step("Click on the link within the fourth question")
    @io.qameta.allure.Step
    public MainPage clickLinkInQuestion4() {
        click(linkInQuestion4);
        switchToAnotherWindow();
        return new MainPage(getDriver());

    }
    @Step("Click on all the questions to expand the answers.")
    @io.qameta.allure.Step
    public MainPage clickAllQuestions(){
        clickAllElementsInList(homepageAllQuestion);
        return new MainPage(getDriver());
    }

    @Step("Scroll to footer menu ")
    @io.qameta.allure.Step
    public MainPage scrollToFooterMenu() {
        scrollByVisibleElement(getFooterMenu());

        return this;
    }

    @Step("Scroll to the last element in the dropdown menu of regions.")
    @io.qameta.allure.Step
    public MainPage scrollToLastElementInDropdownRegion() {
        scrollByVisibleElement(getLastElementInDropdownRegion());

        return this;
    }
    @Step("Input the search criteria (e.g., the defined query).")
    @io.qameta.allure.Step
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
    @Step("Check that  images are dysplaed")
    @io.qameta.allure.Step
    public boolean allImagesDisplayed() {
        return areElementsInListDisplayed(allImagesMainPage);
    }
    @Step("Check that  home page banner are dysplaed")
    @io.qameta.allure.Step
    public boolean homePageBannerIsDisplayed() {
        return isElementDisplayed(homepageBanner);
    }
    @Step("Check that placeholder on the main page  is dysplaed")
    @io.qameta.allure.Step
    public boolean isPlaceholderDisplayedMain() {
        return isElementDisplayed(searchBoxTopMenu);
    }
    @Step("Get text of placeholder")
    @io.qameta.allure.Step
    public String getInnerTextOfPlaceholderMain(String attribute) {
        return getAttribute(searchField, attribute);
    }


    @Step("Click on the main logo to remove focus from the search field")
    @io.qameta.allure.Step
    public MainPage clickMainLogo() {
        click(logoHome);
        return this;
    }
    @Step("Click to popup google")
    @io.qameta.allure.Step
    public MainPage clickPopupGoogle() {
        click(googlePopupInstall);

        return this;
    }
    @Step("Click on the Light theme option.")
    @io.qameta.allure.Step
    public MainPage clickThemeLight() {
        click(secondValueOfLight);

        return new MainPage(getDriver());
    }
    @Step("Click on the Dark theme option.")
    @io.qameta.allure.Step
    public MainPage clickThemeDark() {
        click(thirdValueOfDark);

        return new MainPage(getDriver());
    }
    @Step("Click on the second switch button.")
    @io.qameta.allure.Step
    public MainPage clickBannerSwitchSecond() {
        clickByJavaScript(homepageBannerSwitchSecond);
        return this;
    }
    @Step("Click on the first switch button.")
    @io.qameta.allure.Step
    public MainPage clickBannerSwitchFirst() {
        clickByJavaScript(homepageBannerSwitchFirst);
        return this;
    }

    @Step("Get actual sizes of  suggest ")
    @io.qameta.allure.Step
    public int countElementsInSuggestContainer() {
        return getListSize(suggestListMainPage);
    }

    @Step("Wait to be visible image Email in the banner")
    @io.qameta.allure.Step
    public MainPage waitForImageInBannerVisibleOfEmail() {
        wait20ElementToBeVisible(homepageBannerImageOfEmail);
      return new MainPage(getDriver());
    }
    @Step("Wait to be visible image Music in the banner")
    @io.qameta.allure.Step
    public MainPage waitForImageInBannerVisibleOfMusic() {
        wait20ElementToBeVisible(homepageBannerImageOfMusic);
        return new MainPage(getDriver());
    }
    @Step("Wait for the footer panel to be visible.")
    @io.qameta.allure.Step
    public MainPage waitForFooterPanelToBeVisible() {
        wait20ElementToBeVisible(footerPanelContainer);
        wait20ElementToBeVisible(imageFooterPanel);
       return new MainPage(getDriver());
    }


    @Step("Wait until the suggest container is visible")
    @io.qameta.allure.Step
    public MainPage waitForSuggestToBeVisible() {
        wait20ElementToBeVisible(suggestMainPage);
        return new MainPage(getDriver());

    }
    public VpnPage clickVPNTopMenuAndCloseWindow() {
        click(VPNTopMenu);
        closeWindow();
        return new VpnPage(getDriver());
    }
    @Step("Wait until to be visible popup google install ")
    @io.qameta.allure.Step
    public MainPage waitForPopupGoogleInstallToBeVisible() {
        wait20ElementToBeVisible(googlePopupInstall);
        return new MainPage(getDriver());
    }
    @Step("Wait until to be the visible first answer")
    @io.qameta.allure.Step
    public MainPage waitForAnswerToBeInvisible(){
      wait10ElementToBeInVisible(homepageOneAnswer);
      return new MainPage(getDriver());

    }
    @Step("Scroll to the questions section")
    @io.qameta.allure.Step
    public MainPage scrollToQuestions() {
        scrollByVisibleElement(homepageQuestion6);
        return this;
    }
    @Step("Scroll to the \"Google Block\" popup block.")
    @io.qameta.allure.Step
    public MainPage scrollToBlockGooglePopup() {
        scrollByVisibleElement(installGoogleBlockPopup);

        return this;
    }
    @Step("Scroll to the footer section.")
    @io.qameta.allure.Step
    public MainPage scrollToFooter() {
        scrollByVisibleElement(footerPanelContainer);
        return this;
    }
    @Step("Scroll to the \"Our Services\" section.")
    @io.qameta.allure.Step
    public MainPage scrollToOurService() {
        scrollByVisibleElement(ourServiceContainer);
        return this;
    }
    @Step("Scroll to the About Swisscows section in the footer menu.")
    @io.qameta.allure.Step
    public MainPage scrollToAboutSwisscowsFooterMenu() {
        scrollByVisibleElement(getAboutSwisscowsFooterMenu());

        return this;
    }
    @Step("Scroll to the About SwisscowsAG section in the footer menu.")
    @io.qameta.allure.Step
    public MainPage scrollToAboutSwisscowsAGFooterMenu() {
        scrollByVisibleElement(getAboutSwisscowsAGFooterMenu());

        return this;
    }


    @Step("Get all the links in the footer")
    @io.qameta.allure.Step
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
    @Step("Get the class attribute value of the second switch button.")
    @io.qameta.allure.Step
    public String getClassAttributeSwitchSecond() {

        return getAttribute(homepageBannerSwitchSecond, "class");
    }
    @Step("Get the class attribute value of the first switch button.")
    @io.qameta.allure.Step
   public String getClassAttributeSwitchFirst() {
     return getAttribute(homepageBannerSwitchFirst, "class");
   }
    @Step("Get the class attribute value of the default theme.")
    @io.qameta.allure.Step
    public String getClassAttributeThemeDefault() {
        return getAttribute(firstValueOfTheme, "class");
    }
    @Step("Get the class attribute value of the body of the site.")
    @io.qameta.allure.Step
    public String getClassAttributeBodyOfSite() {
        return getAttribute(bodyIsDark, "class");
    }
    @Step("Get the class attribute value of the light theme.")
    @io.qameta.allure.Step
    public String getClassAttributeThemeLight() {
        return getAttribute(secondValueOfLight, "class");
    }
    @Step("Get the actual class attribute first question")
    @io.qameta.allure.Step
    public String getClassAttributeFirstQuestion() {
        return getAttribute(homepageFirstQuestion,"class");
    }
    @Step("Get the actual class attribute value for all the questions and answer")
    @io.qameta.allure.Step
    public List<String> getClassAttributeAllQuestions() {
        return getAttributeClassAllElements(attributeAllQuestions);
    }

    public List<String> getLinkColorsServicesBlock() throws InterruptedException {

        return  getColorsOfElements(linksServicesBlock);
    }
    @Step("Hover over the services block buttons and get the button colors when hovered over.")
    @io.qameta.allure.Step
    public List<String> getLinksColorsWhenHoverServicesBlock() throws InterruptedException {
        return  getHoverColorsOfElements(linksServicesBlock);
    }
    @Step("Check that music image in banner is dysplaed ")
    @io.qameta.allure.Step
    public boolean imageOfMusicInBannerIsDysplaed() {
        return isElementDisplayed(homepageBannerImageOfMusic);
    }
    @Step("Check that email image in banner is dysplaed ")
    @io.qameta.allure.Step
    public boolean imageOfEmailInBannerIsDysplaed() {
        return isElementDisplayed(homepageBannerImageOfEmail);
    }

    @Step("Get the list of suggestions from the suggest container.")
    @io.qameta.allure.Step
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
    @Step("Click the services block link based on the provided index.")
    @io.qameta.allure.Step
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
