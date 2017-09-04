package com.thetan.automation.example;

import com.thetan.automation.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by thetan.do on 12/28/2016.
 */
public class HomePageTest extends BaseTest {

    WebDriver driver;
    HomePage homePage;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = getDriver(browser);
        homePage = new HomePage(driver);
    }

    @AfterTest
    public void teardown() {
        homePage.close();
    }

    @Test
    public void checkDriver() {
        homePage.open()
                .search("Checking");
    }

    @Test
    public void checkSearch() {
        homePage.open()
                .search("Checking");
    }
}
