package swaglabs.stepdefinitions;

import com.google.common.base.Splitter;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.jetbrains.annotations.NotNull;
import swaglabs.actions.cart.CartActions;
import swaglabs.actions.cart.CartItems;
import swaglabs.actions.catalog.CatalogItems;
import swaglabs.actions.catalog.InventoryActions;
import swaglabs.actions.catalog.ProductDetailsActions;
import swaglabs.actions.checkout.CheckoutActions;
import swaglabs.actions.login.LoginActions;
import swaglabs.model.CustomerDetails;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CartStepDefinitions {

    /**
     * Add an item on the catalog page to the cart
     */
    @Steps
    LoginActions login;
    @Steps
    InventoryActions inventoryActions;
    @Steps
    CatalogItems catalog;
    @Steps
    CartActions cartActions;
    @Steps
    CartItems cartItems;
    @Steps
    ProductDetailsActions productDetailsActions;
    @Steps
    CheckoutActions checkoutActions;

    @Given("Colin has logged into the application")
    public void colinIsLoggedInToTheApplication (){
        login.openTheLoginPage();
        login.withValidCredentials();
    }

    @When("Colin/he adds {string} to the cart")
    public void colinAddsToTheCart(String item) {
        // TODO: Implement me
    }

    @ParameterType(".*")
    public List<String> items(String itemList) {
        return Splitter.on(",").trimResults().splitToList(itemList);
    }
    /*
     addsItemsToTheCart() takes a list of product items as a parameter. The trick here is to imagine an
     InventoryActions class, where you can create an addToCart() method that will click on the
      "Add to cart" button for a given item
     */
    @Given("Colin/he has the following item(s) in his/her cart:")
    @When("Colin adds the following items to the cart: {items}")
    public void addsItemsToTheCart(List<String> items) {
        for (String item : items) {
            inventoryActions.addToCart(item);
            System.out.println(items);
        }
    }

    @When("Colin/he adds this item to the cart")
    public void colinAddsTheCurrentItemTheCart() {
        productDetailsActions.addCurrentItemToTheCart();
        }

  //Checks the number that appears in the cart icon at the top of the screen
    @Then("the cart item count should be {int}")
    public void theCartItemCountShouldBe(int itemCount) {
        assertThat(catalog.shoppingCartBadge()).contains(Integer.toString(itemCount));
    }

    @Then("Colin/he should see the item/items he/she selected in the cart")
    public void shouldSeeItemsHeSelected(List<String> addedItems) {
        assertThat(cartItems.itemsInTheCart().contains(addedItems));
        System.out.println(addedItems);
    }

    @When("Colin/he removes {string} from the cart")
    public void heRemovesFromTheCart(String item) {
        inventoryActions.removeItemFromTheCart(item);
    }

    @When("Colin/he removes {string} from the cart summary")
    public void heRemovesFromTheCartSummary(String item) {
        cartActions.removeItemFromTheCart(item);
    }

    /**
     * Different ways to open the shopping cart
     */
    @Given("Colin/he has opened the shopping cart")
    @Given("Colin/he views his shopping cart")
    @When("Colin/he opens the shopping cart")
    public void opensCart() {
        cartActions.openTheShoppingCart();
    }

    @When("Colin/he reviews his order")
    public void reviewOrder() {
        cartActions.openTheShoppingCart();
        cartActions.startCheckout();
        checkoutActions.enterCustomerDetails(CustomerDetails.about("Colin"));


    }

    @When("Colin/he continues shopping")
    public void continuesShopping() {
        // TODO: Implement me
    }


    @Then("Colin/he should see the following items:")
    public void shouldSeeTheFollowingItems(List<String> expectedItems) {
        assertThat(cartItems.itemsInTheCart().contains(expectedItems));
        //System.out.println(expectedItems);
    }

    @DataTableType
    public CustomerDetails customer(Map<String, String> customer) {
        return new CustomerDetails(customer.get("First Name"), customer.get("Last Name"), customer.get("Zip/Post Code"));
    }

    @When("Colin/he provides the following personal details:")
    public void heProvidesTheFollowingDetails(CustomerDetails customerDetails) {
        checkoutActions.enterCustomerDetails(customerDetails);
    }
    @And("he has no items in his cart")
    public void heHasNoItemsInHisCart() {
            cartActions.cleanTheCart();
        }
    }

