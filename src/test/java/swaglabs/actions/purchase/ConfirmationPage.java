package swaglabs.actions.purchase;

import net.serenitybdd.core.pages.PageObject;

public class ConfirmationPage extends PageObject {
    public String thankYouMessage() {
        return $(".complete-text").getText();
    }
}
