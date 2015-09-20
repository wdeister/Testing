package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ItemView;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

/**
 * Created by wdeister on 31/08/15.
 */

public class StandartPurchase {

	public static WebDriver driver;
	private static Logger Log = Logger.getLogger(StandartPurchase.class.getName());

	@BeforeTest
	public void initWebDriver() {

		DOMConfigurator.configure("log4j.xml");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test (priority = 1)
	public void Order() {
		int itemID = 131;
		String price = "1900,00";
		driver.get("http://trainstation.plenty-showcase.de/a-"+itemID+"/");
		try {
			assertEquals(price, ItemView.priceDynamic(driver, itemID).getText());
		} catch (Exception exp)
		{
			Log.warn("Halt stopp!!!", exp);
		}

		driver.close();
	}

	@AfterTest
	public void closeWindow() {
		driver.close();
	}


}
