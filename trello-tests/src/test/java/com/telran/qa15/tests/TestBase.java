package com.telran.qa15.tests;
import com.telran.qa15.manager.ApplicationManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

  protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
          BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws InterruptedException {

    Thread.sleep(3000);
    app.start("logradum@gmail.com", "klop1913");
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown(){
    app.stop();
  }
}
