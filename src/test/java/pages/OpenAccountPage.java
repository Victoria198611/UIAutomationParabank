package pages;

import com.victoria.parabank.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenAccountPage extends BasePage {

    private final By accountTypeDropdown = By.id("type");
    private final By accountTypeOptions = By.cssSelector("#type option");
    private final By fromAccountDropdown = By.id("fromAccountId");
    private final By fromAccountOptions = By.cssSelector("#fromAccountId option");
    private final By openNewAccountButton = By.cssSelector("input[value='Open New Account']");
    private final By confirmationMessage = By.cssSelector("#rightPanel p");

    public OpenAccountPage(WebDriver driver) {
        super(driver);
    }

    public void selectTypeAccount(String type) {

        // wait for dropdown + options
        waitUtils.waitForVisible(accountTypeDropdown);
        waitUtils.waitForVisible(accountTypeOptions);

        WebElement dropdown = driver.findElement(accountTypeDropdown);

        if (type.equalsIgnoreCase("CHECKING")) {
            dropdown.findElement(By.cssSelector("option[value='0']")).click();
        } else if (type.equalsIgnoreCase("SAVINGS")) {
            dropdown.findElement(By.cssSelector("option[value='1']")).click();
        }
    }

    public void selectFromAccount(int index) {

        // wait for dropdown + options
        waitUtils.waitForVisible(fromAccountDropdown);
        waitUtils.waitForVisible(fromAccountOptions);

        WebElement dropdown = driver.findElement(fromAccountDropdown);
        dropdown.findElements(By.tagName("option")).get(index).click();
    }

    public void clickOpenAccount() {
        elementUtils.click(openNewAccountButton);
    }

    public String getConfirmationMessage() {
        return elementUtils.getText(confirmationMessage);
    }
}