package com.saal.challenge.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saal.challenge.BaseClass.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(xpath = "//a[@class='login']")
	WebElement singIn;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailID;
	
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath = "//p[@class='submit']//span[1]")
	WebElement clickOnSingIn;
	
	@FindBy(xpath = "//span[contains(text(),'Pavan Kumar')]")
	WebElement userNameValidate;
	
	@FindBy(xpath = "//a[@class='logout']")
	WebElement signOut;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login(String uname, String pword)
	{
		singIn.click();
		emailID.sendKeys(uname);
		password.sendKeys(pword);
		clickOnSingIn.click();
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameValidate.isDisplayed();
	}
	
	public String verifyLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifySignOutButton()
	{
		return signOut.isDisplayed();
	}
}
