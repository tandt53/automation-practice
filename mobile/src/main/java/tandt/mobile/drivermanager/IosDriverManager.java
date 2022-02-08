package tandt.mobile.drivermanager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import tandt.commontest.TestContext;
import tandt.commontest.configuration.Configuration;
import ui.exception.DriverInitException;

import java.net.MalformedURLException;
import java.net.URL;

public class IosDriverManager extends DriverManager {

    @Override
    public AppiumDriver initDriver() {
        Configuration caps = TestContext.getInstance().getConfiguration();
        try {
            URL url = new URL((String) caps.get(Constants.CAPABILITY_SERVER_URL));
            caps.remove(Constants.CAPABILITY_SERVER_URL);
            driver = new AndroidDriver(url, new XCUITestOptions(caps.getConfigs()));
            return driver;
        } catch (MalformedURLException e) {
            throw new DriverInitException("Unable to init IosDriver", e.getCause());
        }
    }
}
