package swaglabs.actions.catalog;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIQuerySteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * This is a UIQuerySteps class. It is just like a UIInteractionSteps class, but it is designed to contain methods
 * that query the state of the application.
 */
public class CatalogItems extends UIQuerySteps {
    public List<String> itemNames() {
        return findAll(".inventory_item_name").texts();
    }

    public String shoppingCartBadge() {
       return $(".shopping_cart_badge").getText();

    }
}
