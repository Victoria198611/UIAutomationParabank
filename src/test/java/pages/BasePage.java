package com.victoria.parabank.base;

import org.openqa.selenium.WebDriver;
import com.victoria.parabank.utils.WaitUtils;
import com.victoria.parabank.utils.ElementUtils;

public class BasePage {

    // WebDriver instance used by all page classes
    protected WebDriver driver;

    // Utility class for explicit waits (visibility, clickability, etc.)
    protected WaitUtils waitUtils;

    // Utility class for common element interactions (click, type, getText)
    protected ElementUtils elementUtils;

    // Constructor initializes driver and utility classes for each page object
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.elementUtils = new ElementUtils(driver);
    }

    // Navigates the browser to a specific URL
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Returns the current page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Returns the current page URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}