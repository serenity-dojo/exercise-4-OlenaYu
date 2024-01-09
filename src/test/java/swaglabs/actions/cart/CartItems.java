package swaglabs.actions.cart;

import net.serenitybdd.core.steps.UIQuerySteps;
import swaglabs.model.CheckoutItem;
import swaglabs.model.TotalItemPrice;

import java.util.List;
import java.util.stream.Collectors;

public class CartItems extends UIQuerySteps {
    public List<String> itemNames() {
        return findAll(".inventory_item_name").texts();
    }

    public List<CheckoutItem> items() {
        return findAll(".cart_item")
                .stream()
                .map(row -> new CheckoutItem(
                                Integer.parseInt(row.findBy(".cart_quantity").getText()),
                                row.findBy(".inventory_item_name").getText(),
                                row.findBy(".inventory_item_price").getText()
                        )
                ).collect(Collectors.toList());
    }

    public TotalItemPrice totalItemPrice() {
        return new TotalItemPrice(
                $(".summary_subtotal_label").getText().split(": ")[1],
                $(".summary_tax_label").getText().split(": ")[1],
                $(".summary_total_label").getText().split(": ")[1]
        );
    }
}
