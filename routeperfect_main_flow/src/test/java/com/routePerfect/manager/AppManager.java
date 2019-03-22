package com.routePerfect.manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {
  private TripPlannerHelper TripPlannerHelper;
  private LoginHelper LoginHelper;
  private TourPlanHelper TourPlanHelper;
  WebDriver wd;

  public LoginHelper getLoginHelper() {
    return LoginHelper;
  }
  public TripPlannerHelper getTripPlannerHelper() { return TripPlannerHelper; }
  public com.routePerfect.manager.TourPlanHelper getTourPlanHelper() { return TourPlanHelper; }

  public void start() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    wd.get("https://test.routeperfect.com/");
    TripPlannerHelper = new TripPlannerHelper(wd);
    LoginHelper = new LoginHelper(wd);

    //if this place is correct? tourplan disable while we not on trip-planner page
    TourPlanHelper = new TourPlanHelper(wd);
  }


  public void stop() throws InterruptedException {
    Thread.sleep(3000);
    wd.quit();
  }



}
