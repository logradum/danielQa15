package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase  {

  WebDriver wd;

  @BeforeTest
  public void SetUp(){
    wd=new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    wd.close();
  }

  public void findJavaWiki() {
    wd.navigate().to("https://www.wikipedia.org/");
    wd.findElement(By.id("searchInput")).sendKeys("Java");
    wd.findElement(By.cssSelector("i.sprite.svg-search-icon")).click();
  }
}
