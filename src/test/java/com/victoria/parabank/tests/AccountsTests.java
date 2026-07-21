package com.victoria.parabank.tests;

import com.victoria.parabank.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OverviewPage;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class AccountsTests extends BaseTest {

    @Epic("Parabank Functional Tests")
    @Feature("Account Overview")
    @Story("View Accounts Overview")
    @Description("Verify that the Accounts Overview page is displayed correctly after login and report defects if the overview content is missing.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyAccountOverviewIsDisplayed() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        OverviewPage overviewPage = new OverviewPage(driver);

        System.out.println("Overview H1 text: " + overviewPage.getWelcomeMessage());

        Assert.assertTrue(
                overviewPage.getWelcomeMessage().contains("Accounts Overview"),
                "Overview page not loaded!"
        );
    }
}