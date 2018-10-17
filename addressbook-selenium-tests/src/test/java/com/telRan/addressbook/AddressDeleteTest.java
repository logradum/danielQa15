package com.telRan.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddressDeleteTest extends TestBase {
  @Test
  public void testAddressDelete() throws InterruptedException {
    clickEditIcon();
    submitDeleteAddress();
    Thread.sleep(3000);
    isHomePage();
  }

  private void submitDeleteAddress() {
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
  }
}
