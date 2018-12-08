package Test;

import Manager.AppManager;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {


  static AppManager app = new AppManager();

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
