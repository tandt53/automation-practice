package tandt.web.drivermanager;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import tandt.common.configurations.ContextImpl;
import tandt.common.configurations.capability.Capability;

public class SafariDriverManager extends DriverManager {

    protected static final String KEY_SAFARI = "please add safari driver here";

    @Override
    public WebDriver initDriver() {
        Capability caps = ContextImpl.createInstance().getCapability();
        System.setProperty(KEY_SAFARI, (String) caps.get(Constants.CAPABILITY_DRIVER_PATH));
        SafariOptions options = new SafariOptions();
        options.merge(new MutableCapabilities(caps.getCapabilities()));
        driver.set(new SafariDriver(options));
        return getDriver();
    }

}
