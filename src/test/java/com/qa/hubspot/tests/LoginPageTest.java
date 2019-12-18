package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BagePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginPageTest {

	WebDriver driver;
	BagePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage; 
	
	
	
	
	@BeforeTest
	
	public void setUp(){
		basePage = new BagePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
	    loginPage = new LoginPage(driver);
		
	}
	
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		String title  =loginPage.getLoginPageTitle();
		System.out.println("login page title is"+ title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginPage.isSignUpLinkExists());
	}
	
	@Test(priority=3)
	public void verifyLoginTest(){
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertTrue(homePage.verifyLoggedAccountName());
		Assert.assertEquals(homePage.getLoggedAccountName(),prop.getProperty("accountname"));
	}
	
	
	@AfterTest
	public void quitBrowser(){
		driver.quit();
	}
	
	
	
	
}
