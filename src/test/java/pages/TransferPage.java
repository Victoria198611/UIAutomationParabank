package pages;

import com.victoria.parabank.base.BasePage;
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

    public void transferFunds(String amount, int fromIndex, int toIndex) {

        // type amount
        elementUtils.type(amountField, amount);

        // select from account
        WebElement fromDropdown = waitUtils.waitForVisible(fromAccountDropdown);
        fromDropdown.findElements(By.tagName("option")).get(fromIndex).click();

        // select to account
        WebElement toDropdown = waitUtils.waitForVisible(toAccountDropdown);
        toDropdown.findElements(By.tagName("option")).get(toIndex).click();

        // click transfer
        elementUtils.click(transferButton);
    }

    public String getConfirmationMessage() {
        return elementUtils.getText(confirmationMessage);
    }
}