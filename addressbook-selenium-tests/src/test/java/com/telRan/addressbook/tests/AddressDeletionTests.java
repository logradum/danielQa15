package com.telRan.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressDeletionTests extends TestBase {
  @BeforeMethod
  public void preconditions(){
    if (!app.getAddressHelper().isAddressPresent()){
      app.getAddressHelper().createAddress();
    }
  }

  @Test
  public void testAddressDelete() throws InterruptedException {
    app.getAddressHelper().clickEditIcon();
    app.getAddressHelper().submitDeleteAddress();
    Thread.sleep(3000);
    //app.isHomePage();
  }
}
