package com.routePerfect.manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {
  private TripPlannerHelper TripPlannerHelper;
  private LoginHelper LoginHelper;
  private TourPlanHelper TourPlanHelper;
  private String browser;
  WebDriver wd;

  public LoginHelper getLoginHelper() {
    return LoginHelper;
  }
  public TripPlannerHelper getTripPlannerHelper() { return TripPlannerHelper; }
  public com.routePerfect.manager.TourPlanHelper getTourPlanHelper() { return TourPlanHelper; }

  public AppManager(String browser) {
    this.browser = browser;
  }

  public void start() {

    if (browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    } else if (browser.equals((BrowserType.SAFARI))){
      wd = new SafariDriver();
    }

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    wd.get("https://test.routeperfect.com/");
    LoginHelper = new LoginHelper(wd);
    TripPlannerHelper = new TripPlannerHelper(wd);
    //if this place is correct? tourplan disable while we not on trip-planner page
    TourPlanHelper = new TourPlanHelper(wd);
  }


  public void stop() throws InterruptedException {
    Thread.sleep(1000);
    wd.quit();
  }



}
