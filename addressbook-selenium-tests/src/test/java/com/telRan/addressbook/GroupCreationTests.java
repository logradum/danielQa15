package com.telRan.addressbook;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    openGroupsPage();
    initGroupCreation();
    fillGroupForm("name test", "Something important", "Footers name, more important than something above");
    submitGroupCreation();
    returnToGroupsPage();
  }

}

