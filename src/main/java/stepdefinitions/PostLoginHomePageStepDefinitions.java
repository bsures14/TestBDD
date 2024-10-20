package stepdefinitions;

import Pages.PostLoginHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Utility.Hooks.driver;

public class PostLoginHomePageStepDefinitions {
    PostLoginHomePage dashboard=new PostLoginHomePage(driver);
    @Then("the user should see a  {string} message")
    public void the_user_should_see_a_message(String message) {
        dashboard.verifyMessage(message);
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        dashboard.verifyDashboardPage();
    }

    @Then("the user should see the {string} link in dashboard")
    public void the_user_should_see_the_link_in_dashboard(String linkName) {
        dashboard.verifylinkText(linkName);
    }
    @Then("the user clicks on the {string} link in dashboard")
    public void the_user_clicks_on_the_link_in_dashboard(String linkName) {
        dashboard.clickLink(linkName);
    }

    @When("the user click on {string} section")
    public void the_user_click_on_section(String name) {
        dashboard.clickSection(name);

    }

    @Then("the user should see the {string} header")
    public void the_user_should_see_the_header(String name) {
        dashboard.verifyHeading(name);
    }

    @When("the user clicks on {string} filter")
    public void the_user_clicks_on_filter(String filterName) {
        dashboard.clickOnFilter(filterName);
    }

    @Then("the user clicks on the {string} link on filer")
    public void the_user_clicks_on_the_link_on_filer(String filterItem) {
        dashboard.clickOnFilterItem(filterItem);
    }


    @When("the user mouseover {string} item")
    public void the_user_mouseover_item(String itemName) {
        dashboard.checkItem(itemName);
    }

    @Then("the user should see {string} button for {string}")
    public void the_user_should_see_button_for(String button, String item) {
        dashboard.checkCartButton(button,item);
    }

    @Then("the user click on {string} button for {string}")
    public void the_user_click_on_button_for(String button, String item) {
        dashboard.clickCartButton(button,item);

    }

    @Then("the user click on cart icon")
    public void the_user_click_on_cart_icon() {
        dashboard.clickCartIcon();

    }
}
