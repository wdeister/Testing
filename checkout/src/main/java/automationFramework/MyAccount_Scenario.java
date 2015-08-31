package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.Login_Page;
import pageObjects.Myaccount;

/**
 * Created by wdeister on 31/08/15.
 */
public class MyAccount_Scenario {
	private static WebDriver driver = null;


	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://trainstation.plenty-showcase.de/my-account/");
		// Start_Page.lnk_MyAccount(driver).click();
		Login_Page.txtbx_UserName(driver).sendKeys("waldemar.deister@plentymarkets.com");
		Login_Page.txtbx_Password(driver).sendKeys("Test123!");
		Login_Page.btn_LogIn(driver).click();
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		Myaccount.btn_LogOut(driver).click();

		driver.close();
	}

	public void testmvn()
	{
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
	}

}
