package light.commontest.configuration;

import light.dataprovider.properties.PropertiesLoader;

public class PropertiesConfiguration extends Configuration {
    private final String RUNNER = "runner";
    private final String ENV = "env";
    private final String CONFIG_FILE = "configFile";
    private final String CONFIG_FILE_NAME_FORMAT = "automation-%s-%s.properties";
    private final String DEFAULT_RUNNER = "local";
    private final String DEFAULT_ENV = "qc";

    @Override
    public Configuration load() {
        String runner = getProperty(System.getProperty(RUNNER), DEFAULT_RUNNER);
        String env = getProperty(System.getProperty(ENV), DEFAULT_ENV);
        String configFile = System.getProperty(CONFIG_FILE);
        System.out.println("runner: " + runner);
        System.out.println("env: " + env);
        System.out.println("configFile: " + configFile);

        if (configFile == null || configFile.isEmpty()) {
            String propertiesFileName = String.format(CONFIG_FILE_NAME_FORMAT, runner, env);
            System.out.println("propertiesFileName: " + propertiesFileName);
            caps = PropertiesLoader.getMap(PropertiesConfiguration.class.getResourceAsStream("/" + propertiesFileName));
        } else {
            caps = PropertiesLoader.getMap(configFile);
        }
        return this;
    }

    private String getProperty(String value, String defaultValue) {
        return value != null ? value : defaultValue;
    }
}
