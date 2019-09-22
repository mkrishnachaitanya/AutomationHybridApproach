package com.saal.challenge.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saal.challenge.BaseClass.TestBase;
import com.saal.challenge.Utilities.TestUtility;

public class CheckoutPage extends TestBase
{
	@FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
	WebElement clickOnWomenButton;
	
	@FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
	WebElement clickOnFadedSleeveShirts;
	
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	WebElement addToCart;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement clickOnProceedToCheckOut1;
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement clickOnProceedToCheckOut2;
	
	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement clickOnProceedToCheckOut3;
	
	@FindBy(xpath = "//input[@id='cgv']")
	WebElement termsAndConditions;
	
	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement clickOnProceedToCheckOut4;
	
	@FindBy(xpath = "//a[@class='bankwire']")
	WebElement payByBankWire;
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrder;
	
	@FindBy(xpath = "//strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement orderComplete;
	
	public CheckoutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkoutMetod()
	{
		clickOnWomenButton.click();
		clickOnFadedSleeveShirts.click();
		addToCart.click();
		TestUtility.clickUsingJavaScriptExecutor(clickOnProceedToCheckOut1);
		clickOnProceedToCheckOut2.click();
		clickOnProceedToCheckOut3.click();
		termsAndConditions.click();
		clickOnProceedToCheckOut4.click();
		payByBankWire.click();
		confirmOrder.click();
	}
	
	public String orderCompletionValidation()
	{
		return orderComplete.getText();
	}
}
