package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Common.BaseTest;
import Common.GlobalConstants;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.MyAccountPageObject;
import PageUI.HomePageUI;
import PageUI.MyAccountPageUI;

public class TS_03_MyAccount extends BaseTest{

	WebDriver driver;
	MyAccountPageObject myAccountPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	String updateFirstName = GlobalConstants.update_firstName;
	String updateLastName = GlobalConstants.update_lastName;
	String email = GlobalConstants.username;
	String password = GlobalConstants.password;
	String confirmPassword = GlobalConstants.password;
	String addressFirstName = GlobalConstants.address_firstname;
	String addressLastName = GlobalConstants.address_lastname;
	String addressEmail = GlobalConstants.username;
	String addressCity = GlobalConstants.address_city;
	String addressAddress1 = GlobalConstants.address_address1;
	String addressPostalCode = GlobalConstants.address_postal_code;
	String addressPhone = GlobalConstants.address_phone;
	String oldPassword = GlobalConstants.password;
	String newPassword = GlobalConstants.new_passpord;
	String confirmNewPassword = GlobalConstants.new_passpord;
	
	@Parameters({"browser"})
	
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		driver = getBrowserDriver(urlPage, browserName);
		loginPage = new LoginPageObject(driver);
//		myAccountPage = new MyAccountPageObject(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
//	@Test
	public void TC_01_UpdateCustomerInfo() {
		loginPage.refreshCurrentPage(driver);
		loginPage.keyinEmailToTextbox(email);
		loginPage.keyinPasswordToTextbox(password);
		loginPage.clickOnLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertEquals(homePage.getPageUrl(driver),"https://demo.nopcommerce.com/");
		homePage.clickToMyaccountPage();
		myAccountPage = new MyAccountPageObject(driver);
		myAccountPage.updateFirstNameToTextbox(updateFirstName);
		myAccountPage.updateLastNameToTextbox(updateLastName);
		myAccountPage.updateEmailToTextbox(email);
		myAccountPage.clickOnSaveButton();
//		myAccountPage.getLastnameValue("value");
		Assert.assertEquals(myAccountPage.getLastnameValue("value"),updateLastName);
		sleepInSeconds(3);
	}
	
	@Test
	public void TC_02_UpdateAddress() {
		myAccountPage.clickOnAddressTab();
		Assert.assertEquals(myAccountPage.getTitleOfAccountPage(), "My account - Addresses");
		myAccountPage.clickOnAddnewButton();
		Assert.assertEquals(myAccountPage.getTitleOfAccountPage(), "My account - Add new address");
		myAccountPage.keyinFirstNameInAddress();
		Assert.assertEquals(myAccountPage.getAddressFirstnameValue("value"), addressFirstName);
		myAccountPage.keyinLastNameInAddress();
		Assert.assertEquals(myAccountPage.getAddressLastnameValue("value"), addressLastName);
		myAccountPage.keyinEmailInAddress();
		Assert.assertEquals(myAccountPage.getAddressEmailValue("value"), addressEmail);
		myAccountPage.selectCountryInAddress();
		myAccountPage.selectVietnamInCountryList();
		Assert.assertEquals(myAccountPage.getVietnamValue("value"), "Viet Nam");
		myAccountPage.keyinCityInAddress();
		Assert.assertEquals(myAccountPage.getAddressCityValue("value"), addressCity);
		myAccountPage.keyinAddress1InAddress();
		Assert.assertEquals(myAccountPage.getAddressAddress1Value("value"), addressAddress1);
		myAccountPage.keyinPostalCodeInAddress();
		Assert.assertEquals(myAccountPage.getAddressPostalCodeValue("value"), addressPostalCode);
		myAccountPage.keyinPhoneInAddress();
		Assert.assertEquals(myAccountPage.getAddressPhoneValue("value"), addressPhone);
		myAccountPage.clickOnSaveButton();
		
		
	}
	
	@Test
	public void TC_03_UpdatePassword() {
		myAccountPage.refreshCurrentPage(driver);
		myAccountPage.clickOnChangePasswordTab();
		Assert.assertEquals(myAccountPage.getTitleOfAccountPage(), "My account - Change password");
		myAccountPage.clickOnAddnewButton();
		
		myAccountPage.getOldPasswordValue(password);
		myAccountPage.getNewPasswordValue(newPassword);
		myAccountPage.getConfirmNewPasswordValue(confirmNewPassword);
		myAccountPage.clickOnChangePasswordButton();
		Assert.assertEquals(myAccountPage.getPasswordChangeNotification(), "Password was changed");
		myAccountPage.clickOnCloseNotificationButton();
		myAccountPage.clickToLogoutLink();
		
		homePage.clickToLoginLink();
		loginPage.keyinEmailToTextbox(email);
		loginPage.keyinPasswordToTextbox(password);
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.checkLoginError("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.checkLoginError("The credentials provided are incorrect"));	
		
		loginPage.keyinPasswordToTextbox(newPassword);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(homePage.getPageUrl(driver),"https://demo.nopcommerce.com/");
		
	}
	
}
