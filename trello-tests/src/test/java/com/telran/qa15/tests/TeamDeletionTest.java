package com.telran.qa15.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {
  @Test
  public void testTeamDeletion()  {
    int beforeTeam = app.getTeamHelper().getTeamsCount();
    app.getTeamHelper().openTeam();
    app.getTeamHelper().openTeamSettings();
    app.getTeamHelper().deleteThisTeam();

    int afterTeam = app.getTeamHelper().getTeamsCount();
    Assert.assertEquals(afterTeam,beforeTeam-1);
  }

}
