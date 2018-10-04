package com.telran.qa15.sandbox.lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
  WebDriver wd;

  @BeforeMethod
  public void setUp() throws InterruptedException {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    Thread.sleep(500);
    openWiki();
  }
  @AfterMethod
  public void tearDown(){
    wd.quit();
  }

  public void openWiki() {
    wd.get("https://www.wikipedia.org/");
  }

  public void findAndClickOnTheEnglishLink() {
    wd.findElement(By.id("js-link-box-en")).click();
  }


}
