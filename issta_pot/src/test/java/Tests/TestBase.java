package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
  public WebDriver wd;



  @BeforeTest
  public void start(){
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get("https://www.issta.co.il");
  }

  public void chooseDepartureDirection(By field, By value) {
    WebElement tmp = wd.findElement(field);
    Actions dropdownFlights = new Actions(wd);
    dropdownFlights.moveToElement(tmp).click().perform();
    tmp = wd.findElement(value);
    dropdownFlights.click(tmp).perform();
  }

  public void type(By locator, String s) {
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(s);
  }

  @AfterTest(alwaysRun = true)
  public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    wd.quit();
  }
}
