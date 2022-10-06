package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Common.BaseTest;
import Common.GlobalConstants;
import PageObjects.HomePageObject;
import PageObjects.RegisterPageObject;

public class TS_00_Preconditions extends BaseTest{
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	String firstName = "Testing";
	String lastName = "ABC";
	String email = GlobalConstants.username;
	String password = GlobalConstants.password;
	String confirmPassword = GlobalConstants.password;
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		driver = getBrowserDriver(urlPage, browserName);
		registerPage = new RegisterPageObject(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_00_CreateAccountForTesting() {
		registerPage.refreshCurrentPage(driver);
		registerPage.keyinTextbox("FirstName", firstName);
		registerPage.keyinTextbox("LastName", lastName);
		registerPage.keyinTextbox("Email", email);
		registerPage.keyinTextbox("Password", password);
		registerPage.keyinTextbox("ConfirmPassword", confirmPassword);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkResultMessages("Your registration completed"));
		registerPage.clickToLogOutButton();
		sleepInSeconds(3);
//		homePage = new HomePageObject(driver);
//		homePage.clickToRegisterLink();
	}
}
