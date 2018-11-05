package com.telRan.addressbook.manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private AddressHelper addressHelper;
  private SessionHelper sessionHelper;
  private GroupHelper groupHelper;
  private NavigationHelper navigationHelper;
  WebDriver wd;
  private String browser;

  public ApplicationManager(String browser) {
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
    navigationHelper = new NavigationHelper(wd);
    navigationHelper.openSite("http://localhost/addressbook");
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
    groupHelper = new GroupHelper(wd);
    addressHelper = new AddressHelper(wd);

  }


  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public void stop() {
    wd.quit();
  }

 /* public void submitGroupModification() {
    groupHelper.click(By.name("update"));

  }*/

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public AddressHelper getAddressHelper() {
    return addressHelper;
  }


}
