package pages;

import com.victoria.parabank.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    private By accountBalance = By.id("balance");
    private By accountNumber = By.id("accountId");
    private By accountType = By.id("accountType");

    //Constructor
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountNumber() {
        return driver.findElement(accountNumber).getText().trim();
    }

    public String getAccountBalance() {
        return driver.findElement(accountBalance).getText().trim();
    }

    public String getAccountType() {
        return driver.findElement(accountType).getText().trim();
    }
}