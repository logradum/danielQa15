package com.telRan.addressbook.tests;

import com.telRan.addressbook.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressDeletionTests extends TestBase {
  @BeforeMethod
  public void preconditions(){
    if (!app.isAddressPresent()){
      app.createAddress();
    }
  }

  @Test
  public void testAddressDelete() throws InterruptedException {
    app.clickEditIcon();
    app.submitDeleteAddress();
    Thread.sleep(3000);
    app.isHomePage();
  }
}
