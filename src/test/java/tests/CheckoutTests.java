package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutStepOnePage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.Config;

public class CheckoutTests extends BaseTest {

	private CheckoutStepOnePage checkoutStepOnePage;

	@BeforeMethod
	public void loginSetup() {
		// Iniciamos en la LoginPage (BaseTest ya abrió la URL en el setup)
		LoginPage loginPage = new LoginPage(driver);

		// Nos logueamos y obtenemos automáticamente el acceso a la pantalla del
		// catálogo
		ProductsPage productsPage = loginPage.login(Config.VALID_USER, Config.VALID_PASSWORD);
		// Añadimos dos productos
		productsPage.addBackpackToCart();
		productsPage.addBikeLightToCart();
		// Vamos al carrito
		CartPage cartPage = productsPage.goToCart();
		// Vamos a la primera pantalla del proceso de checkout
		checkoutStepOnePage = cartPage.goToCheckoutStepOne();

	}

	@Test
	public void f() {
	}
}
