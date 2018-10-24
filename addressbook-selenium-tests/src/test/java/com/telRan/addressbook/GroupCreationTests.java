package com.telRan.addressbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.openGroupsPage();
    int before = app.getGroupsCount();
    app.initGroupCreation();
    app.fillGroupForm(new Group()
            .setGroupName("QA15")
            .setGroupHeader("TheTestingHeader")
            .setGroupFooter("TheTestingFooter"));
    app.submitGroupCreation();
    app.returnToGroupsPage();
    int after = app.getGroupsCount();
    Assert.assertEquals(after,before+1);
  }

}

