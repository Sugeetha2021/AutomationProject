package com.techninja.qa.testcases;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.FileHandler;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;


public class AlertHandlingTest {
    
	WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       
       }

    
    @Test(priority = 1)
    public void handleSimpleAlert() {
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Simple Alert Text: " + alert.getText());
        Assert.assertEquals(alert.getText(), "I am a JS Alert");  // Verify alert text
        alert.accept();  // Click OK
    }

    @Test(priority = 2)
    public void handleConfirmationAlert() {
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Confirmation Alert Text: " + alert.getText());
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");  // Verify alert text
        alert.dismiss();  // Click Cancel
    }

    @Test(priority = 3)
    public void handlePromptAlert() {
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Prompt Alert Text: " + alert.getText());
        alert.sendKeys("Hello, TestNG!");  // Enter text in prompt
        alert.accept();  // Click OK
    }
    
    

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}