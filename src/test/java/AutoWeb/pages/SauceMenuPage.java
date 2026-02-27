package AutoWeb.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class SauceMenuPage extends PageObject {

    private final By btnMenu = By.id("react-burger-menu-btn");
    private final By btnLogout = By.id("logout_sidebar_link");
    private final By btnResetApp = By.id("reset_sidebar_link");
    private final By btnCloseMenu = By.id("react-burger-cross-btn");

    public void openMenu() {
        $(btnMenu).waitUntilClickable().click();
    }

    public void clickLogout() {
        $(btnLogout).waitUntilClickable().click();
    }

    public void clickResetAppState() {
        $(btnResetApp).waitUntilClickable().click();
    }

    public void closeMenu() {
        $(btnCloseMenu).waitUntilClickable().click();
    }
}
