package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // Browser from GitHub Actions or config.properties
        String browser = System.getProperty(
                "browser",
                ConfigReader.get("browser")
        );

        // Environment from GitHub Actions
        String env = System.getProperty(
                "env",
                "qa"
        );

        // Pick URL based on environment
        String url;

        switch (env.toLowerCase()) {

            case "dev":
                url = ConfigReader.get("devUrl");
                break;

            case "uat":
                url = ConfigReader.get("uatUrl");
                break;

            case "qa":
            default:
                url = ConfigReader.get("qaUrl");
                break;
        }

        int wait = Integer.parseInt(
                ConfigReader.get("implicitWait")
        );

        // Chrome
        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");

            driver = new ChromeDriver(options);

        }
        // Firefox
        else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");

            driver = new FirefoxDriver(options);

        }
        else {

            throw new RuntimeException(
                    "Unsupported browser: " + browser
            );
        }

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(wait));

        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}