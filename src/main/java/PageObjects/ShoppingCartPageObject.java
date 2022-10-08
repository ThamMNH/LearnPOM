package PageObjects;

import org.openqa.selenium.WebDriver;

import Common.BasePage;
import PageUI.ShoppingCartPageUI;
import PageUI.WishlistPageUI;

public class ShoppingCartPageObject extends BasePage{
	WebDriver driver;

	// constructor
	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void keyinQuantity(String value) {
		waitForElementVisisble(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX);
		doubleclickToElement(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX);
	}

	public void clickOnUpdateShoppingCartButton() {
		waitForElementVisisble(driver, ShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
	}
	
	public boolean checkQuantity(String value) {
		String quantity = getAttributeValue(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX, "value");
		return quantity.equals(value);
	}
	
	public void clickToRemoveButton() {
		waitForElementVisisble(driver, ShoppingCartPageUI.REMOVE_PRODUCT_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.REMOVE_PRODUCT_BUTTON);
	}
	
	public boolean checkEmptyCartMessage(String value) {
		waitForElementVisisble(driver, ShoppingCartPageUI.EMPTY_SHOPPING_CART_MESSAGE);
		String quantity = getTextOfElement(driver, ShoppingCartPageUI.EMPTY_SHOPPING_CART_MESSAGE, "value");
		return quantity.equals(value);
	}

	public boolean checkProductsInShoppingCart(String value) {
		String productName = getTextOfElement(driver, ShoppingCartPageUI.PRODUCT_NAME);
		return productName.equals(value);
	
	}
	
}