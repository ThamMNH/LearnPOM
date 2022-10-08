package PageObjects;

import org.openqa.selenium.WebDriver;

import Common.BasePage;
import PageUI.MyAccountPageUI;
import PageUI.SearchPageUI;

public class SearchPageObject extends BasePage{
	WebDriver driver;

	// constructor
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String keyinSearchTextbox(String value) {
		return getAttributeValue(driver, SearchPageUI.SEARCH_INPUT_TEXTBOX, value);
	}
	
	public void clickOnSearchButton() {
		waitForElementVisisble(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}
	
	public boolean checkSearchErrorMessage(String value) {
		String errorMessage = getTextOfElement (driver, SearchPageUI.SEARCH_ERROR_MESSAGE);
		return errorMessage.equals(value);
	}
	
	public boolean checkNoSearchResultMessage(String value) {
		String noResultMessage = getTextOfElement (driver, SearchPageUI.NO_SEARCH_RESULT_MESSAGE);
		return noResultMessage.equals(value);
	}
	
	public void clickToAdvanceCheckbox() {
		waitForElementVisisble(driver, SearchPageUI.ADVS_CHECKBOX);
		clickToElement(driver, SearchPageUI.ADVS_CHECKBOX);
	}
	
	public void selectCategory(String text) {
		waitForElementVisisble(driver, SearchPageUI.SELECT_CATEGORY);
		selectDropdown(driver, SearchPageUI.SELECT_CATEGORY, text);
	}
	
	public void clickToSubCategoriesCheckbox() {
		waitForElementVisisble(driver, SearchPageUI.SEARCH_SUBCATEGORY_CHECKBOX);
		clickToElement(driver, SearchPageUI.SEARCH_SUBCATEGORY_CHECKBOX);
	}
		
	public boolean isSearchProductTitleDisplayedOnPageAsExpected(String value) {
		return isTitleDisplayedOnPage(driver, SearchPageUI.PRODUCT_TITLE, value);
	}
	
	public boolean checkDisplayItems(String value) {
		waitForElementVisisble(driver, SearchPageUI.PRODUCT_TITLE);
		String productTitle = getTextOfElement(driver, SearchPageUI.PRODUCT_TITLE);
		return productTitle.contains(value);
	}

}

