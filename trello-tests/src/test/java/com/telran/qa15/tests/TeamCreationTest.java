package com.telran.qa15.tests;
import com.telran.qa15.data.Team;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase{
  @Test
  public void testTeamCreation() throws InterruptedException {
    int teamsBefore = app.getTeamHelper().getTeamsCount();

    app.getTeamHelper().click(By.xpath("//*[contains(text(),'Create a team')]"));
    app.getTeamHelper().fillTeamCreationForm(new Team().setTeamName("FluentTeam").setTeamDescription("FluentDescription"));
    app.getTeamHelper().click(By.xpath("//*[@type='submit']"));
    Thread.sleep(1000);
    app.getTeamHelper().returnHomeIconClick();
    app.getNavigationHelper().refreshMainPage();
    int teamsAfter = app.getTeamHelper().getTeamsCount();
    Assert.assertEquals(teamsAfter,teamsBefore+1);
  }


}
