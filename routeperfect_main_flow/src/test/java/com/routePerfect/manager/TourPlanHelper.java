package com.routePerfect.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TourPlanHelper extends HelperBase {
  public TourPlanHelper(WebDriver wd) {
    super(wd);
  }
  public void selectLongNameFromDropDownTourPlan(String destinationConfirmFull){
    WebElement longName = waitUntilPresent(By.xpath("//*[contains(text(),'"+ destinationConfirmFull +", ')]"));
  }
}
