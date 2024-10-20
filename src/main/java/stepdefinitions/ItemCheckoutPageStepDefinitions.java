package stepdefinitions;

import Pages.ItemCheckOutPage;
import io.cucumber.java.en.Then;

import static Utility.Hooks.driver;

public class ItemCheckoutPageStepDefinitions {
    ItemCheckOutPage itemCheckOutPage=new ItemCheckOutPage(driver);

    @Then("the user should see checkout page")
    public void the_user_should_see_checkout_page() {
        itemCheckOutPage.verifyPage();
    }

    @Then("the user should see Order Summary")
    public void the_user_should_see_order_summary() {
        itemCheckOutPage.verifyorderSummary();

    }

    @Then("the user should see the ShippingAddress")
    public void the_user_should_see_the_shipping_address() {
        itemCheckOutPage.verifyAddresslabel();
    }

    @Then("the user should fill the Address details")
    public void the_user_should_fill_the_address_details(io.cucumber.datatable.DataTable dataTable) {
        itemCheckOutPage.fillAddressDetails(dataTable);
    }

    @Then("the user should see {string} items in cart")
    public void the_user_should_see_items_in_cart(String count) {
        itemCheckOutPage.checkItemCount(count);
    }

    @Then("the use should see paymentMethod")
    public void the_use_should_see_payment_method() {
        itemCheckOutPage.checkPaymentlabel();
    }

    @Then("the user see {string}")
    public void the_user_see(String message) throws InterruptedException {
        itemCheckOutPage.checkSuccessMessage(message);
    }

    @Then("the user see the orderid")
    public void the_user_see_the_orderid() {
        itemCheckOutPage.verifyOrderID();
    }

}
