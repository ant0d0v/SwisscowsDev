package pages;

import org.testng.annotations.DataProvider;
import utils.ProjectConstants;

public class TestData {

    @DataProvider(name = "TopMenuTestData")
    public static Object[][] topMenuTestDataProvider() {

        return new Object[][]{
                {0, "Set as Startpage", "/en/set-as-startpage", ProjectConstants.DOMAIN + "/en/set-as-startpage"},
                {1, "Make a Default Search Engine", "/en/default-search", ProjectConstants.DOMAIN +"/en/default-search"},
                {2, "Who we are", "/en/search-engine-no-tracking", ProjectConstants.DOMAIN + "/en/search-engine-no-tracking"},
                {3, "Media Education", "/en/media-education", ProjectConstants.DOMAIN + "/en/media-education"},
                {4, "Charity Project", "/en/social-projects", ProjectConstants.DOMAIN + "/en/social-projects"},
                {5, "Our Datacenter", "/en/data-safe-search-engine", ProjectConstants.DOMAIN +"/en/data-safe-search-engine"},
                {6, "Contact us", "/en/contact", ProjectConstants.DOMAIN + "/en/contact"},
                {7, "Data privacy", "/en/privacy", ProjectConstants.DOMAIN +"/en/privacy"},
                {8, "Donation", "/en/donation", ProjectConstants.DOMAIN + "/en/donation"},
                {9, "Support", "/", "https://support.swisscows.com/"},

        };
    }

    @DataProvider(name = "LangTopMenuTestData")
    public static Object[][] LangTestDataProvider() {

        return new Object[][]{
                {1, "Deutsch", "https://dev.swisscows.com/de","Deine private und anonyme Suchmaschine Swisscows"},
                {2, "Español", "https://dev.swisscows.com/es", "Su buscador privado y anónimo Swisscows"},
                {3, "Français", "https://dev.swisscows.com/fr", "Votre moteur de recherche privé et anonyme Swisscows"},
                {4, "Italiano", "https://dev.swisscows.com/it", "Il tuo motore di ricerca privato e anonimo Swisscows"},
                {5, "Latviešu", "https://dev.swisscows.com/lv", "Jūsu privātā un anonīma meklētājprogramma Swisscows"},
                {6, "Magyar", "https://dev.swisscows.com/hu", "Az Ön privát és névtelen keresőmotorja, Swisscows"},
                {7, "Nederlands", "https://dev.swisscows.com/nl", "Uw privé en anonieme zoekmachine Swisscows"},
                {8, "Portugal", "https://dev.swisscows.com/pt", "O teu motor de busca privado e anónimo Swisscows"},
                {9, "Русский", "https://dev.swisscows.com/ru", "Swisscows - Ваша приватная и анонимная поисковая система"},
                {10, "Українська", "https://dev.swisscows.com/uk", "Swisscows - Ваша приватна та анонімна пошукова система"},


        };
    }
    @DataProvider(name = "LangSetAsStartTestData")
    public static Object[][] LangSetAsStartDataProvider() {

        return new Object[][]{
                {1, "Deutsch", "Swisscows als Startseite festlegen"},
                {2, "Español", "Establecer Swisscows como página de inicio"},
                {3, "Français",  "Utiliser Swisscows comme page d'accueil"},
                {6, "Magyar",  "How to set Swisscows as your start page"},
                {7, "Nederlands",  "How to set Swisscows as your start page"},


        };
    }
    @DataProvider(name = "LangMakaDefaultSearchTestData")
    public static Object[][] LangMakaDefaultSearchDataProvider() {

        return new Object[][]{
                {1, "Deutsch", "Standardsuche verwenden"},
                {2, "Español", "Use la búsqueda estándar"},
                {3, "Français",  "Utiliser la recherche par défaut"},
                {6, "Magyar",  "Használja a Swisscows-t alapértelmezett keresőként"},
                {7, "Nederlands",  "How to use Swisscows as default search"},

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
                {19, "Italy", "https://dev.swisscows.com/en?region=it-IT", "Your private and anonymous search engine Swisscows"},
                {39, "Switzerland(de)", "https://dev.swisscows.com/en?region=de-CH", "Your private and anonymous search engine Swisscows"},
                {40, "Switzerland(fr)", "https://dev.swisscows.com/en?region=fr-CH", "Your private and anonymous search engine Swisscows"},
                {47, "World-wide", "https://dev.swisscows.com/en?region=iv", "Your private and anonymous search engine Swisscows"},

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
                {0, "Who we are", "/en/search-engine-no-tracking", ProjectConstants.DOMAIN + "/en/search-engine-no-tracking", "The search engine without tracking – Swisscows"},
                {1, "Media Education", "/en/media-education", ProjectConstants.DOMAIN + "/en/media-education", "Swisscows – media education"},
                {2, "Charity Project", "/en/social-projects", ProjectConstants.DOMAIN + "/en/social-projects", "Charity Project"},
                {3, "Our Datacenter", "/en/data-safe-search-engine", ProjectConstants.DOMAIN + "/en/data-safe-search-engine", "Data secure search engine"},
                {4, "Contact us", "/en/contact", ProjectConstants.DOMAIN + "/en/contact", "Contact us"},
                {5, "VPN", "/en/anonymous-vpn", ProjectConstants.DOMAIN + "/en/anonymous-vpn", "Anonymous web surfing with Swisscows"},
                {6, "Swisscows.email", "/en/swisscows-email", ProjectConstants.DOMAIN + "/en/swisscows-email", "A letter is your personal property!"},
                {13, "Set as Startpage", "/en/set-as-startpage", ProjectConstants.DOMAIN + "/en/set-as-startpage", "How to set Swisscows as your start page"},
                {14, "Make a Default Search Engine", "/en/default-search", ProjectConstants.DOMAIN + "/en/default-search", "How to use Swisscows as default search"},


        };
    }
    @DataProvider(name = "WhoWeAreLinksData")
    public static Object[][] WhoWeAreLinksTestDataProvider() {

        return new Object[][] {
                {0, "Swisscows", "/en", ProjectConstants.DOMAIN + "/en", "Anonymous search engine"},
                {1, "privacy policy", "/en/privacy", ProjectConstants.DOMAIN + "/en/privacy", "Swisscows Privacy Policy"},

        };
    }

