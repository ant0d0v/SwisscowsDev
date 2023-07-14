package pages.top_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;

import java.util.ArrayList;
import java.util.List;

public class VpnInstructionsPage extends TopMenuPage<VpnInstructionsPage> {
    @FindBy(xpath = "//div[@class= 'extensions']//a")
    private List<WebElement> listOfExtensionsLinks;
    public VpnInstructionsPage(WebDriver driver) {
        super(driver);
    }

    public VpnInstructionsPage createGeneric() {

        return new VpnInstructionsPage(getDriver());
    }
    @Step("Get list of extensions links")
    public List<String> getListOfExtensionsLinks(){
        List<String> elementList = new ArrayList<>();

        for (WebElement element :  listOfExtensionsLinks) {
            elementList.add(element.getAttribute("href"));
        }
        return elementList;
    }
}