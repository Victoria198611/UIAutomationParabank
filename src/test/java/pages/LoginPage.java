package pages;

import com.victoria.parabank.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("input[value='Log In']");

    // Locator corect pentru mesajul de eroare
    private final By errorMessage = By.cssSelector("p.error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login with username: {username} and password: {password}")
    public void login(String username, String password) {
        waitUtils.waitForVisible(usernameField).sendKeys(username);
        waitUtils.waitForVisible(passwordField).sendKeys(password);
        waitUtils.waitForClickable(loginButton).click();
    }

    @Step("Get login error message")
    public String getLoginErrorMessage() {
        // Parabank uneori întârzie cu mesajul → folosim waitForVisible
        return waitUtils.waitForVisible(errorMessage).getText().trim();
    }

    @Step("Check if login form is visible")
    public boolean isLoginFormVisible() {
        return waitUtils.waitForVisible(usernameField).isDisplayed()
                && waitUtils.waitForVisible(passwordField).isDisplayed();
    }
}