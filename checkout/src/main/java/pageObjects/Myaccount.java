package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by wdeister on 14/06/15.
 */

public class Myaccount {

	private static WebElement element = null;

	public static WebElement btn_LogOut(WebDriver driver){
		element = driver.findElement(By.id("button_logoutPlentyWebMyAccountLogout"));
		return element;
	}
}