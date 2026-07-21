package pages;

import com.victoria.parabank.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateProfilePage extends BasePage {

    private final By firstName = By.id("customer.firstName");
    private final By lastName = By.id("customer.lastName");
    private final By address = By.id("customer.address.street");
    private final By city = By.id("customer.address.city");
    private final By state = By.id("customer.address.state");
    private final By zip = By.id("customer.address.zipCode");
    private final By updateButton = By.cssSelector("input[value='Update Profile']");

    // Confirmation message locator
    private final By confirmationMessage = By.cssSelector("#rightPanel .title");

    public UpdateProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Update profile with: {fn}, {ln}, {addr}, {cityVal}, {stateVal}, {zipVal}")
    public void updateProfile(String fn,
                              String ln,
                              String addr,
                              String cityVal,
                              String stateVal,
                              String zipVal) {

        waitUtils.waitForVisible(firstName).clear();
        waitUtils.waitForVisible(firstName).sendKeys(fn);

        waitUtils.waitForVisible(lastName).clear();
        waitUtils.waitForVisible(lastName).sendKeys(ln);

        waitUtils.waitForVisible(address).clear();
        waitUtils.waitForVisible(address).sendKeys(addr);

        waitUtils.waitForVisible(city).clear();
        waitUtils.waitForVisible(city).sendKeys(cityVal);

        waitUtils.waitForVisible(state).clear();
        waitUtils.waitForVisible(state).sendKeys(stateVal);

        waitUtils.waitForVisible(zip).clear();
        waitUtils.waitForVisible(zip).sendKeys(zipVal);

        waitUtils.waitForClickable(updateButton).click();
    }

    @Step("Get profile update confirmation message")
    public String getConfirmationMessage() {
        return waitUtils.waitForVisible(confirmationMessage).getText().trim();
    }
}