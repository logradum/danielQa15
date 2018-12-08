package com.telran.qa15.tests;
import com.telran.qa15.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

//listener read elements
public class TestBase {

  protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
          BrowserType.FIREFOX));

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  @BeforeSuite
  public void setUp() throws IOException, InterruptedException {

    Thread.sleep(3000);
    app.start();
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown(){
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m){
    logger.info("Start test: "+ m.getName());
  }
  @AfterMethod
  public void logTestStop(Method m){
    logger.info("Stop test: "+ m.getName());
  }

}
