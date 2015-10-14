package automationFramework;

import java.util.concurrent.TimeUnit;

import com.github.yev.FailTestScreenshotListener;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import pageObjects.Myaccount;

import static org.testng.Assert.assertEquals;

@Listeners(FailTestScreenshotListener.class)
public class LoginLogout {

	public static WebDriver driver;
	private static Logger Log = Logger.getLogger(StandartPurchase.class.getName());

	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) {
		DOMConfigurator.configure("log4j.xml");
		System.out.println("        _                _                              _           _\t      \n" +
				" _ __  | |    ___  _ __ | |_ __  __ _ _ _  ___ _  _ __ | | __  ___ | |_  ___  \n" +
				"| '_ \\ | |   / _ \\| '  \\|  _|\\ \\/ /| ' ' \\/  _' || '__|| |/ / / _ \\|  _|/ __| \n" +
				"| |_) || |_ |  __/| || || |_  \\  / | | | || (_) || |   |   < |  __/| |_ \\__ \\ \n" +
				"|  __/ |___| \\___||_||_| \\__| / /  |_|_|_|\\___._||_|   |_|\\_\\ \\___|\\___||___/ \n" +
				"|_| ");
		if (browser.equalsIgnoreCase("FF")){
			driver = new FirefoxDriver();
			System.out.println("Running Firefox for " + this.toString());
		}

		if (browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver");

			driver = new ChromeDriver();
			System.out.println("Running Chrome for " + this.toString());
		}
		driver.manage().window().setSize(new Dimension(1280, 960));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void Login_Logout() {
		driver.get("http://trainstation.plenty-showcase.de/my-account/");
		LoginPage.txtbx_UserName(driver).sendKeys("selenium-859534656@example.com");
		LoginPage.txtbx_Password(driver).sendKeys("selenium-859534656@example.com");
		LoginPage.btn_LogIn(driver).click();
		Myaccount.btn_LogOut(driver).click();

		try {
			assertEquals(Myaccount.messageBox(driver).getText(), "×\n" +
					"Schließen\n" +
					"Hinweis\n" +
					"Sie sind nun nicht mehr im System eingeloggt.");
		} catch (Exception exp)
		{
			Log.info(exp);
		}
		System.out.println(Myaccount.messageBox(driver).getText());

	}

	@AfterTest
	public void closeWindow() {
		System.out.println("Trying to close browser for " + this.toString());
		System.out.println("-------------------------------------------------------");
		driver.close();
	}

}
