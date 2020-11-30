package com.tandt53.automation.web.drivermanager;

import com.tandt53.automation.common.CommonException;
import com.tandt53.automation.common.Utils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteDriverManager extends DriverManager {
    static String KEY_SAFARI = "webdriver.safari.driver";
    static String KEY_CHROME = "webdriver.chrome.driver";
    static String KEY_FIREFOX = "webdriver.gecko.driver";
    static String KEY_EDGE = "webdriver.edge.driver";
    private static Map<String, String> driverExeFileMap;

    static {
        driverExeFileMap = new HashMap<>();
        driverExeFileMap.put(Constants.OS_LIN, "chromedriver");
        driverExeFileMap.put(Constants.OS_MAC, "chromedriver");
        driverExeFileMap.put(Constants.OS_WIN, "chromedriver.exe");
    }

    @Override
    public WebDriver initDriver() {
        return null;
    }

    @Override
    public WebDriver initDriver(DriverService service) {
        return null;
    }

    @Override
    public WebDriver initDriver(Capabilities capabilities) {
        return null;
    }

    @Override
    public WebDriver initDriver(DriverService service, Capabilities caps) {
        return null;
    }

    @Override
    public WebDriver initDriver(URL remoteAddress, Capabilities caps) throws MalformedURLException, CommonException {
        String url = Utils.parse(caps.getCapability(Constants.CAPABILITY_REMOTE_HOST).toString());
        System.out.println(url);
        driver.set(new RemoteWebDriver(new URL(url), caps));
        return getDriver();

    }

}
