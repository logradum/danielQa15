package com.telRan.addressbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
  @BeforeMethod
  public void precondition(){
    openGroupsPage();
    if (!isGroupPresent()) {
      createGroup();
    }
  }
  @Test
  public void testGroupModification(){
    openGroupsPage();
    selectGroup();
    initGroupModification();
    fillGroupForm(new Group().setGroupHeader("modifyed").setGroupName("new").setGroupFooter("changed"));
    submitModification();
    returnToGroupsPage();
  }

}
