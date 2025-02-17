package com.fiveelements.qa.testcases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fiveelements.qa.base.Baseclass;
import com.fiveelements.qa.pages.ClientManagementPage;
import com.fiveelements.qa.pages.DropdownPage;
import com.fiveelements.qa.pages.Loginpage;
import com.fiveelements.qa.utils.utilities;

public class clientmanagement extends Baseclass{
	public clientmanagement() {
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
		
		@Test (priority=1)
		public void verifysearchwithvalidclientname() {
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			Loginpage loginPage= new Loginpage(driver);
			loginPage.enterEmailAddress(prop.getProperty("validEmail"));
			loginPage.enterPassword(prop.getProperty("validPassword"));
			loginPage.clickOnLoginButton();
			ClientManagementPage clientManagement= new ClientManagementPage(driver);
			clientManagement.clickOnHamburgerMenu();
			clientManagement.clickOnClientManagementOption();
			clientManagement.clickOnClientsOption();
			clientManagement.searchByClient(dataProp.getProperty("searchByClient"));
			clientManagement.clickOnSearchButton();
			Assert.assertTrue(clientManagement.retrivesearchResult());
		}
		@Test (priority=2)
		public void verifysearchwithinvalidclientname() {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			Loginpage loginPage= new Loginpage(driver);
			loginPage.enterEmailAddress(prop.getProperty("validEmail"));
			loginPage.enterPassword(prop.getProperty("validPassword"));
			loginPage.clickOnLoginButton();
			ClientManagementPage clientManagement= new ClientManagementPage(driver);
			clientManagement.clickOnHamburgerMenu();
			clientManagement.clickOnClientManagementOption();
			clientManagement.clickOnClientsOption();
			clientManagement.searchByClient(dataProp.getProperty("searchByInvalidclient"));
			clientManagement.clickOnSearchButton();
			Assert.assertTrue(clientManagement.retriveInvalidSearchWarningText());
		}
		@Test (priority=3)
		 public void verifyAddClientWithValidCredentials() {
	            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	            Loginpage loginPage = new Loginpage(driver);
	            loginPage.enterEmailAddress(prop.getProperty("validEmail"));
	            loginPage.enterPassword(prop.getProperty("validPassword"));
	            loginPage.clickOnLoginButton();
	            ClientManagementPage clientManagement = new ClientManagementPage(driver);
	            clientManagement.clickOnHamburgerMenu();
	            clientManagement.clickOnClientManagementOption();
	            clientManagement.clickOnClientsOption();
	            clientManagement.clickOnAddClientButton();
	            clientManagement.enterClientName(dataProp.getProperty("clientName") + utilities.generateTimeStamp());
	            clientManagement.enterClientcode(dataProp.getProperty("clientCode") + utilities.generateTimeStamp());
	            DropdownPage Industrydropdown = new DropdownPage(driver);
	            Industrydropdown.IndustryselectOption(dataProp.getProperty("IndustryDropDownfield"));
	            driver.findElement(By.xpath("//div[@id='clientEffectiveDate']//label[1]"));
	            DropdownPage clientEffectiveCalenderDropdown=new DropdownPage(driver);
	            clientEffectiveCalenderDropdown.ClientEffectiveDate(dataProp.getProperty("ClientEffectiveDateDropDownfield"));
	            clientManagement.enterAboutClient(dataProp.getProperty("AboutClientField"));
	            DropdownPage clientTypedropdown = new DropdownPage(driver);
	            clientTypedropdown.clientTypeselectOption(dataProp.getProperty("clientTypeDropDownField"));
	            clientManagement.enterClientPOC(dataProp.getProperty("clientPOC") + utilities.generateTimeStamp());
	           	DropdownPage clientPOCDropDown = new DropdownPage(driver);
	        	clientPOCDropDown.clientPOCDesignationselectOption(dataProp.getProperty("clientPOCDesignationField"));
	        	DropdownPage engagementLeaderDropDown = new DropdownPage(driver);
	        	engagementLeaderDropDown.EngagementLeaderselectOption(dataProp.getProperty("engagementLeaderDropDownField"));
	        	DropdownPage serviceTypeDropDown = new DropdownPage(driver);
	        	serviceTypeDropDown.serviceTypeselectOption(dataProp.getProperty("serviceTypeDropDownField"));
	        	DropdownPage capabilityDropDown = new DropdownPage(driver);
	        	capabilityDropDown.capabilityselectOption(dataProp.getProperty("capability"));
	        	DropdownPage POLocationDropDown = new DropdownPage(driver);
	        	POLocationDropDown.POLocationselectOption(dataProp.getProperty("POLocation"));
	        	DropdownPage deliveryDropDown = new DropdownPage(driver);
	        	deliveryDropDown.deliveryLocationselectOption(dataProp.getProperty("deliveryLocation"));
	        	clientManagement.GlobalClientCheckBox();
	        	driver.findElement(By.xpath("//div[contains(@class,'flex flex-row')]//button[1]")).click();
		
}
}

	        
				
		
				

