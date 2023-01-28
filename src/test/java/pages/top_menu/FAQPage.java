package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.BreadCrumbPage;

import java.util.List;

public class FAQPage extends BreadCrumbPage<FAQPage> {

    @FindBy(xpath = "//section/h3")
    private List<WebElement> H3Headers;

    @FindBy(xpath = "//p[@class='question-heading']")
    private List<WebElement> questions;

    @FindBy(xpath = "//div[@class='question visible']//div[@class='question-content']")
    private WebElement questionsInnerDescription;

    public FAQPage(WebDriver driver) {
        super(driver);
    }

    public FAQPage createGeneric() {

        return new FAQPage(getDriver());
    }

    public List<WebElement> getQuestions() {

        return questions;
    }

    public int getH3HeadersAmount() {

        return getListSize(H3Headers);
    }

    public int getOpenedFAQAmount() {
        int openedContainersAmount = 0;

        for (WebElement currentElement : getQuestions()) {
            scrollByVisibleElement(currentElement);
            clickByJavaScript(currentElement);
            if (questionsInnerDescription.isDisplayed()) {
                openedContainersAmount++;
            }
        }

        return openedContainersAmount;
    }
}
