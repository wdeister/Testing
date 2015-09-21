package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Basket;
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
	int itemID = 131;
	String price = "1900,00";
	String price2 = "1910,00";

	@BeforeTest
	public void setUp() {

		DOMConfigurator.configure("log4j.xml");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test (priority = 1)
	public void Order() {
		driver.get("http://trainstation.plenty-showcase.de/a-"+itemID+"/");
		try {
			assertEquals(ItemView.priceDynamic(driver, itemID).getText(), price);
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		ItemView.AttributeDropdown(driver).click();
		ItemView.AttibuteElement(driver).click();


		try {
			assertEquals(ItemView.priceDynamic(driver, itemID).getText(), price2);
		} catch (Exception exp)
		{
			Log.warn(exp);
		}

		ItemView.AddToBasket(driver).click();

	}

	@Test (priority = 2)
	public void Basket() {
		driver.get("http://trainstation.plenty-showcase.de/basket/");
		Basket.proceedOrder(driver).click();

	}

	@AfterTest
	public void closeWindow() {
		driver.close();
	}


}
