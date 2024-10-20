package stepdefinitions;

import Pages.PreLoginHomePage;
import io.cucumber.java.en.*;

import static Utility.Hooks.driver;

public class preloginhomepage_stepDefinitions {

    PreLoginHomePage homePage= new PreLoginHomePage(driver);

    @Given("the user opens the Magento store homepage")
    public void the_user_opens_the_magento_store_homepage() {
        homePage.openPage();
    }

    @Given("the user should see the {string} link")
    public void the_user_should_see_the_link(String linkName) {
        homePage.verifyLink();
    }

    @Given("the user clicks on the {string} link")
    public void the_user_clicks_on_the_link(String linkname) throws InterruptedException {
        homePage.clicklink(linkname);
    }

    @Then("the user should see error message for {string} as {string}")
    public void the_user_should_see_error_message_for_as(String field, String message) {
        homePage.verifyErrorMessage(field,message);
    }

    @When("the user enters {string} as {string}")
    public void the_user_enters_as(String field, String value) {
        homePage.enterValue(field,value);
    }

    @Then("the user clears the {string} field")
    public void the_user_clears_the_field(String fieldName) {
       homePage.clearField(fieldName);
    }

    @Then("the user should see invalid login error message as {string}")
    public void the_user_should_see_invalid_login_error_message_as(String message) {
        homePage.verifyInvalidLoginMessage(message);
    }
}
