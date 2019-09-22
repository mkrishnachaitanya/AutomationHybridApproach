package com.saal.challenge.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saal.challenge.BaseClass.TestBase;
import com.saal.challenge.Utilities.TestUtility;

public class SignInPage extends TestBase
{
	@FindBy(xpath = "//a[@class='login']")
	WebElement clickOnSingIn;
	
	@FindBy(xpath = "//input[@id='email_create']")
	WebElement emailID;
	
	@FindBy(xpath = "//form[@id='create-account_form']//span[1]")
	WebElement clickOnCreateAccount;
	
	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement clickOnGenderMaleButton;
	
	@FindBy(xpath = "//input[@id='customer_firstname']")
	WebElement customerFirstName;
	
	@FindBy(xpath = "//input[@id='customer_lastname']")
	WebElement customerLastName;
	
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement address1;
	
	@FindBy(xpath = "//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath = "//select[@id='id_state']")
	WebElement state;
	
	@FindBy(xpath = "//input[@id='postcode']")
	WebElement postalCode;
	
	@FindBy(xpath = "//select[@id='id_country']")
	WebElement country;
	
	@FindBy(xpath = "//input[@id='phone_mobile']")
	WebElement mobileNumber;
	
	@FindBy(xpath = "//input[@id='alias']")
	WebElement aliasAddress;
	
	@FindBy(xpath = "//span[contains(text(),'Register')]")
	WebElement clickOnRegisterButton;
	
	public SignInPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailID(String enterEmailID)
	{
		clickOnSingIn.click();
		emailID.sendKeys(enterEmailID);
		clickOnCreateAccount.click();
	}
	
	public boolean verifySignInButton()
	{
		return clickOnSingIn.isDisplayed();
	}
	
	public String verifySignInPageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterDataToAllFields(String firstNames, String lastNames , 
			String passwords, String fFirstName, String lLastName, String aAddress1, String cCity, 
			String sState, String pPostalCode, String cCountry, String mNumber, String aAddress)
	{
		clickOnGenderMaleButton.click();
		customerFirstName.sendKeys(firstNames);
		customerLastName.sendKeys(lastNames);
		password.sendKeys(passwords);
		firstName.sendKeys(fFirstName);
		lastName.sendKeys(lLastName);
		address1.sendKeys(aAddress1);
		city.sendKeys(cCity);
		TestUtility.selectValueFromDropDown(state, sState);
		postalCode.sendKeys(pPostalCode);
		TestUtility.selectValueFromDropDown(country, cCountry);
		mobileNumber.sendKeys(mNumber);
		aliasAddress.sendKeys(aAddress);
		clickOnRegisterButton.click();
	}
}
