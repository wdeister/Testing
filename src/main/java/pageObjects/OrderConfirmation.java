package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmation {

	private static WebElement element = null;

	public static WebElement textBefore (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebPurchaseConfirmationNotice1"));
		return element;
	}
}
