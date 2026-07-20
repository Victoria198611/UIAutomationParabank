package pages;

import com.victoria.parabank.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    // Confirmation locators
    private final By confirmationMessage = By.cssSelector("#rightPanel h1");
    private final By confirmationDetail = By.cssSelector("#rightPanel p");

    public BillPayPage(WebDriver driver) {
        super(driver);
    }

    // Method used by your test: payBill(...)
    public void payBill(String name,
                        String addr,
                        String cityVal,
                        String stateVal,
                        String zipVal,
                        String phoneVal,
                        String acc,
                        String verifyAcc,
                        String amt) {

        elementUtils.type(payeeName, name);
        elementUtils.type(address, addr);
        elementUtils.type(city, cityVal);
        elementUtils.type(state, stateVal);
        elementUtils.type(zip, zipVal);
        elementUtils.type(phone, phoneVal);
        elementUtils.type(account, acc);
        elementUtils.type(verifyAccount, verifyAcc);
        elementUtils.type(amount, amt);

        elementUtils.click(sendPaymentButton);
    }

    // Method used by your test: getConfirmationMessage()
    public String getConfirmationMessage() {
        return elementUtils.getText(confirmationMessage);
    }

    // Method used by your test: getConfirmationDetail()
    public String getConfirmationDetail() {
        return elementUtils.getText(confirmationDetail);
    }
}