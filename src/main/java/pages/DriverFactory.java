package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static utils.Constants.*;

public class DriverFactory {

    public static WebDriver createDriver(BrowserType browserType) {
        WebDriver driver = null;
        switch(browserType){
            case CHROME:
                System.setProperty(SYSTEM_PROPERTY_CHROME_DRIVE, PATH_TO_CHROME_DRIVER);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty(SYSTEM_PROPERTY_FIREFOX_DRIVE, PATH_TO_FIREFOX_DRIVER);
                driver = new FirefoxDriver();
                break;
            default: throw new RuntimeException("Configuration for " + browserType + " is not exist");
        }
        return driver;
    }
}

