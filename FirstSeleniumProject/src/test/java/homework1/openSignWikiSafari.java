package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class openSignWikiSafari {

  WebDriver wd;

  @BeforeMethod
  public void setUp() {
    wd = new SafariDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  }

  @Test
  public void openSignWikiTest() {
    wd.navigate().to("https://en.wikipedia.org");
    wd.findElement(By.linkText("Log in")).click();


    type(By.cssSelector("[name=wpName]"), "Logradum");

    type(By.id("wpPassword1"), "iKVcCAkZDa9L3Dt");

    wd.findElement(By.name("wploginattempt")).click();

  }

  public void type(By locator1, String value1) {
    wd.findElement(locator1).click();
    wd.findElement(locator1).clear();
    wd.findElement(locator1).sendKeys(value1);
  }


  @AfterMethod
  public void tearDown() throws InterruptedException {
    Thread.sleep(3000);
    wd.quit();
  }
}
