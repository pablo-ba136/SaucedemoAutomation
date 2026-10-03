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
	private By itemNames = By.className("inventory_item_name");
	private By itemAddButtons = By.className("btn_primary");
	private By items = By.className("inventory_item");

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

	/*
	 * public String sortSelect(String sort) { return
	 * selectDropdownList(sortDropdownList, sort); }
	 */

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

	// Devuelve los precios de todos los items en una lista
	public List<Float> getPrices() {
		List<Float> prices = new ArrayList<>();
		List<WebElement> items = findElements(itemPrices);
		for (int i = 0; i < items.size(); i++) {
			prices.add(Float.parseFloat(items.get(i).getText().replace("$", "")));
		}
		return prices;

	}

	// Devuelve los nombres de todos los items en una lista
	public List<String> getNames() {
		List<String> names = new ArrayList<>();
		List<WebElement> items = findElements(itemNames);
		for (int i = 0; i < items.size(); i++) {
			names.add(items.get(i).getText());
		}

		return names;
	}

	// Devuelve si los productos tienen datos
	public boolean allProductsHaveData() {

		List<WebElement> products = driver.findElements(items);

		for (int i = 0; i < products.size(); i++) {

			WebElement product = products.get(i);

			boolean hasName = !product.findElement(itemNames).getText().isBlank();

			boolean hasPrice = !product.findElement(itemPrices).getText().isBlank();

			boolean hasButton = product.findElement(itemAddButtons).isDisplayed();

			if (!hasName || !hasPrice || !hasButton) {
				return false;
			}
		}

		return true;
	}

}
