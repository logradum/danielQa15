package com.telran.qa15.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class HelperBase {
  WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void type(By locator, String input) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(input);
  }
  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  public void waitElementTemporary(By locator){
    WebDriverWait wait = new WebDriverWait(wd, 10);
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  public void waitBlockedElement(){
    ((JavascriptExecutor) wd).executeScript("document.getElementById('ID').style.display='block';");
  }

}
