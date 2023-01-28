package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;
import pages.WeatherStationsPage;
import pages.footer_menu.AboutUsPage;
import pages.footer_menu.TechnologyPage;
import pages.footer_menu.WidgetsPage;
import pages.home.HomeAskQuestionPage;
import pages.top_menu.PricePage;
import pages.top_menu.WeatherDashboardPage;

import java.util.List;

public abstract class FooterMenuPage<Generic> extends TopMenuPage {

    private static final String FOOTER_MENU_ID = "//div[@id='footer-website']";

    @FindBy(xpath = FOOTER_MENU_ID)
    private WebElement footerMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='/weather-dashboard']")
    private WebElement weatherDashboardFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='/technology']")
    private WebElement ourTechnologyFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://openweather.co.uk/privacy-policy']")
    private WebElement privacyPolicyFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='/about-us']")
    private WebElement aboutUsFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='/widgets-constructor']")
    private WebElement widgetsFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://apps.apple.com/gb/app/openweather/id1535923697'] "
            + "[@target='_blank']")
    private WebElement downloadOnTheAppStoreLinkFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class='social']/a")
    private List<WebElement> socialPanelIconsFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://github.com/search?q=openweathermap&ref=cmdform']")
    private WebElement githubIconFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='/stations']")
    private WebElement connectYourWeatherStationFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//p[text()='Download OpenWeather app']")
    private WebElement downloadOpenWeatherAppText;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://home.openweathermap.org/questions']")
    private WebElement askQuestionFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='/price']")
    private WebElement pricingFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@style='display: flex; flex-direction: row;']/a")
    private List<WebElement> storeIcons;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://play.google.com/store/apps/details?id=uk.co.openweather']")
    private WebElement iconGooglePlay;

    @FindBy(xpath = FOOTER_MENU_ID + "//span[contains(text(), '©')]")
    private WebElement copyright;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://www.facebook.com/groups/270748973021342']")
    private WebElement iconFacebook;

    @FindBy(xpath = FOOTER_MENU_ID + "//p[text()='Subscription']")
    private WebElement subscription;

    @FindBy(xpath = FOOTER_MENU_ID + "//p[text()='Subscription']/parent::div/div/ul/li")
    private List<WebElement> subscriptionList;

    @FindBy(xpath = FOOTER_MENU_ID + "//a")
    private List<WebElement> footerMenuLinks;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://openweather.co.uk/']")
    private WebElement openWeatherForBusinessFooterMenuLink;

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class='my-5']//a")
    private List<WebElement> storePanelIconsFooterMenu;

    @FindBy(className = "social")
    private WebElement socialPanelFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//ul/li/a")
    private List<WebElement> innerFooterMenuLink;

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

    public WebElement getSubscriptionFooterMenu() {

        return subscription;
    }

    public List<String> getSubscriptionMenusTexts() {

        return getTexts(subscriptionList);
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

    public WeatherDashboardPage clickWeatherDashboardFooterMenu() {
        click(weatherDashboardFooterMenu);

        return new WeatherDashboardPage(getDriver());
    }

    public TechnologyPage clickOurTechnologyFooterMenu() {
        click(ourTechnologyFooterMenu);

        return new TechnologyPage(getDriver());
    }

    public void clickPrivacyPolicyFooterMenu() {
        click(privacyPolicyFooterMenu);
    }

    public PricePage clickPricingFooterMenu() {
        click20(pricingFooterMenu);

        return new PricePage(getDriver());
    }

    public AboutUsPage clickAboutUsFooterMenu() {
        click20(aboutUsFooterMenu);

        return new AboutUsPage(getDriver());
    }

    public WidgetsPage clickWidgetsPageFooterMenu() {
        click(widgetsFooterMenu);

        return new WidgetsPage(getDriver());
    }

    public WeatherStationsPage clickConnectYourWeatherStationFooterMenu() {
        click(connectYourWeatherStationFooterMenu);

        return new WeatherStationsPage(getDriver());
    }

    public void clickGitHubIcon() {
        click20(githubIconFooterMenu);
    }

    public void clickAppStoreIcon() {
        click20(downloadOnTheAppStoreLinkFooterMenu);
    }

    public void clickGooglePlayIcon() {
        click20(iconGooglePlay);
    }

    public void clickFacebookIcon() {
        click20(iconFacebook);
    }

    public void clickOpenWeatherForBusinessFooterMenuLink() {
        click(openWeatherForBusinessFooterMenuLink);
    }

    public MainPage clickAskQuestionFooterMenu() {
        wait10ElementToBeClickable(askQuestionFooterMenu);
        click20(askQuestionFooterMenu);

        return new MainPage(getDriver());
    }

    public HomeAskQuestionPage switchToHomeAskQuestionPage() {
        switchToAnotherWindow();

        return new HomeAskQuestionPage(getDriver());
    }

    public boolean isStorePanelDisplayed() {

        return areElementsInListDisplayed(storePanelIconsFooterMenu);
    }

    public boolean isSocialPanelDisplayed() {

        return isElementDisplayed(socialPanelFooterMenu);
    }
}
