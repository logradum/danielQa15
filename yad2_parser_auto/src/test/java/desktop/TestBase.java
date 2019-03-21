package desktop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestBase {

  WebDriver wd;

  @BeforeTest
  public void setUp(){
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

    wd.get("https://www.yad2.co.il/vehicles/private-cars/toyota-corolla-run-x?manufacturer=16&model=944&year=2004-2007&price=8000-12000");

  }

  @Test
  public void chooseCarParams() throws InterruptedException {
    chooseCarCompany();
    chooseCarModel();
    Thread.sleep(1000);
    chooseAge(2004, 2010);
  }

  private void chooseAge(int from, int till) throws InterruptedException {
    WebElement placeHolder = wd.findElement(By.cssSelector("[placeholder=שנה]"));
    placeHolder.click();
    Thread.sleep(1000);
    placeHolder = wd.findElement(By.cssSelector("[placeholder=מ -]"));
    placeHolder.sendKeys(""+from);
    Thread.sleep(500);
    placeHolder = wd.findElement(By.cssSelector("[placeholder=עד -]"));
    placeHolder.sendKeys(""+till);
  }

  public void chooseCarModel() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(wd,15);
    wait.until(ExpectedConditions
            .attributeContains(By.cssSelector("[placeholder=דגם]"),"class", "search_column on_bar"));

    chooseValueFromDropDown(By.cssSelector("[placeholder=דגם]"), By.xpath("//span[contains(text(),'קורולה RUN-X')]"));
  }

  public void chooseCarCompany() throws InterruptedException {
    chooseValueFromDropDown(By.cssSelector("[placeholder=יצרן]"), By.xpath("//li[@data-val='16']"));

  }

  public void chooseValueFromDropDown(By field, By value) throws InterruptedException {
   WebElement placeHolder = wd.findElement(field);

   placeHolder.click();
   Thread.sleep(1000);
   WebElement companyAuto = wd.findElement(value);
   companyAuto.click();
  }

  @AfterTest (alwaysRun = true)
  public void tearDown(){
    wd.close();
    wd.quit();
  }

}
