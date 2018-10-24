package com.telran.qa15;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamDelitionTest extends TestBase {
  @Test
  public void testTeamDelition(){
    int beforeTeam = getTeamsCount();
    openTeam();
    openTeamSettings();
    deleteThisTeam();
    int afterTeam = getTeamsCount();
    Assert.assertEquals(afterTeam,beforeTeam-1);
  }

}
