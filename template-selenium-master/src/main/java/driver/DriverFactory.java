package driver;

import environment.CurrentEnvironmentLoader;
import environment.PropertyLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public enum DriverFactory implements IDriverType {

    FIREFOX {
        public MutableCapabilities returnDriver() {
            return new FirefoxOptions();
        }
    },

    FIREFOX_HEADLESS {
        public MutableCapabilities returnDriver() {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(true);
            return firefoxOptions;
        }
    },

    CHROME {
        @Override
        public MutableCapabilities returnDriver() {
            return defaultChromeOptions();
        }
    },

    CHROME_HEADLESS {
        @Override
        public MutableCapabilities returnDriver() {
            return ((ChromeOptions) defaultChromeOptions()).addArguments("headless");
        }
    },

    SAFARI {
        @Override
        public MutableCapabilities returnDriver() {
            return new SafariOptions();
        }
    },

    EDGE {
        @Override
        public MutableCapabilities returnDriver() {
            return new EdgeOptions();
        }
    };


    private static MutableCapabilities defaultChromeOptions() {
        ChromeOptions capabilities = new ChromeOptions();
        capabilities.addArguments("start-maximized");
        capabilities.addArguments("lang=pt-BR");
        return capabilities;
    }


    public static WebDriver criarInstancia(String browser) {
        WebDriver driver;

        switch (PropertyLoader.get().getExecution(CurrentEnvironmentLoader.get())) {

            case "local":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "local-headless":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver((ChromeOptions) retornaCapacidade("CHROME_HEADLESS"));
                break;

            default:
                throw new IllegalArgumentException("Browser no encontrado: " + browser);
        }

        return driver;
    }

    private static MutableCapabilities retornaCapacidade(String browser) {
        return valueOf(browser.toUpperCase()).returnDriver();
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
