package swaglabs.actions.login;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginActions extends UIInteractionSteps {
    @Step
    public void openTheLoginPage() {
        openUrl("https://www.saucedemo.com/");
    }

    @Step("Login with valid credentials")
    public void withValidCredentials() {
        withCredentials("standard_user","secret_sauce");
    }

    public void withCredentials(String username, String password) {
        $(LoginForm.USERNAME).sendKeys(username);
        $(LoginForm.PASSWORD).sendKeys(password);
        $(LoginForm.LOGIN).click();
    }

    public String errorMessage() {
        return $(LoginForm.ERROR_MESSAGE).getText();
    }
}
