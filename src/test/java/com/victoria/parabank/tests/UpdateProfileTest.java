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

        // Step 3: Update Profile details (correct parameters)
        UpdateProfilePage updateProfilePage = new UpdateProfilePage(driver);
        updateProfilePage.updateProfile(
                "John",                 // First Name
                "Doe",                  // Last Name
                "Vlaicu Pircalab 1",    // Address
                "Chisinau",             // City
                "MD",                   // State
                "2001"                  // Zip
        );

        // Step 4: Verify confirmation message
        String confirmation = updateProfilePage.getConfirmationMessage();

        Assert.assertTrue(
                confirmation.toLowerCase().contains("updated"),
                "BUG: Profile update confirmation missing. Actual: " + confirmation
        );
    }
}