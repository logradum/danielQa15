package com.telRan.addressbook;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    openGroupsPage();
    initGroupCreation();
    fillGroupForm(new Group()
            .setGroupName("QA15")
            .setGroupHeader("TheTestingHeader")
            .setGroupFooter("TheTestingFooter"));
    submitGroupCreation();
    returnToGroupsPage();
  }

}

