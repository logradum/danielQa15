package com.telRan.addressbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressModificationTests extends TestBase {
  @BeforeMethod
  public void addressPreconditions(){
    if (!app.isAddressPresent()){
      app.createAddress();
    }
  }
  @Test
  public void testAddressModification() throws InterruptedException {
    app.clickEditIcon();
    app.fillAddressForm(new Address()
            .setAddressName("SeleniumModif")
            .setFamilyName("Selia")
            .setAddress("PushkinaModif")
            .setEmail("modify@i.net")
            .setPhone("+9720503345543"));
    app.submitAddressUpdate();
    app.returnToHome();
    app.isHomePage();
  }
}
