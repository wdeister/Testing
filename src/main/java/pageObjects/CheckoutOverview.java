package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverview {

	private static WebElement element = null;

	public static WebElement totalPrice(WebDriver driver){
		element = driver.findElement(By.cssSelector("#PlentyTotalAmountDetail > span.PlentyCurrencyValue"));
		return element;
	}

	public static WebElement nettoPrice(WebDriver driver){
		element = driver.findElement(By.cssSelector("#PlentySubtotalNetDetail > span.PlentyCurrencyValue"));
		return element;
	}

	public static WebElement nettoShippingCosts(WebDriver driver){
		element = driver.findElement(By.cssSelector("#PlentyShippingCostsNetDetail > span.PlentyCurrencyValue"));
		return element;
	}

	public static WebElement grossShippingCosts(WebDriver driver){
		element = driver.findElement(By.cssSelector("#PlentyShippingCostsGrossDetail > span.PlentyCurrencyValue"));
		return element;
	}

	public static WebElement nettoGoodsValue(WebDriver driver){
		element = driver.findElement(By.cssSelector("#PlentyGoodsValueNetDetail > span.PlentyCurrencyValue"));
		return element;
	}

	public static WebElement grossGoodsValue(WebDriver driver){
		element = driver.findElement(By.cssSelector("#PlentyGoodsValueGrossDetail > span.PlentyCurrencyValue"));
		return element;
	}

	public static WebElement totalVat(WebDriver driver){
		element = driver.findElement(By.cssSelector("#PlentyVATDetail > span.PlentyCurrencyValue"));
		return element;
	}

	public static WebElement ck_bx_AGB (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebOrderOverviewAGB"));
		return element;
	}

	public static WebElement ck_bx_Withdrawal (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebOrderOverviewWithdrawal"));
		return element;
	}

	public static WebElement inp_fld_Notes (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebOrderOverviewNotesTextarea"));
		return element;
	}

	public static WebElement inp_fld_Reference (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebOrderOverviewReferenceInput"));
		return element;
	}

	public static WebElement btn_Continue (WebDriver driver){
		element = driver.findElement(By.id("button_place_orderWebOrderOverview"));
		return element;
	}



}
