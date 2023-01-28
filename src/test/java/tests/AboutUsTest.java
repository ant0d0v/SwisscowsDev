package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.Arrays;
import java.util.List;

public class AboutUsTest extends BaseTest {

    @Test
    public void testActiveOptionsForWhereToField() {
        final List<String> expectedOptions = Arrays.asList(
                "Buy by Subscription",
                "Buy in the Marketplace",
                "Products documentation",
                "News and Updates"
        );

        List<String> actualOptions = openBaseURL()
                .scrollToFooterMenu()
                .clickAboutUsFooterMenu()
                .scrollToWhereTo()
                .waitAllOptionsAreVisibleAndClickable()
                .getOptionsText();

        Assert.assertEquals(actualOptions, expectedOptions);
    }

    @Test
    public void testHeadersAboutUsPage(){
        final String expectedH1Header = "OpenWeather\nglobal services";

        String actualH1Header = openBaseURL()
                .scrollToFooterMenu()
                .clickAboutUsFooterMenu()
                .getTextH1Header();

        Assert.assertEquals(actualH1Header, expectedH1Header);

    }
}
