package com.telran.qa15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestBase {
  public String modificatedRandomName;
  WebDriver wd;

  @BeforeClass
  public void setUp() throws InterruptedException {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    Thread.sleep(3000);
    start("logradum@gmail.com", "klop1913");
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void fillLoginForm(String login, String pass) {
    type(By.name("user"), login);
    type(By.name("password"), pass);
  }

  public void type(By locator, String input) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(input);
  }

  public void start(String login, String pass) {
    wd.navigate().to("https://trello.com");
    try {
      click(By.xpath("//*[@class='global-header-section-button']"));
    } catch (Exception e) {
      click(By.xpath("//a[@class='header-button-secondary']"));
    }
    fillLoginForm(login, pass);
    click(By.id("login"));
  }

  public void fillTeamCreationForm(Team team) {
    type(By.id("org-display-name"), team.getTeamName());
    type(By.id("org-desc"), team.getTeamDescription());
  }

  @AfterClass
  public void tearDown(){
    wd.quit();
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
}
