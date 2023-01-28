package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.BreadCrumbPage;

import java.util.List;

public class PricePage extends BreadCrumbPage<PricePage> {

    @FindBy(xpath = "//a[@class = 'btn_block transparent round']")
    private List<WebElement> transparentButtons;

    @FindBy(xpath = "//section[@id = 'alerts']/h2")
    private WebElement alertsHeader;

    @FindBy(xpath = "//section[@id = 'alerts']//tbody/tr/th/h4/a")
    private List<WebElement> alertsH4Headers;

    @FindBy(xpath = "//section[@id='alerts']//h4[text()='By request']")
    private List<WebElement> alertsPriceByRequest;

    @FindBy(id = "solar_radiation")
    private WebElement alertPriceSolarRadiationAPIText;

    @FindBy(xpath = "//section[@id='current']//table/thead//h3/b")
    private List<WebElement> weatherAndForecastsCollections;

    @FindBy(xpath = "//h2")
    private List<WebElement> h2Headers;

    @FindBy(xpath = "//a[@class = 'btn_like btn-orange owm-block-mainpage__btn']")
    private List<WebElement> detailedPricingButtons;

    public PricePage(WebDriver driver) {
        super(driver);
    }

    public PricePage createGeneric() {

        return new PricePage(getDriver());
    }

    public String getAlertsH2Header() {

        return getText(alertsHeader);
    }

    public List<String> getCollectionsNames() {

        return getTexts(weatherAndForecastsCollections);
    }

    public List<String> getH4Headers() {

        return getTexts(alertsH4Headers);
    }

    public List<String> getTransparentButtonsLabels() {

        return getTrimmedTexts(transparentButtons);
    }

    public List<String> getH2Headers() {

        return getTexts(h2Headers);
    }

    public int getH2HeadersAmount() {

        return getListSize(h2Headers);
    }

    public List<String> getDetailedPricingButtonsLabels() {

        return getTrimmedTexts(detailedPricingButtons);
    }

    public int getAlertsByRequestAmount() {

        return getListSize(alertsPriceByRequest);
    }

    public int getDetailedPricingButtonsAmount() {

        return getListSize(detailedPricingButtons);
    }

    public int getTransparentButtonsAmount() {

        return getListSize(transparentButtons);
    }

    public PricePage waitGetRequestToBeChanged(String oldHeader) {
        waitTextToBeChanged(alertPriceSolarRadiationAPIText, oldHeader);

        return this;
    }

    public PricePage waitAllElementsVisibleAndClickable() {
        areAllElementsVisibleAndClickable(transparentButtons);

        return this;
    }
}
