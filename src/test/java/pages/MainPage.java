package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;
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

    @FindBy(xpath = "//div[@class='services-blocks']//a[@href='https://hesbox.com/']")
    private WebElement linkLearnMoreInOurService;

    @FindBy(xpath = "//div[@class='services-blocks']//a[@href='https://swisscows-fanshop.com']")
    private WebElement linkFanShopInOurService;

    @FindBy(xpath = "//div[@class='services-blocks']//a[@href='https://awiebe.org/']")
    private WebElement linkWiebeBlogInOurService;

    @FindBy(xpath = "//ul[@class = 'suggestions']/li")
    private List<WebElement> allChoicesInSuggestion;

    @FindBy(xpath = "//div[@class = 'bnnr-widget']")
    private WebElement homepageBanner;
    @FindBy(xpath = "//div[@class = 'swiper-slide swiper-slide-active']")
    private WebElement homepageBannerSwitchSecondValue;

    @FindBy(xpath = "//div[@class = 'swiper-slide swiper-slide-next']")
    private WebElement homepageBannerSwitchFirstValue;

    @FindBy(xpath = "//span[@class ='swiper-pagination-bullet'][2]")
    private WebElement homepageBannerSwitchSecond;

    @FindBy(xpath = "//span[@class ='swiper-pagination-bullet'][1]")
    private WebElement homepageBannerSwitchFirst;

    @FindBy(xpath = "//img[@src= 'https://api.dev.swisscows.com/b4r/aa0de0145ba54acab978665b92a8c082']")
    private WebElement homepageBannerImage;

    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[1]")
    private WebElement homepageQuestion1;

    @FindBy(xpath = "//h3[@class='question'][1]")
    private WebElement homepageQuestionOne;

    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[2]")
    private WebElement homepageQuestion2;

    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[3]")
    private WebElement homepageQuestion3;
    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[4]")
    private WebElement homepageQuestion4;

    @FindBy(xpath = "//p//a[@href='/en/default-search']")
    private WebElement linkInQuestion4;

    @FindBy(xpath = "//div[@class= 'faq-wrap']//div[5]")
    private WebElement homepageQuestion5;

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

    @FindBy(xpath = "//input[@class ='input-search']")
    private WebElement searchBoxTopMenu;

    @FindBy(xpath = "//ul[@class ='menu-dropdown-list']//li[1]")
    private static WebElement firstValueOfTheme;

    @FindBy(xpath = "//body[@class ='dark']")
    private static WebElement bodyIsDark;

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
    @FindBy(xpath =  "//div//p[@class='title-section']")
    private List<WebElement> h1TextsMainPage;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage createGeneric() {

        return new MainPage(getDriver());
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

    public MainPage clickHomeBanner() {
        Actions action = new Actions(getDriver());
        action.doubleClick(homepageBanner).build().perform();
        switchToAnotherWindow();
        return this;
    }

    public MainPage clickLinkLearnMoreInOurService() {
        click(linkLearnMoreInOurService);
        return new MainPage(getDriver());

    }

    public MainPage clickLinkFanShopInOurService() {
        click(linkFanShopInOurService);
        return new MainPage(getDriver());

    }

    public MainPage clickLinkWiebeBlogInOurService() {
        click(linkWiebeBlogInOurService);
        return new MainPage(getDriver());

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

    public MainPage clickBannerSwitch() {
        click(homepageBannerSwitchSecond);
        return this;
    }
    public MainPage clickBannerSwitchFirst() {
        click(homepageBannerSwitchFirst);
        return this;
    }


    public int countElementsInSuggestContainer() {

        return getListSize(suggestListMainPage);
    }


    public MainPage waitForImageInBannerDisappeared() {
        wait20ElementToBeVisible(homepageBannerImage);
      return new MainPage(getDriver());
    }

    public void waitForFooterPanelToBeVisible() {
        wait20ElementToBeVisible(footerPanelContainer);
        wait20ElementToBeVisible(imageFooterPanel);

    }


    public void waitForSuggestToBeVisible() {
        wait20ElementToBeVisible(suggestMainPage);

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

        return getAttribute(homepageBannerSwitchSecondValue, "class");
    }
   public String getClassAttributeSwitchFirst() {

     return getAttribute(homepageBannerSwitchFirstValue, "class");
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
    public String getClassAttributeQuestion2() {

        return getAttribute(homepageQuestion2,"class");
    }
    public String getClassAttributeQuestion3() {

        return getAttribute(homepageQuestion3,"class");
    }
    public String getClassAttributeQuestion4() {

        return getAttribute(homepageQuestion4,"class");
    }
    public String getClassAttributeQuestion5() {

        return getAttribute(homepageQuestion5,"class");
    }
    public String getClassAttributeQuestion6() {

        return getAttribute(homepageQuestion6,"class");
    }


    public List<String> getAllElementsText() {

        List<String> textList = new ArrayList<>();

        for (WebElement element : allChoicesInSuggestion) {
            textList.add(element.getText().toLowerCase());
        }
        return textList;
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
