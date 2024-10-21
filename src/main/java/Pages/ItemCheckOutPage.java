package Pages;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

import static Utility.DriverManager.scrollToView;
import static Utility.DriverManager.wait;
import static Utility.Hooks.driver;

public class ItemCheckOutPage {
    public ItemCheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='opc-sidebar']/div[1]/span")
    WebElement orderSummeryLabel;

    @FindBy(xpath = "//*[@id='shipping']/div[1]")
    WebElement addresslabel;

    @FindBy(xpath = "//span[contains(@data-bind,'CartSummary')]")
    WebElement cartItemCount;

    @FindBy(xpath = "//*[@id='checkout-payment-method-load']/div/div/div[1]")
    WebElement paymentMethodLabel;

    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    WebElement confirmMessage;

    @FindBy(xpath = "//a[@class='order-number']//strong")
    WebElement orderId;

    @FindBy(xpath = "//div[@class='shipping-address-item selected-item']")
    WebElement shippingAddress;

    public void fillAddressDetails(DataTable dataTable) {
        if(!shippingAddress.isDisplayed()) {//if addreess is pre populated it will ignore below steps
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            System.out.println(data);
            for (int i = 0; i < data.size(); i++) {
                Map<String, String> row = data.get(i);
                System.out.println(row);
                String field = row.get("field");
                String value = row.get("value");
                if (field.equalsIgnoreCase("State")) {
                    selectStatefromDropDown(value);

                } else if (field.equalsIgnoreCase("Country")) {
                    selectCountryFromDropDown(value);

                } else {
                    WebElement inputField = driver.findElement(By.name(field));
                    wait.until(ExpectedConditions.visibilityOf(inputField));
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", inputField);
                    inputField.clear();
                    inputField.sendKeys(value);
                }
            }
        }
    }

    private void selectCountryFromDropDown(String value) {
        WebElement dropdownElement = driver.findElement(By.name("country_id"));
         wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)).click();
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(value);
    }

    private void selectStatefromDropDown(String value) {
        WebElement dropdownElement = driver.findElement(By.name("region_id"));
        wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)).click();
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(value);
    }

    public void verifyAddresslabel() {
        addresslabel.isDisplayed();
    }

    public void verifyorderSummary() {
        scrollToView(orderSummeryLabel);
        orderSummeryLabel.isDisplayed();
    }

    public void verifyPage() {
        wait.until(ExpectedConditions.visibilityOf(orderSummeryLabel));
        Assert.assertEquals("Checkout",driver.getTitle() );

    }

    public void checkItemCount(String count) {
        Assert.assertEquals(count, cartItemCount.getText());
    }

    public void checkPaymentlabel() {
        scrollToView(paymentMethodLabel);
        paymentMethodLabel.isDisplayed();
    }

    public void checkSuccessMessage(String message) throws InterruptedException {
        Thread.sleep(10000);
        scrollToView(confirmMessage);
        String actualmessage=confirmMessage.getText();
        Assert.assertEquals(message, actualmessage);
    }

    public void verifyOrderID() {
        scrollToView(orderId);
        Assert.assertTrue(orderId.isDisplayed());
        System.out.println("Your Order ID="+orderId.getText());
    }
}
