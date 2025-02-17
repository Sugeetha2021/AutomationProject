package com.techninja.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	//object
	@FindBy (xpath="//a[normalize-space(text())='Edit your account information']")
	private WebElement editYourAccountInformationOption;
    
	 public AccountPage(WebDriver driver) {
			
			this.driver =driver;
			PageFactory.initElements(driver, this);
		}
	 
	 public boolean getDisplayStatusOfEditYourAccountInfo() {
		 
		 boolean displayStatus = editYourAccountInformationOption.isDisplayed();
		 return displayStatus;
	 }
	    
}
