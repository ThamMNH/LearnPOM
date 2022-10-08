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
import PageObjects.ShoppingCartPageObject;

public class TS_06_ShoppingCart extends BaseTest{
	WebDriver driver;
	ShoppingCartPageObject shoppingCart;
	LoginPageObject loginPage;
	HomePageObject homePage;
	String email = GlobalConstants.username;
	String password = GlobalConstants.new_passpord;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/cart";
		driver = getBrowserDriver(urlPage, browserName);
		shoppingCart = new ShoppingCartPageObject(driver);
		loginPage = new LoginPageObject(driver);
		homePage = new HomePageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_UpdateShoppingCart() {
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		loginPage = new LoginPageObject(driver);		
		loginPage.refreshCurrentPage(driver);
		loginPage.keyinEmailToTextbox(email);
		loginPage.keyinPasswordToTextbox(password);
		loginPage.clickOnLoginButton();
		
		homePage = new HomePageObject(driver);
		homePage.clickToShoppingCartLink();
		shoppingCart.keyinQuantity("5");
//		homePage.sendEnterToElement();
		shoppingCart.clickOnUpdateShoppingCartButton();
		Assert.assertTrue(shoppingCart.checkQuantity("5"));
	}

	@Test
	public void TC_02_RemoveFromCart() {
		shoppingCart.refreshCurrentPage(driver);
		shoppingCart.clickToRemoveButton();
		Assert.assertTrue(shoppingCart.checkEmptyCartMessage("Your Shopping Cart is empty!"));
	}
}
