package pages.base_abstract;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.footer_menu.*;
/*import pages.MainPage;
import pages.WeatherStationsPage;
import pages.footer_menu.WhoWeArePage;
import pages.footer_menu.TechnologyPage;
import pages.footer_menu.WidgetsPage;
import pages.home.HomeAskQuestionPage;
import pages.pages.top_menu.PricePage;
import pages.pages.top_menu.WeatherDashboardPage;*/

import java.util.List;

public abstract class FooterMenuPage<Generic> extends TopMenuPage {

    private static final String FOOTER_MENU_ID = "//div[@class = 'footer-full-inner-wrap']";

    @FindBy(xpath = FOOTER_MENU_ID)
    private WebElement footerMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='/en/media-education']")
    private WebElement MediaEducationFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text()='Charity Project']") // Swisscows
    private WebElement CharityProjectFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='/en/search-engine-no-tracking']")
    private WebElement whoWeAreFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text()='Our Datacenter']")// Swisscows
    private WebElement OurDatacenterFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text()='Contact us']")//Swisscows
    private WebElement ContactusFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'VPN']")//Swisscows
    private WebElement VpnFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Swisscows.email']")//Swisscows
    private WebElement SwisscowsEmailFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'TeleGuard']")//Swisscows
    private WebElement TeleGuardFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'HES']")//Swisscows
    private WebElement HesFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'GetDigest']")//Swisscows
    private WebElement GetDigestFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class = 'footer-menu']//ul[2]//a")//Swisscows
    private List<WebElement> OurProductsList;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Fan-shop']")//Swisscows
    private WebElement fanShopFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Swisscows Blog']")//Swisscows
    private WebElement swisscowsBlogFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Set as Startpage']")//Swisscows
    private WebElement setAsStartpageFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Make a Default Search Engine']")//Swisscows
    private WebElement makeDefaultSearchEngineFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@class = 'company-link']")//Swisscows
    private WebElement AboutSwisscowsAgFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Imprint']")//Swisscows
    private WebElement imprintFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Data privacy']")//Swisscows
    private WebElement dataPrivacyFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Donation']")//Swisscows
    private WebElement donationFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class = 'footer-menu-bottom']/a")//Swisscows
    private List<WebElement> swisscowsFooterLinks;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@class = 'app-link'][2]")
    private WebElement downloadOnTheAppStoreLinkFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href ='https://play.google.com/store/apps/details?id=com.swisscows.search']"
            + "[@target ='_blank']")
    private WebElement downloadGooglePlayLinkFooterMenu; // Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href ='https://apps.apple.com/app/swisscows-privacy-search/id1581108092']"
            + "[@target ='_blank']")
    private WebElement downloadAppStoreLinkFooterMenu; //Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class = 'social-networks']/a")
    private List<WebElement> socialPanelIconsFooterMenu;//Swisscows


    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://www.facebook.com/swisscows/']")
    private WebElement facebookIconFooterMenu; // Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://www.instagram.com/swisscows.official/']")
    private WebElement instagramIconFooterMenu; // Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://www.linkedin.com/company/swisscows/']")
    private WebElement linkedinIconFooterMenu; // Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://twitter.com/swisscows_ch']")
    private WebElement twitterIconFooterMenu; // Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://teleguard.com/']")
    private WebElement teleGuardIconFooterMenu; // Swisscows


    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class = 'app']/a")
    private List<WebElement> storeIconsDownload;// Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//p[contains(text(), '©')]")
    private WebElement copyright;

    @FindBy(xpath = FOOTER_MENU_ID + "//li[text()='About Swisscows']")
    private WebElement aboutSwisscows; // swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class='footer-menu-bottom']")
    private WebElement aboutSwisscowsAG; // swisscows


    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class = 'footer-menu']//ul[1]//a")
    private List<WebElement> aboutSwisscowsList;

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class='footer-menu-bottom']//a")
    private List<WebElement> aboutSwisscowsAGList;

    @FindBy(xpath = FOOTER_MENU_ID + "//a") // Swisscows links
    private List<WebElement> footerMenuLinks;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://openweather.co.uk/']")
    private WebElement openWeatherForBusinessFooterMenuLink;

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class='app']//a")
    private List<WebElement> storePanelIconsFooterMenu; // Swisscows

    @FindBy(className = "social-networks")
    private WebElement socialPanelFooterMenu;

    @FindBy(xpath = "//h1")
    private WebElement textH1FooterMenu;

    @FindBy(xpath = "//div[@class='row narrow static-content']//a")
    private List<WebElement> allLinksOnPage; // Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//ul/li/a")
    private List<WebElement> innerFooterMenuLink;

    @FindBy(xpath = "//ul[@class ='menu-dropdown-list']/li")
    private List<WebElement> innerLangMenuList;

    @FindBy(xpath = "//ul[@class='menu-dropdown-list']//li")
    private List<WebElement> innerRegionMenuList;

    @FindBy(xpath = "//div[@class ='menu-dropdown-button'][1]")
    private WebElement LangDropDownIcon;

    @FindBy(xpath = "//div[@class='menu-dropdown-button'][2]")
    private WebElement RegionDropDownIcon;
    @FindBy(xpath = "//video")
    private WebElement videoPlayer;

    public FooterMenuPage(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();

    public int getSocialPanelSize() {

        return getListSize(socialPanelIconsFooterMenu);
    }

    public String getCopyright() {

        return getText(copyright);
    }

    public String getH1Text() {

        return getText(textH1FooterMenu);
    }

    public WebElement getAboutSwisscowsFooterMenu() {

        return aboutSwisscows;
    }

    public WebElement getAboutSwisscowsAGFooterMenu() {

        return aboutSwisscowsAG;
    }


    public List<String> getAboutSwisscowsMenusTexts() {

        return getTexts(aboutSwisscowsList);
    }

    public List<String> getAboutSwisscowsAGMenusTexts() {

        return getTexts(aboutSwisscowsAGList);
    }

    public List<String> getOurProductsMenusTexts() {

        return getTexts(OurProductsList);
    }

    protected WebElement getFooterMenu() {

        return footerMenu;
    }

    public int getFooterMenuLinksCount() {
        areAllElementsVisibleAndClickable(footerMenuLinks);

        return getListSize(footerMenuLinks);
    }

    public int getStoresIconsCount() {

        return getListSize(storePanelIconsFooterMenu);
    }

    public List<WebElement> getInnerFooterMenuLinks() {

        return innerFooterMenuLink;
    }

    public List<WebElement> getAllLinksOnPage() {

        return allLinksOnPage;
    }

    public void clickAllLinks(int index) {
        click(getAllLinksOnPage().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }

        createGeneric();
    }





    public Generic clickFooterMenu(int index) {
        click(getInnerFooterMenuLinks().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }

        return createGeneric();
    }


    public void clickFooterMenuExternalLink(int index) {
        click(getInnerFooterMenuLinks().get(index));
        switchToAnotherWindow();
        getWait20().until(ExpectedConditions.numberOfWindowsToBe(2));
    }


    public MediaEducationPage clickMediaEducationFooterMenu() {
        click(MediaEducationFooterMenu);

        return new MediaEducationPage(getDriver());
    }


    public CharityProjectPage clickCharityProjectFooterMenu() {
        click(CharityProjectFooterMenu);

        return new CharityProjectPage(getDriver());
    }

    public OurDatacenterPage clickOurDatacenterPageFooterMenu() {
        click(OurDatacenterFooterMenu);

        return new OurDatacenterPage(getDriver());
    }

    public WhoWeArePage clickAboutUsFooterMenu() {
        click20(whoWeAreFooterMenu);

        return new WhoWeArePage(getDriver());
    }

    public void clickInstagramIcon() {
        click20(instagramIconFooterMenu);
    }

    public void clickLinkedinIcon() {
        click20(linkedinIconFooterMenu);
    }

    public void clickSwisscowsEmail() {
        click20(SwisscowsEmailFooterMenu);
    }
    public ContactUsPage clickContactUsPageFooterMenu() {
        click(ContactusFooterMenu);

        return new ContactUsPage(getDriver());
    }

    public void clickAppStoreIcon() {
        click20(downloadOnTheAppStoreLinkFooterMenu);
    }


    public void clickGooglePlayIcon() {
        click20(downloadGooglePlayLinkFooterMenu);
    }

    public void clickFacebookIcon() {
        click20(facebookIconFooterMenu);
    }

    public void clickTwitterIcon() {
        click20(twitterIconFooterMenu);
    }

    public void clickTeleGuardIcon() {
        click20(teleGuardIconFooterMenu);
    }

    public void clickOpenWeatherForBusinessFooterMenuLink() {
        click(openWeatherForBusinessFooterMenuLink);
    }

   /* public MainPage clickAskQuestionFooterMenu() {
        wait10ElementToBeClickable(askQuestionFooterMenu);
        click20(askQuestionFooterMenu);

        return new MainPage(getDriver());
    }

    public HomeAskQuestionPage switchToHomeAskQuestionPage() {
        switchToAnotherWindow();

        return new HomeAskQuestionPage(getDriver());
    }*/

    public boolean isStorePanelDisplayed() {

        return areElementsInListDisplayed(storePanelIconsFooterMenu);
    }

    public boolean isSocialPanelDisplayed() {

        return isElementDisplayed(socialPanelFooterMenu);
    }
    public String getCurrentSrcOfVideo() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        return (String) executor.executeScript("return arguments[0].currentSrc;", videoPlayer);
    }
    public void pauseVideo() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("return arguments[0].pause()", videoPlayer);
    }
    public CharityProjectPage playVideo() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("return arguments[0].play()", videoPlayer);
        Thread.sleep(5000);
        return new CharityProjectPage(getDriver());
    }
    /*public long getDurationOfVideo() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        return (Long) executor.executeScript("return arguments[0].duration", videoPlayer);
    }*/
}
