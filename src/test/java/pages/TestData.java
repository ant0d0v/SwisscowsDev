package pages;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "TopMenuTestData")
    public static Object[][] topMenuTestDataProvider() {

        return new Object[][]{
                {0, "Set as Startpage", "/en/set-as-startpage", "https://dev.swisscows.com/en/set-as-startpage"},
                {1, "Make a Default Search Engine", "/en/default-search", "https://dev.swisscows.com/en/default-search"},
                {2, "Who we are", "/en/search-engine-no-tracking", "https://dev.swisscows.com/en/search-engine-no-tracking"},
                {3, "Media Education", "/en/media-education", "https://dev.swisscows.com/en/media-education"},
                {4, "Charity Project", "/en/social-projects", "https://dev.swisscows.com/en/social-projects"},
                {5, "Our Datacenter", "/en/data-safe-search-engine", "https://dev.swisscows.com/en/data-safe-search-engine"},
                {6, "Contact us", "/en/contact", "https://dev.swisscows.com/en/contact"},
                {7, "Data privacy", "/en/privacy", "https://dev.swisscows.com/en/privacy"},
                {8, "Donation", "/en/donation", "https://dev.swisscows.com/en/donation"},

        };
    }

    @DataProvider(name = "ExternalTopMenuTestData")
    public static Object[][] externalTopMenuTestDataProvider() {

        return new Object[][]{
                {8, "Blog", "https://dev.swisscows.com/en/privacy", "https://dev.swisscows.com/en/privacy", "Blog "},
                {9, "For Business", "https://dev.swisscows.com/en/privacy", "https://dev.swisscows.com/en/privacy", "for business"}
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
                {12, "Set as Startpage", "/en/set-as-startpage", "https://dev.swisscows.com/en/set-as-startpage", "Set Swisscows as start page"},
                {13, "Make a Default Search Engine", "/en/default-search", "https://dev.swisscows.com/en/default-search", "Install Swisscows and use it as the default search"},


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
