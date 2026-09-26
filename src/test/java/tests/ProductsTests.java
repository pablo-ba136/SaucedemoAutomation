package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import utils.Config;

public class ProductsTests extends BaseTest {
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
	public void priceLowToHigh() {

		productsPage.sortLowToHigh();
		List<Float> actualPrices = productsPage.getPrices();

		List<Float> expectedPrices = new ArrayList<>(actualPrices);
		Collections.sort(expectedPrices);

		assertEquals(actualPrices, expectedPrices, "Los productos no están ordenados de menor a mayor precio");
	}

	@Test
	public void priceHighToLow() {

		productsPage.sortHighToLow();
		List<Float> actualPrices = productsPage.getPrices();

		List<Float> expectedPrices = new ArrayList<>(actualPrices);
		Collections.sort(expectedPrices, Collections.reverseOrder());

		assertEquals(actualPrices, expectedPrices, "Los productos no están ordenados de mayor a menor precio");
	}

	@Test
	public void nameAToZ() {

		productsPage.sortNameAToZ();
		List<String> actualNames = productsPage.getNames();

		List<String> expectedNames = new ArrayList<>(actualNames);
		Collections.sort(expectedNames);

		assertEquals(actualNames, expectedNames, "Los productos no están ordenados alfabéticamente");
	}

	@Test
	public void nameZToA() {

		productsPage.sortNameZToA();
		List<String> actualNames = productsPage.getNames();

		List<String> expectedNames = new ArrayList<>(actualNames);
		Collections.sort(expectedNames, Collections.reverseOrder());

		assertEquals(actualNames, expectedNames, "Los productos no están ordenados alfabéticamente de forma inversa");
	}

}
