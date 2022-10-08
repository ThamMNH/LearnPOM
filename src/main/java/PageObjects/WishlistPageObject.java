package PageObjects;

import org.openqa.selenium.WebDriver;

import Common.BasePage;
import PageUI.SearchPageUI;
import PageUI.WishlistPageUI;

public class WishlistPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnProductMenuBooks () {
		waitForElementVisisble(driver, WishlistPageUI.PRODUCT_MENU_BOOKS);
		clickToElement(driver, WishlistPageUI.PRODUCT_MENU_BOOKS);
	}
	
	public void clickOnAddToCartButton() {
		waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
	}
		
	public void clickOnToWishlistButton() {
		waitForElementClickable(driver, WishlistPageUI.WISHLIST_BUTTON);
		clickToElement(driver, WishlistPageUI.WISHLIST_BUTTON);
	}

	public boolean checkAddToWishlistSuccess(String value) {
		String message = getTextOfElement(driver, WishlistPageUI.WISHLIST_ADDED_MESSAGE);
		return message.contains(value);
	}

	public void clickToCloseWishlistMessage() {
		waitForElementClickable(driver, WishlistPageUI.CLOSE_WISHLIST_ADDED_MESSAGE);
		clickToElement(driver, WishlistPageUI.CLOSE_WISHLIST_ADDED_MESSAGE);
	}
	
	public boolean checkProductsInWishlist(String value) {
		String productName = getTextOfElement(driver, WishlistPageUI.PRODUCT_NAME_IN_WISHLIST);
		return productName.equals(value);
	}
	
	public void clickToAddToCartCheckBox() {
		waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
		clickToElement(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
	}

	public boolean checkWishlistEmpty(String value) {
		String message = getTextOfElement(driver, WishlistPageUI.EMPTY_WISHLIST_MESSAGE);
		return message.equals(value);
	}

}


	

	