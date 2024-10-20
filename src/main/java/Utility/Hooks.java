package Utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Setting WebDriver");
        driver = DriverManager.createAndGetDriver();
    }

    @After
    public void quitDriver() {
        System.out.println("Quitting WebDriver");
 //      DriverManager.quitDriver();
    }
}
