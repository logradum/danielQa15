package Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;

public class AppManager {

  private String browser;

  public AppManager(String browser) {
    this.browser = browser;
  }

  CartHelper cartHelper;
  RegistrationHelper registrationHelper;
  ContactMessageHelper contactMessageHelper;
  public WebDriver wd;


  public ContactMessageHelper getContactMessageHelper() {
    return contactMessageHelper;
  }

  public RegistrationHelper getRegistrationHelper() {
    return registrationHelper;
  }

  public CartHelper getCartHelper() {
    return cartHelper;
  }


  public void start(){
    //creating flexible browser type
    if (browser.equals(BrowserType.CHROME)){ wd = new ChromeDriver();}
    else if (browser.equals(BrowserType.FIREFOX)){ wd = new FirefoxDriver();}
    else if (browser.equals(BrowserType.SAFARI)){ wd = new SafariDriver();}


   wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   contactMessageHelper = new ContactMessageHelper(wd);
   registrationHelper = new RegistrationHelper(wd);
   cartHelper = new CartHelper(wd);

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
