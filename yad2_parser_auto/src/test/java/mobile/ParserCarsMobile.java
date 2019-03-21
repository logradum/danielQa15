package mobile;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParserCarsMobile {
  WebDriver wd;

  @BeforeTest
  public void setUp(){
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    wd.manage().window().setPosition(new Point(0,0));
    wd.manage().window().setSize(new Dimension(800,600));
    wd.get("https://www.yad2.co.il");
  }

  @Test
    public void chooseCar() throws InterruptedException {
    //open cars
    wd.findElement(By.xpath("//a[@class='title_sub_menu'][contains(text(),'רכב')]")).click();
    //go to menu
    wd.findElement(By.xpath("//i[@class='y2i_menu']")).click();
    Thread.sleep(500);
    //go to cars
    wd.findElement(By.xpath("//i[@class='y2i_car']")).click();
    Thread.sleep(1000);
    chooseValueFromDropDown(By.cssSelector("[placeholder=יצרן]"), By.xpath("//li[@data-val='16']"));


  }

  private void chooseValueFromDropDown(By field, By value) throws InterruptedException {
    WebElement placeHolder = wd.findElement(field);

    placeHolder.click();
    Thread.sleep(1000);
    WebElement companyAuto = wd.findElement(value);
    companyAuto.click();
  }
//  @AfterTest(alwaysRun = true)
//  public void tearDown(){
//    wd.close();
//    wd.quit();
//  }
}
