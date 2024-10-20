package stepdefinitions;

import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static Utility.Hooks.driver;

public class LoginPageStepDefinitions {
    LoginPage loginPage=new LoginPage(driver);
    @When("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        loginPage.verifyPage();
    }

    @Then("^the user should see the \"([^\"]*)\" (textbox|button)$")
    public void the_user_should_see_the_textbox(String field,String type) {
        loginPage.verifyFields(field,type);
    }

    @When("the user enters valid login credentials")
    public void the_user_enters_valid_login_credentials(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> credentials = data.get(0);
        String username = credentials.get("Username");
        String password = credentials.get("Password");
        loginPage.enterCredentials(username,password);

    }
    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String signIn) {
        loginPage.clickOnButton(signIn);

    }

}
