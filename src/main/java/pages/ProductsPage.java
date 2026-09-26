package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ProductsPage extends BasePage {
	// Locators de ejemplo para SauceDemo
	private By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
	private By cartIcon = By.className("shopping_cart_link");
	private By cartBadge = By.className("shopping_cart_badge");
	private By backpackRemoveButton = By.id("remove-sauce-labs-backpack");

	private By sortDropdownList = By.cssSelector("select[data-test='product-sort-container']");
	private By itemPrices = By.className("inventory_item_price");

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public void addBackpackToCart() {
		click(backpackAddButton);
	}

	public boolean isbackpackRemoveButtonButtonDisplayed() {
		return isDisplayed(backpackRemoveButton);
	}

	public void removeBackpackToCart() {
		click(backpackRemoveButton);
	}

	public String getCartItemsCount() {
		return getText(cartBadge);
	}

	// 🟢 Al hacer clic en el carrito, navegamos a otra página diferente
	public CartPage goToCart() {
		click(cartIcon);
		return new CartPage(driver); // Fluent interface hacia la página del carrito
	}

	/*public String sortSelect(String sort) {
		return selectDropdownList(sortDropdownList, sort);
	}*/
	
	public void sortLowToHigh() {
	    selectByValue(sortDropdownList, "lohi");
	}

	public void sortHighToLow() {
	    selectByValue(sortDropdownList, "hilo");
	}

	public void sortNameAToZ() {
	    selectByValue(sortDropdownList, "az");
	}

	public void sortNameZToA() {
	    selectByValue(sortDropdownList, "za");
	}

	public List<Float> getPrices() {
		List<Float> prices = new ArrayList<>();
		List<WebElement> items = findElements(itemPrices);
		for (int i = 0; i < items.size(); i++) {
			prices.add(Float.parseFloat(items.get(i).getText().replace("$", "")));
		}
		return prices;

	}


}
