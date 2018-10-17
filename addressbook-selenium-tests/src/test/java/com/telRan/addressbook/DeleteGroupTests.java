package com.telRan.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteGroupTests extends TestBase{
  @Test
  public void testGroupDelition(){
    openGroupsPage();
    selectGroup();
    deleteGroup();
    returnToGroupsPage();
  }

  private void deleteGroup() {
    wd.findElement(By.xpath("//input[@name='delete'][2]")).click();
  }

}
