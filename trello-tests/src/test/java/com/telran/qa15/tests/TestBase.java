package com.telran.qa15.tests;
import com.telran.qa15.manager.ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;

import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

//listener read elements
public class TestBase {
  public static class MyListener extends AbstractWebDriverEventListener{
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println("search: " + by);
    }
    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by + " found");
    }
    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable);
    }
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
      System.out.println("click on element: "+element);
    }
    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
      System.out.println(element + " clicked");
    }
  }

  protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
          BrowserType.FIREFOX));

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  @BeforeSuite
  public void setUp() throws InterruptedException {

    Thread.sleep(3000);
    app.start("logradum@gmail.com", "klop1913");
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown(){
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m){
    logger.info("Start test: "+ m);
  }
  @AfterMethod
  public void logTestStop(Method m){
    logger.info("Stop test: "+ m);
  }

}
