package com.victoria.parabank.tests;

import com.victoria.parabank.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OverviewPage;
import pages.UpdateProfilePage;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class UpdateProfileTest extends BaseTest {

    @Epic("Parabank Functional Tests")
    @Feature("User Profile")
    @Story("Update Profile Information")
    @Description("Verify that user profile information can be updated successfully and report defects if the update confirmation or page title is incorrect.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyProfileUpdateIsSuccessful() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        // Step 2: Navigate to update profile page
        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.goToUpdateProfile();

        // Step 3: Update Profile details
        UpdateProfilePage updateProfilePage = new UpdateProfilePage(driver);
        updateProfilePage.updateProfile("37322783456", "Vlaicu Pircalab, 1", "Chisinau", "MD", "CHIS", "2001");

        // Step 4: Verify success message
        String pageTitle = updateProfilePage.getPageTitle();
        Assert.assertEquals(pageTitle, "Update Profile", "Profile update failed Page title mismatch. Actual: " + pageTitle);
    }
}