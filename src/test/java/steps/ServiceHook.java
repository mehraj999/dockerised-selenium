package steps;

import base.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ServiceHook {
    @After
    public void after(Scenario scenario) throws Exception {
        RemoteWebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
