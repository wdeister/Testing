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
}
