package pages.base_abstract;

import base.BaseTest;
import io.qase.api.annotation.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import pages.accounts.LoginPage;
import pages.footer_menu.CharityProjectPage;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;

public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait20;
    private WebDriverWait webDriverWait10;
    private Actions actions;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait10() {
        if (webDriverWait10 == null) {
            webDriverWait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        return webDriverWait10;
    }
    protected WebDriverWait getWait5() {
        if (webDriverWait10 == null) {
            webDriverWait10 = new WebDriverWait(driver, Duration.ofSeconds(5));
        }

        return webDriverWait10;
    }

    protected WebDriverWait getWait20() {
        if (webDriverWait20 == null) {
            webDriverWait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        return webDriverWait20;
    }

    protected Actions getActions() {
        if (actions == null) {
            actions = new Actions(driver);
        }

        return actions;
    }

    @Step("Get the title")
    public String getTitle() {

        return getDriver().getTitle();
    }
    @Step("Get the current URL.")
    public String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }
    @Step("Get the formatted URL.")
    public String getFormattedURL() {
        return getDriver().getCurrentUrl().substring(61, 84);
    }

    protected String getText(WebElement element) {
        if (!element.getText().isEmpty()) {
            wait10ElementToBeVisible(element);
        }

        return element.getText();
    }

    protected List<String> getTexts(List<WebElement> list) {
        if (list.size() > 0) {
            getWait20().until(ExpectedConditions.visibilityOfAllElements(list));
            List<String> textList = new ArrayList<>();
            for (WebElement element : list) {
                if (element.isEnabled() && element.isDisplayed()) {
                    textList.add(element.getText());
                }
            }

            return textList;
        }

        return new ArrayList<>();
    }



    protected List<String> getTrimmedTexts(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();

        for (WebElement element : elements) {
            texts.add(getText(element).trim());
        }

        return texts;
    }

    public String getAttribute(WebElement element, String attribute) {
        if (!element.getText().isEmpty()) {
            wait10ElementToBeVisible(element);
        }

        return element.getAttribute(attribute);
    }


    protected String getBackgroundColor(WebElement element) {
        wait10ElementToBeVisible(element);

        return element.getCssValue("color");
    }
    protected String getBackgroundHoverColor(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover', {bubbles: true, cancelable: true}));", element);
        wait10ElementToBeVisible(element);
        return element.getCssValue("background-color");
    }
    protected List<String> getColors(List<WebElement> list) {
        if (list.size() > 0) {
            getWait20().until(ExpectedConditions.visibilityOfAllElements(list));
            List<String> colorsList = new ArrayList<>();
            for (WebElement element : list) {
                if (element.isEnabled() && element.isDisplayed()) {
                    colorsList.add(element.getCssValue("color"));
                }
            }

            return colorsList;
        }

        return new ArrayList<>();
    }

    protected List<String> getFontSizes(List<WebElement> list) {
        if (list.size() > 0) {
            getWait20().until(ExpectedConditions.visibilityOfAllElements(list));
            List<String> FontSizeList = new ArrayList<>();
            for (WebElement element : list) {
                if (element.isEnabled() && element.isDisplayed()) {
                    FontSizeList.add(element.getCssValue("font-size"));
                }
            }

            return FontSizeList;
        }

        return new ArrayList<>();
    }

    protected String getBackgroundColorInHEX(WebElement element) {

        return Color.fromString(getBackgroundColor(element)).asHex();
    }

    protected String getFontSize(WebElement element) {
        wait10ElementToBeVisible(element);

        return element.getCssValue("font-size");
    }

    public int getListSize(List<WebElement> list) {

        return list.size();
    }

    protected void click(WebElement element) {
        wait10ElementToBeVisible(element);
        wait10ElementToBeClickable(element).click();
    }

    protected void clickElementUntilInvisible(WebElement element) {
        while (element.isEnabled() && element.isDisplayed()){
            clickByJavaScript(element);
        }

    }

    protected void click20(WebElement element) {
        wait20ElementToBeVisible(element);
        wait20ElementToBeClickable(element).click();
    }

    protected void clickByJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected void clickEnter(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(Keys.ENTER);
    }

    protected void clickArrowUp(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(Keys.ARROW_UP);
    }

    protected void clickAllElementsInList(List<WebElement> elements) {
        List<WebElement> allElements = new ArrayList<>(elements);

        for (WebElement element : allElements) {
            if (element.isEnabled() && element.isDisplayed()) {
                wait10ElementToBeVisible(element);
                wait10ElementToBeClickable(element);
                clickByJavaScript(element);
            } else {
                Reporter.log("Element " + element + " is not visible or not clickable ", true);
            }
        }
    }

    protected void clear(WebElement element) {

        element.clear();
    }
    protected void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();

    }
    public List<String> getBackgroundHoverColorsOfElements(List<WebElement> buttons) throws InterruptedException {
        Actions actions = new Actions(getDriver());
        List<String> colorList = new ArrayList<>();

        for (WebElement button :  buttons) {
            actions.moveToElement(button).build().perform();
            if (button.isEnabled() && button.isDisplayed()) {
                colorList.add(button.getCssValue("background-color"));

            }

        }
        return colorList;
    }
    public List<String> getSrcOfElements(List<WebElement> images){
        List<String> colorList = new ArrayList<>();

        for (WebElement image :  images) {
            if (image.isEnabled() && image.isDisplayed()) {
                colorList.add(image.getAttribute("src"));

            }

        }
        return colorList;
    }
    public List<String> getAttributeClassAllElements(List<WebElement> elements){
        List<String> elementList = new ArrayList<>();

        for (WebElement element :  elements) {
            elementList.add(element.getAttribute("class"));
            }

        return elementList;
    }
    public List<String> getHoverColorsOfElements(List<WebElement> buttons) throws InterruptedException {
        Actions actions = new Actions(getDriver());
        List<String> colorList = new ArrayList<>();

        for (WebElement button :  buttons) {
            actions.moveToElement(button).build().perform();
            if (button.isEnabled() && button.isDisplayed()) {
                colorList.add(button.getCssValue("color"));

            }

        }
        return colorList;
    }
    public List<String> getBackgroundColorsOfElements(List<WebElement> buttons) throws InterruptedException {

        List<String> colorList = new ArrayList<>();

        for (WebElement button :  buttons) {
            if (button.isEnabled() && button.isDisplayed()) {
                colorList.add(button.getCssValue("background-color"));

            }

        }
        return colorList;
    }
    public List<String> getColorsOfElements(List<WebElement> buttons) throws InterruptedException {

        List<String> colorList = new ArrayList<>();

        for (WebElement button :  buttons) {
            if (button.isEnabled() && button.isDisplayed()) {
                colorList.add(button.getCssValue("color"));

            }

        }
        return colorList;
    }


    protected void input(String text, WebElement element) {
        element.sendKeys(text);
    }

    protected void inputAfterClear(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void setWindowDimensions(int width, int height) {
        getDriver().manage().window().setSize(new Dimension(width, height));
    }
    public File saveScreenFile(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(file, new File(String.format("screenshots/%s-%s.png", className, methodName)));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return file;
    }

    public void switchToAnotherWindow() {
        String originalWindow = getDriver().getWindowHandle();

        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!originalWindow.equals(windowHandle) && getDriver().getWindowHandles().size() == 2) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }


    protected void scrollByVisibleElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    protected void scrollByVisibleElementActions(WebElement element) {
        getActions().moveToElement(element).perform();
    }

    protected void goBack() {

        getDriver().navigate().back();
    }
    protected void refreshPage() {

        getDriver().navigate().refresh();
    }

    protected void selectOption(WebElement element, String text) {
        Select option = new Select(element);
        option.selectByValue(text);
    }

    protected void waitForTextNotToBeEmpty(WebElement element) {
        while (element.getText() == null || element.getText().length() < 1) {
            getWait20().until(ExpectedConditions
                    .not(ExpectedConditions.textToBePresentInElement(element, "")));
        }
    }

    protected void wait10ElementToBeVisible(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
    }

    protected void wait10ElementToBeInVisible(WebElement element) {
        getWait10().until(ExpectedConditions.invisibilityOf(element));
    }
    protected void wait10ElementToBeEmpty(WebElement element) {
        getWait10().until(ExpectedConditions.textToBePresentInElement(element, ""));
    }

    protected void wait20ElementToBeVisible(WebElement element) {
        getWait20().until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement wait10ElementToBeClickable(WebElement element) {

        return getWait10().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement wait20ElementToBeClickable(WebElement element) {

        return getWait20().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForUrlContains(String text) {
        getWait10().until(ExpectedConditions.urlContains(text));
    }
    protected void wait20ElementToBeVisibleJsExecutor(JavascriptExecutor jsExecutor, WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center', behavior: 'auto'});", element);
        jsExecutor.executeScript("return (typeof arguments[0].offsetParent !== 'undefined' && arguments[0].offsetParent !== null)", element);
    }

    protected void waitTextToBeChanged(WebElement element, String text) {
        getWait20().until(ExpectedConditions
                .not(ExpectedConditions.textToBePresentInElement(element, text)));
    }
    protected void waitAttributeToBeChanged(WebElement element, String attributeName, String expectedValue) {
        getWait20().until(ExpectedConditions.attributeToBe(element, attributeName, expectedValue));
    }

    protected boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }


    protected boolean areElementsInListDisplayed(List<WebElement> list) {
        boolean result = false;

        for (WebElement element : list) {
            if (element.isDisplayed()) {
                result = true;
            } else {

                return false;
            }
        }

        return result;
    }

    protected boolean areAllElementsVisibleAndClickable(List<WebElement> elements) {
        List<WebElement> allElements = new ArrayList<>(elements);
        int elementsSize = elements.size();
        int count = 0;

        for (WebElement checkedElement : allElements) {
            if (checkedElement.isEnabled() && checkedElement.isDisplayed()) {
                wait10ElementToBeClickable(checkedElement);
                count++;
            }
        }

        return elementsSize == count;
    }

    public void waitForElementIsDisappeared(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
    }
    @Step("Switch to the external web page.")
    public void switchToExternalPage() {
        switchToAnotherWindow();
        getWait20().until(ExpectedConditions.numberOfWindowsToBe(2));
    }
    @Step("Make screen")
    public void screen(String name) throws IOException {
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("screenshotsVideo/" + name));
        new CharityProjectPage(getDriver());
    }

    public List<WebElement> getAllHTTPSLinks(List<WebElement> allLinks) {
        List<WebElement> linksList = new ArrayList<>();

        for (WebElement link : allLinks) {
            if (link.getAttribute("protocol").equals("https:")) {
                linksList.add(link);
            }
        }
        return linksList;
    }

}
