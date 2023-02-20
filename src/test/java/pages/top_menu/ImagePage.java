package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;

public class ImagePage extends TopMenuPage<ImagePage> {
    @FindBy(xpath = "//div[@class='images-results']//figure")
    private WebElement firstImageInImagesResult;

    public ImagePage(WebDriver driver) {
        super(driver);
    }

    public ImagePage createGeneric() {

        return new ImagePage(getDriver());
    }
    public void clickFirstImageInImagesResult() {
        wait20ElementToBeVisible(firstImageInImagesResult);
        click(firstImageInImagesResult);
        new ImagePage(getDriver());

    }


}