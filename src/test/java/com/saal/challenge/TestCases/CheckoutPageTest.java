package com.saal.challenge.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saal.challenge.BaseClass.TestBase;
import com.saal.challenge.Pages.CheckoutPage;
import com.saal.challenge.Pages.LoginPage;
import com.saal.challenge.Pages.SignInPage;

public class CheckoutPageTest extends TestBase
{
	SignInPage signInPage;
	LoginPage loginPage;
	CheckoutPage checkoutPage;
	
	public CheckoutPageTest()
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
		checkoutPage = new CheckoutPage();
		
		loginPage.login(property.getProperty("EmailID"),property.getProperty("Password"));
	}
	
	@Test(priority=1) 
	public void loginTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		checkoutPage.checkoutMetod();
		Log.info("Order is Placed Successfully");
	}
	
	@Test(priority=2) 
	public void orderConfirmationValidateTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		checkoutPage.checkoutMetod();
		String orderSuccessMessage = checkoutPage.orderCompletionValidation();
		System.out.println("The Order Confirmation Message is ::: " +orderSuccessMessage);
		Assert.assertEquals(orderSuccessMessage, "Your order on My Store is complete.");
		Log.info("Order Confirmation Success Message is Validated Successfully");
	}
}
