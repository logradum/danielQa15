package com.telRan.addressbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private GroupHelper groupHelper;
  WebDriver wd;

  public void start() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook");
    login("admin", "secret");

    groupHelper = new GroupHelper();
  }

  public void login(String userName, String password) {
    groupHelper.type(By.name("user"), userName);
    groupHelper.type(By.name("pass"), password);
    groupHelper.click(By.cssSelector("[type=submit]"));
  }

  public void stop() {
    wd.quit();
  }

  public void submitModification() {
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

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }


}
