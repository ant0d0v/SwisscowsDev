package pages.base_abstract;

import io.qase.api.annotation.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;
import pages.accounts.LoginPage;
import pages.accounts.RegisterPage;
import pages.accounts.SubscriptionsPage;
import pages.accounts.UsersLoginPage;
import pages.footer_menu.MakeDefaultSearchPage;
import pages.footer_menu.SetAsStartPage;
import pages.top_menu.*;


import pages.top_menu.EmailPage;
import pages.top_menu.VpnInstructionsPage;
import pages.top_menu.VpnPage;
import utils.ProjectConstants;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public abstract class TopMenuPage<Generic> extends BasePage {

    private static final String TOP_MENU_ID = "//div[@class = 'badges animation-badges']";
    @FindBy(xpath = TOP_MENU_ID)
    private WebElement topMenuContainer;
    @FindBy(xpath = TOP_MENU_ID + "//a[@class='badge-tg']//img")
    private WebElement TeleGuardTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[@class='badge-vpn']//img")
    private WebElement VPNTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[@class = 'badge-email']//img")
    private WebElement EmailTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//div[@class = 'menu popup']//a[@href = '/en/set-as-startpage']")
    private WebElement setAsStartAppHamburgerMenu;

    @FindBy(xpath = TOP_MENU_ID + "//div[@class = 'menu popup']")
    private WebElement hamburgerDropDownContainerTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a")
    private List<WebElement> topMenus;
    @FindBy(xpath = "//img[@alt = 'Swisscows']")
    private WebElement logo;
    @FindBy(xpath = "//input[@class ='input-search']")
    private WebElement searchFieldTopMenu;
    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@class='badge-email']")
    private WebElement emailTopMenuSearch;

    @FindBy(xpath = "//a[@class='badge-vpn']")
    private WebElement vpnTopMenuSearch;
    @FindBy(xpath = "//a[@class='badge-tg']")
    private WebElement teleGuardTopMenuSearch;

    @FindBy(xpath = "//button[@class ='login']")
    private WebElement signInTopMenu;

    @FindBy(xpath= "//button[@type='reset']")
    private WebElement clearButton;

    @FindBy(xpath = "//header//button[@type = 'button']")
    private WebElement hamburgerTopMenu;

    @FindBy(xpath = "//div[@class ='menu popup']//a")
    private List<WebElement> hamburgerTopMenuDropdownLinks;

    @FindBy(xpath = "//div[@class ='menu popup']//li")
    private List<WebElement> hamburgerTopMenuDropdownList;

    @FindBy(xpath = "//button[@type = 'button']")
    private WebElement hamburgerTopMenuIcon;

    @FindBy(xpath = "//button[@class ='logout']")
    private WebElement LogOutButtonHamburgerDropDownMenu;


    @FindBy(xpath = "//ul[@class ='menu-dropdown-list']/li")
    private List<WebElement> innerLangMenuList;

    @FindBy(xpath = "//ul[@class='menu-dropdown-list']//li")
    private List<WebElement> innerRegionMenuList;

    @FindBy(xpath = "//div[@class ='menu-dropdown-button'][1]")
    private WebElement LangDropDownIcon;
    @FindBy(xpath = "//ul[@class ='menu-dropdown-list']//li[2]")
    private WebElement langGermany;
    @FindBy(xpath = "//h1")
    private WebElement textH1;

    @FindBy(xpath = "//div[@class='menu-dropdown-button'][2]")
    private WebElement RegionDropDownIcon;
    @FindBy(xpath = "//ul[@class='menu-dropdown-list']//li[14]")
    private WebElement RegionGerman;

    @FindBy(xpath = "//div[@class='menu-dropdown-button'][3]")
    private WebElement ThemeDropDownIcon;

    @FindBy(xpath = "//div[@class='menu-dropdown-button'][2]")
    private WebElement lastElementInDropdownRegion;

    @FindBy(xpath = "//div[@class = 'avatar']")
    private WebElement AvatarIconHamburgerMenu;

    @FindBy(xpath = "//button[@class ='login']")
    private WebElement LoginIconHamburgerMenu;

    @FindBy(xpath = "//h3")
    private List<WebElement> textsH3;
    @FindBy(xpath = "//h2")
    private List<WebElement> textsH2;
    @FindBy(xpath = "//div[@class='static-content']//div/a")
    private List<WebElement> allLinksOnPage;
    @FindBy(xpath = "//div[@class='static-content']//a[@class='button outline']")
    private List<WebElement> allLinksOnEmailPage;
    @FindBy(className = "suggestions")
    private WebElement searchDropdownMenu;
    @FindBy(xpath = "//div[@class = 'static-content']//a")
    private List<WebElement> allLinks;
    @FindBy(xpath = "//div[@class='error']//h2[@class]")
    private WebElement h2TitleErrorInFavorite;

    @FindBy(xpath = "//div[@class='faq-wrap']//p")
    private List<WebElement> textsAnswers;
    @FindBy(xpath = "//p//a[@href='https://accounts.swisscows.com/register']")
    private WebElement registerLink;
    @FindBy(xpath = "//a[@href='https://swisscows.email/mbox/index.php/login/oauth'][text()='install web-app']")
    private WebElement InstallWebAppLink;
    @FindBy(xpath = "//p//a[@href='/en/vpn-instruction']")
    private WebElement instructionsLink;
    @FindBy(xpath = "//a[text()='Music']")
    private WebElement musicButton;
    @FindBy(xpath = "//a[text()='Video']")
    private WebElement videoButton;
    @FindBy(xpath = "//a[text()='Images']")
    private WebElement imageButton;
    @FindBy(xpath = "//a[text()='News']")
    private WebElement newsButton;
    @FindBy(xpath = "//button[@class ='button favorite'][1]")
    private WebElement favoriteIcon;

    @FindBy(xpath = "//ul[@class='suggestions']//li[2]")
    private WebElement choiceInDropdownMenu;
    @FindBy(xpath = "//ul[@class='menu-dropdown-list']//li[2]")
    private WebElement langDeutschInHamburgerMenu;

    @FindBy(xpath = "//div[@class = 'image']//img")
    private List<WebElement> allImagesOnPage;
    @FindBy(xpath = "//input[@class = 'input-search']")
    private WebElement searchFieldHeader;
    @FindBy(xpath = "//div[@class='three-bounce']//div[1]")
    private WebElement loader;
    @FindBy(xpath = "//button[@class='button favorite']")
    private List<WebElement> allHeartButtons;
    @FindBy(xpath = "//div[@class ='filters-button']//*[name() = 'svg']")
    private WebElement filterButton;
    @FindBy(xpath = "//div[@class= 'badge']")
    private WebElement heartIcon;
    @FindBy(xpath = "//div[@class= 'search-counter']//div[@class='popup']//p[2]")
    private WebElement popupHeartIcon;
    @FindBy(xpath = "//span[@class= 'header-icon-charity']")
    private WebElement valueHeartIcon;
    @FindBy(xpath = "//ul[@class='menu-dropdown-list']//li[44]")
    private WebElement regionUkraine;
    @FindBy(xpath = "//div[@class ='account']")
    private WebElement accountInHamburgerMenu;
    @FindBy(xpath = "//div[@class='widget-slider']//div[last()]/article/a[1]/figure//img")
    private WebElement lastImageInAds;
    @FindBy(xpath = "//div[@class='widget-slider']//div[2]/article/a[1]/figure/img")
    private WebElement firstImageInAds;

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();
    @Step("Get the actual number of top menu links on the page.")
    public int topMenuLinkAmount() {
        return getListSize(topMenus);
    }

    protected WebElement getLastElementInDropdownRegion() {
        return lastElementInDropdownRegion;
    }
    @Step("Get text of links")
    public List<String> getLinksOfText() {
        return getTexts(hamburgerTopMenuDropdownLinks);
    }
    public LoginPage signIn() {
        clickSignInMenu().signInAsRegularUser();
        return new LoginPage(getDriver());
    }

    @Step("Set the window size to the adaptive mode using the specified width and height constants (e.g., hamburger menu size).")
    public MainPage setWindowWithHamburgerMenu(int width, int height) {
        setWindowDimensions(width, height);
        return new MainPage(getDriver());
    }
    @Step("Wait until to be invisible loader")
    public ImagePage waitForLoaderToBeInVisible(){
        wait10ElementToBeInVisible(loader);
        return new ImagePage(getDriver());
    }
    @Step("Get the list of texts for all the options in the Localization dropdown menu.")
    public List<String> getLangMenuListTexts() {
        return getTexts(innerLangMenuList);
    }
    @Step("Get the list of texts for all the Hamburger menu options.")
    public List<String> getHamburgerMenuAllListText() {
        return getTexts(hamburgerTopMenuDropdownList);
    }
    @Step("Get the number of options in the Localization dropdown menu.")
    public int getNumberLangMenu() {
        return getListSize(innerRegionMenuList);
    }
    @Step("Get the number of options in the region dropdown menu.")
    public int getNumberRegionMenu() {
        return getListSize(innerRegionMenuList);
    }
    @Step("Get the number of options in the Hamburger menu")
    public int getNumberOfListHamburgerMenu() {
        return getListSize(hamburgerTopMenuDropdownList);
    }
    public List<String> getH2FontSizes(){
        return  getFontSizes(textsH2);
    }
    public String getH1FontSizes(){
        return  getFontSize(textH1);
    }
    public int getCountImagesOnPage()  {

        return  getListSize(allImagesOnPage);
    }
    public RegisterPage clickRegisterLink() {
        click(registerLink);
        switchToAnotherWindow();
        return new RegisterPage(getDriver());
    }
    public RegisterPage clickInstallWebLink() {
        click(InstallWebAppLink);
        switchToAnotherWindow();
        return new RegisterPage(getDriver());
    }

    public VpnInstructionsPage clickInstructionsLink() {
        click(instructionsLink);
        switchToAnotherWindow();
        return new VpnInstructionsPage(getDriver());
    }
    @Step("Get the value of the class attribute for the hamburger menu when it is visible.")
    public String getHamburgerMenuIsActiveValue() {
        return getAttribute(hamburgerTopMenu, "class");
    }

    public List<WebElement> getTopMenuLinks() {

        return allLinksOnPage;
    }
    @Step("Wait for the top menu to be visible.")
    public MainPage waitTopMenuToBeVisible(){
        getWait10().until(driver -> {
            try {
                wait10ElementToBeVisible(topMenuContainer);
                return topMenuContainer.isDisplayed();
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });
        return new MainPage(getDriver());
    }
    public VideoPage selectGermanyRegion(){
        clickHamburgerMenu();
        clickRegionTopMenu();
        clickRegionGerman();
        return new VideoPage(getDriver());
    }
    public MusicPage selectDeutschLocalisation(){
        clickHamburgerMenu();
        clickLanguagesHamburgerMenu();
        clickLangDeutsch();
        return new MusicPage(getDriver());
    }

    public void clickTopMenu(int index) {
        List<WebElement> menus = new ArrayList<>();
        click(hamburgerTopMenu);
        menus.addAll(hamburgerTopMenuDropdownLinks);
        click(menus.get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }
    }
    @Step("Click on all heart icons")
    public MusicPage clickOnAllHeart()  {
        getWait20().until(ExpectedConditions.visibilityOfAllElements(allHeartButtons));
        clickAllElementsInList(allHeartButtons);
        return new MusicPage(getDriver());
    }
    @Step("Click on the Log Out option.")
    public MainPage logOut() {
        click(hamburgerTopMenu);
        wait20ElementToBeVisible(LogOutButtonHamburgerDropDownMenu);
        click(LogOutButtonHamburgerDropDownMenu);
        return new MainPage(getDriver());
    }
    @Step("Click the hamburger menu.")
    public MainPage clickHamburgerMenu() {
        click20(hamburgerTopMenu);
        return new MainPage(getDriver());
    }
    @Step("Click on the region in the top menu (e.g., German).")
    public MainPage clickRegionGerman() {
        click20(RegionGerman);
        return new MainPage(getDriver());
    }
    @Step("Click germany languages")
    public MainPage clickGermanyLang() {
        click(langGermany);

        return new MainPage(getDriver());
    }
    public List <String> getColorLinks (){
        return getColors(allLinks);
    }



    public void clickTopMenuExternalLink (int index) {
        click(getTopMenuLinks().get(index));
        switchToAnotherWindow();
        getWait20().until(ExpectedConditions.numberOfWindowsToBe(2));
    }
    @Step("Click the company logo.")
    public MainPage clickLogo() {
        click(logo);
        return new MainPage(getDriver());
    }

    @Step("Click on the TeleGuard icon in the top menu")
    public MainPage clickTeleGuardTopMenu() {
        click(TeleGuardTopMenu);
        return new MainPage(getDriver());
    }
    @Step("Click on the Languages option in the hamburger menu")
    public MainPage clickLanguagesHamburgerMenu() {
        click20(LangDropDownIcon);
        return new MainPage(getDriver());
    }
    @Step("Click on the Email icon in the top menu")
    public EmailPage clickEmailTopMenu() {
        getWait10().until(driver -> {
        try {
            click20(EmailTopMenu);
            return EmailTopMenu.isDisplayed();
        } catch (StaleElementReferenceException e) {
            return false;
        }
        });
        return new EmailPage(getDriver());
    }
    @Step("Click on the Email icon in the top menu ")
    public LoginPage clickEmailTopMenuSearch() {
        waitForElementIsDisappeared(loader);
        click(emailTopMenuSearch);
        return  new LoginPage (getDriver());
    }
    @Step("Click on the VPN icon in the top menu ")
    public VpnPage clickVpnTopMenuSearch() {
        wait10ElementToBeVisible(vpnTopMenuSearch);
        click(vpnTopMenuSearch);
        return  new VpnPage (getDriver());
    }
    @Step("Click on the TeleGuard icon in the top menu ")
    public MainPage clickTeleGuardTopMenuSearch() {
        wait10ElementToBeVisible(teleGuardTopMenuSearch);
        click(teleGuardTopMenuSearch);
        return  new MainPage (getDriver());
    }
    @Step("Click the region top menu.")
    public MainPage clickRegionTopMenu() {
        click20(RegionDropDownIcon);
        return new MainPage(getDriver());
    }
    @Step("Click on the theme dropdown icon.")
    public MainPage clickThemeDropDownIcon() {
        click(ThemeDropDownIcon);

       return new MainPage(getDriver());
    }
    @Step("Click on \"Account\" in the hamburger menu.")
    public SubscriptionsPage clickAccountInHamburgerMenu() {
        click(accountInHamburgerMenu);
        return new SubscriptionsPage (getDriver());
    }

    public VpnPage clickVPNTopMenu() {
        click(VPNTopMenu);
        switchToExternalPage();
        return new VpnPage(getDriver());
    }
    @Step("Click hamburger menu icon")
    public MainPage clickHamburgerMenuIcon() {
        click(hamburgerTopMenu);

        return new MainPage(getDriver());
    }
    @Step("Get h3 texts")
    public List <String> getH3Texts() {
        return getTexts(textsH3);
    }
    public List <String> getH2Texts() {
        return getTexts(textsH2);
    }
    public String getH1Text() {

        return getText(textH1);
    }
    @Step("Get the texts of the answers.")
    public List <String> getAnswersTexts() {
        return getTexts(textsAnswers);
    }
    @Step("Get the text of the heart icon popup message.")
    public String getHeartPopupMessage() {
        return getText(popupHeartIcon);
    }
    @Step("Click the \"Set as Startpage\" link in the hamburger menu.")
    public SetAsStartPage clickSetAsStartAppInHamburgerMenu() {
        click(setAsStartAppHamburgerMenu);
        switchToAnotherWindow();

        return new SetAsStartPage(getDriver());
    }


    public void inputSearchCriteriaIntoSearchField(String text) {
        if (!getText(searchFieldTopMenu).isEmpty() && !getText(searchFieldTopMenu).isBlank()) {
            clear(searchFieldTopMenu);
        }
        input(text, searchFieldTopMenu);

        new WebPage(getDriver());
    }

    public WebPage clickEnter() {
        clickEnter(searchFieldTopMenu);

        return new WebPage(getDriver());
    }
    @Step("Click the search icon.")
    public WebPage clickSearchButton() {
        clickEnter(searchButton);

        return new WebPage(getDriver());
    }
    @Step("Click video button")
    public VideoPage clickVideoButton() {
        clickEnter(videoButton);

        return new VideoPage(getDriver());
    }
    @Step("Click music button")
    public MusicPage clickMusicButton() {
        clickEnter(musicButton);
        return new MusicPage(getDriver());
    }
    @Step("Click image button")
    public ImagePage clickImageButton() {
        clickEnter(imageButton);
        return new ImagePage(getDriver());
    }
    @Step("Wait until url to be changed ")
    public ImagePage waitUrlToBeChanged(String parametr){
        waitForUrlContains(ProjectConstants.DOMAIN +parametr);
        return new ImagePage(getDriver());
    }
    @Step("Get tittle of error in favorite")
    public String getErrorOfTitleInFavorite()  {
        wait10ElementToBeVisible(h2TitleErrorInFavorite);
        return getText(h2TitleErrorInFavorite);
    }
    @Step("Click on the \"News\" button")
    public NewsPage clickNewsButton() {
        clickEnter(newsButton);

        return new NewsPage(getDriver());
    }
    @Step("Click filter button")
    public WebPage clickFilterButtonWeb() {
        click20(filterButton);
        return new WebPage(getDriver());
    }
    @Step("Click the region Ukraine")
    public NewsPage clickRegionUkraine() {
        click20(regionUkraine);
        return new NewsPage(getDriver());
    }
    @Step("Click search field")
    public MainPage clickSearchFieldHeader() {
        click(searchFieldHeader);
        return new MainPage(getDriver());
    }
    @Step("Click on the heart icon.")
    public MainPage clickHeartIcon() {
        click(heartIcon);

        return new MainPage(getDriver());
    }
    @Step("Hamburger dropdown container is displayed ")
    public boolean isHamburgerDropdownContainerDisplayed() {
        return isElementDisplayed(hamburgerDropDownContainerTopMenu);
    }
    @Step("Verify that the Hamburger menu icon is displayed.")
    public boolean isHamburgerIconDisplayed() {
        return isElementDisplayed(hamburgerTopMenuIcon);
    }

    @Step("Verify that the login icon is displayed.")
    public boolean isLoginIconDisplayed() {
        return isElementDisplayed(LoginIconHamburgerMenu);
    }
    @Step("Verify that the avatar icon is displayed in the hamburger menu")
    public boolean isAvatarIconIsDisplayedInHamburgerMenu() {
        return isElementDisplayed(AvatarIconHamburgerMenu);
    }
    @Step("Verify that the logo image is displayed in the header")
    public boolean isLogoIconDisplayed() {
        return isElementDisplayed(logo);
    }
    @Step("Verify that all elements on page are displayed.")
    public boolean allElementsDisplayed() {
        return areElementsInListDisplayed(allImagesOnPage);
    }
    @Step("Click on the Sign In menu.")
    public UsersLoginPage clickSignInMenu() {
        click20(signInTopMenu);
        return new UsersLoginPage(getDriver());
    }
    @Step("Click favorite icon")
    public MusicPage clickFavoriteIcon() {
        wait10ElementToBeVisible(favoriteIcon);
        click(favoriteIcon);
        return new MusicPage(getDriver());
    }
    @Step("Click language Deutsch")
    public void clickLangDeutsch() {
        wait10ElementToBeVisible(langDeutschInHamburgerMenu);
        click(langDeutschInHamburgerMenu);
        new WebPage(getDriver());
    }
    @Step("Search after clear int the search field")
    public NewsPage searchAfterClearSearchField(String text) {
        inputAfterClear(searchFieldHeader,text);
        return new NewsPage(getDriver());
    }
    @Step("Search and clear after")
    public void searchAfterClear(String text){
        click(clearButton);
        wait10ElementToBeEmpty(searchFieldHeader);
        searchFieldHeader.sendKeys(text);
        clickEnter();

        new NewsPage(getDriver());
    }


    @Step("Get the value of the heart icon counter.")
    public String getValueHeartIcon() {
        int attempts = 0;
        while (attempts < 2) {
            try {
                return valueHeartIcon.getAttribute("title");
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        return null;
    }
    @Step("Refresh main page")
    public MainPage refreshMainPage() {
        refreshPage();
        wait10ElementToBeVisible(heartIcon);
        return new MainPage(getDriver());
    }
    @Step("Go back to main page")
    public MainPage goBackToMainPage() {
        goBack();
        return new MainPage(getDriver());
    }
    @Step("Wait until to be changed value of charity")
    public WebPage waitCharityValueCountChanged(String newValue ) {
        waitAttributeToBeChanged(valueHeartIcon, "title",newValue);
        return new WebPage(getDriver());
    }

    public void clickLangDropDown(int index) {
        click(LangDropDownIcon);
        click(getInnerLangMenuList().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }

        createGeneric();
    }
    public SetAsStartPage clickLangDropDownSetAsStart(int index) {
        click(LangDropDownIcon);
        click(getInnerLangMenuList().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }

        createGeneric();
        return new SetAsStartPage(getDriver());
    }

    public MakeDefaultSearchPage clickLangDropDownMakeDefault(int index) {
        click(LangDropDownIcon);
        click(getInnerLangMenuList().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }

        createGeneric();
        return new MakeDefaultSearchPage (getDriver());
    }

    public MainPage clickRegionDropDown(int index) {
        click(RegionDropDownIcon);
        click(getInnerRegionMenuList().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }
        createGeneric();
        return new MainPage(getDriver());
    }

    public List<WebElement> getInnerLangMenuList() {

        return innerLangMenuList;
    }
    public List<WebElement> getInnerRegionMenuList() {

        return innerRegionMenuList;
    }
    @Step("Input the search criteria and press Enter.")
    public WebPage inputSearchCriteriaAndEnter(String text) {
        inputSearchCriteriaIntoSearchField(text);
        clickEnter();
        return new WebPage(getDriver());
    }
    @Step("Check that last image of ads is dysplaed")
    public boolean lastImageInAdsIsDisplayed() {
        wait10ElementToBeVisible(lastImageInAds);
        return isElementDisplayed(lastImageInAds);

    }
    @Step("Check that first image of ads is dysplaed")
    public boolean firstImageInAdsIsDisplayed() {
        wait10ElementToBeVisible(firstImageInAds);
        return isElementDisplayed(firstImageInAds);
    }

}
