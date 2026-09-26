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

	// Constructor que heredan las páginas del proyecto
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.waits = new Waits(driver);
	}

	// Abre una URL en el navegador
	public void navigateTo(String url) {
		driver.get(url);
	}

	// Busca un elemento
	protected WebElement findElement(By locator) {
		return waits.waitForElement(locator);
	}

	// Busca una lista de elementos
	protected List<WebElement> findElements(By locator) {
		return waits.waitForListOfElements(locator);
	}

	// Escribe un texto
	protected void writeText(By locator, String text) {
		WebElement element = findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	// Hace clic usando localizador
	protected void click(By locator) {
		waits.waitForElementToBeClickable(locator).click();
	}

	// Hace clic usando WebElement
	protected void click(WebElement element) {
		waits.waitForElementToBeClickable(element).click();
	}

	// Obtiene el texto usando localizador
	protected String getText(By locator) {
		return findElement(locator).getText();
	}
	
	// Obtiene el texto usando WebElement
	public String getText(WebElement element) {
		return element.getText();

	}

	// Verifica si un elemento está en la pantalla
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
	
	//Obtiene el elemento de una lista desplegable usando texto
	public String selectDropdownList(By locator, String text) { 
		Select selectList = new Select(findElement(locator));
		selectList.selectByVisibleText(text);
		return getText(selectList.getFirstSelectedOption());
	}
	
	//Obtiene el elemento de una lista desplegable usando value
	protected void selectByValue(By locator, String value) {

	    Select select = new Select(findElement(locator));
	    select.selectByValue(value);

	}
}
