package com.techninja.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
     
	//Object
	@FindBy (id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy (id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy (id="input-email")
	private WebElement emailField;
	
	@FindBy (id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy (id="input-password")
	private WebElement passwordField;
	
	@FindBy (id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy (xpath="(//input[@name='newsletter'])[2]")
	private WebElement newsletteroption;
	
	@FindBy (name="agree")
	private WebElement privacyPolicyOption;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement continueButton;
	
	@FindBy (xpath="//div[@id='content']//h1[1]")
	private WebElement yourAccountHasBeenCreatedAlertMsg;
	
	@FindBy (xpath="//div[text()='Warning: You must agree to the Privacy Policy!']")
	private WebElement agreePrivacyPolicyAlertMsg;
	
	@FindBy (xpath="//div[text()='Warning: E-Mail Address is already registered!']")
	private WebElement emailAlreadyRegisteredwarningMsg;
	
	
	//Constructor
	public RegisterPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Action
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	public void enterTelephoneNumber(String telephoneNumber) {
		telephoneField.sendKeys(telephoneNumber);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordField.sendKeys(confirmPasswordText);
	}
	
	public void clickonNewsletterOption() {
		newsletteroption.click();
	}
	
	public void SelectPrivacyPolicy() {
		privacyPolicyOption.click();
	}
	public void clickonContinueButton() {
		continueButton.click();
	}
	public String getDisplayStatusOfAccountCreatedAlertMsg() {
		 
		String warningText = yourAccountHasBeenCreatedAlertMsg.getText();
  		return warningText;
	 }
	public String getDisplayStatusOfPrivacyPolicyAlertMsg() {
		 
		String warningText = agreePrivacyPolicyAlertMsg.getText();
  		return warningText;
	 }
	public String getDisplayStatusOfEmailIDAlreadyRegisteredWarningMsg() {
		 
		String warningText = emailAlreadyRegisteredwarningMsg.getText();
  		return warningText;
	 }
}
