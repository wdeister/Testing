package automationFramework;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Created by wdeister on 30/09/15.
 */
public class CustomerPurchase {
	public static WebDriver driver;
	public static Logger Log = Logger.getLogger(StandartPurchase.class.getName());

	int itemID = 131;
	Random rand   = new Random();
	String price  = "1900,00";
	String price2 = "1910,00";
	String vat    = "305,75";
	String color  = "schwarz€ +10,00";
	String email  = "selenium-859534656@example.com";

	@BeforeTest
	public void setUp() {

		DOMConfigurator.configure("log4j.xml");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void Order() {
		driver.get("http://trainstation.plenty-showcase.de/a-" + itemID + "/");
		try {
			assertEquals(ItemView.priceDynamic(driver, itemID).getText(), price);
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		ItemView.attributeDropdown(driver).click();
		ItemView.attibuteElement(driver, color).click();

		try {
			assertEquals(ItemView.priceDynamic(driver, itemID).getText(), price2);
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		ItemView.addToBasket(driver).click();

		/*auf ajax warten*/
		ItemView.btn_close(driver).click();

		try {
			assertEquals(StartPage.basketQuantity(driver).getText(), "1");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		StartPage.basketQuantity(driver).click();

		/*Basket vat total*/
		try {
			assertEquals(Basket.totalVat(driver).getText(), vat);
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		/*Basket price total*/
		try {
			assertEquals(Basket.totalPrice(driver).getText(), "1914,99");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		Basket.refreshBasket(driver).click();

		/*Basket vat total after Refresh*/
		try {
			assertEquals(Basket.totalVat(driver).getText(), "305,75");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		/*Basket price total after Refresh*/
		try {
			assertEquals(Basket.totalPrice(driver).getText(), "1914,99");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		Basket.proceedOrder(driver).click();

		/*Registration*/
		CheckoutLogin.input_Email(driver).sendKeys(email);
		CheckoutLogin.input_Password(driver).sendKeys(email);
		CheckoutLogin.btn_Login(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElement(CheckoutInvoiceInformation.select_Salutation(driver), "Herr"));

		try {
			assertEquals(CheckoutInvoiceInformation.input_FirstName(driver).getAttribute("value"), "Max");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		try {
			assertEquals(CheckoutInvoiceInformation.input_LastName(driver).getAttribute("value"), "Mustermann");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		try {
			assertEquals(CheckoutInvoiceInformation.input_Street(driver).getAttribute("value"), "Bürgermeister Brunner");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		try {
			assertEquals(CheckoutInvoiceInformation.input_HouseNo(driver).getAttribute("value"), "15");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		try {
			assertEquals(CheckoutInvoiceInformation.input_ZIPCode(driver).getAttribute("value"), "34117");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		try {
			assertEquals(CheckoutInvoiceInformation.input_City(driver).getAttribute("value"), "Kassel");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		try {
			assertEquals(CheckoutInvoiceInformation.select_Country(driver).getAttribute("value"), "1");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		try {
			assertEquals(CheckoutInvoiceInformation.input_Email(driver).getAttribute("value"), "selenium-859534656@example.com");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		try {
			assertEquals(CheckoutInvoiceInformation.input_Email2(driver).getAttribute("value"), "selenium-859534656@example.com");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		CheckoutInvoiceInformation.btn_Continue(driver).click();

		/*Payment*/
		CheckoutPaymentInformation.radio_bx_CashInAdvance(driver).click();
		CheckoutPaymentInformation.btn_Continue(driver).click();

		/*Shipping*/
		CheckoutShippingMethod.radio_bx_PlentyWebShippingMethod6(driver).click();
		CheckoutShippingMethod.btn_Continue(driver).click();

		/*Overview*/
		CheckoutOverview.ck_bx_AGB(driver).click();
		CheckoutOverview.ck_bx_Withdrawal(driver).click();
		CheckoutOverview.inp_fld_Notes(driver).sendKeys("Selenium WebDriver");
		CheckoutOverview.inp_fld_Reference(driver).sendKeys("wörk wörk");
		CheckoutOverview.btn_Continue(driver).click();
	}

	@AfterTest
	public void closeWindow() {
		driver.close();
	}
}
