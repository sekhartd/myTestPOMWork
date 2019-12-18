package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public ElementUtil(WebDriver driver){
		this.driver=driver;
		wait = new WebDriverWait(driver,15);
	}
	
	public WebElement getElement(By locator){
		waitForElementPresent(locator);
		WebElement element=null;
		try{
			 element= driver.findElement(locator);
		}
		catch(Exception e){
			System.out.println("some exception got occured  while creating the webelement:" +locator);
			System.out.println(e.getMessage());
		}
		return element;
			}


	public void doClick(By locator){
		try{
			getElement(locator).click();
			}catch(Exception e){
				 System.out.println("some exception got occured while clicking on the webelement:" +locator);
				 System.out.println(e.getMessage());
			}	
	}

	public void doActionsClick(By locator){
		try{
			Actions action = new Actions(driver);
			action.click(getElement(locator)).build().perform();
			}catch(Exception e){
				 System.out.println("some exception got occured while clicking on the webelement:" +locator);
				 System.out.println(e.getMessage());
			}	
	}

	
	public void doSendKeys(By locator, String...value){
		try{
			getElement(locator).click();
			getElement(locator).sendKeys(value);
			}catch(Exception e){
				 System.out.println("some exception got occured while sending the text on the webelement:" +locator);
				 System.out.println(e.getMessage());
			}
	}
	
	public void doActionsSendKeys(By locator, String... value){
		try{

			Actions action = new Actions(driver);
			action.sendKeys(getElement(locator), value).build().perform();
			
			}catch(Exception e){
				 System.out.println("some exception got occured while passing the value on the webelement:" +locator);
				 System.out.println(e.getMessage());
			}
	}

	
	public String doGetText(By locator){
		String text = null;
		try{
			text = getElement(locator).getText();
			
			}catch(Exception e){
				 System.out.println("some exception got occured while getting the text on the webelement:" +locator);
				 System.out.println(e.getMessage());
			}	
		return text;
	}


	public void doActionsMoveToElement(By locator){
		try{

			Actions action = new Actions(driver);
			action.moveToElement(getElement(locator)).build().perform();
			
			}catch(Exception e){
				 System.out.println("some exception got occured while moving on the webelement:" +locator);
				 System.out.println(e.getMessage());
			}
	}

	
	
	public boolean doIsDisplayedt(By locator){

		
		boolean flag = false;
		try{
			flag = getElement(locator).isDisplayed();
	 	}catch(Exception e){
				 System.out.println("some exception got occured while checking isDisplayed on the webelement:" +locator);
				 System.out.println(e.getMessage());
			}	
		return flag;
	}


	public String doGetTitle(){
		String title = null;
		try{
			title = driver.getTitle();
			
			}catch(Exception e){
				 System.out.println("some exception got occured while getting the title of the page" );
				 System.out.println(e.getMessage());
			}	
		return title;
	}
	
	public void waitForPageUrl(String url){
		//WebDriverWait wait= new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.urlToBe(url));
	}
	
	
	public void waitForPageTitle(String title){
		//WebDriverWait wait= new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.titleContains(title));
				
	}
	
	public void waitForElementPresent(By locator){
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
}

