package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;
import pages.accounts.LoginPage;
import pages.accounts.RegisterPage;
import pages.accounts.UsersLoginPage;
import pages.footer_menu.MakeDefaultSearchPage;
import pages.footer_menu.SetAsStartPage;
import pages.top_menu.*;


import pages.top_menu.EmailPage;
import pages.top_menu.VpnInstructionsPage;
import pages.top_menu.VpnPage;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public abstract class TopMenuPage<Generic> extends BasePage {

    private static final String TOP_MENU_ID = "//div[@class = 'badges animation-badges']";
    private static final String HAMBURGER_DROPDOWN_ID = "//button[@class = 'hamburger-menu']";

    @FindBy(xpath = "//img[@alt = 'Swisscows']")
    private WebElement logo;
    @FindBy(xpath = TOP_MENU_ID) // 3 links [teleGuard, VPN, Email]
    private WebElement topMenuContainer;

    @FindBy(xpath = TOP_MENU_ID + "//a") // 3 links [teleGuard, VPN, Email]
    private List<WebElement> topMenuLinks;

    @FindBy(xpath = TOP_MENU_ID + "//div[@class='input-search-wrap']")
    private WebElement searchBoxMainPage;

    @FindBy(xpath = "//input[@class ='input-search']")
    private WebElement searchFieldTopMenu;
    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement searchButton;

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

    @FindBy(xpath = TOP_MENU_ID + "//a")
    private List<WebElement> topMenus;

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

    @FindBy(xpath = "//h1")
    private WebElement textsH1;

    @FindBy(xpath = "//div[@class='static-content']//div/a")
    private List<WebElement> allLinksOnPage;
    @FindBy(xpath = "//div[@class='static-content']//a[@class='button outline']")
    private List<WebElement> allLinksOnEmailPage;
    @FindBy(className = "suggestions")
    private WebElement searchDropdownMenu;// swisscows

    @FindBy(xpath = "//div[@class = 'static-content']//a")
    private List<WebElement> allLinks;
    @FindBy(xpath = "//div[@class='content']//a[@href='https://swisscows.email/mbox/index.php/login/oauth']")
    private WebElement StartForFreeLink;
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
    @FindBy(xpath = "//button[@class ='button favorite'][1]")
    private WebElement favoriteIcon;

    @FindBy(xpath = "//ul[@class='suggestions']//li[2]")
    private WebElement choiceInDropdownMenu;
    @FindBy(xpath = "//ul[@class='menu-dropdown-list']//li[2]")
    private WebElement langDeutschInHamburgerMenu;

    @FindBy(xpath = "//div[@class = 'image']//img")
    private List<WebElement> allImagesOnPage;
    @FindBy(xpath = "//input[@class = 'input-search']")
    private WebElement searchFieldHeader; // swisscows

    @FindBy(xpath = "//h2[text() ='My favorite tracks']")
    private WebElement favoriteContainer;

    @FindBy(xpath = "//button[@class='button favorite']")
    private List<WebElement> allHeartButtons;
    @FindBy(xpath = "//div[@class ='filters-button']")
    private WebElement filterButton;

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
    public List<String> getH2FontSizes(){
        return  getFontSizes(textsH2);

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
    public MainPage clickStartForFreeLink() {
        click(StartForFreeLink);
        return new  MainPage(getDriver());
    }

    public VpnInstructionsPage clickInstructionsLink() {
        click(instructionsLink);
        switchToAnotherWindow();
        return new VpnInstructionsPage(getDriver());
    }

    public String getHamburgerMenuIsActiveValue() {

        return getAttribute(hamburgerTopMenu, "class");
    }

    public List<WebElement> getTopMenuLinks() {

        return allLinksOnPage;
    }
    public List<WebElement> getEmailLinks() {

        return allLinksOnEmailPage;
    }
    public List<String> getButtonColorsWhenHover() throws InterruptedException {

        return  hoverToElements(allLinksOnEmailPage);
    }


    public void waitTopMenuToBeInvisible(){
        wait10ElementToBeInVisible(topMenuContainer);

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
    public MusicPage clickOnAllHeart()  {
        clickAllElementsInList(allHeartButtons);
        return new MusicPage(getDriver());
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
    public MainPage clickRegionGerman() {
        click(RegionGerman);

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
    public void clickAllLinksOnEmailPage(int index) {
        click(getEmailLinks().get(index));
        switchToAnotherWindow();
        getWait20().until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public void setOriginalHandle() {

        getDriver().getWindowHandle();
    }

    public MainPage clickLogo() {
        click(logo);

        return new MainPage(getDriver());
    }


    public void clickTeleGuardTopMenu() {
        click(TeleGuardTopMenu);

        new MainPage(getDriver());
    }

    public void clickLanguagesTopMenu() {
        click20(LangDropDownIcon);

        new MainPage(getDriver());
    }

    public EmailPage clickEmailTopMenu() {
        click(EmailTopMenu);

        return  new EmailPage(getDriver());
    }

    public MainPage clickRegionTopMenu() {
        click(RegionDropDownIcon);

        return new MainPage(getDriver());
    }

    public MainPage clickThemeDropDownIcon() {
        click(ThemeDropDownIcon);

       return new MainPage(getDriver());
    }

    public VpnPage clickVPNTopMenu() {
        click(VPNTopMenu);
        return new VpnPage(getDriver());
    }



    public MainPage clickHamburgerMenuIcon() {
        click(hamburgerTopMenu);

        return new MainPage(getDriver());
    }
    public List <String> getH3Texts() {

        return getTexts(textsH3);
    }
    public List <String> getH2Texts() {

        return getTexts(textsH2);
    }
    public List <String> getAnswersTexts() {

        return getTexts(textsAnswers);
    }

    public void clickSetAsStartAppInHamburgerMenu() {
        click(setAsStartAppHamburgerMenu);

        new MainPage(getDriver());
    }





    public WebPage inputSearchCriteriaIntoSearchField(String text) {
        if (!getText(searchFieldTopMenu).isEmpty() && !getText(searchFieldTopMenu).isBlank()) {
            clear(searchFieldTopMenu);
        }
        input(text, searchFieldTopMenu);

        return new WebPage(getDriver());
    }

    public WebPage clickEnter() {
        clickEnter(searchFieldTopMenu);

        return new WebPage(getDriver());
    }
    public WebPage clickSearchButton() {
        clickEnter(searchButton);

        return new WebPage(getDriver());
    }
    public VideoPage clickVideoButton() {
        clickEnter(videoButton);

        return new VideoPage(getDriver());
    }
    public MusicPage clickMusicButton() {
        clickEnter(musicButton);

        return new MusicPage(getDriver());
    }

    public ImagePage clickImageButton() {
        clickEnter(imageButton);

        return new ImagePage(getDriver());
    }
    public VideoPage clickFilterButton() {
        clickByJavaScript(filterButton);

        return new VideoPage(getDriver());
    }
    public void clickChoiceInDropDownList() {
        wait20ElementToBeVisible(searchDropdownMenu);
        click(choiceInDropdownMenu);

    }
    public WebPage clickSearchFieldHeader() {
        click(searchFieldHeader);
        return new WebPage(getDriver());
    }

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

    public boolean allElementsDisplayed() {

        return areElementsInListDisplayed(allImagesOnPage);
    }
    public UsersLoginPage clickSignInMenu() {
        click20(signInTopMenu);

        return new UsersLoginPage(getDriver());
    }

    public MusicPage clickFavoriteIcon() {
        wait10ElementToBeVisible(favoriteIcon);
        click(favoriteIcon);
        return new MusicPage(getDriver());
    }
    public WebPage clickLangDeutsch() {
        wait10ElementToBeVisible(langDeutschInHamburgerMenu);
        click(langDeutschInHamburgerMenu);
        return new WebPage(getDriver());
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
    public RegisterPage switchToRegisterPage() {
        switchToExternalPage();
        return new RegisterPage(getDriver());

    }
    public WebPage inputSearchCriteriaAndEnter(String text) {
        inputSearchCriteriaIntoSearchField(text);
        clickEnter();

        return new WebPage(getDriver());
    }
}
