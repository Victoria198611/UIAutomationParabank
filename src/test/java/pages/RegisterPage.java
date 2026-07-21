package pages;

import com.victoria.parabank.base.BasePage;
import com.victoria.parabank.utils.RandomUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private final By firstNameField = By.id("customer.firstName");
    private final By lastNameField = By.id("customer.lastName");
    private final By addressField = By.id("customer.address.street");
    private final By cityField = By.id("customer.address.city");
    private final By stateField = By.id("customer.address.state");
    private final By zipCodeField = By.id("customer.address.zipCode");
    private final By phoneField = By.id("customer.phoneNumber");
    private final By ssnField = By.id("customer.ssn");
    private final By usernameField = By.id("customer.username");
    private final By passwordField = By.id("customer.password");
    private final By confirmPasswordField = By.id("repeatedPassword");
    private final By registerButton = By.cssSelector("input[value='Register']");

    // Parabank confirmation message is inside <p>, not <h1>
    private final By successMessage = By.cssSelector("#rightPanel p");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill registration form with random data")
    public void fillRegistrationForm() {

        waitUtils.waitForVisible(firstNameField).sendKeys(RandomUtils.generateRandomString(6));
        waitUtils.waitForVisible(lastNameField).sendKeys(RandomUtils.generateRandomString(8));
        waitUtils.waitForVisible(addressField).sendKeys("Street " + RandomUtils.generateRandomNumber(1, 100));
        waitUtils.waitForVisible(cityField).sendKeys("City" + RandomUtils.generateRandomString(4));
        waitUtils.waitForVisible(stateField).sendKeys("State" + RandomUtils.generateRandomString(3));
        waitUtils.waitForVisible(zipCodeField).sendKeys(String.valueOf(RandomUtils.generateRandomNumber(10000, 99999)));
        waitUtils.waitForVisible(phoneField).sendKeys(RandomUtils.generateRandomPhone());
        waitUtils.waitForVisible(ssnField).sendKeys(RandomUtils.generateRandomID());
        waitUtils.waitForVisible(usernameField).sendKeys(RandomUtils.generateRandomString(8));

        String password = "Pass" + RandomUtils.generateRandomString(6);
        waitUtils.waitForVisible(passwordField).sendKeys(password);
        waitUtils.waitForVisible(confirmPasswordField).sendKeys(password);
    }

    @Step("Submit registration form")
    public void submitForm() {
        waitUtils.waitForClickable(registerButton).click();
    }

    @Step("Get registration success message")
    public String getSuccessMessage() {
        return waitUtils.waitForVisible(successMessage).getText().trim();
    }
}