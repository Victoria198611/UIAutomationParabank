package com.victoria.parabank.tests;

import com.victoria.parabank.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BillPayPage;
import pages.LoginPage;
import pages.OverviewPage;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BillPayTests extends BaseTest {

    @Epic("Parabank Functional Tests")
    @Feature("Payments")
    @Story("Bill Payment")
    @Description("Verify that a bill payment can be submitted successfully and report defects if the payment confirmation is incorrect or missing.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyBillPaymentIsSuccessful() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.goToBillPay();

        BillPayPage billPayPage = new BillPayPage(driver);

        // Ensure accounts exist before paying
        Assert.assertTrue(
                billPayPage.getAvailableAccountsCount() > 0,
                "BUG: No accounts available for Bill Pay."
        );

        billPayPage.payBill(
                "Electric Company",
                "123 Main St",
                "Los Angeles",
                "CA",
                "90001",
                "5551234567",
                "123456",
                "123456",
                "100"
        );

        String title = billPayPage.getConfirmationMessage();
        String detail = billPayPage.getConfirmationDetail();

        System.out.println("Confirmation Title: " + title);
        System.out.println("Confirmation Detail: " + detail);

        Assert.assertTrue(
                title.contains("Bill Payment") || title.contains("Service"),
                "BUG: Bill Payment confirmation title missing. Actual: " + title
        );

        Assert.assertTrue(
                detail.toLowerCase().contains("successful"),
                "BUG: Bill Payment confirmation detail missing. Actual: " + detail
        );

        Assert.assertFalse(
                title.isEmpty(),
                "BUG: Confirmation title is empty!"
        );
    }
}