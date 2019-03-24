package com.routePerfect.tests;

import com.routePerfect.model.TripPlanner;
import org.testng.annotations.Test;

public class RouteBuildingTest extends TestBase {

  @Test
  public void buildRouteTest() throws InterruptedException {

    /***** test could work only with dates starting on the current or next month from today *****/
    /***** test could work only with route duration from 12 up to 28 days *****/
    /***** app works only when start in date begin after 4 (on the 5-th) day after today *****/

    TestBase.fw.getTripPlannerHelper().fillTripPlanner(new TripPlanner()
            .setStartFromDestinationShort("lon")
            .setStartFromDestinationLong("London")
            .setEndInDestinationShort("oxf")
            .setEndInDestinationLong("Oxford")
            .setStartDayAfter(5)
            .setEndDayAfter(12));

    TestBase.fw.getTripPlannerHelper().changePaxTwoAdultsTwoKidsTripPlanner();
    TestBase.fw.getTripPlannerHelper().clickSubmitButtonHomePageTripPlanner();
  }
}
