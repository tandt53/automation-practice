package com.tandt53.automation.web.drivermanager;

import com.tandt53.automation.common.Utils;
import com.tandt53.automation.common.exceptions.CommonException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class RemoteDriverManager extends DriverManager {

    @Override
    public WebDriver initDriver() throws CommonException, MalformedURLException {
        Capability caps = CapabilityManager.loadCaps();
        String url = Utils.parseVariables(caps.getValue(Constants.CAPABILITY_REMOTE_HOST).toString());
        driver.set(new RemoteWebDriver(new URL(url),new MutableCapabilities(caps.getMap())));
        return getDriver();
    }

}
