package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestcaseWorld {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://trainstation.plenty-showcase.de/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCaseWorld() throws Exception {
    driver.get(baseUrl + "/wohnzimmer/sessel-hocker/sessel-redlabel/a-125/");
    driver.findElement(By.id("button_add_basket_ajax")).click();
    driver.get(baseUrl + "/basket/");
    driver.findElement(By.id("button_proceed_order")).click();
    driver.findElement(By.id("PlentyWebLoginRegisterRadio1")).click();
    driver.findElement(By.id("button_nextWebLogin1")).click();
    driver.findElement(By.id("PlentyWebInvoiceDetailsFirstName")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsFirstName")).sendKeys("Thomas");
    driver.findElement(By.id("PlentyWebInvoiceDetailsLastName")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsLastName")).sendKeys("Müller");
    driver.findElement(By.id("PlentyWebInvoiceDetailsStreet")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsStreet")).sendKeys("Ahornweg");
    driver.findElement(By.id("PlentyWebInvoiceDetailsHouseNo")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsHouseNo")).sendKeys("777");
    driver.findElement(By.id("PlentyWebInvoiceDetailsAddressAdditional")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsAddressAdditional")).sendKeys("A");
    driver.findElement(By.id("PlentyWebInvoiceDetailsZIPCode")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsZIPCode")).sendKeys("34117");
    driver.findElement(By.id("PlentyWebInvoiceDetailsCity")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsCity")).sendKeys("Kassel");
    driver.findElement(By.id("PlentyWebInvoiceDetailsEMail")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsEMail")).sendKeys("thomas.mueller@example.com");
    driver.findElement(By.id("PlentyWebInvoiceDetailsEMail2")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsEMail2")).sendKeys("thomas.mueller@example.com");
    driver.findElement(By.id("PlentyWebInvoiceDetailsTelephone")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsTelephone")).sendKeys("0123/45678");
    driver.findElement(By.id("PlentyWebInvoiceDetailsMobilenumber")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsMobilenumber")).sendKeys("0123/45678");
    driver.findElement(By.id("PlentyWebInvoiceDetailsBirthday")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsBirthday")).sendKeys("08");
    driver.findElement(By.id("PlentyWebInvoiceDetailsBirthmonth")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsBirthmonth")).sendKeys("04");
    driver.findElement(By.id("PlentyWebInvoiceDetailsBirthyear")).clear();
    driver.findElement(By.id("PlentyWebInvoiceDetailsBirthyear")).sendKeys("1988");
    driver.findElement(By.id("PlentyWebInvoiceDetailsShippingAdressOther")).click();
    driver.findElement(By.id("button_nextWebInvoiceDetails")).click();
    driver.findElement(By.id("PlentyWebShippingDetailsFirstName")).clear();
    driver.findElement(By.id("PlentyWebShippingDetailsFirstName")).sendKeys("Thomas");
    driver.findElement(By.id("PlentyWebShippingDetailsLastName")).clear();
    driver.findElement(By.id("PlentyWebShippingDetailsLastName")).sendKeys("Müller");
    driver.findElement(By.id("PlentyWebShippingDetailsStreet")).clear();
    driver.findElement(By.id("PlentyWebShippingDetailsStreet")).sendKeys("Uliza Mosfilmowskaja");
    driver.findElement(By.id("PlentyWebShippingDetailsHouseNo")).clear();
    driver.findElement(By.id("PlentyWebShippingDetailsHouseNo")).sendKeys("56");
    driver.findElement(By.id("PlentyWebShippingDetailsZIPCode")).clear();
    driver.findElement(By.id("PlentyWebShippingDetailsZIPCode")).sendKeys("119285");
    driver.findElement(By.id("PlentyWebShippingDetailsCity")).clear();
    driver.findElement(By.id("PlentyWebShippingDetailsCity")).sendKeys("Moskau");
    new Select(driver.findElement(By.id("PlentyWebShippingDetailsCountry"))).selectByVisibleText("Russland");
    driver.findElement(By.id("button_nextWebShippingDetails")).click();
    driver.findElement(By.id("button_nextShippingDetailsList")).click();
    driver.findElement(By.id("PlentyWebPaymentMethod0")).click();
    driver.findElement(By.id("button_nextWebPaymentMethod")).click();
    driver.findElement(By.id("PlentyWebShippingMethod8")).click();
    driver.findElement(By.id("button_nextWebShippingMethod")).click();
    driver.findElement(By.id("PlentyWebOrderOverviewAGB")).click();
    driver.findElement(By.id("PlentyWebOrderOverviewWithdrawal")).click();
    driver.findElement(By.id("PlentyWebOrderOverviewNotesTextarea")).clear();
    driver.findElement(By.id("PlentyWebOrderOverviewNotesTextarea")).sendKeys("seleniumhq");
    driver.findElement(By.id("button_place_orderWebOrderOverview")).click();
    assertEquals("Bahnhof", driver.getTitle());
    driver.get(baseUrl + "/-ActionCallQQWebActionLogoutCustomer/");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
