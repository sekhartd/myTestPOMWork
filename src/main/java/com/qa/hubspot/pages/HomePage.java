package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BagePage;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BagePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	By header = By.cssSelector("h1.private-page__title");
	By accountName = By.cssSelector("span.account-name");
	By logo = By.cssSelector("li>a#nav-primary-home");
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		elementUtil.waitForElementPresent(header);
	}
	
	public String getHomePageTilte(){
	//	return driver.getTitle();
		return elementUtil.doGetTitle();
	}

	public boolean verifyHomePageHeader(){
	//	return driver.findElement(header).isDisplayed();

		return elementUtil.doIsDisplayedt(header);
	}
	

	public String getHomePageHeader(){
		//return driver.findElement(header).getText();
		return elementUtil.doGetText(header);
	}
	
	public boolean verifyLoggedAccountName(){
	//	return driver.findElement(accountName).isDisplayed();
		return elementUtil.doIsDisplayedt(accountName);
	}

	
	public String getLoggedAccountName(){
		//return driver.findElement(accountName).getText();
		return elementUtil.doGetText(accountName);
		
	}
	
	
	public boolean verifyApplicationLogo(){
		//return driver.findElement(logo).isDisplayed();
		return elementUtil.doIsDisplayedt(logo);
	}

	
	
}
