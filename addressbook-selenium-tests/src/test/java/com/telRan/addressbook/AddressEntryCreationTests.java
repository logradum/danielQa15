package com.telRan.addressbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressEntryCreationTests extends TestBase {
  @BeforeMethod
  public void addressPreconditions(){
    if (!isAddressPresent()){
      createAddress();
    }
  }

  @Test
  public void testAddressEntryCreation() throws InterruptedException {
    openAddressEntryPage();
    fillAddressForm(new Address()
            .setAddressName("AddressAddedBySelenium1")
            .setFamilyName("FamilyName1")
            .setEmail("cheburashka@gmail.comS")
            .setPhone("+97222223222")
            .setAddress("hevchenko_1"));
    // addFoto();
    submitAddressEntryCreation();
    returnToHome();
  }

}
