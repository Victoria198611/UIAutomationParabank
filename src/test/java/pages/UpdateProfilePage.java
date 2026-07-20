package pages;

import com.victoria.parabank.base.BasePage;
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

    public UpdateProfilePage(WebDriver driver) {
        super(driver);
    }

    public void updateProfile(String fn, String ln, String addr, String cityVal, String stateVal, String zipVal) {
        elementUtils.type(firstName, fn);
        elementUtils.type(lastName, ln);
        elementUtils.type(address, addr);
        elementUtils.type(city, cityVal);
        elementUtils.type(state, stateVal);
        elementUtils.type(zip, zipVal);
        elementUtils.click(updateButton);
    }
}