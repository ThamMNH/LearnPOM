package PageObjects;

import org.openqa.selenium.WebDriver;

import Common.BasePage;
import PageUI.HomePageUI;
import PageUI.RegisterPageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	//constructor
	public HomePageObject (WebDriver driver) {
		this.driver= driver;
	}
	
	public void clickToRegisterLink(){
		waitForElementClickable (driver, HomePageUI.REGISTER_LINK);
		clickToElement (driver, HomePageUI.REGISTER_LINK);
	}
	public void clickToLoginLink(){
		waitForElementClickable (driver, HomePageUI.LOGIN_LINK);
		clickToElement (driver, HomePageUI.LOGIN_LINK);
	}
	
	public void clickToWishlistLink(){
		waitForElementClickable (driver, HomePageUI.WISHLIST_LINK);
		clickToElement (driver, HomePageUI.WISHLIST_LINK );
	}
	
	public void clickToShoppingCartLink(){
		waitForElementClickable (driver, HomePageUI.SHOPPING_CART_LINK);
		clickToElement (driver, HomePageUI.SHOPPING_CART_LINK);
	}
	
	public void clickToMyaccountPage(){
		waitForElementClickable (driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement (driver, HomePageUI.MY_ACCOUNT_LINK);
	}
	
	

}
