package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by wdeister on 14/06/15.
 */

public class CheckoutLogin {
	private static WebElement element = null;

	public static WebElement radiobx_Guest(WebDriver driver){
		element = driver.findElement(By.id("PlentyWebLoginRegisterRadio1"));
		return element;
	}

	public static WebElement radiobx_Register(WebElement driver){
		element = driver.findElement(By.id("PlentyWebLoginRegisterRadiosRegister"));
		return element;
	}

	public static WebElement input_Email(WebElement driver){
		element = driver.findElement(By.id("PlentyWebLoginLoginEmail"));
		return element;
	}

	public static WebElement input_Password(WebElement driver){
		element = driver.findElement(By.id("PlentyWebLoginLoginPassword"));
		return element;
	}

	public static WebElement btn_continue(WebElement driver){
		element = driver.findElement(By.id("button_nextWebLogin1"));
		return element;
	}

	public static WebElement btn_Login(WebElement driver){
		element = driver.findElement(By.id("button_loginWebLogin2"));
		return element;
	}
}
