package pages.base_abstract;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.FindPage;
import pages.MainPage;
import pages.OurInitiativesPage;
import pages.home.HomeAskQuestionPage;
import pages.home.HomeMarketplacePage;
import pages.home.HomePage;
import pages.home.HomeUsersSignInPage;
import pages.top_menu.*;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class TopMenuPage<Generic> extends BasePage {

    private static final String TOP_MENU_ID = "//div[@id='desktop-menu']";
    private static final String SUPPORT_DROPDOWN_ID = "//ul[@id='support-dropdown-menu']";

    @FindBy(xpath = "//li[@class='logo']/a")
    private WebElement logo;

    @FindBy(xpath = TOP_MENU_ID + "//a")
    private List<WebElement> topMenuLinks;

    @FindBy(xpath = TOP_MENU_ID + "//form[@role='search']")
    private WebElement searchBoxTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//input[@name='q']")
    private WebElement searchFieldTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[@href='/guide']")
    private WebElement guideTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//li/a[@href='/api']")
    private WebElement apiTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[@href='https://home.openweathermap.org/marketplace']")
    private WebElement marketplaceTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[@href='/price']")
    private WebElement pricingTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[@href='/weathermap']")
    private WebElement mapsTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[@href='/our-initiatives']")
    private WebElement ourInitiativesTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[@href='/examples']")
    private WebElement partnersTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "/ul/li")
    private List<WebElement> topMenus;

    @FindBy(xpath = TOP_MENU_ID + "//a[@href='/weather-dashboard']")
    private WebElement dashboardTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//a[@href='https://openweathermap.org/weather-dashboard']")
    private WebElement homeDashboardTopMenu;

    @FindBy(xpath = TOP_MENU_ID + "//li[@class='user-li']/a")
    private WebElement signInTopMenu;

    @FindBy(id = "support-dropdown")
    private WebElement supportTopMenu;

    @FindBy(xpath = "//li[@class='with-dropdown']//ul")
    private WebElement supportTopMenuDropdown;

    @FindBy(xpath = "//li[@class='with-dropdown']//li/a")
    private List<WebElement> supportTopMenuDropdownLinks;

    @FindBy(xpath = SUPPORT_DROPDOWN_ID + "//li/a[@href='/faq']")
    private WebElement faqSupportSubmenu;

    @FindBy(xpath = SUPPORT_DROPDOWN_ID + "//li/a[@href='/appid']")
    private WebElement howToStartSupportSubmenu;

    @FindBy(xpath = SUPPORT_DROPDOWN_ID + "//li/a[@href='https://home.openweathermap.org/questions']")
    private WebElement askQuestionSupportSubmenu;

    @FindBy(xpath = "//nav/ul/li[@id='hamburger']/img")
    private WebElement hamburgerTopMenuIcon;

    @FindBy(xpath = "//ul[@id='mobile-menu']/li/a")
    private List<WebElement> hamburgerTopMenuDropdownLinks;

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

    public List<String> getLinksText() {

        return getTexts(supportTopMenuDropdownLinks);
    }

    public MainPage setWindowWithHamburgerMenu(int width, int height) {
        setWindowDimensions(width, height);

        return new MainPage(getDriver());
    }

    public List<String> getHamburgerMenuList() {

        return getTexts(hamburgerTopMenuDropdownLinks);
    }

    public int getNumberOfOptionsHamburgerMenu() {

        return getListSize(hamburgerTopMenuDropdownLinks);
    }

    public String getSupportMenuIsActiveValue() {

        return getAttribute(supportTopMenuDropdown, "class");
    }

    public List<WebElement> getTopMenuLinks() {

        return topMenuLinks;
    }

    public Generic clickTopMenu(int index) {
        List<WebElement> menus = new ArrayList<>();
        menus.add(logo);
        menus.addAll(topMenuLinks);

        if (menus.get(index).isDisplayed()) {
            click(menus.get(index));
        } else {
            clickSupportMenu().click(menus.get(index));
        }
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }

        return createGeneric();
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

    public GuidePage clickGuideMenu() {
        click(guideTopMenu);

        return new GuidePage(getDriver());
    }

    public APIPage clickAPIMenu() {
        click(apiTopMenu);

        return new APIPage(getDriver());
    }

    public HomeMarketplacePage clickMarketplaceMenu() {
        click(marketplaceTopMenu);

        return new HomeMarketplacePage(getDriver());
    }

    public PricePage clickPricingMenu() {
        click(pricingTopMenu);

        return new PricePage(getDriver());
    }

    public WeatherMapsPage clickMapsMenu() {
        click(mapsTopMenu);

        return new WeatherMapsPage(getDriver());
    }

    public OurInitiativesPage clickOurInitiativesMenu() {
        click(ourInitiativesTopMenu);

        return new OurInitiativesPage(getDriver());
    }

    public PartnersPage clickPartnersMenu() {
        click(partnersTopMenu);

        return new PartnersPage(getDriver());
    }

    public MainPage clickSupportMenu() {
        click(supportTopMenu);

        return new MainPage(getDriver());
    }

    public FAQPage clickFAQSupportSubmenu() {
        click(faqSupportSubmenu);

        return new FAQPage(getDriver());
    }

    public HowToStartPage clickHowToStartSupportSubmenu() {
        click(howToStartSupportSubmenu);
        setOriginalHandle();

        return new HowToStartPage(getDriver());
    }

    public WeatherDashboardPage clickDashboardMenu() {
        click(dashboardTopMenu);

        return new WeatherDashboardPage(getDriver());
    }

    public MainPage clickSearchFieldTopMenu() {
        click(searchFieldTopMenu);

        return new MainPage(getDriver());
    }

    public void clickHamburgerMenuIcon() {
        click(hamburgerTopMenuIcon);

        new MainPage(getDriver());
    }

    public HomeAskQuestionPage clickAskQuestionSupportSubmenu() {
        click(askQuestionSupportSubmenu);
        switchToAnotherWindow();

        return new HomeAskQuestionPage(getDriver());
    }

    public HomeUsersSignInPage clickSignInMenu() {
        click20(signInTopMenu);

        return new HomeUsersSignInPage(getDriver());
    }

    public HomePage signIn() {
        clickSignInMenu().signInAsRegularUser();

        return new HomePage(getDriver());
    }

    public HomeUsersSignInPage signOut() {
        click(getDriver().findElement(By.id("user-dropdown")));
        click(getDriver().findElement(By.xpath("//a[@href='/users/sign_out']")));

        return new HomeUsersSignInPage(getDriver());
    }

    public FindPage inputSearchCriteriaIntoSearchField(String text) {
        if (!getText(searchFieldTopMenu).isEmpty() && !getText(searchFieldTopMenu).isBlank()) {
            clear(searchFieldTopMenu);
        }
        input(text, searchFieldTopMenu);

        return new FindPage(getDriver());
    }

    public FindPage clickEnter() {
        clickEnter(searchFieldTopMenu);

        return new FindPage(getDriver());
    }

    public boolean isPlaceholderDisplayed() {

        return isElementDisplayed(searchBoxTopMenu);
    }

    public boolean isSupportDropdownContainerDisplayed() {

        return isElementDisplayed(supportTopMenuDropdown);
    }

    public boolean isHamburgerIconDisplayed() {

        return isElementDisplayed(hamburgerTopMenuIcon);
    }

    public boolean isLogoIconDisplayed() {

        return isElementDisplayed(logo);
    }

    public String getEnteredValue() {

        return getAttribute(searchFieldTopMenu, "value");
    }

    public FindPage inputSearchCriteriaAndEnter(String text) {
        inputSearchCriteriaIntoSearchField(text);
        clickEnter();

        return new FindPage(getDriver());
    }
}
