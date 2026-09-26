package tests;

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
	@Test
	public void test() {
		// 1. Iniciamos en la LoginPage 
		LoginPage loginPage = new LoginPage(driver);

		// 2. Nos logueamos y obtenemos automáticamente el acceso a la pantalla del
		// catálogo
		ProductsPage productsPage = loginPage.login(Config.VALID_USER, Config.VALID_PASSWORD);

		// 3. Borramos el producto que haya en el carrito

		/*if (productsPage.isbackpackRemoveButtonButtonDisplayed()) {
			productsPage.removeBackpackToCart();
		}*/
		// 3. Añadimos un producto e interactuamos con el catálogo
		productsPage.addBackpackToCart();
		assertEquals(productsPage.getCartItemsCount(), "1", "El contador del carrito no se actualizó.");

		// 4. Viajamos al carrito de compras
		CartPage cartPage = productsPage.goToCart();

		// 5. Validamos el assertion final del carrito
		String productoEsperado = "Sauce Labs Backpack";
		assertEquals(cartPage.getFirstItemName(), productoEsperado, "El producto en el carrito no es el correcto.");

	}

}
