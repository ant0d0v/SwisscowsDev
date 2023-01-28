package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public abstract class BreadCrumbPage<Generic> extends FooterMenuPage<Generic> {

    @FindBy(xpath = "//h1[@class ='breadcrumb-title']")
    private WebElement h1Header;

    @FindBy(xpath = "//ol/li/a[@href = '/']")
    private WebElement homeLink;

    public BreadCrumbPage(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();

    public String getH1Header() {

        return getText(h1Header);
    }

    public WebElement getHomeLink() {

        return homeLink;
    }

    public MainPage clickHomeLink() {
        click(getHomeLink());

        return new MainPage(getDriver());
    }
}
