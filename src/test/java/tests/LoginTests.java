package tests;

import base.BaseTest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class LoginTests extends BaseTest {

	// 🟢 DataProvider para Login con datos correctos
	@DataProvider(name = "userData")
	public Object[][] getUserData() throws IOException {
		return readJsonData("src/test/resources/testdata/users.json");
	}

	// 🟢 DataProvider para hacer Login con datos erróneos
	@DataProvider(name = "invalidUserData")
	public Object[][] getInvalidUserData() throws IOException {
		return readJsonData("src/test/resources/testdata/invalid_users.json");
	}

	// Para leer el JSON
	private Object[][] readJsonData(String filePath) throws IOException {
		FileReader reader = new FileReader(filePath);
		Type listType = new TypeToken<List<Map<String, String>>>() {
		}.getType();
		List<Map<String, String>> usersList = new Gson().fromJson(reader, listType);
		reader.close();

		Object[][] data = new Object[usersList.size()][2];
		for (int i = 0; i < usersList.size(); i++) {
			data[i][0] = usersList.get(i).get("username");
			data[i][1] = usersList.get(i).get("password");
		}
		return data;
	}

	@Test(dataProvider = "userData")
	public void test(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		assertTrue(loginPage.isMenuButtonDisplayed());
	}

	@Test(dataProvider = "invalidUserData")
	public void testFailedLogin(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);

		// Ejecutar el flujo con credenciales incorrectas
		loginPage.login(username, password);

		// Assertion de que el mensaje de error aparece en pantalla
		assertTrue(loginPage.isErrorMessageDisplayed(), "El mensaje de error no se mostró.");

		String textoEsperado = "Epic sadface: Username and password do not match any user in this service";

		assertEquals(loginPage.getErrorMessageText(), textoEsperado);
	}
}
