package com.telRan.addressbook.manager;

import com.telRan.addressbook.model.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddressHelper extends HelperBase {
  public AddressHelper(WebDriver wd) {
    super(wd);
  }

  public void submitAddressEntryCreation() {
    click(By.cssSelector("[name=submit]:nth-child(1)"));
  }

  public void fillAddressForm(Address address) {
    type(By.name("firstname"), address.getAddressName());
    type(By.name("lastname"), address.getFamilyName());
    type(By.name("address"), address.getAddress());
    type(By.name("email"), address.getEmail());
    type(By.name("mobile"), address.getPhone());
  }

  public void openAddressEntryPage() {
    click(By.cssSelector("[href='edit.php']"));
  }

  public void submitAddressUpdate() {
    click(By.cssSelector("[name='update']:nth-child(1)"));
  }

  public void clickEditIcon() {
    click(By.xpath("(//img[@title=\"Edit\"])[1]"));
  }

  public void submitDeleteAddress() {
    click(By.xpath("//input[@value='Delete']"));
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
  public void isHomePage(){
    Assert.assertEquals(isElementPresent(By.id("maintable")), true);
  }

  public boolean isAddressPresent() {
  return isElementPresent(By.name("selected[]"));
  }
}
