package com.saal.challenge.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saal.challenge.BaseClass.TestBase;
import com.saal.challenge.Pages.LoginPage;
import com.saal.challenge.Pages.SignInPage;

public class LoginPageTest extends TestBase
{
	SignInPage signInPage;
	LoginPage loginPage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@Parameters("Browser")
	@BeforeMethod
	public void setUp(String Browser)
	{		
		initialization(Browser);
		Log.info("Browser Launched Successfully");
		
		signInPage = new SignInPage();
		loginPage = new LoginPage();	
	}

	@Test(priority=1) 
	public void loginTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		loginPage.login(property.getProperty("EmailID"),property.getProperty("Password"));
		Log.info("Successfully Logged into Application");
	}
	
	@Test(priority=2) 
	public void verifyCorrectUserNameTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		loginPage.login(property.getProperty("EmailID"),property.getProperty("Password"));
		
		Log.info("Successfully Logged into Application");
		Assert.assertTrue(loginPage.verifyCorrectUserName());
		Log.info("UserName Verified");
	}
	
	@Test(priority=3)
	public void verifyHomePageTitleTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		loginPage.login(property.getProperty("EmailID"),property.getProperty("Password"));
		Log.info("Successfully Logged into Application");
		
		String loginPageTitle = loginPage.verifyLoginPageTitle();
		System.out.println("The Login Page Title is ::: " +loginPageTitle);
		Assert.assertEquals(loginPageTitle, "My account - My Store123", "Login Page Title is not Matched");
		Log.info("Login Page Title Verified");
	}
	
	@Test(priority=4) 
	public void verifySignOutButtonTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		loginPage.login(property.getProperty("EmailID"),property.getProperty("Password"));
		Log.info("Successfully Logged into Application");
		
		Assert.assertTrue(loginPage.verifySignOutButton());
		Log.info("Sign Out Button Verified");
	}
}
