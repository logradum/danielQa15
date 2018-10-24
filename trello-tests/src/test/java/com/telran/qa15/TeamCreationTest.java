package com.telran.qa15;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase{
  @Test
  public void testTeamCreation() throws InterruptedException {
    int teamsBefore = getTeamsCount();
    click(By.xpath("//*[contains(text(),'Create a team')]"));
    fillTeamCreationForm(new Team().setTeamName("FluentTeam").setTeamDescription("FluentDescription"));
    click(By.xpath("//*[@type='submit']"));
    Thread.sleep(1000);
    returnHomeIconClick();
    refreshMainPage();
    int teamsAfter = getTeamsCount();
    Assert.assertEquals(teamsAfter,teamsBefore+1);
  }

  public void refreshMainPage() {
    click(By.xpath("//*[text()='Home']"));
  }

}
