package automationFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Myaccount;

import static org.testng.Assert.assertEquals;

public class LoginLogout {

	public static WebDriver driver;
	private static Logger Log = Logger.getLogger(StandartPurchase.class.getName());

	@BeforeTest
	public void setUp() {
		DOMConfigurator.configure("log4j.xml");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Running Firefox for " + this.toString());
	}

	@Test (priority = 1)
	public void Login_Logout() {
		driver.get("http://trainstation.plenty-showcase.de/my-account/");
		LoginPage.txtbx_UserName(driver).sendKeys("selenium-859534656@example.com");
		LoginPage.txtbx_Password(driver).sendKeys("selenium-859534656@example.com");
		LoginPage.btn_LogIn(driver).click();
		Myaccount.btn_LogOut(driver).click();

		try {
			assertEquals(Myaccount.messageBox(driver).getText(), "×\n" +
					"Schließen\n" +
					"Hinweis\n" +
					"Sie sind nun nicht mehr im System eingeloggt.");
		} catch (Exception exp)
		{
			Log.info(exp);
		}
		System.out.println(Myaccount.messageBox(driver).getText());
		System.out.println("Trying to close Firefox for " + this.toString());
		System.out.println("-------------------------------------------------------");
	}

	@AfterTest
	public void closeWindow()
	{
		driver.close();
	}

}
