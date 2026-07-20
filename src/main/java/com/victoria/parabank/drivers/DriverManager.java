package com.victoria.parabank.drivers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    // Holds the WebDriver instance created for this test run
    protected WebDriver driver;

    // Creates a new ChromeDriver instance and maximizes the browser window
    public void createDriver() {
        WebDriverManager.chromedriver().setup(); // Automatically manages ChromeDriver binaries
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Returns the current WebDriver instance
    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}