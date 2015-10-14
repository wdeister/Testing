package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmation {

	private static WebElement element = null;

	public static WebElement textBeforeUsual (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebPurchaseConfirmationNotice1"));
		return element;
	}

	public static WebElement textBeforePayPal (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebPayPalExpressNotice1"));
		return element;
	}

	public static WebElement textKlarna (WebDriver driver){
		element = driver.findElement(By.xpath("//div[@id='PlentyWebKlarnaIFrameContainer']/p"));
		return element;
	}

}
