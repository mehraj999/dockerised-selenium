package base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;


public class DriverManager {
    public static ThreadLocal<RemoteWebDriver> drivers = new ThreadLocal<>();

    // To quit the drivers and browsers at the end only.
    private static List<RemoteWebDriver> storedDrivers = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                storedDrivers.forEach(WebDriver::quit);
            }
        });
    }

    private DriverManager() {}

    public static RemoteWebDriver getDriver() {
        return drivers.get();
    }

    public static void addDriver(RemoteWebDriver driver) {
        storedDrivers.add(driver);
        drivers.set(driver);
    }

    public static void removeDriver() {
        storedDrivers.remove(drivers.get());
        drivers.remove();
    }
}
