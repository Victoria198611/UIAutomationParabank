package pages;

import com.victoria.parabank.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenAccountPage extends BasePage {

    private final By accountTypeDropdown = By.id("type");
    private final By fromAccountDropdown = By.id("fromAccountId");
    private final By openNewAccountButton = By.cssSelector("input[value='Open New Account']");
    private final By confirmationMessage = By.cssSelector("#rightPanel p");

    public OpenAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select account type: {type}")
    public void selectTypeAccount(String type) {

        WebElement dropdown = waitUtils.waitForVisible(accountTypeDropdown);

        if (type.equalsIgnoreCase("CHECKING")) {
            dropdown.findElement(By.cssSelector("option[value='0']")).click();
        } else if (type.equalsIgnoreCase("SAVINGS")) {
            dropdown.findElement(By.cssSelector("option[value='1']")).click();
        }

        // Wait for Parabank to load accounts after selecting type
        waitUtils.waitForVisible(fromAccountDropdown);
    }

    @Step("Get number of available accounts in dropdown")
    public int getAvailableAccountsCount() {
        WebElement dropdown = waitUtils.waitForVisible(fromAccountDropdown);
        return dropdown.findElements(By.tagName("option")).size();
    }

    @Step("Select account at index {index}")
    public void selectFromAccount(int index) {
        WebElement dropdown = waitUtils.waitForVisible(fromAccountDropdown);
        dropdown.findElements(By.tagName("option")).get(index).click();
    }

    @Step("Click 'Open New Account' button")
    public void clickOpenAccount() {
        waitUtils.waitForClickable(openNewAccountButton).click();
    }

    @Step("Get confirmation message after opening account")
    public String getConfirmationMessage() {
        return waitUtils.waitForVisible(confirmationMessage).getText().trim();
    }
}