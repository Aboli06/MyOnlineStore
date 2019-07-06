package com.onlinestore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.onlinestore.qa.base.OnlineStoreTestBase;

public class SignIn extends OnlineStoreTestBase
{

	
	SignIn objSignIn;

	//Page FActory - Object Repositiry


	//@FindBy(how = How.CLASS_NAME, using ="login")
	//WebElement signInLink ;


	@FindBy(id="email")
	WebElement emailAddress;

	@FindBy(name="passwd")
	WebElement password;

	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement signInbutton;

	@FindBy(linkText="Forgot your password?")
	WebElement forgotPwdLink ;

	@FindBy(xpath="//a[@title='Log me out']")
	public WebElement signOutLink ;

	@FindBy(xpath="//li[text()='Authentication failed.']")
	public WebElement errorAlert;

	@FindBy(id="email_create")
	WebElement createAccEmail ;

	@FindBy(id="SubmitCreate")
	WebElement createAccountbutton;

	public SignIn()
	{

		PageFactory.initElements(driver, this);	

	}


	public void validateLogin(String Id, String pwd) throws InterruptedException 
	{
		emailAddress.sendKeys(Id);
		password.sendKeys(pwd);
		signInbutton.click();
	}


	public UserAccountPage verifySignoutLink()
	{
		return new UserAccountPage();
	}


	public CreateAccountPage enterEmailforNewAccCreation(String emailId)
	{
		createAccEmail.sendKeys(emailId);
		createAccountbutton.click();
		return new CreateAccountPage();
		
	}


}
