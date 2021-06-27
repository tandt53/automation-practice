package tandt.cucumber.test;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tandt.cucumber.test.exception.TakeScreenshotException;
import tandt.mobile.drivermanager.DriverManager;

import java.io.File;
import java.io.IOException;




@Singleton
public class DriverHooks {

    @Inject
    private Injector injector;

    @Inject
    @Named("platformName")
    private String platform;

    private WebDriver webDriver;
    private AppiumDriver<WebElement> mobileDriver;

    public void initWeb() {
        webDriver = injector.getInstance(WebDriver.class);
    }

    public void initMobile() {
        DriverManager manager = injector.getInstance(Key.get(DriverManager.class, Names.named(platform)));
        mobileDriver = manager.initDriver();
    }

    public void takeScreenshotMobile(String image) {
        File srcFile = ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(image);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new TakeScreenshotException("There's a problem during take screenshot", e.getCause());
        }
    }

    public void closeMobileDriver() {
        mobileDriver.quit();
    }

    public void takeScreenshotWeb(String image) {
        File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(image);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new TakeScreenshotException("There's a problem during take screenshot", e.getCause());
        }
    }

    public void closeWebDriver() {
        webDriver.quit();
    }

}
