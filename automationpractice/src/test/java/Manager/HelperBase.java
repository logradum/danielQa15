package Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {

  public WebDriver wd;

  public void click(By locator) {
    wd.findElement(locator).click();
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


  public int getRandomNumber(int i) {
    return (int) (Math.random() * i - 1);
  }
}
