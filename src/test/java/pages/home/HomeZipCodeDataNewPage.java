package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeZipCodeDataNewPage extends HomeMarketplacePage {

    @FindBy(xpath = "//label[text()='Select state']//following-sibling::ul/li//span[1]")
    private List<WebElement> stateList;

    @FindBy(xpath = "//label[text()='Select year']//following-sibling::ul/li//span[1]")
    private List<WebElement> yearList;

    @FindBy(xpath = "//label[text()='Select state']//following-sibling::div//*[local-name() = 'svg']")
    private WebElement dropdownSelectStateButton;

    @FindBy(xpath = "//label[text()='Select year']//following-sibling::div//*[local-name() = 'svg']")
    private WebElement dropdownSelectYearButton;

    @FindBy(xpath = "//div[@class='footer-content']//h4")
    private WebElement totalPrice;

    @FindBy(xpath = "//div[@class='page']//ul[@class='dropdown-menu']/li")
    private List<WebElement> statesPricesZipcodes;

    @FindBy(xpath = "//div[@class='page']//div[@class='section']/ul/li")
    private List<WebElement> weatherParameters;

    @FindBy(xpath = "//div[@class='footer-content']//button")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//div[@class='pop-up-container big']")
    private WebElement placeOrderContainer;

    @FindBy(xpath = "//div[@class='mb-4 container']/h4")
    private WebElement placeOrderPopUpHeader;

    @FindBy(xpath = "//div[@class='page']//div[@class='col-sm-8']")
    private List<WebElement> orderParameters;

    @FindBy(xpath = "//button[@class='button-round dark']")
    private WebElement nextButton;

    @FindBy(xpath = "//div[@class='pop-up-content']//h4")
    private WebElement billingHeader;

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(xpath = "//div[@class='form-group']/label[text()='Email *']/following::input")
    private WebElement emailField;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//div[@class='menu-item']/span[2]")
    private List<WebElement> zipCodesPricesList;

    @FindBy(xpath = "//span[(text()='Virginia')]")
    private WebElement stateVirginia;

    @FindBy(xpath = "//div[@class='pop-up-container big']//ul/li[text()='Order details']")
    private WebElement orderPopUpWindowOne;

    @FindBy(xpath = "//div[@class='pop-up-container big']//ul/li[text()='Billing details']")
    private WebElement orderPopUpWindowTwo;

    @FindBy(xpath = "//div[@class='pop-up-container big']//ul/li[text()='Billing address']")
    private WebElement orderPopUpWindowThree;

    @FindBy(xpath = "//select[@class='custom-select']")
    private WebElement titleField;

    @FindBy(xpath = "//select[@class='custom-select']/option")
    private List<WebElement> titleOptions;

    @FindBy(xpath = "//input[@class='form-control']")
    private List<WebElement> billingDetailsInputFields;

    @FindBy(xpath = "//small[@class='form-text text-muted']")
    private WebElement errorMessage;

    @FindBy(xpath = "//label[@class='custom-control-label' and text()='Organisation']")
    private WebElement organisationInput;

    @FindBy(id = "organisation")
    private WebElement organizationNameField;

    @FindBy(id = "vat_id")
    private WebElement vatIdField;

    public HomeZipCodeDataNewPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getStatesNames() {

        return getTexts(stateList);
    }

    public List<String> getYearsNames() {

        return getTexts(yearList);
    }

    public String getVirginiaTotalPrice() {

        return getText(totalPrice).substring(6);
    }

    public List<String> getWeatherParameters() {

        return getTexts(weatherParameters);
    }

    public String getPlaceOrderPopUpHeader() {

        return getText(placeOrderPopUpHeader);
    }

    public List<String> getOrderParametersTexts() {

        return getTexts(orderParameters);
    }

    public String getBillingDetailsHeader() {

        return getText(billingHeader);
    }

    public String getBillingAddressHeader() {

        return getText(billingHeader);
    }

    public String getAttributeTopPopUpWindowOne() {

        return getAttribute(orderPopUpWindowOne, "class");
    }

    public String getAttributeTopPopUpWindowTwo() {

        return getAttribute(orderPopUpWindowTwo, "class");
    }

    public String getAttributeTopPopUpWindowThree() {

        return getAttribute(orderPopUpWindowThree, "class");
    }

    public String getErrorMessageText() {

        return getText(errorMessage);
    }

    public String getFirstNameFieldText() {

        return getText(firstNameField);
    }

    public String getLastNameFieldText() {

        return getText(lastNameField);
    }

    public String getPhoneNumberFieldText() {

        return getText(phoneField);
    }

    public String getEmailFieldText() {

        return getText(emailField);
    }

    public HomeZipCodeDataNewPage clickDropdownSelectStateButton() {
        click20(dropdownSelectStateButton);

        return this;
    }

    public HomeZipCodeDataNewPage clickDropdownSelectYearButton() {
        click20(dropdownSelectYearButton);

        return this;
    }

    public HomeZipCodeDataNewPage clickPlaceOrder() {
        click20(placeOrderButton);

        return this;
    }


    public HomeZipCodeDataNewPage clickNextButton() {
        click20(nextButton);
        getWait10();

        return this;
    }

    public HomeZipCodeDataNewPage inputFirstName(String firstName) {
        inputAfterClear(firstNameField, firstName);

        return this;
    }

    public HomeZipCodeDataNewPage inputLastName(String lastName) {
        inputAfterClear(lastNameField, lastName);

        return this;
    }

    public HomeZipCodeDataNewPage inputPhone(String number) {
        inputAfterClear(phoneField, number);

        return this;
    }

    public HomeZipCodeDataNewPage inputEmail(String email) {
        inputAfterClear(emailField, email);

        return this;
    }

    public HomeZipCodeDataNewPage clickState(String state) {
        WebElement stateName = getDriver().findElement(By.xpath(String.format("//span[(text()='%s')]", state)));
        click20(stateName);

        return this;
    }

    public HomeZipCodeDataNewPage clickYear(String year) {
        WebElement yearNumber = getDriver().findElement(By.xpath(String.format("//span[(text()='%s')]", year)));
        click20(yearNumber);

        return this;
    }

    public boolean isOrderPopUpDisplayed() {

        return isElementDisplayed(placeOrderContainer);
    }

    public boolean isNextButtonSubmitting() {

        nextButton.click();

        return getText(billingHeader).contains("Billing address");
    }

    public HomeZipCodeDataNewPage waitUntilPlaceOrderPopUpIsVisible() {
        wait10ElementToBeVisible(placeOrderContainer);

        return this;
    }
}