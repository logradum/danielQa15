package com.telran.qa15.tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase{
  @DataProvider
  public Object[] getData() {

    return new Object[0];
  }
  @Test
  public void testTeamCreation() throws InterruptedException {
    int teamsBefore = app.getTeamHelper().getTeamsCount();
    app.getTeamHelper().createTeam();
    app.getNavigationHelper().refreshMainPage();
    int teamsAfter = app.getTeamHelper().getTeamsCount();
    Assert.assertEquals(teamsAfter,teamsBefore+1);

  }


}
