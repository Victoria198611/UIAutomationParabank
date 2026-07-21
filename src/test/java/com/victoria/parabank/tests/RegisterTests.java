package com.victoria.parabank.tests;

import com.victoria.parabank.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.RegisterPage;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class RegisterTests extends BaseTest {

    @Epic("Parabank Functional Tests")
    @Feature("Authentication")
    @Story("User Registration")
    @Description("Verify that a new user can register successfully and report defects if the registration confirmation message is incorrect or missing.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyRegistrationIsSuccessful() {

        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.fillRegistrationForm();
        registerPage.submitForm();

        String message = registerPage.getSuccessMessage();

        Assert.assertTrue(
                message.toLowerCase().contains("welcome"),
                "BUG: Registration confirmation message incorrect! Actual: " + message
        );
    }
}