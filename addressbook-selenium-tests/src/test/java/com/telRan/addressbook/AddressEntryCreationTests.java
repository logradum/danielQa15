package com.telRan.addressbook;

import org.testng.annotations.Test;

public class AddressEntryCreationTests extends TestBase {

  @Test
  public void testAddressEntryCreation() throws InterruptedException {
    openAddressEntryPage();
    fillAddressForm();
    // addFoto();
    submitAddressEntryCreation();
    returnToHome();
    isHomePage();
  }

}
