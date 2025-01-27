package onboarding.web.drivermanager;

import com.google.inject.Inject;
import onboarding.common.exceptions.CommonException;
import onboarding.commontest.TestContext;
import onboarding.commontest.configuration.Configuration;
import onboarding.ui.exception.DriverInitException;
import onboarding.web.drivermanager.option.DriverOptionFilter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class RemoteDriverManager extends DriverManager {

    @Inject
    private DriverOptionFilter optionFilter;

    @Override
    public WebDriver initDriver() {
        Configuration caps = TestContext.getInstance().getConfiguration();
        try {
            String url = (String) caps.get(Constants.CONFIGURATION_REMOTE_HOST);
            driver = new RemoteWebDriver(new URL(url), optionFilter.filter());
            return driver;
        } catch (CommonException | MalformedURLException e) {
            throw new DriverInitException("Unable to init RemoteWebDriver.", e.getCause());
        }
    }

}
