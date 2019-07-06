package com.onlinestore.qa.testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.onlinestore.qa.base.OnlineStoreTestBase;
import com.onlinestore.qa.pages.HomePage;
import com.onlinestore.qa.pages.SignIn;
import com.onlinestore.qa.pages.UserAccountPage;

public class SignInTest extends OnlineStoreTestBase
{

	SignIn objSignIn;
	UserAccountPage objUserAcctPage;

	public SignInTest()
	{
		super();
	}


	@BeforeMethod
	public void setUp() 
	{
		browsweInitialization();

		objSignIn = (new HomePage()).verifySignIn();

	}


	@Test(description="Verify Login scenario with valid credentials")
	public void validateLoginTest() throws InterruptedException 
	{
		objSignIn.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		objSignIn.verifySignoutLink();
		boolean flag = objSignIn.signOutLink.isDisplayed();
		Assert.assertTrue(flag,"Sign Out Link is not present so scenario failed");

	}

	@Test(description="Verify Login scenario with invalid credentials")
	public void verifyInvalidLogin() throws Exception
	{
		objSignIn.validateLogin(prop.getProperty("invalidUser"), prop.getProperty("invalidpassword"));
		boolean	flag=objSignIn.errorAlert.isDisplayed();
		Assert.assertTrue(flag, "Authentication error is not displayed , Invalid Login scenario failed");	

	}


	@AfterMethod
	public void tearDown() 
	{
		driver.close();	
	}

}
