package tandt.mobile.drivermanager;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import tandt.common.configurations.capability.Capability;
import tandt.common.configurations.capability.CapabilityService;
import ui.exception.DriverInitException;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager extends DriverManager {
    @Inject
    @Named("mobile")
    private CapabilityService service;

    @Override
    public AppiumDriver<WebElement> initDriver() {
        Capability caps = service.getCapability();
        URL url = null;
        try {
            url = new URL((String) caps.get(Constants.CAPABILITY_SERVER_URL));
            driver.set(new AndroidDriver<>(url, new DesiredCapabilities(caps.getCapabilities())));
            return getDriver();
        } catch (MalformedURLException e) {
            throw new DriverInitException("Unable to init AndroidDriver", e.getCause());
        }
    }
}
