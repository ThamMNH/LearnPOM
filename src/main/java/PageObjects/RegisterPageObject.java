package PageObjects;

import org.openqa.selenium.WebDriver;

import Common.BasePage;
import PageUI.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	WebDriver driver;
	
	//constructor
	public RegisterPageObject (WebDriver driver) {
		this.driver= driver;
	}
	
	public void clickToRegisterButton(){
		waitForElementClickable (driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement (driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
//	public boolean checkFirstnameErrorMessages (String value) {
//		String errorMessage = getTextOfElement (driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
//	
//	public boolean checkLastnameErrorMessages (String value) {
//		String errorMessage = getTextOfElement (driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
//	
//	public boolean checkEmailErrorMessages (String value) {
//		String errorMessage = getTextOfElement (driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
//	
//	public boolean checkPasswordErrorMessages (String value) {
//		String errorMessage = getTextOfElement (driver, RegisterPageUI.PASS_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
//	
//	public boolean checkConfirmPasswordErrorMessages (String value) {
//		String errorMessage = getTextOfElement (driver, RegisterPageUI.CONFIRM_PASS_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
	
	public boolean checkErrorMessage(String textboxName, String value) {
		String errorMessage = getTextOfElement (driver, RegisterPageUI.ERROR_MESSAGE, textboxName);
		return errorMessage.equals(value);
	}
	
	public boolean checkResultMessages (String value) {
		String errorMessage = getTextOfElement (driver, RegisterPageUI.RESULT_MESSAGE);
		return errorMessage.equals(value);
	}
	
//	public void enterTextToMailBox(String email) {
//		waitForElementVisisble(driver,RegisterPageUI.EMAIL_TEXTBOX);
//		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
//	}
//	
//	public void enterTextToFirstNameBox(String firstName) {
//		waitForElementVisisble(driver,RegisterPageUI.FIRSTNAME_TEXTBOX);
//		sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
//	}
//	
//	public void enterTextToLastNameBox(String lastName) {
//		waitForElementVisisble(driver,RegisterPageUI.LASTNAME_TEXTBOX);
//		sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
//	}
//	
//	public void enterTextToPasswordBox(String password) {
//		waitForElementVisisble(driver,RegisterPageUI.PASSWORD_TEXTBOX);
//		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
//	}
//	
//	public void enterTextToConfirmPasswordBox(String cfpassword) {
//		waitForElementVisisble(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
//		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, cfpassword);
//	}
	
	public void keyinTextbox(String textboxName,String value) {
		waitForElementVisisble(driver, RegisterPageUI.INPUT_TEXTBOX, textboxName);
		sendKeysToElement(driver, RegisterPageUI.INPUT_TEXTBOX, value, textboxName); 
	}
	
	public void clickToLogOutButton(){
		waitForElementClickable (driver, RegisterPageUI.LOGOUT_BUTTON);
		clickToElement (driver, RegisterPageUI.LOGOUT_BUTTON);
	}
	
	public boolean checkExistEmailMessages (String value) {
		String errorMessage = getTextOfElement (driver, RegisterPageUI.EXIST_EMAIL_MESSAGE);
		return errorMessage.equals(value);
	}
	
	public boolean checkValidPassword (String value) {
		String errorMessage = getTextOfElement (driver, RegisterPageUI.INVALID_PASSWORD);
		return errorMessage.contains(value);
	}
	
	public boolean checkInvalidPassword (String value) {
		String errorMessage = getTextOfElement (driver, RegisterPageUI.INVALID_CONFIRM_PASSWORD);
		return errorMessage.contains(value);
	}
}
