package com.routePerfect.tests;
import com.routePerfect.manager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.lang.reflect.Method;

public class TestBase {
  Logger Logger = LoggerFactory.getLogger(TestBase.class);

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

  @BeforeMethod
  public void logTestStart(Method m){
    Logger.info("Start test "+ m.getName());
  }

  @AfterMethod
  public void logTestStop(Method m){
    Logger.info("Stop test"+ m.getName());
  }

}
