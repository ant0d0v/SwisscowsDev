package pages.footer_menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class DonationPage extends FooterMenuPage<DonationPage> {
    @FindBy(xpath = "//div[@class = 'payment-slip-block']")
    private WebElement paymentBlock;
    @FindBy(xpath = "//div[@class = 'payment-slip-block'][1]")
    private WebElement qrCodeChf;
    @FindBy(xpath = "//div[@class = 'payment-slip-block'][2]")
    private WebElement qrCodeEuro;
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
    public DonationPage clickQrCodeChf() {
        click(qrCodeChf);
        switchToAnotherWindow();
        return this;
    }
    public DonationPage clickQrCodeEuro() {
        click(qrCodeEuro);
        switchToAnotherWindow();
        return this;
    }
}
