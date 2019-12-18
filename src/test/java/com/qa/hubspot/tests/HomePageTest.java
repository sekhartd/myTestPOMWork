package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BagePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {
	
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
	    homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	

	@Test(priority=1)
	public void verifyHomePageHeaderValueTest(){
		Assert.assertTrue(homePage.verifyHomePageHeader());
	    String headerValue = homePage.getHomePageHeader();
	    System.out.println("home page header is:"+ headerValue);
	    Assert.assertEquals(headerValue, Constants.HOME_PAGE_HEADER);
	}

	
	@Test(priority=2)
	public void verifyLoggedInUserTest(){
		Assert.assertTrue(homePage.verifyLoggedAccountName());
	    String accountName = homePage.getLoggedAccountName();
	    System.out.println("account Name is:"+ accountName);
	    Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}

	
	@Test(priority=3)
	public void verifyHomePageAppLogo(){
		Assert.assertTrue(homePage.verifyApplicationLogo());
//		System.out.println("Logo is available");
	}

	@Test(priority=4)
	public void verifyHomePageTitleTest(){
		String title = homePage.getHomePageTilte();
		System.out.println("home page title is:"+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	
	@AfterTest
	public void quitBrowser(){
		driver.quit();
	}	
	
	

}
