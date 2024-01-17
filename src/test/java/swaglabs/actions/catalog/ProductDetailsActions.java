package swaglabs.actions.catalog;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class ProductDetailsActions extends UIInteractionSteps {
    public void addCurrentItemToTheCart() {
        $("button[id*='add-to-cart']").click();
    }
}
