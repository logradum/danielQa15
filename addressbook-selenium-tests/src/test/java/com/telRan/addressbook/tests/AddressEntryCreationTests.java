package com.telRan.addressbook.tests;
import com.telRan.addressbook.model.Address;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class AddressEntryCreationTests extends TestBase {


  @BeforeMethod
  public void addressPreconditions() {
    if (!app.getAddressHelper().isAddressPresent()) {
      app.getAddressHelper().createAddress();
    }
  }

  @Test
  public void testAddressEntryCreation() throws InterruptedException {
    app.getAddressHelper().openAddressEntryPage();
    app.getAddressHelper().fillAddressForm(new Address()
            .setAddressName("AddressAddedBySelenium1")
            .setFamilyName("FamilyName1")
            .setEmail("cheburashka@gmail.comS")
            .setPhone("+97222223222")
            .setAddress("hevchenko_1"));
    // addFoto();
    app.getAddressHelper().submitAddressEntryCreation();
    app.returnToHome();
    app.getAddressHelper().isHomePage();
  }
}
