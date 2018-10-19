package com.telRan.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
  WebDriver wd;

  @BeforeClass
  public void setUp() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook");
    login("admin", "secret");

  }

  public void login(String userName, String password) {
    type(By.name("user"), userName);
    type(By.name("pass"), password);
    wd.findElement(By.cssSelector("[type=submit]")).click();
  }

  public void type(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void returnToGroupsPage() {
    wd.findElement(By.cssSelector("i a[href='group.php']")).click();
  }

  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(Group group) {
    type(By.name("group_name"), group.getGroupName());
    type(By.name("group_header"), group.getGroupHeader());
    type(By.name("group_footer"), group.getGroupFooter());
  }

  public void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  public void openGroupsPage() {
    wd.findElement(By.cssSelector("[href='group.php']")).click();
  }

  @AfterClass
  public void tearDown() {
    wd.quit();
  }

  public void submitModification() {
    wd.findElement(By.name("update")).click();

  }

  public void initGroupModification() {
    wd.findElement(By.cssSelector("[name=edit]:last-child")).click();
  }

  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }

  public void isHomePage() {
    Assert.assertEquals(wd.getCurrentUrl(), "http://localhost/addressbook/index.php");
  }

  public void returnToHome() throws InterruptedException {
    Thread.sleep(3000);
  }

  public void submitAddressEntryCreation() {
    wd.findElement(By.cssSelector("[name=submit]:nth-child(1)")).click();
  }



  public void fillAddressForm(Address address) {
    type(By.name("firstname"), address.getAddressName());
    type(By.name("lastname"), address.getFamilyName());
    type(By.name("address"), address.getAddress());
    type(By.name("email"), address.getEmail());
    type(By.name("mobile"), address.getPhone());
  }

  public void openAddressEntryPage() {
    wd.findElement(By.cssSelector("[href='edit.php']")).click();
  }

  public void submitAddressUpdate() {
    wd.findElement(By.cssSelector("[name='update']:nth-child(1)")).click();
  }

 /* public void modificateAddressForm() {
    fillAddressForm(
            new Address("nameModificated", "nameModificated", "addressModificated", "Email@dot.modificated", "+9725555555Modif"));
  }*/

  public void clickEditIcon() {
  wd.findElement(By.xpath("(//img[@title=\"Edit\"])[1]")).click();
  }

  public void submitDeleteAddress() {
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
  }

  private boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isGroupPresent(){
    return isElementPresent(By.name("selected[]"));
  }

  public void createGroup() {
    initGroupCreation();
    fillGroupForm(new Group()
            .setGroupName("QA15")
            .setGroupHeader("TheTestingHeader")
            .setGroupFooter("TheTestingFooter"));
    submitGroupCreation();
    returnToGroupsPage();
  }

  public void deleteGroup() {
    wd.findElement(By.xpath("//input[@name='delete'][2]")).click();
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
  return isElementPresent(By.name("selected[]"));
  }
}

