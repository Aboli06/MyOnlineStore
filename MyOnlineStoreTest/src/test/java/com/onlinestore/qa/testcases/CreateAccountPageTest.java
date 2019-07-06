package com.onlinestore.qa.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.onlinestore.qa.base.OnlineStoreTestBase;
import com.onlinestore.qa.pages.CreateAccountPage;
import com.onlinestore.qa.pages.HomePage;
import com.onlinestore.qa.pages.SignIn;

public class CreateAccountPageTest extends OnlineStoreTestBase {
	
	CreateAccountPage objcreateAcc ;
	//HomePage objHome = new HomePage();

	SignIn objSignIn = new SignIn() ;
	
	public CreateAccountPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		browsweInitialization();
		
		HomePage objHome = new HomePage();
		
		objSignIn = objHome.verifySignIn();
		objSignIn.enterEmailforNewAccCreation("sdasd.saas@qwwee.com");
		

	}
	
	@Test
	public void createNewUserAccount() {
		CreateAccountPage objcreateAcc = new CreateAccountPage() ; 
		objcreateAcc.createNewAccount(1,"Asmi", "Doshi", "456789", "9", "6", "2014", "CApgi", 
				"dfsd,dsfsdf", "New Jercy", "Colorado", "12345", "United States", 
				"9878767675", "ddsfsd");
		
	}

}
