import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Draggable extends TestBase {

  @Test
  public void testDraggable(){
    wd.get("http://localhost/tests/drag.html");
    WebElement box = wd.findElement(By.cssSelector("#draggable"));

    new Actions(wd).moveToElement(box).
            clickAndHold().
            moveByOffset(200,200).
            moveByOffset(100,-100).
            release().
            pause(3000).
            perform();


  }
}
