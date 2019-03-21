import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

@Test
public class Droppable extends TestBase {
  public void testDroppable(){
    wd.get("http://localhost/com.routePerfect.tests/drop.html");
    WebElement box = wd.findElement(By.cssSelector("#draggable"));
    WebElement target = wd.findElement(By.xpath("//div[@id='droppable']"));

    new Actions(wd).clickAndHold(box).
            pause(3000).
            moveToElement(target).
            release().
            perform();
  }
}
