package com.telRan.addressbook.manager;
import com.telRan.addressbook.model.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private SessionHelper sessionHelper;
  private GroupHelper groupHelper;
  private NavigationHelper navigationHelper;
  WebDriver wd;

  public void start() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    navigationHelper.openSite("http://localhost/addressbook");
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
  }


  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public void stop() {
    wd.quit();
  }

  public void submitGroupModification() {
    groupHelper.click(By.name("update"));

  }

  public void isHomePage() {
    Assert.assertEquals(wd.getCurrentUrl(), "http://localhost/addressbook/index.php");
  }

  public void returnToHome() throws InterruptedException {
    Thread.sleep(3000);
  }

  public void submitAddressEntryCreation() {
    groupHelper.click(By.cssSelector("[name=submit]:nth-child(1)"));
  }

  public void fillAddressForm(Address address) {
    groupHelper.type(By.name("firstname"), address.getAddressName());
    groupHelper.type(By.name("lastname"), address.getFamilyName());
    groupHelper.type(By.name("address"), address.getAddress());
    groupHelper.type(By.name("email"), address.getEmail());
    groupHelper.type(By.name("mobile"), address.getPhone());
  }

  public void openAddressEntryPage() {
    groupHelper.click(By.cssSelector("[href='edit.php']"));
  }

  public void submitAddressUpdate() {
    groupHelper.click(By.cssSelector("[name='update']:nth-child(1)"));
  }

  public void clickEditIcon() {
    groupHelper.click(By.xpath("(//img[@title=\"Edit\"])[1]"));
  }

  public void submitDeleteAddress() {
    groupHelper.click(By.xpath("//input[@value='Delete']"));
  }

  public void createAddress() {
    openAddressEntryPage();
    fillAddressForm(new Address()
            .setAddressName("AddressAddedBySelenium2")
            .setFamilyName("FamilyName2")
            .setEmail("Shevchenko_2")
            .setAddress("cheburashka@gmail.com")
            .setPhone("+97222255555"));
    submitAddressEntryCreation();
  }

  public boolean isAddressPresent() {
  return groupHelper.isElementPresent(By.name("selected[]"));
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

}
