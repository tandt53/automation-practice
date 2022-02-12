package tandt.mobile.drivermanager;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import tandt.commontest.Prop;
import ui.driverselector.DriverSelector;

public class DriverManagerFactory {

    private static DriverManager manager;

    @Inject
    Injector injector;

    @Inject
    @Prop("nbt.appium.platformName")
    private String platformName;

    /**
     * Init driver manager based on expected browser type: chrome, firefox, safari
     *
     * @param driverType
     * @return
     */
    public DriverManager getDriverManager(String driverType) {
        manager = injector.getInstance((Key.get(DriverManager.class, Names.named(driverType))));
        manager.initDriver();
        return manager;
    }

    public DriverManager getDriverManager() {
        DriverManager m = injector.getInstance((Key.get(DriverManager.class, Names.named(platformName))));
        m.initDriver();
        return manager;
    }
}
