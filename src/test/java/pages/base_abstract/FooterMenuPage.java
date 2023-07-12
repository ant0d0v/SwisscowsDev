package pages.base_abstract;

import io.qase.api.annotation.Step;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;
import pages.footer_menu.*;
import pages.top_menu.EmailPage;
/*import pages.MainPage;
import pages.WeatherStationsPage;
import pages.footer_menu.WhoWeArePage;
import pages.footer_menu.TechnologyPage;
import pages.footer_menu.WidgetsPage;
import pages.home.HomeAskQuestionPage;
import pages.pages.top_menu.PricePage;
import pages.pages.top_menu.WeatherDashboardPage;*/

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
    @FindBy(xpath = FOOTER_MENU_ID + "//a[text()='Donation']")// Swisscows
    private WebElement donationFooterMenu;

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
    @FindBy(xpath = FOOTER_MENU_ID + "//ul[3]//li")
    private List<WebElement> ourServicesText;

    @FindBy(xpath = FOOTER_MENU_ID + "//a") // Swisscows links
    private List<WebElement> footerMenuLinks;
    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class='app']//a")
    private List<WebElement> storePanelIconsFooterMenu; // Swisscows
    @FindBy(xpath = "(//div[@class = 'footer-full-inner']//ul[1]//li)[position() > 1]")
    private List<WebElement> aboutSwisscowsLinks;

    @FindBy(className = "social-networks")
    private WebElement socialPanelFooterMenu;

    @FindBy(xpath = "//h1")
    private WebElement textH1FooterMenu;
    @FindBy(xpath = "//h1")
    private List<WebElement> textsH1;
    @FindBy(xpath = "//h2")
    private List<WebElement> textsH2;
    @FindBy(xpath = "//div[@class='row narrow static-content']//a")
    private List<WebElement> allLinksOnPage; // Swisscows
    @FindBy(xpath = FOOTER_MENU_ID + "//ul/li/a")
    private List<WebElement> innerFooterMenuLink;
    @FindBy(xpath = "//video")
    private WebElement videoPlayer;
    @FindBy(xpath = "//a[@href='mailto: info@swisscows.com']")
    private WebElement linkToEmail;


    public FooterMenuPage(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();
    @Step("Get numbers social icons in the footer")
    @io.qameta.allure.Step
    public int getSocialPanelSize() {
        return getListSize(socialPanelIconsFooterMenu);
    }
    @Step("Get text of Copyright ")
    @io.qameta.allure.Step
    public String getCopyright() {
        return getText(copyright);
    }
    @Step("Get h1 text on the page")
    @io.qameta.allure.Step
    public String getH1Text() {
        return getText(textH1FooterMenu);
    }
    @Step("Get text of h1 texts ")
    @io.qameta.allure.Step
    public List<String> getH1Texts() {
        return getTexts(textsH1);
    }
    @Step("Get h2 texts on the page")
    @io.qameta.allure.Step
    public List<String> getH2Texts() {
        return getTexts(textsH2);
    }
    @Step("Get color of h1 text on the page")
    @io.qameta.allure.Step
    public List<String> getH1Colors(){
        return  getColors(textsH1);
    }
    @Step("Get font sixes h2 text")
    @io.qameta.allure.Step
    public List<String> getH2FontSizes(){
        return  getFontSizes(textsH2);

    }
    public String getColorEmail (){
        return getBackgroundColor(linkToEmail);
    }
    public List <String> getColorLinks (){

        return getColors(allLinksOnPage);
    }
    public List<WebElement> getAboutSwisscowsLinks() {
        return aboutSwisscowsLinks;
    }

    public WebElement getAboutSwisscowsFooterMenu() {

        return aboutSwisscows;
    }

    public WebElement getAboutSwisscowsAGFooterMenu() {

        return aboutSwisscowsAG;
    }

    @Step("Get the texts of the menus in the About Swisscows section.")
    @io.qameta.allure.Step
    public List<String> getAboutSwisscowsMenusTexts() {
        return getTexts(aboutSwisscowsList);
    }
    @Step("Click the about services block link based on the provided index.")
    @io.qameta.allure.Step
    public void clickAboutSwisscowsBlockLinks(int index) {
        click(getAboutSwisscowsLinks().get(index));
        switchToAnotherWindow();
    }
    @Step("Get texts of about swisscowsAg menu")
    @io.qameta.allure.Step
    public List<String> getAboutSwisscowsAGMenusTexts() {
        return getTexts(aboutSwisscowsAGList);
    }
    @Step("Get texts of our services section")
    @io.qameta.allure.Step
    public List<String> getOurServicesTexts() {
        return getTexts(ourServicesText);
    }
    @Step("Get the texts of the menus in the our products section.")
    @io.qameta.allure.Step
    public List<String> getOurProductsMenusTexts() {
        return getTexts(OurProductsList);
    }

    protected WebElement getFooterMenu() {

        return footerMenu;
    }
    @Step("Get numbers links int he footer")
    @io.qameta.allure.Step
    public int getFooterMenuLinksCount() {
        areAllElementsVisibleAndClickable(footerMenuLinks);
        return getListSize(footerMenuLinks);
    }
    @Step("Get numbers store icons in the footer")
    @io.qameta.allure.Step
    public int getStoresIconsCount() {
        return getListSize(storePanelIconsFooterMenu);
    }
    @Step("Get the list of colors of the footer menu links")
    @io.qameta.allure.Step
    public List<String> getLinkColorsFooterMenu() throws InterruptedException {
        return  getColorsOfElements(footerMenuLinks);
    }
    @Step("Get the list of colors of the footer menu links when hovered")
    @io.qameta.allure.Step
    public List<String> getLinksColorsWhenHoverFooterMenu() throws InterruptedException {

        return  getHoverColorsOfElements(footerMenuLinks);
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

    @Step("Click mediz education link in the footer")
    @io.qameta.allure.Step
    public MediaEducationPage clickMediaEducationFooterMenu() {
        click(MediaEducationFooterMenu);
        return new MediaEducationPage(getDriver());
    }

    @Step("Click charity project link in the footer")
    @io.qameta.allure.Step
    public CharityProjectPage clickCharityProjectFooterMenu() {
        click(CharityProjectFooterMenu);
        return new CharityProjectPage(getDriver());
    }
    @Step("Click our data center link in the footer")
    @io.qameta.allure.Step
    public OurDatacenterPage clickOurDatacenterPageFooterMenu() {
        click(OurDatacenterFooterMenu);
        return new OurDatacenterPage(getDriver());
    }
    @Step("Click donation link in the footer")
    @io.qameta.allure.Step
    public DonationPage clickDonationPageFooterMenu() {
        click(donationFooterMenu);
        return new DonationPage(getDriver());
    }
    @Step("Click about us link in the footer")
    @io.qameta.allure.Step
    public WhoWeArePage clickAboutUsFooterMenu() {
        click20(whoWeAreFooterMenu);
        return new WhoWeArePage(getDriver());
    }
    @Step("Click instagram icon in the footer")
    @io.qameta.allure.Step
    public MainPage clickInstagramIcon() {
        click20(instagramIconFooterMenu);
        return new MainPage(getDriver());
    }
    @Step("Click linkedin icon in the footer")
    @io.qameta.allure.Step
    public MainPage clickLinkedinIcon() {
        click20(linkedinIconFooterMenu);
        return new MainPage(getDriver());
    }
    @Step("Click swisscows email link ")
    @io.qameta.allure.Step
    public EmailPage clickSwisscowsEmail() {
        click20(SwisscowsEmailFooterMenu);
        return new EmailPage(getDriver());
    }
    @Step("Click contact us link in the footer")
    @io.qameta.allure.Step
    public ContactUsPage clickContactUsPageFooterMenu() {
        click(ContactusFooterMenu);
        return new ContactUsPage(getDriver());
    }
    @Step("Click set as start link in the footer")
    @io.qameta.allure.Step
    public SetAsStartPage clickSetAsStartPageFooterMenu() {
        click(setAsStartpageFooterMenu);

        return new SetAsStartPage(getDriver());
    }
    @Step("Click make default search link in the footer")
    @io.qameta.allure.Step
    public MakeDefaultSearchPage clickMakeDefaultSearchPageFooterMenu() {
        click(makeDefaultSearchEngineFooterMenu);

        return new MakeDefaultSearchPage(getDriver());
    }
    @Step("Click privacy policy link in the footer")
    @io.qameta.allure.Step
    public PrivacyPolicyPage clickPrivacyPolicyPageFooterMenu() {
        click(dataPrivacyFooterMenu);

        return new PrivacyPolicyPage(getDriver());
    }
    @Step("Click imprint link in the footer")
    @io.qameta.allure.Step
    public ImprintPage clickImprintPageFooterMenu() {
        click(imprintFooterMenu);

        return new ImprintPage(getDriver());
    }
    @Step("Click app store icon in the footer")
    @io.qameta.allure.Step
    public MainPage clickAppStoreIcon() {
        click20(downloadOnTheAppStoreLinkFooterMenu);
        return new MainPage(getDriver());
    }

    @Step("Click google play icon in the footer")
    @io.qameta.allure.Step
    public MainPage clickGooglePlayIcon() {
        click20(downloadGooglePlayLinkFooterMenu);
        return new MainPage(getDriver());
    }
    @Step("Click facebook icon in the footer")
    @io.qameta.allure.Step
    public MainPage clickFacebookIcon() {
        click20(facebookIconFooterMenu);
        return new MainPage(getDriver());
    }
    @Step("Click twitter icon in the footer")
    @io.qameta.allure.Step
    public MainPage clickTwitterIcon() {
        click20(twitterIconFooterMenu);
        return new MainPage(getDriver());
    }
    @Step("Click teleguard icon in the footer")
    @io.qameta.allure.Step
    public MainPage clickTeleGuardIcon() {
        click20(teleGuardIconFooterMenu);
        return new MainPage(getDriver());
    }

    @Step("Check that store panel is displayed")
    @io.qameta.allure.Step
    public boolean isStorePanelDisplayed() {
        return areElementsInListDisplayed(storePanelIconsFooterMenu);
    }
    @Step("Check that social panel is displayed")
    @io.qameta.allure.Step
    public boolean isSocialPanelDisplayed() {
        return isElementDisplayed(socialPanelFooterMenu);
    }
    public String getCurrentSrcOfVideo() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        return (String) executor.executeScript("return arguments[0].currentSrc;", videoPlayer);
    }
    public CharityProjectPage waitUntilTimeOfVideoToBeChanged(long timeMillis) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        String currentDuration = executor.executeScript("return arguments[0].duration", videoPlayer).toString();
        long startTime = System.currentTimeMillis();
        long maxWaitTime = timeMillis;
        while (!currentDuration.equals(String.valueOf(timeMillis)) && System.currentTimeMillis() - startTime < maxWaitTime) {
            currentDuration = executor.executeScript("return arguments[0].duration", videoPlayer).toString();
        }
        return new CharityProjectPage(getDriver());
    }
    public CharityProjectPage pauseVideoCharity()  {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("return arguments[0].pause()", videoPlayer);
        return new CharityProjectPage(getDriver());
    }
    public CharityProjectPage playVideoCharity() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("return arguments[0].play()", videoPlayer);
        return new CharityProjectPage(getDriver());
    }

    public String getPdfText(String pdfUrl) throws IOException {
        URL url = new URL(pdfUrl);
        InputStream is = url.openStream();
        BufferedInputStream bis= new BufferedInputStream(is);
        PDDocument doc = PDDocument.load(bis);
        return  new PDFTextStripper().getText(doc);
    }
}
