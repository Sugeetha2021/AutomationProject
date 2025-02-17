package com.techninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.techninja.qa.utils.utilities;

public class Baseclass {
  
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public  Baseclass() {
		
	prop=new Properties();
	File profFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\techninja\\qa\\config\\config.properties");
	try {
		FileInputStream fis=new FileInputStream(profFile);
        prop.load(fis);
    }catch(Throwable e) {
    	e.printStackTrace();
    }
	
	dataProp =new Properties();
    File dataPropFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\techninja\\qa\\testdata\\testdata.properties");
    try {
		FileInputStream datafis=new FileInputStream(dataPropFile);
        dataProp.load(datafis);
    }catch(Throwable e) {
    	e.printStackTrace();
    }
	}
	public WebDriver initializeBrowserAndOpenAppURL(String browserName) {
	
	
	if (browserName.equalsIgnoreCase("chrome")) {
		
		driver =new ChromeDriver();
		
	}else if(browserName.equalsIgnoreCase("firefox")) {
		
		driver =new FirefoxDriver();
		
	}else if(browserName.equalsIgnoreCase("edge")) {
		
		driver =new EdgeDriver();
		
	}else if(browserName.equalsIgnoreCase("safari")) {
			
			driver =new SafariDriver();
	}
			
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.IMPLICIT_WAIT_TIME));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.PAGE_LOAD_TIME));
	driver.get(prop.getProperty("url"));
    return driver;
}
}


