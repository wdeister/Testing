package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInvoiceInformation {

	private static WebElement element = null;

	public static WebElement select_Salutation (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsSalutation"));
		return element;
	}

	public static WebElement input_Company (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsCompany"));
		return element;
	}

	public static WebElement input_FirstName (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsFirstName"));
		return element;
	}

	public static WebElement input_LastName (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsLastName"));
		return element;
	}

	public static WebElement input_Street (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsStreet"));
		return element;
	}

	public static WebElement input_HouseNo (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsHouseNo"));
		return element;
	}

	public static WebElement input_AdressAdditional (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsAddressAdditional"));
		return element;
	}

	public static WebElement input_ZIPCode (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsZIPCode"));
		return element;
	}

	public static WebElement input_City (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsCity"));
		return element;
	}

	public static WebElement select_Country (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsCountry"));
		return element;
	}

	public static WebElement input_Email (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsEMail"));
		return element;
	}

	public static WebElement input_Email2 (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsEMail2"));
		return element;
	}

	public static WebElement input_Password (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsPassword"));
		return element;
	}

	public static WebElement input_Password2 (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsPassword2"));
		return element;
	}

	public static WebElement input_Phone (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsTelephone"));
		return element;
	}

	public static WebElement input_Mobile (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsMobilenumber"));
		return element;
	}

	public static WebElement input_Birthday (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsBirthday"));
		return element;
	}

	public static WebElement input_Birthmonth (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsBirthmonth"));
		return element;
	}

	public static WebElement input_Birthyear (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsBirthyear"));
		return element;
	}

	public static WebElement radiobx_ThisAdress (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsShippingAdressThis"));
		return element;
	}

	public static WebElement input_OtherAdress (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebInvoiceDetailsShippingAdressOther"));
		return element;
	}

	public static WebElement btn_Continue (WebDriver driver){
		element = driver.findElement(By.id("button_nextWebInvoiceDetails"));
		return element;
	}
}
