package com.fiveelements.qa.testcases;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import com.techninja.qa.utils.utilities;

import com.fiveelements.qa.base.Baseclass;
import com.fiveelements.qa.pages.Loginpage;
import com.fiveelements.qa.pages.MyDashboard;
import com.fiveelements.qa.utils.utilities;

//import qlearningProject.com.qleaningProject.qa.utils.utilities;



public class Login extends Baseclass{
	public Login() {
		super();
	}
	
	
  WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver= initializeBrowserAndOpenAppURL(prop.getProperty("browserName"));
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
	driver.quit();
}
	
	@Test (priority=1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentilas(String email,String password) {
	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//Get input from testdata properties file
		//driver.findElement(By.xpath("(//label[text()='Email']/following::input)[1]")).sendKeys(prop.getProperty("validEmail"));
		
		Loginpage loginPage= new Loginpage(driver);
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		MyDashboard myDashboard =new MyDashboard(driver);
		Assert.assertTrue (myDashboard.getDisplayStatusOfMyDashboard());
		
		
		//Get Input from config file 
		//driver.findElement(By.xpath("(//label[text()='Email']/following::input)[1]")).sendKeys(email);
		//driver.findElement(By.xpath("//label[text()='Password']/following::input")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//label[text()='Password']/following::input")).sendKeys(password);
		//driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		//Assert.assertTrue(driver.findElement(By.xpath("//button[text()='My Dashboard']")).isDisplayed());
   	
   
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
	public void verifyLoginWithValidCredentilaspreprod() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Loginpage loginPage= new Loginpage(driver);
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
	    
	}
	
	@Test (priority=3)
	public void verifyLoginWithInvalidValidCredentilasdev() {
		Loginpage loginPage= new Loginpage(driver);
		loginPage.enterEmailAddress(utilities.generateTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		String actual=loginPage.retriveEmailPasswordNotMatchingWarningText();
		String expected= dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actual.contains(expected),"Expected error message is not correct");
		
	}
	
	@Test (priority=4)
	public void verifyLoginWithInvalidEmailWithValidpasswordCredentilas() {
		Loginpage loginPage= new Loginpage(driver);
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		String actual=loginPage.retriveEmailPasswordNotMatchingWarningText();
		String expected= dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actual.contains(expected),"expected error message is not correct");
		
	}
	@Test (priority=5)
	public void verifyLoginWithoutProvidingCredentilas() {
		
		Loginpage loginPage= new Loginpage(driver);
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.retriveBlankEmailWarningText());
		Assert.assertTrue(loginPage.retriveBlankPasswordWarningText());
						
			}

}
