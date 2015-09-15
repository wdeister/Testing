package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Login_Page;
import org.testng.*;
import pageObjects.Myaccount;

/**
 * Created by wdeister on 31/08/15.
 */

public class MyAccount_Scenario {

	public static WebDriver driver = null;

	@BeforeTest
	public void initWebDriver() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Login_Logout() {
		driver.get("http://trainstation.plenty-showcase.de/my-account/");
		// Start_Page.lnk_MyAccount(driver).click();
		Login_Page.txtbx_UserName(driver).sendKeys("waldemar.deister@plentymarkets.com");
		Login_Page.txtbx_Password(driver).sendKeys("Test123!");
		Login_Page.btn_LogIn(driver).click();
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		Myaccount.btn_LogOut(driver).click();

		driver.close();
	}

	@AfterTest
	public void closeWindow() {
		driver.close();
	}


}