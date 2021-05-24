package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ProviderForDriver;

import java.time.Duration;

public class Waiters {

    public static WebElement waitForElementToBeVisible(WebElement webElement, int timeLoadElement){
        return new WebDriverWait(new ProviderForDriver().INSTANCE.getDriver(), timeLoadElement)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
    public static boolean waitForChangedValue(WebElement webElement, int timeLoadElement, String attribute, String value){
        return new WebDriverWait(new ProviderForDriver().INSTANCE.getDriver(), timeLoadElement)
                .until(ExpectedConditions.attributeContains(webElement, attribute, value));
    }
}
