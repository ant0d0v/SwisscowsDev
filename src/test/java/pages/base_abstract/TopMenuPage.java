package pages.base_abstract;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import pages.accounts.LoginPage;
import pages.accounts.UsersLoginPage;
import pages.top_menu.VpnPage;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class TopMenuPage<Generic> extends BasePage {

    private static final String TOP_MENU_ID = "//div[@class = 'badges animation-badges']";
    private static final String HAMBURGER_DROPDOWN_ID = "//button[@class = 'hamburger-menu']";

    @FindBy(xpath = "//a[@class = 'logo']")
    private WebElement logo;
    @FindBy(xpath = TOP_MENU_ID) // 3 links [teleGuard, VPN, Email]
    private WebElement topMenuContainer;

    @FindBy(xpath = TOP_MENU_ID + "//a") // 3 links [teleGuard, VPN, Email]
    private List<WebElement> topMenuLinks;

    @FindBy(xpath = TOP_MENU_ID + "//div[@class='input-search-wrap']")
    private WebElement searchBoxMainPage;

    @FindBy(xpath = TOP_MENU_ID + "//input[@class ='input-search']")
    private WebElement searchFieldTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[3]")
    private WebElement TeleGuardTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[2]")
    private WebElement VPNTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[1]")
    private WebElement EmailTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//div[@class = 'menu popup']//a[@href = '/en/set-as-startpage']")
    private WebElement setAsStartAppHamburgerMenu;

    @FindBy(xpath = TOP_MENU_ID + "//div[@class = 'menu popup']")
    private WebElement hamburgerDropDownContainerTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[@href='/our-initiatives']")
    private WebElement ourInitiativesTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[@href='/examples']")
    private WebElement partnersTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a")
    private List<WebElement> topMenus;

    @FindBy(xpath = TOP_MENU_ID + "//a[@href='/weather-dashboard']")
    private WebElement dashboardTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[@href='https://openweathermap.org/weather-dashboard']")
    private WebElement homeDashboardTopMenu;

    @FindBy(xpath = "//button[@class ='login']")
    private WebElement signInTopMenu;

    @FindBy(xpath= "//div[@class ='account']")
    private WebElement userInfoContainer;

    @FindBy(xpath = "//button[@type = 'button']")
    private WebElement hamburgerTopMenu;

    @FindBy(xpath = "//div[@class ='menu popup']//a")
    private List<WebElement> hamburgerTopMenuDropdownLinks;

    @FindBy(xpath = "//div[@class ='menu popup']//li")
    private List<WebElement> hamburgerTopMenuDropdownList;

    @FindBy(xpath = HAMBURGER_DROPDOWN_ID + "//li/a[@href='/faq']")
    private WebElement faqSupportSubmenu;

    @FindBy(xpath = HAMBURGER_DROPDOWN_ID + "//li/a[@href='/appid']")
    private WebElement howToStartSupportSubmenu;

    @FindBy(xpath = HAMBURGER_DROPDOWN_ID + "//li/a[@href='https://home.openweathermap.org/questions']")
    private WebElement askQuestionSupportSubmenu;

    @FindBy(xpath = "//button[@type = 'button']")
    private WebElement hamburgerTopMenuIcon;

    @FindBy(xpath = "//button[@type = 'button']")
    private WebElement hamburgerDropDownMenu;

    @FindBy(xpath = "//button[@class ='logout']")
    private WebElement LogOutButtonHamburgerDropDownMenu;


    @FindBy(xpath = "//ul[@class ='menu-dropdown-list']/li")
    private List<WebElement> innerLangMenuList;

    @FindBy(xpath = "//ul[@class='menu-dropdown-list']//li")
    private List<WebElement> innerRegionMenuList;

    @FindBy(xpath = "//div[@class ='menu-dropdown-button'][1]")
    private WebElement LangDropDownIcon;

    @FindBy(xpath = "//div[@class='menu-dropdown-button'][2]")
    private WebElement RegionDropDownIcon;

    @FindBy(xpath = "//div[@class='menu-dropdown-button'][3]")
    private WebElement ThemeDropDownIcon;

    @FindBy(xpath = "//div[@class='menu-dropdown-button'][2]")
    private WebElement lastElementInDropdownRegion;

    @FindBy(xpath = "//div[@class = 'avatar']")
    private WebElement AvatarIconHamburgerMenu;

    @FindBy(xpath = "//button[@class ='login']")
    private WebElement LoginIconHamburgerMenu;



    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();

    public int topMenuLinkAmount() {

        return getListSize(topMenus);
    }

    public String getInnerTextOfPlaceholder(String attribute) {

        return getAttribute(searchFieldTopMenu, attribute);
    }

    protected WebElement getLastElementInDropdownRegion() {

        return lastElementInDropdownRegion;
    }

    public List<String> getLinksText() {

        return getTexts(hamburgerTopMenuDropdownLinks);
    }

    public LoginPage signIn() {
        clickSignInMenu().signInAsRegularUser();

        return new LoginPage(getDriver());
    }

    public MainPage setWindowWithHamburgerMenu(int width, int height) {
        setWindowDimensions(width, height);

        return new MainPage(getDriver());
    }

    public List<String> getLangMenuListTexts() {

        return getTexts(innerLangMenuList);
    }

    public List<String> getHamburgerMenuAllListText() {

        return getTexts(hamburgerTopMenuDropdownList);
    }

    public int getNumberLangMenu() {

        return getListSize(innerRegionMenuList);
    }
    public int getNumberRegionMenu() {

        return getListSize(innerRegionMenuList);
    }
    public int getNumberOfListHamburgerMenu() {

        return getListSize(hamburgerTopMenuDropdownList);
    }

    public String getHamburgerMenuIsActiveValue() {

        return getAttribute(hamburgerTopMenu, "class");
    }

    public List<WebElement> getTopMenuLinks() {

        return topMenuLinks;
    }

    public void waitTopMenuToBeInvisible(){
        wait10ElementToBeInVisible(topMenuContainer);

    }

    public void waitHamburgerDropDownMenuToBeInvisible(){
        wait10ElementToBeInVisible(userInfoContainer);

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

    public MainPage logOut() {
        click(hamburgerTopMenu);
        wait20ElementToBeVisible(LogOutButtonHamburgerDropDownMenu);
        click(LogOutButtonHamburgerDropDownMenu);
        return new MainPage(getDriver());
    }

    public MainPage clickHamburgerMenu() {
        click(hamburgerTopMenu);

        return new MainPage(getDriver());
    }

    public void clickTopMenuExternalLink (int index) {
        click(getTopMenuLinks().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
            TestUtils.waitForPageLoaded(getDriver());
        }
    }

    public void setOriginalHandle() {

        getDriver().getWindowHandle();
    }

    public MainPage clickLogo() {
        click(logo);

        return new MainPage(getDriver());
    }


    /*public OurInitiativesPage clickOurInitiativesMenu() {
        click(ourInitiativesTopMenu);

        return new OurInitiativesPage(getDriver());
    }*/


    public void clickTeleGuardTopMenu() {
        click(TeleGuardTopMenu);

        new MainPage(getDriver());
    }

    public void clickEmailTopMenu() {
        click(EmailTopMenu);

        new MainPage(getDriver());
    }

    public void clickLanguagesTopMenu() {
        click(LangDropDownIcon);

        new MainPage(getDriver());
    }

    public void clickRegionTopMenu() {
        click(RegionDropDownIcon);

        new MainPage(getDriver());
    }

    public void clickThemeDropDownIcon() {
        click(ThemeDropDownIcon);

        new MainPage(getDriver());
    }

    public VpnPage clickVPNTopMenu() {
        click(VPNTopMenu);

        return new VpnPage(getDriver());
    }



    public MainPage clickSearchFieldTopMenu() {
        click(searchFieldTopMenu);

        return new MainPage(getDriver());
    }

    public void clickHamburgerMenuIcon() {
        click(hamburgerTopMenu);

        new MainPage(getDriver());
    }

    public void clickSetAsStartAppInHamburgerMenu() {
        click(setAsStartAppHamburgerMenu);

        new MainPage(getDriver());
    }



  /*  public FindPage inputSearchCriteriaIntoSearchField(String text) {
        if (!getText(searchFieldTopMenu).isEmpty() && !getText(searchFieldTopMenu).isBlank()) {
            clear(searchFieldTopMenu);
        }
        input(text, searchFieldTopMenu);

        return new FindPage(getDriver());
    }

    public FindPage clickEnter() {
        clickEnter(searchFieldTopMenu);

        return new FindPage(getDriver());
    }*/

    public boolean isPlaceholderDisplayed() {

        return isElementDisplayed(searchBoxMainPage);
    }

    public boolean isHamburgerDropdownContainerDisplayed() {

        return isElementDisplayed(hamburgerDropDownContainerTopMenu);
    }

    public boolean isHamburgerIconDisplayed() {

        return isElementDisplayed(hamburgerTopMenuIcon);
    }

    public boolean isLoginIconDisplayed() {

        return isElementDisplayed(LoginIconHamburgerMenu);
    }

    public boolean isAvatarIconIsDisplayedInHamburgerMenu() {

        return isElementDisplayed(AvatarIconHamburgerMenu);
    }

    public boolean isLogoIconDisplayed() {

        return isElementDisplayed(logo);
    }
    public UsersLoginPage clickSignInMenu() {
        click20(signInTopMenu);

        return new UsersLoginPage(getDriver());
    }

    public String getEnteredValue() {

        return getAttribute(searchFieldTopMenu, "value");
    }
    public void clickLangDropDown(int index) {
        click(LangDropDownIcon);
        click(getInnerLangMenuList().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }

        createGeneric();
    }

    public void clickRegionDropDown(int index) {
        click(RegionDropDownIcon);
        click(getInnerRegionMenuList().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }

        createGeneric();
    }

    public List<WebElement> getInnerLangMenuList() {

        return innerLangMenuList;
    }
    public List<WebElement> getInnerRegionMenuList() {

        return innerRegionMenuList;
    }



   /* public FindPage inputSearchCriteriaAndEnter(String text) {
        inputSearchCriteriaIntoSearchField(text);
        clickEnter();

        return new FindPage(getDriver());
    }*/
}
