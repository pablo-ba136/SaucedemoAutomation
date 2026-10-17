package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
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
		// Añadimos un producto y validamos contador del carrito
		productsPage.addBackpackToCart();
		assertEquals(productsPage.getCartItemsCount(), "1", "El contador del carrito no se actualizó.");

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

}
