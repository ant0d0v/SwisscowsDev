package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import java.util.List;

public class HomeAPIKeysPage extends FooterMenuPage<HomeAPIKeysPage> {

    @FindBy(id = "api_key_form_name")
    private WebElement inputAPIKeysName;

    @FindBy(xpath = "//input[@class='button-round dark']")
    private WebElement generateButton;

    @FindBy(xpath = " //div[contains(text(),'API key was created successfully')]")
    private WebElement apiKeysCreatedConfirmationMessage;

    @FindBy(xpath = " //div[contains(text(),'API key was deleted successfully')]")
    private WebElement apiKeysDeletedConfirmationMessage;

    @FindBy(css = ".fa.fa-remove")
    private List<WebElement> xButtons;

    @FindBy(xpath = "//table[@class='material_table api-keys']/tbody/tr")
    private List<WebElement> apiKeys;

    @FindBy(xpath = "//table[@class='material_table api-keys']/tbody/tr/td[2]")
    private List<WebElement> apiKeysNames;

    @FindBy(xpath = "//table[@class='material_table api-keys']/tbody/tr/td[3]")
    private List<WebElement> apiKeysStatuses;

    public HomeAPIKeysPage(WebDriver driver) {
        super(driver);
    }

    public HomeAPIKeysPage createGeneric() {

        return new HomeAPIKeysPage(getDriver());
    }

    public String getLastAPIKeyStatus() {
        List<String> keys = getTexts(apiKeys);
        List<String> keysStatuses = getTexts(apiKeysStatuses);
        String lastKeyName = getLastGeneratedAPIKeyName();
        String lastKeyStatus = "";

        for(int i = 0; i < keys.size(); i ++) {
            if (keys.get(i).contains(lastKeyName)) {
                lastKeyStatus = keysStatuses.get(i);
            }
        }

        return lastKeyStatus;
    }

    public String confirmMessageAppears() {

        return getText(apiKeysCreatedConfirmationMessage);
    }

    public String confirmationMessageDeleted() {

        return getText(apiKeysDeletedConfirmationMessage);
    }

    public String getLastGeneratedAPIKeyName() {
        List<String> keysNames = getTexts(apiKeysNames);
        String newKeyName = "";

        for (String name : keysNames) {
            if (!name.equals("Default") && !name.equals("WidgetsKey")) {
                newKeyName = name;
            }

        }

        return  newKeyName;
    }

    public HomeAPIKeysPage clickAPIKeyNameField() {
        click(inputAPIKeysName);

        return this;
    }

    public void clickGenerateKeysButton() {
        click(generateButton);

    }

    public HomeAPIKeysPage inputNewName(String text) {
        input(text, inputAPIKeysName);

        return this;
    }

    public int getAmountOfExistingAPIKeys() {

        return apiKeys.size();
    }

    public HomeAPIKeysPage deleteLastAPIKey() {
        xButtons.get(xButtons.size() - 1).click();

        return this;
    }

    public void confirmAPIKeyDeletion() {
        getDriver().switchTo().alert().accept();
    }
}
