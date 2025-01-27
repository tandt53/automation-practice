package onboarding.web.drivermanager;


public class Constants {

    Constants() {
    }

    public static final String DRIVER_TYPE_CHROME = "chrome";
    public static final String DRIVER_TYPE_FIREFOX = "firefox";
    public static final String DRIVER_TYPE_SAFARI = "safari";
    public static final String DRIVER_TYPE_EDGE = "edge";
    public static final String ENV_LOCAL = "local";
    public static final String ENV_REMOTE = "remote";
    public static final String DOT = ".";

    // capabilities
    public static final String PREFIX_SELENIUM = "onboarding.selenium.";
    public static final String CONFIGURATION_REMOTE_HOST = "onboarding.selenium.remote.url";
    public static final String CONFIGURATION_DRIVER_PATH = "onboarding.selenium.driver.path";

    public static final String TEST_OUTPUT_DIR = "TestResults";
    public static final String LOGFILE_PATH = TEST_OUTPUT_DIR + "/Logs";
    public static final String REPORT_PATH = TEST_OUTPUT_DIR + "/Reports";
    public static final String SCREENSHOT_PATH = TEST_OUTPUT_DIR + "/Screenshots";


}
