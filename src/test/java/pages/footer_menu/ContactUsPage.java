package pages.footer_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import pages.base_abstract.FooterMenuPage;

import java.util.List;

public class ContactUsPage extends FooterMenuPage<ContactUsPage> {
    @FindBy(xpath = "//div[@class = 'thanks-message']/h2")
    private WebElement thanksMessage;
    @FindBy(xpath = "//input[@name = 'name']")
    private WebElement userName;
    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement userEmail;
    @FindBy(xpath = "//textarea[@name = 'message']")
    private WebElement userMessage;
    @FindBy(xpath = "//button[@class= 'button']")
    private WebElement sendButton;
    @FindBy(xpath = "//input[@type= 'checkbox']")
    private WebElement checkboxContactUs;

    @FindBy(xpath = "//a[@class= 'button']")
    private WebElement backToSearchButton;
    @FindBy(xpath = "//a[text() = 'privacy policy']")
    private WebElement privacyPolicyLink;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage createGeneric() {

        return new ContactUsPage(getDriver());
    }
    @Step("Get the actual success message from the page.")
    public String getThanksMessage() {
        return getText(thanksMessage);
    }
    @Step("Wait for the \"Thanks\" message to be visible.")
    public ContactUsPage waitToBeVisibleThanksMessage(){
        wait10ElementToBeVisible(thanksMessage);
        return new ContactUsPage(getDriver());
    }
    public void clickClearInputRegularUserName() {
        click(userName);
        userName.clear();
        String name = "TEST";
        input(name, userName);

    }
    public void clickClearInputRegularUserEmail() {
        click(userEmail);
        userEmail.clear();
        String email = "jka59433@xcoxc.com";
        input(email, userEmail);

    }
    public void clickClearInputRegularUserMessage() {
        click(userMessage);
        userMessage.clear();
        String email = "Lorem ipsum dolor sit amet consectetur, adipiscing elit mattis molestie natoque,"
                + " at habitasse eget porttitor. Sapien mi lectus posuere pharetra euismod erat lacus tellus,"
                + " eros montes taciti curae parturient finibus. Justo pharetra arcu tortor ridiculus litora potenti magnis neque, ";
        input(email, userMessage);
    }
    public void clickSendButton() {
        click(sendButton);
    }
    public void clickCheckbox() {
        click(checkboxContactUs);
    }
    public PrivacyPolicyPage clickPrivacyPolicyLink() {
        click(privacyPolicyLink);
        switchToAnotherWindow();
        return new PrivacyPolicyPage(getDriver());
    }
    @Step("Click on the \"Back to Search\" button.")
    public MainPage clickBackToSearchButton(){
        click20(backToSearchButton);
        return new MainPage(getDriver());
    }
    @Step("Submit the contact form on the Contact Us page.")
    public ContactUsPage sendFormContactUs() {
        clickClearInputRegularUserName();
        clickClearInputRegularUserEmail();
        clickClearInputRegularUserMessage();
        clickCheckbox();
        clickSendButton();
        return new ContactUsPage(getDriver());
    }
    @Step("Get color privacy link ")
    public String getColorPrivacyLink(){
        return getBackgroundColor(privacyPolicyLink);
    }
    @Step("Hover on the send button ")
    public ContactUsPage hoverElement() throws InterruptedException {
        hover(sendButton);
        return  this;

    }
    @Step("Get color of button")
    public String backgroundColorOfElement() {
        return getBackgroundHoverColor(sendButton);
    }

}
