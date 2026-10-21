package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CheckoutStepOnePage extends BasePage{

	private By firstNameField = By.id("first-name");
	private By lastNameField = By.id("last-name");
	private By postalCodeField = By.id("postal-code");
	
	private By continueButton = By.id("continue");
	
	public CheckoutStepOnePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void writeFirstName(String firstName) {
		writeText(firstNameField, firstName);
	}

	public void writeLastName(String lastName) {
		writeText(lastNameField, lastName);
	}
	
	public void writePostalCode(String postalCode) {
		writeText(postalCodeField, postalCode);
	}
	
	// Navegamos a la segunda pantalla del checkout
	public CheckoutStepTwoPage goToCheckout() {
		click(continueButton);
		return new CheckoutStepTwoPage(driver);
	}
	
}
