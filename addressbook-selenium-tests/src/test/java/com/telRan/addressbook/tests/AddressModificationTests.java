package com.telRan.addressbook.tests;
import com.telRan.addressbook.model.Address;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressModificationTests extends TestBase {
  @BeforeMethod
  public void addressPreconditions(){
    if (!app.getAddressHelper().isAddressPresent()){
      app.getAddressHelper().createAddress();
    }
  }
  @Test
  public void testAddressModification() {
    app.getAddressHelper().clickEditIcon();
    app.getAddressHelper().fillAddressForm(new Address()
            .setAddressName("SeleniumModif")
            .setFamilyName("Selia")
            .setAddress("PushkinaModif")
            .setEmail("modify@i.net")
            .setPhone("+9720503345543"));
    app.getAddressHelper().submitAddressUpdate();
    app.getNavigationHelper().returnToHome();
  }
}
