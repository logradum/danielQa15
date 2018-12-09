package Manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CartHelper extends HelperBase {


  public CartHelper(WebDriver wd) {
    this.wd = wd;
  }

  //Capabilities for getting browser Info
  Capabilities cap;

  public int getIntFromStringElementByLocator(By locator) {
    int number = 0;
    goToShoppingCardFromMain();
    if (isElementPresent(locator)){
      WebElement productInCart = wd.findElement(locator);
      String cartString = productInCart.getText();
      System.out.println(productInCart.getText());
      number = Integer.parseInt(cartString.replaceAll("[\\D]", ""));
    }
    goToMainByLogo();
    return number;
  }

  public void clickContinueButtonFromAddingToCardForm(By locator) {
      click(locator);
  }


  public void chooseProductFromMainPage(String locator) throws InterruptedException {
    Integer i = getCountOfProduct(locator);
    Integer r = (getRandomNumberNotLessThanOne(i));

    Actions mouse = new Actions(wd);
    WebElement product = wd.findElement(By.xpath(getRandomProduct(locator, r)));
    WebElement addToCardButton = wd
            .findElement(By.xpath(getRandomAddToCardButton(r)));
    Thread.sleep(1000);

    cap = ((RemoteWebDriver) wd).getCapabilities();
    if (cap.getBrowserName().equalsIgnoreCase("FIREFOX")) {
      ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", product);
      mouse.moveToElement(product).pause(1000).click(addToCardButton).release().perform();
      Thread.sleep(1000);
    } else {mouse.moveToElement(product).pause(1000).click(addToCardButton).release().perform();}
  }

  public String getRandomAddToCardButton(int r) {
    return "(//span[contains(text(),'Add to cart')])" + "[" + r + "]";
  }

  public int getCountOfProduct(String locator) {
    return wd.findElements(By.xpath(locator)).size();
  }

  public String getRandomProduct(String locator, int r) {
    return locator + "[" + r + "]";
  }

}
