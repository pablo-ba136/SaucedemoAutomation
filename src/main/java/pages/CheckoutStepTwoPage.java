package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class CheckoutStepTwoPage extends BasePage {

	private By checkoutItemNames = By.className("inventory_item_name");
	private By checkoutItemPrices = By.className("inventory_item_price");
	private By checkoutItemPricesSubTotal = By.className("summary_subtotal_label");
	private By checkoutTax = By.className("summary_tax_label");
	private By checkoutItemPricesTotal = By.className("summary_total_label");

	private By finishButton = By.id("finish");

	public CheckoutStepTwoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Devuelve los nombres de todos los items en una lista
	public List<String> getNames() {
		List<String> names = new ArrayList<>();
		List<WebElement> items = findElements(checkoutItemNames);
		for (int i = 0; i < items.size(); i++) {
			names.add(items.get(i).getText());
		}

		return names;
	}

	// Devuelve los precios de todos los items en una lista
	public List<Float> getPrices() {
		List<Float> prices = new ArrayList<>();
		List<WebElement> items = findElements(checkoutItemPrices);
		for (int i = 0; i < items.size(); i++) {
			prices.add(Float.parseFloat(items.get(i).getText().replace("$", "")));
		}
		return prices;

	}

	// Devuelve el subtotal (precio sin tax) que se muestra en la pantalla del
	// checkout
	public float getItemPricesSubTotal() {
		float price = Float.parseFloat(getText(checkoutItemPricesSubTotal).replace("Item total: $", ""));
		return price;
	}

	// Devuelve el tax que se muestra en la pantalla del checkout
	public float getTax() {
		float tax = Float.parseFloat(getText(checkoutTax).replace("Tax: $", ""));
		return tax;
	}

	// Devuelve el total (precio con tax) que se muestra en la pantalla del checkout
	public float getItemPricesTotal() {
		float price = Float.parseFloat(getText(checkoutItemPricesTotal).replace("Total: $", ""));
		return price;
	}

	// Calcula el subtotal (precio sin taxes) sumando los precios de todos los
	// productos obtenidos del método getPrices
	public float getCalculatedSubTotal() {
		float subTotal = 0;
		List<Float> prices = getPrices();

		for (int i = 0; i < prices.size(); i++) {
			subTotal += prices.get(i);
		}

		return subTotal;
	}

	// Navegamos a la última pantalla del checkout
	public CheckoutCompletePage goToCheckoutCompletePage() {
		click(finishButton);
		return new CheckoutCompletePage(driver);
	}

}
