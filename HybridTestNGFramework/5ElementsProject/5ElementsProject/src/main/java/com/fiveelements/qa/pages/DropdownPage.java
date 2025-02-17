package com.fiveelements.qa.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownPage {
    private WebDriver driver;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void IndustryselectOption(String optionText) {
        WebElement dropdownField = waitForElementClickable(By.xpath("(//div[text()='Select...']/following-sibling::div)[1]"));
        dropdownField.click();

        WebElement option = waitForElementClickable(By.xpath("//div[text()='" + optionText + "']"));
        option.click();
    }
    

    public void clientTypeselectOption(String clientTypeText) {
        WebElement clientTypedropdownField = waitForElementClickable(By.xpath("(//div[@class=' css-1wy0on6']//div)[2]"));
        clientTypedropdownField.click();
      
        WebElement clientTypeoption = waitForElementClickable(By.xpath("//div[text()='" + clientTypeText + "']"));
        clientTypeoption.click();
    }
    
    public void clientPOCDesignationselectOption(String clientPOCDesignationText) {
    	
        WebElement clientPOCDesignationdropdownField = waitForElementClickable(By.xpath("(//div[@class=' css-1wy0on6']//div)[3]"));
        clientPOCDesignationdropdownField.click();
      
        WebElement clientPOCDesignationoption = waitForElementClickable(By.xpath("//div[text()='" + clientPOCDesignationText + "']"));
        clientPOCDesignationoption.click();
    }
    
	 public void EngagementLeaderselectOption(String EngagementLeaderText) {
	    	
	        WebElement EngagementLeaderdropdownField = waitForElementClickable(By.xpath("(//div[@class=' css-1wy0on6']//div)[4]"));
	        EngagementLeaderdropdownField.click();
	      
	        WebElement EngagementLeaderoption = waitForElementClickable(By.xpath("//div[text()='" + EngagementLeaderText + "']"));
	        EngagementLeaderoption.click();
	    }
	 public void serviceTypeselectOption(String serviceTypeText) {
	 	
	     WebElement serviceTypedropdownField = waitForElementClickable(By.xpath("(//div[@class=' css-1wy0on6']//div)[5]"));
	     serviceTypedropdownField.click();
	   
	     WebElement serviceTypeoption = waitForElementClickable(By.xpath("//div[text()='" + serviceTypeText + "']"));
	     serviceTypeoption.click();
	 }
	 public void capabilityselectOption(String capabilityText) {
		 	
	     WebElement capabilitydropdownField = waitForElementClickable(By.xpath("(//div[@class=' css-1wy0on6']//div)[6]"));
	     capabilitydropdownField.click();
	   
	     WebElement capabilityoption = waitForElementClickable(By.xpath("//div[text()='" + capabilityText + "']"));
	     capabilityoption.click();
	 }
	 public void POLocationselectOption(String POLocationText) {
		 	
	     WebElement POLocationdropdownField = waitForElementClickable(By.xpath("(//div[@class=' css-1wy0on6']//div)[7]"));
	     POLocationdropdownField.click();
	   
	     WebElement POLocationoption = waitForElementClickable(By.xpath("//div[text()='" + POLocationText + "']"));
	     POLocationoption.click();
	 }
	 public void deliveryLocationselectOption(String deliveryLocationText) {
		 	
	     WebElement deliveryLocationdropdownField = waitForElementClickable(By.xpath("(//div[@class=' css-1wy0on6']//div)[8]"));
	     deliveryLocationdropdownField.click();
	   
	     WebElement deliveryLocationoption = waitForElementClickable(By.xpath("//div[text()='" + deliveryLocationText + "']"));
	     deliveryLocationoption.click();
	 }
	 
    public void ClientEffectiveDate(String date) {
        // Click on the calendar field to open the dropdown
    	WebElement calendarField = driver.findElement(By.xpath("//div[@id='clientEffectiveDate']//label[1]"));
        calendarField.click();

        // Select the desired date from the calendar
        String xpathForDate = String.format("//input[@min='%s']", date);
        WebElement datePicker = driver.findElement(By.xpath(xpathForDate));
        datePicker.click();
        datePicker.sendKeys(date);
        datePicker.sendKeys(Keys.ENTER);
    }
   
    private WebElement waitForElementClickable(By locator) {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(locator));
    }
   
}
