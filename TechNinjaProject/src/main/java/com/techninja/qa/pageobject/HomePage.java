package com.techninja.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//objects
	@FindBy(xpath="//span[normalize-space(text())='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
    private WebElement loginOption;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu dropdown-menu-right']//a)[1]")
	private WebElement registerOption;
	
	public HomePage(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	//Action
	
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
}
