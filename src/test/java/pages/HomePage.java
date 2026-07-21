package pages;

import com.victoria.parabank.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By transferFundsLink = By.linkText("Transfer Funds");
    private final By openNewAccountLink = By.linkText("Open New Account");
    private final By logoutLink = By.linkText("Log Out");
    private final By loginHeader = By.xpath("//h2[contains(text(),'Customer Login')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Login Page")
    public void goToLoginPage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Step("Click on 'Open New Account'")
    public void clickOpenNewAccount() {
        waitUtils.waitForClickable(openNewAccountLink).click();
    }

    @Step("Click on 'Transfer Funds'")
    public void clickTransferFunds() {
        waitUtils.waitForClickable(transferFundsLink).click();
    }

    @Step("Check if Logout link is visible")
    public boolean isLogoutVisible() {
        try {
            return waitUtils.waitForVisible(logoutLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Get welcome message from Home Page")
    public String getWelcomeMessage() {
        return waitUtils.waitForVisible(loginHeader).getText().trim();
    }
}