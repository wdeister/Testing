package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by wdeister on 15/06/15.
 */
public class Basket {

	private static WebElement element = null;

	public static WebElement titleTextBefore (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBasketTitleText1"));
		return element;
	}

	public static WebElement title (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBasketTitleContainerTitle"));
		return element;
	}

	public static WebElement titleTextAfter (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBasketTitleText2"));
		return element;
	}

	public static WebElement itemTextBefore (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBasketItemsText1"));
		return element;
	}

	public static WebElement itemHeaderDescription (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBasketItemsItemsHeaderDescription"));
		return element;
	}

	public static WebElement itemHeaderQuantity (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBasketItemsItemsHeaderQuantity"));
		return element;
	}

	public static WebElement itemHeaderTotal (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBasketItemsItemsHeaderTotal"));
		return element;
	}

	public static WebElement deliveryDateSelectionLink (WebDriver driver){
		element = driver.findElement(By.cssSelector("span.ItemsDeliveryDateSelectionLink > a"));
		return element;
	}

	public static WebElement addWatchListLink (WebDriver driver){
		element = driver.findElement(By.cssSelector("span.AddWatchListLink > a"));
		return element;
	}
	/* undocumented */
	public static WebElement shippingCountryContainerTitle (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBasketShippingCountryContainerTitle"));
		return element;
	}

	public static WebElement shippingCountryText12 (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBasketShippingCountryText1"));
		return element;
	}
	/* undocumented */
	public static WebElement paymentMethodContainerTitle (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBasketPaymentMethodContainerTitle"));
		return element;
	}

	public static WebElement shippingCountryText1 (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBasketShippingCountryText1"));
		return element;
	}

	public static WebElement totalPrice (WebDriver driver){
		element = driver.findElement(By.cssSelector("div.bold > span.PlentyCurrencyValue"));
		return element;
	}

	public static WebElement proceedOrder (WebDriver driver) {
		element =driver.findElement(By.id("button_proceed_order"));
		return element;
	}
}
