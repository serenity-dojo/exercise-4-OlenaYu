package swaglabs.actions.navigation;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

import java.time.Duration;

public class NavigateActions extends UIInteractionSteps {
    @Step("Navigate to Inventory page")
    public void toInventoryPage() {
        openUrl("https://www.saucedemo.com/inventory.html");
    }
    @Step("Navigate to the Shopping cart")
    public void toTheShoppingCart() {
        $(".shopping_cart_link").click();
    }
}
