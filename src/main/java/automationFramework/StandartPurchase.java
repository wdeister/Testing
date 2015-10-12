package automationFramework;

import com.github.yev.FailTestScreenshotListener;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageObjects.*;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

@Listeners(FailTestScreenshotListener.class)
public class StandartPurchase {

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
	@Parameters("browser")
	public void setUp(String browser) {
		DOMConfigurator.configure("log4j.xml");
		if (browser.equalsIgnoreCase("FF")){
			driver = new FirefoxDriver();
			System.out.println("Running Firefox for " + this.toString());
		}

		if (browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver");

			driver = new ChromeDriver();
			System.out.println("Running Chrome for " + this.toString());
		}
		driver.manage().window().setSize(new Dimension(1280, 960));
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	@Test
	public void Order() {
		WebDriverWait wait = new WebDriverWait(driver, 20);

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

		try {
			assertEquals(ItemView.priceDynamicOverlay(driver, itemID).getText(), price2);
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		wait.until(ExpectedConditions.elementToBeClickable(StartPage.basketQuantity(driver)));

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
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutLogin.btn_continue(driver)));
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
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutInvoiceInformation.btn_Continue(driver)));
		CheckoutInvoiceInformation.btn_Continue(driver).click();

		/*Payment*/
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutPaymentInformation.radio_bx_CashInAdvance(driver)));
		CheckoutPaymentInformation.radio_bx_CashInAdvance(driver).click();
		CheckoutPaymentInformation.btn_Continue(driver).click();

		/*Shipping*/
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutShippingMethod.btn_Continue(driver)));
		CheckoutShippingMethod.radio_bx_PlentyWebShippingMethod6(driver).click();
		CheckoutShippingMethod.btn_Continue(driver).click();

		/*Overview*/
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutOverview.ck_bx_AGB(driver)));
		CheckoutOverview.ck_bx_AGB(driver).click();
		CheckoutOverview.ck_bx_Withdrawal(driver).click();
		CheckoutOverview.inp_fld_Notes(driver).sendKeys("Selenium WebDriver");
		CheckoutOverview.inp_fld_Reference(driver).sendKeys("wörk wörk");

		//Warenwert (brutto)
		try {
			assertEquals(CheckoutOverview.grossGoodsValue(driver).getText(), "1910,00");
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
			assertEquals(CheckoutOverview.grossShippingCosts(driver).getText(), "4,99");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		//Versandkosten (netto)
		try {
			assertEquals(CheckoutOverview.nettoShippingCosts(driver).getText(), "4,19");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		//Zwischensumme (netto)
		try {
			assertEquals(CheckoutOverview.nettoPrice(driver).getText(), "1609,23");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		//MwSt 19%
		try {
			assertEquals(CheckoutOverview.totalVat(driver).getText(), "305,75");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		CheckoutOverview.btn_Continue(driver).click();

		//Bestellbestätigung
		try {
			assertEquals(OrderConfirmation.textBefore(driver).getText(), "Vielen Dank für Ihren Einkauf!");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		System.out.println(OrderConfirmation.textBefore(driver).getText());
	}

	@AfterTest
	public void closeWindow() {
		System.out.println("Trying to close browser for " + this.toString());
		System.out.println("-------------------------------------------------------");
		driver.close();
	}
}