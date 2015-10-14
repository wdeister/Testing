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

	public static WebElement radio_bx_KlarnaInvoice (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebPaymentMethod1401"));
		return element;
	}

	public static WebElement radio_bx_PayPal (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebPaymentMethod14"));
		return element;
	}

	public static WebElement priceCashInAdvance (WebDriver driver){
		element = driver.findElement(By.cssSelector("#PlentyWebPaymentMethod0Price > span.PlentyCurrencyValue"));
		return element;
	}

	public static WebElement priceDebit(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#PlentyWebPaymentMethod3Price > span.PlentyCurrencyValue"));
		return element;
	}

	public static WebElement pricePayPal (WebDriver driver){
		element = driver.findElement(By.cssSelector("#PlentyWebPaymentMethod14Price > span.PlentyCurrencyValue"));
		return element;
	}

	public static WebElement priceKlarnaInvoice (WebDriver driver){
		element = driver.findElement(By.cssSelector("#PlentyWebPaymentMethod1401Price > span.PlentyCurrencyValue"));
		return element;
	}

	public static WebElement input_BankName (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBankInformationBankName"));
		return element;
	}

	public static WebElement input_BLZ (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBankInformationBLZ"));
		return element;
	}

	public static WebElement input_BankAccount (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBankInformationAccount"));
		return element;
	}

	public static WebElement input_OwnerLast (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBankInformationOwnerLast"));
		return element;
	}

	public static WebElement input_IBAN (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBankInformationIBAN"));
		return element;
	}

	public static WebElement input_BIC (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebBankInformationBIC"));
		return element;
	}

	public static WebElement btn_Continue (WebDriver driver){
		element = driver.findElement(By.id("button_nextWebPaymentMethod"));
		return element;
	}

	public static WebElement btn_ContinueDebit (WebDriver driver){
		element = driver.findElement(By.id("button_nextWebBankInformation"));
		return element;
	}
}
