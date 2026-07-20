package com.victoria.parabank.tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTests {
    private WebDriver driver;
    private RegisterPage registerPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        registerPage = new RegisterPage(driver);
    }

    @Epic("Parabank Functional Tests")
    @Feature("Authentication")
    @Story("User Registration")
    @Description("Verify that a new user can register successfully and report defects if the registration confirmation message is incorrect or missing.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testRegistration() {
        registerPage.fillRegistrationForm();
        registerPage.submitForm();
        String message = registerPage.getSuccessMessage();
        Assert.assertEquals(message, "Signing up is easy!", "Registration Field!");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}