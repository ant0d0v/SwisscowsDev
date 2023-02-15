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

    @DataProvider(name = "LangTopMenuTestData")
    public static Object[][] LangTestDataProvider() {

        return new Object[][]{
                {1, "Deutsch", "https://dev.swisscows.com/de","Deine private und anonyme Suchmaschine Swisscows"},
                {2, "Français", "https://dev.swisscows.com/fr", "Votre moteur de recherche privé et anonyme Swisscows"},
                {3, "Italiano", "https://dev.swisscows.com/it", "Il tuo motore di ricerca privato e anonimo Swisscows"},
                {4, "Español", "https://dev.swisscows.com/es", "Su buscador privado y anónimo Swisscows"},
                {5, "Nederlands", "https://dev.swisscows.com/nl", "Uw privé en anonieme zoekmachine Swisscows"},
                {6, "Latviešu", "https://dev.swisscows.com/lv", "Jūsu privātā un anonīma meklētājprogramma Swisscows"},
                {7, "Magyar", "https://dev.swisscows.com/hu", "Az Ön privát és névtelen keresőmotorja, Swisscows"},
                {8, "Русский", "https://dev.swisscows.com/ru", "Swisscows - Ваша приватная и анонимная поисковая система"},
                {9, "Українська", "https://dev.swisscows.com/uk", "Swisscows - Ваша приватна та анонімна пошукова система"},

        };
    }
    @DataProvider(name = "LangSetAsStartTestData")
    public static Object[][] LangSetAsStartDataProvider() {

        return new Object[][]{
                {1, "Deutsch", "Swisscows als Startseite festlegen"},
                {2, "Français", "Utiliser Swisscows comme page d'accueil"},
                {3, "Italiano",  "Impostare Swisscows come pagina iniziale"},
                {6, "Latviešu",  "Vai vēlaties iestatīt \"Swisscows\" kā sākumlapu"},
                {7, "Magyar",  "How to set Swisscows as your start page"},


        };
    }
    @DataProvider(name = "LangMakaDefaultSearchTestData")
    public static Object[][] LangMakaDefaultSearchDataProvider() {

        return new Object[][]{
                {1, "Deutsch", "Standardsuche verwenden"},
                {2, "Français", "Utiliser la recherche par défaut"},
                {3, "Italiano",  "Utilizzare ricerca standard"},
                {6, "Latviešu",  "Vai vēlaties izmantot \"Swisscows\" meklēšanai"},
                {7, "Magyar",  "Használja a Swisscows-t alapértelmezett keresőként"},

        };
    }

    @DataProvider(name = "RegionTopMenuTestData")
    public static Object[][] RegionTestDataProvider() {

        return new Object[][]{
                {0, "Argentina", "https://dev.swisscows.com/en?region=es-AR","Your private and anonymous search engine Swisscows"},
                {1, "Australia", "https://dev.swisscows.com/en?region=en-AU", "Your private and anonymous search engine Swisscows"},
                {2, "Austria", "https://dev.swisscows.com/en?region=de-AT", "Your private and anonymous search engine Swisscows"},
                {3, "Belgium(fr)", "https://dev.swisscows.com/en?region=fr-BE", "Your private and anonymous search engine Swisscows"},
                {6, "Canada(en)", "https://dev.swisscows.com/en?region=en-CA", "Your private and anonymous search engine Swisscows"},
                {7, "Canada(fr)", "https://dev.swisscows.com/en?region=fr-CA", "Your private and anonymous search engine Swisscows"},
                {12, "France", "https://dev.swisscows.com/en?region=fr-FR", "Your private and anonymous search engine Swisscows"},
                {13, "Germany", "https://dev.swisscows.com/en?region=de-DE", "Your private and anonymous search engine Swisscows"},
                {18, "Italy", "https://dev.swisscows.com/en?region=it-IT", "Your private and anonymous search engine Swisscows"},
                {37, "Switzerland(de)", "https://dev.swisscows.com/en?region=de-CH", "Your private and anonymous search engine Swisscows"},
                {38, "Switzerland(fr)", "https://dev.swisscows.com/en?region=fr-CH", "Your private and anonymous search engine Swisscows"},
                {45, "World-wide", "https://dev.swisscows.com/en?region=iv", "Your private and anonymous search engine Swisscows"},

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
                {0, "Who we are", "/en/search-engine-no-tracking", "https://dev.swisscows.com/en/search-engine-no-tracking", "The search engine without tracking – Swisscows"},
                {1, "Media Education", "/en/media-education", "https://dev.swisscows.com/en/media-education", "Swisscows as a search engine without tracking: the best alternative"},
                {2, "Charity Project", "/en/social-projects", "https://dev.swisscows.com/en/social-projects", "Charity Project"},
                {3, "Our Datacenter", "/en/data-safe-search-engine", "https://dev.swisscows.com/en/data-safe-search-engine", "Data secure search engine"},
                {4, "Contact us", "/en/contact", "https://dev.swisscows.com/en/contact", "Contact us"},
                {5, "VPN", "/en/anonymous-vpn", "https://dev.swisscows.com/en/anonymous-vpn", "Anonymous web surfing with Swisscows"},
                {12, "Set as Startpage", "/en/set-as-startpage", "https://dev.swisscows.com/en/set-as-startpage", "How to set Swisscows as your start page"},
                {13, "Make a Default Search Engine", "/en/default-search", "https://dev.swisscows.com/en/default-search", "How to use Swisscows as default search"},


        };
    }
    @DataProvider(name = "WhoWeAreLinksData")
    public static Object[][] WhoWeAreLinksTestDataProvider() {

        return new Object[][] {
                {0, "Swisscows", "/en", "https://dev.swisscows.com/en", "Anonymous search engine"},
                {1, "privacy policy", "/en/privacy", "https://dev.swisscows.com/en/privacy", "Swisscows Privacy Policy"},

        };
    }
    @DataProvider(name = "VpnLinksData")
    public static Object[][] VpnLinksTestDataProvider() {

        return new Object[][] {
                {0, "Swisscows account Register", "https://accounts.swisscows.com/register", "https://accounts.swisscows.com/register",
                        "Registration made easy!"},
                {1, "Google", "https://chrome.google.com/webstore/detail/swisscowsvpn/nglddggbgngenfgaelmmmhldofddjlmh",
                        "https://chrome.google.com/webstore/detail/swisscowsvpn/nglddggbgngenfgaelmmmhldofddjlmh", "chrome web store"},
                {2, "Mozilla", "https://addons.mozilla.org/firefox/addon/swisscows-vpn/",
                        "https://addons.mozilla.org/en-US/firefox/addon/swisscows-vpn/", "Swisscows.VPN\nby Swisscows AG"},
                {3, "Learn More", "/en/vpn-instruction", "https://dev.swisscows.com/en/vpn-instruction",
                        "Configuring Swisscows Proxy"},
                {4, "Swisscows account Sign In", "https://accounts.swisscows.com/subscriptions/vpn#monthly",
                        "https://accounts.swisscows.com/Account/Login?ReturnUrl=%2Fsubscriptions%2Fvpn#monthly", "Sign in"},
                {5, "Swisscows account Sign In", "https://accounts.swisscows.com/subscriptions/vpn#monthly",
                        "https://accounts.swisscows.com/Account/Login?ReturnUrl=%2Fsubscriptions%2Fvpn#annualy", "Sign in"},

        };
    }

    @DataProvider(name = "CharityProjectLinksData")
    public static Object[][] CharityProjectLinksTestDataProvider() {

        return new Object[][] {
                {0, "Swisscows VPN", "/en/vpn", "https://dev.swisscows.com/en/anonymous-vpn",},
                {1, "TeleGuard", "https://teleguard.com", "https://teleguard.com/en"},

        };
    }
    @DataProvider(name = "MakeDefaultSearchLinksData")
    public static Object[][] MakeDefaultSearchLinksTestDataProvider() {

        return new Object[][] {
                {0, "Install Swisscows", "https://addons.mozilla.org/en-US/firefox/addon/swisscows-search/", "https://addons.mozilla.org/en-US/firefox/addon/swisscows-search/",},
                {1, "Install Swisscows", "https://chrome.google.com/webstore/detail/swisscows/ibimaeimnogcdnjmmlpodbhhbejnpaij", "https://chrome.google.com/webstore/detail/swisscows/ibimaeimnogcdnjmmlpodbhhbejnpaij"},
                {2, "Install Swisscows", "https://swisscows.com/web?query=%s", "https://swisscows.com/en/web?query=%25s"},
                {3, "Install Swisscows", "https://swisscows.com/web?query=%s", "https://swisscows.com/en/web?query=%25s"},
                {4, "Install Swisscows", "https://microsoftedge.microsoft.com/addons/detail/swisscows/dlclfmjmfabgglmifagcjnjcpimekdmn", "https://microsoftedge.microsoft.com/addons/detail/swisscows/dlclfmjmfabgglmifagcjnjcpimekdmn"},
        };
    }

    @DataProvider(name = "OurDatacenterLinksData")
    public static Object[][] OurDatacenterLinksTestDataProvider() {

        return new Object[][] {
                {0, "Swisscows.com", "/en", "https://dev.swisscows.com/en",},
                {1, "Media Education", "/en/media-education", "https://dev.swisscows.com/en/media-education"},

        };
    }
    @DataProvider(name = "DonationLinksData")
    public static Object[][] DonationLinksTestDataProvider() {

        return new Object[][] {
                {0, "Swisscows VPN", "/en/anonymous-vpn", "https://dev.swisscows.com/en/anonymous-vpn","Anonymous web surfing with Swisscows"},
                {1, "TeleGuard", "https://teleguard.com", "https://teleguard.com/en","SCREENSHOTS"},
                {2, "here", "/en/social-projects", "https://dev.swisscows.com/en/social-projects","Charity Project"},

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
