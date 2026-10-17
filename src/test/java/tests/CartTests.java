package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.List;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import utils.Config;
import pages.CartPage;
import org.testng.annotations.Test;

import base.BaseTest;

public class CartTests extends BaseTest {

	private ProductsPage productsPage;

	@BeforeMethod
	public void loginSetup() {
		// Iniciamos en la LoginPage (BaseTest ya abrió la URL en el setup)
		LoginPage loginPage = new LoginPage(driver);

		// Nos logueamos y obtenemos automáticamente el acceso a la pantalla del
		// catálogo

		productsPage = loginPage.login(Config.VALID_USER, Config.VALID_PASSWORD);
	}

	@Test
	public void cartCounter() {

		/*
		 * if (productsPage.isbackpackRemoveButtonButtonDisplayed()) {
		 * productsPage.removeBackpackToCart(); }
		 */
		// Añadimos dos productos y validamos contador del carrito
		productsPage.addBackpackToCart();
		productsPage.addBikeLightToCart();
		assertEquals(productsPage.getCartItemsCount(), "2", "El contador del carrito no se actualizó.");

	}

	@Test
	public void addProduct() {

		/*
		 * if (productsPage.isbackpackRemoveButtonButtonDisplayed()) {
		 * productsPage.removeBackpackToCart(); }
		 */
		// Añadimos un producto
		productsPage.addBackpackToCart();

		// Viajamos al carrito de compras
		CartPage cartPage = productsPage.goToCart();

		// Validamos que se ha añadido el producto
		String productoEsperado = "Sauce Labs Backpack";
		assertEquals(cartPage.getFirstItemName(), productoEsperado, "El producto en el carrito no es el correcto.");

	}
	
	@Test
	public void addProducts() {
	    // Capturamos los nombres de todos los productos del inventario de la página de productos.
	    List<String> expectedNames = productsPage.getNames(); 

	    // Añadimos todos los productos del inventario al carrito
	    productsPage.addProductsToCart();

	    CartPage cartPage = productsPage.goToCart();

	    // Capturamos los nombres de los productos que se encuentran en el carrito.
	    List<String> actualNames = cartPage.getNames();
	    assertEquals(actualNames, expectedNames, "Los nombres de los productos en el carrito no coinciden con los de la tienda");
	}

}
