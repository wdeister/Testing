package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by wdeister on 01/07/15.
 */
public class Checkout_Overview{

	private static WebElement element = null;

	public static WebElement ck_bx_AGB (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebOrderOverviewAGB"));
		return element;
	}

	public static WebElement ck_bx_Withdrawal (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebOrderOverviewWithdrawal"));
		return element;
	}

	public static WebElement inp_fld_Notes (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebOrderOverviewNotesTextarea"));
		return element;
	}

	public static WebElement inp_fld_Reference (WebDriver driver){
		element = driver.findElement(By.id("PlentyWebOrderOverviewReferenceInput"));
		return element;
	}

	public static WebElement btn_Continue (WebDriver driver){
		element = driver.findElement(By.id("button_place_orderWebOrderOverview"));
		return element;
	}



}
