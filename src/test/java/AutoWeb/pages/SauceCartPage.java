package AutoWeb.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class SauceCartPage extends PageObject {

    private final By checkoutButton = By.cssSelector("[data-test='checkout']");
    private final By continueShoppingBtn = By.cssSelector("[data-test='continue-shopping']");
    private final By cartItems = By.className("cart_item");
    private final By cartTitle = By.className("title");

 
    private void waitForCartPage() {
        $(cartTitle).waitUntilVisible();
    }

    public void clickCheckout() {
        waitForCartPage();
        $(checkoutButton).waitUntilClickable().click();
    }

    public void clickContinueShopping() {
        waitForCartPage();
        $(continueShoppingBtn).waitUntilClickable().click();
    }

    /**
     * Elimina un producto del carrito por nombre.
     * El id del boton Remove sigue el formato: remove-{slug-del-nombre}
     * Ej: "Sauce Labs Bolt T-Shirt" → "remove-sauce-labs-bolt-t-shirt"
     */
    public void removeProductByName(String productName) {
        waitForCartPage();
        String slug = productName.toLowerCase().replace(" ", "-");
        By removeBtn = By.cssSelector("[data-test='remove-" + slug + "']");
        $(removeBtn).waitUntilClickable().click();
    }

    public boolean isCartEmpty() {
        waitForCartPage();
        return findAll(cartItems).isEmpty();
    }

    public int getCartItemsCount() {
        return findAll(cartItems).size();
    }
}
