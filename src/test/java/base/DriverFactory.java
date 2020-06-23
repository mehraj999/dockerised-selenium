package base;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    protected static String node;
    private static String gridMode = "on";
    private static String url = "https://www.google.com";

    public DriverFactory() {
    }

    public static void createInstance(String browserName, String platform) {
        browserName = browserName != null ? browserName : "chrome";
        if (gridMode.equals("on")) {
            node = "http://localhost:4444/wd/hub";
            createRemoteInstance(browserName);
        } else {
            createLocalInstance(browserName);
        }

    }

    public static void createLocalInstance(String browser) {
        if ("FIREFOX".equalsIgnoreCase(browser)) {
            FirefoxDriverManager.getInstance().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            /*if ("Y".equalsIgnoreCase(System.getenv("HEADLESS"))) {
                firefoxOptions.addArguments("--headless");
            }*/
            RemoteWebDriver driver = new FirefoxDriver(firefoxOptions);
            DriverManager.addDriver(driver);

        } else if ("CHROME".equalsIgnoreCase(browser)) {
            ChromeDriverManager.getInstance().version("83.0.4103.39").setup();
            ChromeOptions options = new ChromeOptions();

            /*if ("Y".equalsIgnoreCase(System.getenv("HEADLESS"))) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
            }*/
            RemoteWebDriver driver = new ChromeDriver(options);
            DriverManager.addDriver(driver);
        }

    }

    public static void createRemoteInstance(String browser) {
        if ("FIREFOX".equalsIgnoreCase(browser)) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--disable-gpu");

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
            try {
                RemoteWebDriver driver = new RemoteWebDriver(new URL(node), desiredCapabilities);
                DriverManager.addDriver(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("CHROME".equalsIgnoreCase(browser)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");

            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
            try {
                RemoteWebDriver driver = new RemoteWebDriver(new URL(node), desiredCapabilities);
                DriverManager.addDriver(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
