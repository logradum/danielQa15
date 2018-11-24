package com.telran.qa15.manager;
import com.telran.qa15.tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  public SessionHelper sessionHelper;
  public NavigationHelper navigationHelper;
  private TeamHelper teamHelper;
  //instead of WebDriver connecting EventFiringWebDriver
  EventFiringWebDriver wd;
  private String browser;
  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void start(String login, String pass) {
    if(browser.equals(BrowserType.CHROME)){
      wd=new EventFiringWebDriver(new ChromeDriver());
    } else if (browser.equals(BrowserType.FIREFOX)){
      wd=new EventFiringWebDriver(new FirefoxDriver());
    } else if (browser.equals((BrowserType.SAFARI))){
      wd = new EventFiringWebDriver (new SafariDriver());
    }

    wd.register(new TestBase.MyListener());
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.navigate().to("https://trello.com");
    teamHelper = new TeamHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login(login, pass);
  }



  public TeamHelper getTeamHelper() {
    return teamHelper;
  }
  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public void stop() {
    wd.quit();
  }
}
