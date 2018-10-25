package com.telRan.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{
  @BeforeMethod
  public void preconditions(){
    app.getGroupHelper().openGroupsPage();
    if (!app.getGroupHelper().isGroupPresent()){
      app.getGroupHelper().createGroup();
    }
  }

  @Test
  public void testGroupDelition(){
    app.getGroupHelper().openGroupsPage();
    int before = app.getGroupHelper().getGroupsCount();
    app.getGroupHelper().selectGroupByIndex(before-1);
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupsPage();
    int after = app.getGroupHelper().getGroupsCount();
    Assert.assertEquals(after,before-1);
  }

}
