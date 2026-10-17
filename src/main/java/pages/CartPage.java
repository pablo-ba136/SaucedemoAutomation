package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class CartPage extends BasePage{

	private By cartItemNames = By.className("inventory_item_name");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public String getFirstItemName() {
		return getText(cartItemNames);
	}
	
	// Devuelve los nombres de todos los items en una lista
	public List<String> getNames() {
		List<String> names = new ArrayList<>();
		List<WebElement> items = findElements(cartItemNames);
		for (int i = 0; i < items.size(); i++) {
			names.add(items.get(i).getText());
		}

		return names;
	}

}
