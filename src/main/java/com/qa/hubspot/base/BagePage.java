package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BagePage {
	 WebDriver driver;
	 Properties prop;
	 
	 public WebDriver init_driver(Properties prop){
		 String browser =  prop.getProperty("browser");
		 
		 if(browser.equals("chrome")){
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		 }
		 else if(browser.equals("firefox")){
			 WebDriverManager.firefoxdriver().setup();
			 driver= new FirefoxDriver();
		 }
		 else if(browser.equals("safari")){
			 WebDriverManager.getInstance(SafariDriver.class).setup();
			    driver= new SafariDriver();
		 }
		 else if(browser.equals("iexplorer")){
			  WebDriverManager.iedriver().setup();
			 }
		 else{
			 System.out.println("Please pass the correct browser name...");
	 	 	}

		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 
		 driver.get(prop.getProperty("url"));

//		 try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 
		 return driver;
		 
	 }
	 
	 public Properties init_properties(){
		 
		 prop = new Properties();
		 try {
			FileInputStream ip= new FileInputStream("C:\\Users\\sekha\\workspace\\OctbatchPOMSeries\\"
			 		+ "src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		 
		 return prop;
	 }
}
