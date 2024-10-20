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
}
