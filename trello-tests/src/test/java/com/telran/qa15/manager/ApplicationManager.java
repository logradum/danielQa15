package com.telran.qa15.manager;
import org.openqa.selenium.WebDriver;

public class ApplicationManager {
  public SessionHelper sessionHelper;
  public NavigationHelper navigationHelper;
  private TeamHelper teamHelper;
  public WebDriver wd;

  public void start(String login, String pass) {
    wd.navigate().to("https://trello.com");
    teamHelper = new TeamHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login(login, pass);
  }

  public TeamHelper getTeamHelper() {
    return teamHelper;
  }
  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
