package Pages;

import Utility.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utility.DriverManager.scrollToView;
import static Utility.DriverManager.wait;
import static Utility.Hooks.driver;

public class PreLoginHomePage {
    @FindBy(xpath = "//header//ul//li[@class='authorization-link']//a[contains(text(),'Sign In')]")
    private WebElement signInLink;

    @FindBy(xpath = "//*[@id='email-error']")
    WebElement emailError;

    @FindBy(xpath = "//*[@id='pass-error']")
    WebElement passError;

    @FindBy(xpath = "//div[contains(@data-bind,'prepareMessage')]")
    WebElement prepareMessage;

    public PreLoginHomePage(WebDriver driver) {
        PageFactory.initElements(Hooks.driver, this);
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

    public void verifyErrorMessage(String field, String message) {
        if(field.equals("email")) {
            Assert.assertEquals(message, emailError.getText());
        } else if (field.equals("password")) {
            Assert.assertEquals(message, passError.getText());
        }
    }

    public void enterValue(String field, String value) {
        WebElement element= driver.findElement(By.xpath("//*[@type='"+field+"']"));
        element.clear();
        element.sendKeys(value);
    }

    public void clearField(String fieldName) {
        WebElement element= driver.findElement(By.xpath("//*[@type='"+fieldName+"']"));
        element.clear();
    }

    public void verifyInvalidLoginMessage(String message) {
        scrollToView(prepareMessage);
        Assert.assertEquals(message, prepareMessage.getText());
    }
}
