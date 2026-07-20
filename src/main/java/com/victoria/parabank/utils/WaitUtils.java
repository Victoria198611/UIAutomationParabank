package com.victoria.parabank.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitUtils {

    private final WebDriver driver;
    private final Duration defaultTimeout = Duration.ofSeconds(10);

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForPresence(By locator) {
        return new WebDriverWait(driver, defaultTimeout)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForVisible(By locator) {
        return new WebDriverWait(driver, defaultTimeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return new WebDriverWait(driver, defaultTimeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForInvisible(By locator) {
        return new WebDriverWait(driver, defaultTimeout)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForPageReady() {
        new WebDriverWait(driver, defaultTimeout).until(
                d -> ((JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }

    public void waitForCondition(Function<WebDriver, Boolean> condition) {
        new WebDriverWait(driver, defaultTimeout).until(condition);
    }
}