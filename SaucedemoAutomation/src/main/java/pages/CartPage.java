package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CartPage extends BasePage{
	// Localizador del nombre del producto dentro del contenedor del carrito
	private By cartItemName = By.className("inventory_item_name");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public String getFirstItemName() {
		return getText(cartItemName);
	}
}
