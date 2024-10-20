package Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static Utility.DriverManager.scrollToView;
import static Utility.DriverManager.wait;
import static Utility.Hooks.driver;

public class PostLoginHomePage {
    @FindBy(xpath = "//header//div[1]/div/ul[contains(@class,'header')]/li[@class='greet welcome'][1]/span[@class='logged-in']")
    WebElement headermessage;

    @FindBy(xpath = "//span[text()='My Cart']//parent::a")
    WebElement myCart;

    public PostLoginHomePage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

    public void verifyDashboardPage() {
        Assert.assertTrue(driver.getTitle().contains("Home Page"));
    }

    public void verifyMessage(String message) {
        String actualmessage=headermessage.getText();
        Assert.assertEquals(message,actualmessage);
    }

    public void verifylinkText(String linkName) {
        WebElement link=driver.findElement(By.xpath("//span[text()='"+linkName+"']//parent::a"));
        scrollToView(link);
        Assert.assertTrue(link.isDisplayed());
    }

    public void clickLink(String linkName) {
        WebElement link=driver.findElement(By.xpath("//span[text()='"+linkName+"']//parent::a"));
        link.click();
    }

    public void clickSection(String itemName) {
        List<WebElement> items=driver.findElements(By.xpath("//*[@id='narrow-by-list2']/dd/ol/li/a"));
        for(WebElement item:items) {
            scrollToView(item);
            if(item.getText().equals(itemName)) {
                item.click();
            }
        }

    }

    public void verifyHeading(String expectedHeading) {
        String actualHeading=driver.findElement(By.xpath("//*[@id='page-title-heading']/span")).getText();
        Assert.assertEquals(expectedHeading,actualHeading);
    }

    public void clickOnFilter(String filter) {
        WebElement filterTitle=driver.findElement(By.xpath("//div[contains(@class, 'filter') and contains(text(), '"+filter+"')]"));
        scrollToView(filterTitle);
        filterTitle.click();
    }

    public void clickOnFilterItem(String filterItem) {
        WebElement filterItemValue=driver.findElement(By.xpath("//a[contains(text(),'"+filterItem+"')]"));
        filterItemValue.click();
    }

    public void checkItem(String itemName) {
        WebElement item=driver.findElement(By.xpath("//img[@alt='"+itemName+"' and not(@data-bind)]"));
        scrollToView(item);
        item.isDisplayed();
    }

    public void checkCartButton(String button, String item) {
        WebElement addtoCartButton=driver.findElement(By.xpath("//a[contains(text(), '"+item+"')]//parent::strong//parent::div//following-sibling::div[@class='actions-primary']//form//button//span[text()='"+button+"']"));
        addtoCartButton.isDisplayed();

    }

    public void clickCartButton(String button, String item) {
        WebElement addtoCartButton=driver.findElement(By.xpath("//a[contains(text(), '"+item+"')]//parent::strong//parent::div//following-sibling::div[@class='actions-primary']//form//button"));
        Actions action=new Actions(driver);
        action.moveToElement(addtoCartButton);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",addtoCartButton);
        //addtoCartButton.click();
    }

    public void clickCartIcon() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(myCart));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",myCart);
    }

    public void moveToItem(String itemName) {
        WebElement item=driver.findElement(By.xpath("//img[@alt='"+itemName+"']"));
        Actions action=new Actions(driver);
        action.moveToElement(item);
    }
}

