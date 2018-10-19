package com.telRan.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressDeletionTests extends TestBase {
  @BeforeMethod
  public void preconditions(){
    if (!isAddressPresent()){
      createAddress();
    }
  }

  @Test
  public void testAddressDelete() throws InterruptedException {
    clickEditIcon();
    submitDeleteAddress();
    Thread.sleep(3000);
    isHomePage();
  }
}
