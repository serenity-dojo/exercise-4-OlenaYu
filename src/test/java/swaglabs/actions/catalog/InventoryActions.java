package swaglabs.actions.catalog;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.Link;
import net.serenitybdd.screenplay.ui.PageElement;
import org.openqa.selenium.By;

import java.time.Duration;

public class InventoryActions extends UIInteractionSteps {

        @Step("Add {0} to the cart")
        public void addToCart(String item) {
            $(Button.withText("Add to cart").inside(inventoryItemWithName(item))).click();
        }
        //Extracted from AddToCart() method to make it more readable
        private SearchableTarget inventoryItemWithName(String item) {
            return PageElement.locatedBy(".inventory_item").containingText(item);
        }
        @Step("Remove {0} from the cart")
        public void removeItemFromTheCart(String item) {
            $(Button.withText("Remove")
                    .inside(inventoryItemWithName(item))).click();
        }
        @Step("Open Product Details page for {0}")
        public void openProductDetailsFor(String productName) {
            //$("img[alt='" + productName + "']").click();
            $(Link.withText(productName)).click();
        }
    public void selectedTheItem() {
            find(By.id("add-to-cart-sauce-labs-backpack")).click();
    }
}

