package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by wdeister on 14/06/15.
 */

public class Login_Page {

	private static WebElement element = null;

	public static WebElement txtbx_UserName(WebDriver driver){
		element = driver.findElement(By.id("PlentyWebMyAccountLoginEmail"));
		return element;
	}

	public static WebElement txtbx_Password(WebDriver driver){
		element = driver.findElement(By.id("PlentyWebMyAccountLoginPassword"));
		return element;
	}

	public static WebElement btn_LogIn(WebDriver driver){
		element = driver.findElement(By.id("button_loginMyAccountLogin"));
		return element;
	}
}