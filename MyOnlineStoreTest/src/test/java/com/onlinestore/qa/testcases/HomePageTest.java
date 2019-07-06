package com.onlinestore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.onlinestore.qa.base.OnlineStoreTestBase;
import com.onlinestore.qa.pages.HomePage;
import com.onlinestore.qa.pages.SignIn;

public class HomePageTest extends OnlineStoreTestBase {
	
	HomePage objHomePage;
	SignIn objSignIn;
	
	public  HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		browsweInitialization();
		objHomePage = new HomePage();
	}
	
	@Test(priority=1,description=" Verification of Titleis matched or not ")
	public void verifyHomePageTitle() {
		String expTitle = objHomePage.verifyPageTitle();
		Assert.assertEquals(expTitle, "My Store");
		System.out.println("Titles Matched");
	}

	@Test(priority=2,description=" Verification of Logo is present or not ")
	public void verifyHomePageLogo() {
		
	boolean flag = objHomePage.verifyLogo();
	Assert.assertTrue(flag);
	System.out.println("Logo Present");
	
	}
	
	
	@Test(priority=3,description=" Verification of Logo is present or not ")
	public void signIn()  {
		objHomePage.verifySignIn();
		objHomePage.SignInPageTitle();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
	driver.close();	
	}
}
