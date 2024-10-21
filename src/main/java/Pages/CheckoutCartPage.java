package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utility.DriverManager.scrollToView;
import static Utility.DriverManager.wait;
import static Utility.Hooks.driver;

public class CheckoutCartPage {

    @FindBy(xpath = "//input[@id='qty']")
    WebElement quantitytextbox;

    @FindBy(xpath ="//div[contains(@class,'message-')]//div")
    WebElement successMessage;

    @FindBy(xpath = "//strong[@class='summary title']")
    WebElement summary;

    @FindBy(xpath = "//*[@id='cart-totals']/div/table")
    WebElement cartTotals;

    @FindBy(xpath ="//*[@title='Proceed to Checkout' and @data-role='proceed-to-checkout']")
    WebElement proceedtoCheckout;

    public CheckoutCartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void checkButtonorIcon(String buttonText) {
        WebElement item=driver.findElement(By.xpath("//*[@title='"+buttonText+"'] | //button//span[text()='"+buttonText+"']"));        wait.until(ExpectedConditions.visibilityOf(item));
        scrollToView(item);
        item.isDisplayed();
        item.isEnabled();
    }

    public void clickonButtonorIcon(String buttonText) {
        WebElement item=driver.findElement(By.xpath("//*[@title='"+buttonText+"'] | //button//span[text()='"+buttonText+"']"));
        scrollToView(item);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", item);
    }

    public void changeQuantity(String n) {
        quantitytextbox.click();
        quantitytextbox.clear();
        quantitytextbox.sendKeys(n);
    }

    public void verifyMessage(String message) {
        scrollToView(successMessage);
        String actualmessage=successMessage.getText();
        System.out.println(actualmessage);
        Assert.assertTrue(actualmessage.contains(message));
    }

    public void checkSummery() {
        summary.isDisplayed();

    }

    public void checkCartTotalTable() {
    cartTotals.isDisplayed();
    }

    public void checkValue(String row, String value) {
        WebElement actual = driver.findElement(By.xpath("//th[text()='"+row+"']//parent::tr//td | //strong[text()='"+row+"']//parent::th//parent::tr/td/strong//span | //span[text()='"+row+"']//parent::th//parent::tr//td"));
        String actualvalue=actual.getText();
        Assert.assertEquals(actualvalue, value);
    }

    public void verifyCheckOutButton() {
        proceedtoCheckout.isDisplayed();
    }

    public void clickonCheckOut() {
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", proceedtoCheckout);
    }
}
