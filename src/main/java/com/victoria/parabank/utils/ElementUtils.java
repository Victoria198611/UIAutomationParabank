package com.victoria.parabank.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ElementUtils {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    // Constructor receives WebDriver from BasePage
    public ElementUtils(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    // Waits for element to be clickable and clicks it
    public void click(By locator) {
        waitUtils.waitForClickable(locator).click();
    }

    // Waits for element to be visible and types text
    public void type(By locator, String text) {
        WebElement element = waitUtils.waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Waits for element to be visible and returns its text
    public String getText(By locator) {
        return waitUtils.waitForVisible(locator).getText().trim();
    }

    public void selectByIndex(By locator, int index) {
        WebElement element = waitUtils.waitForVisible(locator);
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }
}