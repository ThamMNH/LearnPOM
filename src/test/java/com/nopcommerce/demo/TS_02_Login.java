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
import PageObjects.LoginPageObject;
import PageObjects.RegisterPageObject;

public class TS_02_Login extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	String email = GlobalConstants.username;
	String password = GlobalConstants.password;
	String confirmPassword = GlobalConstants.password;
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		driver = getBrowserDriver(urlPage, browserName);
		loginPage = new LoginPageObject(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
//	@Test
//	public void TC_01_LoginWithEmptyData() {
//		loginPage.clickOnLoginButton();
//		Assert.assertTrue(loginPage.checkEmailErrorMessage("Please enter your email"));
//	}
//	
//	@Test
//	public void TC_02_LoginWithInvalidData() {
//		loginPage.refreshCurrentPage(driver);
//		loginPage.keyinEmailToTextbox("1234");
//		loginPage.clickOnLoginButton();
//		Assert.assertTrue(loginPage.checkEmailErrorMessage("Wrong email"));
//	}
//	
//	@Test
//	public void TC_03_LoginWithInvalidEmail() {
//		loginPage.refreshCurrentPage(driver);
//		loginPage.keyinEmailToTextbox("abc@gmail.com");
//		loginPage.clickOnLoginButton();
//		Assert.assertTrue(loginPage.checkLoginError("Login was unsuccessful. Please correct the errors and try again."));
//		Assert.assertTrue(loginPage.checkLoginError("No customer account found"));	
//	}
//	
//	@Test
//	public void TC_04_LoginWithEmptyPassword() {
//		loginPage.refreshCurrentPage(driver);
//		loginPage.keyinEmailToTextbox(email);
//		loginPage.keyinPasswordToTextbox("");
//		loginPage.clickOnLoginButton();
//		Assert.assertTrue(loginPage.checkLoginError("Login was unsuccessful. Please correct the errors and try again."));
//		Assert.assertTrue(loginPage.checkLoginError("No customer account found"));	
//	}
//	
//	@Test
//	public void TC_05_LoginWithInvalidPassword() {
//		loginPage.refreshCurrentPage(driver);
//		loginPage.keyinEmailToTextbox(email);
//		loginPage.keyinPasswordToTextbox("121212");
//		loginPage.clickOnLoginButton();
//		Assert.assertTrue(loginPage.checkLoginError("Login was unsuccessful. Please correct the errors and try again."));
//		Assert.assertTrue(loginPage.checkLoginError("No customer account found"));	
//	}
	
	@Test
	public void TC_06_LoginSuccessfully() {
		loginPage.refreshCurrentPage(driver);
		loginPage.keyinEmailToTextbox(email);
		loginPage.keyinPasswordToTextbox(password);
		loginPage.clickOnLoginButton();
		sleepInSeconds(3);
		Assert.assertTrue(loginPage.checkLoginSuccess("https://demo.nopcommerce.com/"));
	}
	
}
