package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by wdeister on 19/09/15.
 */
public class ItemView {

	private static WebElement element = null;

	public static WebElement priceDynamic (WebDriver driver, int itemId){
		String id = "price_dynamic_0_" + itemId;
		element = driver.findElement(By.id(id));
		return element;
	}

	public static WebElement AttributeDropdown (WebDriver driver){
		element = driver.findElement(By.cssSelector("span.plentyAttributeSelectedValueName"));
		return element;
	}

	public static WebElement AttibuteElement (WebDriver driver){
		element = driver.findElement(By.linkText("schwarz€ +10,00"));
		return element;
	}

	public static WebElement AddToBasket(WebDriver driver) {
		element = driver.findElement(By.linkText("In den Warenkorb"));
		return element;
	}
}
