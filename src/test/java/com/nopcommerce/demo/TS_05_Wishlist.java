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
import PageObjects.SearchPageObject;
import PageObjects.ShoppingCartPageObject;
import PageObjects.WishlistPageObject;

public class TS_05_Wishlist extends BaseTest{
	WebDriver driver;
	WishlistPageObject wishlistPage;
	SearchPageObject searchPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	ShoppingCartPageObject shoppingCartPage;
	String email = GlobalConstants.username;
	String password = GlobalConstants.new_passpord;


	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/wishlist";
		driver = getBrowserDriver(urlPage, browserName);
		wishlistPage = new WishlistPageObject(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_01_AddProductToWishlist() {
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		loginPage = new LoginPageObject(driver);		
		loginPage.refreshCurrentPage(driver);
		loginPage.keyinEmailToTextbox(email);
		loginPage.keyinPasswordToTextbox(password);
		loginPage.clickOnLoginButton();
		
		wishlistPage.clickOnProductMenuBooks();
		wishlistPage.clickOnToWishlistButton();
		wishlistPage.checkAddToWishlistSuccess("The product has been added to your wishlist");
		wishlistPage.clickToCloseWishlistMessage();
		
		homePage = new HomePageObject(driver);
		homePage.clickToWishlistLink();
		Assert.assertTrue(wishlistPage.checkProductsInWishlist("First Prize Pies"));
		
	}
	@Test
	public void TC_02_AddProductIntoShoppingcartFromWishlist() {
		wishlistPage.refreshCurrentPage(driver);
		wishlistPage.clickToAddToCartCheckBox();
		wishlistPage.clickOnAddToCartButton();
		
		shoppingCartPage = new ShoppingCartPageObject(driver);
		Assert.assertTrue(shoppingCartPage.checkProductsInShoppingCart("First Prize Pies"));
		homePage.clickToWishlistLink();
		Assert.assertTrue(wishlistPage.checkWishlistEmpty("The wishlist is empty!"));
	}
	
}
