package swaglabs.stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import swaglabs.actions.catalog.CatalogItems;
import swaglabs.actions.login.LoginActions;
import swaglabs.model.UserCredentials;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepDefinitions {

    @DataTableType
    public UserCredentials userCredentials(Map<String, String> entry) {
        return new UserCredentials(entry.get("username"), entry.get("password"));
    }

    @Steps
    LoginActions login;

    @Steps
    CatalogItems catalogItems;

    @Given("Colin/he is on the login page")
    @When("Colin/he has logged on to the application")
    public void onTheLoginPage() {
        login.openTheLoginPage();
    }

    @When("Colin/he logs in with valid credentials")
    public void logsInWithValidCredentials() {
        login.withValidCredentials();
    }

    @Then("Colin/he should be presented the product catalog")
    public void shouldBeOnHomePage() {
        assertThat(catalogItems.itemNames()).isNotEmpty();
    }

    public void logged_on_to_the_application() {
        // TODO: Implement me
    }

    /**
     * Logon to the application if the user is not already logged on
     */
    @Given("Colin/he has logged onto the application")
    public void aRegisteredUser() {
        // TODO: Implement me
    }

    @When("Colin/he attempts to login with the following credentials:")
    public void attemptsToLoginWithTheFollowingCredentials(UserCredentials userCredentials) {
        // TODO: Implement me
    }

    @Then("Colin/he should be presented with the error message {}")
    public void heShouldBePresentedWithTheErrorMessageMessage(String errorMessage) {
        // TODO: Implement me
    }
}
