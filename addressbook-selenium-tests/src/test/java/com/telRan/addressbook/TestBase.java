package com.telRan.addressbook;

import org.openqa.selenium.By;
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

  public void fillGroupForm(String groupName, String groupHeader, String groupFooter) {
    type(By.name("group_name"), groupName);
    type(By.name("group_header"), groupHeader);
    type(By.name("group_footer"), groupFooter);
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

  public void fillAddressForm() {
    type(By.name("firstname"), "AddressAddedBySelenium1");
    type(By.name("lastname"), "FamilyName1");
    type(By.name("address"), "Shevchenko_1");
    type(By.name("email"), "cheburashka@gmail.com");
    type(By.name("mobile"), "+97222223222");
  }

  public void fillAddressForm(String modifAddressName, String modifFamilyName, String modifAddress, String modifEmail, String modifPhone) {
    type(By.name("firstname"), modifAddressName);
    type(By.name("lastname"), modifFamilyName);
    type(By.name("address"), modifAddress);
    type(By.name("email"), modifEmail);
    type(By.name("mobile"), modifPhone);
  }

  public void openAddressEntryPage() {
    wd.findElement(By.cssSelector("[href='edit.php']")).click();
  }

  public void submitAddressUpdate() {
    wd.findElement(By.cssSelector("[name='update']:nth-child(1)")).click();
  }

  public void modificateAddressForm() {
    fillAddressForm("nameModificated", "nameModificated", "addressModificated",
            "Email@dot.modificated", "+9725555555Modif");
  }

  public void clickEditIcon() {

    //By xpath
   /* int i=0;
    for ( ;wd.findElements(By.xpath("//a[@href='edit.php?id="+i+"']//img[@title='Edit']")).isEmpty(); i++){
  }
    wd.findElement(By.xpath("//a[@href='edit.php?id="+i+"']//img[@title='Edit']")).click();
  */

    //By cssSelector
    int i = 0;
    for (; wd.findElements(By.cssSelector("table.sortcompletecallback-applyZebra:nth-child(2) tbody:nth-child(1) " +
            "tr.odd:nth-child(" + i + ") td.center:nth-child(8) a:nth-child(1) > img:nth-child(1)")).isEmpty(); i++) {
    }
    wd.findElement(By.cssSelector("table.sortcompletecallback-applyZebra:nth-child(2) tbody:nth-child(1) " +
            "tr.odd:nth-child(" + i + ") td.center:nth-child(8) a:nth-child(1) > img:nth-child(1)")).click();

  }
}