    @DataProvider(name = "VpnLinksData")
    public static Object[][] VpnLinksTestDataProvider() {

        return new Object[][] {
                {0,"https://accounts.swisscows.com/register", "Register"},
                {1, "https://chrome.google.com/webstore/detail/swisscowsvpn/nglddggbgngenfgaelmmmhldofddjlmh", "chrome web store"},
                {2, "https://addons.mozilla.org/en-US/firefox/addon/swisscows-vpn/", "Swisscows.VPN\nby Swisscows AG"},
                {3, ProjectConstants.DOMAIN +"/en/vpn-instruction", "Configuring Swisscows Proxy"},
                {4, "https://accounts.swisscows.com/login?ReturnUrl=%2Fproducts%2Fswisscows-vpn-standard", "Login"},
                {5, "https://accounts.swisscows.com/login?ReturnUrl=%2Fproducts%2Fswisscows-vpn-standard", "Login"},

        };
    }
    @DataProvider(name = "EmailLinksData")
    public static Object[][] EmailLinksTestDataProvider () {

        return new Object[][] {
                {0, "Login - Swisscows Accounts", "uthorize%3Fresponse_typ"},
                {1, "Login - Swisscows Accounts","swisscows-email-standar"},
                {2, "Login - Swisscows Accounts","swisscows-email-premium"},


        };
    }
    @DataProvider(name = "ServicesBlockLinksData")
    public static Object[][] ServicesBlockLinksDataDataProvider() {

        return new Object[][] {
                {0, "Enterprise Search Software for companies", "https://hesbox.com/en"},
                {1, "Swisscows Fanshop für Kleider und Geschenke für Fans","https://swisscows-fanshop.com/"},
                {2, "Blog - Andreas Wiebe","https://awiebe.org/"},


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
                {7, "TeleGuard", "https://teleguard.com", "https://teleguard.com/en", "TeleGuard - secure messenger from Switzerland"},
                {8, "HES", "https://hesbox.com/", "https://hesbox.com/en", "Enterprise Search Software for companies"},
                {9, "GetDigest", "https://getdigest.com/", "https://getdigest.com/en", "GetDigest | Get a document summary. Fast!"},
                {10, "Fan-shop", "https://swisscows-fanshop.com", "https://swisscows-fanshop.com/", "Swisscows Fanshop für Kleider und Geschenke für Fans"},
                {11, "Swisscows Blog", "https://blog.swisscows.com/", "https://blog.swisscows.com/", "Blog - Swisscows AG"},
                {12, "Swisscows Support", "https://support.swisscows.com", "https://support.swisscows.com/", "Swisscows Support"},



        };
    }
    @DataProvider(name = "ExternalFooterSearchMenuData")
    public static Object[][] externalMenuTestDataProviderFooterSearch() {

        return new Object[][] {
                {0, "Learn more about", "https://company.swisscows.com/en", "https://company.swisscows.com/en", "Swisscows AG |Startpage"},
                {6, "googlePlay", "https://play.google.com/store/apps/details?id=com.swisscows.search", "https://play.google.com/store/apps/details?id=com.swisscows.search", "Swisscows Private Search - Apps on Google Play"},
                {7, "appStore", "https://apps.apple.com/app/swisscows-privacy-search/id1581108092", "https://apps.apple.com/app/swisscows-privacy-search/id1581108092", "Swisscows Private Search on the App Store"},



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
