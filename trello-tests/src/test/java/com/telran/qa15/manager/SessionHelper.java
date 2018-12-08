package com.telran.qa15.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SessionHelper extends HelperBase{


  public SessionHelper(WebDriver wd) {
    super(wd);

  }

  public void fillLoginForm(String adminLogin, String adminPassword) {
    type(By.name("user"), adminLogin);
    type(By.name("password"), adminPassword);
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
