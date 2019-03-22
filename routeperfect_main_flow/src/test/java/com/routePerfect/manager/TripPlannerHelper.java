package com.routePerfect.manager;

import com.routePerfect.model.TripPlanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Calendar;

public class TripPlannerHelper extends HelperBase {


  public TripPlannerHelper(WebDriver wd) {
    super(wd);
  }

  public void chahgePaxTwoAdultsTwoKidsTripPlanner() {
    openPaxDropDownTripPlanner();
    openPaxOtherOptionsTripPlanner();
    openSelectPaxChildrenDropDownTripPlanner();
    selectTwoChildrenFromDropDownPaxTripPlanner();

    /***** while Done button is hidden issue#1741 use javascript for clicking done *****/
    //waitUntilPresent(By.xpath("//button[@class='Button Button--main Button--primary btn-strong btn-strong--small']")).click();
    clickHiddenElement(wd.findElement(By.xpath("//button[@class='Button Button--main Button--primary btn-strong btn-strong--small']")));
  }

  public void selectTwoChildrenFromDropDownPaxTripPlanner() {
    /***** xpath dynamic for both homepage and trip-planner, means, always 2 kids *****/
    waitAndClick(By.xpath("(//md-option[contains(@id,'md-option')])[3]"));
  }

  public void openSelectPaxChildrenDropDownTripPlanner() {
    click(By.xpath("(//div[@class='mat-select-trigger'])[3]"));
  }

  public void openPaxOtherOptionsTripPlanner() {
    waitAndClick(By.xpath("//span[contains(text(),'Other options...')]"));
  }

  public void openPaxDropDownTripPlanner() {
    click(By.xpath("(//div[@class='input-field last'])"));
  }

  public void clickSubmitButtonHomePageTripPlanner(){
    click(By.cssSelector("#hp_showtrip"));
  }

  public void selectStartDateTripPlanner(Integer startDayFromNow) throws InterruptedException {
    Integer startDateFromNow = getStartInDateTripPlanner(startDayFromNow);
    cal = Calendar.getInstance();

    click(By.cssSelector("[placeholder='Not selected']"));
    if(!isCurrentMonthForStartInTripPlanner(startDayFromNow)){
      click(By.cssSelector("[class='Icon Icon--ic_arrow_right flexy']"));
    }

    //System.out.println("date of start travel after getStartDate is "+startDateFromNow);
    Thread.sleep(500);
    WebElement startingIn = waitUntilPresent(By.xpath("(//div[contains(text(),'"+ startDateFromNow
            +"')][@class='datepicker__calendar__month__day__num__active'])[1]"));
    startingIn.click();
  }

  public void selectEndInDateTripPlanner(Integer endDayFromNow) throws InterruptedException {
    Integer endDateFromNow = getEndInDateTripPlanner(endDayFromNow);
    cal = Calendar.getInstance();

    click(By.xpath("(//*[@placeholder='Not selected'])[2]"));
    System.out.println("date of end travel after getStartDate is "+endDateFromNow);
    Thread.sleep(5000);
    WebElement endingIn = waitUntilPresent(By.xpath("//div[contains(text(),'"+ endDateFromNow +"')]"));
    endingIn.click();
  }

  public int getEndInDateTripPlanner(int durationDaysFromStartIn) {
    cal.add(Calendar.DATE, durationDaysFromStartIn);
    return cal.get(Calendar.DAY_OF_MONTH);
  }

  public int getStartInDateTripPlanner(int dayOfMonthUntilToday) {
    cal.add(Calendar.DATE, dayOfMonthUntilToday);
    return cal.get(Calendar.DAY_OF_MONTH);
  }



  public boolean isCurrentMonthForStartInTripPlanner(Integer dayOfMonthFromToday) {
    /***** get current month (+1 because months starts from 0) *****/
    int monthCurrent = (cal.get(Calendar.MONTH))+1;
    //System.out.println("current month is "+monthCurrent);

    //System.out.println("days to add"+dayOfMonthFromToday);
    /***** get month of starting route day *****/
    cal.add(Calendar.DATE, dayOfMonthFromToday);
    int monthTravelDate = (cal.get(Calendar.MONTH))+1;
    //System.out.println("month of travel is "+monthTravelDate);

    return monthCurrent == monthTravelDate;
  }



  public void fillStartInTripPlanner(String destinationShortName, String destinationConfirmFull) {
    typeAndChooseFromDropdownTripPlanner(By.xpath("//input-combobox[@id='startIn']")
            , By.xpath("(//*[@placeholder='City/Region/Country'])[1]")
            , destinationShortName, destinationConfirmFull);
  }

  public void typeAndChooseFromDropdownTripPlanner(By selectorField, By fieldlaceHolderToConfirm, String destinationShortname, String destinationConfirmFull) {
    wd.findElement(selectorField).click();
    wd.findElement(fieldlaceHolderToConfirm).sendKeys(destinationShortname);
    WebElement startingIn = waitUntilPresent(By.xpath("//*[contains(text(),'"+ destinationConfirmFull +", ')]"));
    startingIn.click();
  }

  public void fillEndInTripPlanner(String destinationShortName, String destinationConfirmFullWithComa) {
    typeAndChooseFromDropdownTripPlanner(By.xpath("//input-combobox[@id='endingIn']")
            , By.xpath("(//*[@placeholder='City/Region/Country'])[2]")
            , destinationShortName, destinationConfirmFullWithComa);
  }


  public void fillTripPlanner(TripPlanner route) throws InterruptedException {
    fillStartInTripPlanner(route.getStartFromDestinationShort(), route.getStartFromDestinationLong());
    fillEndInTripPlanner(route.getEndInDestinationShort(), route.getEndInDestinationLong());
    /***** route duration should be up to the end of next month, because app could click calendar month only once *****/
    selectStartDateTripPlanner(route.getStartDayAfter());
    selectEndInDateTripPlanner(route.getEndDayAfter());
  }

}
