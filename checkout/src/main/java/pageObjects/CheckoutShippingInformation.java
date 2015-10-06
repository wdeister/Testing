package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by wdeister on 15/06/15.
 */

public class CheckoutShippingInformation {

	private static WebElement element = null;

	public static WebElement select_Salutation (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsSalutation"));
		return element;
	}

	public static WebElement input_Company (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsCompany"));
		return element;
	}

	public static WebElement input_FirstName (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsFirstName"));
		return element;
	}

	public static WebElement input_LastName (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsLastName"));
		return element;
	}

	public static WebElement input_Street (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsStreet"));
		return element;
	}

	public static WebElement input_HouseNo (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsHouseNo"));
		return element;
	}

	public static WebElement input_AdressAdditional (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsAddressAdditional"));
		return element;
	}

	public static WebElement input_ZIPCode (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsZIPCode"));
		return element;
	}

	public static WebElement input_City (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsCity"));
		return element;
	}

	public static WebElement select_State (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsState"));
		return element;
	}

	public static WebElement select_Country (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsCountry"));
		return element;
	}

	public static WebElement input_Postident (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsPostident"));
		return element;
	}

	public static WebElement input_Email (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsEMail"));
		return element;
	}

	public static WebElement input_Phone (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsTelephone"));
		return element;
	}

	public static WebElement input_VAT (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsVATNumber"));
		return element;
	}

	public static WebElement btn_Packstations (WebDriver driver){
		element = driver.findElement(By.id("WebPostfinderGetPackstationsOverlayTrigger"));
		return element;
	}

	public static WebElement btn_Continue (WebDriver driver){
		element = driver.findElement(By.id("button_nextWebShippingDetails"));
		return element;
	}

	public static WebElement btn_ContinueShipping (WebDriver driver){
		element = driver.findElement(By.id("button_nextShippingDetailsList"));
		return element;
	}

	public static WebElement btn_Change (WebDriver driver){
		element = driver.findElement(By.id("button_changeWebShippingDetailsList-1"));
		return element;
	}

	public static WebElement radio_Select_Invoice (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsList0"));
		return element;
	}

	public static WebElement radio_Select_First (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsList1"));
		return element;
	}

	public static WebElement radio_Select_Second (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebShippingDetailsList2"));
		return element;
	}



}
