package onboarding.web.drivermanager;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.name.Names;
import onboarding.commontest.Prop;
import onboarding.web.exceptions.SeleniumDriverConfigException;

public class WebDriverProvider implements Provider<DriverManager> {

    @Inject
    private Injector injector;

    @Inject
    @Prop("onboarding.selenium.browserName")
    private String browser;

    @Inject
    @Prop("onboarding.selenium.server")
    private String server;

    @Override
    public DriverManager get() {
        return injector.getInstance(Key.get(DriverManager.class, Names.named(getNamed())));
    }

    private String getNamed() {
        if (server.equals("")) {
            throw new SeleniumDriverConfigException("No server specified");
        }
        if (browser.equals("")) {
            throw new SeleniumDriverConfigException("No browser specified");
        }

        return server.split("\\.")[0] + "." + browser.toLowerCase();

    }
}
