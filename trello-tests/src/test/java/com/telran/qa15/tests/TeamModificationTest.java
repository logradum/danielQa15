package com.telran.qa15.tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamModificationTest extends TestBase {

  @Test
  public void testTeamModification() {


    app.getTeamHelper().openTeam();
    app.getTeamHelper().openTeamSettings();
    app.getTeamHelper().openEditTeamProfile();
    app.getTeamHelper().fillTeamNewName();
    app.getTeamHelper().click(By.xpath("//*[@class='primary wide js-submit-profile']"));
    app.getTeamHelper().returnHomeIconClick();
    int teamsModificatedAfter = app.getTeamHelper().getModificatedTeamsCount();
    Assert.assertEquals(teamsModificatedAfter, 2);


  }

}
