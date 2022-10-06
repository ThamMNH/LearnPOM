package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Common.BaseTest;
import PageObjects.HomePageObject;
import PageObjects.RegisterPageObject;

@Test
public class TS_01_Register extends BaseTest{
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	String firstName = "Testing";
	String lastName = "ABC";
	String email = "testingabc@gmail.com";
	String password = "123456";
	String confirmPassword = "123456";
	
	
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
	public void TC_00_Demo() {
		registerPage = new RegisterPageObject(driver);
		registerPage.openUrl (driver, "https://demo.nopcommerce.com/register?returnUrl=%2F%22);");
		String currentURL = registerPage.getPageUrl(driver);
		String currentTitle = registerPage.getPageTitle(driver);
		System.out.println("Title page hiện tại: "+ currentTitle);
		System.out.println("URL page hiện tại: "+ currentURL);
	}
	
	@Test
	public void TC_01_RegisterWithEmptyData() {
		registerPage.clickToRegisterButton();
//		Assert.assertTrue(registerPage.checkFirstnameErrorMessages("First name is required.")); 
//		Assert.assertTrue(registerPage.checkLastnameErrorMessages("Last name is required."));
//		Assert.assertTrue(registerPage.checkEmailErrorMessages("Email is required."));
//		Assert.assertTrue(registerPage.checkPasswordErrorMessages("Password is required."));
//		Assert.assertTrue(registerPage.checkConfirmPasswordErrorMessages("Password is required."));
		
		Assert.assertTrue(registerPage.checkErrorMessage("FirstName", "First name is required."));
		Assert.assertTrue(registerPage.checkErrorMessage("LastName", "Last name is required."));
		Assert.assertTrue(registerPage.checkErrorMessage("Email", "Email is required."));
		Assert.assertTrue(registerPage.checkErrorMessage("Password", "Password is required."));
		Assert.assertTrue(registerPage.checkErrorMessage("ConfirmPassword", "Password is required."));
		
		sleepInSeconds(3);
	}
	
	@Test
	public void TC_02_InvalidEmail() {
		registerPage.refreshCurrentPage(driver);
//		registerPage.enterTextToMailBox("abcxyz");
		registerPage.keyinTextbox("Email", email);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkErrorMessage("Email", "Wrong email"));
	}
	@Test
	public void TC_03_RegisterSuccess() {
		registerPage.refreshCurrentPage(driver);
//		registerPage.enterTextToFirstNameBox(firstName);
//		registerPage.enterTextToLastNameBox(lastName);
//		registerPage.enterTextToMailBox(email);
//		registerPage.enterTextToPasswordBox(password);
//		registerPage.enterTextToConfirmPasswordBox(confirmPassword);
		registerPage.keyinTextbox("FirstName", firstName);
		registerPage.keyinTextbox("LastName", lastName);
		registerPage.keyinTextbox("Email", email);
		registerPage.keyinTextbox("Password", password);
		registerPage.keyinTextbox("ConfirmPassword", confirmPassword);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkResultMessages("Your registration completed"));
		registerPage.clickToLogOutButton();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
	}
	@Test
	public void TC_04_RegisterWithValidEmail() {
		registerPage.refreshCurrentPage(driver);
//		registerPage.enterTextToFirstNameBox(firstName);
//		registerPage.enterTextToLastNameBox(lastName);
//		registerPage.enterTextToMailBox(email);
//		registerPage.enterTextToPasswordBox(password);
//		registerPage.enterTextToConfirmPasswordBox(confirmPassword);
		registerPage.keyinTextbox("FirstName", firstName);
		registerPage.keyinTextbox("LastName", lastName);
		registerPage.keyinTextbox("Email", email);
		registerPage.keyinTextbox("Password", password);
		registerPage.keyinTextbox("ConfirmPassword", confirmPassword);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkResultMessages("The specified email already exists"));
	}
	@Test
	public void TC_05_RegisterWithInvalidPassword() {
		registerPage.refreshCurrentPage(driver);
//		registerPage.enterTextToFirstNameBox(firstName);
//		registerPage.enterTextToLastNameBox(lastName);
//		registerPage.enterTextToMailBox(email);
//		registerPage.enterTextToPasswordBox("12345");
//		registerPage.enterTextToConfirmPasswordBox(confirmPassword);
		registerPage.keyinTextbox("FirstName", firstName);
		registerPage.keyinTextbox("LastName", lastName);
		registerPage.keyinTextbox("Email", email);
		registerPage.keyinTextbox("Password", password);
		registerPage.keyinTextbox("ConfirmPassword", confirmPassword);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkValidPassword("Password must meet the following rules:"));
		Assert.assertTrue(registerPage.checkValidPassword("must have at least 6 characters"));
	}
	@Test
	public void TC_06_RegisterWithInvalidConfirmPassword() {
		registerPage.refreshCurrentPage(driver);
//		registerPage.enterTextToFirstNameBox(firstName);
//		registerPage.enterTextToLastNameBox(lastName);
//		registerPage.enterTextToMailBox(email);
//		registerPage.enterTextToPasswordBox(password);
//		registerPage.enterTextToConfirmPasswordBox("132456");
		registerPage.keyinTextbox("FirstName", firstName);
		registerPage.keyinTextbox("LastName", lastName);
		registerPage.keyinTextbox("Email", email);
		registerPage.keyinTextbox("Password", password);
		registerPage.keyinTextbox("ConfirmPassword", "132456");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkValidPassword("The password and confirmation password do not match."));
		
	}
}
