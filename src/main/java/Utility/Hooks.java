package Utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.createAndGetDriver();
    }

    @After
    public void takeScreenShot() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File file = new File("target/screenshot.png");
        try {
            FileHandler.copy(srcFile, file);
            System.out.println("Screenshot saved: " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
