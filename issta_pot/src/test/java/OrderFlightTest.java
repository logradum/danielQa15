import Tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class OrderFlightTest extends TestBase {

  @Test
  public void testFlihgtOrdering() throws InterruptedException {
    chooseDepartureDirection(By.xpath("//div[@class='form-wrapper form-is-two-ways']//input[contains(@id,'flight_depart')][@name='dportname']"),
            By.xpath("//div[@class='form-row form-row-focus']//ul[@id='all-destinations']//li[2]//a[1]//i[1]"));
    Thread.sleep(1000);

    chooseDates();
  }

  private void chooseDates() throws InterruptedException {
    WebElement tmpElement = wd.findElement(By.xpath("(//div[@class='form-row two-way-date two-month date-col'])[(1)]"));
    Actions chooseDates=new Actions(wd);
    chooseDates.moveToElement(tmpElement).click().perform();
    Thread.sleep(1000);
    tmpElement = wd.findElement(By.xpath("(//td[text()='"+ getCurrentDate() +"'])[(1)]"));
    if (tmpElement.isDisplayed())
      chooseDates.click(tmpElement).perform();

   // clickDayFromCalendar(chooseDates);

  }

  private void clickDayFromCalendar(Actions chooseDates) {
    WebElement tmpElement;
    int arrivalDay = getIntDayAfterThirtyDays();
    tmpElement = wd.findElement(By.xpath("(//td[text()='"+ arrivalDay +"'])[(2)]"));
    chooseDates.moveToElement(tmpElement).click().perform();
  }

  private int getIntDayAfterThirtyDays() {
    Calendar cal =Calendar.getInstance();
    LocalDate.now();
    int i=cal.get(Calendar.DAY_OF_MONTH);
    cal.add(Calendar.DATE,31);
    return cal.get(Calendar.DAY_OF_MONTH);
  }
  public int getCurrentDate(){
    Calendar cal =Calendar.getInstance();
    LocalDate.now();
    return cal.get(Calendar.DAY_OF_MONTH);
  }

}
