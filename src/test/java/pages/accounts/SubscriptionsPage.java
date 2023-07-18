package pages.accounts;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;

import static java.lang.Thread.sleep;

public class SubscriptionsPage extends TopMenuPage<SubscriptionsPage> {



    @FindBy(xpath = "//ul[@class ='menu-list']//li[3]//a")
    private WebElement subscriptionIcon;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement seeAllLink;

    @FindBy(xpath = "//article[1]//button")
    private WebElement buyNowButtonOfEmailStandardSubscription;
    @FindBy(xpath = "//article[4]//button")
    private WebElement buyNowButtonOfPlatinumSubscription;

    @FindBy(xpath = "//div[@class ='content-box']//button[@class='btn-submit']")
    private WebElement confirmButtonInPopup;

    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfPlatinumProduct;

    @FindBy(xpath = "//div[@class ='items']//div[1]//button")
    private WebElement buyNowButtonOfMonthlyPlan;

    @FindBy(xpath = "//div[@class= 'methods']//div[1]")
    private WebElement methodCard;

    @FindBy(xpath = "//button")
    private WebElement buttonProceed;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement userName;
    @FindBy(xpath = "//article[1]")
    private WebElement attributeEmailStandardSubscription;
    @FindBy(xpath = "//article[4]")
    private WebElement attributePlatinumSubscription;

    @FindBy(xpath = "//div[3]//iframe")
    private WebElement cardNumberFrame;
    @FindBy(xpath = "//input[@placeholder='Card Number']")
    private WebElement cardNumber;
    @FindBy(xpath = "(//div[4]//iframe)[position() =1]")
    private WebElement cardDateFrame;
    @FindBy(xpath = "//input[@placeholder='__/__']")
    private WebElement cardDate;
    @FindBy(xpath = "(//div[4]//iframe)[position() =2]")
    private WebElement cardSvvCodeFrame;
    @FindBy(xpath = "//input[@placeholder='___']")
    private WebElement cardSvvCode;
    @FindBy(xpath = "//button[@class]")
    private WebElement proceedButton;
    @FindBy(xpath = "//div[@class = 'product checkout success']//h1")
    private WebElement successfulMessage;
    @FindBy(xpath = "//img[@src ='./images/payment-illustration-success.svg']")
    private WebElement successfulImage;

    public SubscriptionsPage(WebDriver driver) {

        super(driver);
    }

    public SubscriptionsPage createGeneric() {

        return new SubscriptionsPage(getDriver());
    }
    @Step("Click on the subscription icon.")
    public SubscriptionsPage clickSubscriptionIcon() {
        click(subscriptionIcon);
        return new SubscriptionsPage (getDriver());
    }
    @Step("Click on the \"See All\" link.")
    public SubscriptionsPage clickSeeAllLink() {
        wait10ElementToBeVisible(seeAllLink);
        click(seeAllLink);
        return new SubscriptionsPage (getDriver());
    }
    @Step("Get the text of the successful message.")
    public SubscriptionsPage waitSuccessImage() {
        wait20ElementToBeVisible(successfulImage);
        wait10ElementToBeVisible(successfulMessage);
        return new SubscriptionsPage (getDriver());
    }
    @Step("Click on the \"Buy Now\" button of the Email Standard subscription.")
    public SubscriptionsPage clickBuyNowButtonOfEmailStandardSubscription() {
        clickByJavaScript(buyNowButtonOfEmailStandardSubscription);
        return new SubscriptionsPage (getDriver());
    }
    @Step("Click on the \"Buy Now\" button of the Platinum subscription.")
    public SubscriptionsPage clickBuyNowButtonOfPlatinumSubscription() {
        clickByJavaScript(buyNowButtonOfPlatinumSubscription);
        return new SubscriptionsPage (getDriver());
    }
    @Step("Click on the \"Confirm\" button in the popup")
    public SubscriptionsPage clickConfirmButtonInPopup() {
        click(confirmButtonInPopup);
        return new SubscriptionsPage (getDriver());
    }
    @Step("Click on the \"Buy Now\" button of the product.")
    public SubscriptionsPage clickBuyNowButtonOfProduct() {
        click(buyNowButtonOfPlatinumProduct);
        return new SubscriptionsPage (getDriver());
    }
    @Step("Click on the \"Buy Now\" button of the monthly plan.")
    public SubscriptionsPage clickBuyNowButtonOfMonthlyPlan() {
        click(buyNowButtonOfMonthlyPlan);
        return new SubscriptionsPage (getDriver());
    }
    @Step("Click on the card payment method.")
    public SubscriptionsPage clickMethodCard() {
        click(methodCard);
        click(buttonProceed);
        return new SubscriptionsPage (getDriver());
    }
    public void clickClearInputRegularCardName() {
        click(userName);
        userName.clear();
        String name = "TEST";
        input(name, userName);

    }
    public void clickClearInputRegularCardNumber() throws InterruptedException {
        getDriver().switchTo().frame(cardNumberFrame);
        click(cardNumber);
        String name = "4111111111111111";
        input(name,cardNumber);



    }
    public void clickClearInputRegularCardDate() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(cardDateFrame);
        clickByJavaScript(cardDate);
        String email = "1143";
        input(email,cardDate);
    }
    public void clickClearInputRegularCardCvvCode() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(cardSvvCodeFrame);
        click(cardSvvCode);
        cardSvvCode.clear();
        String email = "434";
        input(email, cardSvvCode);
        getDriver().switchTo().defaultContent();
    }
    public void clickProceedButton() {
        click(proceedButton);
    }

    @Step("Proceed with the card payment.\n")
    public SubscriptionsPage payByCard() throws InterruptedException {
        clickClearInputRegularCardName();
        clickClearInputRegularCardNumber();
        clickClearInputRegularCardDate();
        clickClearInputRegularCardCvvCode();
        clickProceedButton();

        return new SubscriptionsPage(getDriver());
    }
    @Step("Get the text of the successful message.")
    public String getTextSuccessfulMessage() {
        return getText(successfulMessage);
    }
    @Step("Get the attribute of the Email Standard subscription.")
    public String getAttributeEmailStandardSubscription() {
        wait10ElementToBeVisible(attributeEmailStandardSubscription);
        return getAttribute(attributeEmailStandardSubscription,"class");
    }
    @Step("Get the attribute of the Platinum subscription.")
    public String getAttributePlatinumSubscription() {
        wait10ElementToBeVisible(attributePlatinumSubscription);
        return getAttribute(attributePlatinumSubscription,"class");
    }
}
