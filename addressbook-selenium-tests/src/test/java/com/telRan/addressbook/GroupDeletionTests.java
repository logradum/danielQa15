package com.telRan.addressbook;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{
  @BeforeMethod
  public void preconditions(){
    app.openGroupsPage();
    if (!app.isGroupPresent()){
      app.createGroup();
    }
  }

  @Test
  public void testGroupDelition(){
    app.openGroupsPage();
    int before = app.getGroupsCount();
    app.selectGroupByIndex(before-1);
    app.deleteGroup();
    app.returnToGroupsPage();
    int after = app.getGroupsCount();
    Assert.assertEquals(after,before-1);
  }

}
