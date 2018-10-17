package com.telRan.addressbook;
import org.testng.annotations.Test;

public class AddressModificationTest extends TestBase {
  @Test
  public void testAddressModification() throws InterruptedException {
    clickEditIcon();
    modificateAddressForm();
    submitAddressUpdate();
    returnToHome();
    isHomePage();
  }
}
