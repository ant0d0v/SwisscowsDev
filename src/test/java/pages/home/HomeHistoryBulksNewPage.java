package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeHistoryBulksNewPage extends HomeMarketplacePage {

    @FindBy(xpath = "//span[text()='Weather Parameters:']")
    private WebElement weatherParametersButton;

    @FindBy(xpath = "//div[@class='owm-check-box-group columns']//label")
    private List<WebElement> labels;

    @FindBy(xpath = "//div[@class='owm-check-box-group columns']//input")
    private List<WebElement> inputs;

    public HomeHistoryBulksNewPage(WebDriver driver) {
        super(driver);
    }

    public HomeHistoryBulksNewPage clickWeatherParametersButton() {
        click(weatherParametersButton);

        return this;
    }

    public void clickAllWeatherParameters() {
        clickAllElementsInList(labels);
    }

    public List<WebElement> getCheckBoxes() {

        return inputs;
    }

    public int getNOTSelectedCount(List<WebElement> checkBoxes) {
        int count = 0;
        for (WebElement checkBox : checkBoxes) {
            if (!checkBox.isSelected()) {
                count++;
            }
        }

        return count;
    }

    public int getSelectedCount(List<WebElement> checkBoxes) {
        int count = 0;
        for (WebElement checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                count++;
            }
        }

        return count;
    }
}
