import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  protected static AppManager fw = new AppManager();

  @BeforeSuite
  public void setUp(){
    fw.start();
  }


  @AfterSuite(alwaysRun = true)
  public void teatDown() throws InterruptedException {
    fw.stop();
  }


}
