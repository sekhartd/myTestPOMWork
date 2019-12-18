package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BagePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class LoginPage extends BagePage{
	
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//1. Page Objects / By Locators
	
	By emailID = By.id("username");
	By Password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	// 2. page class construction:
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// 3. Page actions/methods
	
	public String getLoginPageTitle(){
		//return driver.getTitle();
		elementUtil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
		return elementUtil.doGetTitle();
	}
	
	public boolean isSignUpLinkExists(){
		//return driver.findElement(signUpLink).isDisplayed();
		return elementUtil.doIsDisplayedt(signUpLink);
	}
	
	public HomePage doLogin(String username, String pwd) {
//		driver.findElement(emailID).sendKeys(username);
//		driver.findElement(Password).sendKeys(pwd);
//		driver.findElement(loginButton).click();
		
		elementUtil.doSendKeys(emailID, username);
		elementUtil.doSendKeys(Password, pwd);
		elementUtil.doClick(loginButton);
		
//		 try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 

		
		 return new HomePage(driver);
		 
		 
	}
	
	

}
