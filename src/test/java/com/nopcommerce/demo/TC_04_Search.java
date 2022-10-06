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
	String invalidData = GlobalConstants.search_valid_item;
	String validData = GlobalConstants.search_valid_item;

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
		searchPage.keyinSearchTextbox(validData);
		searchPage.clickOnSearchButton();
//		Assert.assertTrue(searchPage.isSearchProductTitleDisplayedOnPageAsExpected(validData));
		List<WebElement> ListOfProducts = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
		for(WebElement listobj: ListOfProducts) {
			System.out.println(listobj.getText());
			Assert.assertTrue(listobj.getText().contains(validData));
		}
		sleepInSeconds(3);
	}
	@Test
	public void TC_04_AdvanceSearchWithParentCategories() {
		searchPage.refreshCurrentPage(driver);
		searchPage.keyinSearchTextbox("Apple Macbook Pro");
		searchPage.clickToAdvanceCheckbox();
		
		
	
	}
}

 