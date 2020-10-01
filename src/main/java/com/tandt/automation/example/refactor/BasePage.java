package com.tandt.automation.example.refactor;

import com.tandt.automation.example.ElementSupplier;
import com.tandt.automation.example.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by thetan.do on 12/28/2016.
 */
public class BasePage<TPage extends BasePage<?>> implements ElementSupplier {

    /**
     * default url
     */
    public String url;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final int DEFAULT_TIMEOUT = 30;

    @SuppressWarnings("unchecked")
    public Log PLog = new Log(((TPage) BasePage.this).getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, DEFAULT_TIMEOUT);
        PageFactory.initElements(this, this.driver, this.wait);
    }

    /**
     * open default page with url is not null
     */
    public TPage open() {
        if (url != null)
            return open(url);
        return null;
    }

    /**
     * open page with a specific url
     */
    @SuppressWarnings("unchecked")
    private TPage open(String url) {
        driver.get(url);
        return (TPage) this;
    }

    /**
     * close page and quit driver
     */
    public void close() {
        if (driver != null)
            driver.quit();
    }

    /**
     * getTitle
     *
     * @return title of page
     */
    public String getPageTitel() {
        return driver.getTitle();
    }
}
