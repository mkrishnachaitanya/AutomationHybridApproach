package com.saal.challenge.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saal.challenge.BaseClass.TestBase;
import com.saal.challenge.Pages.LoginPage;
import com.saal.challenge.Pages.SignInPage;
import com.saal.challenge.Utilities.TestUtility;

public class SignInPageTest extends TestBase
{	
	SignInPage signInPage;
	LoginPage loginPage;
	
	String sheetName = "RegistrationData"; //Passing Excel Sheet Name
	
	public SignInPageTest()
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
	
	@DataProvider
	public Object[][] getCRMContactsTestData() //To Access Sheet from Test Data Sheet
	{
		Object data [][] = TestUtility.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1) 
	public void verifySignInButtonTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		Assert.assertTrue(signInPage.verifySignInButton());
		Log.info("Sign In Button Verified");
	}
	
	@Test(priority=2)
	public void verifySignInPageTitleTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		String signInPageTitle = signInPage.verifySignInPageTitle();
		System.out.println("The Sign In Page Title is ::: " +signInPageTitle);
		Assert.assertEquals(signInPageTitle, "My Store", "Sign In Page Title is not Matched");
		Log.info("Sign In Page Title Verified");
	}
	
	@Test(priority=3, dataProvider="getCRMContactsTestData", enabled=false)
	public void registrationTest(Method method, String CustomerFirstName, String CustomerLastName, 
			String Password, String FirstName, String LastName, String Address, String City, 
			String State, String PostalCode, String Country, String MobileNumber, String AliasAddress)
	{
		extentTest = extent.startTest(method.getName());
		signInPage.enterEmailID(property.getProperty("RegistrationEmailID"));
		signInPage.enterDataToAllFields(CustomerFirstName, CustomerLastName, Password, FirstName, LastName, 
				Address, City, State, PostalCode, Country, MobileNumber, AliasAddress);
		Log.info("New User Registration is Successful");
	}
}
