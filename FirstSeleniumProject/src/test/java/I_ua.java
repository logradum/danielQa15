import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class I_ua {

    WebDriver wd;

    @BeforeMethod
    public void setUp() throws IOException {
      wd=new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void openSiteTest() {
      wd.navigate().to("https://www.i.ua");

      wd.findElement(By.name("login")).click();
      wd.findElement(By.name("login")).clear();
      wd.findElement(By.name("login")).sendKeys("dio1@email.ua");

      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys("compaq1913");

      wd.findElement(By.tagName("Вход на почту")).click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
      Thread.sleep(3000);
      wd.quit();
    }
  }


