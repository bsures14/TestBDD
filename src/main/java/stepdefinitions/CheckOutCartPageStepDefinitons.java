package stepdefinitions;

import Pages.CheckoutCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static Utility.Hooks.driver;

public class CheckOutCartPageStepDefinitons {
    CheckoutCartPage checkoutCartPage = new CheckoutCartPage(driver);

    @And("the user should see the {string} Button/icon/Textbox")
    public void the_user_should_see_the_button_icon(String buttonText) {
        checkoutCartPage.checkButtonorIcon(buttonText);
    }

    @Then("the user clicks on the {string} button/icon")
    public void the_user_clicks_on_the_icon(String button) {
        checkoutCartPage.clickonButtonorIcon(button);
    }

    @Then("user enters {string} in quantity textbox")
    public void user_enters_in_quantity_textbox(String qty) {
        checkoutCartPage.changeQuantity(qty);
    }

    @Then("user should see {string} message")
    public void user_should_see_message(String message) {
        checkoutCartPage.verifyMessage(message);
    }

    @Then("the user should see order summery in checkout cart")
    public void the_user_should_see_order_summery_in_checkout_cart() {
        checkoutCartPage.checkSummery();
    }

    @Then("the user should see the cart total table in checkout cart")
    public void the_user_should_see_the_cart_total_table_in_checkout_cart() {
       checkoutCartPage.checkCartTotalTable();
    }

    @Then("the user should {string} as {string} in table")
    public void the_user_should_as_in_table(String row, String value) {
        checkoutCartPage.checkValue(row,value);
    }
    @Then("the user should see the Proceed to Checkout Button")
    public void the_user_should_see_the_proceed_to_checkout_button() {
        checkoutCartPage.verifyCheckOutButton();
    }

    @Then("the user clicks on the Proceed to Checkout button")
    public void the_user_clicks_on_the_proceed_to_checkout_button() {
        checkoutCartPage.clickonCheckOut();
    }

}


