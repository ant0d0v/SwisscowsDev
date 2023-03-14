package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopMenuPage;

import java.util.List;

public class NewsPage extends TopMenuPage<NewsPage> {
    @FindBy(xpath = "//div[@class='news-results']//figure")
    private WebElement newsResultContainer;
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public NewsPage createGeneric() {

        return new NewsPage(getDriver());
    }
    public VideoPage waitUntilVisibilityNewsResult() {
        wait20ElementToBeVisible(newsResultContainer);

        return new VideoPage(getDriver());
    }
}