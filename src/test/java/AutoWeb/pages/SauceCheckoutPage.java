package AutoWeb.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class SauceCheckoutPage extends PageObject {

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By completeMessage = By.className("complete-header");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");
    private final By errorContainer = By.className("error-message-container");

    public void enterFirstName(String firstName) {
        $(this.firstName).waitUntilClickable().type(firstName);
    }

    public void enterLastName(String lastName) {
        $(this.lastName).waitUntilClickable().type(lastName);
    }

    public void enterPostalCode(String postalCode) {
        $(this.postalCode).waitUntilClickable().type(postalCode);
    }

    public void clickContinue() {
        $(continueButton).waitUntilClickable().click();
    }

    public void clickFinish() {
        $(finishButton).waitUntilClickable().click();
    }

    public String getCompleteMessage() {
        return $(completeMessage).waitUntilVisible().getText();
    }

    public String getErrorMessage() {
        return $(errorMessage).waitUntilVisible().getText();
    }
}
