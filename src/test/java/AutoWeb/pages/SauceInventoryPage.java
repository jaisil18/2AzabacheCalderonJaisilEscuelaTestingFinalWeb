package AutoWeb.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SauceInventoryPage extends PageObject {

    private final By title = By.className("title");
    private final By firstProductAddButton = By.cssSelector(".inventory_item:first-child button");
    private final By shoppingCartLink = By.className("shopping_cart_link");
    private final By productSortContainer = By.className("product_sort_container");
    private final By firstProductName = By.cssSelector(".inventory_item:first-child .inventory_item_name");
    private final By cartBadge = By.className("shopping_cart_badge");

    public String getTitle() {
        return $(title).getText();
    }

    public void addFirstProductToCart() {
        $(firstProductAddButton).waitUntilClickable().click();
    }

    public void addProductByName(String productName) {
        By addBtn = By.xpath("//div[contains(@class,'inventory_item_description') and .//div[text()='" + productName + "']]//button");
        $(addBtn).waitUntilClickable().click();
    }

    public void sortBy(String sortOption) {
        $(productSortContainer).waitUntilClickable();
        Select select = new Select($(productSortContainer));
        select.selectByVisibleText(sortOption);
    }

    public String getFirstProductName() {
        return $(firstProductName).getText();
    }

    public void clickShoppingCart() {
        $(shoppingCartLink).waitUntilClickable().click();
    }

    public boolean isCartBadgeVisible() {
        return $(cartBadge).isCurrentlyVisible();
    }
    
    public boolean isCartBadgePresent() {
        return $(cartBadge).isPresent();
    }
}
