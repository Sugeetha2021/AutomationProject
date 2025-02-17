package com.techninja.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.techninja.qa.base.Baseclass;



public class search extends Baseclass{
	
	public search() {
		super();
	}
	
    WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver= initializeBrowserAndOpenAppURL(prop.getProperty("browser"));
		driver.findElement(By.xpath("//span[normalize-space(text())='My Account']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//a[normalize-space(text())='Login']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
	}
	
	
	@AfterMethod
	public void tearDown() {
		
	driver.quit();
}
	
	@Test (priority=1)
	public void verifysearchWithValidProducts() {
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validSearch"));
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space(text())='HP LP3065']")).isDisplayed(),"Valid product HP is not displayed");
}
	@Test (priority=2)
	public void verifysearchWithInValidProducts() {
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("invalidSearch"));
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		String actualSearchMessage = driver.findElement(By.xpath("//p[normalize-space(text())='There is no product that matches the search criteria.']")).getText();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductWarning"),"No such products in search results is displayed");
}
	@Test (priority=3)
	public void VerifySearchWithoutAnyProcuct() {		
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		String actualSearchMessage = driver.findElement(By.xpath("//p[normalize-space(text())='There is no product that matches the search criteria.']")).getText();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductWarning") ,"No such products in search results is displayed");
	}
	}

