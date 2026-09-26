package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	private final WebDriverWait wait;

	// Constructor que recibe el driver y el tiempo de espera
	public Waits(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(Config.DEFAULT_TIMEOUT)); 
	}

	// Esperar a que un elemento sea visible usando localizador
	public WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Esperar a que un elemento sea visible usando WebElement
	public WebElement waitForElement(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Esperar a que un elemento sea cliqueable usando localizador
	public WebElement waitForElementToBeClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Esperar a que un elemento sea cliqueable usando WebElement
	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Esperar a que una lista de elementos contenga al menos un elemento visible
	public List<WebElement> waitForListOfElements(By locator) {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	// Esperar a que el texto de un elemento cambie o contenga algo específico
	public boolean waitForTextToBePresentInElement(By locator, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	// Esperar a que un elemento desaparezca de la pantalla
	public boolean waitForInvisibility(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
}
