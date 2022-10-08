package PageUI;

public class WishlistPageUI {
	
	public static final String PRODUCT_MENU_BOOKS = "//a[@href='/books']//parent::li";
	public static final String WISHLIST_BUTTON = "//button[@class='button-2 add-to-wishlist-button']";
	public static final String WISHLIST_ADDED_MESSAGE = "//p[@class='content']";
	public static final String CLOSE_WISHLIST_ADDED_MESSAGE = "//span[@class='close']";

	public static final String PRODUCT_NAME_IN_WISHLIST = "//a[@class='product-name']";
	public static final String ADD_TO_CART_BUTTON = "//button[@class='button-2 wishlist-add-to-cart-button']";
	public static final String ADD_TO_CART_CHECKBOX = "//a[@class='product-name']/parent::td[@class='product']/preceding::td[@class='add-to-cart']/input";
	public static final String EMPTY_WISHLIST_MESSAGE = "//div[@class='page-body']";
}