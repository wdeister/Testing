package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPaymentInformation {

	private static WebElement element = null;


	public static WebElement radio_bx_CashInAdvance (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebPaymentMethod0"));
		return element;
	}

	public static WebElement radio_bx_CashOnDelivery (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebPaymentMethod1"));
		return element;
	}

	public static WebElement radio_bx_Invoice (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebPaymentMethod2"));
		return element;
	}

	public static WebElement radio_bx_Debit (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebPaymentMethod3"));
		return element;
	}

	public static WebElement radio_bx_PayUponPickup (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebPaymentMethod4"));
		return element;
	}

	public static WebElement btn_Continue (WebDriver driver){
		element = driver.findElement(By.id("button_nextWebPaymentMethod"));
		return element;
	}

	public static WebElement txt_CashInAdvancePrice (WebDriver driver){
		element = driver.findElement(By.cssSelector("PlentyWebPaymentMethod0Price > PlentyCurrencyValue"));
		return element;
	}
}
