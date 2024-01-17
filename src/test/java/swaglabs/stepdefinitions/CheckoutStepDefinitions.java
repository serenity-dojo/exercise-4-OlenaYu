package swaglabs.stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import swaglabs.actions.cart.CartActions;
import swaglabs.actions.cart.CartItems;
import swaglabs.actions.catalog.InventoryActions;
import swaglabs.actions.checkout.CheckoutActions;
import swaglabs.actions.navigation.NavigateActions;
import swaglabs.model.CheckoutItem;
import swaglabs.model.CustomerDetails;
import swaglabs.model.TotalItemPrice;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class CheckoutStepDefinitions {
    @Steps
    InventoryActions inventoryActions;
    @Steps
    NavigateActions navigate;
    @Steps
    CartActions cartActions;
    @Steps
    CheckoutActions checkout;
    @Steps
    CartItems cartItems;

    /**
     * The present tense tells us this is something Colin is doing now
     */
    @When("Colin/he checks out his cart")
    public void colinInitiatesCheckout() {
        // TODO: Implement me
    }

    /**
     * The past tense tells us we are setting up state, so Colin has added some items to his cart and has checkted them out
     */
    @And("Colin/he has selected an item and checked out his cart")
    public void colinHasCheckedOutHisCart() {
        inventoryActions.addToCart("Sauce Labs Backpack");
        navigate.toTheShoppingCart();
        cartActions.startCheckout();
    }

    /**
     * Open the checkout page and enter customer personal details
     */
    //about() method lets you generate test data for a given customer, e.g.
    @When("Colin/he checks out his cart providing his personal details")
    public void checksOutWithPersonalDetails() {
        navigate.toTheShoppingCart();
        cartActions.startCheckout();
        checkout.enterCustomerDetails(CustomerDetails.about("Colin"));
    }

    @When("Colin/he checks out the following items:")
    public void checksOutItems(List<CheckoutItem> items) {
        // TODO: Implement me
    }

    @When("Colin/he confirms his order")
    public void confirmsOrder() {
        checkout.confirmTheOrder();

    }

    @Then("Colin/he should be informed {string}")
    public void shouldBeInformedThat(String message) {
        assertThat(checkout.confirmationMessage()).contains(message);
    }

    @DataTableType
    public CheckoutItem product(Map<String, String> itemDetails) {
        return new CheckoutItem(
                Integer.parseInt(itemDetails.get("Qty")),
                itemDetails.get("Description"),
                itemDetails.get("Price"));
    }

    @DataTableType
    public TotalItemPrice itemPriceTotal(Map<String, String> itemTotals) {
        return new TotalItemPrice(
                itemTotals.get("Item total"),
                itemTotals.get("Tax"),
                itemTotals.get("Total"));
    }
    //we need to read the rows in the Your Cart page and compare them to the table that Cucumber provides
    @Then("Colin/he should be presented with a summary of his purchase including:")
    public void presentSummaryOfPurchases(List<CheckoutItem> expectedItems) {
        assertThat(cartItems.items()).containsExactlyElementsOf(expectedItems);
    }

    /**
     * Check the total price details displayed on the checkout confirmation page
     */
    @And("the total price should be:")
    public void totalPriceShouldBe(TotalItemPrice expectedPrices) {
        assertThat(cartItems.totalItemPrice()).contains(expectedPrices);

    }
}

