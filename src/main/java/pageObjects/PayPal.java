package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayPal {

	private static WebElement element = null;

	public static WebElement txtbx_UserName (WebDriver driver){
		element = driver.findElement(By.id("login_email"));
		return element;
	}

	public static WebElement txtbx_Password (WebDriver driver){
		element = driver.findElement(By.id("login_password"));
		return element;
	}

	public static WebElement btn_LogIn (WebDriver driver){
		element = driver.findElement(By.id("submitLogin"));
		return element;
	}

	public static WebElement btn_continue (WebDriver driver){
		element = driver.findElement(By.id("continue"));
		return element;
	}
}