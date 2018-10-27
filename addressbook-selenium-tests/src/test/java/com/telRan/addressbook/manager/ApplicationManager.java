package com.telRan.addressbook.manager;
import com.telRan.addressbook.model.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private AddressHelper addressHelper;
  private SessionHelper sessionHelper;
  private GroupHelper groupHelper;
  private NavigationHelper navigationHelper;
  WebDriver wd;

  public void start() {
    wd = new ChromeDriver();
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


  public void returnToHome() throws InterruptedException {
    Thread.sleep(3000);
  }

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
