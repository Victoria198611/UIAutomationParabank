package pages;

import com.victoria.parabank.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferPage extends BasePage {

    private final By amountField = By.id("amount");
    private final By fromAccountDropdown = By.id("fromAccountId");
    private final By toAccountDropdown = By.id("toAccountId");
    private final By transferButton = By.cssSelector("input[value='Transfer']");
    private final By confirmationMessage = By.cssSelector("#rightPanel p");

    public TransferPage(WebDriver driver) {
        super(driver);
    }

    @Step("Transfer {amount} from account index {fromIndex} to account index {toIndex}")
    public void transferFunds(String amount, int fromIndex, int toIndex) {

        // Type amount
        waitUtils.waitForVisible(amountField).sendKeys(amount);

        // Select FROM account
        WebElement fromDropdown = waitUtils.waitForVisible(fromAccountDropdown);
        fromDropdown.findElements(By.tagName("option")).get(fromIndex).click();

        // Select TO account
        WebElement toDropdown = waitUtils.waitForVisible(toAccountDropdown);
        toDropdown.findElements(By.tagName("option")).get(toIndex).click();

        // Click Transfer
        waitUtils.waitForClickable(transferButton).click();
    }

    @Step("Get transfer confirmation message")
    public String getConfirmationMessage() {
        return waitUtils.waitForVisible(confirmationMessage).getText().trim();
    }

    @Step("Get number of available FROM accounts")
    public int getFromAccountsCount() {
        WebElement dropdown = waitUtils.waitForVisible(fromAccountDropdown);
        return dropdown.findElements(By.tagName("option")).size();
    }

    @Step("Get number of available TO accounts")
    public int getToAccountsCount() {
        WebElement dropdown = waitUtils.waitForVisible(toAccountDropdown);
        return dropdown.findElements(By.tagName("option")).size();
    }
}