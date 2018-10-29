package com.telran.qa15.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{
  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void fillLoginForm(String login, String pass) {
    type(By.name("user"), login);
    type(By.name("password"), pass);
  }

  public void login(String login, String pass) {
    try {
      click(By.xpath("//*[@class='global-header-section-button']"));
    } catch (Exception e) {
      click(By.xpath("//a[@class='header-button-secondary']"));
    }
    fillLoginForm(login, pass);
    click(By.id("login"));
  }
}
