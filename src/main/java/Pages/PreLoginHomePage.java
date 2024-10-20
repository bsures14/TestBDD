package Pages;

import Utility.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utility.DriverManager.wait;
import static Utility.Hooks.driver;

public class PreLoginHomePage {
    @FindBy(xpath = "//header//ul//li[@class='authorization-link']//a[contains(text(),'Sign In')]")
    private WebElement signInLink;

    public PreLoginHomePage(WebDriver driver) {
        PageFactory.initElements(Hooks.driver, this); // Initialize PageFactory elements
    }

    public void openPage() {
        driver.get("https://magento.softwaretestingboard.com");
        Assert.assertTrue(driver.getTitle().contains("Home Page"));
    }

    public void verifyLink() {
            Assert.assertTrue(signInLink.isDisplayed());
    }

    public void clicklink(String link) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(signInLink)).click();
        Thread.sleep(2000);
    }
}
