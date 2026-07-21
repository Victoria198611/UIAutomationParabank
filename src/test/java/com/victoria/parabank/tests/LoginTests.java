package com.victoria.parabank.tests;

import com.victoria.parabank.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class LoginTests extends BaseTest {

    @Epic("Parabank Functional Tests")
    @Feature("Authentication")
    @Story("User Login")
    @Description("Verify that a user can log in successfully and report defects if authentication fails.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyLoginSuccessful() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isLogoutVisible(),
                "BUG: Login failed — Logout link not visible!"
        );
    }

    @Epic("Parabank Functional Tests")
    @Feature("Authentication")
    @Story("User Login")
    @Description("Verify that login fails when invalid credentials are provided and the correct error message is displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void verifyLoginFailsWithWrongCredentials() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong", "wrong");

        String error = loginPage.getLoginErrorMessage();

        Assert.assertTrue(
                error.toLowerCase().contains("could not be verified"),
                "BUG: Wrong error message for invalid login! Actual: " + error
        );
    }
}