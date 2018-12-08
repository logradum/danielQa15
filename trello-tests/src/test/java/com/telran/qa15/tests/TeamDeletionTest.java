package com.telran.qa15.tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {
  @BeforeTest
  public void preconditions() throws InterruptedException {
    if(!app.getBoardHelper()
            .isElementPresent(By
                    .xpath("(//*[@class='icon-organization icon-sm tab__tabIconSpan__jlnEo'])[1]"))){
      app.getTeamHelper().createTeam();
    }
  }
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
