package com.onlinestore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinestore.qa.base.OnlineStoreTestBase;

public class HomePage extends OnlineStoreTestBase{
	
	
	@FindBy(xpath="//img[@alt='My Store']")
	WebElement onlineStorelogo;
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signInLink ;
	
	@FindBy(linkText="Contact us")
	WebElement contactUsLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyPageTitle() {
		
	return	driver.getTitle();
		
	}

	
	public boolean verifyLogo() {
		
	return onlineStorelogo.isDisplayed();
			
	}
	
	
	public  SignIn  verifySignIn() {
	signInLink.click();
	return new SignIn();
	}
	
	
	
	public void SignInPageTitle() {
	String SignInPageTitle =driver.getTitle();	
	System.out.println("Page Title of SignIn Page : " +SignInPageTitle);
	
	}
	
}



