package pages;

import com.victoria.parabank.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillPayPage extends BasePage {

    private final By payeeName = By.name("payee.name");
    private final By address = By.name("payee.address.street");
    private final By city = By.name("payee.address.city");
    private final By state = By.name("payee.address.state");
    private final By zip = By.name("payee.address.zipCode");
    private final By phone = By.name("payee.phoneNumber");
    private final By account = By.name("payee.accountNumber");
    private final By verifyAccount = By.name("verifyAccount");
    private final By amount = By.name("amount");
    private final By sendPaymentButton = By.cssSelector("input[value='Send Payment']");
    private final By fromAccountDropdown = By.name("fromAccountId");

    private final By confirmationMessage = By.cssSelector("#rightPanel h1");
    private final By confirmationDetail = By.cssSelector("#rightPanel p");

    public BillPayPage(WebDriver driver) {
        super(driver);
    }

    @Step("Pay bill to {name} with amount {amt}")
    public void payBill(String name,
                        String addr,
                        String cityVal,
                        String stateVal,
                        String zipVal,
                        String phoneVal,
                        String acc,
                        String verifyAcc,
                        String amt) {

        waitUtils.waitForVisible(payeeName).sendKeys(name);
        waitUtils.waitForVisible(address).sendKeys(addr);
        waitUtils.waitForVisible(city).sendKeys(cityVal);
        waitUtils.waitForVisible(state).sendKeys(stateVal);
        waitUtils.waitForVisible(zip).sendKeys(zipVal);
        waitUtils.waitForVisible(phone).sendKeys(phoneVal);
        waitUtils.waitForVisible(account).sendKeys(acc);
        waitUtils.waitForVisible(verifyAccount).sendKeys(verifyAcc);
        waitUtils.waitForVisible(amount).sendKeys(amt);

        // Select first account safely
        WebElement dropdown = waitUtils.waitForVisible(fromAccountDropdown);
        dropdown.findElements(By.tagName("option")).get(0).click();

        waitUtils.waitForClickable(sendPaymentButton).click();
    }

    @Step("Get bill payment confirmation title")
    public String getConfirmationMessage() {
        return waitUtils.waitForVisible(confirmationMessage).getText().trim();
    }

    @Step("Get bill payment confirmation detail")
    public String getConfirmationDetail() {
        return waitUtils.waitForVisible(confirmationDetail).getText().trim();
    }

    @Step("Get number of available accounts for Bill Pay")
    public int getAvailableAccountsCount() {
        WebElement dropdown = waitUtils.waitForVisible(fromAccountDropdown);
        return dropdown.findElements(By.tagName("option")).size();
    }
}