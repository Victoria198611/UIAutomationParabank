package com.victoria.parabank.tests;

import com.victoria.parabank.base.BaseTest;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

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

        // BUG HANDLING: dacă dropdown-ul e gol → FAIL controlat
        int accounts = driver.findElements(By.cssSelector("#fromAccountId option")).size();
        Assert.assertTrue(accounts > 0,
                "BUG: No accounts available in dropdown after creating new account.");

        openAccountPage.selectFromAccount(0);
        openAccountPage.clickOpenAccount();

        overviewPage.goToTransferFunds();

        TransferPage transferPage = new TransferPage(driver);
        transferPage.transferFunds("100", 0, 0);

        String message = transferPage.getConfirmationMessage();

        Assert.assertTrue(
                message.contains("Transfer") || message.contains("Complete") || message.contains("Success"),
                "BUG: Transfer confirmation message not found. Actual message: " + message
        );
    }
}