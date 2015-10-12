package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemView {

	private static WebElement element = null;

	public static WebElement priceDynamic (WebDriver driver, int itemId){
		String id = "price_dynamic_0_" + itemId;
		element = driver.findElement(By.id(id));
		return element;
	}

	public static WebElement priceDynamicOverlay (WebDriver driver, int itemId){
		String css = "#span.large > #price_dynamic_0_" + itemId;
		element = driver.findElement(By.cssSelector(css));
		return element;
	}

	public static WebElement attributeDropdown (WebDriver driver){
		element = driver.findElement(By.cssSelector("span.plentyAttributeSelectedValueName"));
		return element;
	}

	public static WebElement attibuteElement (WebDriver driver, String color){
		element = driver.findElement(By.linkText(color));
		return element;
	}

	public static WebElement addToBasket (WebDriver driver) {
		element = driver.findElement(By.linkText("In den Warenkorb"));
		return element;
	}

	public static WebElement btn_close (WebDriver driver) {
		element = driver.findElement(By.cssSelector("button.btn.btn-default"));
		return element;
	}
}
