package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import utils.Config;

public class ProductsTests extends BaseTest {
	@Test
	public void priceLowToHigh() {
		// 1. Iniciamos en la LoginPage (BaseTest ya abrió la URL en el setup)
		LoginPage loginPage = new LoginPage(driver);

		// 2. Nos logueamos y obtenemos automáticamente el acceso a la pantalla del
		// catálogo
		ProductsPage productsPage = loginPage.login(Config.VALID_USER, Config.VALID_PASSWORD);

		productsPage.sortLowToHigh();
		List<Float> actualPrices = productsPage.getPrices();

		List<Float> expectedPrices = new ArrayList<>(actualPrices);
		Collections.sort(expectedPrices);

		assertEquals(actualPrices, expectedPrices, "Los productos no están ordenados de menor a mayor precio");
	}
}
