package com.telran.qa15.manager;

import com.telran.qa15.data.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class TeamHelper extends HelperBase{

  public String modificatedRandomName;

  public TeamHelper(WebDriver wd) {
    super(wd);
  }

  public void fillTeamCreationForm(Team team) {
    type(By.id("org-display-name"), team.getTeamName());
    type(By.id("org-desc"), team.getTeamDescription());
  }

  public int getTeamsCount() {
    return wd.findElements(By.xpath("//*[@class='icon-organization icon-sm tab__tabIconSpan__jlnEo']")).size();
  }

  public void deleteThisTeam() {
    click(By.xpath("//*[contains(text(),'Delete this team?')]"));
    click(By.xpath("//*[@class='js-confirm full negate']"));
  }

  public void openTeamSettings() {
    click(By.xpath("//*[@class='icon-gear icon-sm tab__tabIconSpan__jlnEo']"));
  }

  public void openTeam() {
    click(By.xpath("(//*[@class='icon-organization icon-sm tab__tabIconSpan__jlnEo'])[1]"));

  }

  public void returnHomeIconClick() {
    click(By.xpath("//*[@class='header-logo-default']"));
  }

  public int getModificatedTeamsCount() {
    return wd.findElements(By.xpath("//*[text()='" + modificatedRandomName + "']")).size();
  }

  public void fillTeamNewName() {
    getRandomName();
    type(By.name("displayName"), modificatedRandomName);
  }

  public void getRandomName() {
    Random rand = new Random();
    int i = rand.nextInt(1000) + 1;
    modificatedRandomName = "TeamModificatedName" + i;
  }

  public void openEditTeamProfile() {
    click(By.xpath("//*[@class='button-link tabbed-pane-header-details-edit js-edit-profile']"));
  }

  public void createTeam() throws InterruptedException {
    try {
      click(By.cssSelector("[class='icon-add icon-sm tab__tabIconSpan__jlnEo']"));
    } catch (Exception e) {
      click(By.cssSelector("[class='icon-add icon-sm tab__tabIconSpan__jlnEo']"));
    }

    fillTeamCreationForm(new Team().setTeamName("FluentTeam").setTeamDescription("FluentDescription"));
    click(By.xpath("//*[@type='submit']"));
    Thread.sleep(1000);
    returnHomeIconClick();

  }


}
