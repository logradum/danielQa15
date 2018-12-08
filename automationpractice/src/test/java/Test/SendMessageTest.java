package Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMessageTest extends TestBase{

  @Test
  public void testMessageForm() throws InterruptedException {
    app.getContactMessageHelper().fillContactMessageForm();

    Assert.assertEquals(true, app.isElementPresent(By.xpath("//p[@class='alert alert-success']")));
  }


}
