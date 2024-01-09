package swaglabs.stepdefinitions;

import com.google.common.base.Splitter;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swaglabs.model.CustomerDetails;

import java.util.List;
import java.util.Map;

public class CartStepDefinitions {

    /**
     * Add an item on the catalog page to the cart
     */
    @When("Colin/he adds {string} to the cart")
    public void colinAddsToTheCart(String item) {
        // TODO: Implement me
    }

    @ParameterType(".*")
    public List<String> items(String itemList) {
        return Splitter.on(",").trimResults().splitToList(itemList);
    }

    @When("Colin/he adds the following items to the cart: {items}")
    public void addsItemsToTheCart(List<String> items) {
        // TODO: Implement me
    }

    @When("Colin/he adds this item to the cart")
    public void colinAddsTheCurrentItemTheCart() {
        // TODO: Implement me
    }

    @Then("the cart item count should be {int}")
    public void theCartItemCountShouldBe(int itemCount) {
        // TODO: Implement me
    }

    @And("Colin/he has the following item(s) in his/her cart:")
    public void addedTheFollowingItemsToTheCart(List<String> items) {
        // TODO: Implement me
    }

    @And("Colin/he has no items in his/her cart")
    public void addedTheFollowingItemsToTheCart() {
        // TODO: Implement me
    }

    @Then("Colin/he should see the item/items he/she selected in the cart")
    public void shouldSeeItemsHeSelected() {
        // TODO: Implement me

    }

    @When("Colin/he removes {string} from the cart")
    public void heRemovesFromTheCart(String item) {
        // TODO: Implement me
    }

    @When("Colin/he removes {string} from the cart summary")
    public void heRemovesFromTheCartSummary(String item) {
        // TODO: Implement me
    }

    /**
     * Different ways to open the shopping cart
     */
    @Given("Colin/he has opened the shopping cart")
    @Given("Colin/he views his shopping cart")
    @When("Colin/he opens the shopping cart")
    public void opensCart() {
        // TODO: Implement me
    }

    @When("Colin/he reviews his order")
    public void reviewOrder() {

    }

    @When("Colin/he continues shopping")
    public void continuesShopping() {
        // TODO: Implement me
    }


    @Then("Colin/he should see the following items:")
    public void shouldSeeTheFollowingItems(List<String> expectedItems) {
        // TODO: Implement me
    }

    @DataTableType
    public CustomerDetails customer(Map<String, String> customer) {
        return new CustomerDetails(customer.get("First Name"), customer.get("Last Name"), customer.get("Zip/Post Code"));
    }

    @When("Colin/he provides the following personal details:")
    public void heProvidesTheFollowingDetails(CustomerDetails customerDetails) {
        // TODO: Implement me
    }
}

