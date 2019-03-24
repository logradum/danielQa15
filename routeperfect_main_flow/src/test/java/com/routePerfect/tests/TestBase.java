package com.routePerfect.tests;
import com.routePerfect.manager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {


  protected static AppManager fw = new AppManager(System.getProperty("browser",
          BrowserType.CHROME));

  @BeforeSuite
  public void setUp(){
    fw.start();
  }


  @AfterSuite(alwaysRun = true)
  public void teatDown() throws InterruptedException {
    fw.stop();
  }
}
