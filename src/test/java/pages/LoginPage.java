package pages;

import com.victoria.parabank.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("input[value='Log In']");
    private final By errorMessage = By.cssSelector("#rightPanel .error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        elementUtils.type(usernameField, username);
        elementUtils.type(passwordField, password);
        elementUtils.click(loginButton);
    }

    public String getLoginErrorMessage() {
        return elementUtils.getText(errorMessage);
    }

    public boolean isLoginFormVisible() {
        return waitUtils.waitForVisible(usernameField).isDisplayed()
                && waitUtils.waitForVisible(passwordField).isDisplayed();
    }
}