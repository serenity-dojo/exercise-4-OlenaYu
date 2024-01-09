package swaglabs.actions.navigation;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class NavigateActions extends UIInteractionSteps {
    public void toInventoryPage() {
        openUrl("https://www.saucedemo.com/inventory.html");
    }

    public void toTheShoppingCart() {
        $(".shopping_cart_link").click();
    }
}
