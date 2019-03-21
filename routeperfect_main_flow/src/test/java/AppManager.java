import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {
  private  TripPlannerHelper TripPlannerHelper;
  private LoginHelper LoginHelper;
  WebDriver wd;

  public LoginHelper getLoginHelper() {
    return LoginHelper;
  }

  public void start() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    wd.get("https://routeperfect.com/");
    TripPlannerHelper = new TripPlannerHelper(wd);
    LoginHelper = new LoginHelper(wd);
  }

  public void type(By locator, String text) {
    if(text!=null) {
      TripPlannerHelper.click(locator);
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }
  }

  public void stop() throws InterruptedException {
    Thread.sleep(3000);
    wd.quit();
  }


  public TripPlannerHelper getTripPlannerHelper() {
    return TripPlannerHelper;
  }
}
