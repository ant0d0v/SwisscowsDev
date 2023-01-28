package pages;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "TopMenuTestData")
    public static Object[][] topMenuTestDataProvider() {

        return new Object[][]{
                {0, "Logo", "/", "https://openweathermap.org/", "Сurrent weather and forecast - OpenWeatherMap"},
                {1, "Guide", "/guide", "https://openweathermap.org/guide", "OpenWeatherMap API guide - OpenWeatherMap"},
                {2, "API", "/api", "https://openweathermap.org/api", "Weather API - OpenWeatherMap"},
                {3, "Dashboard", "/weather-dashboard", "https://openweathermap.org/weather-dashboard", "Weather dashboard - OpenWeatherMap"},
                {4, "Marketplace", "https://home.openweathermap.org/marketplace", "https://home.openweathermap.org/marketplace", "Marketplace: History Bulk, History Forecast Bulk, Historical Weather Data by State for all ZIP codes, USA - OpenWeather"},
                {5, "Pricing", "/price", "https://openweathermap.org/price", "Pricing - OpenWeatherMap"},
                {6, "Maps", "/weathermap", "https://openweathermap.org/weathermap", "Interactive weather maps - OpenWeatherMap"},
                {7, "Our Initiatives", "/our-initiatives", "https://openweathermap.org/our-initiatives", "Our Initiatives - OpenWeatherMap"},
                {8, "Partners", "/examples", "https://openweathermap.org/examples", "Partners and solutions - OpenWeatherMap"},
                {11, "Sign In", "/users/sign_in", "https://home.openweathermap.org/users/sign_in", "Members"},
                {12, "FAQ", "/faq", "https://openweathermap.org/faq", "Frequently Asked Questions - OpenWeatherMap"},
                {13, "How to start", "/appid", "https://openweathermap.org/appid", "How to start to work with Openweather API - OpenWeatherMap"},
                {14, "Ask a question", "https://home.openweathermap.org/questions", "https://home.openweathermap.org/questions", "Members"}
        };
    }

    @DataProvider(name = "ExternalTopMenuTestData")
    public static Object[][] externalTopMenuTestDataProvider() {

        return new Object[][]{
                {8, "Blog", "https://openweather.co.uk/blog/category/weather", "https://openweather.co.uk/blog/category/weather", "Blog - OpenWeatherMap"},
                {9, "For Business", "https://openweather.co.uk", "https://openweather.co.uk/", "OpenWeather for business - OpenWeatherMap"}
        };
    }

    @DataProvider(name = "ApiIconsMainPage")
    public static Object[][] apiIconsTestDataProvider() {

        return new Object[][]{
                {0, "current\nweather", "(current)", "/current", "https://openweathermap.org/current", "Current weather data - OpenWeatherMap"},
                {1, "hourly\nforecast", "(4 days)", "/api/hourly-forecast", "https://openweathermap.org/api/hourly-forecast", "Hourly Weather Forecast 4 days - OpenWeatherMap"},
                {2, "daily\nforecast", "(16 days)", "/forecast16", "https://openweathermap.org/forecast16", "Daily Forecast 16 Days - OpenWeatherMap"},
                {3, "climatic\nforecast", "(30 days)", "/api/forecast30", "https://openweathermap.org/api/forecast30", "Climate forecast for 30 days - OpenWeatherMap"},
                {4, "historical\nweather", "(1 month, 1 year)", "/history", "https://openweathermap.org/history", "Historical weather API - OpenWeatherMap"}
        };
    }

    @DataProvider(name = "FooterMenuData")
    public static Object[][] footerMenuTestDataProvider() {

        return new Object[][] {
                {0, "Current and Forecast APIs", "/api#current", "https://openweathermap.org/api#current", "Weather API - OpenWeatherMap"},
                {1, "Historical Weather Data", "/api#history", "https://openweathermap.org/api#history", "Weather API - OpenWeatherMap"},
                {2, "Weather Maps", "/api#maps", "https://openweathermap.org/api#maps", "Weather API - OpenWeatherMap"},
                {3, "Weather Dashboard", "/weather-dashboard", "https://openweathermap.org/weather-dashboard", "Weather dashboard - OpenWeatherMap"},
                {4, "Widgets", "/widgets-constructor", "https://openweathermap.org/widgets-constructor", "Weather widgets constructor - OpenWeatherMap"},
                {5, "How to start", "/appid", "https://openweathermap.org/appid", "How to start to work with Openweather API - OpenWeatherMap"},
                {6, "Pricing", "/price", "https://openweathermap.org/price", "Pricing - OpenWeatherMap"},
                {7, "Subscribe for free", "https://home.openweathermap.org/users/sign_up", "https://home.openweathermap.org/users/sign_up", "Members"},
                {8, "FAQ", "/faq", "https://openweathermap.org/faq", "Frequently Asked Questions - OpenWeatherMap"},
                {9, "Our technology", "/technology", "https://openweathermap.org/technology", "Weather model - OpenWeatherMap"},
                {10, "Accuracy and quality of weather data", "/accuracy-and-quality", "https://openweathermap.org/accuracy-and-quality", "Accuracy and quality of weather data - OpenWeatherMap"},
                {11, "Connect your weather station", "/stations", "https://openweathermap.org/stations", "Weather Stations - OpenWeatherMap"},
                {15, "About us", "/about-us", "https://openweathermap.org/about-us", "About us - OpenWeatherMap"},
                {18, "Ask a question", "https://home.openweathermap.org/questions", "https://home.openweathermap.org/questions", "Members"}
        };
    }

    @DataProvider(name = "ExternalFooterMenuData")
    public static Object[][] externalMenuTestDataProvider() {

        return new Object[][] {
                {13, "Privacy Policy", "https://openweather.co.uk/privacy-policy", "https://openweather.co.uk/privacy-policy", "Privacy policy - OpenWeatherMap"},
                {16, "Blog", "https://openweather.co.uk/blog/category/weather", "https://openweather.co.uk/blog/category/weather", "Blog - OpenWeatherMap"},
                {17, "OpenWeather for Business", "https://openweather.co.uk/", "https://openweather.co.uk/", "OpenWeather for business - OpenWeatherMap"},
        };
    }

    @DataProvider(name = "SignInCredentials")
    public static Object[][] signInWithInvalidCredentialsTestDataProvider() {

        return new Object[][] {
                {"bothWrong", "jka59435@xcoxc.com", "Tester11#", "Invalid Email or password.", "Sign In"},
                {"invalidEmail", "jka59435@xcoxc.com", "Tester12#", "Invalid Email or password.", "Sign In"},
                {"invalidPassword", "jka59433@xcoxc.com", "Tester11#", "Invalid Email or password.", "Sign In"},
                {"bothEmpty", "", "", "Invalid Email or password.", "Sign In"},
                {"emptyEmail", "", "Tester12#", "Invalid Email or password.", "Sign In"},
                {"emptyPassword", "jka59433@xcoxc.com", "", "Invalid Email or password.", "Sign In"},
                {"passwordCaseSensitive", "jka59433@xcoxc.com", "tester12#", "Invalid Email or password.", "Sign In"},
                {"passwordLeadingSpace", "jka59433@xcoxc.com", " Tester12#", "Invalid Email or password.", "Sign In"},
                {"passwordTrailingSpace", "jka59433@xcoxc.com", "Tester12# ", "Invalid Email or password.", "Sign In"}
        };
    }
}
