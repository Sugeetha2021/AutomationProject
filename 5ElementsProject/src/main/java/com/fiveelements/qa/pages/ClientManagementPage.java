package com.fiveelements.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientManagementPage {

WebDriver driver;
	
	//objects
	
	@FindBy(xpath="(//div[@class='nav__left']//img)[2]")
	private WebElement HamburgerMenu;
	
	@FindBy(xpath="(//span[text()='Client Management'])[1]")
	private WebElement clientManagementoption;
	
	@FindBy(xpath="//span[text()='Clients']")
	private WebElement Clientsoption;
	
	@FindBy(xpath="//input[@placeholder='Search by Client, Type, Industry']")
	private WebElement searchByClient;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement searchButton;
	
	@FindBy(xpath="//div[@id='cell-2-undefined']//span[1]")
	private WebElement searchGetDisplayed;
	
	@FindBy(xpath="//div[text()='There are no records to display']")
	private WebElement InvalidsearchWarningText;
	
	@FindBy(xpath="(//div[contains(@class,'flex flex-col')]//button)[1]")
	private WebElement addClientButton;
	
	@FindBy(xpath="(//div[@class='input-group']//input)[1]")
	private WebElement clientNameField;
	
	@FindBy(xpath="(//div[@class='input-group']//input)[2]")
	private WebElement clientCodeField;
	
	@FindBy(xpath="(//div[text()='Select...']/following-sibling::div)[1]")
	private WebElement industryDropdownField;
	
	@FindBy(xpath="(//div[text()='Retail']")
	private WebElement optionRetail;
	
	@FindBy(xpath="//div[@class='mb-3']//textarea[1]")
	private WebElement abouttheClientField;
	
			
	@FindBy(xpath="(//input[@class='form-control'])[3]")
	private WebElement clientPOCField;
	
	//driver.findElement(By.xpath("//div[@class='form-check form-switch']//input[1]")).click();
	
	@FindBy(xpath="//div[@class='form-check form-switch']//input[1]")
	private WebElement GlobalClientField;
	
	public ClientManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	//Actions
	public void clickOnHamburgerMenu() {
		 
		HamburgerMenu.click();
	 }
	public void clickOnClientManagementOption() {
		 
		clientManagementoption.click();
	 }
	public void clickOnClientsOption() {
		 
		Clientsoption.click();
	 }
	public void searchByClient(String searchByClientText) {
		
	searchByClient.sendKeys(searchByClientText);
		
	}
	public void clickOnSearchButton() {
		searchButton.click();	
    }
	
	 public boolean retrivesearchResult() {
	    	
	    	boolean searchResult= searchGetDisplayed.isDisplayed();
	    	return searchResult;
	    }
	 public boolean retriveInvalidSearchWarningText() {
			
			boolean invalidSearch=InvalidsearchWarningText.isDisplayed();
			return invalidSearch;
		}
	 public void clickOnAddClientButton() {
		 	addClientButton.click();	
	    }
	 public void enterClientName(String ClientNameText) {
			
		 clientNameField.sendKeys(ClientNameText);
			
		}
	 public void enterClientcode(String ClientCodeText) {
			
		 clientCodeField.sendKeys(ClientCodeText);
			
		}
	 public void clickIndustryDropDown() {
		 
		 industryDropdownField.click();
		 }
	 public void clickIndustryDropDownOption() {
		 
		 optionRetail.click();
		 }
	 public void enterAboutClient(String AboutclientText) {
			
		 abouttheClientField.sendKeys(AboutclientText);
			
		}
		public void enterClientPOC(String clientPOCText) {
			
			clientPOCField.sendKeys(clientPOCText);
				
			}
		 public void GlobalClientCheckBox() {
			 
			 GlobalClientField.click();
			 }
}


