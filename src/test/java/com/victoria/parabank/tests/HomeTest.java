package com.victoria.parabank.tests;

import com.victoria.parabank.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class HomeTest extends BaseTest {

    @Epic("Parabank Functional Tests")
    @Feature("Dashboard")
    @Story("Home Page Loading")
    @Description("Verify that the home page loads correctly and displays the expected welcome message.")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void verifyHomePageLoads() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();

        String welcomeMessage = homePage.getWelcomeMessage();
        Assert.assertEquals(welcomeMessage, "Customer Login", "Home page did not load correctly!");
    }

    @Epic("Parabank Functional Tests")
    @Feature("Dashboard")
    @Story("Home Page Navigation")
    @Description("Verify that navigation from the home page to the login page works correctly and the login form is visible.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void verifyNavigationToLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginFormVisible(), "Login form is not visible!");
    }
}