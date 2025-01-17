package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutLogin {

	private static WebElement element = null;

	public static WebElement radiobx_Guest (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebLoginRegisterRadio1"));
		return element;
	}

	public static WebElement radiobx_Register (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebLoginRegisterRadiosRegister"));
		return element;
	}

	public static WebElement input_Email (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebLoginLoginEmail"));
		return element;
	}

	public static WebElement input_Password (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebLoginLoginPassword"));
		return element;
	}

	public static WebElement btn_continue (WebDriver driver){
		element = driver.findElement(By.id("button_nextWebLogin1"));
		return element;
	}

	public static WebElement btn_Login (WebDriver driver){
		element = driver.findElement(By.id("button_loginWebLogin2"));
		return element;
	}
}
