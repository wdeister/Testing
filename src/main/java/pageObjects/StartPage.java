package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage {

	private static WebElement element = null;

	public static WebElement lnk_MyAccount (WebDriver driver){
		element = driver.findElement(By.linkText("Mein Konto"));
		return element;
	}

	public static WebElement lnk_LogOut (WebDriver driver){
		element = driver.findElement(By.linkText("Abmelden"));
		return element;
	}

	public static WebElement basketQuantity (WebDriver driver){
		element = driver.findElement(By.id("basket_quantity"));
		return element;
	}
}