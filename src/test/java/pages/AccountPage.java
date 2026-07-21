package pages;

import com.victoria.parabank.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    private final By accountBalance = By.id("balance");
    private final By accountNumber = By.id("accountId");
    private final By accountType = By.id("accountType");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get account number")
    public String getAccountNumber() {
        return waitUtils.waitForVisible(accountNumber).getText().trim();
    }

    @Step("Get account balance")
    public String getAccountBalance() {
        return waitUtils.waitForVisible(accountBalance).getText().trim();
    }

    @Step("Get account type")
    public String getAccountType() {
        return waitUtils.waitForVisible(accountType).getText().trim();
    }
}