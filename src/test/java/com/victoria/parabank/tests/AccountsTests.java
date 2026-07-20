package com.victoria.parabank.tests;

import com.victoria.parabank.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OverviewPage;

public class AccountsTests extends BaseTest {

    @Epic("Parabank Functional Tests")
    @Feature("Account Overview")
    @Story("View Accounts Overview")
    @Description("Verify that the Accounts Overview page is displayed correctly after login and report defects if the overview content is missing.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyAccountOverviewIsDisplayed() {
        // Perform login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        // Navigate to overview page
        OverviewPage overviewPage = new OverviewPage(driver);

        // Log the H1 text
        System.out.println("Overview H1 text: " + overviewPage.getWelcomeMessage());

        // Assert that Accounts Overview is displayed
        Assert.assertTrue(
                overviewPage.getWelcomeMessage().contains("Accounts Overview"),
                "Overview page not loaded!"
        );
    }
}