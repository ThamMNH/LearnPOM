package PageObjects;

import org.openqa.selenium.WebDriver;

import Common.BasePage;
import PageUI.HomePageUI;
import PageUI.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void updateFirstNameToTextbox(String firstName) {
		waitForElementVisisble(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void updateLastNameToTextbox(String lastName) {
		waitForElementVisisble(driver, MyAccountPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(driver, MyAccountPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void updateEmailToTextbox(String email) {
		waitForElementVisisble(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickOnSaveButton() {
		waitForElementVisisble(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	public String getLastnameValue(String value) {
		return getAttributeValue(driver, MyAccountPageUI.LASTNAME_TEXTBOX, value);
	}

	public void clickOnAddressTab() {
		waitForElementVisisble(driver, MyAccountPageUI.ADDRESS_TAB);
		clickToElement(driver, MyAccountPageUI.ADDRESS_TAB);
	}
	
	public String getTitleOfAccountPage() {
		String title = getTextOfElement(driver, MyAccountPageUI.PAGE_TITLE);
		return title;
	}
	
	public void clickOnAddnewButton() {
		waitForElementVisisble(driver, MyAccountPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADD_NEW_BUTTON);
	}
	
	public void keyinFirstNameInAddress() {
		waitForElementVisisble(driver, MyAccountPageUI.ADDRESS_FIRSTNAME_TEXTBOX);
		clickToElement(driver, MyAccountPageUI.ADDRESS_FIRSTNAME_TEXTBOX);
	}
	
	public void keyinLastNameInAddress() {
		waitForElementVisisble(driver, MyAccountPageUI.ADDRESS_FIRSTNAME_TEXTBOX);
		clickToElement(driver, MyAccountPageUI.ADDRESS_LASTNAME_TEXTBOX);
	}
	
	public void keyinEmailInAddress() {
		waitForElementVisisble(driver, MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX);
		clickToElement(driver, MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX);
	}
	
	public void selectCountryInAddress() {
		waitForElementVisisble(driver, MyAccountPageUI.ADDRESS_COUNTRY_SELECTION);
		clickToElement(driver, MyAccountPageUI.ADDRESS_COUNTRY_SELECTION);
	}
	
	public void selectVietnamInCountryList() {
		waitForElementVisisble(driver, MyAccountPageUI.SELECT_VIETNAM);
		clickToElement(driver, MyAccountPageUI.SELECT_VIETNAM);
	}
	
	public void keyinCityInAddress() {
		waitForElementVisisble(driver, MyAccountPageUI.ADDRESS_CITY_TEXTBOX);
		clickToElement(driver, MyAccountPageUI.ADDRESS_CITY_TEXTBOX);
	}
	
	public void keyinAddress1InAddress() {
		waitForElementVisisble(driver, MyAccountPageUI.ADDRESS_ADDRESS1_TEXTBOX);
		clickToElement(driver, MyAccountPageUI.ADDRESS_ADDRESS1_TEXTBOX);
	}
	
	public void keyinPostalCodeInAddress() {
		waitForElementVisisble(driver, MyAccountPageUI.ADDRESS_POSTAL_CODE_TEXTBOX);
		clickToElement(driver, MyAccountPageUI.ADDRESS_POSTAL_CODE_TEXTBOX);
	}
	
	public void keyinPhoneInAddress() {
		waitForElementVisisble(driver, MyAccountPageUI.ADDRESS_PHONE_TEXTBOX);
		clickToElement(driver, MyAccountPageUI.ADDRESS_PHONE_TEXTBOX);
	}
	
	public void clickOnSaveButtonInAddress() {
		waitForElementVisisble(driver, MyAccountPageUI.ADDRESS_SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADDRESS_SAVE_BUTTON);
	}
	
	public String getAddressFirstnameValue(String value) {
		return getAttributeValue(driver, MyAccountPageUI.ADDRESS_FIRSTNAME_TEXTBOX, value);
	}
	
	public String getAddressLastnameValue(String value) {
		return getAttributeValue(driver, MyAccountPageUI.ADDRESS_LASTNAME_TEXTBOX, value);
	}
	
	public String getAddressEmailValue(String value) {
		return getAttributeValue(driver, MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX, value);
	}
	
	public String getcountryValue(String value) {
		return getAttributeValue(driver, MyAccountPageUI.ADDRESS_COUNTRY_SELECTION, value);
	}
	
	public String getVietnamValue(String value) {
		return getAttributeValue(driver, MyAccountPageUI.SELECT_VIETNAM, value);
	}
	
	public String getAddressCityValue(String value) {
		return getAttributeValue(driver, MyAccountPageUI.ADDRESS_CITY_TEXTBOX, value);
	}
	
	public String getAddressAddress1Value(String value) {
		return getAttributeValue(driver, MyAccountPageUI.ADDRESS_ADDRESS1_TEXTBOX, value);
	}
	
	public String getAddressPostalCodeValue(String value) {
		return getAttributeValue(driver, MyAccountPageUI.ADDRESS_POSTAL_CODE_TEXTBOX, value);
	}
	
	public String getAddressPhoneValue(String value) {
		return getAttributeValue(driver, MyAccountPageUI.ADDRESS_PHONE_TEXTBOX, value);
	}
	
	public void clickOnChangePasswordTab() {
		waitForElementVisisble(driver, MyAccountPageUI.UPDATE_PASSWORD_TAB);
		clickToElement(driver, MyAccountPageUI.UPDATE_PASSWORD_TAB);
	}
	
	public void keyinOldPassword () {
		waitForElementVisisble(driver, MyAccountPageUI.OLD_PASSWORD);
		clickToElement(driver, MyAccountPageUI.OLD_PASSWORD);
	}
	
	public void keyinNewPassword () {
		waitForElementVisisble(driver, MyAccountPageUI.NEW_PASSWORD);
		clickToElement(driver, MyAccountPageUI.NEW_PASSWORD);
	}
	
	public void keyinConfirmNewPassword () {
		waitForElementVisisble(driver, MyAccountPageUI.CONFIRM_NEW_PASSWORD);
		clickToElement(driver, MyAccountPageUI.CONFIRM_NEW_PASSWORD);
	}
	
	public void clickOnChangePasswordButton () {
		waitForElementVisisble(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
	}
	
	public String getOldPasswordValue(String value) {
		return getAttributeValue(driver, MyAccountPageUI.OLD_PASSWORD, value);
	}
	
	public String getNewPasswordValue(String value) {
		return getAttributeValue(driver, MyAccountPageUI.NEW_PASSWORD, value);
	}
	
	public String getConfirmNewPasswordValue(String value) {
		return getAttributeValue(driver, MyAccountPageUI.NEW_PASSWORD, value);
	}
	
	public String getPasswordChangeNotification() {
		String PasswordNotification = getTextOfElement(driver, MyAccountPageUI.PASSWORD_CHANGE_NOTIFICATION);
		return PasswordNotification;
	}
	
	public void clickOnCloseNotificationButton() {
		waitForElementVisisble(driver, MyAccountPageUI.CLOSE_NOTIFICATION_BUTTON);
		clickToElement(driver, MyAccountPageUI.CLOSE_NOTIFICATION_BUTTON);
	}
	
	public void clickToLogoutLink () {
		waitForElementClickable (driver, MyAccountPageUI.LOGOUT_LINK);
		clickToElement (driver, MyAccountPageUI.LOGOUT_LINK);
	}
}















