package base;

import org.testng.annotations.Test;

import utils.Config;
import utils.DriverFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	protected WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		driver = DriverFactory.createDriver(browser);
		driver.get(Config.URL);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
