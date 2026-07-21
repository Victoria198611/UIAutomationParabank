package com.victoria.parabank.tests;

import com.victoria.parabank.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OpenAccountPage;
import pages.OverviewPage;
import pages.TransferPage;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class TransferTests extends BaseTest {

    @Epic("Parabank Functional Tests")
    @Feature("Funds Transfer")
    @Story("Transfer Money Between Accounts")
    @Description("Verify that funds can be transferred successfully between accounts and report defects if account options or confirmation messages are missing.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyTransferIsSuccessful() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.goToOpenNewAccount();

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.selectTypeAccount("CHECKING");

        // Use Page Object method instead of driver.findElements
        int accounts = openAccountPage.getAvailableAccountsCount();
        Assert.assertTrue(accounts > 0,
                "BUG: No accounts available in dropdown after creating new account.");

        openAccountPage.selectFromAccount(0);
        openAccountPage.clickOpenAccount();

        overviewPage.goToTransferFunds();

        TransferPage transferPage = new TransferPage(driver);

        // Verify dropdowns have accounts before transfer
        Assert.assertTrue(
                transferPage.getFromAccountsCount() > 0,
                "BUG: No FROM accounts available for transfer."
        );

        Assert.assertTrue(
                transferPage.getToAccountsCount() > 0,
                "BUG: No TO accounts available for transfer."
        );

        transferPage.transferFunds("100", 0, 0);

        String message = transferPage.getConfirmationMessage();

        Assert.assertTrue(
                message.toLowerCase().contains("transfer"),
                "BUG: Transfer confirmation message not found. Actual message: " + message
        );
    }
}