package tandt.mobile.drivermanager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public abstract class DriverManager {

    public static ThreadLocal<AppiumDriver<WebElement>> driver = new ThreadLocal<>();

    public AppiumDriver<WebElement> getDriver() {
        return driver.get();
    }

    public abstract AppiumDriver<WebElement> initDriver() ;

}