package com.telran.qa15.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BoardHelper extends HelperBase {

  public BoardHelper(WebDriver wd) {
    super(wd);
  }

  public int getBoardCount() {
  Integer i= wd.findElements(By.xpath("//*[@class='board-tile-details is-badged']")).size();
    if (i!=null) return i;
    return 0;
  }

}
