package com.telran.qa15.sandbox.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ebay {

    WebDriver wd;

    @BeforeMethod
    public void setUp() throws IOException {
      wd=new ChromeDriver();
      wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void openSiteTest() {
      wd.navigate().to("https://www.ebay.com");
      wd.findElement(By.linkText("Sign in")).click();

      wd.findElement(By.id("userid")).click();
      wd.findElement(By.id("userid")).clear();
      wd.findElement(By.id("userid")).sendKeys("logradum@gmail.com");

      wd.findElement(By.id("pass")).click();
      wd.findElement(By.id("pass")).clear();
      wd.findElement(By.id("pass")).sendKeys("klop1913");

      wd.findElement(By.id("sgnBt")).click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
      Thread.sleep(3000);
      wd.quit();
    }
  }


