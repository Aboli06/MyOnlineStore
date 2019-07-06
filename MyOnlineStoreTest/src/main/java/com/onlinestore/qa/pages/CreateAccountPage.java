package com.onlinestore.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.onlinestore.qa.base.OnlineStoreTestBase;

public class CreateAccountPage extends OnlineStoreTestBase
{
	
	
	
	
	List<WebElement> genderRadio = driver.findElements(By.className("radio-inline"));
	
	@FindBy(xpath="//input[@name='customer_firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='customer_lastname']")
	WebElement lstName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	Select objDays = new Select(driver.findElement(By.id("days")));
	Select objMonth = new Select(driver.findElement(By.id("months")));
	Select objYear = new Select(driver.findElement(By.id("years")));
	
	@FindBy(id="newsletter")
	WebElement newsletterChkBox;
	
	@FindBy(id="optin")
	WebElement offerChkBox ;
	
	@FindBy(id="company")
	WebElement company ;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="address2")
	WebElement address2;
	
	@FindBy(id="city")
	WebElement ecity;
	
	Select objState = new Select(driver.findElement(By.id("id_state")));
	
	@FindBy(id="postcode")
	WebElement postcode;
	
	Select objCountry = new Select(driver.findElement(By.id("id_country")));
	
	@FindBy(id="other")
	WebElement additionalInfo;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(id="phone_mobile")
	WebElement mobile;
	
	@FindBy(id="alias")
	WebElement addressAlias;
	
	@FindBy(xpath="//button[@name='submitAccount']")
	WebElement register;
	
	
	public CreateAccountPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	

	public void createNewAccount(int gindex, String fname , String lName , String pwd ,
			String day , String month , String year,String comp , 
			String add1,String city , String state,String pcode,String country,String mobileNum,String alias)
	{
	
		genderRadio.get(gindex).click();
		firstName.sendKeys(fname);
		lstName.sendKeys(lName);
		password.sendKeys(pwd);
		objDays.selectByValue(day);
		objMonth.selectByValue(month);
		objYear.selectByValue(year);
		company.sendKeys(comp);
		address1.sendKeys(add1);
		ecity.sendKeys(city);
		objState.selectByVisibleText(state);
		postcode.sendKeys(pcode);
		objCountry.selectByVisibleText(country);
		mobile.sendKeys(mobileNum);
		addressAlias.sendKeys(alias);
		register.click();
		
	}
	

}
