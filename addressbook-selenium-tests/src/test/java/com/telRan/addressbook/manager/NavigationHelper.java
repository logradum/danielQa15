package com.telRan.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void openSite(String url) {
    wd.get(url);
  }

  public void returnToHome(){
    click(By.xpath("//a[contains(text(),'home')]"));

  }

}
