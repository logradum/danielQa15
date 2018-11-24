import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase{
  WebDriver wd;

  @BeforeClass
  public void setUp(){
    wd = new ChromeDriver();
  }
  @AfterClass
  public void tearDown() throws InterruptedException {
    Thread.sleep(3000);
  }
}
