package PageObjects;

import org.openqa.selenium.WebDriver;

import Common.BasePage;
import PageUI.HomePageUI;
import PageUI.LoginPageUI;
import PageUI.RegisterPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public LoginPageObject (WebDriver driver) {
		this.driver= driver;
	}
	
	public void keyinEmailToTextbox(String email) {
		waitForElementVisisble(driver,LoginPageUI.EMAIL);
		sendKeysToElement(driver, LoginPageUI.EMAIL, email);
	}
	
	public boolean checkEmailErrorMessage (String value) {
		String errorMessage = getTextOfElement (driver, LoginPageUI.EMAIL_ERROR_MESSAGE );
		return errorMessage.equals(value);
	}
	
	public void keyinPasswordToTextbox(String password) {
		waitForElementVisisble(driver,LoginPageUI.PASSWORD);
		sendKeysToElement(driver, LoginPageUI.PASSWORD, password);
	}
	
	public void clickOnLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	
	public boolean checkLoginError(String value) {
		String errorMessage = getTextOfElement(driver, LoginPageUI.LOGIN_ERROR_MESSAGE);
		return errorMessage.contains(value);
	}
	
	public boolean checkLoginSuccess (String url) {
		waitForElementVisisble(driver, HomePageUI.HOME_PAGE);
		String pageURL = getPageUrl(driver);
		return pageURL.equals(url) ;
	}
}


