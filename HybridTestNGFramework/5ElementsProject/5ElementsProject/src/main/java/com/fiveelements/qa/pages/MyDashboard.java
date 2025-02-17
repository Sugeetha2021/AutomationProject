package com.fiveelements.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboard {
	
      WebDriver driver;
	
	//objects
      
	@FindBy(xpath="//button[text()='My Dashboard']")
	private WebElement validateMyDashboardOption ;
	
	public MyDashboard (WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver,this);
}
//Actions
	
	
	public boolean getDisplayStatusOfMyDashboard() {
		 boolean displayStatus =validateMyDashboardOption.isDisplayed();
		 return displayStatus;
	
	}

}
