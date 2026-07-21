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

        System.out.println("Confirmation message: " + billPayPage.getConfirmationMessage());
        System.out.println("Title: " + billPayPage.getConfirmationMessage());
        System.out.println("Detail: " + billPayPage.getConfirmationDetail());

        Assert.assertTrue(
                billPayPage.getConfirmationMessage().contains("Bill Payment Service"),
                "Bill Payment failed! Actual message: " + billPayPage.getConfirmationMessage()
        );

        Assert.assertTrue(
                billPayPage.getConfirmationDetail().contains("successful"),
                "Bill Payment failed! Actual detail: " + billPayPage.getConfirmationDetail()
        );

        Assert.assertFalse(
                billPayPage.getConfirmationMessage().isEmpty(),
                "Title not found!"
        );
    }
}