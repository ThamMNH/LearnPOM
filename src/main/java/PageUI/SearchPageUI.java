package PageUI;

public class SearchPageUI {
	public static final String SEARCH_LINK = "//a[@href='/search']//parent::li";
	public static final String SEARCH_INPUT_TEXTBOX = "//input[@id='q']";
	public static final String SEARCH_BUTTON = "//button[@class='button-1 search-button']";
	public static final String SEARCH_ERROR_MESSAGE = "//div[@class='warning']";
	public static final String NO_SEARCH_RESULT_MESSAGE = "//div[@class='no-result']";
	public static final String ADVS_CHECKBOX = "//input[@id='advs']";
	public static final String SELECT_CATEGORY = "//select[@id='cid']";
	public static final String SEARCH_SUBCATEGORY_CHECKBOX = "//input[@id='isc']";
	public static final String PRODUCT_TITLE = "//h2[@class='product-title']/a";
}
