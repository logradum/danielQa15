package Test;

import Manager.AppManager;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

 protected static AppManager app = new AppManager(System.getProperty("browser",
          BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp(){
    app.start();
    app.openSite();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws InterruptedException {
    app.stop();
  }

}
