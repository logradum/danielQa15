package com.telRan.addressbook.tests;
import com.telRan.addressbook.model.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
  @BeforeMethod
  public void precondition(){
    app.getGroupHelper().openGroupsPage();
    int before = app.getGroupHelper().getGroupsCount();
    if (!app.getGroupHelper().isGroupPresent()) {
      app.getGroupHelper().createGroup();
    }
    int after = app.getGroupHelper().getGroupsCount();
    Assert.assertEquals(after,before);
  }
  @Test
  public void testGroupModification(){
    app.getGroupHelper().openGroupsPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new Group().setGroupHeader("modifyed").setGroupName("new").setGroupFooter("changed"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupsPage();
  }

}
