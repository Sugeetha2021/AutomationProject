package com.techninja.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//objects
	@FindBy(xpath="//input[@placeholder='E-Mail Address']")
	private WebElement emailAddressField;
	
	@FindBy (xpath="//input[@placeholder='Password']")
	private WebElement passwordField;
	
	@FindBy (xpath="//input[@class='btn btn-primary']")
	private WebElement LoginButton;
	
	@FindBy (xpath="//div[normalize-space(text())='Warning: No match for E-Mail Address and/or Password.']")
	private WebElement emailPasswordNotMatchingWarningMsg;
	
    public LoginPage(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
    
  //Action
	
  	public void  enterEmailAddress(String emailText){
  		emailAddressField.sendKeys(emailText);
  	}
  	
  	public void enterPassword(String passwordText) {
  		passwordField.sendKeys(passwordText);
  	}
  	
  	public AccountPage clickOnLoginButton() {
  		LoginButton.click();
  		return new AccountPage(driver);
  	}
  	public String retrieveEmailPasswordNotMatchingWarningMessageText() {
  		
  		String warningText = emailPasswordNotMatchingWarningMsg.getText();
  		return warningText;
  		
  	}
}
