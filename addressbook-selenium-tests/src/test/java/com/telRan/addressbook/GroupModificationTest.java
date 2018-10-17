package com.telRan.addressbook;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{
  @Test
  public void testGroupModification(){
    openGroupsPage();
    selectGroup();
    initGroupModification();
    fillGroupForm("modifyed", "new", "changed");
    submitModification();
    returnToGroupsPage();
  }

}
