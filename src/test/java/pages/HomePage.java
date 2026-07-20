package pages;

import com.victoria.parabank.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By transferFundsLink = By.linkText("Transfer Funds");
    private final By openNewAccountLink = By.linkText("Open New Account");
    private final By logoutLink = By.linkText("Log Out");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    public void clickOpenNewAccount() {
        waitUtils.waitForClickable(openNewAccountLink).click();
    }

    public void clickTransferFunds() {
        waitUtils.waitForClickable(transferFundsLink).click();
    }

    public boolean isLogoutVisible() {
        try {
            return waitUtils.waitForVisible(logoutLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getWelcomeMessage() {
        return waitUtils.waitForVisible(By.xpath("//h2[contains(text(),'Customer Login')]"))
                .getText().trim();
    }
}