package Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {

  public WebDriver wd;

  public void click(By locator) {
    if (isElementPresent(locator)) {
      wd.findElement(locator).click();
    } else {
      System.out.println("No such element to click ----------------->" + locator.toString());
    }

  }

  public void type(By locator, String s) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(s);
  }

  public void attachFile(By locator, String path) {
    WebElement uppload = wd.findElement(locator);
    uppload.sendKeys(path);
  }

  public void select(By locator, String text) {
    WebElement element = wd.findElement(locator);
    Select select = new Select(element);
    select.selectByVisibleText(text);
  }

  public void goToMainByLogo() {
    click(By.xpath("//img[@class='logo img-responsive']"));
  }

  public void goToShoppingCardFromMain() {
    click(By.xpath("//a[@title='View my shopping cart']"));
  }


  public int getRandomNumberNotLessThanOne(int i) {
    int random = ((int) (Math.random() * i - 1));
    if (random > 0) return random;
    return 1;
  }

  public boolean isElementPresent(By locator) {
    return (wd.findElements(locator).size() > 0 ? true : false);
  }
}
