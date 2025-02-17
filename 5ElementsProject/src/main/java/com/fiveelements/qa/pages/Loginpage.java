package com.fiveelements.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	
	//objects
	
	@FindBy(xpath="(//label[text()='Email']/following::input)[1]")
	private WebElement emailAddressField;
	
	@FindBy(xpath="//label[text()='Password']/following::input")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement loginButton;
	
	@FindBy(xpath="//p[text()='Login ID/password combination is not correct']")
	private WebElement emailPasswordNotMatchingWarning;
	
	@FindBy(xpath="//p[text()='Please enter Email Id']")
	private WebElement blankEmailField;
	
	@FindBy(xpath="//p[text()='Please enter Password']")
	private WebElement blankPasswordField;
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public void enterEmailAddress(String emailText) {
		
		emailAddressField.sendKeys(emailText);
		
	}

	public void enterPassword(String passwordText) {
		 
		 passwordField.sendKeys(passwordText);
	 }
	public void clickOnLoginButton() {
		 
		 loginButton.click();
	 }
	public String retriveEmailPasswordNotMatchingWarningText() {
		
		String warningText=emailPasswordNotMatchingWarning.getText();
		return warningText;
	}
    public boolean retriveBlankEmailWarningText() {
    	
    	boolean warningText1= blankEmailField.isDisplayed();
    	return warningText1;
    }
    public boolean retriveBlankPasswordWarningText() {
    	boolean warningText2= blankPasswordField.isDisplayed();
    	return warningText2;
    }
	 }
