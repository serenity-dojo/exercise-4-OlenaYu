package swaglabs.actions.checkout;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import swaglabs.model.CustomerDetails;

public class CheckoutActions extends UIInteractionSteps {
    /*
    Cucumber will pass empty values as null, and Selenium doesn't like null values very much,
    so it is a good idea to check for null before entering the value
    (Serenity 3.3.1 or higher will do this for you automatically)
     */
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
    public void confirmTheOrder() {
        $("#finish").click();
    }

    public String confirmationMessage() {
        return $(".complete-text").getText();
    }
}
