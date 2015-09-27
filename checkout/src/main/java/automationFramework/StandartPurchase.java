package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

/**
 * Created by wdeister on 31/08/15.
 */

public class StandartPurchase {

	public static WebDriver driver;
	public static Logger Log = Logger.getLogger(StandartPurchase.class.getName());

	Random rand = new Random();
	int itemID = 131;
	String price = "1900,00";
	String price2 = "1910,00";
	String color = "schwarz€ +10,00";
	String email = "selenium"+rand.nextInt()+"@example.com";

	@BeforeTest
	public void setUp() {

		DOMConfigurator.configure("log4j.xml");
		driver = new FirefoxDriver();
//		driver = new EventFiringWebDriver(new FirefoxDriver()).register(eventListener);
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

		/*auf ajax warten*/
		WebDriverWait wait = new WebDriverWait(driver, 18);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-default")));
		ItemView.btn_close(driver).click();


		try {
			assertEquals(StartPage.basketQuantity(driver).getText(), "1");
		} catch (Exception exp)
		{
			Log.info(exp);
		}

		StartPage.basketQuantity(driver).click();

	}

	@Test (priority = 2)
	public void Basket() {
//		driver.get("http://trainstation.plenty-showcase.de/basket/");
		/*Todo*/
		Basket.proceedOrder(driver).click();

	}

	@Test (priority = 3)
	public void Checkout(){

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
		CheckoutInvoiceInformation.input_Password(driver).sendKeys("Test123!");
		CheckoutInvoiceInformation.input_Password2(driver).sendKeys("Test123!");
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
