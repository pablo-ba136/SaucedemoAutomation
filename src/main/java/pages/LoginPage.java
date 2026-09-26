package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage {
	private By usernameInput = By.id("user-name");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login-button");
	private By menuButton = By.id("react-burger-menu-btn");
	private By errorMessage = By.cssSelector("[data-test='error']");
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public ProductsPage login(String user, String password) {
		writeText(usernameInput, user);
		writeText(passwordInput, password);
		click(loginButton);
		return new ProductsPage(driver); // Devuelve la página del catálogo de productos
	}

	public boolean isMenuButtonDisplayed() {
		return isDisplayed(menuButton);
	}

	public boolean isErrorMessageDisplayed() {
		return isDisplayed(errorMessage);
	}

	public String getErrorMessageText() {
		return getText(errorMessage); 
	}
}
