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
                {0, "Who we are", "/en/search-engine-no-tracking", "https://dev.swisscows.com/en/search-engine-no-tracking", "Your private and anonymous search engine Swisscows"},
                {1, "Media Education", "/en/media-education", "https://dev.swisscows.com/en/media-education", "Your private and anonymous search engine Swisscows"},
                {2, "Charity Project", "/en/social-projects", "https://dev.swisscows.com/en/social-projects", "Social projects - We support social projects"},
                {3, "Our Datacenter", "/en/data-safe-search-engine", "https://dev.swisscows.com/en/data-safe-search-engine", "Data center – Everything about the Swisscows data center"},
                {4, "Contact us", "/en/contact", "https://dev.swisscows.com/en/contact", "Contact us | Swisscows"},
                {5, "VPN", "/en/anonymous-vpn", "https://dev.swisscows.com/en/anonymous-vpn", "Surf anonymously with VPN - Secure web surfing with Swisscows"},
                {12, "Set as Startpage", "/en/set-as-startpage", "https://dev.swisscows.com/en/set-as-startpage", "Your private and anonymous search engine Swisscows"},
                {13, "Make a Default Search Engine", "/en/default-search", "https://dev.swisscows.com/en/default-search", "Your private and anonymous search engine Swisscows"},


        };
    }

    @DataProvider(name = "ExternalFooterMenuData")
    public static Object[][] externalMenuTestDataProvider() {

        return new Object[][] {
                {6, "Swisscows.email", "https://swisscows.email/", "https://swisscows.email/", "Swisscows.email - My secure e-mail."},
                {7, "TeleGuard", "https://teleguard.com", "https://teleguard.com/en", "TeleGuard - secure messenger from Switzerland"},
                {8, "HES", "https://hesbox.com/", "https://hesbox.com/en", "Enterprise Search Software for companies"},
                {9, "GetDigest", "https://getdigest.com/", "https://getdigest.com/en", "GetDigest | Get a document summary. Fast!"},
                {10, "Fan-shop", "https://swisscows-fanshop.com", "https://swisscows-fanshop.com/", "Swisscows Fanshop für Kleider und Geschenke für Fans"},
                {11, "Swisscows Blog", "https://blog.swisscows.com/", "https://blog.swisscows.com/", "Blog - Swisscows AG"},



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
