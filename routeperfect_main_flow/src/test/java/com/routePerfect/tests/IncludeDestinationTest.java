package com.routePerfect.tests;
import com.routePerfect.model.TourPlan;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IncludeDestinationTest extends TestBase {
  @Test
  public void addDestinationTest(){

    /*******
     * need to build testng file to run RouteBuildingTest before
     * *******/
    addDestinationTripPlanner(new TourPlan().setDestinationShort("birm").setDestinationLong("Birmingham"));

  }

  private void addDestinationTripPlanner(TourPlan TourPlanShortLongNameDest) {
    fw.getTourPlanHelper().click(By.cssSelector("[class='Icon Icon--close']"));
    fw.getTourPlanHelper().click(By.cssSelector("[class='Icon Icon--close']"));

    fw.getTourPlanHelper().type(By.cssSelector("[placeholder='Add a destination or a region']")
            ,TourPlanShortLongNameDest.getDestinationShort());
    fw.getTourPlanHelper().selectLongNameFromDropDownTourPlan(TourPlanShortLongNameDest.getDestinationLong());
  }

}
