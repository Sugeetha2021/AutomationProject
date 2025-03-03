package com.techninja.qa.testcases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.techninja.qa.base.Baseclass;
import com.techninja.qa.pageobject.AccountPage;
import com.techninja.qa.pageobject.HomePage;
import com.techninja.qa.pageobject.LoginPage;
import com.techninja.qa.utils.utilities;


public class Login extends Baseclass{
	
	LoginPage loginPage;
	
	public Login() {
		super();
	}
	
	
    WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		//loadPropertiesFile();
		driver= initializeBrowserAndOpenAppURL(prop.getProperty("browser"));
		HomePage homePage =new HomePage(driver);
		homePage.clickOnMyAccount();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		loginPage = homePage.selectLoginOption();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
	}
	
	
	@AfterMethod
	public void tearDown() {
		
	driver.quit();
}
	
	@Test(priority=1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentilas(String Email,String Password) {
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		loginPage.enterEmailAddress(Email);
		loginPage.enterPassword(Password);
		AccountPage accountPage = loginPage.clickOnLoginButton();
		//Optimizing the code by reducing the line
		//AccountPage accountPage =new AccountPage (driver);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInfo(),"Edit your account information link is not displayed");
		//Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed());
		//Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space(text())='Edit your account information']")).isDisplayed(),"Edit your account information link is not displayed");
		//Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed());
 	     
	}
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData(){
		//Object[][] data= {{"admin@admin.com","changeme"},
				    //     {"hariniramesh42021@gmail.com","changeme"},
				    //     {"sugeetha.nandhakumar1982@gmail.com","changeme"}};
		Object[][] data=   utilities.getTestDataFromExcel("Login");
		return data;
		}
	
	@Test (priority=2)
	public void verifyLoginWithInvalidValidCredentilas() {
		
		loginPage.enterEmailAddress(utilities.generateTimeStamp());
		loginPage.enterPassword(prop.getProperty("vaildPassword"));
		loginPage.clickOnLoginButton();
		String actual= loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expected= dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actual.contains(expected),"expected error message is not correct");
		
	}
	
	@Test (priority=3)
	public void verifyLoginWithvalidEmailWithInValidpasswordCredentilas() {
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		String actual= loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		//driver.findElement(By.xpath("//input[@placeholder='E-Mail Address']")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(dataProp.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		//String actual=driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).getText();
		String expected= dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actual.contains(expected),"expected error message is not correct");
		
	}
	@Test (priority=4)
	public void verifyLoginWithoutProvidingCredentilas() {
		loginPage.clickOnLoginButton();
		//driver.findElement(By.cssSelector("input[value='Login']")).click();
		//driver.findElement(By.cssSelector("input[type='submit']")).click();
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actual= loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expected= dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actual.contains(expected),"expected error message is not correct");
			
			}

	}
