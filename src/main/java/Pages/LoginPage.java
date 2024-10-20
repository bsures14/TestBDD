package Pages;

import Utility.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.IDN;

import static Utility.DriverManager.scrollToView;
import static Utility.DriverManager.wait;
import static Utility.Hooks.driver;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(xpath = "//*[@title='Email']")
    WebElement emailtextbox;

    @FindBy(xpath="//*[@title='Password']")
    WebElement passwordtextbox;

    @FindBy(xpath="//button[@class='action login primary']/span[text()='Sign In']")
    WebElement signinbutton;

    public void verifyPage() {
        Assert.assertEquals(driver.getTitle(),"Customer Login");
    }

    public void verifyFields(String field,String type) {
        scrollToView(emailtextbox);
        if(field.equals("Email")) {
            emailtextbox.isDisplayed();
        }
        if(field.equals("Password")) {
            passwordtextbox.isDisplayed();
        }
        if(field.equals("SignInButton")&& type.equals("button")) {
            signinbutton.isDisplayed();
            signinbutton.isEnabled();
        }
    }


    public void enterCredentials(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(emailtextbox)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordtextbox)).sendKeys(password);
    }

    public void clickOnButton(String signIn) {
        wait.until(ExpectedConditions.visibilityOf(signinbutton)).click();
    }
}
