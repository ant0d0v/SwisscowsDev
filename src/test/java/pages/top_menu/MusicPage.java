package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;

public class MusicPage extends TopMenuPage<MusicPage> {
    @FindBy(xpath = "//div[@class='audio-results']//article")
    private WebElement audioResultContainer;

    public MusicPage(WebDriver driver) {
        super(driver);
    }

    public MusicPage createGeneric() {

        return new MusicPage(getDriver());
    }
    public MusicPage waitUntilVisibilityAudioResult() {
        wait20ElementToBeVisible(audioResultContainer);

        return new MusicPage(getDriver());
    }
}