package com.telran.qa15.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }
  public void refreshMainPage() {
   click(By.xpath("//*[text()='Home']"));
  }
  public void refreshCurrentPage(){
    wd.navigate().refresh();
  }
  public void goHomeFromBoard(){
    click(By.xpath("//span[@class='header-btn-icon icon-lg icon-house light']"));
  }
  public void getFromOverlay(){
    WebElement home = wd.findElement(By.xpath("//span[@class='header-btn-icon icon-lg icon-house light']"));
    new Actions(wd).doubleClick(home).release().perform();
  }
}
