package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Myaccount {

	private static WebElement element = null;

	public static WebElement btn_LogOut (WebDriver driver){
		element = driver.findElement(By.id("button_logoutPlentyWebMyAccountLogout"));
		return element;
	}

	public static WebElement messageBox (WebDriver driver){
		element = driver.findElement(By.cssSelector("div.plentyMessageBox"));
		return element;
	}
}