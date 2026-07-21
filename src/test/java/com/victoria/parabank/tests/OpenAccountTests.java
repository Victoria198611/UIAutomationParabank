package com.victoria.parabank.tests;

import com.victoria.parabank.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OpenAccountPage;
import pages.OverviewPage;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class OpenAccountTests extends BaseTest {

    @Epic("Parabank Functional Tests")
    @Feature("Account Management")
    @Story("Open New Account")
    @Description("Verify that a new account can be opened successfully and report defects if account options or confirmation messages are missing.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyOpenNewAccountIsSuccessful() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.goToOpenNewAccount();

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);

        openAccountPage.selectTypeAccount("CHECKING");

        int accounts = openAccountPage.getAvailableAccountsCount();

        Assert.assertTrue(
                accounts > 0,
                "BUG: No accounts available in dropdown before opening new account."
        );

        openAccountPage.selectFromAccount(0);
        openAccountPage.clickOpenAccount();

        String message = openAccountPage.getConfirmationMessage();

        Assert.assertTrue(
                message.toLowerCase().contains("account"),
                "BUG: Account creation confirmation message missing. Actual: " + message
        );
    }
}