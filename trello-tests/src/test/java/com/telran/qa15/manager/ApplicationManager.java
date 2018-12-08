package com.telran.qa15.manager;
import com.telran.qa15.tests.MyListener;
import com.telran.qa15.tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  public SessionHelper sessionHelper;
  public NavigationHelper navigationHelper;
  private TeamHelper teamHelper;
  private BoardHelper boardHelper;
  //instead of WebDriver connecting EventFiringWebDriver
  EventFiringWebDriver wd;
  private Properties properties;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void start() throws IOException {
    //launching browser with argument

    if(browser.equals(BrowserType.CHROME)){
      wd=new EventFiringWebDriver(new ChromeDriver());
    } else if (browser.equals(BrowserType.FIREFOX)){
      wd=new EventFiringWebDriver(new FirefoxDriver());
    } else if (browser.equals((BrowserType.SAFARI))){
      wd = new EventFiringWebDriver (new SafariDriver());
    }

    //launching listener
    wd.register(new MyListener());


    //setting up webDriver
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.navigate().to("https://trello.com");

    //helpers initialising
    teamHelper = new TeamHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    boardHelper = new BoardHelper(wd);

    //setting up login and password from properties file
    String target = System.getProperty("target","local");
    properties.load(new FileReader(new File(String
            .format("/Users/logradum/Documents/Tools/danielQa15/trello-tests/src/test/resources/%s.properties",target))));
    sessionHelper.login(properties.getProperty("web.adminLogin")
            ,properties.getProperty("web.adminPassword"));
  }



  //helpers creating
  public BoardHelper getBoardHelper() { return boardHelper; }
  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
  public TeamHelper getTeamHelper() { return teamHelper; }

  public void stop() {
    wd.quit();
  }
}
