package com.telRan.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{
  @BeforeMethod
  public void preconditions(){
    openGroupsPage();
    if (!isGroupPresent()){
      createGroup();
    }
  }

  @Test
  public void testGroupDelition(){
    openGroupsPage();
    selectGroup();
    deleteGroup();
    returnToGroupsPage();
  }

}
