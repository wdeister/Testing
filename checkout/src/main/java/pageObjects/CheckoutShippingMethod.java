package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by wdeister on 15/06/15.
 */
public class CheckoutShippingMethod {
	private static WebElement element = null;

	// trainstation: DHL versichertes Paket
	public static WebElement radio_bx_PlentyWebShippingMethod6 (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingMethod6"));
		return element;
	}

	// trainstation: DHL EU
	public static WebElement radio_bx_PlentyWebShippingMethod7 (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingMethod7"));
		return element;
	}

	// trainstation: DHL Welt
	public static WebElement radio_bx_PlentyWebShippingMethod8 (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingMethod8"));
		return element;
	}

	// trainstation: UPS
	public static WebElement radio_bx_PlentyWebShippingMethod9 (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingMethod9"));
		return element;
	}

	// trainstation: DHL versichertes Paket Price
	public static WebElement txt_ShippingMethodPrice6 (WebDriver driver){
		element = driver.findElement(By.id(""));
		return element;
	}

	// trainstation: DHL EU Price
	public static WebElement txt_ShippingMethodPrice7 (WebDriver driver){
		element = driver.findElement(By.id(""));
		return element;
	}

	// trainstation: DHL Welt Price
	public static WebElement txt_ShippingMethodPrice8 (WebDriver driver){
		element = driver.findElement(By.id(""));
		return element;
	}

	// trainstation: UPS Price
	public static WebElement txt_ShippingMethodPrice9 (WebDriver driver){
		element = driver.findElement(By.id(""));
		return element;
	}
}
