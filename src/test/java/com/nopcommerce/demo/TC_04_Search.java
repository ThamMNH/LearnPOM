package com.nopcommerce.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class TC_04_Search extends BaseTest{
	WebDriver driver;
	SearchPageObject searchPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	String invalidData = GlobalConstants.search_invalid_item;
	String validData1 = GlobalConstants.search_valid_item1;
	String validData2 = GlobalConstants.search_valid_item2;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/search";
		driver = getBrowserDriver(urlPage, browserName);
		searchPage = new SearchPageObject(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_01_SearchWithEmptyData() {
		searchPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.checkSearchErrorMessage("Search term minimum length is 3 characters"));
	}
	
	@Test
	public void TC_02_SearchWithInvalidData() {
		searchPage.refreshCurrentPage(driver);
		searchPage.keyinSearchTextbox(invalidData);
		searchPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.checkNoSearchResultMessage("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_03_SearchLenovo() {
		searchPage.refreshCurrentPage(driver);
		searchPage.keyinSearchTextbox(validData1);
		searchPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.isSearchProductTitleDisplayedOnPageAsExpected("Lenovo"));
	}
	
	@Test
	public void TC_04_AdvanceSearchWithParentCategories() {
		searchPage.refreshCurrentPage(driver);
		searchPage.keyinSearchTextbox(validData1);
		searchPage.clickToAdvanceCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.checkNoSearchResultMessage("No products were found that matched your criteria."));		
	}
	
	@Test
	public void TC_05_AdvanceSearchWithSubCategories() {
		searchPage.refreshCurrentPage(driver);
		searchPage.keyinSearchTextbox(validData2);
		searchPage.clickToAdvanceCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.clickToSubCategoriesCheckbox();
		searchPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.checkDisplayItems(validData2));
	}
}

 