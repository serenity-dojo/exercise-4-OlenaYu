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
        $(LoginForm.USERNAME).sendKeys("standard_user");
        $(LoginForm.PASSWORD).sendKeys("secret_sauce");
        $(LoginForm.LOGIN).click();
    }
}
