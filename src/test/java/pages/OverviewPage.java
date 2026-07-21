package pages;

import com.victoria.parabank.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {

    private final By welcomeMessage = By.cssSelector("h1");
    private final By accountOverviewTable = By.id("accountTable");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get welcome message from Accounts Overview page")
    public String getWelcomeMessage() {
        return waitUtils.waitForVisible(welcomeMessage).getText().trim();
    }

    @Step("Check if account overview table is displayed")
    public boolean isAccountOverviewDisplayed() {
        return waitUtils.waitForVisible(accountOverviewTable).isDisplayed();
    }

    @Step("Navigate to Bill Pay page")
    public void goToBillPay() {
        waitUtils.waitForClickable(By.linkText("Bill Pay")).click();
    }

    @Step("Navigate to Transfer Funds page")
    public void goToTransferFunds() {
        waitUtils.waitForClickable(By.linkText("Transfer Funds")).click();
    }

    @Step("Navigate to Update Profile page")
    public void goToUpdateProfile() {
        waitUtils.waitForClickable(By.linkText("Update Contact Info")).click();
    }

    @Step("Navigate to Open New Account page")
    public void goToOpenNewAccount() {
        waitUtils.waitForClickable(By.linkText("Open New Account")).click();
    }
}