package swaglabs.actions.cart;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.ui.Button;
import org.openqa.selenium.WebElement;
import swaglabs.actions.catalog.CatalogItems;
import swaglabs.actions.navigation.NavigateActions;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CartActions extends UIInteractionSteps {
    @Steps
    CartItems cartItems;
    @Steps
    NavigateActions navigate;
    @Steps
    CatalogItems catalog;

    public void openTheShoppingCart() {
        $(".shopping_cart_link").click();
    }
    public void cleanTheCart() {
              if($(".shopping_cart_badge").isPresent()) {
                  navigate.toTheShoppingCart();
                  removeAllItemsFromCart();
                  navigate.toInventoryPage();
              }
    }

    private void removeAllItemsFromCart() {
            for (String item : itemsToRemove()) {
                removeItemFromTheCart(item);
            }
        }
    private List<String> itemsToRemove() {
        return cartItems.itemsInTheCart();
    }
    public void removeItemFromTheCart(String item) {
        String dynamicSelector = "#remove-" + item.toLowerCase().replace(" ", "-");
        $(dynamicSelector).click();
    }
    public void startCheckout() {
        $(Button.withText("Checkout")).click();
    }

}
