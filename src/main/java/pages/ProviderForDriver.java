package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import static utils.Constants.FILENAME_WITH_PROPERTIES;

public class ProviderForDriver {
    public static final ProviderForDriver INSTANCE = new ProviderForDriver();
    private ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();

    public ProviderForDriver() {
    }

    public WebDriver getDriver() {
        if (DRIVER.get() == null) {
            String browserType = loadProperties().getProperty("browserType");
            DRIVER.set(DriverFactory.createDriver(BrowserType.valueOf(browserType)));
        }
        return DRIVER.get();
    }

    public void removeDriver() {
        DRIVER.get().quit();
        DRIVER.remove();
    }

    public static Properties loadProperties(){
    String currentDir = System.getProperty("user.dir");
    String fileSeparator = System.getProperty("file.separator");
    String resourcesFolder = "src" + fileSeparator + "main" + fileSeparator + "resources";
    Path file = Paths.get(currentDir + fileSeparator + resourcesFolder + fileSeparator + FILENAME_WITH_PROPERTIES);
    Properties properties = new Properties();
      try {
          properties.load(Files.newInputStream(file));
      } catch (IOException e){
          e.printStackTrace();
          throw new RuntimeException("No such properties file");
      }
      return properties;
    }
}