package pages.footer_menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;
import java.util.List;


public class DonationPage extends FooterMenuPage<DonationPage> {
    @FindBy(xpath = "//div[@class = 'payment-slip-block']")
    private WebElement paymentBlock;
    @FindBy(xpath = "//div[@class = 'payment-slip-block'][1]")
    private WebElement qrCodeChf;
    @FindBy(xpath = "//div[@class = 'payment-slip-block'][2]")
    private WebElement qrCodeEuro;
    @FindBy(xpath = "//h1[2]")
    private WebElement h1Header;
    @FindBy(xpath = "//p[@class = 'introduction']//a")
    private List<WebElement> allLinksOnPage;
    public DonationPage(WebDriver driver) {
        super(driver);
    }

    public DonationPage createGeneric() {

        return new DonationPage(getDriver());
    }
    public DonationPage scrollToWherePaymentBlock() {
        scrollByVisibleElement(paymentBlock);

        return this;
    }
    public DonationPage scrollToWhereH1Header() {
        scrollByVisibleElement(h1Header);

        return this;
    }

    public DonationPage clickQrCodeChf() {
        click(qrCodeChf);
        switchToAnotherWindow();

        return this;
    }
    public DonationPage clickQrCodeEuro()  {
        click(qrCodeEuro);
        switchToAnotherWindow();
        return  this;
    }
    public List<WebElement> getAllLinksOnPage() {

        return allLinksOnPage;
    }
    public void clickAllLinksToDonationPage(int index) {
        click(getAllLinksOnPage().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }
        createGeneric();
    }
    public List <String> getColorLinksDonation (){

        return getColors(allLinksOnPage);
    }

}
