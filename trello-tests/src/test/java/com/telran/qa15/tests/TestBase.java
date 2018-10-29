package com.telran.qa15.tests;
import com.telran.qa15.manager.ApplicationManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class TestBase {

  protected ApplicationManager app = new ApplicationManager();

  @BeforeClass
  public void setUp() throws InterruptedException {
    app.wd = new ChromeDriver();
    app.wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    Thread.sleep(3000);
    app.start("logradum@gmail.com", "klop1913");
  }

  @AfterClass
  public void tearDown(){
    app.wd.quit();
  }

}
