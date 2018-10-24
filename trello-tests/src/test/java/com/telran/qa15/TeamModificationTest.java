package com.telran.qa15;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamModificationTest extends TestBase {

  @Test
  public void testTeamModification() {


    openTeam();
    openTeamSettings();
    openEditTeamProfile();
    fillTeamNewName();
    click(By.xpath("//*[@class='primary wide js-submit-profile']"));
    returnHomeIconClick();
    int teamsModificatedAfter = getModificatedTeamsCount();
    Assert.assertEquals(teamsModificatedAfter, 2);
    //can somebody explain why this XPATH everytime find 2 elements instead of 1?
    //The page shows only 1 (checked with cltrl+f)

  }

}
