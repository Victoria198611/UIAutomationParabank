package pages;

import com.victoria.parabank.utils.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    // Locators
    private By firstNameField = By.id("customer.firstName");
    private By lastNameField = By.id("customer.lastName");
    private By addressField = By.id("customer.address.street");
    private By cityField = By.id("customer.address.city");
    private By stateField = By.id("customer.address.state");
    private By zipCodeField = By.id("customer.address.zipCode");
    private By phoneField = By.id("customer.phoneNumber");
    private By ssnField = By.id("customer.ssn");
    private By usernameField = By.id("customer.username");
    private By passwordField = By.id("customer.password");
    private By confirmPasswordField = By.id("repeatedPassword");
    private By registerButton = By.cssSelector("input[value='Register']");
    private By successMessage = By.cssSelector("h1");

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Fill form
    public void fillRegistrationForm() {
        driver.findElement(firstNameField).sendKeys(RandomUtils.generateRandomString(6));
        driver.findElement(lastNameField).sendKeys(RandomUtils.generateRandomString(8));
        driver.findElement(addressField).sendKeys("Street " + RandomUtils.generateRandomNumber(1, 100));
        driver.findElement(cityField).sendKeys("City " + RandomUtils.generateRandomString(4));
        driver.findElement(stateField).sendKeys("State " + RandomUtils.generateRandomString(3));
        driver.findElement(zipCodeField).sendKeys(String.valueOf(RandomUtils.generateRandomNumber(10000, 99999)));
        driver.findElement(phoneField).sendKeys(RandomUtils.generateRandomPhone());
        driver.findElement(ssnField).sendKeys(RandomUtils.generateRandomID());
        driver.findElement(usernameField).sendKeys(RandomUtils.generateRandomString(8));
        driver.findElement(passwordField).sendKeys("Pass " + RandomUtils.generateRandomString(6));
        driver.findElement(confirmPasswordField).sendKeys("Pass " + RandomUtils.generateRandomString(6));
    }

    // Submit form
    public void submitForm() {
        driver.findElement(registerButton).click();
    }

    // Success message
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}