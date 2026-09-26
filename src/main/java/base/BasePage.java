package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Waits;

public class BasePage {

	protected WebDriver driver;
	protected Waits waits;

	// Constructor que heredarán todas las páginas de tu proyecto
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.waits = new Waits(driver);
	}

	// Abre una URL específica en el navegador
	public void navigateTo(String url) {
		driver.get(url);
	}

	// Busca un elemento asegurando primero que sea visible
	protected WebElement findElement(By locator) {
		return waits.waitForElement(locator);
	}

	// Busca una lista de elementos asegurando que estén presentes
	protected List<WebElement> findElements(By locator) {
		return waits.waitForListOfElements(locator);
	}

	// Envuelve la acción de escribir texto (Limpia el campo antes de escribir)
	protected void writeText(By locator, String text) {
		WebElement element = findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	// Envuelve la acción de hacer clic asegurando que el elemento sea interactuable
	protected void click(By locator) {
		waits.waitForElementToBeClickable(locator).click();
	}

	// Envuelve la acción de hacer clic sobre un WebElement ya localizado
	protected void click(WebElement element) {
		waits.waitForElementToBeClickable(element).click();
	}

	// Obtiene el texto de un elemento visible
	protected String getText(By locator) {
		return findElement(locator).getText();
	}
	
	public String getText(WebElement element) {
		return element.getText();

	}

	// Verifica si un elemento está desplegado en la pantalla
	protected boolean isDisplayed(By locator) {
		try {
			return findElement(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Obtiene el título de la página actual
	public String getPageTitle() {
		return driver.getTitle();
	}

	// Obtiene la URL actual del navegador
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String selectDropdownList(By locator, String text) { 
		Select selectList = new Select(findElement(locator));
		selectList.selectByVisibleText(text);
		return getText(selectList.getFirstSelectedOption());
	}
	
	protected void selectByValue(By locator, String value) {

	    Select select = new Select(findElement(locator));
	    select.selectByValue(value);

	}
}
