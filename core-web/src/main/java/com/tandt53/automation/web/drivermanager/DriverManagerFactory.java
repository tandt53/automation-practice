package com.tandt53.automation.web.drivermanager;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

public class DriverManagerFactory {

    private static ThreadLocal<DriverManager> manager = new ThreadLocal<>();

    /**
     * Init driver manager based on expected browser type: chrome, firefox, safari
     *
     * @param driverType
     * @return
     */
    public static DriverManager getDriverManager(String driverType) {
        Injector injector = Guice.createInjector(new DriverBinder());
        DriverManager m = injector.getInstance((Key.get(DriverManager.class, Names.named(driverType))));
        manager.set(m);
        return m;
    }

}
