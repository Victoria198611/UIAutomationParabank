package pages;

import com.victoria.parabank.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {

    private final By welcomeMessage = By.cssSelector("h1");
    private final By accountOverviewTable = By.id("accountTable");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMessage() {
        return waitUtils.waitForVisible(welcomeMessage).getText().trim();
    }

    public boolean isAccountOverviewDisplayed() {
        return waitUtils.waitForVisible(accountOverviewTable).isDisplayed();
    }

    public void goToBillPay() {
        driver.findElement(By.linkText("Bill Pay")).click();
    }

    public void goToTransferFunds() {
        elementUtils.click(By.linkText("Transfer Funds"));
    }

    public void goToUpdateProfile() {
        driver.findElement(By.linkText("Update Contact Info")).click();
    }

    public void goToOpenNewAccount() {
        elementUtils.click(By.linkText("Open New Account"));
    }
    }