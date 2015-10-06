package automationFramework;

import com.github.yev.FailTestScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

@Listeners(FailTestScreenshotListener.class)
public class DeliveryAdressPurchase {

	public static WebDriver driver;
	public static Logger Log = Logger.getLogger(StandartPurchase.class.getName());

	int itemID = 131;
	Random rand   = new Random();
	String price  = "1900,00";
	String price2 = "1910,00";
	String vat    = "305,75";
	String color  = "schwarz€ +10,00";
	String email  = "selenium"+rand.nextInt()+"@example.com";

	@BeforeTest
	public void setUp() {

		DOMConfigurator.configure("log4j.xml");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test (priority = 1)
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
			assertEquals(Basket.totalVat(driver).getText(), vat);
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
		CheckoutLogin.radiobx_Register(driver).click();
		CheckoutLogin.btn_continue(driver).click();

		/*Invoice Information*/
		CheckoutInvoiceInformation.input_FirstName(driver).sendKeys("Max");
		CheckoutInvoiceInformation.input_LastName(driver).sendKeys("Mustermann");
		CheckoutInvoiceInformation.input_Street(driver).sendKeys("Bürgermeister Brunner");
		CheckoutInvoiceInformation.input_HouseNo(driver).sendKeys("15");
		CheckoutInvoiceInformation.input_ZIPCode(driver).sendKeys("34117");
		CheckoutInvoiceInformation.input_City(driver).sendKeys("Kassel");
		CheckoutInvoiceInformation.input_Email(driver).sendKeys(email);
		CheckoutInvoiceInformation.input_Email2(driver).sendKeys(email);
		CheckoutInvoiceInformation.input_Password(driver).sendKeys(email);
		CheckoutInvoiceInformation.input_Password2(driver).sendKeys(email);
		CheckoutInvoiceInformation.input_OtherAdress(driver).click();
		CheckoutInvoiceInformation.btn_Continue(driver).click();

		/*Shipping Information*/

		CheckoutShippingInformation.input_FirstName(driver).sendKeys("Max");
		CheckoutShippingInformation.input_LastName(driver).sendKeys("Mustermann");
		CheckoutShippingInformation.input_Street(driver).sendKeys("Uliza Mosfilmowskaja");
		CheckoutShippingInformation.input_HouseNo(driver).sendKeys("56");
		CheckoutShippingInformation.input_ZIPCode(driver).sendKeys("119 285");
		CheckoutShippingInformation.input_City(driver).sendKeys("Moskau");
		new Select (CheckoutShippingInformation.select_Country(driver)).selectByValue("40");
		CheckoutShippingInformation.btn_Continue(driver).click();
		CheckoutShippingInformation.btn_ContinueShipping(driver).click();



		/*Payment*/
		CheckoutPaymentInformation.radio_bx_CashInAdvance(driver).click();
		CheckoutPaymentInformation.btn_Continue(driver).click();

		/*Shipping*/
		CheckoutShippingMethod.radio_bx_PlentyWebShippingMethod8(driver).click();
		CheckoutShippingMethod.btn_Continue(driver).click();

		/*Overview*/

		CheckoutOverview.ck_bx_AGB(driver).click();
		CheckoutOverview.ck_bx_Withdrawal(driver).click();
		CheckoutOverview.inp_fld_Notes(driver).sendKeys("Selenium WebDriver");
		CheckoutOverview.inp_fld_Reference(driver).sendKeys("wörk wörk");

		//Warenwert (brutto)
		try {
			assertEquals(CheckoutOverview.grossGoodsValue(driver).getText(), "1605,04");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		//Warenwert (netto)
		try {
			assertEquals(CheckoutOverview.nettoGoodsValue(driver).getText(), "1605,04");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		//Versandkosten (brutto)
		try {
			assertEquals(CheckoutOverview.grossShippingCosts(driver).getText(), "8,36");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		//Versandkosten (netto)
		try {
			assertEquals(CheckoutOverview.nettoShippingCosts(driver).getText(), "8,36");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		//Zwischensumme (netto)
		try {
			assertEquals(CheckoutOverview.nettoPrice(driver).getText(), "1613,40");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		//MwSt 19%
		try {
			assertEquals(CheckoutOverview.totalVat(driver).getText(), "0,00");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		CheckoutOverview.btn_Continue(driver).click();
	}

	@AfterTest
	public void closeWindow() {
		driver.close();
	}
}