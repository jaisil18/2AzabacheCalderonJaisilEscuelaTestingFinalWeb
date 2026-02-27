package AutoWeb.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.saucedemo.com/")
public class SauceLoginPage extends PageObject {

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public void enterUsername(String username) {
        $(usernameField).waitUntilClickable().type(username);
    }

    public void enterPassword(String password) {
        $(passwordField).waitUntilClickable().type(password);
    }

    public void clickLoginButton() {
        $(loginButton).waitUntilClickable().click();
    }

    public String getErrorMessage() {
        return $(errorMessage).waitUntilVisible().getText();
    }

    public boolean isLoginButtonVisible() {
        return $(loginButton).waitUntilVisible().isCurrentlyVisible();
    }
}
