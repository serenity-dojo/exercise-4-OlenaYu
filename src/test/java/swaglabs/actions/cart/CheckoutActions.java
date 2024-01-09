package swaglabs.actions.cart;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.ui.PageElement;
import net.thucydides.core.annotations.Step;
import swaglabs.model.CustomerDetails;

public class CheckoutActions extends UIInteractionSteps {

    @Step("Enter customer details {0}")
    public void enterCustomerDetails(CustomerDetails customerDetails) {
        if (customerDetails.firstName() != null) {
            $(InputField.withPlaceholder("First Name")).sendKeys(customerDetails.firstName());
        }
        if (customerDetails.lastName() != null) {
            $(InputField.withPlaceholder("Last Name")).sendKeys(customerDetails.lastName());
        }
        if (customerDetails.postCode() != null) {
            $(InputField.withPlaceholder("Zip/Postal Code")).sendKeys(customerDetails.postCode());
        }
        $(Button.withText("Continue")).click();
    }

    @Step("Confirm the order")
    public void confirmOrder() {
        $(Button.withText("Finish")).click();
    }
}
