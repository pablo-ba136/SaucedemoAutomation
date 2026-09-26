package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static WebDriver createDriver(String browser) {
		WebDriver driver;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Navegador no soportado: " + browser);
		}

		driver.manage().window().maximize();

		return driver;
	}
}
