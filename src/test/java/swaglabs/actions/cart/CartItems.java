package swaglabs.actions.cart;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import swaglabs.model.CheckoutItem;
import swaglabs.model.TotalItemPrice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CartItems extends UIInteractionSteps {
    //returns a list of checked out itemsInTheCart
    public List<String> itemsInTheCart() {
        return $$(".inventory_item_name").texts();
    }

    public List<CheckoutItem> items() {
        List<CheckoutItem> items = new ArrayList<>();
        for(WebElementFacade row : findAll(".cart_item")) {
            int quantity = Integer.parseInt(row.findBy(".cart_quantity").getText());
            String name = row.findBy(".inventory_item_name").getText();
            String price = row.findBy(".inventory_item_price").getText();
            items.add(new CheckoutItem (quantity, name, price));
        } return items;
    }

    public List<TotalItemPrice> totalItemPrice() {
        List<TotalItemPrice> priceTotal = new ArrayList<>();
            String itemTotal = $(".summary_subtotal_label").getText()
                    .replaceAll("Item total: ", "" );
            String tax = $(".summary_tax_label").getText()
                    .replaceAll("Tax: ", "" );
            String total = $(".summary_total_label")
                    .getText().replaceAll("Total: ", "" );

            priceTotal.add(new TotalItemPrice (itemTotal, tax, total));
        return priceTotal;
    }

    }
    //An alternative solution using Java 8 streams might look like this:

//    public List<CheckoutItem> items() {
//        return findAll(".cart_item")
//                .stream()
//                .map(row -> new CheckoutItem(
//                                Integer.parseInt(row.findBy(".cart_quantity").getText()),
//                                row.findBy(".inventory_item_name").getText(),
//                                row.findBy(".inventory_item_price").getText()
//                        )
//                ).collect(Collectors.toList());
//    }

