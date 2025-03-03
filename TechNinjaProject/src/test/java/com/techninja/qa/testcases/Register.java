package com.techninja.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.techninja.qa.base.Baseclass;
import com.techninja.qa.pageobject.HomePage;
import com.techninja.qa.pageobject.RegisterPage;
import com.techninja.qa.utils.utilities;

public class Register extends Baseclass {
	
	RegisterPage registerPage;
	public Register() {
		super();
	}
	
	 WebDriver driver;
	 
	 @BeforeMethod
		public void setup() {
			
		    driver= initializeBrowserAndOpenAppURL(prop.getProperty("browser"));
		    HomePage homePage=new HomePage(driver);
		    homePage.clickOnMyAccount();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    registerPage =homePage.selectRegisterOption();
					
		}
		
		
		@AfterMethod
		public void tearDown() {
			
		driver.quit();
	}
	
	@Test (priority=1)
	public void verifyRegisterWithAllFields() {
		//RegisterPage registerPage=new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(utilities.generateTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("vaildPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("vaildPassword"));
		registerPage.clickonNewsletterOption();
		registerPage.SelectPrivacyPolicy();
		registerPage.clickonContinueButton();
		String actualHeading= registerPage.getDisplayStatusOfAccountCreatedAlertMsg();
		String expectedHeading= dataProp.getProperty("emailCreatedAlertMsg");
		Assert.assertTrue(actualHeading.contains(expectedHeading),"account success page is not displayed");
		
		
}
	@Test (priority=2)
	public void verifyLoginWithMandatoryFields() {
	
		//RegisterPage registerPage=new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(utilities.generateTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("vaildPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("vaildPassword"));
		registerPage.clickonNewsletterOption();
		registerPage.clickonContinueButton();
		String actualHeading = registerPage.getDisplayStatusOfPrivacyPolicyAlertMsg();
		String expectedHeading= dataProp.getProperty("privacyPolicyWarning");
		Assert.assertTrue(actualHeading.contains(expectedHeading),"account success page is not displayed");
		
				
}
	@Test (priority=3)
	public void verifyRegisterWithExistingEmail() {
		//RegisterPage registerPage=new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(prop.getProperty("validEmail"));
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("vaildPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("vaildPassword"));
		registerPage.clickonNewsletterOption();
		registerPage.SelectPrivacyPolicy();
		registerPage.clickonContinueButton();
		String actualHeading = registerPage.getDisplayStatusOfEmailIDAlreadyRegisteredWarningMsg();
		String expectedHeading= dataProp.getProperty("emailAlreadyRegisteredWarning");
		Assert.assertTrue(actualHeading.contains(expectedHeading),"account success page is not displayed");
		
		
	}
	@Test (priority=4)
	public void verifyRegisterWithoutFillAnyFields() {
		//RegisterPage registerPage=new RegisterPage(driver);
		registerPage.clickonContinueButton();
		String actualHeading = registerPage.getDisplayStatusOfPrivacyPolicyAlertMsg();
		String expectedHeading= dataProp.getProperty("privacyPolicyWarning");
		Assert.assertTrue(actualHeading.contains(expectedHeading),"account success page is not displayed");
	}
}

