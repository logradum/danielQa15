package Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {

  RegistrationHelper registrationHelper;
  ContactMessageHelper contactMessageHelper;

  public ContactMessageHelper getContactMessageHelper() {
    return contactMessageHelper;
  }

  public RegistrationHelper getRegistrationHelper() {
    return registrationHelper;
  }

  public WebDriver wd;

  public void start(){
   wd = new ChromeDriver();
   wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   contactMessageHelper = new ContactMessageHelper(wd);
   registrationHelper = new RegistrationHelper(wd);

  }

  public void openSite() {
    wd.get("http://automationpractice.com/index.php");
  }

  public boolean isElementPresent(By locator) {
   if (wd.findElements(locator).size()>0)
     return true;
   return false;
  }

  public void stop() throws InterruptedException {
    Thread.sleep(1000);
    wd.quit();
  }


}
